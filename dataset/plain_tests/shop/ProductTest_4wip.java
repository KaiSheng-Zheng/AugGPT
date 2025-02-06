import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class ProductTest_4wip {

    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product("Laptop", 50.0f);
    }

    @Test
    public void testProductCreation() {
        assertNotNull(product);
        assertEquals("Laptop", product.getName());
        assertEquals(50.0f, product.getPrice());
    }

    @Test
    public void testSetRating() {
        assertTrue(product.setRating(4));
        assertEquals(4, product.getAvgRating(), 0.01);
    }

    @Test
    public void testSetInvalidRating() {
        assertFalse(product.setRating(6)); // Invalid rating
        assertEquals(0, product.getAvgRating(), 0.01);
    }

    @Test
    public void testGetAvgRatingWithMultipleRatings() {
        product.setRating(3);
        product.setRating(5);
        assertEquals(4.0f, product.getAvgRating(), 0.01);
    }
}