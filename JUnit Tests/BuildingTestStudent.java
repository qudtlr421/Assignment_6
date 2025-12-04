package cur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuildingTestStudent {

    private Building building;

    private static class ConcreteBuilding implements Building {
        private double length;
        private double width;
        private String color;
        private String buildingType;

        public ConcreteBuilding() {
            this.length = 0.0;
            this.width = 0.0;
            this.color = "unknown";
            this.buildingType = "unknown";
        }

        public ConcreteBuilding(double length, double width, String color, String buildingType) {
            this.length = length;
            this.width = width;
            this.color = color;
            this.buildingType = buildingType;
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
    }

    @BeforeEach
    void setUp() throws Exception {
        building = new ConcreteBuilding(); 
    }

    @AfterEach
    void tearDown() throws Exception {
        building = null; 
    }

    @Test
    void testDefaultConstructor() {
        assertNotNull(building);
        assertEquals(0.0, building.getLength(), 0.001); 
        assertEquals(0.0, building.getWidth(), 0.001);
        assertEquals("unknown", building.getColor());
        assertEquals("unknown", building.getBuildingType());
    }

    @Test
    void testParameterizedConstructor() {
        Building parameterizedBuilding = new ConcreteBuilding(10.0, 5.0, "Red", "House");
        assertEquals(10.0, parameterizedBuilding.getLength(), 0.001);
        assertEquals(5.0, parameterizedBuilding.getWidth(), 0.001);
        assertEquals("Red", parameterizedBuilding.getColor());
        assertEquals("House", parameterizedBuilding.getBuildingType());
    }

    @Test
    void testSetSize() {
        building.setSize(15.0, 8.0);
        assertEquals(15.0, building.getLength(), 0.001);
        assertEquals(8.0, building.getWidth(), 0.001);

        building.setSize(0.0, 0.0);
        assertEquals(0.0, building.getLength(), 0.001);
        assertEquals(0.0, building.getWidth(), 0.001);
        
        building.setSize(-5.0, -2.0);
        assertEquals(-5.0, building.getLength(), 0.001); 
        assertEquals(-2.0, building.getWidth(), 0.001);
    }

    @Test
    void testGetLength() {
        building.setSize(20.0, 10.0);
        assertEquals(20.0, building.getLength(), 0.001);
    }

    @Test
    void testGetWidth() {
        building.setSize(20.0, 10.0);
        assertEquals(10.0, building.getWidth(), 0.001);
    }

    @Test
    void testSetColor() {
        building.setColor("Blue");
        assertEquals("Blue", building.getColor());
        
        building.setColor("");
        assertEquals("", building.getColor());
        
        building.setColor(null);
        assertNull(building.getColor()); 
    }

    @Test
    void testGetColor() {
        building.setColor("Green");
        assertEquals("Green", building.getColor());
    }

    @Test
    void testSetBuildingType() {
        building.setBuildingType("Apartment");
        assertEquals("Apartment", building.getBuildingType());
        
        building.setBuildingType("");
        assertEquals("", building.getBuildingType());
        building.setBuildingType(null);
        assertNull(building.getBuildingType()); 
        
    }

    @Test
    void testGetBuildingType() {
        building.setBuildingType("Office");
        assertEquals("Office", building.getBuildingType());
    }
}
