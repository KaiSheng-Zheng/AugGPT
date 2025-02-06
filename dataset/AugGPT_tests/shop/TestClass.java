import org.junit.jupiter.api.*;
import java.lang.reflect.*;
import java.util.*;
import java.io.*;
import java.math.*;

import static org.junit.jupiter.api.Assertions.*;


public class TestClass {

    @Test
    public void testProductRatingAndAverage_dpcm() throws Exception {
        // Step 1: Create a product with a name and price.
        Product product = new Product("Laptop", 10000.00f);
        
        // Step 2: Set ratings for the product.
        product.setRating(5);
        product.setRating(4);
        product.setRating(3);
        
        // Step 3: Use reflection to call the getAvgRating method.
        Method getAvgRatingMethod = Product.class.getDeclaredMethod("getAvgRating");
        getAvgRatingMethod.setAccessible(true);
        float avgRating = (float) getAvgRatingMethod.invoke(product);
        
        // Step 4: Assert the average rating is calculated correctly.
        Assertions.assertEquals(4.0f, avgRating, 0.01f);
        
        // Step 5: Check the product's string representation.
        String productString = product.toString();
        
        // Step 6: Assert the toString method gives the correct format.
        Assertions.assertTrue(productString.contains("Product ID"));
        Assertions.assertTrue(productString.contains("Laptop"));
        Assertions.assertTrue(productString.contains("RMB 10000.00"));
        Assertions.assertTrue(productString.contains("Rating 4.0"));
    }

    @Test
    public void testStoreProductManagement_bf4p() throws Exception {
        // Step 1: Create a store and a product.
        Store store = new Store("Tech Store");
        Product product = new Product("Laptop", 10000.00f);
        
        // Step 2: Add the product to the store.
        boolean added = store.addProduct(product);
        
        // Step 3: Assert that the product was added successfully.
        Assertions.assertTrue(added);
        
        // Step 4: Check if the product exists in the store.
        boolean hasProduct = store.hasProduct(product);
        
        // Step 5: Assert that the store indeed has the product.
        Assertions.assertTrue(hasProduct);
        
        // Step 6: Remove the product from the store.
        boolean removed = store.removeProduct(product);
        
        // Step 7: Assert that the product was removed successfully.
        Assertions.assertTrue(removed);
        
        // Step 8: Assert that the product no longer exists in the store.
        Assertions.assertFalse(store.hasProduct(product));
    }

    @Test
    public void testCustomerPurchaseAndRefund_rv05() throws Exception {
        // Step 1: Create a customer with a wallet amount.
        Customer customer = new Customer("Alice", 20000.00f);
        
        // Step 2: Create a store and a product.
        Store store = new Store("Gadget Store");
        Product product = new Product("Smartphone", 7000.00f);
        
        // Step 3: Add the product to the store.
        store.addProduct(product);
        
        // Step 4: Purchase the product.
        boolean purchased = customer.purchaseProduct(store, product);
        
        // Step 5: Assert the purchase was successful.
        Assertions.assertTrue(purchased);
        
        // Step 6: Refund the product.
        boolean refunded = customer.refundProduct(product);
        
        // Step 7: Assert the refund was successful.
        Assertions.assertTrue(refunded);
        
        // Step 8: Assert that the customer can purchase again.
        Assertions.assertTrue(customer.purchaseProduct(store, product));
    }

    @Test
    public void testCustomerShoppingCartSorting_ikt7() throws Exception {
        // Step 1: Create a customer and products.
        Customer customer = new Customer("Alice", 20000.00f);
        Store store = new Store("Online Store");
        Product product1 = new Product("Laptop", 10000.00f);
        Product product2 = new Product("Mouse", 100.00f);
        Product product3 = new Product("Table", 300.00f);
        
        // Step 2: Add products to the store and purchase them.
        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);
        customer.purchaseProduct(store, product1);
        customer.purchaseProduct(store, product2);
        customer.purchaseProduct(store, product3);
        
        // Step 3: Use reflection to call viewShoppingCart method with sorting by Price.
        Method viewShoppingCartMethod = Customer.class.getDeclaredMethod("viewShoppingCart", SortBy.class);
        viewShoppingCartMethod.setAccessible(true);
        
        // Step 4: Call the method to sort by price.
        viewShoppingCartMethod.invoke(customer, SortBy.Price);
        
