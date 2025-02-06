import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collection;
public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<Product>();
    private float wallet;
    public Customer(String name, float wallet)
    {
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating)
    {
        if(rating == 1.0 || rating == 2.0 || rating == 3.0 || rating == 4.0 || rating == 5.0)
        {product.setRating(rating);
            return true;}
        else{return false;}
    }
    public void updateWallet(float amount)
    {
        this.wallet=wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product)
    {
        if(store.hasProduct(product)&&wallet>=product.getPrice())
        {   shoppingCart.add(product);
            wallet-=product.getPrice();
            store.removeProduct(product);
            store.setincome(product.getPrice());
            return true;
        }
        else
        {return false;}
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> ShoppingCart = shoppingCart;
        ShoppingCart.sort(new Comparator<Product>() {
           @Override
            public int compare(Product o1, Product o2) {
                float x = 0;
                switch (sortMethod) {
                    case Price :
                    { x = o1.getPrice() - o2.getPrice();}
                    case Rating  :
                    { x = o1.getAvgRating() - o2.getAvgRating();}
                    case PurchaseTime :
                    { x = 0;}
                    default :
                        { x = 0;}
                }
                return x > 0 ? 1 : (x < 0 ? -1 : 0);
            }
        });
        for (Product product : ShoppingCart)
            System.out.println(product);
    }
//    public void viewShoppingCart(SortBy method) {
//        switch (method) {
//            case PurchaseTime: {
//                for (int j = 0; j < shoppingCart.size(); j++) {
//                    float i = shoppingCart.get(j).getAvgRating();
//                   System.out.print(toString());
//                }
//            }
//            break;
//            case Rating: {
//                Product[] asdf = new Product[shoppingCart.size()];
//                for (int i = 0; i < shoppingCart.size(); i++) {
//                    asdf[i] = shoppingCart.get(i);
//                }
//                for (int j = 1; j < shoppingCart.size(); j++) {
//                    for (int i = 0; i < shoppingCart.size() - j; i++) {
//                        Product ex;
//                        if (asdf[i].getAvgRating() > asdf[i + 1].getAvgRating()) {
//                            ex = asdf[i];
//                            asdf[i] = asdf[i + 1];
//                            asdf[i + 1] = ex;
//                        }
//                    }
//                }
//                for (int j = 0; j < shoppingCart.size(); j++) {
//                    float i = asdf[j].getAvgRating();
//                    String Y =String.format("%.1f",i);
//                    String a=String.format("%.2f",asdf[j].getPrice());
//                    System.out.print("Product ID " + asdf[j].getID() + ", " + asdf[j].getName() + ", " + "RMB " + a + ", " + "Rating " + Y);
//                }
//                break;}
//            case Price: {
//                Product[] asdf = new Product[shoppingCart.size()];
//                for (int i = 0; i < shoppingCart.size(); i++) {
//                    asdf[i] = shoppingCart.get(i);
//                }
//                for (int j = 1; j < shoppingCart.size(); j++) {
//                    for (int i = 0; i < shoppingCart.size() - j; i++) {
//                        Product ex;
//                        if (asdf[i].getPrice() > asdf[i + 1].getPrice()) {
//                            ex = asdf[i];
//                            asdf[i] = asdf[i + 1];
//                            asdf[i + 1] = ex;
//                        }
//                    }
//                }
//                for (int j = 0; j < shoppingCart.size(); j++) {
//                    float i = asdf[j].getAvgRating();
//                    String Y =String.format("%.1f",i);
//                    String a=String.format("%.2f",asdf[j].getPrice());
//                    System.out.print("Product ID " + asdf[j].getID() + ", " + asdf[j].getName() + ", " + "RMB " + a + ", " + "Rating " + Y);
//                }
//                break;}
//        }
//    }
    public boolean refundProduct(Product product){
        if (!shoppingCart.contains(product))
        {return false;}
        else
//        {shoppingCart.remove(product);
//        updateWallet(product.getPrice());
//        product.getStore().transact(product, 1);
//        product.markFrom(null);
        return true;
    }
}
