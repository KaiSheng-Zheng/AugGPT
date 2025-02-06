import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class ProductTest_zllt {
    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Smartphone", 500.0f);
    }

    @Test
    void testSetRating() {
        assertTrue(product.setRating(4));
        assertFalse(product.setRating(6)); // Invalid rating
        assertEquals(4.0f, product.getAvgRating(), 0.01);
    }

    @Test
    void testGetAvgRating() {
        product.setRating(5);
        product.setRating(3);
        assertEquals(4.0f, product.getAvgRating(), 0.01);
    }

    //@Test
    void testToString() {
        assertEquals("Product ID 1, Smartphone, RMB 500.00, Rating 0.0", product.toString());
    }

    @Test
    void testGetPrice() {
        assertEquals(500.0f, product.getPrice(), 0.01);
    }

    //@Test
    void testGetId() {
        assertEquals(1, product.getId());
    }
}
