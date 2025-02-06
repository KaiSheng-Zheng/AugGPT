import org.junit.jupiter.api.*;
import java.lang.reflect.*;
import java.util.*;
import java.io.*;
import java.math.*;

import static org.junit.jupiter.api.Assertions.*;


public class TestClass {
    
    @Test
    public void testCircleShrink_czk9() throws Exception {
        // Create a Location for the Circle
        Location location = new Location(1, 0);
        // Create a Circle with radius 5
        Circle circle = new Circle(location, '*', 5);
        
        // Check initial area (should be greater than 0)
        int initialArea = circle.area();
        assertTrue(initialArea > 0, "Initial area should be greater than 0");
        
        // Shrink the circle and capture the new area
        circle.shrink();
        int newArea = circle.area();

        // Assert that the area decreases after shrinking
        assertTrue(newArea < initialArea, "Area should decrease after shrinking");

        // Reflectively access the radius field to check its value
        Field radiusField = Circle.class.getDeclaredField("radius");
        radiusField.setAccessible(true);
        int radiusValue = (int) radiusField.get(circle);

        // Assert that the radius is decreased by 1
        assertEquals(4, radiusValue, "Radius should be 4 after shrinking");
    }

    @Test
    public void testRightTriangleEnlarge_hf2n() throws Exception {
        // Create a Location for the RightTriangle
        Location location = new Location(0, 1);
        // Create a RightTriangle with width 3, height 2, and direction RIGHT_UP
        RightTriangle triangle = new RightTriangle(location, 'X', 3, 2, Direction.RIGHT_UP);

        // Capture the initial area
        int initialArea = triangle.area();
        assertTrue(initialArea > 0, "Initial area should be greater than 0");

        // Enlarge the triangle
        triangle.enlarge();
        int newArea = triangle.area();

        // Assert that the area increases after enlarging
        assertTrue(newArea > initialArea, "Area should increase after enlarging");

        // Reflectively access the width and height fields to check their values
        Field widthField = RightTriangle.class.getDeclaredField("width");
        Field heightField = RightTriangle.class.getDeclaredField("height");
        widthField.setAccessible(true);
        heightField.setAccessible(true);
        
        int widthValue = (int) widthField.get(triangle);
        int heightValue = (int) heightField.get(triangle);

        // Assert that both width and height are increased by 1
        assertEquals(4, widthValue, "Width should be 4 after enlarging");
        assertEquals(3, heightValue, "Height should be 3 after enlarging");
    }

    @Test
    public void testRightTriangleToString_o6dt() throws Exception {
        // Create a Location for the RightTriangle
        Location location = new Location(2, 2);
        // Create a RightTriangle with width 5, height 5, and direction LEFT_UP
        RightTriangle triangle = new RightTriangle(location, 'A', 5, 5, Direction.LEFT_UP);

        // Reflectively access the toString method
        String output = triangle.toString();

        // Assert that the output matches the expected format
        assertTrue(output.contains("RightTriangle: (2,2)"), "Output should contain location");
        assertTrue(output.contains("area="), "Output should contain area");
        assertTrue(output.contains("pattern=A"), "Output should contain pattern");
    }

    @Test
    public void testOverLapShapeCanvas_j4s6() throws Exception {
        // Create an OverLapShapeCanvas with dimensions 15x15
        OverLapShapeCanvas canvas = new OverLapShapeCanvas(15, 15);

        // Add shapes to the canvas
        boolean addedCircle = canvas.addShape(1, 1, 'C', 3);
        boolean addedTriangle = canvas.addShape(1, 1, 'T', 3, 3, 0); // Overlapping
        boolean addedAnotherCircle = canvas.addShape(2, 2, 'A', 1); // Overlapping

        // Assert the addition results
        assertTrue(addedCircle, "Circle should be added successfully");
        assertTrue(addedTriangle, "Triangle should be added even if overlapping");
        assertTrue(addedAnotherCircle, "Another circle should be added even if overlapping");

        // Check the canvas
        char[][] canvasArray = canvas.getCanvas();
        // Assert that the canvas has non-space characters where shapes were added
        assertNotEquals(' ', canvasArray[1][1], "Canvas should have shape at (1,1)");
        assertNotEquals(' ', canvasArray[1][2], "Canvas should have shape at (1,2)");
        assertNotEquals(' ', canvasArray[2][2], "Canvas should have shape at (2,2)");
    }

    //@Test
    public void testCircleMethods_czh0() throws Exception {
        // Create a Location instance for the Circle
        Location location = new Location(5, 5);
        // Create a Circle instance with radius 3
        Circle circle = new Circle(location, '*', 3);
        
        // Verify initial area
        int initialArea = circle.area(); // area should be calculated based on radius
        assertEquals(28, initialArea, "Initial area should be 28 for radius 3");
        
        // Invoke enlarge() to increase radius by 1
        circle.enlarge();
        
        // Verify area after enlarging
        int enlargedArea = circle.area(); // area should now be based on radius 4
        assertEquals(50, enlargedArea, "Area should be 50 after enlarging");
        
        // Invoke shrink() to decrease radius by 1
        circle.shrink();
        
        // Verify area after shrinking
        int shrunkArea = circle.area(); // area should be back to 28
        assertEquals(28, shrunkArea, "Area should be back to 28 after shrinking");
        
        // Access the private 'pattern' field using reflection
        Field patternField = Circle.class.getDeclaredField("pattern");
        patternField.setAccessible(true);
        char pattern = (char) patternField.get(circle);
        
        // Assert the pattern is as expected
        assertEquals('*', pattern, "Pattern should be '*' for Circle");
        
        // Check the toString() method
        String circleString = circle.toString();
        assertTrue(circleString.contains("Circle: (5,5)"), "toString should contain the correct location");
        assertTrue(circleString.contains("area=28"), "toString should contain the correct area");
        assertTrue(circleString.contains("pattern=*"), "toString should contain the correct pattern");
    }

    //@Test
    public void testRightTriangleMethods_felm() throws Exception {
        // Create a Location instance for the RightTriangle
        Location location = new Location(0, 0);
        // Create a RightTriangle instance with width 5, height 3
        RightTriangle triangle = new RightTriangle(location, 'X', 5, 3, Direction.LEFT_UP);
        
        // Verify initial area
        int initialArea = triangle.area(); // area should be calculated based on width and height
        assertEquals(7, initialArea, "Initial area should be 7 for width 5 and height 3");
        
        // Invoke enlarge() to increase width and height by 1
        triangle.enlarge();
        
        // Verify area after enlarging
        int enlargedArea = triangle.area(); // area should now be based on width 6 and height 4
        assertEquals(12, enlargedArea, "Area should be 12 after enlarging");
        
        // Invoke shrink() to decrease width and height by 1
        triangle.shrink();
        
        // Verify area after shrinking
        int shrunkArea = triangle.area(); // area should be back to 7
        assertEquals(7, shrunkArea, "Area should be back to 7 after shrinking");
        
        // Access the private 'width' field using reflection
        Field widthField = RightTriangle.class.getDeclaredField("width");
        widthField.setAccessible(true);
        int width = (int) widthField.get(triangle);
        
        // Assert the width is as expected
        assertEquals(5, width, "Width should be 5 for RightTriangle");
        
        // Check the toString() method
        String triangleString = triangle.toString();
        assertTrue(triangleString.contains("RightTriangle: (0,0)"), "toString should contain the correct location");
        assertTrue(triangleString.contains("area=7"), "toString should contain the correct area");
        assertTrue(triangleString.contains("pattern=X"), "toString should contain the correct pattern");
    }

