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
public class Ticket {

    private double basePrice;
    private DayOfWeek day;
    private String ageGroup;
    private int level;
    private int quantity;


    public Ticket(double basePrice, DayOfWeek day, String ageGroup, int level, int quantity) {
        this.basePrice = basePrice;
        this.day = day;
        this.ageGroup = ageGroup.toLowerCase();
        this.level = level;
        this.quantity = quantity;
    }

    // Calculate total cost 
    public double getTotal() {
        double price= basePrice;
        double effectiveLevelMultiplier;
        if(level== 2) {
            effectiveLevelMultiplier= 2.0;
        } else{
            effectiveLevelMultiplier= 1.0; 
        }

        price*= effectiveLevelMultiplier;
        price= price*(1.0- day.getDiscount());

        if(ageGroup.equals("child")){
            price *= 0.90;
        }else if(ageGroup.equals("senior")){
            price*= 0.95; 
        }
        return price*quantity;
    }

    @Override
    public String toString(){
        return String.format("Ticket[base=%.2f, day=%s, age=%s, level=%d, qty=%d, total=%.2f]", basePrice, day, ageGroup, level, quantity, getTotal());
    }
}