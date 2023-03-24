package com.example.mydoc.services;

import com.example.mydoc.models.dto.AppointmentDTO;
import com.example.mydoc.models.entities.Appointment;
import com.example.mydoc.models.entities.Doctor;

import java.util.List;

public interface AppointmentService {

    void seedAppointment(AppointmentDTO appointmentDTO, Doctor doctor);

    List<Appointment> getByPatientId();

    void cancel(Long id);
}
