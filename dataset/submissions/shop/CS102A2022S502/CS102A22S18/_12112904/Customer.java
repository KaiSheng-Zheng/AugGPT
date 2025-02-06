import java.util.ArrayList;
public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet=this.wallet+amount;
    }



    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&(wallet>=product.getPrice())){
            this.shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product,0);
            return true;
        }else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.PurchaseTime){
            for (Product product : this.shoppingCart) {
                System.out.println(product);
            }
        }
        ArrayList<Float> p1=new ArrayList<>();
        int c=0;

        if(sortMethod==SortBy.Price){
            for(int k=0;k<shoppingCart.size();k++){
                for(int z=0;z<p1.size();z++){
                    if(p1.get(z)==shoppingCart.get(k).getPrice()){
                        c++;
                    }
                }
                if(c==0){
                    p1.add(shoppingCart.get(k).getPrice());
                }
                c=0;
            }
            float[] p=new float[p1.size()];
            for(int k=0;k<p.length;k++){
                p[k]=p1.get(k);
            }
            int N=p.length;
            int i,pmin,j;
            float a;
            for (i=0;i<N;i++) {
                pmin=i;
                for(j=i;j<N;j++){
                    if(p[j]<p[pmin]){
                        pmin=j;
                    }
                }
                a=p[i];
                p[i]=p[pmin];
                p[pmin]=a;
            }
            for(int k=0;k<p.length;k++){
                for(int z=0;z<shoppingCart.size();z++){
                    if(shoppingCart.get(z).getPrice()==p[k]){
                        System.out.println(shoppingCart.get(z));
                    }
                }
            }
        }

        if(sortMethod==SortBy.Rating){
            for(int k=0;k<shoppingCart.size();k++){
                for(int z=0;z<p1.size();z++){
                    if(p1.get(z)==shoppingCart.get(k).getAvgRating()){
                        c++;
                    }
                }
                if(c==0){
                    p1.add(shoppingCart.get(k).getAvgRating());
                }
                c=0;
            }
            float[] p=new float[p1.size()];
            for(int k=0;k<p.length;k++){
                p[k]=p1.get(k);
            }
            int N=p.length;
            int i,pmin,j;
            float a;
            for (i=0;i<N;i++) {
                pmin=i;
                for(j=i;j<N;j++){
                    if(p[j]<p[pmin]){
                        pmin=j;
                    }
                }
                a=p[i];
                p[i]=p[pmin];
                p[pmin]=a;
            }
            for(int k=0;k<p.length;k++){
                for(int z=0;z<shoppingCart.size();z++){
                    if(shoppingCart.get(z).getAvgRating()==p[k]){
                        System.out.println(shoppingCart.get(z));
                    }
                }
            }
        }
    }

    public boolean refundProduct(Product product){
        return true;
    }

}