import java.util.ArrayList;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products;default is empty.
    private ArrayList<Store> storeLists = new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        cnt++;
        this.name = name;
        this.wallet = wallet;
        id = cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet >= product.getPrice()){
            store.transact(product,0);
            shoppingCart.add(product);
            storeLists.add(store);
            updateWallet(-product.getPrice());
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (Product product : shoppingCart) {
                    System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f%n", product.getId(), product.getName(), product.getPrice(), product.getAvgRating());
                }
                break;
            case Price:
                ArrayList<Product> a = (ArrayList<Product>) shoppingCart.clone();
                for(int x=0;x<a.size();x++){
                    for (int y=x+1;y<a.size();y++){
                        if(a.get(x).getPrice()>a.get(y).getPrice()){
                            Product change = a.get(x);
                            a.set(x,a.get(y));
                            a.set(y,change);
                        }
                        if(a.get(x).getPrice()==a.get(y).getPrice()&&shoppingCart.indexOf(a.get(x))>shoppingCart.indexOf(a.get(y))){
                            Product change = a.get(x);
                            a.set(x,a.get(y));
                            a.set(y,change);
                        }
                    }
                }
                for (Product product : a) {
                    System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f%n", product.getId(), product.getName(), product.getPrice(), product.getAvgRating());
                }
                break;
            case Rating:
                ArrayList<Product> b = (ArrayList<Product>) shoppingCart.clone();
                for(int x=0;x<b.size();x++){
                    for (int y=x+1;y<b.size();y++){
                        if(b.get(x).getAvgRating()>b.get(y).getAvgRating()){
                            Product change = b.get(x);
                            b.set(x,b.get(y));
                            b.set(y,change);
                        }
                        if(b.get(x).getAvgRating()==b.get(y).getAvgRating()&&shoppingCart.indexOf(b.get(x))>shoppingCart.indexOf(b.get(y))){
                            Product change = b.get(x);
                            b.set(x,b.get(y));
                            b.set(y,change);
                        }
                    }
                }
                for (Product product : b) {
                    System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f%n", product.getId(), product.getName(), product.getPrice(), product.getAvgRating());
                }
                break;
        }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)) {
            storeLists.get(shoppingCart.indexOf(product)).transact(product,1);
            storeLists.remove(shoppingCart.indexOf(product));
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            return true;
        }else {
            return false;
        }
    }
}
