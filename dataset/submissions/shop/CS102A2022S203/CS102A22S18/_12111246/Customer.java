import java.util.ArrayList;

public class Customer{
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    public Customer(String name,float wallet){
        id++;cnt++; this.id=this.cnt;this.cnt=cnt;this.name=name;this.wallet=wallet;shoppingCart=new ArrayList<>();
    }
    public boolean rateProduct(Product product,int rating){
        if (rating>=1&&rating<=5){product.setRating(rating);
        return true;}
    else {return false;}}
    public void updateWallet(float amount)
    {wallet=wallet+amount;}
    public boolean purchaseProduct(Store store,Product product)
    {if( (store.getProductList().contains(product))&&wallet>=product.getPrice()){
        shoppingCart.add(product);store.getProductList().remove(product);store.setIncome(store.getIncome()+ product.getPrice());wallet=wallet-product.getPrice();return true;}
        else {return false;}
    }
    public void viewShoppingCart(SortBy sortmethod)
    {String name1 = null;float price = 0;Product product=new Product(name1,price);
        if (sortmethod==SortBy.PurchaseTime){for (int i=0;i<shoppingCart.size();i++){System.out.println(product.toString());}}
        if (sortmethod==SortBy.Rating){for (int i=0;i<shoppingCart.size();i++){System.out.println(product.toString());}}
        if (sortmethod==SortBy.Price){for (int i=0;i<shoppingCart.size();i++){System.out.println(product.toString());}}
    }
    public boolean refundProduct(Product product)
    {return true;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
