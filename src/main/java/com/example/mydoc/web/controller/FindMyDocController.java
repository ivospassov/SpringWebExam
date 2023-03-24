package com.example.mydoc.web.controller;

import com.example.mydoc.models.entities.Doctor;
import com.example.mydoc.models.entities.Hospital;
import com.example.mydoc.models.dto.MyDocDTO;
import com.example.mydoc.models.enums.CitiesName;
import com.example.mydoc.models.enums.SpecialtyType;
import com.example.mydoc.services.DoctorService;
import com.example.mydoc.services.HospitalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class FindMyDocController {

    private final DoctorService doctorService;
    private final HospitalService hospitalService;

    public FindMyDocController(DoctorService doctorService, HospitalService hospitalService) {
        this.doctorService = doctorService;
        this.hospitalService = hospitalService;
    }

    @ModelAttribute("myDocDTO")
    public MyDocDTO myDocDTO() {
        return new MyDocDTO();
    }

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @PostMapping("/find-mydoc")
    public String handleFindMyDocForm(MyDocDTO myDocDTO, ModelMap modelMap) {

        Optional<Hospital> optionalHospital = hospitalService.findByName(myDocDTO.getHospital());
        boolean isHospitalFieldNotEmpty = myDocDTO.getHospital().length() != 0;

        //Finding a particular hospital is a priority over the other filters
        if (optionalHospital.isEmpty() && isHospitalFieldNotEmpty) {
            return "/404Page";
        } else if (optionalHospital.isPresent() && isHospitalFieldNotEmpty) {
            return "redirect:/hospitals/" + optionalHospital.get().getId();
        } else if (myDocDTO.getLocation() != null && myDocDTO.getSpecialty() != null) {

            SpecialtyType specialty = myDocDTO.getSpecialty();
            String location = myDocDTO.getLocation().name();

            List<Doctor> filteredDoctorsByCityAndSpecialty = this.doctorService.findByCityNameAndSpecialtyName(location, specialty);
            modelMap.addAttribute("doctors", filteredDoctorsByCityAndSpecialty);
            return "/doctors";
        }
        return "redirect:/";
    }
}
