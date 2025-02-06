import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
        cnt++;
        id = cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if (rating<=5&&rating>=1){
            product.setRating(rating);
            return true;
        }else return false;
    }

    public void updateWallet(float amount){
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.getProductList().contains(product) && this.wallet >= product.getPrice()){
            store.transact(product, 0);
            shoppingCart.add(product);
            this.wallet -= product.getPrice();
            return true;
        }else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case Price:
                ArrayList<Product> change = shoppingCart;
                int s = 1;
                while(s!=0){
                    s = 0;
                    for (int i = 0; i < change.size()-1; i++) {
                        if (change.get(i).getPrice() > change.get(i+1).getPrice()){
                            Product p = change.get(i);
                            change.set(i,change.get(i+1));
                            change.set(i+1,p);
                            s++;
                        }
                    }
                }
                for (int i = 0; i < change.size()-1; i++) {
                    if (change.get(i).getPrice() == change.get(i+1).getPrice()){
                        Product p = change.get(i);
                        change.set(i,change.get(i+1));
                        change.set(i+1,p);
                    }
                }
                for (int i = 0; i < change.size(); i++) {
                    System.out.println(change.get(i));
                }
                break;
            case PurchaseTime:
                ArrayList<Product> change1 = shoppingCart;
                for (int i = 0; i < change1.size(); i++) {
                    System.out.println(change1.get(i));
                }
                break;
            case Rating:
                ArrayList<Product> change2 = shoppingCart;
                int q = 1;
                while(q!=0){
                    q = 0;
                    for (int i = 0; i < change2.size()-1; i++) {
                        if (change2.get(i).getAvgRating() > change2.get(i+1).getAvgRating()){
                            Product pro = change2.get(i);
                            change2.set(i,change2.get(i+1));
                            change2.set(i+1,pro);
                            q++;
                        }
                    }
                }
                for (int i = 0; i < change2.size(); i++) {
                    System.out.println(change2.get(i));
                }
                break;
        }
    }

    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            product.getStore().transact(product, 1);
            shoppingCart.remove(product);
            this.wallet += product.getPrice();
            return true;
        }
        return false;
    }
}
