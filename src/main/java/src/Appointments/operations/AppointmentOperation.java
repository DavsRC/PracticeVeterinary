package src.Appointments.operations;

import src.Appointments.ApointmentStatus;
import src.Appointments.Appointment;
import src.Appointments.Type;
import src.Patient.Patient;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class AppointmentOperation implements IAppointmentOperation{


    @Override
    public Appointment saveAppointment(List<Patient> patientList) {
        String clinicNumber;
        Appointment appointment = null;
        if (patientList.isEmpty()) {
            System.out.println("patent list empty");
        } else {
            // Building clinical number
            clinicNumber = buildingClinicalNumber(patientList);
            appointment = Appointment.builder()
                    .clinicNumber(clinicNumber)
                    .type(setAppointmentType())
                    .apointmentStatus(ApointmentStatus.NOT_STARTED)
                    .build();
        }
        System.out.println(appointment);
        return appointment;
    }

    private Type setAppointmentType() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        try{
            System.out.println("Select your appointment type");
            System.out.println("1. MEDICAL");
            System.out.println("2. SURGERY");
            System.out.println("3. AESTHETIC");
            if(scanner.hasNextInt()) {
                option = scanner.nextInt();
            } else {
                System.out.println("Please, select a correct number");
                scanner.next();
            }
        }catch (InputMismatchException exception){
            System.out.println("You have to introduce a number");
            scanner.next();
        }

        return validateAppointmentType(option);
    }

    private Type validateAppointmentType(int option) {
        switch (option){
            case 1:
               return Type.MEDICAL;
            case 2:
               return Type.SURGERY;
            case 3:
               return Type.AESTHETIC;
            default:
                System.out.println("Please select a correct answer");
        }
        return null;
    }

    private String buildingClinicalNumber(List<Patient> patientList){
        // variables
        Scanner scanner = new Scanner(System.in);
        String clinicalNumber = null;

        // get clinical patient list
        List<String> clinicalNumberLists = getClinicalPatientNumberList(patientList);

        // set clinical patient number
        try{
            do{
                System.out.println((" ___________..........___________"));
                System.out.println("clinical number patients List: ");
                clinicalNumberLists.forEach(System.out::println);
                System.out.println((" ___________..........___________"));
                System.out.println("Please enter one of the available clinical patient numbers");
                if(scanner.hasNextInt()) {

                    clinicalNumber = scanner.next();
                }else {
                    System.out.println("Please, select a correct number");
                    scanner.next();
                }
            }while (!clinicalNumberLists.contains(clinicalNumber));
        }catch (InputMismatchException exception){
            System.out.println("You have to introduce a number");
            scanner.next();
        }
      
        
        return clinicalNumber;
    }

    private List<String> getClinicalPatientNumberList(List<Patient> patientList) {
        List<String> clinicalNumberLists = null;
        if(patientList.isEmpty()){
            System.out.println("There aren't patients");
        }else {
            clinicalNumberLists = patientList.stream().map(Patient::getClinicNumber).collect(Collectors.toList());
        }
        return clinicalNumberLists;
    }

}
