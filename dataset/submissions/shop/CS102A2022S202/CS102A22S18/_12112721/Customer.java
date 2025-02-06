import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        boolean rp = product.setRating(rating);
        return rp;
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product)&&this.wallet>=product.getPrice()) {
            store.transact(product,0);
            this.shoppingCart.add(product);
            wallet -= product.getPrice();
            return true;
        }
        else return false;
    }

    public ArrayList<Product> sortByRating(ArrayList<Product> car) {
        ArrayList<Product> cart = car;
        for (int i = 0; i < car.size()-1; i++) {
            for (int j = 0; j < car.size()-1-i; j++) {
                if (cart.get(j).getAvgRating() > cart.get(j+1).getAvgRating()) {
                    Product p = cart.get(j);
                    cart.set(j,cart.get(j+1));
                    cart.set(j+1,p);
                }
            }
        }
        return cart;
    }

    public ArrayList<Product> sortByPrice(ArrayList<Product> car) {
        ArrayList<Product> cart = car;
        for (int i = 0; i < car.size()-1; i++) {
            for (int j = 0; j < car.size()-1-i; j++) {
                if (cart.get(j).getPrice() > cart.get(j+1).getPrice()) {
                    Product p = cart.get(j);
                    cart.set(j,cart.get(j+1));
                    cart.set(j+1,p);
                }
            }
        }
        return cart;
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod) {
            case PurchaseTime:{
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
                break;
            }
            case Rating:{
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println((sortByRating(shoppingCart)).get(i));
                }
                break;
            }
            case Price:{
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println((sortByPrice(shoppingCart)).get(i));
                }
                break;
            }
        }
    }

    public boolean refundProduct(Product product){
        return false;
    }






}
