package com.example.coronapatients.dao;

import com.example.coronapatients.model.Patient;
import com.example.coronapatients.model.PatientStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository("coronaPatientDao")
public class PatientDaoImpl implements PatientDao {

    // Since we aren't using a database, so we will store the Patient details in an ArrayList
    private static List<Patient> coronaPatients = new ArrayList<>();

    @Override
    public int addPatient(UUID caseId, Patient patient) {
        coronaPatients.add(new Patient(caseId, patient.getName(), patient.getGender(), PatientStatus.SUSPECT));
        return 1;
    }

    @Override
    public List<Patient> getAllPatients() {
        return coronaPatients;
    }

    @Override
    public Optional<Patient> getPatientById(UUID caseId) {
        return coronaPatients.stream()
                .filter(patient -> patient.getCaseId().equals(caseId))
                .findFirst();
    }

    @Override
    public List<Patient> getAllNegativeStatusPatients() {
        return coronaPatients.stream()
                .filter(patient -> patient.getPatientStatus().equals(PatientStatus.NEGATIVE))
                .collect(Collectors.toList());
    }

    @Override
    public List<Patient> getAllPositiveStatusPatients() {
        return coronaPatients.stream()
                .filter(patient -> patient.getPatientStatus().equals(PatientStatus.POSITIVE))
                .collect(Collectors.toList());
    }

    @Override
    public int removePatientById(UUID caseId) {
        Optional<Patient> patient = getPatientById(caseId);
        if (patient.isEmpty()) {
            return 0;
        }
        coronaPatients.remove(patient.get());
        return 1;
    }

    @Override
    public int removeAllNegativeStatusPatients() {
        List<Patient> negativeTestedPatients = getAllNegativeStatusPatients();
        if (negativeTestedPatients.isEmpty()) {
            return 0;
        }
        coronaPatients.removeAll(negativeTestedPatients);
        return 1;
    }

    @Override
    public int updatePatientDetailById(UUID caseId, Patient newDetail) {
        return getPatientById(caseId)
                .map(patient -> {
                    int indexOfPatientToUpdate = coronaPatients.indexOf(patient);
                    if (indexOfPatientToUpdate >= 0) {
                        coronaPatients.set(indexOfPatientToUpdate,
                                new Patient(caseId, newDetail.getName(), newDetail.getGender(), newDetail.getPatientStatus()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
