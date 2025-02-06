import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class StoreTest_yd6o {
    private Store store;
    private Product product;

    @BeforeEach
    void setUp() {
        store = new Store("Grocery Store");
        product = new Product("Bread", 2.5f);
        store.addProduct(product);
    }

    @Test
    void testHasProduct() {
        assertTrue(store.hasProduct(product));
        assertFalse(store.hasProduct(new Product("Milk", 1.5f))); // Not added
    }

    @Test
    void testTransact() {
        assertTrue(store.hasProduct(product));
        store.transact(product, 0); // Sale
        assertFalse(store.hasProduct(product)); // Should be removed
        assertEquals(2.5f, store.income, 0.01);
        
        // Now, test for refund
        store.transact(product, 1); // Refund
        assertTrue(store.hasProduct(product)); // Should be added back
        assertEquals(0.0f, store.income, 0.01);
    }
}