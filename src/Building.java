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
public interface Building {
	
    void setSize(double length, double width);

    double getLength();

    double getWidth();

    void setColor(String color);

    String getColor();

    void setBuildingType(String type);

    String getBuildingType();

}

