package cur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;

class CircusTestStudent {

    private Circus circus;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        circus = new Circus();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        outContent.reset();
    }

    // Helper methods using reflection to access private lists
    private List<Animal> getAnimals() throws Exception {
        Field field = Circus.class.getDeclaredField("animals");
        field.setAccessible(true);
        return (List<Animal>) field.get(circus);
    }

    private List<Person> getPersons() throws Exception {
        Field field = Circus.class.getDeclaredField("persons");
        field.setAccessible(true);
        return (List<Person>) field.get(circus);
    }

    private List<Building> getBuildings() throws Exception {
        Field field = Circus.class.getDeclaredField("buildings");
        field.setAccessible(true);
        return (List<Building>) field.get(circus);
    }

    private List<Ticket> getTickets() throws Exception {
        Field field = Circus.class.getDeclaredField("tickets");
        field.setAccessible(true);
        return (List<Ticket>) field.get(circus);
    }

    @Test
    void testCircusDefaultConstructor() throws Exception {
        assertNotNull(circus);
        assertEquals(0, getAnimals().size());
        assertEquals(0, getPersons().size());
        assertEquals(0, getBuildings().size());
        assertEquals(0, getTickets().size());
    }

    @Test
    void testAddAnimalAndDisplay() throws Exception {
        Bird bird = new Bird("Tweety", 3, "Parrot", "Yellow");
        Lion lion = new Lion("Simba", 8, "African", "Golden");

        circus.addAnimal(bird);
        circus.addAnimal(lion);
        circus.displayAllAnimals();

        String output = outContent.toString();
        assertTrue(output.contains("Tweety"));
        assertTrue(output.contains("Simba"));
        assertTrue(output.contains("Parrot"));
        assertTrue(output.contains("African"));
    }

    @Test
    void testAddPersonAndDisplay() throws Exception {
        Clerk clerk = new Clerk("Alice", 35, 5, "Cashier");
        circus.addPerson(clerk);
        circus.addPerson(new Acrobatic("Charlie", 28, 3, "Trapeze"));

        circus.displayAllPersons();

        String output = outContent.toString();
        assertTrue(output.contains("Alice"));
        assertTrue(output.contains("Charlie"));
        assertTrue(output.contains("Cashier"));
        assertTrue(output.contains("Trapeze"));
    }

    @Test
    void testAddBuildingAndDisplay() throws Exception {
        circus.addBuilding(new Arena("Red", 100.0, 80.0));
        circus.addBuilding(new TicketingOffice("Blue", 30.0, 20.0));

        circus.displayAllBuildings();

        String output = outContent.toString();
        assertTrue(output.contains("Arena"));
        assertTrue(output.contains("TicketingOffice") || output.contains("Ticketing Office"));
        assertTrue(output.contains("Red"));
        assertTrue(output.contains("Blue"));
    }

    @Test
    void testSortAnimalsByAge() throws Exception {
        circus.addAnimal(new Dog("Rex", 7, "Shepherd", "Black"));
        circus.addAnimal(new Bird("Sky", 2, "Eagle", "Brown"));
        circus.addAnimal(new Lion("King", 10, "African", "Gold"));

        circus.sortAnimalsByAge();

        List<Animal> animals = getAnimals();
        assertEquals(2, animals.get(0).getAge());  // youngest first
        assertEquals(7, animals.get(1).getAge());
        assertEquals(10, animals.get(2).getAge());
    }

    @Test
    void testSortAnimalsByName() throws Exception {
        circus.addAnimal(new Horse("Zorro", 6, "Arabian", "Black"));
        circus.addAnimal(new Dog("Buddy", 4, "Lab", "Yellow"));
        circus.addAnimal(new Bird("Angel", 1, "Dove", "White"));

        circus.sortAnimalsByName();

        List<Animal> animals = getAnimals();
        assertEquals("Angel", animals.get(0).getName());
        assertEquals("Buddy", animals.get(1).getName());
        assertEquals("Zorro", animals.get(2).getName());
    }


    @Test
    void testSearchAnimalByName_FoundCaseInsensitive() throws Exception {
        circus.addAnimal(new Lion("nala", 6, "Lioness", "Tan"));
        circus.addAnimal(new Bird("Polly", 3, "Parrot", "Green"));

        outContent.reset(); 

        circus.searchAnimalByName("NALA"); 

        String output = outContent.toString();
        assertTrue(output.contains("Animal found"));
        assertTrue(output.contains("nala") || output.contains("Nala"));
    }

    @Test
    void testSearchAnimalByName_NotFound() throws Exception {
        circus.addAnimal(new Dog("Max", 5, "Husky", "Gray"));

        outContent.reset();

        circus.searchAnimalByName("Ghost");

        String output = outContent.toString();
        assertTrue(output.contains("No animal found with name: Ghost"));
    }

    @Test
    void testTicketPriceCalculations() {
        Ticket t1 = new Ticket(50.0, DayOfWeek.MONDAY, "child", 2, 3);
        assertEquals(243.0, t1.getTotal(), 0.01);


        Ticket t2 = new Ticket(100.0, DayOfWeek.SATURDAY, "adult", 1, 1);
        assertEquals(100.0, t2.getTotal(), 0.01);

        Ticket t3 = new Ticket(80.0, DayOfWeek.WEDNESDAY, "senior", 3, 2);
        assertEquals(410.4, t3.getTotal(), 0.01);
    
    }

    @Test
    void testAddTicket() throws Exception {
        Ticket ticket = new Ticket(60.0, DayOfWeek.FRIDAY, "adult", 1, 1);
        circus.addTicket(ticket);
        assertEquals(1, getTickets().size());
        assertSame(ticket, getTickets().get(0));
    }

    @Test
    void testDisplayEmptyCollections() {
        circus.displayAllAnimals();
        circus.displayAllPersons();
        circus.displayAllBuildings();

        String output = outContent.toString();
        assertTrue(output.contains("No animals") || output.contains("No animals"));
        assertTrue(output.contains("No persons"));
        assertTrue(output.contains("No buildings"));
    }

    @Test
    void testArenaAndTicketingOffice() {
        Arena arena = new Arena("Purple", 150.0, 100.0);
        assertEquals("Purple", arena.getColor());
        assertEquals("Arena", arena.getBuildingType());

        TicketingOffice office = new TicketingOffice("White", 40.0, 30.0);
        assertEquals("Ticketing Office", office.getBuildingType());
    }

    @Test
    void testTicketToString() {
        Ticket ticket = new Ticket(75.0, DayOfWeek.TUESDAY, "child", 2, 4);
        String str = ticket.toString();
        assertTrue(str.contains("75.00"));
        assertTrue(str.contains("TUESDAY"));
        assertTrue(str.contains("child"));
        assertTrue(str.contains("total=486.00"));
    }

    @Test
    void testAnimalBehavior() {
        Animal bird = new Bird("Rio", 5, "Macaw", "Blue");
        Animal dog = new Dog("Max", 6, "Lab", "Black");

        bird.makeSound();
        dog.move();

        String output = outContent.toString();
        assertTrue(output.contains("Tweet"));
        assertTrue(output.contains("runs around happily"));
    }
}