import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    private ArrayList<Store> storeList = new ArrayList<>();
    private int num=0;

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }
    public Customer(String name, float wallet){
        this.name=name;
        cnt++;
        id=cnt;
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet=wallet+amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        boolean judge=store.hasProduct(product);
        boolean judge1=false;
        if(judge &&(wallet>= product.getPrice())){
            judge1=true;
            wallet=wallet-product.getPrice();
            store.transact(product,0);
            shoppingCart.add(product);
            storeList.add(store);
        }
        return judge1;
    }

    public void viewShoppingCart(SortBy sortMethod){
        sortMethod.geCases(this);

    }


    public boolean refundProduct(Product product){
        boolean judge=false;
        for(int i=0;i< shoppingCart.size();i++){
            if(shoppingCart.get(i)==product) {
                judge = true;
                wallet = wallet + product.getPrice();
                storeList.get(i).transact(product,1);
                storeList.remove(i);
                shoppingCart.remove(product);
            }
        }
        return judge;
    }
}