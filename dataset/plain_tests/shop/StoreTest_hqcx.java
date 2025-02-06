import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class StoreTest_hqcx {
    private Store store;
    private Product product;

    @BeforeEach
    public void setUp() {
        store = new Store("Grocery Store");
        product = new Product("Apple", 1.0f);
    }

    @Test
    public void testAddProduct_Success() {
        assertTrue(store.addProduct(product));
        assertTrue(store.hasProduct(product));
    }

    @Test
    public void testAddProduct_AlreadyExists() {
        store.addProduct(product);
        assertFalse(store.addProduct(product));
    }

    @Test
    public void testRemoveProduct_Success() {
        store.addProduct(product);
        assertTrue(store.removeProduct(product));
        assertFalse(store.hasProduct(product));
    }

    @Test
    public void testRemoveProduct_NotExists() {
        assertFalse(store.removeProduct(product));
    }
}