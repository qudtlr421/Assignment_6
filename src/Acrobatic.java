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


public class Acrobatic extends Person {
 private String job;

 public Acrobatic(String name, int age, int yearsWorked, String job) {
     super(name, age, yearsWorked);
     this.job = job;
 }

 public String getJob() { return job; }

 @Override
 public String toString() {
     return String.format("Name: %s\nAge: %d\nYears Worked: %d\nJob: %s",
             getName(), getAge(), getYearsWorked(), job);
 }
}
