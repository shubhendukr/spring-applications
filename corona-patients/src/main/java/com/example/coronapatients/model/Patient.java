package com.example.coronapatients.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;
import java.util.UUID;

public class Patient {

    private final UUID caseId;

    @NonNull
    private final String name;

    private final Character gender;

    @NonNull
    private final PatientStatus patientStatus;

    public Patient(@JsonProperty("caseId") UUID caseId,
                   @JsonProperty("name") @NonNull String name,
                   @JsonProperty("gender") Character gender,
                   @JsonProperty("patientStatus") @NonNull PatientStatus patientStatus) {
        this.caseId = caseId;
        this.name = name;
        this.gender = gender;
        this.patientStatus = patientStatus;
    }

    public UUID getCaseId() {
        return caseId;
    }

    public String getName() {
        return name;
    }

    public Character getGender() {
        return gender;
    }

    public PatientStatus getPatientStatus() {
        return patientStatus;
    }
}
