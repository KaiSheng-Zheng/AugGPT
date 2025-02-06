
    import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    private int time=0;
    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
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
        if ((this.wallet>=product.getPrice())&&(store.hasProduct(product))){
            this.shoppingCart.add(product);
            store.transact(product,0);
            product.setStore(store);
            time++;
            product.setTime(time);
            updateWallet(-product.getPrice());
            return true;
        }else {return false;}
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
            }if(sortMethod==SortBy.Price){
            Product[] products = new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                products[i] = shoppingCart.get(i);
            }
            Arrays.sort(products, (P1, P2) -> Float.compare(P1.getPrice(), P2.getPrice()));
            for(int j=0;j<products.length;j++){
                for(int i=0;i<products.length-1;i++){
                    if(products[i].getPrice()==products[i+1].getPrice()){
                        products[i]=products[i].getPrice()>products[i+1].getPrice()?products[i+1]:products[i];
                    }
                }}
            for (Product product : products) {
                System.out.println(product.toString());
            }
        }
        }
        public boolean has(Product product){
            for (int i=0;i<shoppingCart.size();i++){
                if (product.getId()==shoppingCart.get(i).getId()){
                   return true;
                }}
        return false;
        }

    public boolean refundProduct(Product product){
        if (has(product)){
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            product.getStore().transact(product,1);
            return true;
        }else {return false;}

    }

}
