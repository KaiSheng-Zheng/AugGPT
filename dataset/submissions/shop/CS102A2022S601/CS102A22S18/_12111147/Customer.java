import java.util.*;


public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(0); // The list of purchased products; default is empty.
//    private HashMap<Integer, Store> purchaseFrom = new HashMap<>();
    private float wallet;
    private ArrayList<Bought> bought = new ArrayList<>();

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
        this.shoppingCart = new ArrayList<>(0);
    }

    public boolean rateProduct(Product product, int rating) {
//        if(rating>=1 && rating<=5) {
//            return true;
//        }
//        return false;////////////////////////////////////////

        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }


    public boolean haveProduct(Product product) {
        for(int i=0; i<shoppingCart.size(); i++){
            if(product.equals(shoppingCart.get(i))){
                return true;
            }
        }
        return false;
    }


    public boolean purchaseProduct(Store store, Product product) {
        Bought bought1= new Bought(store, product);
        this.bought.add(bought1);
        if(store.hasProduct(product) && this.wallet>= product.getPrice()){
            updateWallet(-product.getPrice());
            store.transact(product,0);
            this.shoppingCart.add(product);
//            purchaseFrom.put(product.getId(), store);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
//        ArrayList<Product> res = shoppingCart;
//        System.out.printf("size:%d", shoppingCart.size());
        switch (sortMethod){
            case PurchaseTime:
                for(int i=0; i<shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
//                Collections.sort(res, new PurchaseTime());
                break;
            case Rating:
//                for(int i=0; i<shoppingCart.size()-1; i++){
//                    for(int j=0; j<shoppingCart.size()-1-i; j++){
//                        Math.min(shoppingCart.get(i).getAvgRating(), shoppingCart.get(i+1).getAvgRating());
//                    }
//                }
                ArrayList<Product> copy1 = new ArrayList<>(shoppingCart);
                float[] r = new float[shoppingCart.size()];
                for(int i=0; i<shoppingCart.size(); i++) {
                    r[i] = shoppingCart.get(i).getAvgRating();
                }
                Arrays.sort(r);
                for(int i=0; i<shoppingCart.size(); i++) {
                    for (int j=0; j<copy1.size(); j++) {
                        if(r[i] == copy1.get(j).getAvgRating()) {
                            System.out.println(copy1.get(j).toString());
                            copy1.remove(j);
                        }
                    }
                }
                break;
            case Price:
                ArrayList<Product> copy2 = new ArrayList<>(shoppingCart);
                float[] p = new float[shoppingCart.size()];
                for(int i=0; i<shoppingCart.size(); i++) {
                    p[i] = shoppingCart.get(i).getPrice();
                }
                Arrays.sort(p);
                for(int i=0; i<shoppingCart.size(); i++) {
                    for (int j=0; j<copy2.size(); j++) {
                        if(p[i] == copy2.get(j).getPrice()) {
                            System.out.println(copy2.get(j).toString());
                            copy2.remove(j);
                        }
                    }
                }
                break;
        }
    }


    public boolean refundProduct(Product product) {
//        if(purchaseFrom.containsKey(product.getId())){
//            Store store = purchaseFrom.get(product.getId());
//            updateWallet(-product.getPrice());
//            store.transact(product,1);
//            this.shoppingCart.remove(shoppingCart.indexOf(product));
//            purchaseFrom.remove(product.getId());
//            return true;
//        }
        if(shoppingCart.size() == 0)
            return false;
        if(haveProduct(product)) {
            for (int i = 0; i < bought.size(); i++) {
                if (product.equals(bought.get(i).getProduct())) {
                    updateWallet(product.getPrice());
                    shoppingCart.remove(product);
                    bought.get(i).getStore().transact(product, 1);
                    return true;
                }
            }
        }
        return false;
    }
}
class Bought{
    private Store store;
    private Product product;
    public Bought(Store store, Product product){
        this.store = store;
        this.product = product;
    }
    public Store getStore(){return this.store;}
    public Product getProduct(){return this.product;}
}
enum SortBy {
        PurchaseTime, Rating, Price
    }
