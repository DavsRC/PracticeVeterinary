package src.operations;

import src.Patient.Patient;

import java.util.List;

public interface IPatientOperations {

    public Patient savePatient();
    public void getPatients(List<Patient> patientList);
}
