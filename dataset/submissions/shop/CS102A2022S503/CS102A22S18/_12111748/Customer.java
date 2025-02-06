import java.util.ArrayList;
public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct( Product product, int rating){
        if(product.setRating(rating)){
            return true;
        }
        else {
            return false;
        }
    }
    public void updateWallet(float amount){
        if(amount>=0){
            wallet+=amount;
        }
        else {
            wallet-=amount;
        }
    }
    public boolean purchaseProduct( Store store, Product product){
      if(store.hasProduct(product)&&wallet>=product.getPrice()){
          store.getProductList().remove(product);
          shoppingCart.add(product);
          wallet-= product.getPrice();
         store.setIncome(store.getIncome()+product.getPrice());
          return true;
      }
      else{
          return false;
      }
    }
    public void viewShoppingCart(SortBy sortMethod){
    if(sortMethod==SortBy.PurchaseTime){
        for (int i = 0; i < shoppingCart.size(); i++) {
            System.out.println(shoppingCart.get(i).toString());
        }
    }
    if(sortMethod==SortBy.Rating){
        double a=0;
        double b=0;
        double temp;
        for(int i=0;i<shoppingCart.size()-1;i++){
            for(int j=0;j<shoppingCart.size()-1-i;j++){
                a=shoppingCart.get(j).getRatings().get(j);
                b=shoppingCart.get(j+1).getRatings().get(j+1);
                if(a>b){
                    temp=b;
                    shoppingCart.get(j+1).setRating((int) a);
                    b=a;
                    shoppingCart.get(j).setRating((int)b);
                    a=temp;
                }
            }System.out.println(shoppingCart.get(i).toString());
        }
    }
     if(sortMethod==SortBy.Price){
         double a=0;
         double b=0;
         double temp;
         for(int i=0;i<shoppingCart.size()-1;i++){
             for(int j=0;j<shoppingCart.size()-1-i;j++){
                 a=shoppingCart.get(j).getPrice();
                 b=shoppingCart.get(j+1).getPrice();
                 if(a>b){
                     temp=b;
                     shoppingCart.get(j+1).setPrice((float) a);
                     b=a;
                     shoppingCart.get(j).setPrice((float) b);
                     a=temp;
                 }
             }System.out.println(shoppingCart.get(i).toString());
         }
     }

    }
}