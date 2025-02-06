import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Store> stores = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        boolean test = false;
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            product.setRating(rating);
            test = true;
        }else
            return false;
        return test;
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        boolean test = false;
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            test = true;
            shoppingCart.add(product);
            stores.add(store);
            wallet -= product.getPrice();
            store.getProductList().remove(product);
            store.setIncome(store.getIncome() + product.getPrice());

        }
        return test;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        String str = sortMethod.toString();
        String pct = SortBy.PurchaseTime.toString();
        String rat = SortBy.Rating.toString();
        String pric = SortBy.Price.toString();
        if (str.equals(pct)) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }
        if (str.equals(rat)) {
            int[] num = new int[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                num[i] = i;
            }
            for (int i = 0; i < shoppingCart.size() - 1; i++) {
                for (int j = i+1; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(i).getAvgRating() > shoppingCart.get(j).getAvgRating() || shoppingCart.get(i).getAvgRating() == shoppingCart.get(j).getAvgRating() && i > j) {
                        int a = num[i];
                        num[i] = num[j];
                        num[j] = a;
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(num[i]));
            }
        }
        if (str.equals(pric)) {
            int[] num = new int[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                num[i] = i;
            }
            for (int i = 0; i < shoppingCart.size() - 1; i++) {
                for (int j = i+1; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(i).getPrice() > shoppingCart.get(j).getPrice() || shoppingCart.get(i).getPrice() == shoppingCart.get(j).getPrice() && i > j) {
                        int a = num[i];
                        num[i] = num[j];
                        num[j] = a;
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(num[i]));
            }
        }
    }


    public boolean refundProduct (Product product){
        boolean test = false;

        if (shoppingCart.contains(product)) {
            test = true;
            wallet += product.getPrice();
            shoppingCart.remove(product);

            for (int i=0;i<stores.size();i++){
                if (!stores.get(i).hasProduct(product)){
                    stores.get(i).setIncome(stores.get(i).getIncome()-product.getPrice());
                    stores.get(i).getProductList().add(product);
                }
            }
        }
        return test;
    }

}

