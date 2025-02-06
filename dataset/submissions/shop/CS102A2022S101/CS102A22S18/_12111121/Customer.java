import java.util.ArrayList;
public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Store> shoppingStore = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating < 1 || rating > 5) return false;
        else {
            product.setRating(rating);
            return true;
        }
    }
    public void updateWallet(float amount) {
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product) {
        if(store.hasProduct(product)==true && wallet>=product.getPrice()) {
            store.transact(product,0);
            shoppingCart.add(product); wallet-= product.getPrice();
            shoppingStore.add(shoppingCart.indexOf(product),store);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod) {
        if(sortMethod == SortBy.PurchaseTime) {
            for(int i=0;i<shoppingCart.size();i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        else if(sortMethod == SortBy.Rating) {
            ArrayList<Product> shoppingCart1 = new ArrayList<>();
            for(int i=0;i<shoppingCart.size();i++) shoppingCart1.add(shoppingCart.get(i));
            for(int i=0;i<shoppingCart1.size();i++) {
                for(int j=0;j<shoppingCart1.size()-1;j++) {
                    if(shoppingCart1.get(j+1).getAvgRating() < shoppingCart1.get(j).getAvgRating()) {
                        Product p = shoppingCart1.get(j);
                        shoppingCart1.set(j,shoppingCart1.get(j+1));
                        shoppingCart1.set(j+1,p);
                    }
                }
            }

            for(int i=0;i<shoppingCart1.size();i++) {
                System.out.println(shoppingCart1.get(i).toString());
            }
        }
        else if(sortMethod == SortBy.Price) {
            ArrayList<Product> shoppingCart1 = new ArrayList<>();
            for(int i=0;i<shoppingCart.size();i++) shoppingCart1.add(shoppingCart.get(i));
            for(int i=0;i<shoppingCart1.size();i++) {
                for(int j=0;j<shoppingCart1.size()-1;j++) {
                    if(shoppingCart1.get(j+1).getPrice() < shoppingCart1.get(j).getPrice()) {
                        Product p = shoppingCart1.get(j);
                        shoppingCart1.set(j,shoppingCart1.get(j+1));
                        shoppingCart1.set(j+1,p);
                    }
                }
            }

            for(int i=0;i<shoppingCart1.size();i++) {
                System.out.println(shoppingCart1.get(i).toString());
            }
        }
    }

    public boolean refundProduct(Product product) {
        if(shoppingCart.indexOf(product)!=-1) {
            shoppingStore.get(shoppingCart.indexOf(product)).transact(product,1);
            shoppingStore.remove( shoppingCart.indexOf(product));
            shoppingCart.remove(product); wallet+=product.getPrice();

            return true;
        }
        else return false;
    }
}
