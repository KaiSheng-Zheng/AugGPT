import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private ArrayList<Store> productStores = new ArrayList<>();

    public Customer(String name,float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }

    public boolean rateProduct(Product product,int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet = wallet+amount;
    }

    public boolean purchaseProduct(Store store,Product product){
        if (store.getProductList().contains(product)&&this.wallet>= product.getPrice()){
            shoppingCart.add(product);
            float account = - product.getPrice();
            updateWallet(account);
            store.transact(product,0);
            productStores.add(store);
            return true;
        }else {return false;}
    }
    
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> newList = new ArrayList<Product>(shoppingCart);
        switch (sortMethod){
            case PurchaseTime:
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }break;
            case Rating:
                newList.sort((a, b) -> (int) (a.getAvgRating() - b.getAvgRating()));
                for (Product product : newList) {
                    System.out.println(product.toString());
                }break;
            case Price:
                newList.sort((a, b) -> (int) (a.getPrice() - b.getPrice()));
                for (Product product : newList) {
                    System.out.println(product.toString());
                }break;
        }
    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
//            productStores.get(shoppingCart.indexOf(product)).transact(product,1);
//            productStores.remove(shoppingCart.indexOf(product));
            return true;
        }else {return false;}
    }
}