import java.util.ArrayList;

public class Customer {
private static int cnt=0;
private int id;
private String name;
private ArrayList<Product> shoppingCart=new ArrayList<>();;
private float wallet;
public Customer(String name,float wallet){
    this.name=name;
    this.wallet=wallet;
cnt++;
id=cnt;
}
public boolean rateProduct(Product product,int rating){
    
    if(product.setRating(rating)==true)
        return true;
    else
        return false;
}
public void updateWallet(float amount){
    wallet+=amount;
}
public boolean purchaseProduct(Store store,Product product){
    if (store.hasProduct(product)&&wallet>=product.getPrice()){
        shoppingCart.add(product);
        wallet-=product.getPrice();
        store.transact(product,0);
        return true;
    }
    else
        return false;
}
public void viewShoppingCart(SortBy sortMethod) {
    if (sortMethod == SortBy.PurchaseTime) {
        for (int i = 0; i < shoppingCart.size(); i++) {
            System.out.println(shoppingCart.get(i).toString());
        }}

        if (sortMethod == SortBy.Rating) {
            int[] num = new int[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                num[i] = i;
            }
            int l = 0;
            Product[] p = new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                p[i] = shoppingCart.get(i);
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int o = 1; o < shoppingCart.size() - i; o++) {
                    if (p[num[i]].getAvgRating() > p[num[i + o]].getAvgRating()) {
                        l =num[i];
                        num[i] = num[i + o];
                        num[i + o] = l;
                    }
                    if (p[num[i]].getAvgRating() == p[num[i + o]].getAvgRating()) {
                        if(num[i]>num[i+o]){
                            l =num[i];
                        num[i] = num[i + o];
                        num[i + o] = l;}
                    }
                }
                System.out.println(shoppingCart.get(num[i]).toString());
            }

            }

         if (sortMethod == SortBy.Price) {
            int[] num = new int[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                num[i] = i;
            }
            int l = 0;
            Product[] p = new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                p[i] = shoppingCart.get(i);
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int o = 1; o < shoppingCart.size() - i; o++) {
                    if (p[num[i]].getPrice() > p[num[i + o]].getPrice()) {
                        l =num[i];
                        num[i] = num[i + o];
                        num[i + o] = l;
                    }
                      if (p[num[i]].getPrice() == p[num[i + o]].getPrice()) {
                        if(num[i]>num[i+o]){
                         l =num[i];
                         num[i] = num[i + o];
                        num[i + o] = l;}
                      }
                }
                System.out.println(shoppingCart.get(num[i]).toString());
            }

    }}
        
     public boolean refundProduct(Product product){
    int lk=0;
    for(int i=0;i<shoppingCart.size();i++){
        if(shoppingCart.get(i).getId()==product.getId())
            lk=1;
    }
      if(lk==1) {
          product.getSd().transact(product, 1);
       shoppingCart.remove(product);
       wallet+=product.getPrice();
       return true;
      }
      else
          return false;
    }
}
