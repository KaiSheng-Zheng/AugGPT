import java.util.ArrayList;
import java.util.Collections;


public class Customer {
    private static int cnt = 0;
    private int id ;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt = cnt + 1;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)){
            return true;
        }else {
            return false;
        }
    }

    public void updateWallet(float amount){
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if((store.hasProduct(product))&(wallet>= product.getPrice())){
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product, 0);
            product.setStore(store);
            return true;
        }else {
            return false;
        }
    }



    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            case Rating:
                Product product;
                Product[] products = new Product[shoppingCart.size()];
                for (int i = 0; i < products.length; i++) {
                    products[i] = shoppingCart.get(i);
                }
                for (int i = 0; i < products.length-1; i++) {
                    for (int j = 0; j < products.length-i-1; j++) {
                        if(products[j].getAvgRating()>products[j+1].getAvgRating()){
                            product = products[j];
                            products[j] = products[j+1];
                            products[j+1] = product;
                        }
                    }
                }
                for (int i = 0; i < products.length; i++) {
                    System.out.println(products[i].toString());
                }
                break;
            case Price:
                Collections.sort(shoppingCart, (o1, o2) -> (int)(o1.getPrice()-o2.getPrice())*100);
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
        }
    }

    public boolean refundProduct(Product product){
        for (int i = 0; i < shoppingCart.size(); i++) {
            if(shoppingCart.get(i)==product){
                shoppingCart.remove(product);
                updateWallet(product.getPrice());
                product.getStore().transact(product, 1);
                return true;
            }
        }
        return false;
    }
}