    //@Test
    public void testAvoidConflictShapeCanvas_15p1() {
        // Create an AvoidConflictShapeCanvas instance with dimensions 10x10
        AvoidConflictShapeCanvas canvas = new AvoidConflictShapeCanvas(10, 10);
        
        // Add a Circle to the canvas
        assertTrue(canvas.addShape(2, 2, 'A', 2), "Circle should be added successfully");
        
        // Attempt to add a Circle that would overlap
        assertFalse(canvas.addShape(2, 2, 'B', 2), "Overlapping Circle should not be added");
        
        // Add a RightTriangle to the canvas
        assertTrue(canvas.addShape(5, 5, 'C', 4, 3, 0), "RightTriangle should be added successfully");
        
        // Check the shape count
        assertEquals(2, canvas.getShapeCount(), "There should be 2 shapes in the canvas");
        
        // Check space grid count
        int spaceCount = canvas.getSpaceGridCount();
        assertTrue(spaceCount < 100, "There should be less than 100 space grids");
        
        // Check shapes by area
        var shapesByArea = canvas.getShapesByArea();
        assertEquals(2, shapesByArea.size(), "There should be 2 shapes returned by area");
        
        // Check shapes by location
        var shapesByLocation = canvas.getShapesByLocation();
        assertEquals(2, shapesByLocation.size(), "There should be 2 shapes returned by location");
    }

    @Test
    public void testOverLapShapeCanvas_wdir() {
        // Create an OverLapShapeCanvas instance with dimensions 15x15
        OverLapShapeCanvas canvas = new OverLapShapeCanvas(15, 15);
        
        // Add a Circle to the canvas
        assertTrue(canvas.addShape(0, 0, 'A', 5), "Circle should be added successfully");
        
        // Add another Circle that overlaps with the first
        assertTrue(canvas.addShape(1, 1, 'B', 5), "Overlapping Circle should be added successfully");
        
        // Add a RightTriangle to the canvas
        assertTrue(canvas.addShape(10, 5, 'C', 4, 6, 2), "RightTriangle should be added successfully");
        
        // Check the shape count
        assertEquals(3, canvas.getShapeCount(), "There should be 3 shapes in the canvas");
        
        // Check space grid count
        int spaceCount = canvas.getSpaceGridCount();
        assertTrue(spaceCount < 225, "There should be less than 225 space grids");
        
        // Check shapes by area
        var shapesByArea = canvas.getShapesByArea();
        assertEquals(3, shapesByArea.size(), "There should be 3 shapes returned by area");
        
        // Check shapes by location
        var shapesByLocation = canvas.getShapesByLocation();
        assertEquals(3, shapesByLocation.size(), "There should be 3 shapes returned by location");
    }

    //@Test
    public void testCircleAreaAndEnlarge_h5ij() throws Exception {
        // Create a new Location object for the Circle
        Location location = new Location(1, 1);
        // Create a Circle object with the specified parameters
        Circle circle = new Circle(location, '*', 5);
        
        // Use reflection to access the private field 'radius' in Circle
        Field radiusField = Circle.class.getDeclaredField("radius");
        radiusField.setAccessible(true);
        
        // Check the initial area of the Circle
        int initialArea = circle.area();
        Assertions.assertEquals(88, initialArea, "Initial area should be 88 for radius 5");
        
        // Enlarge the Circle and check the area again
        circle.enlarge();
        int enlargedArea = circle.area();
        Assertions.assertEquals(113, enlargedArea, "Area should be 113 after enlarging the circle");
        
        // Access the radius field to ensure it has increased
        int radiusAfterEnlarge = (int) radiusField.get(circle);
        Assertions.assertEquals(6, radiusAfterEnlarge, "Radius should be 6 after enlarging");
        
        // Shrink the Circle and check the area again
        circle.shrink();
        int shrunkArea = circle.area();
        Assertions.assertEquals(88, shrunkArea, "Area should return to 88 after shrinking back");
    }

    //@Test
    public void testRightTriangleFillGridsAndShrink_uthb() throws Exception {
        // Create a new Location object for the RightTriangle
        Location location = new Location(2, 2);
        // Create a RightTriangle object with the specified parameters
        RightTriangle triangle = new RightTriangle(location, 'X', 5, 5, Direction.LEFT_UP);
        
        // Use reflection to access the private fields 'width' and 'height' in RightTriangle
        Field widthField = RightTriangle.class.getDeclaredField("width");
        Field heightField = RightTriangle.class.getDeclaredField("height");
        widthField.setAccessible(true);
        heightField.setAccessible(true);
        
        // Check the initial area of the RightTriangle
        int initialArea = triangle.area();
        Assertions.assertEquals(12, initialArea, "Initial area should be 12 for width 5 and height 5");
        
        // Shrink the RightTriangle and check the area again
        triangle.shrink();
        int shrunkArea = triangle.area();
        Assertions.assertEquals(6, shrunkArea, "Area should be 6 after shrinking");
        
        // Access the width and height fields to ensure they have decreased
        int widthAfterShrink = (int) widthField.get(triangle);
        int heightAfterShrink = (int) heightField.get(triangle);
        Assertions.assertEquals(4, widthAfterShrink, "Width should be 4 after shrinking");
        Assertions.assertEquals(4, heightAfterShrink, "Height should be 4 after shrinking");
        
        // Check the grids filled with the pattern
        char[][] grids = triangle.getGrids();
        Assertions.assertEquals('X', grids[0][0], "Top left grid should be filled with pattern 'X'");
        Assertions.assertEquals(' ', grids[1][0], "Grid below top left should be empty");
    }

    @Test
    public void testOverlapShapeCanvas_n7uu() throws Exception {
        // Create an OverLapShapeCanvas object
        OverLapShapeCanvas canvas = new OverLapShapeCanvas(10, 10);
        
        // Add shapes to the canvas
        boolean addedCircle = canvas.addShape(1, 1, 'O', 3); // Circle with radius 3
        boolean addedTriangle = canvas.addShape(2, 2, 'T', 4, 4, 0); // RightTriangle with width and height 4
        
        // Assert that both shapes were added successfully
        Assertions.assertTrue(addedCircle, "Circle should be added successfully");
        Assertions.assertTrue(addedTriangle, "RightTriangle should be added successfully");
        
        // Check the shape count in the canvas
        int shapeCount = canvas.getShapeCount();
        Assertions.assertEquals(2, shapeCount, "Shape count should be 2");
        
        // Check the canvas for patterns
        char[][] canvasGrid = canvas.getCanvas();
        Assertions.assertEquals('O', canvasGrid[1][1], "Circle should be at (1,1)");
        Assertions.assertEquals('T', canvasGrid[2][2], "Triangle should be at (2,2)");
        
        // Verify the space grid count
        int spaceCount = canvas.getSpaceGridCount();
        Assertions.assertTrue(spaceCount < 100, "There should be some space grids left");
    }

