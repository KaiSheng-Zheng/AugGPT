import java.util.ArrayList;
public class Customer  {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    public  Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product, int rating){
        if(rating>=1&&rating<=5){
            product.setRating(rating);
            return true;
        }else return false;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Customer.cnt=0;
    }

    public void updateWallet(float amount){
        wallet+=amount;
    }
    public  boolean purchaseProduct(Store store, Product product){
        if(store.getProductList().contains(product)&&(wallet>= product.getPrice())){
            shoppingCart.add(product);
            wallet=wallet-product.getPrice();
            store.getProductList().remove(product);
            store.setIncome(product.getPrice());
            return true;
        }else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> productslist=new ArrayList<>(shoppingCart);

        if(sortMethod==SortBy.PurchaseTime){
            System.out.println(productslist);
        }else if(sortMethod==SortBy.Rating){
            
        }else if(sortMethod==SortBy.Price){
            System.out.println();
        }
        System.out.println(sortMethod);
    }

    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            return true;
        }else return false;
    }
}

