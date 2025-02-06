import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class CustomerTest_2cts {
    private Customer customer;
    private Store store;
    private Product product;

    @BeforeEach
    public void setUp() {
        customer = new Customer("John Doe", 100.0f);
        product = new Product("Laptop", 50.0f);
        store = new Store("Tech Store");
        store.addProduct(product);
    }

    @Test
    public void testPurchaseProduct_Success() {
        assertTrue(customer.purchaseProduct(store, product));
        assertEquals(50.0f, customer.wallet);
        assertTrue(customer.shoppingCart.contains(product));
    }

    @Test
    public void testPurchaseProduct_InsufficientFunds() {
        Product expensiveProduct = new Product("Smartphone", 150.0f);
        store.addProduct(expensiveProduct);
        assertFalse(customer.purchaseProduct(store, expensiveProduct));
        assertEquals(100.0f, customer.wallet);
    }

    @Test
    public void testPurchaseProduct_ProductNotAvailable() {
        Product unavailableProduct = new Product("Tablet", 30.0f);
        assertFalse(customer.purchaseProduct(store, unavailableProduct));
        assertEquals(100.0f, customer.wallet);
    }

    @Test
    public void testRefundProduct_Success() {
        customer.purchaseProduct(store, product);
        assertTrue(customer.refundProduct(product));
        assertEquals(100.0f, customer.wallet);
        assertFalse(customer.shoppingCart.contains(product));
    }

    @Test
    public void testRefundProduct_NotInCart() {
        Product anotherProduct = new Product("Monitor", 70.0f);
        assertFalse(customer.refundProduct(anotherProduct));
        assertEquals(100.0f, customer.wallet);
    }

    @Test
    public void testRateProduct_Success() {
        assertTrue(customer.rateProduct(product, 5));
        assertEquals(5.0f, product.getAvgRating());
    }

    @Test
    public void testRateProduct_InvalidRating() {
        assertFalse(customer.rateProduct(product, 6));
        assertEquals(0.0f, product.getAvgRating());
    }

    @Test
    public void testViewShoppingCart_SortByPrice() {
        customer.purchaseProduct(store, product);
        customer.viewShoppingCart(SortBy.Price); // This will print the product details
        // Add assertions to verify printed output if necessary (e.g., using a PrintStream)
    }
}

public 