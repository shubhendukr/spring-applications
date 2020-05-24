package com.example.coronapatients.service;

import com.example.coronapatients.dao.PatientDao;
import com.example.coronapatients.model.Patient;
import com.example.coronapatients.model.PatientStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientDao patientDao;

    @Autowired
    public PatientService(@Qualifier("coronaPatientDao") PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public int addPatient(Patient patient) {
        return patientDao.addPatient(patient);
    }

    public List<Patient> getAllPatients() {
        return patientDao.getAllPatients();
    }

    public Optional<Patient> getPatientById(UUID caseId) {
        return patientDao.getPatientById(caseId);
    }

    public List<Patient> getAllNegativeStatusPatients() {
        return patientDao.getAllNegativeStatusPatients();
    }

    public List<Patient> getAllPositiveStatusPatients() {
        return patientDao.getAllPositiveStatusPatients();
    }

    public int removePatientById(UUID caseId) {
        return patientDao.removePatientById(caseId);
    }

    public int removeAllNegativeStatusPatients() {
        return patientDao.removeAllNegativeStatusPatients();
    }

    public int updatePatientDetailById(UUID caseId, Patient newDetail) {
        return patientDao.updatePatientDetailById(caseId, newDetail);
    }
}
