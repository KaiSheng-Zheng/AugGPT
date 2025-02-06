
import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product>shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name,float wallet){
        this.id=1+cnt;
        cnt=cnt+1;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product,int rating){
        if (product.setRating(rating)){

            return true;
        }
        else return false;
    }
    public void updateWallet(float amount){
        this.wallet=wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet>=product.getPrice()){
            shoppingCart.add(product);
            wallet-=product.getPrice();
            store.removeProduct(product);
            store.addIncome(product.getPrice());
            return true;
        }
        else return false;
    }
    public  void viewShoppingCart(SortBy sortMethod){
if(shoppingCart.size()==0){return;}
      else  if(sortMethod== SortBy.PurchaseTime){
            for(int i=0;i<shoppingCart.size();i++){
                System.out.println( shoppingCart.get(i).toString());
            }
        }
        else if (sortMethod== SortBy.Price){
    ArrayList<Product> product2=new ArrayList<>();
    int i=0;
    int k=0;
    int j=0;

            while(i<shoppingCart.size()){
                product2.add(shoppingCart.get(i));
                i=i+1;
            }
            float[]price2=new float[shoppingCart.size()];
            while (j<price2.length){
                price2[j]=shoppingCart.get(j).getPrice();
                j=j+1;
            }
            Arrays.sort(price2);
            while(k<price2.length) {
                for (int l=0;l<product2.size();l++){
                    if (price2[k]==product2.get(l).getPrice()){
                        System.out.println(product2.get(l).toString());
                        product2.remove(l);
                        break;
                    }
               }
          k=k+1;  }
        }
        else if (sortMethod== SortBy.Rating){
    ArrayList<Product> product3=new ArrayList<>();
    int i=0;

    int j=0;
    int k=0;

    while (i<shoppingCart.size()){
        product3.add(shoppingCart.get(i));
        i=i+1;
    }
    float[]rating2=new float[shoppingCart.size()];
    while (j<rating2.length){
                rating2[j]=shoppingCart.get(j).getAvgRating();
                j=j+1;
            }
            Arrays.sort(rating2);
           while (k<rating2.length) {
                for (int l=0;l<product3.size();l++){
                    if (rating2[k]==product3.get(l).getAvgRating()){
                        System.out.println(product3.get(l).toString());
                        product3.remove(l);
                        break;
                    }
                }
               k=k+1;      }
     }
    }
    public boolean refundProduct(Product product){
        int judge=0;
        for(int i=0;i<shoppingCart.size();i++){

            if (product.equals(shoppingCart.get(i))){
                judge=1;
                shoppingCart.remove(i);
                wallet=wallet+shoppingCart.get(i).getPrice();
                break;
            }
        }
  if(judge==1){
      return true;
  }
    else return false;}


}