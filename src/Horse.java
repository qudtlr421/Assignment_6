package cur;

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

import java.util.Objects;

public class Horse implements Animal {
    private String name;
    private int age;
    private String species;
    private String color;

    public Horse(String nameH, int ageH, String speciesH, String colorH) {
        name = nameH;
        age = ageH;
        species = speciesH;
        color = colorH;
    }

    @Override
    public void move(){
        System.out.println(name + " jog around the forest.");
    }

    @Override
    public void makeSound(){
        System.out.println(name +" whinny: hoo hoo hoo hooo");
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getAge(){
        return age;
    }

    @Override
    public boolean equals(Object objectH){
        if(this==objectH) return true;
        if(!(objectH instanceof Horse)) return false;
        Horse horse=(Horse) objectH;
        return age==horse.age && Objects.equals(name, horse.name) && Objects.equals(species, horse.species) && Objects.equals(color, horse.color);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, age, species, color);
    }

    @Override
    public String toString(){
        return "Horse [Name: " + name + ", Age: " + age + ", Species: " + species + ", Color: " + color + "]";
    }
}