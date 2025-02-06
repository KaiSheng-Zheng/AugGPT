import java.util.ArrayList;
import java.util.Objects;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.wallet=wallet;
        this.name=name;
    }
    public boolean rateProduct(Product product, int rating){
        if (rating==1||rating==2||rating==3||rating==4||rating==5){
            product.setRating(rating);
            return true;
        }else {
            return false;
        }
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        for (int i=0;i<store.getProductList().size();i++){
            if (store.getProductList().get(i).getId()==product.getId()&&this.wallet>=store.getProductList().get(i).getPrice()){
                shoppingCart.add(store.getProductList().get(i));
                this.wallet-=store.getProductList().get(i).getPrice();
                store.transact(product,0);
                store.removeProduct(product);
                return true;
            }
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod.equals(SortBy.PurchaseTime)){
            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod.equals(SortBy.Price)){
            Product[] products=new Product[shoppingCart.size()];
            for (int i=0;i<products.length;i++){
                products[i]=shoppingCart.get(i);
            }
            for (int i=0;i<shoppingCart.size()-1;i++){
                for (int j=0;j<shoppingCart.size()-1;j++){
                    Product product007;
                    if (products[j].getPrice()>products[j+1].getPrice()){
                        product007=products[j];
                        products[j]=products[j+1];
                        products[j+1]=product007;
                    }
                }
            }
            for (int i=0;i<products.length;i++){
                System.out.println(products[i]);
            }
        }
        if (sortMethod.equals(SortBy.Rating)){
            Product[] products=new Product[shoppingCart.size()];
            for (int i=0;i<products.length;i++){
                products[i]=shoppingCart.get(i);
            }
            for (int i=0;i<shoppingCart.size()-1;i++){
                for (int j=0;j<shoppingCart.size()-1;j++){
                    Product product007;
                    if (products[j].getAvgRating()>products[j+1].getAvgRating()){
                        product007=products[j];
                        products[j]=products[j+1];
                        products[j+1]=product007;
                    }
                }
            }
            for (int i=0;i<products.length;i++){
                System.out.println(products[i]);
            }
        }
        }
    public boolean refundProduct(Product product){
        return true;
    }

}
