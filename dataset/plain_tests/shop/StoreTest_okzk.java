import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class StoreTest_okzk {

    private Store store;
    private Product product;

    @BeforeEach
    public void setUp() {
        store = new Store("Electronics Store");
        product = new Product("Laptop", 50.0f);
    }

    @Test
    public void testAddProduct() {
        assertTrue(store.addProduct(product));
        assertTrue(store.hasProduct(product));
    }

    @Test
    public void testAddExistingProduct() {
        store.addProduct(product);
        assertFalse(store.addProduct(product)); // Should not add duplicate
    }

    @Test
    public void testRemoveProduct() {
        store.addProduct(product);
        assertTrue(store.removeProduct(product));
        assertFalse(store.hasProduct(product));
    }

    @Test
    public void testRemoveNonExistingProduct() {
        assertFalse(store.removeProduct(product));
    }
}