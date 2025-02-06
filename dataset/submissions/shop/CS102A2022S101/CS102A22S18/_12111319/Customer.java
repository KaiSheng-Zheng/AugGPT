import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private ArrayList<Store> paststore;
    private ArrayList<Store> hasGone;
    private ArrayList<Product> hasBuyed;
    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        id = 1+cnt;
        cnt++;
        ArrayList<Store> a = new ArrayList<>();
        paststore = a;
        ArrayList<Product> b = new ArrayList<>();
        hasBuyed = b;
        ArrayList<Product> c = new ArrayList<>();
        shoppingCart = c;
        ArrayList<Store> d =  new ArrayList<>();
        hasGone = d;
    }
    public boolean rateProduct(Product product, int rating) {
        if ((rating <= 5)&&(rating >= 1)) {
            product.setRating(rating);
            return true;
        } else {
            return false;
        }
    }
    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }
    public boolean purchaseProduct(Store store, Product product) {
        if ((store.hasProduct(product))&&(wallet >= product.getPrice())) {
            wallet = wallet - product.getPrice();
            store.setIn(-product.getPrice());
            store.removeProduct(product);
            shoppingCart.add(product);
            paststore.add(store);
            hasBuyed.add(product);
            hasGone.add(store);
            return true;
        } else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> NEW = new ArrayList<>();
        for (int i = 0; i < shoppingCart.size(); i++) {
            NEW.add(shoppingCart.get(i));
        }
        ArrayList<Product> MN = new ArrayList<>();
        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        } else if (sortMethod.equals(SortBy.Price)) {
            float[] prices = new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                prices[i] = shoppingCart.get(i).getPrice();
            }
            Arrays.sort(prices);
            for (int i = 0; i < prices.length; i++) {
                for (int i1 = 0; i1 < NEW.size(); i1++) {
                    if (NEW.get(i1).getPrice() == prices[i]) {
                        MN.add(NEW.get(i1));
                        NEW.remove(i1);
                        i1 = i1 - 1;
                    }
                }
            }
            for (int i = 0; i < MN.size(); i++) {
                System.out.println(MN.get(i).toString());
            }
        } else if (sortMethod.equals(SortBy.Rating)) {
            float[] rates = new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                rates[i] = shoppingCart.get(i).getAvgRating();
            }
            Arrays.sort(rates);
            for (int i = 0; i <  rates.length; i++) {
                for (int i1 = 0; i1 < NEW.size(); i1++) {
                    if (NEW.get(i1).getAvgRating() == rates[i]) {
                        MN.add(NEW.get(i1));
                        NEW.remove(i1);
                        i1 = i1-1;
                    }
                }
            }
            for (int i = 0; i < MN.size(); i++) {
                System.out.println(MN.get(i).toString());
            }

        }
    }
    public boolean refundProduct(Product product) {
        boolean a = false;
        Loop:
        for (int i = 0;i < hasBuyed.size();i++) {
            if ((hasBuyed.get(i).equals(product))&&(hasGone.get(i).getIncome() >= product.getPrice())) {
                wallet = wallet + product.getPrice();
                shoppingCart.remove(product);
                paststore.get(i).setIn(product.getPrice());
                paststore.get(i).addProduct(product);
                paststore.remove(i);
                hasGone.remove(i);
                hasBuyed.remove(i);
                a = true;
                break Loop;
            }
        }
        return a;
    }
}
