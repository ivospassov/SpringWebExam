package com.example.mydoc.services.impl;

import com.example.mydoc.models.dto.AppointmentDTO;
import com.example.mydoc.models.entities.Appointment;
import com.example.mydoc.models.entities.Doctor;
import com.example.mydoc.models.entities.User;
import com.example.mydoc.repositories.AppointmentRepository;
import com.example.mydoc.repositories.DoctorRepository;
import com.example.mydoc.services.AppointmentService;
import com.example.mydoc.services.UserService;
import com.example.mydoc.web.session.UserLoginSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    private final UserService userService;
    private final ModelMapper modelMapper;

    private final UserLoginSession userLoginSession;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, UserService userService, ModelMapper modelMapper, UserLoginSession userLoginSession) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.userLoginSession = userLoginSession;
    }

    @Override
    public void seedAppointment(AppointmentDTO appointmentDTO, Doctor doctor) {
        Appointment appointment = this.modelMapper.map(appointmentDTO, Appointment.class);

        doctor.getAppointments().add(appointment);
        appointment.setDoctor(doctor);
        appointment.setPatient(retrieveUserById());
        appointment.setStatus("Going");

        this.doctorRepository.save(doctor);
    }

    @Override
    public List<Appointment> getByPatientId() {
        return this.appointmentRepository.findAllByPatientId(this.userLoginSession.getId());
    }

    @Override
    public void cancel(Long id) {
        Appointment appointmentToCancel = this.appointmentRepository.findById(id).get();
        appointmentToCancel.setStatus("Cancelled");
        this.appointmentRepository.save(appointmentToCancel);
    }

    private User retrieveUserById() {
        Long userId = this.userLoginSession.getId();
        return this.userService.retrieveById(userId);
    }
}
