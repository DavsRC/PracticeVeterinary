package src.Appointments.operations;

import src.Appointments.Appointment;
import src.Patient.Patient;

import java.util.List;

public interface IAppointmentOperation {

    public Appointment saveAppointment(List<Patient> patientList);
}
