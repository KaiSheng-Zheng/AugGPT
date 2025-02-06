import java.util.ArrayList;

import java.util.Comparator;

public class Customer {

    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        if (rating >= 1 && rating <= 5){
            product.setRating(rating);
            return true;
        }else{
            return false;
        }
    }

    public void updateWallet(float amount){
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){

        if (store.getProductList().contains(product) && this.wallet >= product.getPrice()){
            store.transact(product,0);
            shoppingCart.add(product);
            wallet -= product.getPrice();
            product.setComefrom(store);
            return true;
        }else{
            return false;
        }
    }



    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> sp = new ArrayList<Product>();

        for (Product product : shoppingCart) {
            sp.add(product);
        }
        switch (sortMethod) {
            case PurchaseTime:
                for (Product p : shoppingCart) {
                    System.out.println(p);
                }
                break;
            case Rating:
                sp.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return new Float(o1.getAvgRating()).compareTo(new Float(o2.getAvgRating()));
                    }
                });
                for (Product p : sp) {
                    System.out.println(p);
                }
                break;
            case Price:
                sp.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return new Float(o1.getPrice()).compareTo(new Float(o2.getPrice()));
                    }
                });
                for (Product p : sp) {
                    System.out.println(p);
                }

        }
    }

    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){

            product.getComefrom().transact(product,1);
            shoppingCart.remove(product);
            wallet += product.getPrice();
            return true;
        }else {
            return false;
        }
    }





}

enum SortBy{
    PurchaseTime,Rating,Price
}