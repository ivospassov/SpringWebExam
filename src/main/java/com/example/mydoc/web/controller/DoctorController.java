package com.example.mydoc.web.controller;

import com.example.mydoc.models.entities.Doctor;
import com.example.mydoc.models.entities.Hospital;
import com.example.mydoc.services.DoctorService;
import com.example.mydoc.services.HospitalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String handleGetDoctorsButtonByHospitalId(@PathVariable Long id) {

        //Es ist möglich, die ID-Anforderung später zu entfernen
        Hospital hospital = this.hospitalService.findById(id);

        //TODO: try to redirect with path variable(required = false) with the Hospital name
        return "redirect:/doctors";
    }

    @GetMapping("/doctors")
    public String renderAllDoctors(ModelMap modelMap) {
        List<Doctor> allDoctors = this.doctorService.findAllDoctors();
        modelMap.addAttribute("doctors", allDoctors);

        return "/doctors";
    }
}
