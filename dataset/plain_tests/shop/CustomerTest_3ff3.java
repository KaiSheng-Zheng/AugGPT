import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class CustomerTest_3ff3 {

    private Customer customer;
    private Store store;
    private Product product;

    @BeforeEach
    public void setUp() {
        customer = new Customer("John Doe", 100.0f);
        product = new Product("Laptop", 50.0f);
        store = new Store("Electronics Store");
        store.addProduct(product);
    }

    @Test
    public void testCustomerCreation() {
        assertNotNull(customer);
        assertEquals("John Doe", customer.getName());
        assertEquals(100.0f, customer.getWallet());
    }

    @Test
    public void testRateProduct() {
        assertTrue(customer.rateProduct(product, 5));
        assertEquals(5, product.getAvgRating(), 0.01);
    }

    @Test
    public void testRateProductInvalid() {
        assertFalse(customer.rateProduct(product, 6)); // Invalid rating
        assertEquals(0, product.getAvgRating(), 0.01);
    }

    @Test
    public void testPurchaseProductSuccess() {
        assertTrue(customer.purchaseProduct(store, product));
        assertEquals(50.0f, customer.getWallet());
        assertTrue(customer.getShoppingCart().contains(product));
    }

    @Test
    public void testPurchaseProductInsufficientFunds() {
        customer.updateWallet(-100.0f); // Reduce wallet to 0
        assertFalse(customer.purchaseProduct(store, product));
        assertEquals(0.0f, customer.getWallet());
    }

    @Test
    public void testPurchaseProductNotAvailable() {
        Product unavailableProduct = new Product("Tablet", 30.0f);
        assertFalse(customer.purchaseProduct(store, unavailableProduct));
    }

    @Test
    public void testViewShoppingCart() {
        customer.purchaseProduct(store, product);
        customer.viewShoppingCart(SortBy.Price);
        // Output can be checked manually or redirected to a stream for validation
    }

    @Test
    public void testRefundProductSuccess() {
        customer.purchaseProduct(store, product);
        assertTrue(customer.refundProduct(product));
        assertEquals(100.0f, customer.getWallet());
        assertFalse(customer.getShoppingCart().contains(product));
    }

    @Test
    public void testRefundProductNotInCart() {
        Product anotherProduct = new Product("Phone", 30.0f);
        assertFalse(customer.refundProduct(anotherProduct));
    }
}

public 