import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;


    public Customer(String name, float wallet){
        id = cnt + 1;
        this.name = name;
        shoppingCart = new ArrayList<>();
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && this.wallet > product.getPrice()){
            store.transact(product,0);
            wallet = wallet -product.getPrice();
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod == SortBy.PurchaseTime){
            for(int i = 0; i < shoppingCart.size(); i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if(sortMethod == SortBy.Rating){
            Product []sortRating = new Product[shoppingCart.size()];
            Product pro = shoppingCart.get(0);
            for(int i = 0; i < shoppingCart.size(); i++){
                for(int j = i; j < shoppingCart.size(); j++){
                    if(pro.getAvgRating()> (shoppingCart.get(j)).getAvgRating()){
                        pro = shoppingCart.get(j);
                    }
                }
                sortRating[i] = pro;
            }
            for(int i = 0; i < sortRating.length; i++){
                System.out.println(sortRating[i].toString());
            }
        }
        if(sortMethod == SortBy.Price){
            Product []sortRating = new Product[shoppingCart.size()];
            Product pro = shoppingCart.get(0);
            for(int i = 0; i < shoppingCart.size(); i++){
                for(int j = i; j < shoppingCart.size(); j++){
                    if(pro.getPrice()> (shoppingCart.get(j)).getPrice()){
                        pro = shoppingCart.get(j);
                    }
                }
                sortRating[i] = pro;
            }
            for(int i = 0; i < sortRating.length; i++){
                System.out.println(sortRating[i].toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        return true;
    }


}
