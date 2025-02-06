import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id = 0;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet = 0;
    private ArrayList<Store> stores = new ArrayList<>();

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if (rating < 1 || rating > 5){
            return false;
        }else {
            product.setRating(rating);
            return true;
        }
    }

    public void updateWallet(float amount){
        this.wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            shoppingCart.add(product);
            wallet = wallet - product.getPrice();
            store.removeProduct(product);
            store.setIncome(store.getIncome() + product.getPrice());
            stores.add(store);
            return true;
        }else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){

    }

    public boolean refundProduct(Product product){
        int a = 0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).equals(product)){
                shoppingCart.remove(product);
                wallet = wallet + product.getPrice();
                Store storeGetFrom = stores.get(i);
                ArrayList<Product> refund = new ArrayList<>();
                for (int j = 0; j < storeGetFrom.getProductList().size(); j++) {
                    refund.add(storeGetFrom.getProductList().get(i));
                }
                refund.add(product);
                    storeGetFrom.setProductList(refund);
                    storeGetFrom.setIncome(storeGetFrom.getIncome() - product.getPrice());
                    a = 1;
            }else {
                a = 2;
            }
        }
        return a == 1;
    }
}
