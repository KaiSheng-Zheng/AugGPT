import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products;default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
        shoppingCart=new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && product.getPrice() <= wallet) {
            shoppingCart.add(product);
            wallet = wallet - product.getPrice();
            store.removeProduct(product);
            store.addIncome(product.getPrice());
            return true;
        } else
            return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod==SortBy.Price){
            float[] p=new float[shoppingCart.size()];
            for (int i=0;i<shoppingCart.size();i++){
                if (shoppingCart.get(i).getPrice()>p[0]){
                    p[0]=shoppingCart.get(i).getPrice();
                }}
            for (int n=1;n<shoppingCart.size();n++){
            for (int i=0;i<shoppingCart.size();i++){
                if (shoppingCart.get(i).getPrice()>p[n] && shoppingCart.get(i).getPrice()<p[n-1]){
                    p[n]=shoppingCart.get(i).getPrice();
                }}
                }
            for (int n=shoppingCart.size()-1;n>=0;n--){
            for (int i=0;i<shoppingCart.size();i++){
                if (shoppingCart.get(i).getPrice()==p[n])
                    System.out.println(shoppingCart.get(i).toString());
            }
            }}
        if (sortMethod==SortBy.Rating){
            float[] p=new float[shoppingCart.size()];
            for (int i=0;i<shoppingCart.size();i++){
                p[i]=-1;
            }

            for (int i=0;i<shoppingCart.size();i++){
                if (shoppingCart.get(i).getAvgRating()>p[0]){
                    p[0]=shoppingCart.get(i).getAvgRating();
                }}
            for (int n=1;n<shoppingCart.size();n++){
            for (int i=0;i<shoppingCart.size();i++){
                if (shoppingCart.get(i).getAvgRating()>p[n] && shoppingCart.get(i).getAvgRating()<p[n-1]){
                    p[n]=shoppingCart.get(i).getAvgRating();
                }}}
            for (int n=shoppingCart.size()-1;n>=0;n--){
            for (int i=0;i<shoppingCart.size();i++){
                if (shoppingCart.get(i).getAvgRating()==p[n])
                    System.out.println(shoppingCart.get(i).toString());
            }}
        }
        }

    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            product.getStore().addProduct(product);
            product.getStore().addIncome(-product.getPrice());
            shoppingCart.remove(product);
            wallet=wallet+ product.getPrice();
            return true;
        }
        else {
        return false;}
    }



    }