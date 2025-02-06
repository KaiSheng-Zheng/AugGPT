import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.removeProduct(product);
            store.setIncome(store.getIncome() + product.getPrice());
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            product.store = store;
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod == SortBy.Price) {
            ArrayList<Product> copy = new ArrayList<>(shoppingCart);
            for (int i = 0; i < copy.size()-1; i++) {
                for (int j = 0; j < copy.size()-1-i; j++) {
                    if (copy.get(j).getPrice()>copy.get(j+1).getPrice()){
                        Product store = copy.get(j);
                        copy.set(j,copy.get(j+1));
                        copy.set(j+1,store);
                    }
                }
            }
            for (int i = 0; i < copy.size(); i++) {
                System.out.println(copy.get(i).toString());
            }
        }
        if (sortMethod == SortBy.Rating) {
            ArrayList<Product> copy = new ArrayList<>(shoppingCart);
            for (int i = 0; i < copy.size()-1; i++) {
                for (int j = 0; j < copy.size()-1-i; j++) {
                    if (copy.get(j).getAvgRating()>copy.get(j+1).getAvgRating()){
                        Product store = copy.get(j);
                        copy.set(j,copy.get(j+1));
                        copy.set(j+1,store);
                    }
                }
            }
            for (int i = 0; i < copy.size(); i++) {
                System.out.println(copy.get(i).toString());
            }
        }
    }

    public boolean refundProduct(Product product) {
        int Button = 0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).equals(product)){
                Button++;
            }
        }
        if (Button!=0){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            product.store.transact(product,1);
            return true;
        }else {
            return false;
        }
    }
}