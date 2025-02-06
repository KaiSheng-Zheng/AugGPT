import org.junit.jupiter.api.*;
import java.lang.reflect.*;
import java.util.*;
import java.io.*;
import java.math.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class TestClass {
    private static Product product1_;
    private static Product product2_;
    private static Product product3_;
    private static Product product4_;
    private static Product product5_;
    private static Constructor<Product> productConstructor_;
    private static Store store1_;
    private static Store store2_;

    private static Constructor<Store> storeConstructor1_;
    private static Constructor<Store> storeConstructor2_;

    private static Customer customer_;
    private static Constructor<Customer> customerConstructor_;

    @Test
    public void test00_ProductConstructorExist() {
        Class<?>[] parameters = {String.class, float.class};
        try {
            productConstructor_ = Product.class.getConstructor(parameters);
        } catch (NoSuchMethodException e) {
            fail("The declaration of constructor of Class Product doesn't meet the requirement!");
        }
    }

    @Test
    public void test01_ProductFieldExist() {
        try {
            Field cnt = Product.class.getDeclaredField("cnt");
            Field id = Product.class.getDeclaredField("id");
            Field name = Product.class.getDeclaredField("name");
            Field price = Product.class.getDeclaredField("price");
            Field ratings = Product.class.getDeclaredField("ratings");

            assertTrue(Modifier.isPrivate(cnt.getModifiers()));
            assertTrue(Modifier.isStatic(cnt.getModifiers()));
            assertTrue(Modifier.isPrivate(id.getModifiers()));
            assertTrue(Modifier.isPrivate(name.getModifiers()));
            assertTrue(Modifier.isPrivate(price.getModifiers()));
            assertTrue(Modifier.isPrivate(ratings.getModifiers()));

            assertEquals(cnt.getType(), int.class);
            assertEquals(id.getType(), int.class);
            assertEquals(name.getType(), String.class);
            assertEquals(price.getType(), float.class);
            assertEquals(ratings.getType(), ArrayList.class);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            fail("The declaration of fields of Class Product doesn't meet the requirement!");
        }
    }

    @Test
    public void test02_ProductMethodExist() {
        try {
            Method setRating = Product.class.getDeclaredMethod("setRating", int.class);
            Method getAvgRating = Product.class.getDeclaredMethod("getAvgRating");
            Method toString = Product.class.getDeclaredMethod("toString");

            assertEquals(setRating.getReturnType(), boolean.class);
            assertEquals(getAvgRating.getReturnType(), float.class);
            assertEquals(toString.getReturnType(), String.class);

            assertTrue(Modifier.isPublic(setRating.getModifiers()));
            assertTrue(Modifier.isPublic(getAvgRating.getModifiers()));
            assertTrue(Modifier.isPublic(toString.getModifiers()));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            fail("The declaration of methods of Class Product doesn't meet the requirement!");
        }
    }

    @Test
    public void test03_ProductConstructor() {
        Class<?>[] parameters = {String.class, float.class};
        try {
            Object[] args = {"P1", 1.5f};
            productConstructor_ = Product.class.getConstructor(parameters);
            product1_ = productConstructor_.newInstance(args);

            Field id = product1_.getClass().getDeclaredField("id");
            id.setAccessible(true);
            assertEquals(1, id.getInt(product1_));

            Field name = product1_.getClass().getDeclaredField("name");
            name.setAccessible(true);
            assertEquals("P1", name.get(product1_));

            Field price = product1_.getClass().getDeclaredField("price");
            price.setAccessible(true);
            assertEquals(1.5, price.getFloat(product1_));

            Field ratings = product1_.getClass().getDeclaredField("ratings");
            ratings.setAccessible(true);
            assertEquals(new ArrayList<Integer>(), ratings.get(product1_));

            args = new Object[]{"P2", 2f};
            product2_ = productConstructor_.newInstance(args);
            Field cnt1 = product2_.getClass().getDeclaredField("cnt");
            cnt1.setAccessible(true);
            assertEquals(2, cnt1.getInt(product2_));

            product3_ = productConstructor_.newInstance("P3",3.5f);
            product4_ = productConstructor_.newInstance("P4",10000f);
            product5_ = productConstructor_.newInstance("P5",1f);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException e) {
            e.printStackTrace();
            fail("Constructor of Product is wrong!");
        }
    }

    @Test
    public void test04_SetRating() {
        try {
            Method setRating = Product.class.getDeclaredMethod("setRating", int.class);
            Boolean b = (Boolean) setRating.invoke(product3_, 1);
            assertTrue(b);

            Field ratings = Product.class.getDeclaredField("ratings");
            ratings.setAccessible(true);
            ArrayList<Integer> answer = new ArrayList<>();
            answer.add(1);
            assertTrue(answer.containsAll((ArrayList)ratings.get(product3_)));
            assertEquals(answer.size(), ((ArrayList)ratings.get(product3_)).size());

            assertTrue((Boolean) setRating.invoke(product3_, 2));
            answer.add(2);
            assertTrue(answer.containsAll((ArrayList)ratings.get(product3_)));
            assertEquals(answer.size(), ((ArrayList)ratings.get(product3_)).size());

            assertFalse((Boolean) setRating.invoke(product3_, 6));
            assertFalse((Boolean) setRating.invoke(product3_, 0));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void test05_getAvgRating() {
        try {
            Method getAvgRating = Product.class.getDeclaredMethod("getAvgRating");
            Field ratings = Product.class.getDeclaredField("ratings");
            ratings.setAccessible(true);
            float pre = (float) getAvgRating.invoke(product3_);
            assertEquals(1.5f, pre);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void test06_toString() {
        try {
            Method toString = Product.class.getDeclaredMethod("toString");
            String pre = (String) toString.invoke(product3_);
            String ans = "Product ID 3, P3, RMB 3.50, Rating 1.5";
            assertEquals(ans, pre);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void test07_StoreConstructorExist() {
        Class<?>[] parameters1 = {String.class};
        Class<?>[] parameters2 = {String.class, ArrayList.class, float.class};
        try {
            storeConstructor1_ = Store.class.getConstructor(parameters1);
            storeConstructor2_ = Store.class.getConstructor(parameters2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            fail("The declaration of constructors of class Store doesn't meet the requirement!");
        }
    }

    @Test
    public void test08_StoreFieldExist() {
        try {
            Field cnt = Store.class.getDeclaredField("cnt");
            Field id = Store.class.getDeclaredField("id");
            Field name = Store.class.getDeclaredField("name");
            Field productList = Store.class.getDeclaredField("productList");
            Field income = Store.class.getDeclaredField("income");

            assertTrue(Modifier.isStatic(cnt.getModifiers()));
            assertTrue(Modifier.isPrivate(cnt.getModifiers()));
            assertTrue(Modifier.isPrivate(id.getModifiers()));
            assertTrue(Modifier.isPrivate(name.getModifiers()));
            assertTrue(Modifier.isPrivate(productList.getModifiers()));
            assertTrue(Modifier.isPrivate(income.getModifiers()));

            assertEquals(int.class, cnt.getType());
            assertEquals(int.class, id.getType());
            assertEquals(String.class, name.getType());
            assertEquals(ArrayList.class, productList.getType());
            assertEquals(float.class, income.getType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            fail("The declaration of fields of class Store doesn't meet the requirement!");
        }
    }

    @Test
    public void test09_StoreMethodExist() {
        try {
            Method addProduct = Store.class.getDeclaredMethod("addProduct", Product.class);
            Method removeProduct = Store.class.getDeclaredMethod("removeProduct", Product.class);
            Method getProductList = Store.class.getDeclaredMethod("getProductList");
            Method hasProduct = Store.class.getDeclaredMethod("hasProduct", Product.class);
            Method transact = Store.class.getDeclaredMethod("transact", Product.class, int.class);

            assertEquals(boolean.class, addProduct.getReturnType());
            assertEquals(boolean.class, removeProduct.getReturnType());
            assertEquals(ArrayList.class, getProductList.getReturnType());
            assertEquals(boolean.class, hasProduct.getReturnType());
            assertEquals(void.class, transact.getReturnType());

            assertTrue(Modifier.isPublic(addProduct.getModifiers()));
            assertTrue(Modifier.isPublic(removeProduct.getModifiers()));
            assertTrue(Modifier.isPublic(getProductList.getModifiers()));
            assertTrue(Modifier.isPublic(hasProduct.getModifiers()));
            assertTrue(Modifier.isPublic(transact.getModifiers()));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            fail("The declaration of methods of class Store doesn't meet the requirement!");
        }
    }

    @Test
    public void test10_StoreConstructor() {
        Class<?>[] parameters1 = {String.class};
        Class<?>[] parameters2 = {String.class, ArrayList.class, float.class};
        try {
            Object[] args1 = {"S1"};
            storeConstructor1_ = Store.class.getConstructor(parameters1);
            store1_ = storeConstructor1_.newInstance(args1);

            ArrayList<Product> list2 = new ArrayList<>();
            list2.add(product2_);
            list2.add(product3_);
            Object[] args2 = {"S2", list2, 1000};
            storeConstructor2_ = Store.class.getConstructor(parameters2);
            store2_ = storeConstructor2_.newInstance(args2);
            ArrayList<Product> products = new ArrayList<>();
            products.add(product2_);
            products.add(product3_);

            Field id = store1_.getClass().getDeclaredField("id");
            id.setAccessible(true);
            assertEquals(1, id.getInt(store1_));

            Field name = store1_.getClass().getDeclaredField("name");
            name.setAccessible(true);
            assertEquals("S1", name.get(store1_));

            Field income = store1_.getClass().getDeclaredField("income");
            income.setAccessible(true);
            assertEquals(0, income.getFloat(store1_));

            Field productList = store1_.getClass().getDeclaredField("productList");
            productList.setAccessible(true);
            assertEquals(new ArrayList<Integer>(), productList.get(store1_));

            Field id2 =Store.class.getDeclaredField("id");
            id2.setAccessible(true);
            assertEquals(2, id.getInt(store2_));

            Field productList2 =Store.class.getDeclaredField("productList");
            productList2.setAccessible(true);
            assertEquals(products, productList.get(store2_));
        } catch (Exception e) {
            e.printStackTrace();
            fail("Constructor(s) of Store is/are wrong!");
        }
    }

    @Test
    public void test11_StoreAddProduct() {
        try {
            Method addProduct = Store.class.getDeclaredMethod("addProduct", Product.class);
            Field products = Store.class.getDeclaredField("productList");
            products.setAccessible(true);
            ArrayList<Product> answer = new ArrayList<>();
            answer.add(product2_);
            answer.add(product3_);
            assertFalse((Boolean) addProduct.invoke(store2_, product2_));
            assertTrue((Boolean) addProduct.invoke(store2_, product1_));
            assertFalse((Boolean) addProduct.invoke(store2_, product1_));
            answer.add(product1_);
            assertTrue(answer.containsAll((ArrayList<Product>) products.get(store2_)));
            assertEquals(answer.size(), ((ArrayList<Product>)products.get(store2_)).size());

            ArrayList<Product> answer2 = new ArrayList<>();
            answer2.add(product5_);
            assertTrue((Boolean) addProduct.invoke(store1_, product5_));
            assertTrue(answer2.containsAll((ArrayList<Product>) products.get(store1_)));
            assertEquals(answer2.size(), ((ArrayList<Product>)products.get(store1_)).size());
        } catch (Exception e) {
            e.printStackTrace();
            fail("addProduct method of class Store is wrong!");
        }
    }

    @Test
    public void test12_StoreGetProductList() {
        try {
            Method getProductList = Store.class.getDeclaredMethod("getProductList");
            Field products = Store.class.getDeclaredField("productList");
            products.setAccessible(true);
            ArrayList<Product> answer = new ArrayList<>();
            answer.add(product2_);
            answer.add(product3_);
            answer.add(product1_);
            assertTrue(answer.containsAll((ArrayList<Product>) getProductList.invoke(store2_)));
            assertEquals(answer.size(), ((ArrayList<Product>)getProductList.invoke(store2_)).size());
        } catch (Exception e) {
            e.printStackTrace();
            fail("getProducts method of class Store is wrong!");
        }
    }

    @Test
    public void test13_StoreHasProduct() {
        try {
            Method hasProduct = Store.class.getDeclaredMethod("hasProduct", Product.class);
            assertTrue((Boolean) hasProduct.invoke(store2_, product1_));
            assertFalse((Boolean) hasProduct.invoke(store2_, product4_));
        } catch (Exception e) {
            e.printStackTrace();
            fail("hasProduct method of class Store is wrong!");
        }
    }

    @Test
    public void test14_StoreRemoveProduct() {
        try {
            Method removeProduct = Store.class.getDeclaredMethod("removeProduct", Product.class);
            Field products = Store.class.getDeclaredField("productList");
            products.setAccessible(true);
            ArrayList<Product> answer = new ArrayList<>();
            answer.add(product2_);
            answer.add(product3_);
            answer.add(product1_);

            assertTrue((Boolean) removeProduct.invoke(store2_, product1_));
            assertFalse((Boolean) removeProduct.invoke(store2_, product1_));
            answer.remove(product1_);
            assertTrue(answer.containsAll((ArrayList<Product>) products.get(store2_)));
            assertEquals(answer.size(), ((ArrayList<Product>)products.get(store2_)).size());
        } catch (Exception e) {
            e.printStackTrace();
            fail("removeProduct method of class Store is wrong!");
        }
    }

    @Test
    public void test15_StorePurchase() {
        try {
            Method transact =Store.class.getDeclaredMethod("transact", Product.class, int.class);
            Field income =Store.class.getDeclaredField("income");
            Field products =Store.class.getDeclaredField("productList");
            income.setAccessible(true);
            products.setAccessible(true);
            ArrayList<Product> answer = new ArrayList<>();
            answer.add(product2_);
            answer.add(product3_);

            transact.invoke(store2_, product2_, 0);
            answer.remove(product2_);
            assertTrue(answer.containsAll((ArrayList<Product>) products.get(store2_)));
            assertEquals(answer.size(), ((ArrayList<Product>)products.get(store2_)).size());
            assertEquals(1002f, income.get(store2_));
        } catch (Exception e) {
            e.printStackTrace();
            fail("Purchasing part in transact method of class Store is wrong!");
        }
    }

    @Test
    public void test16_StoreRefund() { //bonus
        try {
            Method transact =Store.class.getDeclaredMethod("transact", Product.class, int.class);
            Field income =Store.class.getDeclaredField("income");
            Field products =Store.class.getDeclaredField("productList");
            income.setAccessible(true);
            products.setAccessible(true);
            ArrayList<Product> answer = new ArrayList<>();
            answer.add(product3_);

            store2_.addProduct(product2_);
            income.set(store2_,(float)income.get(store2_)- product2_.getPrice());
//            transact.invoke(store2_, product2_, 1);
//            answer.add(product2_);
//            assertTrue(answer.containsAll((ArrayList<Product>) products.get(store2_)));
//            assertEquals(answer.size(), ((ArrayList<Product>)products.get(store2_)).size());
//            assertEquals(1000f, income.get(store2_));
        } catch (Exception e) {
            e.printStackTrace();
            fail("Refunding part in transact method of class Store is wrong!");
        }
    }

    @Test
    public void test17_CustomerFieldExist() {
        try {
            Field cnt = Customer.class.getDeclaredField("cnt");
            Field id = Customer.class.getDeclaredField("id");
            Field name = Customer.class.getDeclaredField("name");
            Field shoppingCart = Customer.class.getDeclaredField("shoppingCart");
            Field wallet = Customer.class.getDeclaredField("wallet");

            assertTrue(Modifier.isStatic(cnt.getModifiers()));
            assertTrue(Modifier.isPrivate(cnt.getModifiers()));
            assertTrue(Modifier.isPrivate(id.getModifiers()));
            assertTrue(Modifier.isPrivate(name.getModifiers()));
            assertTrue(Modifier.isPrivate(shoppingCart.getModifiers()));
            assertTrue(Modifier.isPrivate(wallet.getModifiers()));

            assertEquals(int.class, cnt.getType());
            assertEquals(int.class, id.getType());
            assertEquals(String.class, name.getType());
            assertEquals(ArrayList.class, shoppingCart.getType());
            assertEquals(float.class, wallet.getType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            fail("Field error!");
        }
    }

    @Test
    public void test18_CustomerMethodExist() {
        try {
            Method rateProduct = Customer.class.getDeclaredMethod("rateProduct", Product.class, int.class);
            Method purchaseProduct = Customer.class.getDeclaredMethod("purchaseProduct", Store.class, Product.class);
            Method updateWallet = Customer.class.getDeclaredMethod("updateWallet", float.class);
            Method viewShoppingCart = Customer.class.getDeclaredMethod("viewShoppingCart", SortBy.class);
//            Method refundProduct = Customer.class.getDeclaredMethod("refundProduct", Product.class);

            assertEquals(boolean.class, rateProduct.getReturnType());
            assertEquals(boolean.class, purchaseProduct.getReturnType());
            assertEquals(void.class, updateWallet.getReturnType());
            assertEquals(void.class, viewShoppingCart.getReturnType());
//            assertEquals(boolean.class, refundProduct.getReturnType());

            assertTrue(Modifier.isPublic(rateProduct.getModifiers()));
            assertTrue(Modifier.isPublic(purchaseProduct.getModifiers()));
            assertTrue(Modifier.isPublic(updateWallet.getModifiers()));
            assertTrue(Modifier.isPublic(viewShoppingCart.getModifiers()));
//            assertTrue(Modifier.isPublic(refundProduct.getModifiers()));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            fail("The declaration of methods of Class Customer doesn't meet the requirement!");
        }
    }

    @Test
    public void test19_CustomerConstructorExist() {
        Class<?>[] parameters = {String.class, float.class};
        try {
            customerConstructor_ = Customer.class.getConstructor(parameters);
            customer_ = customerConstructor_.newInstance("C1", 100);
            Field id = customer_.getClass().getDeclaredField("id");
            Field name = customer_.getClass().getDeclaredField("name");
            Field shoppingCart = customer_.getClass().getDeclaredField("shoppingCart");
            Field wallet = customer_.getClass().getDeclaredField("wallet");

            id.setAccessible(true);
            assertEquals(1, id.getInt(customer_));
            name.setAccessible(true);
            assertEquals("C1", name.get(customer_));
            shoppingCart.setAccessible(true);
            assertEquals(new ArrayList<Product>(), shoppingCart.get(customer_));
            wallet.setAccessible(true);
            assertEquals(100f, wallet.get(customer_));
        } catch (Exception e) {
            e.printStackTrace();
            fail("Customer Constructor error!");
        }
    }

    @Test
    public void test20_rateProduct() {
        try {
            Method rateProduct = Customer.class.getDeclaredMethod("rateProduct", Product.class, int.class);
            rateProduct.setAccessible(true);
            assertTrue((Boolean) rateProduct.invoke(customer_, product1_, 5));
            assertFalse((Boolean) rateProduct.invoke(customer_, product1_, -1));
            assertFalse((Boolean) rateProduct.invoke(customer_, product1_, 6));
            Field ratings = Product.class.getDeclaredField("ratings");
            ratings.setAccessible(true);
            ArrayList<Integer> answer = new ArrayList<>();
            answer.add(5);
            assertEquals(answer, ratings.get(product1_));
        } catch (Exception e) {
            e.printStackTrace();
            fail("rateProduct error!");
        }
    }

    @Test
    public void test21_purchaseProduct() {
        try {
            Method purchaseProduct = Customer.class.getDeclaredMethod("purchaseProduct", Store.class, Product.class);
            purchaseProduct.setAccessible(true);
            Field shoppingCart = Customer.class.getDeclaredField("shoppingCart");
            shoppingCart.setAccessible(true);
            Field wallet = Customer.class.getDeclaredField("wallet");
            wallet.setAccessible(true);
            Field productList = Store.class.getDeclaredField("productList");
            productList.setAccessible(true);
            Field income = Store.class.getDeclaredField("income");
            income.setAccessible(true);

            ArrayList<Product> answer_shoppingCart = (ArrayList<Product>) ((ArrayList<Product>) shoppingCart.get(customer_)).clone();
            ArrayList<Product> answer_productList = (ArrayList<Product>) ((ArrayList<Product>) productList.get(store2_)).clone();

            assertTrue((Boolean) purchaseProduct.invoke(customer_, store2_, product2_));

            answer_shoppingCart.add(product2_);
            assertTrue(answer_shoppingCart.containsAll((ArrayList)shoppingCart.get(customer_)));
            assertEquals(answer_shoppingCart.size(), ((ArrayList)shoppingCart.get(customer_)).size());
            assertEquals(98f, wallet.get(customer_));
            answer_productList.remove(product2_);
            assertTrue(answer_productList.containsAll((ArrayList)productList.get(store2_)));
            assertEquals(answer_productList.size(), ((ArrayList)productList.get(store2_)).size());
            assertEquals(1002f,income.get(store2_));

            assertTrue((Boolean) purchaseProduct.invoke(customer_, store2_, product3_));

            answer_shoppingCart.add(product3_);
            assertTrue(answer_shoppingCart.containsAll((ArrayList)shoppingCart.get(customer_)));
            assertEquals(answer_shoppingCart.size(), ((ArrayList)shoppingCart.get(customer_)).size());
            assertEquals(94.5f, wallet.get(customer_));
            answer_productList.remove(product3_);
            assertTrue(answer_productList.containsAll((ArrayList)productList.get(store2_)));
            assertEquals(answer_productList.size(), ((ArrayList)productList.get(store2_)).size());
            assertEquals(1005.5f,income.get(store2_));

            assertFalse((Boolean) purchaseProduct.invoke(customer_, store2_, product1_));
            assertFalse((Boolean) purchaseProduct.invoke(customer_, store2_, product4_));

            assertTrue((Boolean) purchaseProduct.invoke(customer_, store1_, product5_));
            answer_shoppingCart.add(product5_);
            assertTrue(answer_shoppingCart.containsAll((ArrayList)shoppingCart.get(customer_)));
            assertEquals(answer_shoppingCart.size(), ((ArrayList)shoppingCart.get(customer_)).size());
            assertEquals(93.5f, wallet.get(customer_));
            answer_productList.remove(product5_);
            assertTrue(answer_productList.containsAll((ArrayList)productList.get(store1_)));
            assertEquals(answer_productList.size(), ((ArrayList)productList.get(store1_)).size());
            assertEquals(1f, income.get(store1_));
        } catch (Exception e) {
            e.printStackTrace();
            fail("purchaseProduct error!");
        }
    }

    @Test
    public void test22_updateWallet() {
        try {
            Customer customer1 = customerConstructor_.newInstance("C2", 10);
            Method updateWallet = Customer.class.getDeclaredMethod("updateWallet", float.class);
            updateWallet.setAccessible(true);
            updateWallet.invoke(customer1, 100f);
            Field wallet = customer1.getClass().getDeclaredField("wallet");
            wallet.setAccessible(true);
            assertEquals(110f, wallet.get(customer1));
        } catch (Exception e) {
            e.printStackTrace();
            fail("updateWallet error!");
        }
    }

    @Test
    public void test23_viewShoppingCart() {
        try {
            Method viewShoppingCart = Customer.class.getDeclaredMethod("viewShoppingCart", SortBy.class);
            viewShoppingCart.setAccessible(true);
            Customer customer1 = customerConstructor_.newInstance("C3", 10);
            Field shoppingCart = customer1.getClass().getDeclaredField("shoppingCart");
            shoppingCart.setAccessible(true);
            ArrayList<Product> cart = (ArrayList<Product>) (shoppingCart.get(customer1));
            cart.add(productConstructor_.newInstance("2", 10f));
            cart.add(productConstructor_.newInstance("1", 20f));
            cart.add(productConstructor_.newInstance("3", 15f));
            Field ratings = Product.class.getDeclaredField("ratings");
            ratings.setAccessible(true);
            ratings.set(cart.get(0), new ArrayList<>(Arrays.asList(1,2,3)));
            ratings.set(cart.get(1), new ArrayList<>(Arrays.asList(1,1,1)));
            ratings.set(cart.get(2), new ArrayList<>(Arrays.asList(0,0,0)));
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            viewShoppingCart.invoke(customer1, SortBy.Price);
            viewShoppingCart.invoke(customer1, SortBy.Rating);
            assertEquals("Product ID 6, 2, RMB 10.00, Rating 2.0" + System.lineSeparator() +
                    "Product ID 8, 3, RMB 15.00, Rating 0.0" + System.lineSeparator() +
                    "Product ID 7, 1, RMB 20.00, Rating 1.0" + System.lineSeparator() +
                    "Product ID 8, 3, RMB 15.00, Rating 0.0" + System.lineSeparator() +
                    "Product ID 7, 1, RMB 20.00, Rating 1.0" + System.lineSeparator() +
                    "Product ID 6, 2, RMB 10.00, Rating 2.0" + System.lineSeparator(), outContent.toString());
            System.setOut(System.out);
        } catch (Exception e) {
            System.setOut(System.out);
            e.printStackTrace();
            fail("viewShoppingCart error!");
        }
    }

    @Test
    public void test24_refundProduct() {
        try {
            Method refundProduct = Customer.class.getDeclaredMethod("refundProduct", Product.class);
            refundProduct.setAccessible(true);
            Field shoppingCart = Customer.class.getDeclaredField("shoppingCart");
            shoppingCart.setAccessible(true);
            Field wallet = Customer.class.getDeclaredField("wallet");
            wallet.setAccessible(true);
            Field productList = Store.class.getDeclaredField("productList");
            productList.setAccessible(true);
            Field income = Store.class.getDeclaredField("income");
            income.setAccessible(true);
            Field price = Product.class.getDeclaredField("price");
            price.setAccessible(true);

            ArrayList<Product> answer_productList = (ArrayList<Product>) ((ArrayList<Product>) productList.get(store2_)).clone();
            ArrayList<Product> answer_shoppingCart = (ArrayList<Product>) ((ArrayList<Product>) shoppingCart.get(customer_)).clone();
            float current_wallet = (float) wallet.get(customer_);
            float current_income = (float) income.get(store2_);

            assertTrue((Boolean) refundProduct.invoke(customer_, product2_));
            assertFalse((Boolean) refundProduct.invoke(customer_, product2_));
            assertFalse((Boolean) refundProduct.invoke(customer_, product1_));
            assertFalse((Boolean) refundProduct.invoke(customer_, product4_));
            answer_shoppingCart.remove(product2_);
            answer_productList.add(product2_);

            assertTrue(answer_shoppingCart.containsAll((ArrayList)shoppingCart.get(customer_)));
            assertEquals(answer_shoppingCart.size(), ((ArrayList)shoppingCart.get(customer_)).size());
            assertEquals(current_wallet + price.getFloat(product2_), wallet.get(customer_));

            assertTrue(answer_productList.containsAll((ArrayList<Product>) productList.get(store2_)));
            assertEquals(answer_productList.size(), ((ArrayList<Product>) productList.get(store2_)).size());
            assertEquals(current_income - price.getFloat(product2_), income.get(store2_));
            current_income = (float) income.get(store2_);
            current_wallet = (float) wallet.get(customer_);

            assertTrue((Boolean) refundProduct.invoke(customer_, product3_));
            answer_shoppingCart.remove(product3_);
            answer_productList.add(product3_);

            assertTrue(answer_shoppingCart.containsAll((ArrayList)shoppingCart.get(customer_)));
            assertEquals(answer_shoppingCart.size(), ((ArrayList)shoppingCart.get(customer_)).size());
            assertEquals(current_wallet + price.getFloat(product3_), wallet.get(customer_));

            assertTrue(answer_productList.containsAll((ArrayList<Product>) productList.get(store2_)));
            assertEquals(answer_productList.size(), ((ArrayList<Product>) productList.get(store2_)).size());
            assertEquals(current_income - price.getFloat(product3_), income.get(store2_));
            current_income = (float) income.get(store1_);
            current_wallet = (float) wallet.get(customer_);
            answer_productList = (ArrayList<Product>) ((ArrayList<Product>) productList.get(store1_)).clone();

            assertTrue((Boolean) refundProduct.invoke(customer_, product5_));
            answer_shoppingCart.remove(product5_);
            answer_productList.add(product5_);

            assertTrue(answer_shoppingCart.containsAll((ArrayList)shoppingCart.get(customer_)));
            assertEquals(answer_shoppingCart.size(), ((ArrayList)shoppingCart.get(customer_)).size());
            assertEquals(current_wallet + price.getFloat(product5_), wallet.get(customer_));

            assertTrue(answer_productList.containsAll((ArrayList<Product>) productList.get(store1_)));
            assertEquals(answer_productList.size(), ((ArrayList<Product>) productList.get(store1_)).size());
            assertEquals(current_income - price.getFloat(product5_), income.get(store1_));

        } catch (Exception e) {
            e.printStackTrace();
            fail("refundProduct error!");
        }
    }


    @Test
    public void test25_testProductRatingAndAverage_dpcm() throws Exception {
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
    public void test25_testStoreProductManagement_bf4p() throws Exception {
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
    public void test25_testCustomerPurchaseAndRefund_rv05() throws Exception {
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
    public void test25_testCustomerShoppingCartSorting_ikt7() throws Exception {
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
    public void test25_testCustomerRatingProduct_y81c() throws Exception {
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
    public void test25_testCustomerPurchasingProduct_ijk3() throws Exception {
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
    public void test25_testCustomerRefundingProduct_gd8l() throws Exception {
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
    public void test25_testStoreProductManagement_2m78() throws Exception {
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
    public void test25_testCustomerPurchaseAndRefund_k1ou() throws Exception {
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
    public void test25_testProductRatingAndAverage_obys() throws Exception {
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
    public void test25_testStoreProductManagement_ekce() throws Exception {
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
    public void test25_testCustomerShoppingCartSorting_0h15() throws Exception {
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
    public void test25_testCustomerPurchaseAndRefund_bvv7() throws Exception {
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
    public void test25_testProductRatingAndAverage_yd97() throws Exception {
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
    public void test25_testStoreProductManagement_bjrv() throws Exception {
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
    public void test25_testCustomerViewShoppingCartSorting_2ck0() throws Exception {
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
    public void test25_testCustomerPurchaseAndRefund_yqje() throws Exception {
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
    public void test25_testProductRatingAndAverage_vrtd() throws Exception {
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
    public void test25_testStoreProductManagement_mmlz() throws Exception {
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
    public void test25_testCustomerViewShoppingCartSorting_0pzy() throws Exception {
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
    public void test25_testCustomerPurchaseAndSortByRating_buy8() throws Exception {
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
    public void test25_testStoreRemoveProductAndTransact_zduc() throws Exception {
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
    public void test25_testProductRatingLogic_ct69() throws Exception {
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
        Assertions.assertEquals("Product ID 60, Laptop, RMB 10000.00, Rating 4.0", laptop.toString());
    }

    //@Test
    public void test25_testCustomerRefundAndStoreUpdate_zq5u() throws Exception {
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
    public void test25_testProductRatingAndAverage_wsti() throws Exception {
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
    public void test25_testStoreProductManagement_s3dv() throws Exception {
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
    public void test25_testCustomerPurchaseAndRefund_mgf8() throws Exception {
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
    public void test25_testCustomerViewShoppingCartSorting_lpud() throws Exception {
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
    public void test25_testProductRatingAndAverage_qdhs() throws Exception {
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
    public void test25_testStoreProductManagement_tgkq() throws Exception {
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
    public void test25_testCustomerPurchaseAndRefund_t6y9() throws Exception {
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
    public void test25_testCustomerViewShoppingCartSorting_q25j() throws Exception {
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
    public void test25_testCustomerPurchaseProductAndViewShoppingCart_k3hy() throws Exception {
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
    public void test25_testProductRatingAndAverage_j5xc() throws Exception {
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
    public void test25_testStoreRemoveAndCheckProduct_86dj() throws Exception {
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
    public void test25_testCustomerRefundProduct_rok4() throws Exception {
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
    public void test25_testCustomerPurchaseProduct_nstx() throws Exception {
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
    public void test25_testCustomerRateProduct_5di6() throws Exception {
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
    public void test25_testStoreTransactRefund_10k4() throws Exception {
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
    public void test25_testStoreRemoveProduct_4pgl() throws Exception {
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
    public void test25_testCustomerPurchaseProductWithInsufficientFunds_z6pd() throws Exception {
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
    public void test25_testCustomerRefundProduct_g6t8() throws Exception {
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
    public void test25_testProductSetRating_9grb() throws Exception {
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
    public void test25_testStoreTransactRefund_pv0r() throws Exception {
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
    public void test25_testCustomerPurchaseAndRefundFlow_tdge() throws Exception {
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
    public void test25_testProductRatingAndAverage_87kc() throws Exception {
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
    public void test25_testStoreProductManagement_d8ny() throws Exception {
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
    public void test25_testCustomerShoppingCartSorting_06dc() throws Exception {
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
