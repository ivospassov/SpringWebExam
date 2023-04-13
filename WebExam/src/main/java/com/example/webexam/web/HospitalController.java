package com.example.webexam.web;

import com.example.webexam.model.entity.Hospital;
import com.example.webexam.service.contracts.HospitalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/hospitals/{id}")
    public String renderHospitalById(@PathVariable("id") Long id, ModelMap modelMap) {
        Hospital hospital = hospitalService.findById(id);

        modelMap.addAttribute("hospitalId", hospital.getId());
        modelMap.addAttribute("hospitalName", hospital.getName());
        modelMap.addAttribute("hospitalImage", hospital.getImage());
        return "/hospital";
    }
}
