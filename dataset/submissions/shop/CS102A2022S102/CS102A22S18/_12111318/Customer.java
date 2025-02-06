

import java.util.ArrayList;
public class Customer {
    private int id;
    private String name;
    private static int cnt;
    private float wallet;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    public Customer(String name, float wallet) {
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public void updateWallet(float amount) {
        wallet+=amount;
    }

    public boolean purchaseProduct(Store store,Product product) {
        boolean judge =  store.hasProduct(product) && wallet >=product.getPrice();
        if(judge) {
            product.setPurchaseTime();
            product.setStore(store);
            wallet -= product.getPrice();
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }
        return false;
    }

    public boolean rateProduct(Product product,int rating) {
        return product.setRating(rating);
    }
    public void viewShoppingCart(SortBy sortMethod) {
        if(shoppingCart.size()-1==0) {
            return;
        }
        if(sortMethod.toString()=="Rating") {
            sortRating(0, shoppingCart.size()-1);
        }
        if(sortMethod.toString()=="Price") {
            sortPrice(0, shoppingCart.size()-1);
        }
        for(int i=0;i<=shoppingCart.size()-1;i++) {
            System.out.println(shoppingCart.get(i).toString());
        }
        sortTime(0,shoppingCart.size()-1);
    }
    public boolean refundProduct(Product product) {
        for(int j=0;j<shoppingCart.size();j++) {
            if(product.getId()==shoppingCart.get(j).getId()) {
                shoppingCart.remove(j);
                wallet+=product.getPrice();


                product.getStore().transact(product,1);
                return true;
            }
        }
        return false;
    }

    private void sortRating(int ratingLength,int num) {
         int now1=ratingLength;
         int now2=num;
         float m=shoppingCart.get((ratingLength+num)>>1).getAvgRating();
         while(now2>=now1) {
             while(shoppingCart.get(now1).getAvgRating()<m) {
                 now1++;
             }
             while(shoppingCart.get(now2).getAvgRating()>m) {
                 now2--;
             }
             if(now1<=now2) {
                 Product t=shoppingCart.get(now1);
                 shoppingCart.set(now1,shoppingCart.get(now2));
                 shoppingCart.set(now2,t);
                 now1++;now2--;
             }
         }
         if(ratingLength<now2) {
             sortRating(ratingLength, now2);
         }
         if(now1<num) {
             sortRating(now1, num);
         }
    }
    private void sortPrice(int priceLength,int num) {
         int now1=priceLength,now2=num;
         float m=shoppingCart.get((priceLength+num)>>1).getPrice();
         while(now2>=now1) {
             while(shoppingCart.get(now2).getPrice()>m) {
                 now2--;
             }
             while(shoppingCart.get(now1).getPrice()<m) {
                 now1++;
             }
             if(now2>=now1) {
                 Product shop=shoppingCart.get(now1);
                 shoppingCart.set(now1,shoppingCart.get(now2));
                 shoppingCart.set(now2,shop);
                 now1++;
                 now2--;
             }
         }
         if(priceLength<now2) {
             sortPrice(priceLength, now2);
         }
         if(now1<num) {
             sortPrice(now1, num);
         }
    }

    private void sortTime(int timeLength,int num) {
         int now1=timeLength;
         int now2=num;
         int m=shoppingCart.get((timeLength+num)>>1).getPurchaseTime();
         while(now2>=now1) {
             while(shoppingCart.get(now1).getPurchaseTime()<m) {
                 now1++;
             }
             while(shoppingCart.get(now2).getPurchaseTime()>m) {
                 now2--;
             }
             if(now2>=now1) {
                 Product t=shoppingCart.get(now1);
                 shoppingCart.set(now1,shoppingCart.get(now2));
                 shoppingCart.set(now2,t);
                 now1++;now2--;
             }
         }
         if(timeLength<now2) {
             sortTime(timeLength, now2);
         }
         if(num>now1) {
             sortTime(now1, num);
         }
    }
    public void printOut() {
        System.out.println(id);
        System.out.println(name);
    }
}

