import java.util.*;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;
    private ArrayList<Store> storeCart=new ArrayList<>();
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)){
            return true;
        }
        return false;
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(wallet>=product.getPrice()&&store.hasProduct(product)){
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            storeCart.add(store);
            store.transact(product,0);
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod.equals(SortBy.PurchaseTime)){
            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }else if(sortMethod.equals(SortBy.Price)){
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.getPrice()-o2.getPrice()>0){
                        return 1;
                    }else if(o1.getPrice()-o2.getPrice()<0){
                        return -1;
                    }else {
                        return 0;
                    }
                }
            });

            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }else if(sortMethod.equals(SortBy.Rating)){
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.getAvgRating()-o2.getAvgRating()>0){
                        return 1;
                    }else if(o1.getAvgRating()-o2.getAvgRating()<0){
                        return -1;
                    }else {
                        return 0;
                    }

                }
            });

            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }

    public boolean refundProduct(Product product){
        for (int i=0;i<shoppingCart.size();i++){
            if(product.equals(shoppingCart.get(i))){
                shoppingCart.remove(i);
                updateWallet(shoppingCart.get(i).getPrice());
                storeCart.get(i).transact(product,1);
                return true;
            }
        }
        return false;
    }


}
