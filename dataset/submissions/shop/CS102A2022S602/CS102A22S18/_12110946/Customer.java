import java.util.ArrayList;

import java.util.Collections;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();// The list of purchased products;default is empty.
    private float wallet;
    private static int counter = 0;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        counter++;
        id = counter;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating >= 1 & rating <= 5) {
            product.setRating(rating);
            return true;                                      //??
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) & wallet >=product.getPrice()) {
            store.removeProduct(product);
            wallet -= product.getPrice();
            shoppingCart.add(product);
            store.transact(product,0);
            product.setStore(store);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> shoppingCart=new ArrayList<>();
        shoppingCart.addAll(this.shoppingCart);
        if (sortMethod == SortBy.Price) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = i+1; j < shoppingCart.size(); j++) {
                    if(shoppingCart.get(i).getPrice()>shoppingCart.get(j).getPrice()){
                        Collections.swap(shoppingCart,i,j);
                }
            }
            for (Product p:shoppingCart) {
                System.out.println(p);
            }
        }
    }else if(sortMethod== SortBy.Rating){
            for (int i = 0; i < shoppingCart.size(); i++) {

                for (int j = i+1; j <shoppingCart.size() ; j++) {
                    if(shoppingCart.get(i).getAvgRating()>shoppingCart.get(j).getAvgRating()){
                        Collections.swap(shoppingCart,i,j);
                    }
                }
            }
            for(Product p:shoppingCart){
                System.out.println(p);
            }
        }else if(sortMethod== SortBy.PurchaseTime){
            for(Product p:shoppingCart){
                System.out.println(p);
            }
        }

}

    public boolean refundProduct(Product product){
        boolean a =false;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if(shoppingCart.get(i).getId()==product.getId()){
                a=true;
                break;
            }
        }
        if(a){
            product.getStore().transact(product,1);
            wallet+=product.getPrice();
            shoppingCart.remove(product);

            return true;
        }else{
            return false;
        }


    }

}
