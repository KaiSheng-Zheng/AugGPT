import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products .default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id=cnt;
        shoppingCart=new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        } else {
            product.setRating(rating);
            return true;
        }
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if(wallet>= product.getPrice()){
            if(store.hasProduct(product)){
                store.transact(product,0);
                shoppingCart.add(product);
                wallet-= product.getPrice();
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
//    public boolean purchaseProduct(Store store, Product product) {
//        if(store.hasProduct(product)&&wallet>=product.getPrice()){
//            wallet-=product.getPrice();
//            shoppingCart.add(product);
//            store.removeProduct(product);
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.Rating){
            ArrayList<Product>productorder=new ArrayList<>(shoppingCart);
            for(int i=0;i<shoppingCart.size()-1;i++){
                for(int j=0;j<shoppingCart.size()-i-1;j++){
                    Product linshi;
                    if(productorder.get(j).getAvgRating()>productorder.get(j+1).getAvgRating()){
                        linshi=productorder.get(j);
                        productorder.set(j,productorder.get(j+1));
                        productorder.set(j+1,linshi);
                    }
                }
            }
            for(int k=0;k<productorder.size();k++){
                System.out.println(productorder.get(k).toString());
            }
        }
        else if(sortMethod == SortBy.Price){
            ArrayList<Product>productorder=new ArrayList<>(shoppingCart);
            for(int i=0;i<productorder.size()-1;i++){
                for(int j=0;j<productorder.size()-i-1;j++){
                    if(productorder.get(j).getPrice()>productorder.get(j+1).getPrice()){
                        Product linshi=productorder.get(j);
                        productorder.set(j,productorder.get(j+1));
                        productorder.set(j+1,linshi);
                    }
                }
            }
            for(int k=0;k<productorder.size();k++){
                System.out.println(productorder.get(k).toString());
            }
        }
        else {
            ArrayList<Product>productorder=new ArrayList<>(shoppingCart);
            for(int k=0;k<productorder.size();k++){
                System.out.println(productorder.get(k).toString());
            }
        }
    }

    public boolean refundProduct(Product product){
        return false;
    }

}
