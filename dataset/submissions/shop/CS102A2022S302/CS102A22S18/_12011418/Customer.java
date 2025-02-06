import java.util.ArrayList;

public class Customer {
    // Attributes
    private static int cnt = 0;// initialized to 0, cnt += 1 when the constructor is called
    private int id;// unique for each customer, the value is set to cnt
    private String name;// the name of the product
    private ArrayList<Product> shoppingCart;// the list of purchased products, default is empty
    private float wallet;// the balance of the customer

    // Constructor
    public Customer(String name, float wallet) {
        cnt++;
        this.setId(cnt);
        this.setName(name);
        this.setWallet(wallet);
        ArrayList<Product> shoppingCart = new ArrayList<>();
        this.setShoppingCart(shoppingCart);
    }

    // Setter & Getter
    public void setId(int id) {
        this.id = id;
    }// id
    public int getId() {
        return this.id;
    }// id

    public void setName(String name) {
        this.name = name;
    }// name
    public String getName() {
        return this.name;
    }// name

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }// ShoppingCart
    public ArrayList<Product> getShoppingCart() {
        return this.shoppingCart;
    }// ShoppingCart

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }// wallet
    public float getWallet() {
        return this.wallet;
    }// wallet

    /**
     * Customers can rate a product using this method.
     * @return whether the operation succeeds
     */
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    /**
     * Update the wallet of this customer.
     */
    public void updateWallet(float amount){
        this.setWallet(this.getWallet() + amount);
    }

    /**
     * Return true if the store has this product and the customer has enough money to
     * purchase this product; return false otherwise.
     * @return whether the operation succeeds
     */
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && this.getWallet() >= product.getPrice()){
            store.removeProduct(product);
            store.setIncome(store.getIncome() + product.getPrice());
            this.getShoppingCart().add(product);
            this.updateWallet(-product.getPrice());
            product.setCustomer(this);// ADDITIONAL
            store.getPurchased().add(product);// ADDITIONAL
            return true;
        } else {
            return false;
        }
    }

    /**
     * Display the purchased products in the shoppingCart of this customer.
     * The order of displaying is specified by sortMethod.
     */
    public void viewShoppingCart(SortBy sortMethod){
        Product[] sort = new Product[this.getShoppingCart().size()];
        for (int i = 0; i < sort.length; i++) {
            sort[i] = this.getShoppingCart().get(i);
        }
        if (sortMethod.equals(SortBy.PurchaseTime)){
            if (sort.length != 0){
                for (Product product : sort) {
                    System.out.println(product.toString());
                }// print product in formatted string
            }
        } else if (sortMethod.equals(SortBy.Rating)){
            if (sort.length != 0){
                for (int i = 0; i < sort.length; i++) {
                    Product insertProduct;// product to be inserted
                    insertProduct = sort[i];
                    int insertIndex = i - 1;// index of the product before insertProduct
                    while (insertIndex >= 0 && insertProduct.getAvgRating() < sort[insertIndex].getAvgRating()){
                        sort[insertIndex + 1] = sort[insertIndex];
                        sort[insertIndex] = insertProduct;
                        insertIndex--;
                    }
                }// insert sort
                for (Product product : sort) {
                    System.out.println(product.toString());
                }// print product in formatted string
            }
        } else if (sortMethod.equals(SortBy.Price)){
            if (sort.length != 0){
                for (int i = 0; i < sort.length; i++) {
                    Product insertProduct;// product to be inserted
                    insertProduct = sort[i];
                    int insertIndex = i - 1;// index of the product before insertProduct
                    while (insertIndex >= 0 && insertProduct.getPrice() < sort[insertIndex].getPrice()){
                        sort[insertIndex + 1] = sort[insertIndex];
                        sort[insertIndex] = insertProduct;
                        insertIndex--;
                    }
                }// insert sort
                for (Product product : sort) {
                    System.out.println(product.toString());
                }// print product in formatted string
            }
        }
    }

    /**
     * BONUS
     * Return the product to the store where it was sold and get the money back.
     * @return whether the operation succeeds
     */
    public boolean refundProduct(Product product){
        if (product.getStore() == null){
            return false;
        } else if (product.getStore().getPurchased().contains(product) && product.getCustomer().equals(this)){
            this.getShoppingCart().remove(product);
            this.setWallet(this.getWallet() + product.getPrice());
            product.getStore().addProduct(product);
            product.getStore().setIncome(product.getStore().getIncome() - product.getPrice());
            product.getStore().getPurchased().remove(product);
            return true;
        } else {
            return false;
        }
    }
}