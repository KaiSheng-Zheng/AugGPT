import java.util.*;

public class Customer {
    private HashMap<Product,Store> hashMap = new HashMap<>();
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
        Customer.cnt++;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&(this.wallet >= product.getPrice())){
            product.setDate(new Date());
            shoppingCart.add(product);
            wallet -= product.getPrice();
            store.getProductList().remove(product);
            store.transact(product,0);
            return true;
        }
        else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        Collections.sort(shoppingCart, new Comparator<Product>(){
            @Override
            public int compare(Product o1, Product o2) {
                if (sortMethod == SortBy.Price){
                    if (o1.getPrice() > o2.getPrice()) {
                        return 1;
                    }
                    if (o1.getPrice() == o2.getPrice()) {
                        return 0;
                    }
                    return -1;
                }else if (sortMethod == SortBy.Rating){
                    if (o1.getAvgRating() > o2.getAvgRating()) {
                        return 1;
                    }
                    if (o1.getAvgRating() == o2.getAvgRating()) {
                        return 0;
                    }
                    return -1;
                }else if(sortMethod == SortBy.PurchaseTime) {
                    if (o1.getDate().getTime() > o2.getDate().getTime()) {
                        return 1;
                    }
                    if (o1.getDate().getTime() == o2.getDate().getTime()) {
                        return 0;
                    }
                    return -1;
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Product product : shoppingCart) {
            System.out.println(product);
        }
    }
    public boolean refundProduct(Product product){
        for (Product product1 : shoppingCart) {
            if (product.getId() == product1.getId()){
                Store store = hashMap.get(product);
                store.transact(product,1);
                store.getProductList().add(product);
                shoppingCart.remove(product);
                wallet += product.getPrice();
                return true;
            }
        }
        return false;
    }
}