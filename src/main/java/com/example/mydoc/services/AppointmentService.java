package com.example.mydoc.services;

import com.example.mydoc.models.dto.AppointmentDTO;
import com.example.mydoc.models.entities.Doctor;

public interface AppointmentService {

    void seedAppointment(AppointmentDTO appointmentDTO, Doctor doctor);
}
