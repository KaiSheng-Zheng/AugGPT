import java.util.ArrayList;

enum SortBy {
    PurchaseTime, Rating, Price
}

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private ArrayList<Store> store;
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
        this.shoppingCart=new ArrayList<>();
        this.store = new ArrayList<>();
    }

    public boolean rateProduct(Product product,int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && this.wallet >= product.getPrice()){
            updateWallet(-product.getPrice());
            this.shoppingCart.add(product);
            this.store.add(store);
            store.transact(product,0);
            return true;
        }return false;
    }



    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f",
                        shoppingCart.get(this.shoppingCart.size()-i-1).getId(), 
                        shoppingCart.get(this.shoppingCart.size()-i-1).getName(),
                        shoppingCart.get(this.shoppingCart.size()-i-1).getPrice(), 
                        shoppingCart.get(this.shoppingCart.size()-i-1).getAvgRating());
            }
        }
        if (sortMethod == SortBy.Rating) {
            ArrayList<Product> rating = new ArrayList<>();
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                int k = 0;
                for (int j = i; j < this.shoppingCart.size(); j++) {
                    k = this.shoppingCart.get(i).getAvgRating() > this.shoppingCart.get(j).getAvgRating() ? k++ : k;
                    }
                rating.add(k,this.shoppingCart.get(i));
                }
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f",
                        rating.get(i).getId(), rating.get(i).getName(),
                        rating.get(i).getPrice(), rating.get(i).getAvgRating());
                }
            }
        if (sortMethod == SortBy.Price) {
            ArrayList<Product> rating = new ArrayList<>();
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                int k = 0;
                for (int j = i; j < this.shoppingCart.size(); j++) {
                    k = this.shoppingCart.get(i).getPrice() > this.shoppingCart.get(j).getPrice() ? k++ : k;
                }
                rating.add(k,this.shoppingCart.get(i));
            }
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f",
                        rating.get(i).getId(), rating.get(i).getName(),
                        rating.get(i).getPrice(), rating.get(i).getAvgRating());
            }
        }
    }
    public boolean refundProduct(Product product){

        if (this.shoppingCart.contains(product)){
            updateWallet(+product.getPrice());
            this.shoppingCart.remove(shoppingCart.indexOf(product));
            store.get(shoppingCart.indexOf(product)).transact(product,1);
            this.store.remove(shoppingCart.indexOf(product));
            return true;
        }
        return false;
    }
}

