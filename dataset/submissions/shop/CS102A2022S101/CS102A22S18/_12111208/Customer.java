import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=Integer.valueOf(cnt);
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet>=product.getPrice()){
            store.removeProduct(product);
            wallet=wallet- product.getPrice();
            store.transact(product,0);
            shoppingCart.add(product);
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod) throws CloneNotSupportedException {
        ArrayList<Product> CopyShoppingCart=new ArrayList<>();
        ArrayList<Product> CopyShoppingCart1=new ArrayList<>();
        for (int i=0;i<shoppingCart.size();i++){
            CopyShoppingCart.add(shoppingCart.get(i));
            CopyShoppingCart1.add(shoppingCart.get(i));
        }
        Product productBig;
        if (sortMethod==SortBy.PurchaseTime){
            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(CopyShoppingCart.get(i));
            }
        }else if (sortMethod==SortBy.Rating){
            for(int i=0;i<shoppingCart.size()-1;i++){
                for(int j=0;j<shoppingCart.size()-1-i;j++){
                    if(CopyShoppingCart.get(j).getAvgRating()>CopyShoppingCart.get(j+1).getAvgRating()){
                        productBig =CopyShoppingCart.get(j);
                        CopyShoppingCart.set(j,CopyShoppingCart.get(j+1));
                        CopyShoppingCart.set(j+1,productBig);
                    }
                }
            }
            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(CopyShoppingCart.get(i));
            }
        }else if (sortMethod==SortBy.Price){
            for(int i=0;i<shoppingCart.size()-1;i++){
                for(int j=0;j<shoppingCart.size()-1-i;j++){
                    if(CopyShoppingCart.get(j).getPrice()>CopyShoppingCart.get(j+1).getPrice()){
                        productBig =CopyShoppingCart.get(j);
                        CopyShoppingCart.set(j,CopyShoppingCart.get(j+1));
                        CopyShoppingCart.set(j+1,productBig);
                    }
                }
            }
            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(CopyShoppingCart.get(i));
            }
        }
    }
    public boolean hasPurchased(Product product){
        if (shoppingCart.contains(product)){
            return true;
        }else {
            return false;
        }
    }


    public boolean refundProduct(Product product){
        if (hasPurchased(product)){
            shoppingCart.remove(product);
            wallet=wallet+ product.getPrice();
            return true;
        }else {
            return false;
        }
    }

}
