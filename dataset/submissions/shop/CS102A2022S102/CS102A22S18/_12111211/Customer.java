import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;


public class Customer {
    private HashMap<Integer,Store> purchaseSource;

    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        if(rating>=1&&rating<=5){
            product.setRating(rating);
            return true;
        }else {
            return false;
        }
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }


    public boolean purchaseProduct(Store store, Product product){
        if(wallet>=product.getPrice()&&store.hasProduct(product)){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
//            purchaseSource.put(product.getId(),store);
            return true;
        }else {
            return false;
        }
    }

    public boolean refundProduct(Product product){

            return true;

    }




    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product>b=new ArrayList<>();
        ArrayList<Product>c=new ArrayList<>();
        b.addAll(shoppingCart);
        c.addAll(shoppingCart);
        switch (sortMethod){
            case PurchaseTime:{

                for (int i=0;i<b.size();i++) {
                    System.out.println(b.get(i).toString());
                }
                break;
            }
            case Price:{

                float[] a=new float[b.size()];
                for(int i=0;i<b.size();i++){
                    a[i]= shoppingCart.get(i).getPrice();
                }
                Arrays.sort(a);
                for(int i=0;i<shoppingCart.size();i++){
                    for(int j=0;j<shoppingCart.size();j++){
                        if(a[i]==shoppingCart.get(j).getPrice()) {
                            System.out.println(b.get(j).toString());
                            b.remove(j);
                        }
                    }
                }
                break;
            }
            case Rating:{
                float[] a=new float[shoppingCart.size()];
                for(int i=0;i<shoppingCart.size();i++){
                    a[i]=  shoppingCart.get(i).getAvgRating();
                }
                Arrays.sort(a);
                for(int i=0;i<shoppingCart.size();i++){
                    for(int j=0;j<shoppingCart.size();j++){
                        if(a[i]==shoppingCart.get(j).getAvgRating()) {
                            System.out.println(b.get(j).toString());
                            b.remove(j);
                        }
                    }
                }
                break;
            }
        }

    }
}
