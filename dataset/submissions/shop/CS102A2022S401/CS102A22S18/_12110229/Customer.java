import java.awt.*;
import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private ArrayList<Store> storeRecord=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt+=1;
        this.id=cnt;
    }

    public boolean rateProduct(Product product , int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store,Product product){
        if (store.hasProduct(product)&&wallet >= product.getPrice()){
            store.transact(product,0);
            this.wallet-=product.getPrice();
            shoppingCart.add(product);
            storeRecord.add(store);
            return true;
        }
        return false;

    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (int k=0;k<shoppingCart.size();k++) {
                System.out.println(shoppingCart.get(k));
            }
        }
        if (sortMethod==SortBy.Price){
//            Product[] tmp =new Product[this.shoppingCart.size()];
//            for (int m=0;m<this.shoppingCart.size();m++){
//                tmp[m]=this.shoppingCart.get(m);
//            }
            Product[] sort =new Product[this.shoppingCart.size()];
            for (int i=0;i<this.shoppingCart.size();i++){
                int count=0;
                for (int j=0;j<this.shoppingCart.size();j++){
                    if (i!=j && this.shoppingCart.get(i).getPrice()>this.shoppingCart.get(j).getPrice()){
                        count+=1;
                    }
                }
                while (true){
                    if (sort[count]==null) {
                        sort[count] = this.shoppingCart.get(i);
                        break;
                    } else {
                        count++;
                    }
                }
            }
            for (int k=0;k<sort.length;k++) {
                System.out.println(sort[k]);
            }
        }
        if (sortMethod==SortBy.Rating){
            Product[] sort =new Product[this.shoppingCart.size()];
            for (int i=0;i<this.shoppingCart.size();i++){
                float tmp = this.shoppingCart.get(i).getAvgRating();
                int count=0;
                for (int j=0;j<this.shoppingCart.size();j++){
                    if (i!=j && this.shoppingCart.get(i).getAvgRating()>this.shoppingCart.get(j).getAvgRating()){
                        count+=1;
                    }
                }
                while (true){
                    if (sort[count]==null) {
                        sort[count] = this.shoppingCart.get(i);
                        break;
                    } else {
                        count++;
                    }
                }
            }
            for (int k=0;k<sort.length;k++){
                System.out.println(sort[k]);
            }
        }
    }

    public boolean refundProduct(Product product){
        for (int i=0;i<shoppingCart.size();i++){
            if(shoppingCart.get(i)==product) {
                shoppingCart.remove(i);
                storeRecord.get(i).transact(product, 1);
                storeRecord.remove(i);
                this.wallet += product.getPrice();
                return true;
            }
        }
        return false;
    }
}
