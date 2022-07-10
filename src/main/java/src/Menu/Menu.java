package src.Menu;
import src.Appointments.Appointment;
import src.Appointments.operations.AppointmentOperation;
import src.Patient.Patient;
import src.Patient.operations.PatientPatientOperations;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Menu {

private static Scanner in;
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;
    int option;
    Patient patient = new Patient();
    Appointment appointment = new Appointment();
    PatientPatientOperations patientOperations = new PatientPatientOperations();
    AppointmentOperation appointmentOperation = new AppointmentOperation();
    List<Patient> patientList = new ArrayList<>();

    public void showMenu(){
        while(!exit){
            System.out.println(" ___________..........___________" +
                    "\n" + "Sanipet - Veterinary care center" +
                    "\n" + "1. Register patient " +
                    "\n" + "2. Show patients" +
                    "\n" + "3. Appoinments" +
                    "\n" + "4. Billing" +
                    "\n" + "5. Medicine Stock" +
                    "\n" + "6. Exit" +
                    "");
            try{
                option = scanner.nextInt();
                switch (option){
                    case 1:
                        patient = patientOperations.savePatient();
                        patientList.add(patient);
                        break;
                    case 2:
                        patientOperations.getPatients(patientList);
                        break;
                    case 3:
                        appointment = appointmentOperation.saveAppointment(patientList);
                        break;
                    case 4:
                        System.out.println("Hola mundo 4");
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Please select a correct answer");
                }
            }catch (InputMismatchException exception){
                System.out.println("\nYou must enter a number");
                scanner.next();
            }
        }
    }
}
