import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet) {
        ++cnt;
        this.name = name;
        this.wallet = wallet;
        this.id = cnt;
        this.shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        float price = product.getPrice();
        if (store.hasProduct(product) && price <= wallet) {
            shoppingCart.add(product);
            wallet -= price;
            store.transact(product,0);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch(sortMethod){
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
            case Rating:
                ArrayList<Float> arr_2 = new ArrayList<>();
                ArrayList<Product> SC_2 = shoppingCart;
                for (int i = 0; i < shoppingCart.size(); i++) {
                    arr_2.add(shoppingCart.get(i).getAvgRating());
                }
                while(!arr_2.isEmpty()){
                    int indexOfMaxElement = arr_2.indexOf(Collections.min(arr_2));
                    System.out.println(shoppingCart.get(indexOfMaxElement).toString());
                    arr_2.remove(arr_2.get(indexOfMaxElement));
                    SC_2.remove(SC_2.get(indexOfMaxElement));
                }
            case Price:
                ArrayList<Float> arr_3 = new ArrayList<>();
                ArrayList<Product> SC_3 = shoppingCart;
                for (int i = 0; i < shoppingCart.size(); i++) {
                    arr_3.add(shoppingCart.get(i).getPrice());
                }
                while(!arr_3.isEmpty()){
                    int indexOfMaxElement = arr_3.indexOf(Collections.min(arr_3));
                    System.out.println(shoppingCart.get(indexOfMaxElement).toString());
                    arr_3.remove(arr_3.get(indexOfMaxElement));
                    SC_3.remove(SC_3.get(indexOfMaxElement));
                }
        }
    }

    public boolean refundProduct(Store store, Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            wallet += product.getPrice();
            store.transact(product,1);
            return true;
        } else {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public static int getCnt() {
        return cnt;
    }
}