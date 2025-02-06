import java.util.ArrayList;
import java.util.Comparator;



public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;


    public Customer(String name, float wallet){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet += amount;

    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.getProductList().contains(product) && this.wallet >= product.getPrice()){
            wallet -= product.getPrice();
            shoppingCart.add(product);
            store.removeProduct2(product);
            store.setIncome(store.getIncome() + product.getPrice());
            return true;
        }else{
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod) {
          switch(sortMethod){
              case PurchaseTime:
                  for (Product product : shoppingCart) {
                      System.out.println(product);
                  }
                  break;
              case Rating:
                  shoppingCart.sort(Comparator.comparing(Product::getAvgRating));
                  for(Product product : shoppingCart){
                      System.out.println(product);
                  }
                  break;
              case Price:
                  shoppingCart.sort(Comparator.comparing(Product::getPrice));
                  for(Product product: shoppingCart){
                      System.out.println(product);
                  }
                  break;
          }
//        if (sortMethod.equals(SortBy.PurchaseTime)) {
//            for (Product product : shoppingCart) {
//                System.out.println(product);
//            }
//        }
//        if (sortMethod.equals(SortBy.Rating)) {
//
//            System.out.println(shoppingCart);
//        }
//        if(sortMethod.equals(SortBy.Price) ){
//
//            System.out.println(shoppingCart);
//        }

    }

    public boolean refundProduct(Product product){
        return false;

    }

    public float getWallet() {
        return this.wallet;
    }

}
