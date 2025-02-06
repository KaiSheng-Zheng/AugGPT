import java.util.ArrayList;
public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private ArrayList<Store> stores=new ArrayList<>();
    public Customer(String name, float wallet){
        this.name=name;this.wallet=wallet;cnt++;id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        boolean rate=product.setRating(rating);
        return rate;
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){

        boolean purchase=store.hasProduct(product);
        if(purchase==true){
        if(wallet<product.getPrice()){purchase=false;}
        else {store.remove(product);wallet-= product.getPrice();shoppingCart.add(product);store.setIncome(product.getPrice());stores.add(store);}}
        return purchase;
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> a=shoppingCart;
        switch (sortMethod){
            case PurchaseTime:
                for (int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i));
                }
                break;
            case Rating:
                for (int i=0;i<a.size();i++){
                    for (int j=i+1;j<a.size();j++){
                        Product b=a.get(i);
                        Product c=a.get(j);
                        if(b.getAvgRating()>c.getAvgRating()){
                            a.set(i,c);a.set(j,b);
                        }
                    }
                }
                for (int i=0;i<a.size();i++){
                    System.out.println(a.get(i));
                }
                break;
            case Price:
                for (int i=0;i<a.size();i++){
                    for (int j=i+1;j<a.size();j++){
                        Product b=a.get(i);
                        Product c=a.get(j);
                        if(b.getPrice()>c.getPrice()){
                            a.set(i,c);a.set(j,b);
                        }
                    }
                }
                for (int i=0;i<a.size();i++){
                    System.out.println(a.get(i));
                }
        }
    }
    public boolean refundProduct(Product product){
        boolean refund=false;
        for(int i=0;i<shoppingCart.size();i++){
            if(shoppingCart.get(i).getId()==product.getId()){
                refund=true;shoppingCart.remove(product);wallet+= product.getPrice();stores.get(i).addProduct(product);stores.get(i).setIncome(-product.getPrice());
                break;
            }
        }
        return refund;
    }
}
