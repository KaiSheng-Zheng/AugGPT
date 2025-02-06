
import java.util.ArrayList;


public class Customer {

    private static int cnt = 0;
    private int id = ++cnt;
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    public boolean rateProduct(Product product, int rating){
        if(rating<=5&&rating>=1){
            product.setRating(rating);
            return true;
        }else{
            return false;
        }
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            wallet-=product.getPrice();
            shoppingCart.add(product);
            return true;
        }
        else {return false;}
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod.equals(SortBy.PurchaseTime)) {
            for (Product customerProduct : shoppingCart) {
                System.out.print(customerProduct);
            }
        }
        else if(sortMethod==SortBy.Price){
             Product[] priceList = new Product[shoppingCart.size()];
            for(int i=0;i<shoppingCart.size();i++){
                priceList[i] = shoppingCart.get(i);
            }
             for(int j=0;j< priceList.length-1;j++) {
                 for (int i = 0; i < priceList.length - 1 - j; i++) {
                     if (priceList[i].getPrice() > priceList[i + 1].getPrice()) {
                         Product temp = priceList[i];
                         priceList[i] = priceList[i+1];
                         priceList[i] = temp;
                     }
                 }
             }
             for (Product product: priceList){
                 System.out.print(product);
             }
        }else if(sortMethod==SortBy.Rating){
            Product[] ratingList = new Product[shoppingCart.size()];
            for(int i=0;i<shoppingCart.size();i++){
                ratingList[i] = shoppingCart.get(i);
            }
            for(int j=0;j< ratingList.length-1;j++) {
                for (int i = 0; i < ratingList.length - 1 - j; i++) {
                    if (ratingList[i].getAvgRating() > ratingList[i + 1].getAvgRating()) {
                        Product temp = ratingList[i];
                        ratingList[i] = ratingList[i+1];
                        ratingList[i] = temp;
                    }
                }
            }
            for (Product product: ratingList){
                System.out.print(product);
            }
        }

    }
    public boolean refundProduct(Product product){

        return false;
    }
}
