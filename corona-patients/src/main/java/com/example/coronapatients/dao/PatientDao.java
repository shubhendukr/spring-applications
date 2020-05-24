package com.example.coronapatients.dao;

import com.example.coronapatients.model.Patient;
import com.example.coronapatients.model.PatientStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientDao {

    // to add a new patient case to our list of patients
    int addPatient(UUID caseId, Patient patient);

    // default method to add a new patient case
    default int addPatient(Patient patient) {
        UUID caseId = UUID.randomUUID();
        return addPatient(caseId, patient);
    }

    // gets all the list of all the patients with their details
    List<Patient> getAllPatients();

    // gets the patient detail by their caseId
    Optional<Patient> getPatientById(UUID caseId);

    // gets the list of patients who have been tested NEGATIVE
    List<Patient> getAllNegativeStatusPatients();

    // gets all the patients who have been tested POSITIVE
    List<Patient> getAllPositiveStatusPatients();

    // removes a patient from the list by the caseId
    int removePatientById(UUID caseId);

    // removes all the patients from the list who have been tested NEGATIVE
    int removeAllNegativeStatusPatients();

    // updates a patient's detail by their caseId
    int updatePatientDetailById(UUID caseId, Patient newDetail);
}
