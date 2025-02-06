import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private ArrayList<Store> stores=new ArrayList<>();
    private float wallet;
    public Customer(String name,float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product,int rate){
        return product.setRating(rate);
    }
    public void updateWallet(float amount){
        this.wallet=this.wallet+amount;
    }
    public boolean purchaseProduct(Store store,Product product){
        boolean t;
        if (this.wallet>= product.getPrice()){
            t=store.hasProduct(product);
            if (t){
                store.transact(product,0);
                this.updateWallet(-product.getPrice());
                this.shoppingCart.add(product);
                this.stores.add(store);
            }
        }
        else {
            t=false;
        }
        return t;
    }
    public boolean refundProduct(Product product){
        boolean t=true;
        if (this.shoppingCart.contains(product)){
            int i=shoppingCart.indexOf(product);
            stores.get(i).transact(product,1);
            this.wallet=this.wallet+ product.getPrice();
            shoppingCart.remove(i);
            stores.remove(i);
        }
        else {
            t=false;
        }
        return t;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (Product product:shoppingCart){
                System.out.printf("%s\n",product.toString());
            }
        }
        if (sortMethod==SortBy.Rating){
            ArrayList<Product> ra=new ArrayList<>();
            for (Product product:shoppingCart){
                boolean t=true;
                for (int n=0;n<ra.size();n++){
                    if (product.getAvgRating()<ra.get(n).getAvgRating()){
                        ra.add(n,product);
                        t=false;
                        break;
                    }
                }
                if (t){
                    ra.add(product);
                }
            }
            for (Product product:ra){
                System.out.printf("%s\n",product);
            }
        }
        if (sortMethod==SortBy.Price){
            ArrayList<Product> pr=new ArrayList<>();
            for (Product product:shoppingCart){
                boolean t=true;
                for (int n=0;n<pr.size();n++){
                    if (product.getPrice()<pr.get(n).getPrice()){
                        pr.add(n,product);
                        t=false;
                        break;
                    }
                }
                if (t){
                    pr.add(product);
                }
            }
            for (Product product:pr){
                System.out.printf("%s\n",product);
            }
        }
    }
}

