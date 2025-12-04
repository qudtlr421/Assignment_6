package cur;

import java.util.Objects;

public class Lion implements Animal{
    
    private String name;
    private int age;
    private String species;
    private String color;

   
    public Lion(String name, int age, String species, String color){
        this.name= name;
        this.age= age;
        this.species= species;
        this.color= color;
    }

    @Override
    public void move(){ 
        System.out.println(name + " stalks and chasing a prey.");
    }

    @Override
    public void makeSound(){ 
        System.out.println(name + " roars!");
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
    public boolean equals(Object obj){ 
        if(this== obj) return true;
        if(!(obj instanceof Lion)) return false;
        Lion other= (Lion) obj;
        return age== other.age &&
               Objects.equals(name, other.name) && Objects.equals(species, other.species) && Objects.equals(color, other.color);
    }

    @Override
    public String toString(){ 
        return String.format("Lion [name=%s, age=%d, species=%s, color=%s]",
                name, age, species, color);
    }
}
