import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        this.id = cnt + 1;
        cnt++;
        shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet = this.wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && this.wallet >= product.getPrice()){
            store.removeProduct(product);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.updIncome(product.getPrice());
            return true;
        }
        else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        Collections.sort(this.shoppingCart, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(sortMethod.equals(SortBy.PurchaseTime)){
                    return -1;
                }
                else if(sortMethod.equals(SortBy.Rating)){
                    if(o1.getAvgRating() < o2.getAvgRating()) return -1;
                    else if(o1.getAvgRating() == o2.getAvgRating()) return 0;
                    return 1;
                }
                else{
                    if(o1.getPrice() < o2.getPrice()) return -1;
                    else if(o1.getPrice() == o2.getPrice()) return 0;
                    return 1;
                }
            }
        });
        for (Product product : shoppingCart) {
            System.out.println(product);
        }
    }

    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());


            return true;
        }
        else return false;
    }

    public void SortBy(SortBy a){
        switch (a){
            case Price:{

            }
            case PurchaseTime:{

            }
            case Rating:{

            }
        }
    }
}
