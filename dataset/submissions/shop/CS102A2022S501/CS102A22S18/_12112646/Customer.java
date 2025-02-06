import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private ArrayList<Store> storesCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.wallet = wallet;
        id = cnt;
        this.name = name;
        shoppingCart=new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
        if (product.setRating(rating)){
            return true;
        }else {
            return false;
        }
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            shoppingCart.add(product);
            storesCart.add(store);
            wallet = wallet - product.getPrice();
            store.transact(product,0);
            return true;
        }else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod == SortBy.PurchaseTime){
            for (Product p:shoppingCart) {
                p.toString();
            }
        }else if (sortMethod == SortBy.Price){
            String[] out = new String[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                out[i] = shoppingCart.get(i).toString();
            }

            float[] orderPrice = new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                orderPrice[i] = shoppingCart.get(i).getPrice();
            }

            for (int i = 0; i < orderPrice.length - 1; i++) {//
                for (int j = i+1; j < orderPrice.length - 1; j++) {
                    if (orderPrice[i] > orderPrice[j]){
                        float change = orderPrice[j];
                        orderPrice[j] = orderPrice[i];
                        orderPrice[i] = change;
                        String a = out[j];
                        out[j] = out[i];
                        out[i] = a;
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(out[i]);
            }

        } else if (sortMethod == SortBy.Rating){
            String[] out = new String[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                out[i] = shoppingCart.get(i).toString();
            }

            float[] orderRate = new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                orderRate[i] = shoppingCart.get(i).getAvgRating();
            }

            for (int i = 0; i < orderRate.length - 1; i++) {//
                for (int j = i+1; j < orderRate.length - 1; j++) {
                    if (orderRate[i] > orderRate[j]){
                        float change = orderRate[j];
                        orderRate[j] = orderRate[i];
                        orderRate[i] = change;
                        String a = out[j];
                        out[j] = out[i];
                        out[i] = a;
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(out[i]);
            }
        }


    }
    public boolean refundProduct(Product product){
        return true;
    }

}