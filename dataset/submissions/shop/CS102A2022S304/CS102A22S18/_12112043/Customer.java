import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
        cnt++;
        this.id = cnt;

    }

    public boolean rateProduct(Product product, int rating) {
        if (!product.setRating(rating)) {
            return false;
        } else {
            return true;
        }
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            store.removeProduct(product);
            this.shoppingCart.add(product);
            this.wallet -= product.getPrice();
            store.setIncome(store.getIncome() + product.getPrice());
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (int n = 0; n < this.shoppingCart.size(); n++) {
                System.out.println(this.shoppingCart.get(n).toString());
            }
        }
        if (sortMethod == SortBy.Rating) {
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                for (int j = 0; j < this.shoppingCart.size()-i-1; j++) {
                    if (this.shoppingCart.get(j).getAvgRating() > (this.shoppingCart.get(j+1).getAvgRating())) {
                        Product p1 = this.shoppingCart.get(j);
                        Product p2 = this.shoppingCart.get(j+1);
                        this.shoppingCart.set(j, p2);
                        this.shoppingCart.set(j+1, p1);
                    } else if (this.shoppingCart.get(j).getAvgRating() <= (this.shoppingCart.get(j+1).getAvgRating())) {
                        Product p1 = this.shoppingCart.get(j);
                        Product p2 = this.shoppingCart.get(j+1);
                        this.shoppingCart.set(j, p1);
                        this.shoppingCart.set(j+1,p2);
                    }
                }
            }
            for (int n = 0; n < this.shoppingCart.size(); n++) {
                System.out.println(this.shoppingCart.get(n).toString());
            }
            if (sortMethod == SortBy.Price) {
                for (int i = 0; i < this.shoppingCart.size(); i++) {
                    for (int j = 0; j < this.shoppingCart.size()-i-1; j++) {
                        if (this.shoppingCart.get(j).getPrice() > (this.shoppingCart.get(j+1).getPrice())) {
                            Product p1 = this.shoppingCart.get(j);
                            Product p2 = this.shoppingCart.get(j+1);
                            this.shoppingCart.set(j, p2);
                            this.shoppingCart.set(j+1, p1);
                        } else if (this.shoppingCart.get(j).getPrice() <= (this.shoppingCart.get(j+1).getPrice())) {
                            Product p1 = this.shoppingCart.get(j);
                            Product p2 = this.shoppingCart.get(j+1);
                            this.shoppingCart.set(j, p1);
                            this.shoppingCart.set(j+1, p2);
                        }
                    }
                }
                for (int n = 0; n < this.shoppingCart.size(); n++) {
                    System.out.println(this.shoppingCart.get(n).toString());
                }
            }
        }
    }

    public boolean refundProduct(Product product) {
        return true;
    }
}