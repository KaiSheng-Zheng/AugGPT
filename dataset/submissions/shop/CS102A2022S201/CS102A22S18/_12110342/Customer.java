import java.util.ArrayList;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt+=cnt;
        this.name=name;
        this.wallet=wallet;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
      return product.setRating(rating);
    }
    public void updateWallet(Product product,float amount){
        wallet=wallet + amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>= product.getPrice()){
            return true;
        }else{return false;}
    }
    public enum SortBy {PurchaseTime, Rating, Price}
    public void viewShoppingCart(SortBy sortMethod){
        switch(sortMethod){
            case PurchaseTime:{
                for(int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i).toString());
                }break;
            }
            case Rating:{

            }
        }
    }
}