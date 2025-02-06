import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt=0;
    private int cnt2=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt ++;
        id = cnt;
        this.shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            product.setSellsFrom(store);
            product.setSellsTime(cnt2);
            cnt2++;
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            return true;
        }else {
            return false;
        }
    }


    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for(int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            case Rating:
                ArrayList<Product> sortR =  new ArrayList<>(shoppingCart);
                for(int a=0;a<sortR.size();a++){
                    for(int b=a+1;b<sortR.size();b++){
                        if(sortR.get(a).getAvgRating()>sortR.get(b).getAvgRating()){
                            Product temp = sortR.get(a);
                            sortR.set(a,sortR.get(b));
                            sortR.set(b,temp);
                        }else if(sortR.get(a).getAvgRating()==sortR.get(b).getAvgRating()){
                            if(sortR.get(a).getSellsTime()>sortR.get(b).getSellsTime()){
                                Product temp = sortR.get(a);
                                sortR.set(a,sortR.get(b));
                                sortR.set(b,temp);
                            }
                        }
                    }
                }
                for(int i=0;i<sortR.size();i++){
                    System.out.println(sortR.get(i).toString());
                }
                break;

            case Price:
                ArrayList<Product> sortP =  new ArrayList<>(shoppingCart);
                for(int a=0;a<sortP.size();a++){
                    for(int b=a+1;b<sortP.size();b++){
                        if(sortP.get(a).getPrice()>sortP.get(b).getPrice()){
                            Product temp = sortP.get(a);
                            sortP.set(a,sortP.get(b));
                            sortP.set(b,temp);
                        }
                    }
                }
                for(int i=0;i<sortP.size();i++){
                    System.out.println(sortP.get(i).toString());
                }
                break;
        }
    }



    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            product.getSellsFrom().transact(product,1);
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            return true;
        }else {
            return false;
        }
    }
}
