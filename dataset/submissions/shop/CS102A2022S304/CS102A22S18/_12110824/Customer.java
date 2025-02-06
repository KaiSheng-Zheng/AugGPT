import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if (rating>=1&&rating<=5){
            product.setRating(rating);
            return true;
        }else{
            return false;
        }
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }
        if (sortMethod==SortBy.Rating){
            for (int i = 0; i < shoppingCart.size(); i++) {//ratingmethod
                System.out.println(ratingmethod(shoppingCart).get(i));
            }
        }
        if (sortMethod==SortBy.Price){
            for (int i = 0; i < shoppingCart.size(); i++) {//pricemethod
                System.out.println(pricemethod(shoppingCart).get(i));
            }
        }
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet > product.getPrice()-1){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            return true;
        }else {
            return false;
        }
    }

    public static ArrayList pricemethod(ArrayList<Product> arrayList){
        ArrayList<Product> newList= (ArrayList<Product>) arrayList.clone();
        for (int i = 0; i < newList.size()-1; i++) {
            for (int j = 0; j < newList.size()-1-i; j++) {
                if (newList.get(j).getPrice()>newList.get(j+1).getPrice()){
                    Collections.swap(newList,j,j+1);
                } else if (newList.get(j).getPrice()==newList.get(j+1).getPrice()){
                    if (arrayList.indexOf(newList.get(j)) > arrayList.indexOf(newList.get(j+1))){
                        Collections.swap(newList,j,j+1);
                    }
                }
            }
        }
        return newList;
    }

    public static ArrayList ratingmethod(ArrayList <Product>arrayList){
        ArrayList<Product> newList= (ArrayList<Product>) arrayList.clone();
        for (int i = 0; i < newList.size()-1; i++) {
            for (int j = 0; j < newList.size()-1-i; j++) {
                if (newList.get(j).getAvgRating()>newList.get(j+1).getAvgRating()){
                    Collections.swap(newList,j,j+1);
                }else if (newList.get(j).getAvgRating()==newList.get(j+1).getAvgRating()){
                    if (arrayList.indexOf(newList.get(j)) > arrayList.indexOf(newList.get(j+1))){
                        Collections.swap(newList,j,j+1);
                    }
                }
            }
        }
        return newList;
    }

    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            product.getThestore().transact(product,1);
            shoppingCart.remove(product);
            this.updateWallet(product.getPrice());
            return true;
        } else {
            return false;
        }
    }
}