    //@Test
    public void testAvoidConflictShapeCanvas_b053() throws Exception {
        // Create an AvoidConflictShapeCanvas object
        AvoidConflictShapeCanvas canvas = new AvoidConflictShapeCanvas(15, 15);
        
        // Add shapes to the canvas
        boolean addedCircle1 = canvas.addShape(0, 0, 'C', 4); // Circle with radius 4
        boolean addedTriangle1 = canvas.addShape(5, 5, 'T', 3, 3, 0); // RightTriangle with width and height 3
        
        // Try to add a conflicting shape
        boolean addedCircle2 = canvas.addShape(0, 0, 'C', 2); // Circle with radius 2 (conflict)
        
        // Assert that the first two shapes were added successfully and the last one failed
        Assertions.assertTrue(addedCircle1, "First Circle should be added successfully");
        Assertions.assertTrue(addedTriangle1, "First RightTriangle should be added successfully");
        Assertions.assertFalse(addedCircle2, "Conflicting Circle should not be added");
        
        // Check the shape count in the canvas
        int shapeCount = canvas.getShapeCount();
        Assertions.assertEquals(2, shapeCount, "Shape count should remain 2");
        
        // Check the canvas for patterns
        char[][] canvasGrid = canvas.getCanvas();
        Assertions.assertEquals('C', canvasGrid[0][0], "Circle should be at (0,0)");
        Assertions.assertEquals('T', canvasGrid[5][5], "Triangle should be at (5,5)");
        
        // Verify the space grid count
        int spaceCount = canvas.getSpaceGridCount();
        Assertions.assertTrue(spaceCount < 225, "There should be some space grids left");
    }

    @Test
    public void testCircleAreaAndToString_itie() throws Exception {
        // Step 1: Create a Location instance for the Circle
        Location location = new Location(1, 1);
        
        // Step 2: Create a Circle instance with radius 5
        Circle circle = new Circle(location, '*', 5);
        
        // Step 3: Access the radius field using reflection
        Field radiusField = Circle.class.getDeclaredField("radius");
        radiusField.setAccessible(true);
        
        // Step 4: Assert the initial area calculation
        int area = circle.area();
        Assertions.assertEquals(88, area, "The area should be 88 for a radius of 5");
        
        // Step 5: Assert the toString method
        String expectedToString = "Circle: (1,1) area=88 pattern=*";
        Assertions.assertEquals(expectedToString, circle.toString(), "toString should match expected format");
        
        // Step 6: Shrink the circle and assert the new area
        circle.shrink();
        int newArea = circle.area();
        Assertions.assertEquals(60, newArea, "The area should be 60 after shrinking");
        
        // Step 7: Assert the updated toString method
        String updatedToString = "Circle: (1,1) area=60 pattern=*";
        Assertions.assertEquals(updatedToString, circle.toString(), "toString should reflect the updated area");
    }

    @Test
    public void testRightTriangleAreaAndToString_rt0f() throws Exception {
        // Step 1: Create a Location instance for the RightTriangle
        Location location = new Location(0, 1);
        
        // Step 2: Create a RightTriangle instance with width 7, height 3
        RightTriangle triangle = new RightTriangle(location, 'X', 7, 3, Direction.RIGHT_UP);
        
        // Step 3: Access width and height fields using reflection
        Field widthField = RightTriangle.class.getDeclaredField("width");
        Field heightField = RightTriangle.class.getDeclaredField("height");
        widthField.setAccessible(true);
        heightField.setAccessible(true);
        
        // Step 4: Assert the initial area calculation
        int area = triangle.area();
        Assertions.assertEquals(15, area, "The area should be 15 for width 7 and height 3");
        
        // Step 5: Assert the toString method
        String expectedToString = "RightTriangle: (0,1) area=15 pattern=X";
        Assertions.assertEquals(expectedToString, triangle.toString(), "toString should match expected format");
        
        // Step 6: Enlarge the triangle and assert the new area
        triangle.enlarge();
        int newArea = triangle.area();
        Assertions.assertEquals(20, newArea, "The area should be 20 after enlarging");
        
        // Step 7: Assert the updated toString method
        String updatedToString = "RightTriangle: (0,1) area=20 pattern=X";
        Assertions.assertEquals(updatedToString, triangle.toString(), "toString should reflect the updated area");
    }

    //@Test
    public void testAvoidConflictShapeCanvas_vk45() throws Exception {
        // Step 1: Create an AvoidConflictShapeCanvas instance
        AvoidConflictShapeCanvas canvas = new AvoidConflictShapeCanvas(20, 20);
        
        // Step 2: Add a Circle to the canvas
        boolean addedCircle = canvas.addShape(5, 5, 'C', 3);
        Assertions.assertTrue(addedCircle, "The circle should be added successfully");
        
        // Step 3: Add a RightTriangle to the canvas
        boolean addedTriangle = canvas.addShape(10, 10, 'T', 5, 5, 0);
        Assertions.assertTrue(addedTriangle, "The right triangle should be added successfully");
        
        // Step 4: Attempt to add another Circle overlapping with the first one
        boolean addedCircleOverlap = canvas.addShape(5, 5, 'D', 2);
        Assertions.assertFalse(addedCircleOverlap, "The overlapping circle should not be added");
        
        // Step 5: Verify the shapes by area
        Assertions.assertEquals(2, canvas.getShapeCount(), "There should be 2 shapes in the canvas");
        
        // Step 6: Get the canvas representation and verify it
        char[][] canvasGrid = canvas.getCanvas();
        Assertions.assertEquals('C', canvasGrid[5][5], "Canvas should have 'C' at (5,5)");
        Assertions.assertEquals('T', canvasGrid[10][10], "Canvas should have 'T' at (10,10)");
    }

    @Test
    public void testOverLapShapeCanvas_87if() throws Exception {
        // Step 1: Create an OverLapShapeCanvas instance
        OverLapShapeCanvas canvas = new OverLapShapeCanvas(15, 15);
        
        // Step 2: Add a RightTriangle to the canvas
        boolean addedTriangle1 = canvas.addShape(0, 0, 'A', 5, 5, 0);
        Assertions.assertTrue(addedTriangle1, "The first triangle should be added successfully");
        
        // Step 3: Add another RightTriangle overlapping with the first one
        boolean addedTriangle2 = canvas.addShape(2, 2, 'B', 4, 4, 0);
        Assertions.assertTrue(addedTriangle2, "The second triangle should be added overlapping successfully");
        
        // Step 4: Verify the shape count
        Assertions.assertEquals(2, canvas.getShapeCount(), "There should be 2 shapes in the canvas");
        
        // Step 5: Get the canvas representation and verify it
        char[][] canvasGrid = canvas.getCanvas();
        Assertions.assertEquals('A', canvasGrid[0][0], "Canvas should have 'A' at (0,0)");
        Assertions.assertEquals('B', canvasGrid[2][2], "Canvas should have 'B' at (2,2)");
        
        // Step 6: Verify space count in the canvas
        int spaceCount = canvas.getSpaceGridCount();
        Assertions.assertTrue(spaceCount > 0, "There should be space grids in the canvas");
    }

