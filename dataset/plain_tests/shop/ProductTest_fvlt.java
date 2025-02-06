import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class ProductTest_fvlt {
    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product("Headphones", 20.0f);
    }

    @Test
    public void testSetRating_Success() {
        assertTrue(product.setRating(4));
        assertEquals(4.0f, product.getAvgRating());
    }

    @Test
    public void testSetRating_Invalid() {
        assertFalse(product.setRating(6));
        assertEquals(0.0f, product.getAvgRating());
    }

    @Test
    public void testGetAvgRating_NoRatings() {
        assertEquals(0.0f, product.getAvgRating());
    }
}