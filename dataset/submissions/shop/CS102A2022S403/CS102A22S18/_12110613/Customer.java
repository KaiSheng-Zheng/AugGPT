import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name,float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product,int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store,Product product){
        if(store.hasProduct(product)&&product.getPrice()<=this.wallet){
            this.wallet-=product.getPrice();
            this.shoppingCart.add(product);
            store.getProductList().remove(product);
            store.setIncome(store.getIncome()+product.getPrice());
            product.setStore(store);
            return true;
        }else
            return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod == SortBy.PurchaseTime){
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if(sortMethod==SortBy.Rating){
            ArrayList<Product> copy = new ArrayList<>(shoppingCart);
            float[] rating=new float[copy.size()];
            for(int i=0;i<copy.size();i++){
                rating[i]=copy.get(i).getAvgRating();
            }
            Arrays.sort(rating);
            for (float v : rating) {
                for (int j = 0; j < copy.size(); j++) {
                    if (v == copy.get(j).getAvgRating()) {
                        System.out.println(copy.get(j).toString());
                        copy.set(j, new Product("",-1));
                    }
                }
            }
        }
        if(sortMethod==SortBy.Price){
            ArrayList<Product> copy=new ArrayList<>(shoppingCart);
            float[] price=new float[copy.size()];
            for(int i=0;i<copy.size();i++){
                price[i]=copy.get(i).getPrice();
            }
            Arrays.sort(price);
            for (float v : price) {
                for (int j = 0; j < copy.size(); j++) {
                    if (v == copy.get(j).getPrice()) {
                        System.out.println(copy.get(j).toString());
                        copy.set(j, new Product("",-1));
                    }
                }
            }
        }
    }

    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet+=product.getPrice();
            product.getStore().transact(product,1);
            return true;
        }else
            return false;
    }
}
