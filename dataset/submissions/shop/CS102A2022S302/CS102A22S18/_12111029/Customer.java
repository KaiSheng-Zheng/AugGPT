import java.util.ArrayList;
import java.util.Arrays;
public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Store> storeRecord = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            store.transact(product, 0);
            shoppingCart.add(product);
            storeRecord.add(store);
            updateWallet(-product.getPrice());
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        } else if (sortMethod.equals(SortBy.Rating)) {
            float[] rating = new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                rating[i] = shoppingCart.get(i).getAvgRating();
            }
            Arrays.sort(rating);
            ArrayList<Float> rate = new ArrayList<>();
            rate.add(rating[0]);
            for (int i = 1; i < rating.length; i++) {
                if (rating[i] != rating[i - 1]) {
                    rate.add(rating[i]);
                }
            }
            for (int i = 0; i < rate.size(); i++) {
                ArrayList<Integer> num = new ArrayList<>();
                for (int j = 0; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(j).getAvgRating() == rate.get(i)) {
                        num.add(j);
                    }
                }
                for (int k = 0; k < num.size(); k++) {
                    System.out.println(shoppingCart.get(num.get(k)).toString());
                }
                num.clear();
            }
        } else if (sortMethod.equals(SortBy.Price)) {
            float[] price = new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                price[i] = shoppingCart.get(i).getPrice();
            }
            Arrays.sort(price);
            ArrayList<Float> pricing = new ArrayList<>();
            pricing.add(price[0]);
            for (int i = 1; i < price.length; i++) {
                if (price[i] != price[i - 1]) {
                    pricing.add(price[i]);
                }
            }
            for (int i = 0; i < pricing.size(); i++) {
                ArrayList<Integer> num = new ArrayList<>();
                for (int j = 0; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(j).getPrice() == pricing.get(i)) {
                        num.add(j);
                    }
                }
                for (int k = 0; k < num.size(); k++) {
                    System.out.println(shoppingCart.get(num.get(k)).toString());
                }
                num.clear();
            }
        }
    }

    public boolean refundProduct(Product product) {
        boolean flag = false;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).getId() == product.getId()) {
                storeRecord.get(i).transact(product, 1);
                shoppingCart.remove(product);
                storeRecord.remove(i);
                updateWallet(product.getPrice());
                flag = true;
                break;
            }
        }
        return flag;
    }
}
