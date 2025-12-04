/*
 * Class: CMSC203 
 * Instructor: professor Ahmed Tarek
 * Description: Create Bob’s circus is a family-owned circus.
 * Due: 12/03/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Giran Park
 */
package cur;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CircusDriverApp{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Circus circus = new Circus();
        boolean exit = false;

        System.out.println("Welcome to Bob's Circus Management System!");

        while (!exit){
            showMainMenu();

            int selection= validateInput(scanner);

            switch (selection) {
                case 1:
                    handleAddAnimal(circus, scanner);
                    break;
                case 2:
                    handleAddPerson(circus, scanner);
                    break;
                case 3:
                    handleAddBuilding(circus, scanner);
                    break;
                case 4:
                    handleGenerateTicket(scanner);
                    break;
                case 5:
                    System.out.println("Displaying all animals:");
                    System.out.println("----------------------");
                    circus.displayAllAnimals();
                    break;
                case 6:
                    System.out.println("Displaying all persons:");
                    System.out.println("----------------------");
                    circus.displayAllPersons();
                    break;
                case 7:
                    System.out.println("Displaying all buildings:");
                    System.out.println("------------------------");
                    circus.displayAllBuildings();
                    break;
                case 8:
                    System.out.println("Sorting animals by age...");
                    circus.sortAnimalsByAge();
                    System.out.println("Animals sorted by age.");
                    break;
                case 9:
                    System.out.println("Sorting animals by name...");
                    circus.sortAnimalsByName();
                    System.out.println("Animals sorted by name.");
                    break;
                case 10:
                    scanner.nextLine();
                    System.out.print("Enter the name of the animal to search: ");
                    String searchName = scanner.nextLine();
                    circus.searchAnimalByName(searchName);
                    break;
                case 11:
                    exit = true;
                    System.out.println("Exiting Bob's Circus Management System. Goodbye!\n");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

        scanner.close();
    }


    public static void showMainMenu(){
        System.out.println("\nMenu:");
        System.out.println("1. Add Animal");
        System.out.println("2. Add Person");
        System.out.println("3. Add Building");
        System.out.println("4. Generate Ticket");
        System.out.println("5. Display All Animals");
        System.out.println("6. Display All Persons");
        System.out.println("7. Display All Buildings");
        System.out.println("8. Sort Animals by Age");
        System.out.println("9. Sort Animals by Name");
        System.out.println("10. Search Animal by Name");
        System.out.println("11. Exit\n");
        System.out.print("Choose an option: ");
    }


    private static int validateInput(Scanner scanner){
        while(true){
            try {
                int val = scanner.nextInt();
                scanner.nextLine();
                return val;
            } catch(InputMismatchException e){
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                System.out.print("Choose an option: ");
            }
        }
    }


    public static void handleAddAnimal(Circus circus, Scanner scanner){
        System.out.print("\nEnter animal name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter animal type (dog/lion/bird/horse): ");
        String type = scanner.nextLine().trim().toLowerCase();

        System.out.print("Enter age (integer): ");
        int age = 0;
        try{
            age = Integer.parseInt(scanner.nextLine().trim());
        } catch(NumberFormatException e){
            System.out.println("Invalid age entered. Age set to 0.");
            age = 0;
        }

        System.out.print("Enter species: ");
        String species = scanner.nextLine().trim();
        System.out.print("Enter color: ");
        String color = scanner.nextLine().trim();

        Animal animal= null;
        switch(type){
            case "dog":
                animal= new Dog(name, age, species, color);
                break;
            case "lion":
                animal= new Lion(name, age, species, color);
                break;
            case "bird":
                animal= new Bird(name, age, species, color);
                break;
            case "horse":
                animal= new Horse(name, age, species, color);
                break;
            default:
                System.out.println("Unknown animal type. Animal not added.");
                return;
        }

        circus.addAnimal(animal);
        System.out.println("Animal added: " + animal.toString());
    }


    public static void handleAddPerson(Circus circus, Scanner scanner){
        System.out.print("\nEnter person name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter person type (clerk/acrobatic): ");
        String type = scanner.nextLine().trim().toLowerCase();

        System.out.print("Enter age (integer): ");
        int age = 0;
        try {
            age = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid age entered. Age set to 0.");
            age = 0;
        }

        System.out.print("Enter years worked (integer): ");
        int yearsWorked= 0;
        try{
        	yearsWorked= Integer.parseInt(scanner.nextLine().trim());
        } catch(NumberFormatException e){
            System.out.println("Invalid years worked entered. Set to 0.");
            yearsWorked= 0;
        }

        System.out.print("Enter job title: ");
        String job= scanner.nextLine().trim();

        Person person;
        if("clerk".equals(type)){
            person = new Clerk(name, age, yearsWorked, job);
        } else if("acrobatic".equals(type)){
            person = new Acrobatic(name, age, yearsWorked, job);
        } else {
            System.out.println("Unknown person type. Person not added.");
            return;
        }

        circus.addPerson(person);
        System.out.println("Person added: " + person.toString());
    }


    public static void handleAddBuilding(Circus circus, Scanner scanner) {
        System.out.print("\nEnter building type (arena/ticket): ");
        String type = scanner.nextLine().trim().toLowerCase();

        System.out.print("Enter length (double): ");
        double length = 0;
        try {
            length = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid length. Set to 0.");
            length = 0;
        }

        System.out.print("Enter width (double): ");
        double width = 0;
        try {
            width = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e){
            System.out.println("Invalid width. Set to 0. ");
            width = 0;
        }

        System.out.print("Enter color: ");
        String color = scanner.nextLine().trim();

        Building building;
        if ("arena".equals(type)){
            building = new Arena(color, length, width);
        } else if("ticket".equals(type) || "ticketingoffice".equals(type) || "ticketing office".equals(type)) {
            building = new TicketingOffice(color, length, width);
        } else{
            System.out.println("Unknown building type. Building not added.");
            return;
        }

        circus.addBuilding(building);
        System.out.println("Building added: " + building.toString());
    }



    public static void handleGenerateTicket(Scanner scanner){
        System.out.print("\nEnter ticket base price: ");
        double basePrice = 0.0;
        try {
            basePrice = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid price entered. Using 0.");
        }

        double totalAmount = 0.0;
        StringBuilder ticketDetails = new StringBuilder();
        ticketDetails.append(String.format("Regular ticket price: $%.2f%n%n", basePrice));

        boolean addMore = true;
        while (addMore) {
            // Day of week selection
            System.out.println("\nSelect day of the week:");
            for (int i = 0; i < DayOfWeek.values().length; i++) {
                DayOfWeek d = DayOfWeek.values()[i];
                if (d.getDiscount() > 0) {
                    System.out.printf("%d. %s (%.0f%% discount)%n", i + 1, d, d.getDiscount() * 100);
                } else {
                    System.out.printf("%d. %s%n", i + 1, d);
                }
            }
            System.out.print("\nEnter your choice: ");
            int dayChoice = readChoiceInRange(scanner, 1, DayOfWeek.values().length);
            DayOfWeek selectedDay = DayOfWeek.values()[dayChoice - 1];
            double dayDiscount = selectedDay.getDiscount();

            // Customer type selection
            System.out.println("\nEnter customer type:");
            System.out.println("1. Child (10% discount)");
            System.out.println("2. Student (10% discount)");
            System.out.println("3. Adult");
            System.out.println("4. Senior (5% discount)");
            System.out.print("\nEnter your choice: ");
            int custType = readChoiceInRange(scanner, 1, 4);
            double custDiscount = 0.0;
            String custLabel = "";
            switch (custType) {
                case 1:
                    custDiscount = 0.10;
                    custLabel = "child";
                    break;
                case 2:
                    custDiscount = 0.10;
                    custLabel = "student";
                    break;
                case 3:
                    custDiscount = 0.0;
                    custLabel = "adult";
                    break;
                case 4:
                    custDiscount = 0.05;
                    custLabel = "senior";
                    break;
            }

            // Seat selection
            System.out.println("\nSeat Location in the Arena:");
            System.out.println("1. Lower level");
            System.out.println("2. T-level (double ticket price)");
            System.out.println("3. Upper level (5% discount)");
            System.out.print("\nEnter your choice: ");
            int seatChoice = readChoiceInRange(scanner, 1, 3);
            double seatMultiplier = (seatChoice == 2) ? 2.0 : 1.0;
            double seatDiscount = (seatChoice == 3) ? 0.05 : 0.0;

            // Number of tickets
            System.out.print("Enter number of tickets: ");
            int numberOfTickets = 1;
            try {
                numberOfTickets = Integer.parseInt(scanner.nextLine().trim());
                if (numberOfTickets < 1) {
                    System.out.println("Number of tickets must be at least 1. Using 1.");
                    numberOfTickets = 1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Using 1.");
                numberOfTickets = 1;
            }

            // Calculate price
            double priceAfterDay = basePrice * (1.0 - dayDiscount);
            double priceAfterSeatMult = priceAfterDay * seatMultiplier;
            double priceAfterSeatDiscount = priceAfterSeatMult * (1.0 - seatDiscount);
            double finalUnitPrice = priceAfterSeatDiscount * (1.0 - custDiscount);

            double batchTotal = finalUnitPrice * numberOfTickets;
            totalAmount += batchTotal;

            // show customer discount only if > 0
            String custDiscountPart = "";
            if (custDiscount > 0) {
                custDiscountPart = String.format(", Customer Type Discount: %.0f%%", custDiscount * 100);
            }

            // Example: "2 child $32.00 (Day: MONDAY, Day Discount: 10%, Customer Type Discount: 10%)"
            ticketDetails.append(String.format("%d %s $%.2f (Day: %s, Day Discount: %.0f%%%s)%n",
                    numberOfTickets,
                    custLabel,
                    batchTotal,
                    selectedDay,
                    dayDiscount * 100,
                    (custDiscountPart.isEmpty() ? "" : custDiscountPart)));

            // Ask to add more
            System.out.print("\nDo you want to add more tickets? (y/n): ");
            String resp = scanner.nextLine().trim().toLowerCase();
            addMore = resp.equals("y");
        }

        System.out.println("\nTicket Calculation Details:");
        System.out.println("---------------------------");
        System.out.println(ticketDetails.toString());

        System.out.printf("Final Total Amount: $%.2f%n", totalAmount);
        System.out.println("Enjoy the show!");
    }


    private static int readChoiceInRange(Scanner scanner, int min, int max) {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                int val = Integer.parseInt(line);
                if (val < min || val > max) {
                    System.out.printf("Please enter a number between %d and %d: ", min, max);
                } else {
                    return val;
                }
            } catch (NumberFormatException e) {
                System.out.printf("Invalid input. Please enter a number between %d and %d: ", min, max);
            }
        }
    }
}
