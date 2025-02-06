import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt ++;
        id =cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if(rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5){
            return true;
        }else{
            return true;
        }
    }


    public void updateWallet(float amount){
      wallet +=amount;
    }


    public boolean purchaseProduct(Store store, Product product){
        if(store.getproductlist(store).contains(product) && wallet >= product.getprice(product)){
            shoppingCart.add(product);
            store.removeProduct(product);
            updateWallet(-product.getprice(product));
            store.transact(product,0);
            return true;
        }else{return false;}

    }


    public void viewShoppingCart(SortBy sortMethod){

        if (sortMethod.equals(SortBy.PurchaseTime)){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }
        if(sortMethod.equals(SortBy.Rating)){
            Product temp =null;
            for (int i = 0; i <shoppingCart.size() ; i++) {
                for (int j = 0; j <shoppingCart.size()-i-1 ; j++) {
                    if(shoppingCart.get(j).getAvgRating()>shoppingCart.get(j+1).getAvgRating()){
                        temp = shoppingCart.get(j);
                        shoppingCart.set(j,shoppingCart.get(j+1));
                        shoppingCart.set(j+1,temp);
                    }
                }
                
            }
        }
        if(sortMethod.equals(SortBy.Price)){
            Product temp =null;
            for (int i = 0; i <shoppingCart.size() ; i++) {
                for (int j = 0; j <shoppingCart.size()-i-1 ; j++) {
                    if(shoppingCart.get(j).getprice(temp)>shoppingCart.get(j+1).getprice(temp)){
                        temp = shoppingCart.get(j);
                        shoppingCart.set(j,shoppingCart.get(j+1));
                        shoppingCart.set(j+1,temp);
                    }
                }

            }
        }

    }
    public boolean refundProduct(Product product){
        return true;
    }
}
