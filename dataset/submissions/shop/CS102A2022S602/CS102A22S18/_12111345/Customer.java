import java.util.ArrayList;
public class Customer {
    private static int cnt ;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet += amount;
    }


    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet >= product.getPrice()){
            updateWallet(-product.getPrice());
           shoppingCart.add(product);
           product.store = store;
           store.removeProduct(product);
           store.transact(product,0);
           return true;
        }
        else return false;
    }


    public void viewShoppingCart(SortBy sortMethod){

        if (sortMethod==SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }

        if (sortMethod==SortBy.Price){
            Product temp = null;
            Product[] shoppingCartCopy2 = new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                shoppingCartCopy2 [i] = shoppingCart.get(i);
            }

            for (int i = 0; i < shoppingCart.size()-1; i++) {
                for (int j= 0; j < shoppingCart.size()-1-i; j++) {
                    if (shoppingCartCopy2[j+1].getPrice()<shoppingCartCopy2[j].getPrice()){
                         temp = shoppingCartCopy2 [j];
                        shoppingCartCopy2 [j] = shoppingCartCopy2[j+1];
                        shoppingCartCopy2 [j+1] = temp;
                    }
                }}
            for (int i = 0; i < shoppingCartCopy2.length; i++) {
                System.out.println(shoppingCartCopy2[i]);
            }
        }
        if ( sortMethod == SortBy.Rating){
            Product temp = null;
            Product[] shoppingCartCopy1 = new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                shoppingCartCopy1 [i] = shoppingCart.get(i);
            }
            for (int i = 0; i < shoppingCart.size()-1; i++) {

                for (int j= 0; j < shoppingCart.size()-1-i; j++) {

                    if (shoppingCartCopy1[j].getAvgRating()>shoppingCartCopy1[j+1].getAvgRating()){
                         temp = shoppingCartCopy1 [j];
                        shoppingCartCopy1 [j] = shoppingCartCopy1[j+1];
                        shoppingCartCopy1 [j+1] = temp;
                    }}
                }
            for (int i = 0; i < shoppingCartCopy1.length; i++) {
                System.out.println(shoppingCartCopy1[i]);
            }
        }
    }

    public boolean refundProduct(Product product){
        if (!shoppingCart.contains(product)){
            return false;
        }
        else {
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            product.store.addProduct(product);
            product.store.transact(product,1);
           return true;
        }
    }



}
