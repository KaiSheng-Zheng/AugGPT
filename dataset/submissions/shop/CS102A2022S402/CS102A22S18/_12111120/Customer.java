import java.util.ArrayList;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
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
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
            if (store.hasProduct(product) && wallet >= product.getPrice()) {
                store.transact(product , 0);
                store.removeProduct(product);
                wallet -= product.getPrice();
                shoppingCart.add(product);
                return true;
            }else {
                return false;
            }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> products = new ArrayList<>(shoppingCart.size());
        products.addAll(shoppingCart);
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product p : products) {
                System.out.println(p.toString());
            }
        } else if (sortMethod == SortBy.Rating) {
            for (int i = 0; i < products.size(); i++) {
                for (int j = 0; j < products.size() - 1 - i; j++) {
                    if (products.get(j).getAvgRating() > products.get(j + 1).getAvgRating()) {
                        Product pp = products.get(j);
                        products.set(j, products.get(j + 1));
                        products.set(j+1 , pp);
                    }
                }
            }
            for (Product p : products) {
                System.out.println(p.toString());
            }
        } else if (sortMethod == SortBy.Price) {
            for (int i = 0; i < products.size(); i++) {
                for (int j = 0; j < products.size()-1-i; j++) {
                    if (products.get(j).getPrice() > products.get(j+1).getPrice()){
                        Product pp = products.get(j);
                        products.set(j, products.get(j + 1));
                        products.set(j+1 , pp);
                    }
                }
            }
            for (Product p : products) {
                System.out.println(p.toString());
            }
        }
    }

    public boolean refundProduct(Product product){
        return true;
    }
}
