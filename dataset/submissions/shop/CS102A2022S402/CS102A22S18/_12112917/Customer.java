import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private final int id;
    private final String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    public Customer(String name, float wallet){
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        if(amount>=0){
            wallet+=amount;
        }else{
            wallet-=Math.abs(amount);
        }
    }
    public boolean purchaseProduct(Store store, Product product){
        boolean s = false;
        product.setPs(store);
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            s = true;
        }
        if(s){
            shoppingCart.add(product);
            wallet-=product.getPrice();
            store.transact(product,0);
        }
        return s;
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for(int i = 0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            case Price:
                float[] p = new float[shoppingCart.size()];
                for(int i = 0;i<shoppingCart.size();i++){
                    p[i] = shoppingCart.get(i).getPrice();
                }
                float[] pf = paixu(p);
                for(int i = 0;i<shoppingCart.size();i++){
                    for(int j = 0;j<shoppingCart.size();j++){
                        if(pf[i]==shoppingCart.get(j).getPrice()){
                            System.out.println(shoppingCart.get(j).toString());
                            break;
                        }
                    }
                }
                break;
            case Rating:
                float[] r = new float[shoppingCart.size()];
                for(int i = 0;i<shoppingCart.size();i++){
                    r[i] = shoppingCart.get(i).getAvgRating();
                }
                float[] rf = paixu(r);
                for(int i = 0;i<shoppingCart.size();i++){
                    for(int j = 0;j<shoppingCart.size();j++){
                        if(rf[i]==shoppingCart.get(j).getAvgRating()){
                            System.out.println(shoppingCart.get(j).toString());
                            break;
                        }
                    }
                }
                break;
        }

    }
    public static float[] paixu(float[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            float b = a[i];
            a[i] = a[min];
            a[min] = b;
        }
        return a;
    }
    public boolean refundProduct(Product product){
        int i = 0;
        boolean s = false;
        for(i = 0;i<shoppingCart.size();i++){
            if(shoppingCart.get(i).getId() == product.getId()){
                s = true;
                break;
            }
        }
        if(s){
            shoppingCart.remove(i);
            wallet+=product.getPrice();
            product.getPs().transact(product,1);
        }
        return s;
    }


}
