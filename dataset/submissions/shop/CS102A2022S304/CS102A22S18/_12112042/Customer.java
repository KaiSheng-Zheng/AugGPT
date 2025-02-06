import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        if (amount >= 0) {
            this.wallet = this.wallet + amount;
        } else {
            this.wallet = this.wallet + amount;
        }
    }

    public float getWallet() {
        return this.wallet;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && getWallet()>= product.getPrice()) {
            updateWallet(-product.getPrice());
            this.shoppingCart.add(product);
            store.transact(product,0);
            product.setStore(store);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product m : this.shoppingCart) {
                System.out.println(m.toString());
            }
        } else if (sortMethod == SortBy.Rating) {
            for (int i = 0; i < this.shoppingCart.size() - 1; i++) {
                for (int j = 0; j < this.shoppingCart.size()-i-1; j++) {
                    if(this.shoppingCart.get(j).getPrice()>this.shoppingCart.get(j+1).getPrice()){
                        Product temp = this.shoppingCart.get(j);
                        this.shoppingCart.set(j,shoppingCart.get(j+1));
                        this.shoppingCart.set(j+1,temp);
                    }
                }
            }
            for (Product m : this.shoppingCart) {
                System.out.println(m.toString());
            }
        } else if (sortMethod == SortBy.Price) {
            for (int i = 0; i < this.shoppingCart.size() - 1; i++) {
                for (int j = 0; j < this.shoppingCart.size()-i-1; j++) {
                    if(this.shoppingCart.get(j).getPrice()> this.shoppingCart.get(j+1).getPrice()){
                        Product temp = this.shoppingCart.get(j);
                        this.shoppingCart.set(j,this.shoppingCart.get(j+1));
                        this.shoppingCart.set(j+1,temp);
                    }
                }
            }
            for (Product m : this.shoppingCart) {
                System.out.println(m.toString());
            }
        }
    }

    public boolean refundProduct(Product product) {
        int count = 0;
        for (int i = 0; i < this.shoppingCart.size(); i++) {
            if(product == shoppingCart.get(i)){
                count++;
            }
        }
        if(count!=0){
            product.getStore().transact(product,1);
            this.shoppingCart.remove(product);
            updateWallet(product.getPrice());
            return true;
        }else{
            return false;
        }
    }
}
