import java.util.ArrayList;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private ArrayList<Store> trade=new ArrayList<>();
    public Customer(String name, float wallet){
        this.name=name;this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if (rating>=1&&rating<=5){
            product.setRating(rating);
            return true;
        }else {
            return false;
        }
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet>=product.getPrice()){
            store.transact(product,0);
            wallet-= product.getPrice();
            shoppingCart.add(product);
            trade.add(store);
            return true;
        }else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (Product product0:shoppingCart){
                System.out.println(product0);
            }
        }else if (sortMethod==SortBy.Rating){
            Product[] shoppingcartCopy=new Product[shoppingCart.size()];
            for (int i=0;i<shoppingCart.size();i++){
                shoppingcartCopy[i]= shoppingCart.get(i);
            }
            Product temp;
            for (int i=0;i<shoppingcartCopy.length;i++){
                for (int j=i;j<shoppingcartCopy.length;j++)
                    if (shoppingcartCopy[i].getAvgRating()>shoppingcartCopy[j].getAvgRating()){
                        temp=shoppingcartCopy[i];
                        shoppingcartCopy[i]=shoppingcartCopy[j];
                        shoppingcartCopy[j]=temp;
                    }
            }
            for (int i=0;i<shoppingcartCopy.length;i++){
                System.out.println(shoppingcartCopy[i]);
            }
        }else {
            Product[] shoppingcartCopy=new Product[shoppingCart.size()];
            for (int i=0;i<shoppingCart.size();i++){
                shoppingcartCopy[i]= shoppingCart.get(i);
            }
            Product temp;
            for (int i=0;i<shoppingcartCopy.length;i++){
                for (int j=i;j<shoppingcartCopy.length;j++)
                    if (shoppingcartCopy[i].getPrice()>shoppingcartCopy[j].getPrice()){
                        temp=shoppingcartCopy[i];
                        shoppingcartCopy[i]=shoppingcartCopy[j];
                        shoppingcartCopy[j]=temp;
                    }
            }
            for (int i=0;i<shoppingcartCopy.length;i++){
                System.out.println(shoppingcartCopy[i]);
            }

        }
    }
    public boolean refundProduct(Product product){
        boolean flag=false;
        int pos=0;
        for (int i=0;i<shoppingCart.size();i++){
            if (product==shoppingCart.get(i)){
                flag=true;
                pos=i;
                break;
            }
        }
        if (flag){
            trade.get(pos).transact(product,1);
            this.updateWallet(product.getPrice());
            this.shoppingCart.remove(pos);
            trade.remove(pos);
            return true;
        }else {
            return false;
        }
    }
}