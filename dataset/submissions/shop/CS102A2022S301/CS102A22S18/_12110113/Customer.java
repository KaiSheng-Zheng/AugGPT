import java.util.ArrayList;

public class Customer {
    public static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    public ArrayList<Store> storeCart=new ArrayList<>();

    private float wallet;
    public Customer(String name,float wallet){
        cnt++;
        this.name=name;
        this.wallet=wallet;
        id=cnt;
    }

    public boolean rateProduct(Product product,int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet=wallet+amount;
    }

    public boolean purchaseProduct(Store store,Product product){
        if (store.hasProduct(product)&&wallet>=product.getPrice()){
            store.transact(product,0);
            shoppingCart.add(product);
            storeCart.add(store);
            updateWallet(-product.getPrice());
            return true;
        }
        else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        else if (sortMethod==SortBy.Rating){
            for (int i=1;i<shoppingCart.size();i++){
                Product temp=shoppingCart.get(i);
                int j=0;
                for (j=i-1;j>=0;j--){
                    if (shoppingCart.get(j).getAvgRating()>temp.getAvgRating()){
                        shoppingCart.set(j+1,shoppingCart.get(j));
                    }
                    else {
                        break;
                    }
                }
                if (shoppingCart.get(j+1).getAvgRating()!=temp.getAvgRating()){
                    shoppingCart.set(j+1,temp);
                }
            }
            for (Product n:shoppingCart){
                System.out.println(n.toString());
            }
        }
        else if (sortMethod==SortBy.Price){
            for (int i=1;i<shoppingCart.size();i++){
                Product temp=shoppingCart.get(i);
                int j=0;
                for (j=i-1;j>=0;j--){
                    if (shoppingCart.get(j).getPrice()>temp.getPrice()){
                        shoppingCart.set(j+1,shoppingCart.get(j));
                    }
                    else {
                        break;
                    }
                }
                if (shoppingCart.get(j+1).getPrice()!=temp.getPrice()){
                    shoppingCart.set(j+1,temp);
                }
            }
            for (Product n:shoppingCart){
                System.out.println(n.toString());
            }
        }
    }

    public boolean refundProduct(Product product){
            int i=shoppingCart.indexOf(product);
            if (i!=-1){
            storeCart.get(i).transact(product,1);
            storeCart.remove(i);
            shoppingCart.remove(i);
            updateWallet(product.getPrice());
            return true;
            }
            else return false;
    }

}
