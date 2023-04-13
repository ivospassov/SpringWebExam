package com.example.webexam.web;

import com.example.webexam.model.entity.Doctor;
import com.example.webexam.model.entity.Hospital;
import com.example.webexam.service.contracts.DoctorService;
import com.example.webexam.service.contracts.HospitalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DoctorController {

    private final HospitalService hospitalService;
    private final DoctorService doctorService;

    public DoctorController(HospitalService hospitalService, DoctorService doctorService) {
        this.hospitalService = hospitalService;
        this.doctorService = doctorService;
    }

    @GetMapping("/hospital/{id}")
    public String handleGetDoctorsButtonByHospitalId(@PathVariable Long id, RedirectAttributes redirectAttributes) {

        Hospital hospital = this.hospitalService.findById(id);
        List<Doctor> doctors = this.doctorService.findDoctorsByHospital(hospital);

        redirectAttributes.addFlashAttribute("doctors", doctors);

        //TODO: try to redirect with path variable(required = false) with the Hospital name
        return "/doctors";
    }

//    @GetMapping("/doctors")
//    public String renderAllDoctors(ModelMap modelMap) {
//        List<Doctor> allDoctors = this.doctorService.findAllDoctors();
//        modelMap.addAttribute("doctors", allDoctors);
//
//        return "/doctors";
//    }
}
