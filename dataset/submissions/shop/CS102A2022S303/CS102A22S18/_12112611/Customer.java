import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.*;


public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;


    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;

    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public boolean rateProduct(Product product, int rating){

        if(product.setRating(rating))
        {
            return true;
        }
        else return false;
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
    }
    static int a=0;
    public boolean purchaseProduct(Store store, Product product){
        if(store.getProductList().contains(product)&&wallet>=product.getPrice()){
            a++;

            store.transact(product,0);
            shoppingCart.add(product);
            wallet=wallet-product.getPrice();
            return true;
        }
        else return false;
    }




    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> shoppingCart1=new ArrayList<>();
        for (int i=0;i<shoppingCart.size();i++){
            shoppingCart1.add(shoppingCart.get(i));
        }

        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for (int i = 0; i < getShoppingCart().size(); i++) {
                System.out.println(shoppingCart1.get(i).toString());
            }
        }

        if (sortMethod.equals(SortBy.Rating)) {
            for (int j = 0; j < shoppingCart1.size(); j++) {
                for(int k=0;k<shoppingCart1.size()-1;k++){
                    if (shoppingCart1.get(k).getAvgRating1() > shoppingCart1.get(k + 1).getAvgRating1()) {
                        Collections.swap(shoppingCart1, k, k + 1);
                    }
                }
            }for (int i=0;i<shoppingCart1.size();i++){
                System.out.println(shoppingCart1.get(i).toString());
            }
        }
        if(sortMethod.equals(SortBy.Price)){
            for (int j = 0; j < shoppingCart1.size(); j++) {
                for(int k=0;k<shoppingCart1.size()-1;k++){
                    if (shoppingCart1.get(k).getPrice() > shoppingCart1.get(k + 1).getPrice()) {
                        Collections.swap(shoppingCart1, k, k + 1);
                    }
                }

            }for (int i=0;i<shoppingCart1.size();i++){
                System.out.println(shoppingCart1.get(i).toString());
            }

        }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            wallet=wallet+ product.getPrice();
            for(int i=0;i< Store.st.size();i++){
                if(Store.st.get(i).hasProduct(product)){
                    Store.st1.get(i).transact(product,1);
                }
            }


            return true;
        }else {return false;}
    }


}
