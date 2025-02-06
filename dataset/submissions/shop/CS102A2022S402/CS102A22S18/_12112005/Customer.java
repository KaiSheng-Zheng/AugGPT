import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products;default is empty.
    private ArrayList<Store> storelist;
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<Product>();
        this.storelist = new ArrayList<Store>();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && (product.getPrice()<=this.wallet)){
            updateWallet(-product.getPrice());
            this.shoppingCart.add(product);
            store.transact(product,0);
            this.storelist.add(store);
            return true;
        }else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        SortBy m1 = SortBy.PurchaseTime;
        SortBy m2 = SortBy.Rating;
        SortBy m3 = SortBy.Price;

        if(sortMethod == m1){
            for(int i=0;i<shoppingCart.size();i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }

        if(sortMethod==m3){
            ArrayList<Product> shoppingCartm3 = new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++) {
                shoppingCartm3.add(shoppingCart.get(i));
            }
            for (int i = 1; i < shoppingCartm3.size(); i++) {
                if (shoppingCartm3.get(i).getPrice() < shoppingCartm3.get(i-1).getPrice()){
                    for (int j = i-1, k = i; j >=0 ; j--,k--) {
                        if(shoppingCartm3.get(k).getPrice() < shoppingCartm3.get(j).getPrice()){
                            Product temp = shoppingCartm3.get(k);
                            shoppingCartm3.set(k,shoppingCartm3.get(j));
                            shoppingCartm3.set(j,temp);
                        }
                        else if(shoppingCartm3.get(i).getPrice() >= shoppingCartm3.get(j).getPrice()){
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < shoppingCartm3.size(); i++) {
                System.out.println(shoppingCartm3.get(i).toString());
            }
//
        }

        if(sortMethod==m2){
//
            ArrayList<Product> shoppingCartm2 = new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++) {
                shoppingCartm2.add(shoppingCart.get(i));
            }
            for (int i = 1; i < shoppingCartm2.size(); i++) {
                if (shoppingCartm2.get(i).getAvgRating() < shoppingCartm2.get(i-1).getAvgRating()){
                    for (int j = i-1, k = i; j >=0 ; j--,k--) {
                        if(shoppingCartm2.get(k).getAvgRating() < shoppingCartm2.get(j).getAvgRating()){
                            Product temp = shoppingCartm2.get(k);
                            shoppingCartm2.set(k,shoppingCartm2.get(j));
                            shoppingCartm2.set(j,temp);
                        }
                        else if(shoppingCartm2.get(i).getAvgRating() >= shoppingCartm2.get(j).getAvgRating()){
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < shoppingCartm2.size(); i++) {
                System.out.println(shoppingCartm2.get(i).toString());
//
            }
//
        }
    }
    public boolean refundProduct(Product product){
        for (int i = 0; i < shoppingCart.size(); i++) {
            if(shoppingCart.get(i).getId() == product.getId()){
                Store store = storelist.get(i);
                if (store.hasremovedProduct(product)){
                    this.shoppingCart.remove(i);
                    this.updateWallet(product.getPrice());
                    store.transact(product,1);
                    storelist.remove(store);
                    return true;
                }
            }
        }
        return false;
    }




}
