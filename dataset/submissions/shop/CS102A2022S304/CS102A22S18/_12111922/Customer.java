import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private ArrayList<Store> stores;
    private ArrayList<Product> Origin;

    public Customer(String name, float wallet){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
        this.wallet = wallet;
        this.stores = new ArrayList<>();
        Origin = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
        if (rating<1||rating>5){
            return false;
        }
        else {
            product.setRating(rating);
            return true;
        }
    }

    public void updateWallet(float amount){
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet>=product.getPrice()){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            stores.add(store);
            Origin.add(product);
            return true;
        }
        else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod == SortBy.Price){
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o1.getPrice()-o2.getPrice());
                }
            });
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        }
        if (sortMethod == SortBy.Rating){
            ArrayList<Product> tempShoppingCart = new ArrayList<>(shoppingCart);
            tempShoppingCart.sort(Comparator.comparing(Product::getAvgRating));
            for (Product product: tempShoppingCart) {
                System.out.println(product);
            }
        }
        if (sortMethod == SortBy.PurchaseTime){
            for (Product product: shoppingCart) {
                System.out.println(product);
            };
        }
    }

    public boolean refundProduct(Product product){
        boolean z = false;
        for (int i =0; i < shoppingCart.size(); i++) {
            if (product.getId() == shoppingCart.get(i).getId()){
                shoppingCart.remove(i);
                updateWallet(product.getPrice());
                z = true;
                break;
            }
        }
        if (z){
            int j = 0;
            while (product.getId() != Origin.get(j).getId()){
                j++;
            }
            stores.get(j).transact(product,1);
        }
        return z;
    }
}
