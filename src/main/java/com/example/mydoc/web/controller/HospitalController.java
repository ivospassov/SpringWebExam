package com.example.mydoc.web.controller;

import com.example.mydoc.models.entities.Hospital;
import com.example.mydoc.repositories.HospitalRepository;
import com.example.mydoc.services.HospitalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HospitalController {

    private final HospitalService hospitalService;
    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalService hospitalService,
                              HospitalRepository hospitalRepository) {
        this.hospitalService = hospitalService;
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/hospitals/{id}")
    public String renderHospitalById(@PathVariable("id") Long id, ModelMap modelMap) {
        Hospital hospital = hospitalService.findById(id);

        modelMap.addAttribute("hospitalName", hospital.getName());
        modelMap.addAttribute("hospitalImage", hospital.getImage());
        return "/hospital";
    }
}
