import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Customer.cnt = cnt;
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

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }
    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating) == true) {
            return true;
        }
        else return false;
    }
    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }
    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) == true && wallet >= product.getPrice()) {
            store.transact(product, 0);
            wallet = wallet - product.getPrice();
            shoppingCart.add(product);
            return true;
        } else return false;
    }
    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod.equals(SortBy.Price)) {
            Product temp;
            int k;
            for (int i=0;i<shoppingCart.size()-1;i++){
                k=i;
                for (int j=i+1;j<shoppingCart.size();j++) {
                    if (shoppingCart.get(j).getPrice() < shoppingCart.get(k).getPrice()) {
                        k = j;
                    }
                }
                temp = shoppingCart.get(k);
                if (k!=i) {
                    shoppingCart.set(k, shoppingCart.get(i));
                    shoppingCart.set(i, temp);
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod.equals(SortBy.Rating)) {
            Product temp;
            int k;
            for (int i=0;i<shoppingCart.size()-1;i++){
                k=i;
                for (int j=i+1;j<shoppingCart.size();j++) {
                    if (shoppingCart.get(j).getAvgRating() < shoppingCart.get(k).getAvgRating()) {
                        k = j;
                    }
                }
                temp = shoppingCart.get(k);
                if (k!=i) {
                    shoppingCart.set(k, shoppingCart.get(i));
                    shoppingCart.set(i, temp);
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product,Store store) {
        int a = 0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (product.equals(shoppingCart.get(i))) {
                a = 1;
                break;
            }
        }
        if (a == 1) {
            shoppingCart.remove(product);
            wallet = wallet - product.getPrice();
            store.transact(product, 1);
            return true;
         } else return false;
    }
}













