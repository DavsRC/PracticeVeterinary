package src.Patient.operations;

import src.Patient.Owner;
import src.Patient.Patient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PatientPatientOperations implements IPatientOperations {

    @Override
    public Patient savePatient() {
        Scanner scanner = new Scanner(System.in);
        String clinicNumber;
        String name;
        String breed;
        boolean isVaccinated;
        Date dewormingDay = null;
        String pet;

        // Building clinical number
        clinicNumber = buildingClinicalNumber();

        // Building name
        name = buildingName(scanner);

        // Building breed
        breed = buildingBreed(scanner);

        // Building pet
        pet = buildingPet();

        // Building Owner
        Owner owner = buildingOwner(scanner);

        // Building isVaccinated
        isVaccinated = setIsVaccinated();

        // Building Deworming Date
        dewormingDay = mapingDate(scanner, dewormingDay);

        return getPatient(clinicNumber, name, breed, isVaccinated, dewormingDay, pet, owner);
    }

    @Override
    public void getPatients(List<Patient> patientList) {
        if(patientList.isEmpty()){
            System.out.println("There aren't patients");
        }else {
            System.out.println((" ___________..........___________"));
            System.out.println("Patients List: ");
            patientList.stream().forEach(System.out::println);
        }
    }

    private Patient getPatient(String clinicNumber, String name, String breed, boolean isVaccinated, Date dewormingDay, String pet, Owner owner) {
        return Patient.builder()
                .clinicNumber(clinicNumber)
                .name(name)
                .breed(breed)
                .pet(pet)
                .owners(owner)
                .isVaccinated(isVaccinated)
                .dewormingDate(dewormingDay)
                .build();
    }

    private Owner buildingOwner(Scanner scanner) {
        String cellphone;
        int age;
        String DNI;
        String ownerName;
        System.out.println("\n Introduce owner's DNI");
        DNI = scanner.nextLine();
        System.out.println("\n Introduce owner's name");
        ownerName = scanner.nextLine();
        System.out.println("\n Introduce owner's cellphone");
        cellphone = scanner.nextLine();
        System.out.println("\n Introduce owner's age");
        age = getOwnerAge(scanner);
        Owner owner = new Owner(DNI, ownerName, cellphone, age);
        return owner;
    }

    private int getOwnerAge(Scanner scanner) {
        int age = 0;
        try{
            do{
                if(scanner.hasNextInt()) {
                    age = scanner.nextInt();
                } else {
                    System.out.println("Please enter a validated number. Remember that you must to be an adult to register an patient");
                    scanner.next();
                }
            }while (age <18);
        }catch (InputMismatchException exception){
            System.out.println("You have to introduce a number");
            scanner.next();
        }

        return age;
    }

    private String buildingPet() {
        String pet;
        System.out.println("\n Introduce pet type");
        pet = setPetType();
        return pet;
    }

    private String buildingBreed(Scanner scanner) {
        String breed;
        System.out.println("\n Introduce patient's breed");
        breed = scanner.nextLine();
        return breed;
    }

    private String buildingName(Scanner scanner) {
        String name;
        System.out.println("\n Introduce patient's name");
        name = scanner.nextLine();
        return name;
    }

    private String buildingClinicalNumber() {

        Random random = new Random();
        int number = random.nextInt(999999);
        return String.format("%06d", number);

    }

    private String setPetType() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        try{
            do{
                System.out.println("Select your pet");
                System.out.println("1. Cat");
                System.out.println("2. Dog");
                if(scanner.hasNextInt()) {
                    option = scanner.nextInt();
                } else {
                    System.out.println("Please, select a correct number");
                    scanner.next();
                }
            }while (option != 1 && option != 2);
        }catch (InputMismatchException exception){
            System.out.println("You have to introduce a number");
            scanner.next();
        }

        return validatePet(option);
    }

    private String validatePet(int pet) {
        return pet == 1 ? "Cat" : "Dog";
    }

    private boolean setIsVaccinated() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        try{
            do{
                System.out.println("Is your pet vaccinated?");
                System.out.println("1. Yes");
                System.out.println("2. Not");
                if(scanner.hasNextInt()) {
                    option = scanner.nextInt();
                } else {
                    System.out.println("Please, select a correct number");
                    scanner.next();
                }
            }while (option != 1 && option != 2);
        }catch (InputMismatchException exception){
            System.out.println("You have to introduce a number");
            scanner.next();
        }

        return validateVaccinated(option);
    }

    private boolean validateVaccinated(int option){
        return option == 1 ? Boolean.TRUE : Boolean.FALSE;
    }

    private Date mapingDate(Scanner scanner, Date dewormingDay) {
        try {
            dewormingDay = setDewormingDate(scanner);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dewormingDay;
    }


    private Date setDewormingDate(Scanner scanner) throws ParseException {
        int day = 0, month = 0, year = 0;

        System.out.println("\n Introduce deworming day");
        day = getDate(scanner, day);
        System.out.println("\n Introduce deworming month");
        month = getDate(scanner, month);
        System.out.println("\n Introduce deworming year");
        year = getDate(scanner, year);
        String dateString = day + "/" + month + "/" + year;
        return new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
    }

    private int getDate(Scanner scanner, int date) {
        do{
            if(scanner.hasNextInt()){
                date = scanner.nextInt();
            }else {
                System.out.println("Please, select a correct number");
                scanner.next();
            }
            return date;
        }while (0!= date);
    }

}
