package com.example.coronapatients.controller;

import com.example.coronapatients.model.Patient;
import com.example.coronapatients.model.PatientStatus;
import com.example.coronapatients.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/corona/patient")
@RestController
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @GetMapping(path = "all")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping(path = "{caseId}")
    public Patient getPatientById(@PathVariable("caseId") UUID caseId) {
        return patientService.getPatientById(caseId)
                .orElse(null);
    }

    @GetMapping(path = "negative")
    public List<Patient> getAllNegativeStatusPatients() {
        return patientService.getAllNegativeStatusPatients();
    }

    @GetMapping(path = "positive")
    public List<Patient> getAllPositiveStatusPatients() {
        return patientService.getAllPositiveStatusPatients();
    }

    @DeleteMapping(path = "{caseId}")
    public void removePatientById(@PathVariable("caseId") UUID caseId) {
        patientService.removePatientById(caseId);
    }

    @DeleteMapping(path = "negative")
    public void removeAllNegativeStatusPatients() {
        patientService.removeAllNegativeStatusPatients();
    }

    @PutMapping(path = "{caseId}")
    public void updatePatientDetailById(@PathVariable("caseId") UUID caseId, @RequestBody Patient newDetail) {
        patientService.updatePatientDetailById(caseId, newDetail);
    }

}
