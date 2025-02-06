import java.util.*;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product>shoppingCart=new ArrayList<>();
    private float wallet;
    private ArrayList<Store> stores=new ArrayList<>();
    private ArrayList<Product> products=new ArrayList<>();


public Customer(String name,float wallet){
    this.name=name;
    this.wallet=wallet;
    cnt++;
    this.id=cnt;
}

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public boolean rateProduct(Product product, int rating){
if(rating>=1&&rating<=5){
    product.getRatings().add(rating);
    return true;
}
else{
    return false;
}
}

public void updateWallet(float amount){
wallet+=amount;
}

public boolean purchaseProduct(Store store,Product product){

if(store.hasProduct(product)&&wallet>=product.getPrice()){
    products.add(product);
    stores.add(store);
    wallet-=product.getPrice();
    shoppingCart.add(product);
    store.transact(product,0);


    return true;
}
else{
    return false;
}
}

public void viewShoppingCart(SortBy sortMethod){
switch(sortMethod){
    case PurchaseTime:
        for (int i = 0; i < shoppingCart.size(); i++) {
            System.out.println(shoppingCart.get(i));
        }
        break;
    case Price:
        ArrayList<Product> shoppingCarts=new ArrayList<>();
        for (int i = 0; i < shoppingCart.size(); i++) {
            shoppingCarts.add(shoppingCart.get(i));
        }
        Collections.sort(shoppingCarts, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
               if(o1.getPrice()>o2.getPrice()){
                   return 1;
               }
               else if(o1.getPrice()<o2.getPrice()){
                   return -1;
               }
               else{
                   return 0;
               }
            }
        });

        for (int i = 0; i < shoppingCarts.size(); i++) {
            System.out.println(shoppingCarts.get(i));
        }
        break;
    case Rating:
        ArrayList<Product> shoppingCarts2=new ArrayList<>();
        for (int i = 0; i < shoppingCart.size(); i++) {
            shoppingCarts2.add(shoppingCart.get(i));
        }
        Collections.sort(shoppingCarts2, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getAvgRating()> o2.getAvgRating()){
                    return 1;
                }
               else if(o1.getAvgRating()<o2.getAvgRating()){
                    return -1;
                }
               else{
                   return 0;
                }
            }
        });

        for (int i = 0; i < shoppingCarts2.size(); i++) {
            System.out.println(shoppingCarts2.get(i));
        }
        break;
}

}

public boolean refundProduct(Product product){
    for (int i = 0; i < products.size(); i++) {
        if(products.get(i)==product){
            shoppingCart.remove(shoppingCart.get(i));
            wallet+=product.getPrice();
             stores.get(i).transact(product,1);
            products.remove(products.get(i));
            stores.remove(stores.get(i));
            return true;
        }
        }
    return false;
    }


}


