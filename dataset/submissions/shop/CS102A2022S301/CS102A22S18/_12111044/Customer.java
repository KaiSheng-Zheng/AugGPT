import java.util.*;
public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private HashMap<Product, Store> purchase = new HashMap<>();
    private ArrayList<Product> removeList=new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.wallet=wallet;
        this.name=name;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        if(amount>0) {
            this.wallet += amount;
        }
        else{
            this.wallet-=Math.abs(amount);
        }
    }

    public boolean purchaseProduct(Store store, Product product){
        if(this.wallet>= product.getPrice()&&store.hasProduct(product)){
            this.purchase.put(product, store);
            this.wallet-= product.getPrice();
            store.transact(product,0);
            this.shoppingCart.add(product);
            return true;
        }
        else
            return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        Product[]pp=this.shoppingCart.toArray(shoppingCart.toArray(new Product[0]));
        switch (sortMethod) {
            case Price: {
                Arrays.sort(pp, (i, j) -> Float.compare(i.getPrice(), j.getPrice()));
                for (int i=0;i< pp.length;i++) {
                    System.out.println(pp[i]);
                }
                break;
            }
            case Rating: {
                Arrays.sort(pp, (i, j) -> Float.compare(i.getAvgRating(), j.getAvgRating()));
                for (int i=0;i< pp.length;i++) {
                    System.out.println(pp[i]);
                }
                break;
            }
            case PurchaseTime: {
                for (int i=0;i< pp.length;i++) {
                    System.out.println(pp[i]);
                }
                break;
            }
        }
    }
    public boolean refundProduct(Product product){
        if(this.shoppingCart.contains(product)){
            this.shoppingCart.remove(product);
            this.wallet+= product.getPrice();
            this.removeList.add(product);
            this.purchase.get(product).transact(product, 1);
            return true;
        }
        else
        {return false;}

    }
}
