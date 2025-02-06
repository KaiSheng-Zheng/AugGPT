import java.util.ArrayList;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id=0;  // unique for each customer and the value is set to cnt.
    private String name="";
    private ArrayList<Product> shoppingCart=new ArrayList<>();   // The list of purchased products; default is empty.
    private ArrayList<Store> storeCart=new ArrayList<>();
    private float wallet;
    //private int[] storeId=new int[1000000];
    public static void main(String[] args) {}
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)==true){
            return true;
        }else return false;
    }
    public void updateWallet(float amount){
        this.wallet=this.wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)==true&&this.wallet>=product.getprice()){
            store.transact(product,0);
            updateWallet(-product.getprice());
            this.shoppingCart.add(product);
            this.storeCart.add(store);
            //storeId[product.getId()]=store.getId();
            return true;
        }else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.PurchaseTime) {
            for (int i = 0; i < this.shoppingCart.size(); i++){
                System.out.println(this.shoppingCart.get(i));
            }
        }
        if(sortMethod==SortBy.Rating){
            int num=0;
            int[]a=new int[this.shoppingCart.size()];
            for (int i = 0; i < this.shoppingCart.size(); i++){
                float min=6;
                for(int j=0;j<this.shoppingCart.size();j++){
                    if(min>this.shoppingCart.get(j).getAvgRating()&&a[j]==0){
                        min=this.shoppingCart.get(j).getAvgRating();
                        num=j;
                    }
                }
                System.out.println(this.shoppingCart.get(num));
                a[num]=1;
            }
        }
        if(sortMethod==SortBy.Price){
            //float min=100000000;
            int num=0;
            int[]a=new int[this.shoppingCart.size()];
            for (int i = 0; i < this.shoppingCart.size(); i++){
                float min=100000000;
                for(int j=0;j<this.shoppingCart.size();j++){
                    if(min>this.shoppingCart.get(j).getprice()&&a[j]==0){
                        min=this.shoppingCart.get(j).getprice();
                        num=j;
                    }
                }
                System.out.println(this.shoppingCart.get(num));
                a[num]=1;
            }
        }
    }
    public boolean refundProduct(Product product){
        for (int i = 0; i < this.shoppingCart.size(); i++){
            if(this.shoppingCart.get(i).getId()==product.getId()){
                updateWallet(product.getprice());
                this.storeCart.get(i).transact(product,1);
                return true;
            }
        }
        return false;
    }
}
