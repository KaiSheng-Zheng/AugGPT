import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when theconstructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products;default is empty.
    private float wallet;
    private ArrayList<Store> storeList = new ArrayList<>();
    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet = this.wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (this.wallet >= product.getPrice() && store.hasProduct(product)) {
            this.wallet = this.wallet - product.getPrice();
            shoppingCart.add(product);
            addStore(store);
            store.transact(product,0);
            return true;
        }
        return false;
    }

    public void addStore(Store store){
        for (int i =0; i<storeList.size();i++){
            if (store.getId() == storeList.get(i).getId()){
                return;
            }
        }
        storeList.add(store);
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod.equals(SortBy.PurchaseTime) ) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod.equals(SortBy.Rating) ) {
            int q;
            Product trans;
            for (int i = 0; i < shoppingCart.size() - 1; i++) {
                q = 0;
                for (int p = 0; p < shoppingCart.size() - 1; p++) {
                    if (shoppingCart.get(p).getAvgRating() > shoppingCart.get(p+1).getAvgRating()){
                        trans = shoppingCart.get(p);
                        shoppingCart.set(p,shoppingCart.get(p+1));
                        shoppingCart.set(p+1,trans);
                        q++;
                    }
                }
                if (q == 0){
                    break;
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod.equals(SortBy.Price)){
            int q;
            Product trans;
            for (int i = 0; i < shoppingCart.size() - 1; i++) {
                q = 0;
                for (int p = 0; p < shoppingCart.size() - 1; p++) {
                    if (shoppingCart.get(p).getPrice() > shoppingCart.get(p+1).getPrice()){
                        trans = shoppingCart.get(p);
                        shoppingCart.set(p,shoppingCart.get(p+1));
                        shoppingCart.set(p+1,trans);
                        q++;
                    }
                }
                if (q == 0){
                    break;
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }


    public boolean refundProduct(Product product){
        int p = 0;
        int m;
        for (int i = 0; i < shoppingCart.size();i++){
            if (shoppingCart.get(i).getId() == product.getId()){
                p = 1;
                m = i;
                break;
            }
        }
        if (getStore(product).equals(null)) {
            return false;
        }else if (p == 1){
            getStore(product).transact(product,1);
            shoppingCart.remove(product);
            wallet = wallet + product.getPrice();
            return true;
        }else {
            return false;
        }
    }

    public Store getStore(Product product){

         for (int i=0; i<storeList.size();i++){
            if (storeList.get(i).allhasProduct(product)) {
                return storeList.get(i);
            }
        }
         return null;
    }
}
