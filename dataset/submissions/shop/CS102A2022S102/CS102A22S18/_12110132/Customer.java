import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        this.name=name;
        cnt++;
        this.id=cnt;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&this.wallet>=product.getPrice()){
            store.transact(product, 0);
            this.shoppingCart.add(product);
            this.wallet-=product.getPrice();
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> List = (ArrayList<Product>) this.shoppingCart.clone();
        switch (sortMethod){
            case PurchaseTime:
                for(int i=0;i< List.size();i++){
                    System.out.println(List.get(i));
                }
            case Rating:
                List.sort((x, y) -> Float.compare(x.getAvgRating(), y.getAvgRating()));
                for(int i=0;i< List.size();i++){
                    System.out.println(List.get(i));
                }
            case Price:
                List.sort((x, y) -> Float.compare(x.getPrice(), y.getPrice()));
                for(int i=0;i< List.size();i++){
                    System.out.println(List.get(i));
                }
        }
    }
//    public boolean refundProduct(Product product){
//
//    }





}
