import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet) {
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }
    public void updateWallet(float amount) {
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product) {
        for (Product i: store.getProductList()) {
            i.setStore(store);
        }
        if (store.hasProduct(product)&&wallet>= product.getPrice()) {
            wallet-= product.getPrice();
            store.removeProduct(product);
            store.setIncome(store.getIncome()+product.getPrice());
            shoppingCart.add(product);
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> tmp = (ArrayList<Product>) shoppingCart.clone();
        if (sortMethod==SortBy.PurchaseTime) {
            for (Product i: tmp) {
                System.out.println(i);
            }
        }
        if (sortMethod==SortBy.Rating) {
            for (int j=0;j<tmp.size();j++) {
                float t = Float.MAX_VALUE;
                for (Product i: tmp) {
                    t=Math.min(t,i.getAvgRating());
                }
                for(int i = 0;i < tmp.size();i++){
                    //System.out.println(i+"11");
                    if (tmp.get(i).getAvgRating()==t) {
                        System.out.println(tmp.get(i));
                        j--;
                        tmp.remove(i);
                    }
                }
            }
        }
        if (sortMethod==SortBy.Price) {
            for (int j=0;j<tmp.size();j++) {
//               j\ System.out.println(j+"j");
                float t = Float.MAX_VALUE;
                for (Product i: tmp) {
                    t=Math.min(t,i.getPrice());
                }
                for(int i = 0;i < tmp.size();i++){
                    //System.out.println(i+"11");
                    if (tmp.get(i).getPrice()==t) {
                        System.out.println(tmp.get(i));
                        j--;
                        tmp.remove(i);
                    }
                }
            }
        }}
    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            wallet+= product.getPrice();
            product.getStore().getProductList().add(product);
            product.getStore().setIncome(product.getStore().getIncome()- product.getPrice());
            return true;
        }
        return false;
    }
}
