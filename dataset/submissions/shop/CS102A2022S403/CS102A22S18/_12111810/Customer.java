import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.name = name;
        this.wallet = wallet;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        product.setRating(rating);
        if(rating>=1&&rating<=5){
            return true;
        }
        else{
            return false;
        }
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.removeProduct(product);
            float in = store.getIncome()+ product.getPrice();
            store.setIncome(in);
            return true;
        }
        else {
            return false;
        }

    }


    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime: {
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            }
            case Rating:{
                ArrayList<Product> p = new ArrayList<>(shoppingCart);
               for(int i = 0;i<shoppingCart.size()-1;i++){
                   for(int j = 0;j<shoppingCart.size()-i-1;j++){
                       if(shoppingCart.get(j).getAvgRating()>shoppingCart.get(j+1).getAvgRating()){
                           Product product1 = shoppingCart.get(j);
                           p.set(j,p.get(j+1));
                           p.set(j+1,product1);
                       }
                   }
                }
               for(int i = 0;i<p.size();i++){
                   System.out.println(p.get(i).toString());
               }
                break;
            }
            case Price:{
                ArrayList<Product> p = new ArrayList<>(shoppingCart);
                for(int i = 0;i<shoppingCart.size()-1;i++){
                    for(int j = 0;j<shoppingCart.size()-i-1;j++){
                        if(shoppingCart.get(j).getPrice()>shoppingCart.get(j+1).getPrice()){
                            Product product1 = shoppingCart.get(j);
                            p.set(j,p.get(j+1));
                            p.set(j+1,product1);
                        }
                    }
                }
                for(int i = 0;i<p.size();i++){
                    System.out.println(p.get(i).toString());
                }
                break;
            }
        }

    }

    public boolean refundProduct(Product product){
        return true;
    }

}
