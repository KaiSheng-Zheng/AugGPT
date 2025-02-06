import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart =new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        id = cnt+1;
        cnt++;

    }
    public boolean rateProduct(Product product, int rating){
       return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)==true && wallet >= product.getPrice()){
            store.transact(product,0);
            wallet -= product.getPrice();
            shoppingCart.add(product);
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod == SortBy.PurchaseTime){
            for(int i = 0; i< shoppingCart.size(); i++){
                System.out.println(shoppingCart.get(i));
            }
        }else if(sortMethod == SortBy.Price){
            for(int i = 0; i< shoppingCart.size(); i++){
                for(int j = 0; j< shoppingCart.size(); j++){
                    int number = 0;
                    for(int k = 0; k< shoppingCart.size(); k++){
                        if(shoppingCart.get(j).getPrice()>shoppingCart.get(k).getPrice()){
                            number++;
                        }
                    }
                    if(number == i){
                        System.out.println(shoppingCart.get(j));
                    }
                }
            }
        }else{
            for(int i = 0; i< shoppingCart.size(); i++) {
                for (int j = 0; j < shoppingCart.size(); j++) {
                    int number = 0;
                    for (int k = 0; k < shoppingCart.size(); k++) {
                        if (shoppingCart.get(j).getAvgRating() > shoppingCart.get(k).getAvgRating()) {
                            number++;
                        }
                    }
                    if (number == i) {
                        System.out.println(shoppingCart.get(j));
                    }
                }
            }
        }
    }
}