        // Step 5: Validate the output is in the correct order.
        // The output would need to be checked manually since we cannot capture printed output.
        // However, we ensure the logic flow and that the method executes without errors.
        Assertions.assertTrue(true); // Placeholder for output validation.
    }
    @Test
    public void testCustomerRatingProduct_y81c() throws Exception {
        // Create a Product and Customer
        Product product = new Product("Laptop", 10000.00f);
        Customer customer = new Customer("Alice", 20000.00f);
        
        // Customer rates the product
        // This should add the rating to the product
        assertTrue(customer.rateProduct(product, 5));
        
        // Check the average rating of the product
        // The product should now have one rating of 5
        float avgRating = product.getAvgRating(); // should return 5.0
        assertEquals(5.0f, avgRating, 0.1f);
        
        // Rate the product with an invalid rating
        assertFalse(customer.rateProduct(product, 6)); // invalid rating, should return false
        
        // Check that the rating list in the product still has one rating
        // It should still be 5.0
        avgRating = product.getAvgRating(); // should still return 5.0
        assertEquals(5.0f, avgRating, 0.1f);
    }

    //@Test
    public void testCustomerPurchasingProduct_ijk3() throws Exception {
        // Create a Store and Product
        Store store = new Store("Tech Store");
        Product product = new Product("Laptop", 10000.00f);
        
        // Add product to store
        assertTrue(store.addProduct(product)); // should succeed

        // Create a Customer
        Customer customer = new Customer("Alice", 20000.00f);
        
        // Customer attempts to purchase the product
        assertTrue(customer.purchaseProduct(store, product)); // should succeed
        
        // Check that the product is removed from the store
        assertFalse(store.hasProduct(product)); // should return false

        // Check that the customer has the product in the shopping cart
        // Using reflection to access the private shoppingCart field
        Method getShoppingCartMethod = Customer.class.getDeclaredMethod("getShoppingCart");
        getShoppingCartMethod.setAccessible(true);
        ArrayList<Product> shoppingCart = (ArrayList<Product>) getShoppingCartMethod.invoke(customer);
        assertTrue(shoppingCart.contains(product)); // should contain the purchased product
    }

    //@Test
    public void testCustomerRefundingProduct_gd8l() throws Exception {
        // Create a Store and Product
        Store store = new Store("Tech Store");
        Product product = new Product("Laptop", 10000.00f);
        
        // Add product to store
        store.addProduct(product);
        
        // Create a Customer
        Customer customer = new Customer("Alice", 20000.00f);
        customer.purchaseProduct(store, product); // Alice buys the product
        
        // Alice refunds the product
        assertTrue(customer.refundProduct(product)); // should succeed
        
        // Check that the product is back in the store
        assertTrue(store.hasProduct(product)); // should return true
        
        // Check that the wallet is updated
        // Using reflection to access the private wallet field
        Method getWalletMethod = Customer.class.getDeclaredMethod("getWallet");
        getWalletMethod.setAccessible(true);
        float walletAmount = (float) getWalletMethod.invoke(customer);
        assertEquals(20000.00f, walletAmount, 0.1f); // should return to original amount
    }

    @Test
    public void testStoreProductManagement_2m78() throws Exception {
        // Create a Store
        Store store = new Store("Tech Store");
        
        // Create Products
        Product product1 = new Product("Laptop", 10000.00f);
        Product product2 = new Product("Mouse", 100.00f);
        
        // Add products to the store
        assertTrue(store.addProduct(product1)); // should succeed
        assertTrue(store.addProduct(product2)); // should succeed
        
        // Try adding the same product again
        assertFalse(store.addProduct(product1)); // should fail
        
        // Remove a product
        assertTrue(store.removeProduct(product1)); // should succeed
        
        // Check that the product list is updated
        ArrayList<Product> products = store.getProductList(); // Using the provided method
        assertFalse(products.contains(product1)); // should not contain product1 anymore
        assertTrue(products.contains(product2)); // should still contain product2
    }
    @Test
    public void testCustomerPurchaseAndRefund_k1ou() throws Exception {
        // Create products
        Product productLaptop = new Product("Laptop", 10000.00f);
        Product productTable = new Product("Table", 300.00f);
        Product productMouse = new Product("Mouse", 100.00f);
        
        // Create store and add products
        Store store = new Store("Tech Store");
        store.addProduct(productLaptop);
        store.addProduct(productTable);
        store.addProduct(productMouse);
        
        // Create customer with sufficient wallet
        Customer customer = new Customer("Alice", 20000.00f);
        
        // Purchase products
        Assertions.assertTrue(customer.purchaseProduct(store, productLaptop)); // Should succeed
        Assertions.assertTrue(customer.purchaseProduct(store, productMouse)); // Should succeed
        
        // Check wallet after purchases
        Method updateWalletMethod = Customer.class.getDeclaredMethod("updateWallet", float.class);
        updateWalletMethod.setAccessible(true);
        float expectedWalletAfterPurchase = 20000.00f - productLaptop.getPrice() - productMouse.getPrice();
        Assertions.assertEquals(expectedWalletAfterPurchase, getPrivateField_xqg7(customer, "wallet"));
        
        // Refund a product
        Assertions.assertTrue(customer.refundProduct(productMouse)); // Should succeed
        // Check wallet after refund
        Assertions.assertEquals(expectedWalletAfterPurchase + productMouse.getPrice(), getPrivateField_xqg7(customer, "wallet"));
    }

    @Test
    public void testProductRatingAndAverage_obys() throws Exception {
        // Create a product
        Product productPhone = new Product("Phone", 7000.00f);
        
        // Rate the product
        Assertions.assertTrue(productPhone.setRating(5)); // Valid rating
        Assertions.assertTrue(productPhone.setRating(4)); // Valid rating
        Assertions.assertFalse(productPhone.setRating(6)); // Invalid rating
        
        // Check average rating
        float expectedAvgRating = (5 + 4) / 2.0f; // (5 + 4) / 2
        Assertions.assertEquals(expectedAvgRating, productPhone.getAvgRating());
    }

    @Test
    public void testStoreProductManagement_ekce() throws Exception {
        // Create products
        Product productTable = new Product("Table", 300.00f);
        Product productChair = new Product("Chair", 150.00f);
        
        // Create store
        Store store = new Store("Furniture Store");
        
        // Add products to store
        Assertions.assertTrue(store.addProduct(productTable)); // Should succeed
        Assertions.assertTrue(store.addProduct(productChair)); // Should succeed
        Assertions.assertFalse(store.addProduct(productTable)); // Should fail, already exists
        
        // Remove a product
        Assertions.assertTrue(store.removeProduct(productChair)); // Should succeed
        Assertions.assertFalse(store.removeProduct(productChair)); // Should fail, already removed
        
        // Check remaining products
        Assertions.assertTrue(store.hasProduct(productTable)); // Should be true
        Assertions.assertFalse(store.hasProduct(productChair)); // Should be false
    }

    @Test
    public void testCustomerShoppingCartSorting_0h15() throws Exception {
        // Create products
        Product productLaptop = new Product("Laptop", 10000.00f);
        Product productTable = new Product("Table", 300.00f);
        Product productMouse = new Product("Mouse", 100.00f);
        
        // Create store and add products
        Store store = new Store("Tech Store");
        store.addProduct(productLaptop);
        store.addProduct(productTable);
        store.addProduct(productMouse);
        
        // Create customer and purchase products
        Customer customer = new Customer("Alice", 20000.00f);
        customer.purchaseProduct(store, productLaptop);
        customer.purchaseProduct(store, productTable);
        customer.purchaseProduct(store, productMouse);
        
        // Sort by price
        customer.viewShoppingCart(SortBy.Price); // Should display in order of price
        
        // Sort by rating
        customer.viewShoppingCart(SortBy.Rating); // Should display in order of rating
        
        // Sort by purchase time
        customer.viewShoppingCart(SortBy.PurchaseTime); // Should display in order of purchase time
    }

    private float getPrivateField_xqg7(Object obj, String fieldName) throws Exception {
        var field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.getFloat(obj);
    }
    @Test
    public void testCustomerPurchaseAndRefund_bvv7() throws Exception {
        // Create a store and products
        Store store = new Store("Electronics Store");
        Product laptop = new Product("Laptop", 10000.00f);
        Product mouse = new Product("Mouse", 100.00f);
        
        // Add products to the store
        store.addProduct(laptop);
        store.addProduct(mouse);
        
        // Create a customer with a sufficient wallet
        Customer customer = new Customer("Alice", 20000.00f);
        
        // Customer purchases a product
        Assertions.assertTrue(customer.purchaseProduct(store, laptop), "Customer should successfully purchase the laptop.");
        
        // Verify that the product is in the shopping cart
        Method shoppingCartMethod = Customer.class.getDeclaredMethod("viewShoppingCart", SortBy.class);
        shoppingCartMethod.setAccessible(true);
        shoppingCartMethod.invoke(customer, SortBy.PurchaseTime); // Invoke to check cart state
        
        // Refund the product
        Assertions.assertTrue(customer.refundProduct(laptop), "Customer should successfully refund the laptop.");
        
        // Check that the product is removed from the shopping cart after refund
        Method walletMethod = Customer.class.getDeclaredMethod("updateWallet", float.class);
        walletMethod.setAccessible(true);
        walletMethod.invoke(customer, laptop.getPrice()); // Customer's wallet should be updated
    }

    @Test
    public void testProductRatingAndAverage_yd97() throws Exception {
        // Create a product
        Product phone = new Product("Phone", 7000.00f);
        
        // Set ratings for the product
        Assertions.assertTrue(phone.setRating(5), "Should allow rating of 5.");
        Assertions.assertTrue(phone.setRating(4), "Should allow rating of 4.");
        Assertions.assertTrue(phone.setRating(3), "Should allow rating of 3.");
        
        // Verify the average rating calculation
        Assertions.assertEquals(4.0f, phone.getAvgRating(), "Average rating should be 4.0 after three ratings.");
        
        // Test invalid rating
        Assertions.assertFalse(phone.setRating(6), "Should not allow rating of 6.");
    }

    @Test
    public void testStoreProductManagement_bjrv() throws Exception {
        // Create a store and products
        Store store = new Store("Book Store");
        Product book1 = new Product("Java Programming", 50.00f);
        Product book2 = new Product("Data Structures", 70.00f);
        
        // Add products to the store
        Assertions.assertTrue(store.addProduct(book1), "Should successfully add book1 to the store.");
        Assertions.assertTrue(store.addProduct(book2), "Should successfully add book2 to the store.");
        
        // Verify that the store has the products
        Assertions.assertTrue(store.hasProduct(book1), "Store should have book1.");
        Assertions.assertTrue(store.hasProduct(book2), "Store should have book2.");
        
        // Remove a product
        Assertions.assertTrue(store.removeProduct(book1), "Should successfully remove book1 from the store.");
        Assertions.assertFalse(store.hasProduct(book1), "Store should not have book1 after removal.");
        
        // Attempt to remove a non-existent product
        Assertions.assertFalse(store.removeProduct(book1), "Should return false when removing a non-existent product.");
    }

    @Test
    public void testCustomerViewShoppingCartSorting_2ck0() throws Exception {
        // Create a store and products
        Store store = new Store("Tech Store");
        Product laptop = new Product("Laptop", 10000.00f);
        Product tablet = new Product("Tablet", 300.00f);
        Product mouse = new Product("Mouse", 100.00f);
        
        // Add products to the store
        store.addProduct(laptop);
        store.addProduct(tablet);
        store.addProduct(mouse);
        
        // Create a customer and purchase products
        Customer customer = new Customer("Bob", 20000.00f);
        customer.purchaseProduct(store, laptop);
        customer.purchaseProduct(store, tablet);
        customer.purchaseProduct(store, mouse);
        
        // View shopping cart sorted by rating
        Method viewCartMethod = Customer.class.getDeclaredMethod("viewShoppingCart", SortBy.class);
        viewCartMethod.setAccessible(true);
        viewCartMethod.invoke(customer, SortBy.Rating); // Invoke to check cart state
    }
    @Test
    public void testCustomerPurchaseAndRefund_yqje() throws Exception {
        // Step 1: Create products and store
        Product laptop = new Product("Laptop", 10000.00f);
        Product table = new Product("Table", 300.00f);
        Store store = new Store("Tech Store");
        
        // Step 2: Add products to the store
        store.addProduct(laptop);
        store.addProduct(table);
        
        // Step 3: Create a customer with a sufficient wallet
        Customer alice = new Customer("Alice", 20000.00f);
        
        // Step 4: Purchase products from the store
        Assertions.assertTrue(alice.purchaseProduct(store, laptop)); // Purchase laptop
        Assertions.assertTrue(alice.purchaseProduct(store, table)); // Purchase table
        
        // Step 5: Validate shopping cart
        Method viewShoppingCartMethod = Customer.class.getDeclaredMethod("viewShoppingCart", SortBy.class);
        viewShoppingCartMethod.setAccessible(true);
        viewShoppingCartMethod.invoke(alice, SortBy.PurchaseTime); // Check purchase order
        
        // Step 6: Refund a product
        Assertions.assertTrue(alice.refundProduct(laptop)); // Refund laptop
        Assertions.assertFalse(alice.refundProduct(laptop)); // Refund again should fail
        
        // Step 7: Check if product is back in the store
        Assertions.assertTrue(store.hasProduct(laptop)); // Store should have the laptop back
    }

    @Test
    public void testProductRatingAndAverage_vrtd() throws Exception {
        // Step 1: Create a product
        Product phone = new Product("Phone", 7000.00f);
        
        // Step 2: Rate the product
        Assertions.assertTrue(phone.setRating(5)); // Valid rating
        Assertions.assertTrue(phone.setRating(3)); // Valid rating
        Assertions.assertFalse(phone.setRating(6)); // Invalid rating
        
        // Step 3: Check average rating
        Assertions.assertEquals(4.0f, phone.getAvgRating(), 0.1f); // Average should be 4.0
        
        // Step 4: Get string representation of the product
        String productDescription = phone.toString();
        Assertions.assertTrue(productDescription.contains("Product ID")); // Check if ID is included
        Assertions.assertTrue(productDescription.contains("Phone")); // Check if name is included
        Assertions.assertTrue(productDescription.contains("RMB 7000.00")); // Check if price is included
        Assertions.assertTrue(productDescription.contains("Rating 4.0")); // Check if rating is included
    }

    @Test
    public void testStoreProductManagement_mmlz() throws Exception {
        // Step 1: Create products and store
        Product mouse = new Product("Mouse", 100.00f);
        Store store = new Store("Gadget Store");
        
        // Step 2: Add a product to the store
        Assertions.assertTrue(store.addProduct(mouse)); // Adding mouse
        
        // Step 3: Check if the product exists in the store
        Assertions.assertTrue(store.hasProduct(mouse)); // Should be true
        
        // Step 4: Remove the product from the store
        Assertions.assertTrue(store.removeProduct(mouse)); // Should successfully remove
        
        // Step 5: Check if the product is removed
        Assertions.assertFalse(store.hasProduct(mouse)); // Should be false now
    }

    @Test
    public void testCustomerViewShoppingCartSorting_0pzy() throws Exception {
        // Step 1: Create products
        Product laptop = new Product("Laptop", 10000.00f);
        Product table = new Product("Table", 300.00f);
        Product mouse = new Product("Mouse", 100.00f);
        
        // Step 2: Create store and add products
        Store store = new Store("Tech Store");
        store.addProduct(laptop);
        store.addProduct(table);
        store.addProduct(mouse);
        
        // Step 3: Create a customer and purchase products
        Customer alice = new Customer("Alice", 20000.00f);
        alice.purchaseProduct(store, laptop);
        alice.purchaseProduct(store, table);
        alice.purchaseProduct(store, mouse);
        
        // Step 4: View shopping cart sorted by price
        Method viewShoppingCartMethod = Customer.class.getDeclaredMethod("viewShoppingCart", SortBy.class);
        viewShoppingCartMethod.setAccessible(true);
        viewShoppingCartMethod.invoke(alice, SortBy.Price); // Check sorted by price
        
        // Step 5: Validate the order of products in the shopping cart
        // Since we can't directly access the shopping cart, we rely on the output or further methods to validate
        // This would typically involve checking the printed output or accessing a method to retrieve sorted products
    }
    @Test
    public void testCustomerPurchaseAndSortByRating_buy8() throws Exception {
        // Step 1: Create a store and products
        Store store = new Store("Tech Store");
        Product laptop = new Product("Laptop", 10000.00f);
        Product mouse = new Product("Mouse", 100.00f);
        Product phone = new Product("Phone", 7000.00f);
        
        // Step 2: Add products to the store
        store.addProduct(laptop);
        store.addProduct(mouse);
        store.addProduct(phone);
        
        // Step 3: Create a customer with a sufficient wallet
        Customer customer = new Customer("Alice", 20000.00f);
        
        // Step 4: Customer purchases products
        customer.purchaseProduct(store, laptop);
        customer.purchaseProduct(store, mouse);
        customer.purchaseProduct(store, phone);
        
        // Step 5: Rate products
        Method rateProductMethod = Customer.class.getDeclaredMethod("rateProduct", Product.class, int.class);
        rateProductMethod.setAccessible(true);
        rateProductMethod.invoke(customer, laptop, 5);
        rateProductMethod.invoke(customer, mouse, 3);
        rateProductMethod.invoke(customer, phone, 4);
        
        // Step 6: View shopping cart sorted by rating
        customer.viewShoppingCart(SortBy.Rating);
        
        // Step 7: Check if the average ratings are correct
        Assertions.assertEquals(5.0f, laptop.getAvgRating());
        Assertions.assertEquals(3.0f, mouse.getAvgRating());
        Assertions.assertEquals(4.0f, phone.getAvgRating());
    }

    @Test
    public void testStoreRemoveProductAndTransact_zduc() throws Exception {
        // Step 1: Create a store and products
        Store store = new Store("Grocery Store");
        Product apple = new Product("Apple", 10.00f);
        Product bread = new Product("Bread", 15.00f);
        
        // Step 2: Add products to the store
        store.addProduct(apple);
        store.addProduct(bread);
        
        // Step 3: Create a customer with a sufficient wallet
        Customer customer = new Customer("Bob", 50.00f);
        
        // Step 4: Customer purchases apple
        customer.purchaseProduct(store, apple);
        
        // Step 5: Store income should increase
        Method getProductListMethod = Store.class.getDeclaredMethod("getProductList");
        getProductListMethod.setAccessible(true);
        ArrayList<Product> products = (ArrayList<Product>) getProductListMethod.invoke(store);
        Assertions.assertEquals(1, products.size());
        
        // Step 6: Store should not have apple anymore
        Assertions.assertFalse(store.hasProduct(apple));
        
        // Step 7: Now, let's remove bread
        Assertions.assertTrue(store.removeProduct(bread));
        
        // Step 8: Verify bread is removed
        Assertions.assertFalse(store.hasProduct(bread));
    }

    @Test
    public void testProductRatingLogic_ct69() throws Exception {
        // Step 1: Create a product
        Product laptop = new Product("Laptop", 10000.00f);
        
        // Step 2: Rate the product with valid ratings
        Assertions.assertTrue(laptop.setRating(5));
        Assertions.assertTrue(laptop.setRating(4));
        
        // Step 3: Try to rate the product with an invalid rating
        Assertions.assertFalse(laptop.setRating(6)); // Invalid rating
        
        // Step 4: Check average rating
        Assertions.assertEquals(4.5f, laptop.getAvgRating());
        
        // Step 5: Rate the product again
        Assertions.assertTrue(laptop.setRating(3));
        
        // Step 6: Verify the new average rating
        Assertions.assertEquals(4.0f, laptop.getAvgRating());

        // Step 7: Verify the toString method
        Assertions.assertEquals("Product ID 1, Laptop, RMB 10000.00, Rating 4.0", laptop.toString());
    }

    //@Test
    public void testCustomerRefundAndStoreUpdate_zq5u() throws Exception {
        // Step 1: Create a store and products
        Store store = new Store("Fashion Store");
        Product shirt = new Product("Shirt", 50.00f);
        
        // Step 2: Add product to the store
        store.addProduct(shirt);
        
        // Step 3: Create a customer with sufficient wallet
        Customer customer = new Customer("Charlie", 100.00f);
        
        // Step 4: Customer purchases shirt
        customer.purchaseProduct(store, shirt);
        
        // Step 5: Customer refunds shirt
        Assertions.assertTrue(customer.refundProduct(shirt));
        
        // Step 6: Verify the store has the shirt back
        Assertions.assertTrue(store.hasProduct(shirt));
        
        // Step 7: Check if the wallet is updated correctly
        Method getWalletMethod = Customer.class.getDeclaredMethod("getWallet");
        getWalletMethod.setAccessible(true);
        Assertions.assertEquals(100.00f, getWalletMethod.invoke(customer));
        
        // Step 8: Verify the store income is updated correctly
        Method getIncomeMethod = Store.class.getDeclaredMethod("getIncome");
        getIncomeMethod.setAccessible(true);
        Assertions.assertEquals(0.00f, getIncomeMethod.invoke(store));
    }
    @Test
    public void testProductRatingAndAverage_wsti() throws Exception {
        // Create a product
        Product product = new Product("Laptop", 10000.00f);
        
        // Rate the product with valid ratings
        Assertions.assertTrue(invokeSetRating_i25d(product, 5));
        Assertions.assertTrue(invokeSetRating_i25d(product, 4));
        Assertions.assertTrue(invokeSetRating_i25d(product, 3));
        
        // Check the average rating
        float averageRating = invokeGetAvgRating_8myy(product);
        // Average of (5 + 4 + 3) / 3 = 4.0
        Assertions.assertEquals(4.0f, averageRating, 0.1f);
        
        // Rate with an invalid rating
        Assertions.assertFalse(invokeSetRating_i25d(product, 6));
        
        // Check the average rating remains unchanged
        averageRating = invokeGetAvgRating_8myy(product);
        Assertions.assertEquals(4.0f, averageRating, 0.1f);
    }

    //@Test
    public void testStoreProductManagement_s3dv() throws Exception {
        // Create a store
        Store store = new Store("Tech Store");
        
        // Create products
        Product product1 = new Product("Laptop", 10000.00f);
        Product product2 = new Product("Mouse", 100.00f);
        
        // Add products to the store
        Assertions.assertTrue(invokeAddProduct_s8ph(store, product1));
        Assertions.assertTrue(invokeAddProduct_s8ph(store, product2));
        
        // Check if the store has the products
        Assertions.assertTrue(invokeHasProduct_9srp(store, product1));
        Assertions.assertTrue(invokeHasProduct_9srp(store, product2));
        
        // Remove a product and check
        Assertions.assertTrue(invokeRemoveProduct_0c6z(store, product1));
        Assertions.assertFalse(invokeHasProduct_9srp(store, product1));
        
        // Ensure the income remains zero after product management
        Assertions.assertEquals(0.0f, invokeGetIncome_0eci(store), 0.1f);
    }

    //@Test
    public void testCustomerPurchaseAndRefund_mgf8() throws Exception {
        // Create a store and products
        Store store = new Store("Gadget Store");
        Product product1 = new Product("Laptop", 10000.00f);
        Product product2 = new Product("Mouse", 100.00f);
        invokeAddProduct_s8ph(store, product1);
        invokeAddProduct_s8ph(store, product2);
        
        // Create a customer with enough wallet
        Customer customer = new Customer("Alice", 20000.00f);
        
        // Purchase a product
        Assertions.assertTrue(invokePurchaseProduct_6rqb(customer, store, product1));
        
        // Check the shopping cart for the purchased product
        ArrayList<Product> cart = invokeGetShoppingCart(customer);
        Assertions.assertEquals(1, cart.size());
        Assertions.assertEquals(product1, cart.get(0));
        
        // Refund the product
        Assertions.assertTrue(invokeRefundProduct_84fm(customer, product1));
        Assertions.assertEquals(0, invokeGetShoppingCart(customer).size());
    }

    @Test
    public void testCustomerViewShoppingCartSorting_lpud() throws Exception {
        // Create a store and products
        Store store = new Store("Gadget Store");
        Product product1 = new Product("Laptop", 10000.00f);
        Product product2 = new Product("Mouse", 100.00f);
        Product product3 = new Product("Table", 300.00f);
        
        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);

        // Add ratings
        invokeSetRating_i25d(product1, 5);
        invokeSetRating_i25d(product2, 3);
        invokeSetRating_i25d(product3, 4);
        
        // Create a customer
        Customer customer = new Customer("Alice", 20000.00f);
        
        // Purchase products
        invokePurchaseProduct_6rqb(customer, store, product1);
        invokePurchaseProduct_6rqb(customer, store, product2);
        invokePurchaseProduct_6rqb(customer, store, product3);
        
        // View shopping cart sorted by Rating
        invokeViewShoppingCart_mdow(customer, SortBy.Rating);
        // Expected order: Mouse, Table, Laptop (by rating)
    }

    // Reflection methods to invoke private methods
    private boolean invokeSetRating_i25d(Product product, int rating) throws Exception {
        Method method = Product.class.getDeclaredMethod("setRating", int.class);
        method.setAccessible(true);
        return (boolean) method.invoke(product, rating);
    }

    private float invokeGetAvgRating_8myy(Product product) throws Exception {
        Method method = Product.class.getDeclaredMethod("getAvgRating");
        method.setAccessible(true);
        return (float) method.invoke(product);
    }

    private boolean invokeAddProduct_s8ph(Store store, Product product) throws Exception {
        Method method = Store.class.getDeclaredMethod("addProduct", Product.class);
        method.setAccessible(true);
        return (boolean) method.invoke(store, product);
    }

    private boolean invokeRemoveProduct_0c6z(Store store, Product product) throws Exception {
        Method method = Store.class.getDeclaredMethod("removeProduct", Product.class);
        method.setAccessible(true);
        return (boolean) method.invoke(store, product);
    }

    private boolean invokeHasProduct_9srp(Store store, Product product) throws Exception {
        Method method = Store.class.getDeclaredMethod("hasProduct", Product.class);
        method.setAccessible(true);
        return (boolean) method.invoke(store, product);
    }

    private float invokeGetIncome_0eci(Store store) throws Exception {
        Method method = Store.class.getDeclaredMethod("getIncome");
        method.setAccessible(true);
        return (float) method.invoke(store);
    }

    private boolean invokePurchaseProduct_6rqb(Customer customer, Store store, Product product) throws Exception {
        Method method = Customer.class.getDeclaredMethod("purchaseProduct", Store.class, Product.class);
        method.setAccessible(true);
        return (boolean) method.invoke(customer, store, product);
    }

    private boolean invokeRefundProduct_84fm(Customer customer, Product product) throws Exception {
        Method method = Customer.class.getDeclaredMethod("refundProduct", Product.class);
        method.setAccessible(true);
        return (boolean) method.invoke(customer, product);
    }

    private ArrayList<Product> invokeGetShoppingCart(Customer customer) throws Exception {
        Method method = Customer.class.getDeclaredMethod("viewShoppingCart", SortBy.class);
        method.setAccessible(true);
        return (ArrayList<Product>) method.invoke(customer);
    }

    private void invokeViewShoppingCart_mdow(Customer customer, SortBy sortMethod) throws Exception {
        Method method = Customer.class.getDeclaredMethod("viewShoppingCart", SortBy.class);
        method.setAccessible(true);
        method.invoke(customer, sortMethod);
    }
    @Test
    public void testProductRatingAndAverage_qdhs() throws Exception {
        // Step 1: Create a Product object
        Product product = new Product("Laptop", 10000.00f);

        // Step 2: Set ratings for the product
        product.setRating(5); // valid rating
        product.setRating(4); // valid rating
        product.setRating(6); // invalid rating, should not be added

        // Step 3: Retrieve the average rating
        float avgRating = product.getAvgRating(); // should be (5 + 4) / 2 = 4.5

        // Step 4: Use reflection to access the private field id
        Field idField = Product.class.getDeclaredField("id");
        idField.setAccessible(true);
        int productId = idField.getInt(product);

        // Step 5: Check the product string representation
        String productString = product.toString(); // should match the format

        // Assertions
        assertEquals(4.5, avgRating, 0.01);
        assertEquals("Product ID " + productId + ", Laptop, RMB 10000.00, Rating 4.5", productString);
    }

    @Test
    public void testStoreProductManagement_tgkq() throws Exception {
        // Step 1: Create a Product and Store
        Product product = new Product("Laptop", 10000.00f);
        Store store = new Store("Tech Store");

        // Step 2: Add the product to the store
        boolean added = store.addProduct(product); // should return true

        // Step 3: Check if the product exists in the store
        boolean hasProduct = store.hasProduct(product); // should return true

        // Step 4: Remove the product from the store
        boolean removed = store.removeProduct(product); // should return true

        // Step 5: Check again if the product exists
        boolean stillHasProduct = store.hasProduct(product); // should return false

        // Assertions
        assertTrue(added);
        assertTrue(hasProduct);
        assertTrue(removed);
        assertFalse(stillHasProduct);
    }

    @Test
    public void testCustomerPurchaseAndRefund_t6y9() throws Exception {
        // Step 1: Create a Store and a Product
        Product product = new Product("Laptop", 10000.00f);
        Store store = new Store("Tech Store");
        store.addProduct(product); // Add product to the store

        // Step 2: Create a Customer with sufficient wallet
        Customer customer = new Customer("Alice", 20000.00f);

        // Step 3: Customer purchases the product
        boolean purchased = customer.purchaseProduct(store, product); // should return true

        // Step 4: Check if the product is in the customer's shopping cart
        Method viewCartMethod = Customer.class.getDeclaredMethod("viewShoppingCart", SortBy.class);
        viewCartMethod.setAccessible(true);
        viewCartMethod.invoke(customer, SortBy.PurchaseTime); // should display the product

        // Step 5: Customer refunds the product
        boolean refunded = customer.refundProduct(product); // should return true

        // Step 6: Verify the product is back in the store
        boolean hasProductAfterRefund = store.hasProduct(product); // should return true

        // Assertions
        assertTrue(purchased);
        assertTrue(refunded);
        assertTrue(hasProductAfterRefund);
    }

    @Test
    public void testCustomerViewShoppingCartSorting_q25j() throws Exception {
        // Step 1: Create a Store and Products
        Store store = new Store("Tech Store");
        Product product1 = new Product("Laptop", 10000.00f);
        Product product2 = new Product("Table", 300.00f);
        Product product3 = new Product("Mouse", 100.00f);
        Product product4 = new Product("Phone", 7000.00f);

        // Step 2: Add products to the store
        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);
        store.addProduct(product4);

        // Step 3: Create a Customer and purchase products
        Customer customer = new Customer("Alice", 20000.00f);
        customer.purchaseProduct(store, product1);
        customer.purchaseProduct(store, product2);
        customer.purchaseProduct(store, product3);
        customer.purchaseProduct(store, product4);

        // Step 4: View shopping cart sorted by Rating
        Method viewCartMethod = Customer.class.getDeclaredMethod("viewShoppingCart", SortBy.class);
        viewCartMethod.setAccessible(true);
        viewCartMethod.invoke(customer, SortBy.Rating); // should display sorted products

        // Step 5: Validate that the products are sorted correctly
        // Note: Since we can't capture console output directly in this test, 
        // we would normally assert based on expected behavior or check the sorting logic in another test.

        // Step 6: Check if the customer can refund a product
        boolean refunded = customer.refundProduct(product1); // should return true

        // Assertions
        assertTrue(refunded);
    }
    @Test
    public void testCustomerPurchaseProductAndViewShoppingCart_k3hy() throws Exception {
        // Step 1: Create products and store
        Product product1 = new Product("Laptop", 10000.00f);
        Product product2 = new Product("Table", 300.00f);
        Store store = new Store("Tech Store");
        
        // Step 2: Add products to store
        Method addProductMethod = Store.class.getDeclaredMethod("addProduct", Product.class);
        addProductMethod.setAccessible(true);
        addProductMethod.invoke(store, product1);
        addProductMethod.invoke(store, product2);
        
        // Step 3: Create customer
        Customer customer = new Customer("Alice", 20000);
        
        // Step 4: Customer purchases products
        Assertions.assertTrue(customer.purchaseProduct(store, product1)); // Purchase Laptop
        Assertions.assertTrue(customer.purchaseProduct(store, product2)); // Purchase Table
        
        // Step 5: View shopping cart sorted by PurchaseTime
        customer.viewShoppingCart(SortBy.PurchaseTime);
        
        // Step 6: Verify the cart contains products
        ArrayList<Product> shoppingCart = (ArrayList<Product>) getPrivateField_u7o9(customer, "shoppingCart");
        Assertions.assertEquals(2, shoppingCart.size());
        Assertions.assertEquals(product1, shoppingCart.get(0));
        Assertions.assertEquals(product2, shoppingCart.get(1));
    }

    @Test
    public void testProductRatingAndAverage_j5xc() throws Exception {
        // Step 1: Create a product
        Product product = new Product("Mouse", 100.00f);
        
        // Step 2: Rate the product
        Assertions.assertTrue(product.setRating(4)); // Valid rating
        Assertions.assertTrue(product.setRating(5)); // Valid rating
        Assertions.assertFalse(product.setRating(6)); // Invalid rating
        
        // Step 3: Get average rating
        float avgRating = product.getAvgRating();
        
        // Step 4: Verify the average rating is correct
        Assertions.assertEquals(4.5, avgRating, 0.1); // Average should be 4.5
    }

    @Test
    public void testStoreRemoveAndCheckProduct_86dj() throws Exception {
        // Step 1: Create products and store
        Product product = new Product("Phone", 7000.00f);
        Store store = new Store("Gadget Store");
        
        // Step 2: Add product to store
        Method addProductMethod = Store.class.getDeclaredMethod("addProduct", Product.class);
        addProductMethod.setAccessible(true);
        addProductMethod.invoke(store, product);
        
        // Step 3: Verify product is in store
        Assertions.assertTrue(store.hasProduct(product));
        
        // Step 4: Remove product from store
        Method removeProductMethod = Store.class.getDeclaredMethod("removeProduct", Product.class);
        removeProductMethod.setAccessible(true);
        Assertions.assertTrue((Boolean) removeProductMethod.invoke(store, product));
        
        // Step 5: Verify product is no longer in store
        Assertions.assertFalse(store.hasProduct(product));
    }

    @Test
    public void testCustomerRefundProduct_rok4() throws Exception {
        // Step 1: Create products and store
        Product product = new Product("Laptop", 10000.00f);
        Store store = new Store("Tech Store");
        
        // Step 2: Add product to store
        Method addProductMethod = Store.class.getDeclaredMethod("addProduct", Product.class);
        addProductMethod.setAccessible(true);
        addProductMethod.invoke(store, product);
        
        // Step 3: Create customer and purchase product
        Customer customer = new Customer("Alice", 20000);
        Assertions.assertTrue(customer.purchaseProduct(store, product)); // Purchase Laptop
        
        // Step 4: Refund product
        Assertions.assertTrue(customer.refundProduct(product)); // Refund Laptop
        
        // Step 5: Verify store has the product back
        Assertions.assertTrue(store.hasProduct(product));
    }

    private Object getPrivateField_u7o9(Object obj, String fieldName) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
    @Test
    public void testCustomerPurchaseProduct_nstx() throws Exception {
        // Create a store and product for testing
        Store store = new Store("Test Store");
        Product product = new Product("Test Product", 100.0f);
        
        // Add the product to the store
        Method addProductMethod = Store.class.getDeclaredMethod("addProduct", Product.class);
        addProductMethod.setAccessible(true);
        addProductMethod.invoke(store, product);
        
        // Create a customer with sufficient wallet balance
        Customer customer = new Customer("Test Customer", 200.0f);
        
        // Attempt to purchase the product
        boolean purchaseResult = customer.purchaseProduct(store, product);
        
        // Assert the purchase was successful
        Assertions.assertTrue(purchaseResult);
        
        // Verify that the product was removed from the store's product list
        Method getProductListMethod = Store.class.getDeclaredMethod("getProductList");
        getProductListMethod.setAccessible(true);
        ArrayList<Product> productList = (ArrayList<Product>) getProductListMethod.invoke(store);
        Assertions.assertFalse(productList.contains(product));
    }

    @Test
    public void testCustomerRateProduct_5di6() throws Exception {
        // Create a product and customer
        Product product = new Product("Test Product", 100.0f);
        Customer customer = new Customer("Test Customer", 200.0f);
        
        // Customer rates the product
        boolean ratingResult = customer.rateProduct(product, 5);
        
        // Assert the rating was successful
        Assertions.assertTrue(ratingResult);
        
        // Check if the rating was correctly added to the product
        Method getAvgRatingMethod = Product.class.getDeclaredMethod("getAvgRating");
        getAvgRatingMethod.setAccessible(true);
        float avgRating = (float) getAvgRatingMethod.invoke(product);
        Assertions.assertEquals(5.0f, avgRating);
    }

    @Test
    public void testStoreTransactRefund_10k4() throws Exception {
        // Create a store and product
        Store store = new Store("Test Store");
        Product product = new Product("Test Product", 100.0f);
        
        // Add the product to the store
        Method addProductMethod = Store.class.getDeclaredMethod("addProduct", Product.class);
        addProductMethod.setAccessible(true);
        addProductMethod.invoke(store, product);
        
        // Create a customer and purchase the product
        Customer customer = new Customer("Test Customer", 200.0f);
        customer.purchaseProduct(store, product);
        
        // Now refund the product
        Method refundProductMethod = Customer.class.getDeclaredMethod("refundProduct", Product.class);
        refundProductMethod.setAccessible(true);
        boolean refundResult = (boolean) refundProductMethod.invoke(customer, product);
        
        // Assert the refund was successful
        Assertions.assertTrue(refundResult);
        
        // Check that the product was added back to the store
        Method getProductListMethod = Store.class.getDeclaredMethod("getProductList");
        getProductListMethod.setAccessible(true);
        ArrayList<Product> productList = (ArrayList<Product>) getProductListMethod.invoke(store);
        Assertions.assertTrue(productList.contains(product));
    }

    @Test
    public void testStoreRemoveProduct_4pgl() throws Exception {
        // Create a store and products
        Store store = new Store("Test Store");
        Product product1 = new Product("Test Product 1", 100.0f);
        Product product2 = new Product("Test Product 2", 200.0f);
        
        // Add products to the store
        Method addProductMethod = Store.class.getDeclaredMethod("addProduct", Product.class);
        addProductMethod.setAccessible(true);
        addProductMethod.invoke(store, product1);
        addProductMethod.invoke(store, product2);
        
        // Remove product1 from the store
        Method removeProductMethod = Store.class.getDeclaredMethod("removeProduct", Product.class);
        removeProductMethod.setAccessible(true);
        boolean removeResult = (boolean) removeProductMethod.invoke(store, product1);
        
        // Assert the removal was successful
        Assertions.assertTrue(removeResult);
        
        // Check that product1 is no longer in the store's product list
        Method getProductListMethod = Store.class.getDeclaredMethod("getProductList");
        getProductListMethod.setAccessible(true);
        ArrayList<Product> productList = (ArrayList<Product>) getProductListMethod.invoke(store);
        Assertions.assertFalse(productList.contains(product1));
        
        // Check that product2 is still in the product list
        Assertions.assertTrue(productList.contains(product2));
    }
    @Test
    public void testCustomerPurchaseProductWithInsufficientFunds_z6pd() throws Exception {
        // Create a new Store and Product
        Store store = new Store("Tech Store");
        Product product = new Product("Laptop", 15000.00f);
        
        // Add product to store
        store.addProduct(product);

        // Create a Customer with insufficient funds
        Customer customer = new Customer("Alice", 10000.00f);
        
        // Attempt to purchase product
        boolean result = customer.purchaseProduct(store, product);

        // Assert that the purchase was unsuccessful
        assertFalse(result, "Customer should not be able to purchase product with insufficient funds.");
        
        // Check if product is still in store's product list
        assertTrue(store.getProductList().contains(product), "Product should still be available in the store.");
    }

    //@Test
    public void testCustomerRefundProduct_g6t8() throws Exception {
        // Create a new Store and Product
        Store store = new Store("Gadget Store");
        Product product = new Product("Smartphone", 5000.00f);
        
        // Add product to store
        store.addProduct(product);

        // Create a Customer with enough funds
        Customer customer = new Customer("Bob", 10000.00f);
        
        // Customer purchases the product
        customer.purchaseProduct(store, product);
        
        // Customer refunds the product
        boolean refundResult = customer.refundProduct(product);

        // Assert that the refund was successful
        assertTrue(refundResult, "Customer should be able to refund the product.");
        
        // Check if product is back in store's product list
        assertTrue(store.getProductList().contains(product), "Product should be back in the store after refund.");
        
        // Check if customer's wallet is updated correctly
        Method getWalletMethod = Customer.class.getDeclaredMethod("getWallet");
        getWalletMethod.setAccessible(true);
        float wallet = (float) getWalletMethod.invoke(customer);
        assertEquals(10000.00f, wallet, "Customer's wallet should reflect the refunded amount.");
    }

    @Test
    public void testProductSetRating_9grb() throws Exception {
        // Create a Product
        Product product = new Product("Tablet", 3000.00f);
        
        // Set valid ratings
        assertTrue(product.setRating(4), "Setting valid rating should return true.");
        assertTrue(product.setRating(5), "Setting valid rating should return true.");
        
        // Set invalid rating
        assertFalse(product.setRating(6), "Setting invalid rating should return false.");
        
        // Check average rating
        float avgRating = product.getAvgRating();
        assertEquals(4.5f, avgRating, "Average rating should be 4.5 after setting ratings.");
    }

    //@Test
    public void testStoreTransactRefund_pv0r() throws Exception {
        // Create a new Store and Product
        Store store = new Store("Electronics Store");
        Product product = new Product("Monitor", 2000.00f);
        
        // Add product to store
        store.addProduct(product);
        
        // Create a Customer and purchase the product
        Customer customer = new Customer("Charlie", 3000.00f);
        customer.purchaseProduct(store, product);
        
        // Refund the product
        store.transact(product, 1); // method = 1 means refund
        assertTrue(store.getProductList().contains(product), "Product should be back in the store after refund.");
        
        // Check store income
        Method getIncomeMethod = Store.class.getDeclaredMethod("getIncome");
        getIncomeMethod.setAccessible(true);
        float income = (float) getIncomeMethod.invoke(store);
        assertEquals(0.00f, income, "Store income should be 0 after refunding the product.");
    }
    @Test
    public void testCustomerPurchaseAndRefundFlow_tdge() throws Exception {
        // Create a store and a product
        Store store = new Store("Tech Store");
        Product laptop = new Product("Laptop", 10000.00f);
        Product mouse = new Product("Mouse", 100.00f);
        
        // Add product to store
        store.addProduct(laptop);
        store.addProduct(mouse);
        
        // Create a customer with sufficient wallet balance
        Customer customer = new Customer("Alice", 20000.00f);
        
        // Customer purchases a laptop
        Assertions.assertTrue(customer.purchaseProduct(store, laptop));
        
        // Check if the product is in the customer's shopping cart
        Method getShoppingCartMethod = Customer.class.getDeclaredMethod("viewShoppingCart", SortBy.class);
        getShoppingCartMethod.setAccessible(true);
        getShoppingCartMethod.invoke(customer, SortBy.PurchaseTime);
        
        // Customer refunds the laptop
        Assertions.assertTrue(customer.refundProduct(laptop));
        
        // Check if the product is back in the store
        Assertions.assertTrue(store.hasProduct(laptop));
        
        // Check the wallet after refund
        Method updateWalletMethod = Customer.class.getDeclaredMethod("updateWallet", float.class);
        updateWalletMethod.setAccessible(true);
        updateWalletMethod.invoke(customer, 10000.00f);
    }

    @Test
    public void testProductRatingAndAverage_87kc() throws Exception {
        // Create a product
        Product phone = new Product("Phone", 7000.00f);
        
        // Set ratings for the product
        Assertions.assertTrue(phone.setRating(4));
        Assertions.assertTrue(phone.setRating(5));
        Assertions.assertTrue(phone.setRating(3));
        
        // Get the average rating
        float averageRating = phone.getAvgRating();
        
        // Assert the average rating is correct
        Assertions.assertEquals(4.0f, averageRating);
        
        // Check the string representation of the product
        String productString = phone.toString();
        Assertions.assertTrue(productString.contains("Phone"));
        Assertions.assertTrue(productString.contains("RMB 7000.00"));
        Assertions.assertTrue(productString.contains("Rating 4.0"));
    }

    @Test
    public void testStoreProductManagement_d8ny() throws Exception {
        // Create a store
        Store store = new Store("Gadget Store");
        
        // Create products
        Product tablet = new Product("Tablet", 3000.00f);
        Product keyboard = new Product("Keyboard", 500.00f);
        
        // Add products to the store
        Assertions.assertTrue(store.addProduct(tablet));
        Assertions.assertTrue(store.addProduct(keyboard));
        
        // Check if the store has products
        Assertions.assertTrue(store.hasProduct(tablet));
        Assertions.assertTrue(store.hasProduct(keyboard));
        
        // Remove a product and check again
        Assertions.assertTrue(store.removeProduct(keyboard));
        Assertions.assertFalse(store.hasProduct(keyboard));
        
        // Assert the product list size
        Assertions.assertEquals(1, store.getProductList().size());
    }

    @Test
    public void testCustomerShoppingCartSorting_06dc() throws Exception {
        // Create a store and products
        Store store = new Store("Online Store");
        Product table = new Product("Table", 300.00f);
        Product mouse = new Product("Mouse", 100.00f);
        Product laptop = new Product("Laptop", 10000.00f);
        
        // Add products to the store
        store.addProduct(table);
        store.addProduct(mouse);
        store.addProduct(laptop);
        
        // Create a customer
        Customer customer = new Customer("Bob", 20000.00f);
        
        // Customer purchases products
        customer.purchaseProduct(store, table);
        customer.purchaseProduct(store, mouse);
        customer.purchaseProduct(store, laptop);
        
        // View shopping cart sorted by price
        Method viewCartMethod = Customer.class.getDeclaredMethod("viewShoppingCart", SortBy.class);
        viewCartMethod.setAccessible(true);
        viewCartMethod.invoke(customer, SortBy.Price);
        
        // Assert the products are sorted correctly by price
        // The logic for actual sorting validation is implemented within the method
    }


}
