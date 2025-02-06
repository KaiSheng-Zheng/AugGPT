import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class CustomerTest_5ayt {
    private Customer customer;
    private Store store;
    private Product product;

    @BeforeEach
    public void setUp() {
        // Initialize the customer with a wallet of 100.0
        customer = new Customer("Alice", 100.0f);
        
        // Initialize a store and a product
        store = new Store("Tech Store");
        product = new Product("Laptop", 90.0f);
        
        // Add the product to the store
        store.addProduct(product);
    }

    @Test
    public void testPurchaseProduct_Success() {
        assertTrue(customer.purchaseProduct(store, product));
        assertEquals(10.0f, customer.wallet);
        assertTrue(customer.shoppingCart.contains(product));
    }

    @Test
    public void testPurchaseProduct_InsufficientFunds() {
        // Set up a product that costs more than the wallet
        Product expensiveProduct = new Product("Expensive Laptop", 150.0f);
        store.addProduct(expensiveProduct);
        
        assertFalse(customer.purchaseProduct(store, expensiveProduct));
        assertEquals(100.0f, customer.wallet); // Wallet should remain unchanged
    }

    @Test
    public void testPurchaseProduct_ProductNotAvailable() {
        Product unavailableProduct = new Product("Unavailable Product", 50.0f);
        
        assertFalse(customer.purchaseProduct(store, unavailableProduct)); // Product not in store
        assertEquals(100.0f, customer.wallet); // Wallet should remain unchanged
    }

    @Test
    public void testRateProduct_Success() {
        assertTrue(customer.rateProduct(product, 5));
        assertEquals(5.0f, product.getAvgRating());
    }

    @Test
    public void testRateProduct_InvalidRating() {
        assertFalse(customer.rateProduct(product, 6)); // Invalid rating
        assertEquals(0.0f, product.getAvgRating()); // Rating should not change
    }

    @Test
    public void testUpdateWallet() {
        customer.updateWallet(50.0f);
        assertEquals(150.0f, customer.wallet); // Wallet should be updated
    }

    @Test
    public void testViewShoppingCart() {
        customer.purchaseProduct(store, product);
        // Redirecting output to test the console output
        // In practice, you might want to capture the output to verify it matches expected output
        customer.viewShoppingCart(SortBy.Price); // Should print the product details
        // The actual verification of printed output would require a more complex setup
    }

    @Test
    public void testRefundProduct_Success() {
        customer.purchaseProduct(store, product);
        assertTrue(customer.refundProduct(product));
        assertEquals(100.0f, customer.wallet); // Wallet should return to original amount
        assertFalse(customer.shoppingCart.contains(product)); // Product should be removed from cart
    }

    @Test
    public void testRefundProduct_NotInCart() {
        Product anotherProduct = new Product("Another Product", 30.0f);
        assertFalse(customer.refundProduct(anotherProduct)); // Product not in cart
    }
}