import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(0);
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        ++cnt;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (wallet >= product.getPrice()){
            if (store.removeProduct(product)){
                this.wallet -= product.getPrice();
                shoppingCart.add(product);
                product.store = store;
                store.setIncome(store.getIncome() + product.getPrice());
                return true;
            }
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> newShoppingCart = new ArrayList<>(shoppingCart);
        switch (sortMethod){
            case PurchaseTime:
                for (Product product : shoppingCart){
                    System.out.println(product.toString());
                }
                break;
            case Rating:
                newShoppingCart.sort(Comparator.comparingDouble(Product::getAvgRating));
                for (Product product : newShoppingCart){
                    System.out.println(product.toString());
                }
                break;
            case Price:
                newShoppingCart.sort(Comparator.comparingDouble(Product::getPrice));
                for (Product product : newShoppingCart){
                    System.out.println(product.toString());
                }
                break;
        }
    }

    public boolean refundProduct(Product product){
        if (shoppingCart.size() == 0){
            return false;
        }
        for (int i = shoppingCart.size() - 1; i >= 0 ; i --){
            if (shoppingCart.get(i).equals(product)){
                wallet += product.getPrice();
                shoppingCart.remove(i);
                product.store.addProduct(product);
                float income = product.store.getIncome() - product.getPrice();
                product.store.setIncome(income);
                return true;
            }
        }
        return false;
    }
}