    //@Test
    public void testCircleShrink_r7ia() throws Exception {
        // Create a Location for the Circle at (1, 0)
        Location location = new Location(1, 0);
        // Create a Circle with radius 5
        Circle circle = new Circle(location, '*', 5);
        
        // Access the private radius field using reflection
        Field radiusField = Circle.class.getDeclaredField("radius");
        radiusField.setAccessible(true);
        
        // Assert the initial area of the Circle
        assertEquals(88, circle.area(), "Initial area should be 88");

        // Shrink the Circle
        circle.shrink();
        
        // Assert that the radius is now 4
        assertEquals(4, radiusField.get(circle), "Radius should be 4 after shrinking");
        
        // Assert the area after shrinking
        assertEquals(60, circle.area(), "Area should be 60 after shrinking");
        
        // Check the grids to verify the correct filling
        char[][] grids = circle.getGrids();
        assertEquals(10, grids.length, "Height of grids should be 10");
        assertEquals(10, grids[0].length, "Width of grids should be 10");
    }

    //@Test
    public void testRightTriangleShrink_49sy() throws Exception {
        // Create a Location for the RightTriangle at (0, 1)
        Location location = new Location(0, 1);
        // Create a RightTriangle with width 7, height 3
        RightTriangle triangle = new RightTriangle(location, 'X', 7, 3, Direction.RIGHT_UP);
        
        // Access the private fields width and height using reflection
        Field widthField = RightTriangle.class.getDeclaredField("width");
        Field heightField = RightTriangle.class.getDeclaredField("height");
        widthField.setAccessible(true);
        heightField.setAccessible(true);
        
        // Assert the initial area of the RightTriangle
        assertEquals(15, triangle.area(), "Initial area should be 15");

        // Shrink the RightTriangle
        triangle.shrink();
        
        // Assert that the width is now 6 and height is now 2
        assertEquals(6, widthField.get(triangle), "Width should be 6 after shrinking");
        assertEquals(2, heightField.get(triangle), "Height should be 2 after shrinking");
        
        // Assert the area after shrinking
        assertEquals(6, triangle.area(), "Area should be 6 after shrinking");
        
        // Check the grids to verify the correct filling
        char[][] grids = triangle.getGrids();
        assertEquals(2, grids.length, "Height of grids should be 2");
        assertEquals(6, grids[0].length, "Width of grids should be 6");
    }

    @Test
    public void testRightTriangleDirectionCoverage_gbrt() throws Exception {
        // Create a Location for the RightTriangle at (0, 1)
        Location location = new Location(0, 1);
        // Create RightTriangles with different directions
        RightTriangle triangleUp = new RightTriangle(location, 'A', 5, 5, Direction.LEFT_UP);
        RightTriangle triangleDown = new RightTriangle(location, 'B', 5, 5, Direction.LEFT_DOWN);
        
        // Check the grids for LEFT_UP
        triangleUp.fillGrids();
        triangleDown.fillGrids();

        char[][] gridsUp = triangleUp.getGrids();
        assertEquals('A', gridsUp[0][0], "Grids should start with 'A' for LEFT_UP");
        
        // Check the grids for LEFT_DOWN
        char[][] gridsDown = triangleDown.getGrids();
        assertEquals('B', gridsDown[4][0], "Grids should start with 'B' for LEFT_DOWN");
        
        // Check sizes
        assertEquals(5, gridsUp.length, "Height of grids for LEFT_UP should be 5");
        assertEquals(5, gridsDown.length, "Height of grids for LEFT_DOWN should be 5");
    }

    //@Test
    public void testCanvasShapeOverlap_rtrm() throws Exception {
        // Create an AvoidConflictShapeCanvas of size 10x10
        AvoidConflictShapeCanvas canvas = new AvoidConflictShapeCanvas(10, 10);
        
        // Add shapes to the canvas
        assertTrue(canvas.addShape(0, 0, 'A', 5, 5, 0), "Should successfully add shape A");
        assertTrue(canvas.addShape(1, 1, 'B', 5, 5, 0), "Should successfully add shape B overlapping A");
        
        // Verify the canvas after adding shapes
        char[][] drawnCanvas = canvas.getCanvas();
        
        // Check that shape A occupies the canvas
        assertEquals('A', drawnCanvas[0][0], "Canvas should have 'A' at (0,0)");
        assertEquals('B', drawnCanvas[1][1], "Canvas should have 'B' at (1,1)");
        
        // Check the total number of shapes added
        assertEquals(2, canvas.getShapeCount(), "Should have 2 shapes in the canvas");
    }

    @Test
    public void testCircleShrink_aqzk() throws Exception {
        // Initialize a Location and Circle object with a radius of 5
        Location location = new Location(1, 0);
        Circle circle = new Circle(location, '*', 5);

        // Verify the initial area of the circle
        int initialArea = circle.area();
        Assertions.assertEquals(88, initialArea, "Initial area should be 88");

        // Shrink the circle, which should reduce the radius and update the grids
        circle.shrink();

        // Access the radius field using reflection
        Field radiusField = Circle.class.getDeclaredField("radius");
        radiusField.setAccessible(true);
        int newRadius = (int) radiusField.get(circle);

        // Verify the radius is now 4 after shrinking
        Assertions.assertEquals(4, newRadius, "Radius should be 4 after shrinking");

        // Verify the area of the circle after shrinking
        int newArea = circle.area();
        Assertions.assertEquals(60, newArea, "Area should be 60 after shrinking");
    }

    //@Test
    public void testRightTriangleDirection_kj6v() throws Exception {
        // Initialize a Location and RightTriangle object
        Location location = new Location(0, 1);
        RightTriangle triangle = new RightTriangle(location, 'X', 7, 3, Direction.RIGHT_DOWN);

        // Fill the grids for the triangle
        char[][] grids = triangle.getGrids();

        // Verify the grid contents for the RIGHT_DOWN direction
        Assertions.assertEquals('X', grids[0][6], "The right angle corner should be filled with pattern");
        Assertions.assertEquals(' ', grids[1][6], "The next cell down should be empty");
        Assertions.assertEquals('X', grids[2][5], "The hypotenuse cell should be filled with pattern");
        Assertions.assertEquals(' ', grids[2][6], "The adjacent cell should be empty");

        // Check the area calculation
        int area = triangle.area();
        Assertions.assertEquals(10, area, "Area should be 10 for the triangle");
    }

    //@Test
    public void testRightTriangleEnlarge_zw7t() throws Exception {
        // Initialize a Location and RightTriangle object
        Location location = new Location(2, 3);
        RightTriangle triangle = new RightTriangle(location, 'Z', 5, 5, Direction.LEFT_UP);

        // Verify the initial area
        int initialArea = triangle.area();
        Assertions.assertEquals(12, initialArea, "Initial area should be 12");

        // Enlarge the triangle
        triangle.enlarge();

        // Verify the area after enlarging
        int newArea = triangle.area();
        Assertions.assertEquals(20, newArea, "Area should be 20 after enlarging");

        // Check the updated grids
        char[][] grids = triangle.getGrids();
        Assertions.assertEquals('Z', grids[0][4], "The grid at the hypotenuse should be filled with pattern after enlarge");
    }

