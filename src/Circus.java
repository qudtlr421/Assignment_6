/*
 * Class: CMSC203 
 * Instructor: professor Ahmed Tarek
 * Description:Create Bob’s circus is a family-owned circus.
 * Due: 12/03/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Giran Park
*/
package cur;

import java.util.ArrayList;
import java.util.List;

public class Circus{
    private List<Animal> animals;
    private List<Person> persons;
    private List<Building> buildings;
    private List<Ticket> tickets;

    public Circus(){
        animals= new ArrayList<>();
        persons= new ArrayList<>();
        buildings= new ArrayList<>();
        tickets= new ArrayList<>();
    }


    public void addBuilding(Building building){
        buildings.add(building);
    }


    public void displayAllBuildings(){
        if(buildings.isEmpty()){
            System.out.println("No buildings in the circus.");
        }else {
            for(Building b : buildings){
                System.out.println(b);
            }
        }
    }

    public void addPerson(Person person){
        persons.add(person);
    }

    public void displayAllPersons(){
        if (persons.isEmpty()){
            System.out.println("No persons in the circus.");
        } else {
            for (Person p : persons) {
                System.out.println(p);
            }
        }
    }

    // Add animal
    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    // Display animals
    public void displayAllAnimals(){
        if (animals.isEmpty()){
            System.out.println("No animals in the circus.");
        } else {
            for (Animal a : animals){
                System.out.println(a);
            }
        }
    }


    public void sortAnimalsByAge(){
        for(int i= 0; i< animals.size()- 1;i++){
            int min = i;
            for(int j=i + 1; j< animals.size(); j++) {
                if(animals.get(j).getAge() < animals.get(min).getAge()) {
                    min = j;
                }
            }
            if (min != i) {
                Animal temp = animals.get(i);
                animals.set(i, animals.get(min));
                animals.set(min, temp);
            }
        }
    }

    // Sort animals by name
    public void sortAnimalsByName() {
        for (int i = 0; i < animals.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < animals.size(); j++) {
                if (animals.get(j).getName().compareToIgnoreCase(
                        animals.get(min).getName()) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                Animal temp = animals.get(i);
                animals.set(i, animals.get(min));
                animals.set(min, temp);
            }
        }
    }

    // Search animal by name
    public void searchAnimalByName(String name) {
        boolean found = false;
        for (Animal a : animals) {
            if (a.getName().equalsIgnoreCase(name)) {
                System.out.println("Animal found: " + a);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No animal found with name: " + name);
        }
    }


    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

/**
 * this create ticket
 * @param dayOfWeek day of week want to buy
 * @param basePrice base price of ticket
 * @param age  age of the person who buy ticket
 * @return ticket 
 */
  
    public Ticket generateTicket(String dayOfWeek, double basePrice, int age) {
        DayOfWeek day;

        try {
            day = DayOfWeek.valueOf(dayOfWeek.toUpperCase());
        } catch (Exception e) {
            day = DayOfWeek.FRIDAY; 
        }

        
        String ageGroup;
        if (age <= 12) {
            ageGroup = "child";
        } else if (age >= 65) {
            ageGroup = "senior";
        } else {
            ageGroup = "adult";
        }

       
        Ticket ticket = new Ticket(basePrice, day, ageGroup, 1, 1);

        addTicket(ticket);

        return ticket;
    }
}
