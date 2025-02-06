import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private HashMap<Product, Store> record = new HashMap<Product, Store>();

    public Customer(String name,float wallet){
        cnt++;
        id = cnt;
        this.name=name;
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            store.transact(product,0);
            shoppingCart.add(product);
            wallet-=product.getPrice();
           record.put(product,store);
            return true;
        }
        else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> tempList = new ArrayList<>(shoppingCart);
//        for (int i=0;i<shoppingCart.size();i++){
//            tempList.add(shoppingCart.get(i));
//        }
        if(sortMethod== SortBy.PurchaseTime){
            for(Product product:tempList){
                System.out.printf(product+System.lineSeparator());
            }
        }
        if(sortMethod== SortBy.Price){
            int flag =0;
            for(int j=0;j<tempList.size()-1;j++){
                if(j!=0&&flag==0){break;}
                flag=0;
                for(int i=1;i<tempList.size();i++){
                    if(tempList.get(i).getPrice()<tempList.get(i-1).getPrice()){
                        Product temp = tempList.get(i-1);
                        tempList.remove(i-1);
                        tempList.add(i,temp);
                        flag++;
                    }
                }
            }
            for(Product product:tempList){
                System.out.printf(product+System.lineSeparator());
            }
        }
        if(sortMethod== SortBy.Rating){
            int flag =0;
            for(int j=0;j<tempList.size()-1;j++){
                if(j!=0&&flag==0){break;}
                flag=0;
                for(int i=1;i<tempList.size();i++){
                    if(tempList.get(i).getAvgRating()<tempList.get(i-1).getAvgRating()){
                        Product temp = tempList.get(i-1);
                        tempList.remove(i-1);
                        tempList.add(i,temp);
                        flag++;
                    }
                }
            }
            for(Product product:tempList){
                System.out.printf(product+System.lineSeparator());
            }
        }
   }
    public boolean refundProduct(Product product){
        if(record.containsKey(product)){
            record.get(product).transact(product,1);
            shoppingCart.remove(product);
            record.remove(product);
            wallet+=product.getPrice();
            return true;
        }
        else{
            return false;
        }
    }
}


