import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(), shoprate = new ArrayList<>(), shopprice = new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        cnt++; id = cnt;
        this.name = name;
        this.wallet = wallet;
    }
    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)){
            return true;
        } else {
            return false;
        }
    }
    public void updateWallet(float amount){
        wallet = wallet + amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet >= product.getPrice()){
            store.transact(product, 0);
            updateWallet(product.getPrice() * (-1));
            shoppingCart.add(product); shoprate.add(product); shopprice.add(product);
            for(int i = 0; i < shopprice.size(); i++){
                if(product.getPrice() < shopprice.get(i).getPrice()){
                    shopprice.add(i, product);
                    shopprice.remove(shopprice.size()-1);
                    break;
                }
            }
            for(int i = 0; i < shoprate.size(); i++){
                if(product.getAvgRating() < shoprate.get(i).getAvgRating()){
                    shoprate.add(i, product);
                    shoprate.remove(shoprate.size()-1);
                    break;
                }
            }
            return true;
        } else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for(int i = 0; i < shoppingCart.size(); i++){
                    System.out.println(shoppingCart.get(i));
                }
                break;
            case Rating:
                for(int i = 0; i < shoprate.size(); i++){
                    System.out.println(shoprate.get(i));
                }
                break;
            case Price:
                for(int i = 0; i < shopprice.size(); i++){
                    System.out.println(shopprice.get(i));
                }
                break;
        }
    }
    public boolean buyProduct(Product product){
        for(int i = 0; i < shoppingCart.size(); i++){
            if(shoppingCart.get(i).getId() == product.getId())
                return true;
        }
        return false;
    }
    public boolean refundProduct(Product product){
        if(buyProduct(product)){
            updateWallet(product.getPrice() * 1);
            product.getStore().transact(product, 1);
            shoppingCart.remove(product); shoprate.remove(product); shopprice.remove(product);
            return true;
        } else {
            return false;
        }
    }
}
