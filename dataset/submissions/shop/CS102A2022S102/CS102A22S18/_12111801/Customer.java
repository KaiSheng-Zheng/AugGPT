import java.util.*;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private float wallet;
    private static HashMap pointer = new HashMap<>();
    private ArrayList<Product> shoppingCart = new ArrayList<>();


    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product, int rating){         //
        return product.setRating(rating);
    }

    public void updateWallet(float amount){                          //
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && product.getPrice()<=this.wallet) {
            pointer.put(product.getID(),store);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }
        else{
            return false;
        }

    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime) {
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        } else if (sortMethod==SortBy.Rating) {
            ArrayList<Product> newlist=new ArrayList<>(shoppingCart);
            int index=0;
            while(0!=newlist.size()){
                for(int i=0;i<newlist.size();i++){
                    if(newlist.get(index).getAvgRating()>newlist.get(i).getAvgRating()){
                        index=i;
                    }
                }
                System.out.println(newlist.get(index));
                newlist.remove(index);
                index=0;
            }

        } else if (sortMethod==SortBy.Price) {
            ArrayList<Product> newlist=new ArrayList<>(shoppingCart);
            int index=0;
            while(newlist.size()!=0){
                for(int i=0;i<newlist.size();i++){
                    if(newlist.get(index).getPrice()>newlist.get(i).getPrice()){
                        index=i;
                    }
                }
                System.out.println(newlist.get(index));
                newlist.remove(index);
                index=0;
            }
        }
    }

    public boolean refundProduct(Product product){
        Store store;
        if(shoppingCart.contains(product)){
           store = (Store) pointer.get(product.getID());
           store.transact(product,1);
           updateWallet(product.getPrice());
           shoppingCart.remove(product);
           return true;
        }
        else{
            return false;
        }
    }
}

enum SortBy{
    PurchaseTime, Rating, Price;
}