    //@Test
    public void testAvoidConflictShapeCanvas_2jv4() throws Exception {
        // Initialize the AvoidConflictShapeCanvas
        AvoidConflictShapeCanvas canvas = new AvoidConflictShapeCanvas(15, 15);

        // Add a Circle and verify
        boolean circleAdded = canvas.addShape(1, 1, 'C', 3);
        Assertions.assertTrue(circleAdded, "Circle should be added successfully");

        // Attempt to add a RightTriangle that overlaps the existing Circle
        boolean triangleAdded = canvas.addShape(1, 1, 'T', 5, 5, 0);
        Assertions.assertFalse(triangleAdded, "RightTriangle should not be added due to conflict");

        // Add another Circle at a different location
        boolean secondCircleAdded = canvas.addShape(10, 10, 'D', 4);
        Assertions.assertTrue(secondCircleAdded, "Second Circle should be added successfully");

        // Verify the canvas state
        char[][] grid = canvas.getCanvas();
        Assertions.assertEquals('C', grid[1][1], "Canvas should contain the first Circle at (1,1)");
        Assertions.assertEquals('D', grid[10][10], "Canvas should contain the second Circle at (10,10)");
    }

    @Test
    public void testCircleShrink_rniv() throws Exception {
        // Initialize a Location and a Circle with radius 5
        Location location = new Location(1, 0);
        Circle circle = new Circle(location, '*', 5);
        
        // Access the private radius field using reflection
        Field radiusField = Circle.class.getDeclaredField("radius");
        radiusField.setAccessible(true);
        
        // Assert initial radius
        assertEquals(5, radiusField.get(circle));
        
        // Call shrink method to decrease the radius
        circle.shrink();
        
        // Assert that the radius is decreased
        assertEquals(4, radiusField.get(circle));
        
        // Get the grids after shrinking
        char[][] grids = circle.getGrids();
        
        // Assert the area should decrease (check against expected value from document)
        assertEquals(60, circle.area());
        
        // Print grids to verify the structure visually
        for (char[] grid : grids) {
            System.out.println(grid);
        }
    }

    //@Test
    public void testRightTriangleEnlarge_utse() throws Exception {
        // Initialize a Location and a RightTriangle with width 4, height 3
        Location location = new Location(0, 1);
        RightTriangle triangle = new RightTriangle(location, 'X', 4, 3, Direction.RIGHT_UP);
        
        // Access the private width and height fields using reflection
        Field widthField = RightTriangle.class.getDeclaredField("width");
        Field heightField = RightTriangle.class.getDeclaredField("height");
        widthField.setAccessible(true);
        heightField.setAccessible(true);
        
        // Assert initial dimensions
        assertEquals(4, widthField.get(triangle));
        assertEquals(3, heightField.get(triangle));
        
        // Call enlarge method to increase the dimensions
        triangle.enlarge();
        
        // Assert the dimensions are increased
        assertEquals(5, widthField.get(triangle));
        assertEquals(4, heightField.get(triangle));
        
        // Get the grids after enlarging
        char[][] grids = triangle.getGrids();
        
        // Assert the area should increase (check against expected value from document)
        assertEquals(20, triangle.area());
        
        // Print grids to verify the structure visually
        for (char[] grid : grids) {
            System.out.println(grid);
        }
    }

    @Test
    public void testOverLapShapeCanvas_svce() throws Exception {
        // Initialize OverLapShapeCanvas with dimensions 15x15
        OverLapShapeCanvas canvas = new OverLapShapeCanvas(15, 15);
        
        // Add multiple shapes to canvas
        assertTrue(canvas.addShape(0, 0, 'A', 6)); // Circle with radius 6
        assertTrue(canvas.addShape(1, 1, 'B', 5)); // Circle with radius 5
        assertTrue(canvas.addShape(2, 2, 'C', 4)); // Circle with radius 4
        assertTrue(canvas.addShape(3, 3, 'D', 3)); // Circle with radius 3
        
        // Verify the canvas content and shape count
        assertEquals(4, canvas.getShapeCount());
        
        // Get the canvas representation
        char[][] grid = canvas.getCanvas();
        
        // Print the canvas to visualize the placement of shapes
        for (char[] line : grid) {
            System.out.println(line);
        }
        
        // Assert space grid count should decrease as shapes are added
        assertTrue(canvas.getSpaceGridCount() < 15 * 15);
    }

    @Test
    public void testAvoidConflictShapeCanvas_nrrb() throws Exception {
        // Initialize AvoidConflictShapeCanvas with dimensions 20x20
        AvoidConflictShapeCanvas canvas = new AvoidConflictShapeCanvas(20, 20);
        
        // Add shapes ensuring they do not conflict
        assertTrue(canvas.addShape(0, 2, 'A', 5, 3, 1)); // RightTriangle
        assertTrue(canvas.addShape(6, 8, 'B', 5, 7, 2)); // RightTriangle
        assertFalse(canvas.addShape(0, 2, 'C', 5, 3, 1)); // Attempt to add conflicting shape
        
        // Get shapes by area
        var shapesByArea = canvas.getShapesByArea();
        
        // Assert the shapes are returned in correct order
        assertEquals("RightTriangle: (0,2) area=11 pattern=A", shapesByArea.get(0).toString());
        assertEquals("RightTriangle: (6,8) area=23 pattern=B", shapesByArea.get(1).toString());
        
        // Get the canvas representation
        char[][] grid = canvas.getCanvas();
        
        // Print the canvas to visualize the placement of shapes
        for (char[] line : grid) {
            System.out.println(line);
        }
        
        // Assert shape count is correct
        assertEquals(2, canvas.getShapeCount());
    }

    //@Test
    public void testCircleEnlargeAndShrink_2q5l() throws Exception {
        // Initialize a Circle with radius 5 at location (1, 0) with pattern '*'
        Location location = new Location(1, 0);
        Circle circle = new Circle(location, '*', 5);
        
        // Enlarge the circle
        circle.enlarge(); // radius should increase to 6
        Field radiusField = Circle.class.getDeclaredField("radius");
        radiusField.setAccessible(true);
        assertEquals(6, radiusField.getInt(circle)); // Check if radius is 6 after enlargement

        // Fill grids and assert area after enlargement
        circle.fillGrids();
        assertEquals(113, circle.area()); // Area should be updated accordingly after enlarging

        // Shrink the circle
        circle.shrink(); // radius should decrease to 5
        assertEquals(5, radiusField.getInt(circle)); // Check if radius is back to 5
        circle.fillGrids(); // Refill grids after shrinking
        assertEquals(78, circle.area()); // Area should reflect the radius of 5
    }

