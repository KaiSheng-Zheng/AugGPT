

import java.util.ArrayList;

class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private ArrayList<Product> shoppingCart2=new ArrayList<>(); 
    private float wallet;
    private ArrayList<Store> stores=new ArrayList<>();
    protected static ArrayList<Customer> customers=new ArrayList<>();

    public Customer(String name, float wallet) {
        this.id = ++cnt;
        this.name = name;
        this.wallet = wallet;
        customers.add(this);
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && product.getPrice() <= wallet) {
            wallet -= product.getPrice();
            store.transact(product, 0);
            shoppingCart.add(product);
            stores.add(store);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        sortMethod.getList(id);
    }

    public boolean refundProduct(Product product) {
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).getId() == product.getId()) {
                wallet += product.getPrice();
                stores.get(i).transact(product, 1);
                shoppingCart.remove(i);
                stores.remove(i);
                return true;
            }
        }
        return false;
    }

    public Product getShoppingCart(int index) {
        return shoppingCart.get(index);
    }
    public int getShoppingCartSize() {
        return shoppingCart.size();
    }

    
}
