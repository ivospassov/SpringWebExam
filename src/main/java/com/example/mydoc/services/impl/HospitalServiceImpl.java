package com.example.mydoc.services.impl;

import com.example.mydoc.models.entities.Hospital;
import com.example.mydoc.models.enums.HospitalsName;
import com.example.mydoc.repositories.HospitalRepository;
import com.example.mydoc.services.CityService;
import com.example.mydoc.services.HospitalService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HospitalServiceImpl implements HospitalService {
    private static final String HOPE_URL = "https://upload.wikimedia.org/wikipedia/commons/e/eb/Hope_Building%2C_Salford_Royal_Hospital_-_geograph.org.uk_-_2586383.jpg";
    private static final String ISUL_URL = "https://trud.bg/public/images/articles/2020-11/%D1%83%D0%BC%D0%B1%D0%B0%D0%BB_%D1%86%D0%B0%D1%80%D0%B8%D1%86%D0%B0_%D0%B9%D0%BE%D0%B0%D0%BD%D0%B0_-_%D0%B8%D1%81%D1%83%D0%BB_3556714952462417095_big.jpg";
    private static final String TOKUDA_URL = "https://acibademcityclinic.bg/images/librariesprovider2/tokuda-outsde/tokuda_outside-(1)ca9abea4acd54194b7831efd4f457ff1.jpeg?sfvrsn=784fffc1_9";
    private static final String NADEZHDA_URL = "https://pbs.twimg.com/media/EOYyqskW4AActyz.jpg"; //OR https://nadezhdahospital.com/wp-content/uploads/2021/09/Screenshot-2021-09-16-at-19.35.23-1024x692.png
    private static final String SOFIAMED_URL = "https://hospitalsofiamed.bg/images/theme/sofmed.jpg";
    private static final String ALEKSANDROVSKA_URL = "https://glasnews.bg/news/2021/07/07/aleksandrovska-bolnitsa-veche-e-novo-926.jpg";
    private static final String SERDIKA_URL = "https://serdika.com/wp-content/uploads/2019/06/%D0%A1%D0%B3%D1%80%D0%B0%D0%B4%D0%B0_.jpg";
    private static final String MAYO_URL = "https://images.unsplash.com/photo-1596541223130-5d31a73fb6c6?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8bWF5byUyMGNsaW5pY3xlbnwwfHwwfHw%3D&w=1000&q=80";

    private final HospitalRepository hospitalRepository;
    private final CityService cityService;

    public HospitalServiceImpl(HospitalRepository hospitalRepository, CityService cityService) {
        this.hospitalRepository = hospitalRepository;
        this.cityService = cityService;
    }

    @Override
    public boolean isHospitalListEmpty() {
        return this.hospitalRepository.count() <= 0;
    }

    @Override
    public void seedHospitals() {

        if (isHospitalListEmpty()) {
            Hospital isul = new Hospital(HospitalsName.Isul.name(), cityService.findByCityId(1L));
            Hospital tokuda = new Hospital(HospitalsName.Tokuda.name(), cityService.findByCityId(2L));
            Hospital nadezhda = new Hospital(HospitalsName.Nadezhda.name(), cityService.findByCityId(3L));
            Hospital hope = new Hospital(HospitalsName.Hope.name(), cityService.findByCityId(4L));
            Hospital sofiamed = new Hospital(HospitalsName.SofiaMed.name(), cityService.findByCityId(1L));
            Hospital mayo = new Hospital(HospitalsName.Mayo.name(), cityService.findByCityId(5L));
            Hospital aleksandrovska = new Hospital(HospitalsName.Aleksandrovska.name(), cityService.findByCityId(2L));
            Hospital serdika = new Hospital(HospitalsName.Serdika.name(), cityService.findByCityId(3L));

            List<Hospital> hospitals = new ArrayList<>(List.of(isul, tokuda, nadezhda, hope, sofiamed, mayo, aleksandrovska, serdika));
            List<Hospital> modifiedHospitals = hospitals.stream().map(this::setImageUrl).toList();
            this.hospitalRepository.saveAll(modifiedHospitals);
        }
    }

    private Hospital setImageUrl(Hospital hospital) {

        switch (hospital.getName().toLowerCase()) {
            case "sofiamed" -> hospital.setImage(SOFIAMED_URL);
            case "mayo" -> hospital.setImage(MAYO_URL);
            case "aleksandrovska" -> hospital.setImage(ALEKSANDROVSKA_URL);
            case "serdika" -> hospital.setImage(SERDIKA_URL);
            case "tokuda" -> hospital.setImage(TOKUDA_URL);
            case "isul" -> hospital.setImage(ISUL_URL);
            case "nadezhda" -> hospital.setImage(NADEZHDA_URL);
            case "hope" -> hospital.setImage(HOPE_URL);
        }

        return hospital;
    }

    @Override
    public Hospital findById(Long id) {
        return this.hospitalRepository.findById(id).get();
    }

    @Override
    public Optional<Hospital> findByName(String name) {
        return this.hospitalRepository.findByName(name);
    }

    @Override
    public List<Hospital> findAllHospitals() {
        return this.hospitalRepository.findAll();
    }

    @Override
    public List<Hospital> findByCity(String cityName) {
        return this.hospitalRepository.findByCityName(cityName);
    }
}