    //@Test
    public void testRightTriangleBehavior_6mmw() throws Exception {
        // Initialize a RightTriangle with width 4, height 3 at location (0, 1) with pattern 'X'
        Location location = new Location(0, 1);
        RightTriangle triangle = new RightTriangle(location, 'X', 4, 3, Direction.LEFT_UP);

        // Fill grids and assert area
        triangle.fillGrids();
        assertEquals(6, triangle.area()); // Area of the triangle should be 6

        // Enlarge the triangle
        triangle.enlarge(); // width and height should increase to 5 and 4
        Field widthField = RightTriangle.class.getDeclaredField("width");
        Field heightField = RightTriangle.class.getDeclaredField("height");
        widthField.setAccessible(true);
        heightField.setAccessible(true);
        assertEquals(5, widthField.getInt(triangle));
        assertEquals(4, heightField.getInt(triangle));

        // Fill grids again and assert area
        triangle.fillGrids();
        assertEquals(10, triangle.area()); // Updated area after enlarging
    }

    //@Test
    public void testShapeCanvasOverlap_6rmf() {
        // Create an OverLapShapeCanvas of size 15x15
        OverLapShapeCanvas canvas = new OverLapShapeCanvas(15, 15);
        
        // Add shapes to the canvas
        assertTrue(canvas.addShape(0, 0, 'A', 6)); // Should succeed
        assertTrue(canvas.addShape(1, 1, 'B', 5)); // Should succeed
        assertTrue(canvas.addShape(2, 2, 'C', 4)); // Should succeed
        assertTrue(canvas.addShape(3, 3, 'D', 3)); // Should succeed
        assertTrue(canvas.addShape(10, 5, 'E', 4, 6, 2)); // Should succeed
        assertTrue(canvas.addShape(14, 14, 'F', 4, 6, 3)); // Should succeed

        // Try to add overlapping shapes
        assertTrue(canvas.addShape(10, 5, '0', 3, 2, 1)); // Should succeed, overlap allowed
        assertTrue(canvas.addShape(10, 5, '1', 1, 1, 2)); // Should succeed, overlap allowed

        // Check the shape count
        assertEquals(7, canvas.getShapeCount()); // Should be 7 shapes successfully added
    }

    @Test
    public void testAvoidConflictShapeCanvas_rw86() {
        // Create an AvoidConflictShapeCanvas of size 20x20
        AvoidConflictShapeCanvas canvas = new AvoidConflictShapeCanvas(20, 20);
        
        // Add shapes to the canvas
        assertTrue(canvas.addShape(0, 2, 'A', 5, 3, 1)); // Should succeed
        assertTrue(canvas.addShape(6, 8, 'B', 5, 7, 2)); // Should succeed
        assertFalse(canvas.addShape(8, 12, 'C', 5)); // Should fail due to conflict
        assertTrue(canvas.addShape(6, 6, 'D', 5, 7, 1)); // Should succeed
        assertTrue(canvas.addShape(0, 8, 'E', 3)); // Should succeed

        // Check shapes by area
        var shapesByArea = canvas.getShapesByArea();
        assertEquals(4, shapesByArea.size()); // Should only be 4 shapes after conflict resolution
        assertEquals("RightTriangle: (0,2) area=11 pattern=A", shapesByArea.get(0).toString()); // Check area sorting
    }

    //@Test
    public void testCircleShrinkAndArea_c9ac() throws Exception {
        // Create a Location object at (1, 0)
        Location location = new Location(1, 0);
        // Create a Circle object with radius 5
        Circle circle = new Circle(location, '*', 5);
        
        // Assert initial area (expected area of circle with radius 5)
        assertEquals(78, circle.area());

        // Invoke shrink method to decrease radius
        circle.shrink();
        
        // Using reflection to access the private radius field
        Field radiusField = Circle.class.getDeclaredField("radius");
        radiusField.setAccessible(true);
        int radiusAfterShrink = (int) radiusField.get(circle);
        
        // Assert that the radius is now 4 after shrinking
        assertEquals(4, radiusAfterShrink);
        
        // Assert the area after shrinking (expected area of circle with radius 4)
        assertEquals(50, circle.area());
        
        // Invoke fillGrids to update the grid representation
        circle.fillGrids();
        char[][] grids = circle.getGrids();
        
        // Check the dimensions of the grids
        assertEquals(10, grids.length);
        assertEquals(10, grids[0].length);
        
        // Verify that the grid representation is correct for radius 4
        assertTrue(grids[5][5] == '*'); // Check center
        assertTrue(grids[5][9] == ' '); // Check boundary
    }

    //@Test
    public void testRightTriangleEnlargeAndArea_n696() throws Exception {
        // Create a Location object at (0, 1)
        Location location = new Location(0, 1);
        // Create a RightTriangle object with width 4, height 3, and direction RIGHT_UP
        RightTriangle triangle = new RightTriangle(location, 'X', 4, 3, Direction.RIGHT_UP);
        
        // Assert initial area (expected area of right triangle with base 4 and height 3)
        assertEquals(6, triangle.area());

        // Invoke enlarge method to increase dimensions
        triangle.enlarge();
        
        // Using reflection to access the private width and height fields
        Field widthField = RightTriangle.class.getDeclaredField("width");
        Field heightField = RightTriangle.class.getDeclaredField("height");
        widthField.setAccessible(true);
        heightField.setAccessible(true);
        
        int widthAfterEnlarge = (int) widthField.get(triangle);
        int heightAfterEnlarge = (int) heightField.get(triangle);
        
        // Assert that the width is now 5 and height is now 4 after enlarging
        assertEquals(5, widthAfterEnlarge);
        assertEquals(4, heightAfterEnlarge);
        
        // Assert the area after enlarging (expected area of right triangle with base 5 and height 4)
        assertEquals(10, triangle.area());
        
        // Invoke fillGrids to update the grid representation
        triangle.fillGrids();
        char[][] grids = triangle.getGrids();
        
        // Check the dimensions of the grids
        assertEquals(4, grids.length);
        assertEquals(5, grids[0].length);
        
        // Verify that the grid representation is correct for enlarged triangle
        assertTrue(grids[0][0] == 'X'); // Check right angle
        assertTrue(grids[3][4] == 'X'); // Check bottom right
    }

    //@Test
    public void testShapeCanvasAddShapeConflict_2wm2() throws Exception {
        // Create an AvoidConflictShapeCanvas with dimensions 10x10
        AvoidConflictShapeCanvas canvas = new AvoidConflictShapeCanvas(10, 10);
        
        // Add a Circle with radius 3 at position (5, 5)
        assertTrue(canvas.addShape(5, 5, 'A', 3));
        
        // Add a RightTriangle that overlaps with the Circle
        assertFalse(canvas.addShape(4, 4, 'B', 4, 4, 0)); // Should fail due to conflict
        
        // Add another RightTriangle that does not overlap
        assertTrue(canvas.addShape(0, 0, 'C', 2, 2, 0));
        
        // Check the total shape count in the canvas
        assertEquals(2, canvas.getShapeCount());
        
        // Verify the canvas representation
        char[][] canvasGrid = canvas.getCanvas();
        assertTrue(canvasGrid[5][5] == 'A'); // Circle should be present
        assertTrue(canvasGrid[0][0] == 'C'); // Triangle should be present
        assertTrue(canvasGrid[4][4] == ' '); // No shape should be here due to conflict
    }

