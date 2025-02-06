import java.util.ArrayList;

public class Customer {
    private static int cnt = 1;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.id = cnt;
        cnt = cnt + 1;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating >= 1 && rating <= 5) {
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
        if (store.getProductList().contains(product) && wallet >= product.getPrice()) {
            wallet = wallet - product.getPrice();
            shoppingCart.remove(product);
            return true;
        } else {
            return false;
        }

    }

    public void viewShoppingCart(SortBy sortMethod) {
        this.shoppingCart=shoppingCart;
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }
            if (sortMethod == SortBy.Rating) {
                float temp;
                for (int i = 0; i < shoppingCart.size(); i++) {
                    for (int j = 0; j < shoppingCart.size(); j++) {
                        float a = shoppingCart.get(i).getAvgRating();
                        float b = shoppingCart.get(j).getAvgRating();
                        if (shoppingCart.get(i).getAvgRating() > shoppingCart.get(i).getAvgRating()) {
                            temp = a;
                            a = b;
                            b = temp;
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }

            }
            if (sortMethod == SortBy.Price) {
                float temp;
                for (int i = 0; i < shoppingCart.size(); i++) {
                    for (int j = 0; j < shoppingCart.size(); j++) {
                        float a = shoppingCart.get(i).getPrice();
                        float b = shoppingCart.get(j).getPrice();
                        if (shoppingCart.get(i).getPrice() > shoppingCart.get(j).getPrice()) {
                            temp = a;
                            a = b;
                            b = temp;
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
            }
    }
    public boolean refundProduct (Product product){
        if (shoppingCart.contains(product)||product.getStore().hasProduct(product)){
            return false;
        } else {
            wallet = wallet + product.getPrice();
            shoppingCart.add(product);
            return true;
        }
    }
}


