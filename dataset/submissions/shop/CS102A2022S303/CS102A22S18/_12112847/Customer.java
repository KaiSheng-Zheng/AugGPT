import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer{
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private static int cntbuy;

    public Customer(String name, float wallet){
        this.name=name;this.wallet=wallet;cnt++;this.id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){this.wallet+=amount;}
    public boolean purchaseProduct(Store store, Product product){
        if(store.getProductList().contains(product)&&wallet>=product.getPrice()){
            cntbuy++;
            wallet-= product.getPrice();
            shoppingCart.add(product);
            product.setStore(store);
            store.transact(product,0);
            product.setBuy(cntbuy);
            return true;
        }else{
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }else if(sortMethod==SortBy.Rating){
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1,Product o2){
                    if(o1.getAvgRating()< o2.getAvgRating()){return -1;
                    }else if(o1.getAvgRating()> o2.getAvgRating()){return 1;
                    }else {
                        if(o1.getBuy()< o2.getBuy()){return -1;}else{return 1;}
                    }
                }
            });
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }else if(sortMethod==SortBy.Price){
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1,Product o2){
                    if(o1.getPrice()< o2.getPrice()){return -1;
                    }else if(o1.getPrice()> o2.getPrice()){return 1;
                    }else{if(o1.getBuy()< o2.getBuy()){return -1;}else{return 1;}}
                }
            });
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }

    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            wallet+=product.getPrice();
            shoppingCart.remove(product);
            product.getStore().transact(product,1);
            return true;
        }else{return false;}
    }

}