    //@Test
    public void testShapeCanvasGetShapesByArea_qv23() throws Exception {
        // Create an OverLapShapeCanvas with dimensions 15x15
        OverLapShapeCanvas canvas = new OverLapShapeCanvas(15, 15);
        
        // Add multiple shapes to the canvas
        canvas.addShape(1, 1, 'A', 4, 4, 0); // RightTriangle
        canvas.addShape(0, 0, 'B', 3);      // Circle
        canvas.addShape(5, 5, 'C', 5, 5, 0); // RightTriangle
        
        // Get shapes sorted by area
        List<Shape> sortedShapes = canvas.getShapesByArea();
        
        // Assert the order based on area
        assertEquals("Circle: (0,0) area=28 pattern=B", sortedShapes.get(0).toString());
        assertEquals("RightTriangle: (1,1) area=8 pattern=A", sortedShapes.get(1).toString());
        assertEquals("RightTriangle: (5,5) area=12 pattern=C", sortedShapes.get(2).toString());
    }

    @Test
    public void testCircleEnlargeAndShrink_oyk7() throws Exception {
        // Arrange: Create a Circle instance with initial radius 5
        Location location = new Location(1, 0);
        Circle circle = new Circle(location, '*', 5);

        // Enlarge the circle by 1
        circle.enlarge();
        
        // Access private radius field using reflection
        Field radiusField = Circle.class.getDeclaredField("radius");
        radiusField.setAccessible(true);
        int enlargedRadius = (int) radiusField.get(circle);
        
        // Assert: Radius should be 6 after enlargement
        assertEquals(6, enlargedRadius);

        // Now shrink the circle by 1
        circle.shrink();
        
        // Get the radius again after shrinking
        int shrunkRadius = (int) radiusField.get(circle);
        
        // Assert: Radius should return back to 5 after shrinking
        assertEquals(5, shrunkRadius);
        
        // Fill the grids and get the area
        circle.fillGrids();
        assertEquals(88, circle.area()); // Area of the circle should be 88
    }

    //@Test
    public void testRightTriangleAreaAndShrink_c10e() throws Exception {
        // Arrange: Create a RightTriangle instance with width 7 and height 3
        Location location = new Location(0, 1);
        RightTriangle triangle = new RightTriangle(location, 'X', 7, 3, Direction.RIGHT_UP);
        
        // Assert: Initial area should be 15
        assertEquals(15, triangle.area());

        // Now shrink the triangle by 1
        triangle.shrink();
        
        // Assert: After shrinking, area should be updated correctly
        assertEquals(6, triangle.area()); // Area should now be 6 after shrinking
        
        // Fill the grids after shrinking
        triangle.fillGrids();
        
        // Access grids via reflection
        Field gridsField = Shape.class.getDeclaredField("grids");
        gridsField.setAccessible(true);
        char[][] grids = (char[][]) gridsField.get(triangle);
        
        // Assert: Check the grid height and width after shrinking
        assertEquals(2, grids.length); // Height should be 2 after shrinking
        assertEquals(6, grids[0].length); // Width should remain 6
    }

    @Test
    public void testCircleFillGrids_whsx() throws Exception {
        // Arrange: Create a Circle instance with radius 5
        Location location = new Location(1, 0);
        Circle circle = new Circle(location, '*', 5);
        
        // Act: Fill grids for the circle
        circle.fillGrids();
        
        // Access grids via reflection
        Field gridsField = Shape.class.getDeclaredField("grids");
        gridsField.setAccessible(true);
        char[][] grids = (char[][]) gridsField.get(circle);
        
        // Assert: Verify the correct pattern filling in the grids
        assertEquals('*', grids[5][1]); // Center of circle (5,1) should be filled
        assertEquals(' ', grids[0][0]); // Should be empty outside the circle
    }

    //@Test
    public void testOverlapShapeCanvas_qdni() throws Exception {
        // Arrange: Create an OverLapShapeCanvas instance
        OverLapShapeCanvas canvas = new OverLapShapeCanvas(15, 15);
        
        // Add shapes
        assertTrue(canvas.addShape(0, 0, 'A', 6)); // Add Circle
        assertTrue(canvas.addShape(1, 1, 'B', 5)); // Add RightTriangle
        assertTrue(canvas.addShape(2, 2, 'C', 4)); // Add another shape
        
        // Assert: The count of shapes added successfully
        assertEquals(3, canvas.getShapeCount());
        
        // Get the canvas representation
        char[][] canvasGrid = canvas.getCanvas();
        
        // Assert: Check if the canvas has the expected filled patterns
        assertEquals('A', canvasGrid[0][0]); // Should have pattern A
        assertEquals('B', canvasGrid[1][1]); // Should have pattern B
        assertEquals('C', canvasGrid[2][2]); // Should have pattern C
    }

    @Test
    public void testCircleShrinkAndArea_kkc0() throws Exception {
        // Create a Location instance at (1, 0)
        Location location = new Location(1, 0);
        // Create a Circle with radius 5 and pattern '*'
        Circle circle = new Circle(location, '*', 5);
        
        // Access the private radius field using reflection
        Field radiusField = Circle.class.getDeclaredField("radius");
        radiusField.setAccessible(true);
        
        // Verify initial area (expected area is 88 as per document)
        assertEquals(88, circle.area(), "Initial area should be 88.");
        
        // Shrink the circle, which should decrease the radius by 1
        circle.shrink();
        
        // Check if the radius has been decreased
        assertEquals(4, radiusField.getInt(circle), "Radius should be decreased to 4.");
        
        // Check the area after shrinking (expected area is 60 as per document)
        assertEquals(60, circle.area(), "Area after shrinking should be 60.");
        
        // Verify the grids after shrinking
        char[][] grids = circle.getGrids();
        assertEquals(8, grids.length, "Height of grids should be 8 after shrinking.");
        assertEquals(8, grids[0].length, "Width of grids should be 8 after shrinking.");
    }

    @Test
    public void testRightTriangleEnlargeAndArea_ffmu() throws Exception {
        // Create a Location instance at (0, 1)
        Location location = new Location(0, 1);
        // Create a RightTriangle with width 7, height 3, and pattern 'X'
        RightTriangle triangle = new RightTriangle(location, 'X', 7, 3, Direction.RIGHT_UP);
        
        // Access the private width and height fields using reflection
        Field widthField = RightTriangle.class.getDeclaredField("width");
        Field heightField = RightTriangle.class.getDeclaredField("height");
        widthField.setAccessible(true);
        heightField.setAccessible(true);
        
        // Verify initial area (expected area is 15 as per document)
        assertEquals(15, triangle.area(), "Initial area should be 15.");
        
        // Enlarge the triangle, which should increase width and height by 1
        triangle.enlarge();
        
        // Check if width and height have been increased
        assertEquals(8, widthField.getInt(triangle), "Width should be increased to 8.");
        assertEquals(4, heightField.getInt(triangle), "Height should be increased to 4.");
        
        // Check the area after enlarging (expected area is 20 as per document)
        assertEquals(20, triangle.area(), "Area after enlarging should be 20.");
        
        // Verify the grids after enlarging
        char[][] grids = triangle.getGrids();
        assertEquals(4, grids.length, "Height of grids should be 4 after enlarging.");
        assertEquals(8, grids[0].length, "Width of grids should be 8 after enlarging.");
    }

