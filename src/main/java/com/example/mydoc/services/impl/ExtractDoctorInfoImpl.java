package com.example.mydoc.services.impl;

import com.example.mydoc.models.entities.City;
import com.example.mydoc.models.entities.Doctor;
import com.example.mydoc.models.entities.Hospital;
import com.example.mydoc.models.entities.Specialty;
import com.example.mydoc.models.enums.DoctorBiography;
import com.example.mydoc.models.enums.DoctorImageURL;
import com.example.mydoc.services.CityService;
import com.example.mydoc.services.ExtractDoctorInfo;
import com.example.mydoc.services.HospitalService;
import com.example.mydoc.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ExtractDoctorInfoImpl implements ExtractDoctorInfo {

    private final SpecialtyService specialtyService;
    private final CityService cityService;
    private final HospitalService hospitalService;


    public ExtractDoctorInfoImpl(SpecialtyService specialtyService, CityService cityService, HospitalService hospitalService) {
        this.specialtyService = specialtyService;
        this.cityService = cityService;
        this.hospitalService = hospitalService;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        List<Specialty> specialties = this.specialtyService.findAll();
        List<Hospital> hospitalsInSofia = this.hospitalService.findByCity("Sofia");
        List<Hospital> hospitalsInPlovdiv = this.hospitalService.findByCity("Plovdiv");
        List<Hospital> hospitalsInBourgas = this.hospitalService.findByCity("Bourgas");
        List<Hospital> hospitalsInPleven = this.hospitalService.findByCity("Pleven");
        List<Hospital> hospitalsInBlagoevgrad = this.hospitalService.findByCity("Blagoevgrad");
        City sofiaCity = this.cityService.findByCityId(1L);
        City plovdivCity = this.cityService.findByCityId(2L);
        City bourgasCity = this.cityService.findByCityId(3L);
        City plevenCity = this.cityService.findByCityId(4L);
        City blagoevgradCity = this.cityService.findByCityId(5L);
        Random random = new Random();

        List<Doctor> doctors = new ArrayList<>(List.of(
                new Doctor("Michaelis", "Masturbakis", 29,
                        specialties.get(0), DoctorBiography.IMMUNOLOGY_MASTURBAKIS.getBiographyText(), "mmasturbakis@mydoc.com",
                        sofiaCity, hospitalsInSofia.get(random.nextInt(0, hospitalsInSofia.size())), DoctorImageURL.MASTURBAKIS_URL.getImageUrl()),
                new Doctor("Johnny", "Sins", 32,
                        specialties.get(1), DoctorBiography.ANESTHESIOLOGY_SINS.getBiographyText(), "jsins@mydoc.com",
                        sofiaCity, hospitalsInSofia.get(random.nextInt(0, hospitalsInSofia.size())), DoctorImageURL.SINS_URL.getImageUrl()),
                new Doctor("Bustin", "Jieber", 48,
                        specialties.get(2), DoctorBiography.DERMATOLOGY_JIEBER.getBiographyText(), "bjieber@mydoc.com",
                        sofiaCity, hospitalsInSofia.get(random.nextInt(0, hospitalsInSofia.size())), DoctorImageURL.JIEBER_URL.getImageUrl()),

                new Doctor("Michaelis", "Avantakis", 29,
                        specialties.get(3), DoctorBiography.RADIOLOGY_AVANTAKIS.getBiographyText(), "mavantakis@mydoc.com",
                        plovdivCity, hospitalsInPlovdiv.get(random.nextInt(0, hospitalsInPlovdiv.size())), DoctorImageURL.AVANTAKIS_URL.getImageUrl()),
                new Doctor("Horhe", "Rodriguez", 32,
                        specialties.get(4), DoctorBiography.OPHTHALMOLOGY_RODRIGUEZ.getBiographyText(), "hrodriguez@mydoc.com",
                        plovdivCity, hospitalsInPlovdiv.get(random.nextInt(0, hospitalsInPlovdiv.size())), DoctorImageURL.RODRIGUEZ_URL.getImageUrl()),
                new Doctor("Malte", "Minnerup", 48,
                        specialties.get(5), DoctorBiography.PEDIATRICS_MINNERUP.getBiographyText(), "mminnerup@mydoc.com",
                        plovdivCity, hospitalsInPlovdiv.get(random.nextInt(0, hospitalsInPlovdiv.size())), DoctorImageURL.MINNERUP_URL.getImageUrl()),

                new Doctor("Michaelis", "Psomitakis", 29,
                        specialties.get(6), DoctorBiography.REHABILITATION_PSOMITAKIS.getBiographyText(), "mpsomitakis@mydoc.com",
                        bourgasCity, hospitalsInBourgas.get(random.nextInt(0, hospitalsInBourgas.size())), DoctorImageURL.PSOMITAKIS_URL.getImageUrl()),
                new Doctor("Harry", "Timber", 32,
                        specialties.get(7), DoctorBiography.PSYCHIATRY_TIMBER.getBiographyText(), "htimber@mydoc.com",
                        bourgasCity, hospitalsInBourgas.get(random.nextInt(0, hospitalsInBourgas.size())), DoctorImageURL.TIMBER_URL.getImageUrl()),
                new Doctor("Billie", "Kimber", 48,
                        specialties.get(8), DoctorBiography.ONCOLOGY_KIMBER.getBiographyText(), "bkimber@mydoc.com",
                        bourgasCity, hospitalsInBourgas.get(random.nextInt(0, hospitalsInBourgas.size())), DoctorImageURL.KIMBER_URL.getImageUrl()),

                new Doctor("Daniel", "Makler", 29,
                        specialties.get(9), DoctorBiography.UROLOGY_MAKLER.getBiographyText(), "dmakler@mydoc.com",
                        plevenCity, hospitalsInPleven.get(random.nextInt(0, hospitalsInPleven.size())), DoctorImageURL.MAKLER_URL.getImageUrl()),
                new Doctor("Maria", "Hristova", 32,
                        specialties.get(0), DoctorBiography.IMMUNOLOGY_HRISTOVA.getBiographyText(), "msalvator@mydoc.com",
                        plevenCity, hospitalsInPleven.get(random.nextInt(0, hospitalsInPleven.size())), DoctorImageURL.I_HRISTOVA_URL.getImageUrl()),
                new Doctor("Gergana", "Hristova", 48,
                        specialties.get(1), DoctorBiography.ANESTHESIOLOGY_HRISTOVA.getBiographyText(), "ghristova@mydoc.com",
                        plevenCity, hospitalsInPleven.get(random.nextInt(0, hospitalsInPleven.size())), DoctorImageURL.A_HRISTOVA_URL.getImageUrl()),

                new Doctor("Aleksandra", "Georgieva", 29,
                        specialties.get(2), DoctorBiography.DERMATOLOGY_GEORGIEVA.getBiographyText(), "ageorgieva@mydoc.com",
                        blagoevgradCity, hospitalsInBlagoevgrad.get(random.nextInt(0, hospitalsInBlagoevgrad.size())), DoctorImageURL.D_GEORGIEVA_URL.getImageUrl()),
                new Doctor("Daniela", "Stamenova", 32,
                        specialties.get(3), DoctorBiography.RADIOLOGY_AVANTAKIS.getBiographyText(), "dstamenova@mydoc.com",
                        blagoevgradCity, hospitalsInBlagoevgrad.get(random.nextInt(0, hospitalsInBlagoevgrad.size())), DoctorImageURL.STAMENOVA_URL.getImageUrl()),
                new Doctor("Hristina", "Ivanova", 48,
                        specialties.get(4), DoctorBiography.OPHTHALMOLOGY_IVANOVA.getBiographyText(), "hivanova@mydoc.com",
                        blagoevgradCity, hospitalsInBlagoevgrad.get(random.nextInt(0, hospitalsInBlagoevgrad.size())), DoctorImageURL.IVANOVA_URL.getImageUrl()),

                new Doctor("Ivan", "Milev", 29,
                        specialties.get(5), DoctorBiography.PEDIATRICS_MILEV.getBiographyText(), "imilev@mydoc.com",
                        sofiaCity, hospitalsInSofia.get(random.nextInt(0, hospitalsInSofia.size())), DoctorImageURL.MILEV_URL.getImageUrl()),
                new Doctor("Yvonne", "Hristova", 32,
                        specialties.get(6), DoctorBiography.REHABILITATION_HRISTOVA.getBiographyText(), "yhristova@mydoc.com",
                        sofiaCity, hospitalsInSofia.get(random.nextInt(0, hospitalsInSofia.size())), DoctorImageURL.A_HRISTOVA_URL.getImageUrl()),
                new Doctor("Gabriela", "Dacheva", 48,
                        specialties.get(7), DoctorBiography.PSYCHIATRY_DACHEVA.getBiographyText(), "gdacheva@mydoc.com",
                        sofiaCity, hospitalsInSofia.get(random.nextInt(0, hospitalsInSofia.size())), DoctorImageURL.DACHEVA_URL.getImageUrl()),

                new Doctor("Teodora", "Naydenova", 29,
                        specialties.get(8), DoctorBiography.ONCOLOGY_NAYDENOVA.getBiographyText(), "tnaydenova@mydoc.com",
                        plovdivCity, hospitalsInPlovdiv.get(random.nextInt(0, hospitalsInPlovdiv.size())), DoctorImageURL.NAYDENOVA_URL.getImageUrl()),
                new Doctor("Stefan", "Stefanov", 32,
                        specialties.get(9), DoctorBiography.UROLOGY_STEFANOV.getBiographyText(), "sstefanov@mydoc.com",
                        plovdivCity, hospitalsInPlovdiv.get(random.nextInt(0, hospitalsInPlovdiv.size())), DoctorImageURL.STEFANOV_URL.getImageUrl()),
                new Doctor("Iva", "Bahchieva", 48,
                        specialties.get(0), DoctorBiography.IMMUNOLOGY_BAHCHIEVA.getBiographyText(), "ibahchieva@mydoc.com",
                        plovdivCity, hospitalsInPlovdiv.get(random.nextInt(0, hospitalsInPlovdiv.size())), DoctorImageURL.BAHCHIEVA_URL.getImageUrl()),

                new Doctor("Martina", "Baleva", 29,
                        specialties.get(1), DoctorBiography.ANESTHESIOLOGY_BALEVA.getBiographyText(), "mbaleva@mydoc.com",
                        bourgasCity, hospitalsInBourgas.get(random.nextInt(0, hospitalsInBourgas.size())), DoctorImageURL.BALEVA_URL.getImageUrl()),
                new Doctor("Daniel", "Hristov", 32,
                        specialties.get(2), DoctorBiography.DERMATOLOGY_HRISTOV.getBiographyText(), "dhristov@mydoc.com",
                        bourgasCity, hospitalsInBourgas.get(random.nextInt(0, hospitalsInBourgas.size())), DoctorImageURL.HRISTOV_URL.getImageUrl()),
                new Doctor("Paola", "Georgieva", 75,
                        specialties.get(3), DoctorBiography.RADIOLOGY_GEORGIEVA.getBiographyText(), "pgeorgieva@mydoc.com",
                        bourgasCity, hospitalsInBourgas.get(random.nextInt(0, hospitalsInBourgas.size())), DoctorImageURL.R_GEORGIEVA_URL.getImageUrl()),

                new Doctor("Pavlin", "Dazov", 29,
                        specialties.get(4), DoctorBiography.OPHTHALMOLOGY_DAZOV.getBiographyText(), "pdazov@mydoc.com",
                        plevenCity, hospitalsInPleven.get(random.nextInt(0, hospitalsInPleven.size())), DoctorImageURL.DAZOV_URL.getImageUrl()),
                new Doctor("Angel", "Ivanov", 32,
                        specialties.get(5), DoctorBiography.PEDIATRICS_IVANOV.getBiographyText(), "aivanov@mydoc.com",
                        plevenCity, hospitalsInPleven.get(random.nextInt(0, hospitalsInPleven.size())), DoctorImageURL.IVANOV_URL.getImageUrl()),
                new Doctor("Teodor", "Todorov", 48,
                        specialties.get(6), DoctorBiography.REHABILITATION_TODOROV.getBiographyText(), "ttodorov@mydoc.com",
                        plevenCity, hospitalsInPleven.get(random.nextInt(0, hospitalsInPleven.size())), DoctorImageURL.TODOROV_URL.getImageUrl()),

                new Doctor("Mina", "Harizanova", 29,
                        specialties.get(7), DoctorBiography.PSYCHIATRY_HARIZANOVA.getBiographyText(), "mharizanova@mydoc.com",
                        blagoevgradCity, hospitalsInBlagoevgrad.get(random.nextInt(0, hospitalsInBlagoevgrad.size())), DoctorImageURL.HARIZANOVA_URL.getImageUrl()),
                new Doctor("Sergey", "Stilyanov", 32,
                        specialties.get(8), DoctorBiography.ONCOLOGY_STILYANOV.getBiographyText(), "sstilyanov@mydoc.com",
                        blagoevgradCity, hospitalsInBlagoevgrad.get(random.nextInt(0, hospitalsInBlagoevgrad.size())), DoctorImageURL.STILYANOV_URL.getImageUrl()),
                new Doctor("Ivana", "Georgieva", 48,
                        specialties.get(9), DoctorBiography.UROLOGY_GEORGIEVA.getBiographyText(), "igeorgieva@mydoc.com",
                        blagoevgradCity, hospitalsInBlagoevgrad.get(random.nextInt(0, hospitalsInBlagoevgrad.size())), DoctorImageURL.U_GEORGIEVA_URL.getImageUrl())
        ));

        return doctors;
    }
}
