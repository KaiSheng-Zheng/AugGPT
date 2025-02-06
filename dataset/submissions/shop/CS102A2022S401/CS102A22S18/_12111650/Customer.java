import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.wallet = wallet;
        this.name = name;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating >= 1 && rating <= 5) {
            product.setRating(rating);
            return true;
        } else return false;
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product)) {
            if (this.wallet >= Float.parseFloat(product.getPrice())) {
                this.updateWallet((float) (Float.parseFloat(product.getPrice()) * (-1.00)));
                this.shoppingCart.add(product);
                store.transact(product,0);
                return true;
            } else return false;
        } else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod == SortBy.PurchaseTime){
            for (Product product : this.shoppingCart) {
                System.out.println(product);
            }
        }
        if(sortMethod == SortBy.Price){
            ArrayList<Product> p1 = new ArrayList<Product>();
            for (Product product : this.shoppingCart){
                p1.add(product);
            }
            for (int i =0;i<p1.size()-1;i++){
                boolean flag = false;
                for (int j =0;j<p1.size()-1;j++){
                    float f1 = Float.parseFloat(p1.get(j).getPrice());
                    float f2 = Float.parseFloat(p1.get(j+1).getPrice());
                    if(f1 > f2){
                        Product tem1 = p1.get(j);
                        Product tem2 = p1.get(j+1);
                        p1.set(j,tem2);
                        p1.set(j+1,tem1);
                        flag = true;
                    }
                }
                if (!flag){
                    break;
                }
            }
            for (Product product : p1){
                System.out.println(product);
            }
        }
        if(sortMethod == SortBy.Rating) {
            ArrayList<Product> p2 = new ArrayList<Product>();
            for (Product product : this.shoppingCart){
                p2.add(product);
            }
            for (int i=0;i<p2.size()-1;i++){
                boolean flag = false;
                for (int j =0;j<p2.size()-1;j++){
                    float r1 = p2.get(j).getAvgRating();
                    float r2 = p2.get(j+1).getAvgRating();
                    if(r1>r2){
                        Product tem1 = p2.get(j);
                        Product tem2 = p2.get(j+1);
                        p2.set(j,tem2);
                        p2.set(j+1,tem1);
                        flag = true;
                    }
                    else if(r1 == r2){
                        int r1s = p2.get(j).getAllRating();
                        int r1n = p2.get(j).getRatingNumber();
                        int r2s = p2.get(j+1).getAllRating();
                        int r2n = p2.get(j+1).getRatingNumber();
                        if(r1s*r2n > r2s*r1n){
                            Product tem1 = p2.get(j);
                            Product tem2 = p2.get(j+1);
                            p2.set(j,tem2);
                            p2.set(j+1,tem1);
                            flag = true;
                        }
                    }
                }
                if(!flag){
                    break;
                }
            }
            for(Product product : p2){
                System.out.println(product);
            }
        }
    }
    public boolean refundProduct(Product product){
        return false;
    }
}
