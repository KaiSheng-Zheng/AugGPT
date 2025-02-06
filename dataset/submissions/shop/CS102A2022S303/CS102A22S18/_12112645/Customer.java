
import java.util.ArrayList;
//import java.util.Arrays;

public class Customer {
    //???17wrong member various
    private static int cnt=0; // initialized to 0, and will increase by 1 when theconstructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;
    private ArrayList<Store> shoppingStore=new ArrayList<>();//The list of store which has been purchased products
    //Constructor
    public Customer(String name, float wallet){
        cnt++;
        id=cnt;//????????
        this.name=name;
        this.wallet=wallet;
    }
    //Methods
    //??? 18+19
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
   //???20+21
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&this.wallet>= product.getPrice()){
            shoppingStore.add(store);
            shoppingCart.add(product);
            store.addIncome(product.getPrice());
            wallet-= product.getPrice();
            return store.removeProduct(product);
        }else {return false;}
    }
    //???22+23+24
    public void viewShoppingCart(SortBy sortMethod){
/*

 */
     if(sortMethod== SortBy.PurchaseTime){
         for (int i = 0; i < shoppingCart.size(); i++) {
             System.out.println(shoppingCart.get(i).toString());
         }
     }
     if(sortMethod==SortBy.Price){
         int order[]=new int [shoppingCart.size()];
         float price[]=new float[shoppingCart.size()];
         for (int i = 0; i < shoppingCart.size(); i++) {
             order[i]=i;
             price[i]=shoppingCart.get(i).getPrice();
         }
         for (int i = 0; i < shoppingCart.size(); i++) {
             for (int j = i+1; j <shoppingCart.size() ; j++) {
                 if(price[i]>price[j]){
                     int orderChange;float priceChange;;

                 priceChange=price[i];price[i]=price[j];price[j]=priceChange;
                 orderChange=order[i];order[i]=order[j];order[j]=orderChange;
                 }
             }
         }
         for (int i = 0; i < shoppingCart.size(); i++) {
             System.out.println(shoppingCart.get(order[i]).toString());
         }
     }
     if(sortMethod==SortBy.Rating){
       int order[]=new int[shoppingCart.size()];
       int rating [] =new int [shoppingCart.size()];
       int number []=new int[shoppingCart.size()];
         for (int i = 0; i < shoppingCart.size(); i++) {
             order[i]=i;
             rating [i]=shoppingCart.get(i).getRating();
             number[i]=shoppingCart.get(i).getNumber();
         }
         for (int i = 0; i < shoppingCart.size(); i++) {
             for (int j = i+1; j <shoppingCart.size() ; j++) {
                 if((number[j]*rating[i]>number[i]*rating[j])&&!(number[j]*rating[i]==number[i]*rating[j])){
                     int orderChange;int rateChange;int numberChange;
                     rateChange=rating[i];rating[i]=rating[j];rating[j]=rateChange;
                     orderChange=order[i];order[i]=order[j];order[j]=orderChange;
                     numberChange=number[i];number[i]=number[j];number[j]=numberChange;
                 }
             }
         }
         for (int i = 0; i < shoppingCart.size(); i++) {
             System.out.println(shoppingCart.get(order[i]).toString());
         }
     }
    }
   //???25
    public boolean refundProduct(Product product){
      if(shoppingCart.contains(product)){
          shoppingStore.get(Num(product)).setProductList(product);
          shoppingStore.get(Num(product)).minusIncome(product.getPrice());
          shoppingStore.remove(Num(product));
          wallet+=product.getPrice();
          shoppingCart.remove(product);
          return true;
      }else {return false;}
    }
    //extra method
    public  int Num(Product product){
        int num=0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i)==product){num=i;break;}
        }
        return num;
    }
}