    //@Test
    public void testShapeCanvasAddShapeConflict_swni() throws Exception {
        // Create an AvoidConflictShapeCanvas with dimensions 20x20
        AvoidConflictShapeCanvas canvas = new AvoidConflictShapeCanvas(20, 20);
        
        // Add a Circle at (0, 0) with radius 5 and pattern 'A'
        assertTrue(canvas.addShape(0, 0, 'A', 5), "Should successfully add Circle A.");
        
        // Attempt to add another Circle at (0, 0) with radius 3 and pattern 'B'
        assertFalse(canvas.addShape(0, 0, 'B', 3), "Should fail to add Circle B due to conflict.");
        
        // Add a RightTriangle at (1, 1) with width 4, height 4 and pattern 'C'
        assertTrue(canvas.addShape(1, 1, 'C', 4, 4, 0), "Should successfully add RightTriangle C.");
        
        // Check the total shape count in the canvas
        assertEquals(2, canvas.getShapeCount(), "Shape count should be 2.");
        
        // Verify the canvas grid representation
        char[][] grid = canvas.getCanvas();
        assertEquals('A', grid[0][0], "Canvas should have Circle A at (0,0).");
        assertEquals('C', grid[1][1], "Canvas should have RightTriangle C at (1,1).");
    }

    //@Test
    public void testShapeCanvasSortingByAreaAndLocation_1j0j() throws Exception {
        // Create an OverLapShapeCanvas with dimensions 15x15
        OverLapShapeCanvas canvas = new OverLapShapeCanvas(15, 15);
        
        // Add shapes to the canvas
        canvas.addShape(0, 0, 'A', 6); // Circle A
        canvas.addShape(1, 1, 'B', 5); // Circle B
        canvas.addShape(2, 2, 'C', 4); // Circle C
        
        // Retrieve shapes sorted by area
        var sortedByArea = canvas.getShapesByArea();
        assertEquals("Circle: (0,0) area=132 pattern=A", sortedByArea.get(0).toString(), "First shape should be Circle A.");
        assertEquals("Circle: (1,1) area=88 pattern=B", sortedByArea.get(1).toString(), "Second shape should be Circle B.");
        assertEquals("Circle: (2,2) area=60 pattern=C", sortedByArea.get(2).toString(), "Third shape should be Circle C.");
        
        // Retrieve shapes sorted by location
        var sortedByLocation = canvas.getShapesByLocation();
        assertEquals("Circle: (0,0) area=132 pattern=A", sortedByLocation.get(0).toString(), "First shape by location should be Circle A.");
        assertEquals("Circle: (1,1) area=88 pattern=B", sortedByLocation.get(1).toString(), "Second shape by location should be Circle B.");
        assertEquals("Circle: (2,2) area=60 pattern=C", sortedByLocation.get(2).toString(), "Third shape by location should be Circle C.");
    }

    @Test
    public void testCircleShrinkAndArea_x1st() throws Exception {
        // Create a location for the circle
        Location location = new Location(1, 0);
        // Create a Circle object with a radius of 5
        Circle circle = new Circle(location, '*', 5);
        
        // Verify initial area is calculated correctly
        int initialArea = circle.area();
        assertEquals(88, initialArea, "Initial area of the circle should be 88");

        // Shrink the circle, which should decrease the radius by 1
        circle.shrink();

        // Access the private field radius using reflection
        Field radiusField = Circle.class.getDeclaredField("radius");
        radiusField.setAccessible(true);
        int radiusAfterShrink = (int) radiusField.get(circle);

        // Assert the radius is decreased
        assertEquals(4, radiusAfterShrink, "Radius should be decreased to 4 after shrinking");

        // Verify the area is updated after shrinking
        int updatedArea = circle.area();
        assertEquals(60, updatedArea, "Area of the circle after shrinking should be 60");
    }

    @Test
    public void testRightTriangleEnlargeAndArea_wudy() throws Exception {
        // Create a location for the right triangle
        Location location = new Location(0, 1);
        // Create a RightTriangle object with width 7, height 3, and direction RIGHT_UP
        RightTriangle triangle = new RightTriangle(location, 'X', 7, 3, Direction.RIGHT_UP);
        
        // Verify initial area is calculated correctly
        int initialArea = triangle.area();
        assertEquals(15, initialArea, "Initial area of the triangle should be 15");

        // Enlarge the triangle, which should increase the width and height by 1
        triangle.enlarge();

        // Access the private fields width and height using reflection
        Field widthField = RightTriangle.class.getDeclaredField("width");
        Field heightField = RightTriangle.class.getDeclaredField("height");
        widthField.setAccessible(true);
        heightField.setAccessible(true);
        int widthAfterEnlarge = (int) widthField.get(triangle);
        int heightAfterEnlarge = (int) heightField.get(triangle);

        // Assert the width and height are increased
        assertEquals(8, widthAfterEnlarge, "Width should be increased to 8 after enlarging");
        assertEquals(4, heightAfterEnlarge, "Height should be increased to 4 after enlarging");

        // Verify the area is updated after enlarging
        int updatedArea = triangle.area();
        assertEquals(20, updatedArea, "Area of the triangle after enlarging should be 20");
    }

    @Test
    public void testOverLapShapeCanvas_vutp() {
        // Create an OverLapShapeCanvas with a size of 15x15
        OverLapShapeCanvas canvas = new OverLapShapeCanvas(15, 15);
        
        // Add a Circle to the canvas and assert success
        assertTrue(canvas.addShape(5, 5, 'A', 3), "Should be able to add Circle to canvas");
        
        // Add a RightTriangle to the canvas and assert success
        assertTrue(canvas.addShape(3, 3, 'B', 4, 4, 0), "Should be able to add RightTriangle to canvas");

        // Attempt to add another Circle that overlaps with existing Circle
        assertTrue(canvas.addShape(5, 5, 'C', 3), "Should allow overlapping shapes on canvas");

        // Print the canvas to visually inspect if shapes are placed correctly
        char[][] canvasGrid = canvas.getCanvas();
        for (char[] line : canvasGrid) {
            System.out.println(line);
        }
    }

    @Test
    public void testAvoidConflictShapeCanvas_xf32() {
        // Create an AvoidConflictShapeCanvas with a size of 15x15
        AvoidConflictShapeCanvas canvas = new AvoidConflictShapeCanvas(15, 15);
        
        // Add a Circle to the canvas and assert success
        assertTrue(canvas.addShape(1, 1, 'A', 5), "Should be able to add Circle to canvas");

        // Add a RightTriangle to the canvas and assert success
        assertTrue(canvas.addShape(0, 0, 'B', 3, 3, 0), "Should be able to add RightTriangle to canvas");

        // Attempt to add another Circle that overlaps with existing Circle, assert failure
        assertFalse(canvas.addShape(1, 1, 'C', 5), "Should NOT allow overlapping shapes on canvas");

        // Print the canvas to visually inspect if shapes are placed correctly
        char[][] canvasGrid = canvas.getCanvas();
        for (char[] line : canvasGrid) {
            System.out.println(line);
        }
    }


}
