package cur;

import java.util.Objects;

public class Dog implements Animal, Cloneable{
    // Instance variables
    private String name;
    private int age;
    protected String species;
    protected String color;

    // Constructor
    public Dog(String nameDog, int ageDog, String speciesDog, String colorDog) {
        name = nameDog;
        age = ageDog;
        species = speciesDog;
        color = colorDog;
    }

    @Override
    public void move(){ 
        System.out.println(name + " running around the house.");
    }

    @Override
    public void makeSound(){ 
        System.out.println(name + " growl: grrr");
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
    public Dog clone(){ 
        try {
            return (Dog) super.clone();
        } catch (CloneNotSupportedException e) {
            
            return new Dog(this.name, this.age, this.species, this.color);
        }
    }

    @Override
    public boolean equals(Object objectD){
    	if(this == objectD) return true;
    	if(objectD == null || getClass() != objectD.getClass()) return false;
    	Dog other = (Dog) objectD;
    	return age == other.age && Objects.equals(name, other.name) && Objects.equals(species, other.species) && Objects.equals(color, other.color);
    	} 

    @Override
    public String toString(){ 
        return String.format("Dog [name=%s, age=%d, species=%s, color=%s]", name, age, species, color);
    }
}
