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

public class Bird implements Animal {
    private String name;
    private int age;
    private String species;
    private String color;

    public Bird(String nameB, int ageB, String speciesB, String colorB) {
        name = nameB;
        age = ageB;
        species = speciesB;
        color = colorB;
    }

    @Override
    public void move() {
        System.out.println(name + " is hopping on the grass.");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " chirps: witch-ity, witch-ity, witch-ity");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object objectB){
        if (this == objectB) return true;
        if (!(objectB instanceof Bird)) return false;
        Bird bird = (Bird) objectB;
        return age == bird.age && Objects.equals(name, bird.name) && Objects.equals(species, bird.species) &&Objects.equals(color, bird.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, species, color);
    }

    @Override
    public String toString() {
        return "Bird [Name: " + name + ", Age: " + age + ", Species: " + species + ", Color: " + color + "]";
    }
}
