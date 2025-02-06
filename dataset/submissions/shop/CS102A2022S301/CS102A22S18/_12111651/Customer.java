import java.util.ArrayList;
public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Store> storesList = new ArrayList<>();
    private ArrayList<Product> realCart = new ArrayList<>();
    private float wallet;
    private Store store;

    public Customer(String name, float wallet){
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct (Product product, int rating){
        if( !product.setRating(rating) ){
            return false;
        }
        return true;
    }

    public void updateWallet(float amount){
        this.wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if( store.hasProduct(product) && this.wallet >= product.getPrice()){
            float price = - product.getPrice();
            updateWallet(price);
            shoppingCart.add(product);
            storesList.add(store);
            realCart.add(product);
            store.transact(product,0);
            return true;
        }
        return false;
    }

    public void viewShoppingCart( SortBy sortMethod ){
        ArrayList<Product> copy = new ArrayList<>(shoppingCart);
        switch (sortMethod){
            case PurchaseTime:
                for (int i = 0; i < copy.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            case Rating:
                if( copy.size() != 0 ) {
                    if(!checkRating(copy) ) {
                        for (int i = 0; i < copy.size() -1; i++) {
                            Product tem;
                            for (int j = 0; j < copy.size() -1; j++) {
                                if (copy.get(j).getAvgRating() > copy.get(j+1).getAvgRating()) {
                                    tem = copy.get(j);
                                    copy.set(j, copy.get(j+1));
                                    copy.set(j+1, tem);
                                }
                            }
                        }
                    }
                    for (int i = 0; i < copy.size(); i++) {
                        System.out.println(copy.get(i).toString());
                    }
                }
                else {
                    for (int i = 0; i < copy.size(); i++) {
                        System.out.println(copy.get(i).toString());
                    }
                }
                break;
            case Price:
                if( copy.size() != 0 ) {
                    if(!checkPrice(copy) ) {
                        for (int i = 0; i < copy.size() -1; i++) {
                            Product tem ;
                            for (int j = 0; j < copy.size() -1; j++) {
                                if (copy.get(j).getPrice() > copy.get(j+1).getPrice()) {
                                    tem = copy.get(j);
                                    copy.set(j, copy.get(j+1));
                                    copy.set(j+1, tem);

                                }
                            }
                        }
                    }
                    for (int i = 0; i < copy.size(); i++) {
                        System.out.println( copy.get(i).toString() );
                    }
                }
                else {
                    for (int i = 0; i < copy.size(); i++) {
                        System.out.println(copy.get(i).toString());
                    }
                }
                break;
            default:
                for (int i = 0; i < copy.size(); i++) {
                    System.out.println( copy.get(i).toString() );
                }
                break;
        }
    }

    public boolean checkRating (ArrayList<Product> shopping){
        for (int i = 0; i < shopping.size(); i++) {
            for (int j = i; j < shopping.size(); j++) {
                if (shopping.get(i).getAvgRating() > shopping.get(j).getAvgRating()){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkPrice (ArrayList<Product> shopping){
        for (int i = 0; i < shopping.size(); i++) {
            for (int j = i; j < shopping.size(); j++) {
                if (shopping.get(i).getPrice() > shopping.get(j).getPrice()){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean refundProduct(Product product){
        boolean checkstorepro = true;
        for (int i = 0; i < storesList.size(); i++) {
            for (int j = 0; j < storesList.get(i).getProductList().size(); j++) {
                if ( product.getId() == storesList.get(i).getProductList().get(j).getId() ){
                    checkstorepro = false;
                }
            }
        }
        if(checkstorepro) {
            for (int i = 0; i < realCart.size(); i++) {
                if (product.equals(realCart.get(i))) {
                wallet = wallet + product.getPrice();
                shoppingCart.remove(product);
                storesList.get(i).transact(product, 1);
                return true;
                }
            }
        }
        return false;
    }
}
