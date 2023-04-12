package com.example.webexam.web;

import com.example.webexam.model.dtos.MyDocDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class FindMyDocController {

//    private final DoctorService doctorService;
//    private final HospitalService hospitalService;
//
//    public FindMyDocController(DoctorService doctorService, HospitalService hospitalService) {
//        this.doctorService = doctorService;
//        this.hospitalService = hospitalService;
//    }
//
    @ModelAttribute("myDocDTO")
    public MyDocDTO myDocDTO() {
        return new MyDocDTO();
    }

    @GetMapping("/find-my-doc")
    public String showIndex() {
        return "my-doc";
    }

//    @PostMapping("/find-mydoc")
//    public String handleFindMyDocForm(MyDocDTO myDocDTO, ModelMap modelMap) {
//
//        Optional<Hospital> optionalHospital = hospitalService.findByName(myDocDTO.getHospital());
//        boolean isHospitalFieldNotEmpty = myDocDTO.getHospital().length() != 0;
//
//        //Finding a particular hospital is a priority over the other filters
//        if (optionalHospital.isEmpty() && isHospitalFieldNotEmpty) {
//            return "redirect:/404";
//        } else if (optionalHospital.isPresent() && isHospitalFieldNotEmpty) {
//            return "redirect:/hospitals/" + optionalHospital.get().getId();
//        } else if (myDocDTO.getLocation() != null && myDocDTO.getSpecialty() != null) {
//
//            SpecialtyType specialty = myDocDTO.getSpecialty();
//            String location = myDocDTO.getLocation().name();
//
//            List<Doctor> filteredDoctorsByCityAndSpecialty = this.doctorService.findByCityNameAndSpecialtyName(location, specialty);
//            modelMap.addAttribute("doctors", filteredDoctorsByCityAndSpecialty);
//            return "/doctors";
//        }
//        return "redirect:/find-mydoc";
//    }
//
//    @GetMapping("/404")
//    public String errorNotFound() {
//        return "/404Page";
//    }
}
