import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int numOfPro=0;
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
//    private ArrayList<Store> shoppingstore; //
    private float wallet;
    public Customer(String name, float wallet) {
        shoppingCart=new ArrayList<>();
//        shoppingstore=new ArrayList<>();
        id=++cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating) {
//        if(rating<1||rating>5) return false;
        return product.setRating(rating);
//        return true;
    }
    public void updateWallet(float amount) {
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet >= product.getPrice())
        {
            updateWallet(-product.getPrice());
            product.setAddTime(++numOfPro);//
            store.transact(product,0);
            product.setStore(store); /////
//            store.removeProduct(product);
            shoppingCart.add(product);//ShoppingCart
//            shoppingstore.add(store);
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> shoppingCart=new ArrayList<>();
        shoppingCart.addAll(this.shoppingCart);
        if(sortMethod==SortBy.PurchaseTime) {
//            for (int i=0;i<shoppingCart.size();i++)
//                for(int j=i+1;j<shoppingCart.size();j++)
//                {
//                    if(shoppingCart.get(i).getAddTime() > shoppingCart.get(j).getAddTime())
//                    Collections.swap(shoppingCart,i,j);
//                }
        }
        if(sortMethod==SortBy.Rating) {
            for (int i=0;i<shoppingCart.size();i++)
                for(int j=i+1;j<shoppingCart.size();j++)
                {
                    if(shoppingCart.get(i).getAvgRating() > shoppingCart.get(j).getAvgRating())
                        Collections.swap(shoppingCart,i,j);
                    if(shoppingCart.get(i).getAvgRating() == shoppingCart.get(j).getAvgRating() && shoppingCart.get(i).getAddTime() > shoppingCart.get(j).getAddTime())
                        Collections.swap(shoppingCart,i,j);
                }
        }
        if(sortMethod==SortBy.Price) {
            for (int i=0;i<shoppingCart.size();i++)
                for(int j=i+1;j<shoppingCart.size();j++)
                {
                    if(shoppingCart.get(i).getPrice() > shoppingCart.get(j).getPrice())
                        Collections.swap(shoppingCart,i,j);
                    if(shoppingCart.get(i).getPrice() == shoppingCart.get(j).getPrice() && shoppingCart.get(i).getAddTime() > shoppingCart.get(j).getAddTime())
                        Collections.swap(shoppingCart,i,j);
                }
        }
        for(Product s:shoppingCart)
            System.out.println(s);
    }
    public int hasProduct(Product product){
        int size=shoppingCart.size();
        for(int i=0;i<size;i++) {
            if(product.getId() == shoppingCart.get(i).getId()) return i;
        }
        return -1;
    }
    public boolean refundProduct(Product product)
    {
        int s=hasProduct(product);
        if(s>=0)
        {
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            Store store=product.getStore();
            store.transact(product, 1);
            return true;
        }
        return false;
    }
}