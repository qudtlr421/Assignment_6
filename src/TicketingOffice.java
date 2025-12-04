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

public class TicketingOffice implements Building {
    private String color;
    private double length;
    private double width;
    private String buildingType;

    public TicketingOffice(String colorT, double lengthT, double widthT) {
        color = colorT;
        length = lengthT;
        width = widthT;
        buildingType = "Ticketing Office";
    }

    @Override
    public void setSize(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setBuildingType(String type) {
        this.buildingType = type;
    }

    @Override
    public String getBuildingType() {
        return buildingType;
    }

    @Override
    public String toString() {
        return "TicketingOffice [Color: " + color + ", Length: " + length +  ", Width: " + width + 
               ", Type: " + buildingType + "]";
    }
}