import java.util.ArrayList;

public class Customer {
    private static int cnt =0;
    private int id =0;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt += 1; id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet >= product.getPrice()){
            store.transact(product, 0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            return true;
        }
        else
            return  false;
    }
    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                for (Product p : shoppingCart) System.out.println(p);
                break;
            case Rating:
                Product[] p = new Product[shoppingCart.size()];
                shoppingCart.toArray(p);
                for (int a = 1; a < p.length; a++) {
                    for (int i = 0; i < p.length - 1; i++) {
                        if (p[i].getAvgRating() > p[i + 1].getAvgRating()) {
                            Product p1 = p[i];
                            p[i] = p[i + 1];
                            p[i + 1] = p1;
                        }
                    }
                }
                for (Product product : p) {
                    System.out.println(product);
                }
                break;
            case Price:
                Product[] pr = new Product[shoppingCart.size()];
                shoppingCart.toArray(pr);
                for (int a = 1; a < pr.length; a++) {
                    for (int i = 0; i < pr.length - 1; i++) {
                        if (pr[i].getPrice() > pr[i + 1].getPrice()) {
                            Product pr1 = pr[i];
                            pr[i] = pr[i + 1];
                            pr[i + 1] = pr1;
                        }
                    }
                }
                for (Product product : pr) {
                    System.out.println(product);
                }
                break;
        }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            product.getStore().transact(product, 1);
            return true;
        }
        else
            return false;
    }

}

