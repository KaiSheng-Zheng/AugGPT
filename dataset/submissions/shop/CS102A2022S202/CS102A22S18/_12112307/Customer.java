import java.util.ArrayList;

public class Customer {
    private static int cnt =0;
    private int id = 0;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Store> storeList = new ArrayList<>();
    private float wallet = 0;
    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if (product.setRating(rating)){
            return true;
        } return false;
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet>= product.getPrice()){
            shoppingCart.add(product);
            storeList.add(store);
            wallet -= product.getPrice();
            store.transact(product,0);
            return true;
        } return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (shoppingCart.size() == 0) {
        }else {
            if (sortMethod == SortBy.PurchaseTime) {
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
            } else if (sortMethod == SortBy.Rating) {
                for (int i = 0; i < shoppingCart.size() - 1; i++) {
                    for (int j = 0; j < shoppingCart.size() - 1 - i; j++) {
                        if (shoppingCart.get(j).getAvgRating() > shoppingCart.get(j + 1).getAvgRating()) {
                            Product k = shoppingCart.get(j);
                            shoppingCart.set(j, shoppingCart.get(j + 1));
                            shoppingCart.set(j + 1, k);
                        } else if (shoppingCart.get(j).getAvgRating() == shoppingCart.get(j + 1).getAvgRating()) {
                            float sum1 = 0;
                            float sum2 = 0;
                            for (int k = 0; k < shoppingCart.get(j).getRatings().size(); k++) {
                                sum1 += shoppingCart.get(j).getRatings().get(k);
                            }
                            for (int k = 0; k < shoppingCart.get(j + 1).getRatings().size(); k++) {
                                sum2 += shoppingCart.get(j + 1).getRatings().get(k);
                            }
                            if ((sum1 / shoppingCart.get(j).getRatings().size()) > (sum2 / shoppingCart.get(j + 1).getRatings().size())) {
                                Product k = shoppingCart.get(j);
                                shoppingCart.set(j, shoppingCart.get(j + 1));
                                shoppingCart.set(j + 1, k);
                            }
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
            } else if (sortMethod == SortBy.Price) {
                for (int i = 0; i < shoppingCart.size() - 1; i++) {
                    for (int j = 0; j < shoppingCart.size() - 1 - i; j++) {
                        if (shoppingCart.get(j).getPrice() > shoppingCart.get(j + 1).getPrice()) {
                            Product k = shoppingCart.get(j);
                            shoppingCart.set(j, shoppingCart.get(j + 1));
                            shoppingCart.set(j + 1, k);
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
            }
        }
    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            int m = 0;
            for (int i=0;i<shoppingCart.size();i++){
                if (shoppingCart.get(i) == product){
                    m = i;
                }
            }
            shoppingCart.remove(product);
            wallet += product.getPrice();
            storeList.get(m).transact(product,1);
            return true;
        } return false;
    }

}
