import java.util.*;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    private ArrayList<Object[]> listProductStore;


    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
        this.shoppingCart = new ArrayList<Product>();
        listProductStore = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)){
            return true;
        }
        return false;
    }
    public void updateWallet(float amount){
        this.wallet += amount;
    }



    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && this.wallet >= product.getPrice()) {
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product,0);
            listProductStore.add(new Object[]{product, store});
            return true;
        }
        else
            return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> shoppingCartClone = new ArrayList<Product>();
        shoppingCartClone.addAll(shoppingCart);

        if(sortMethod == SortBy.Rating){
            Collections.sort(shoppingCartClone, (a,b) -> Float.compare(a.getAvgRating(),b.getAvgRating()));
            for(int i = 0; i < shoppingCartClone.size(); i++)
                System.out.println(shoppingCartClone.get(i));
        }
        else if(sortMethod == SortBy.Price){
            Collections.sort(shoppingCartClone, (a,b) -> Float.compare(a.getPrice(),b.getPrice()));
            for(int i = 0; i < shoppingCartClone.size(); i++)
                System.out.println(shoppingCartClone.get(i));
        }
        else{
            for(int i = 0; i < shoppingCartClone.size(); i++)
                System.out.println(shoppingCartClone.get(i));
        }
    }

    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());

            for(Object[] e : listProductStore){
                if((Product) e[0] == product){
                    Store s = (Store)e[1];
                    s.transact(product, 1);
                    listProductStore.remove(e);
                    break;
                }
            }
            return true;
        }
        return false;
    }
}