import java.util.ArrayList;
import java.util.HashMap;
public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    private HashMap<Product,Store> out;
    public Customer(String name,float wallet){
        cnt = cnt + 1;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
        this.out = new HashMap<>();
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet = this.wallet + amount;
    }

    public void setShoppingCart(Product product) {
        this.shoppingCart.add(product);
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&this.wallet>=product.getPrice()){
            updateWallet(-product.getPrice());
            setShoppingCart(product);
            store.transact(product,0);
            out.put(product,store);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> A = new ArrayList<>(shoppingCart);
        switch (sortMethod){
            case PurchaseTime:for (Product e : shoppingCart){
                System.out.println(e);
            }
            break;
            case Rating:{
                while (A.size()!=1) {
                    Product e = A.get(0);
                    for (int i = 0;i<A.size();i++){
                        if (e.getAvgRating()>A.get(i).getAvgRating()){
                            e = A.get(i);
                        }
                    }
                    System.out.println(e);
                    A.remove(e);
                }
                System.out.println(A.get(0));
                break;
            }
            case Price:{
                while (A.size()!=1) {
                    Product e = A.get(0);
                    for (int i = 0;i<A.size();i++){
                        if (e.getPrice()>A.get(i).getPrice()){
                            e = A.get(i);
                        }
                    }
                    System.out.println(e);
                    A.remove(e);
                }
                System.out.println(A.get(0));
                break;
            }
        }
    }
    public boolean refundProduct(Product product){
        int n = 0;
        for (Product e : shoppingCart){
            if (e.equals(product)) {
                out.get(product).transact(product,1);
                shoppingCart.remove(product);
                this.updateWallet(product.getPrice());
                n = 1;
                break;
            }
        }
        return n==1;
    }

    public static void main(String[] args) {
        Customer alice = new Customer("Alice", 2000000);
        Product product_phone = new Product("Phone",7000);
        Product product_laptop = new Product("Laptop",10000);
        Product product_mouse = new Product("Mouse",100);
        Product product_table = new Product("Table",30000);
        ArrayList<Product> a = new ArrayList<>();
        a.add(product_laptop);
        a.add(product_table);
        ArrayList<Product> b = new ArrayList<>();
        b.add(product_mouse);
        ArrayList<Product> c = new ArrayList<>();
        c.add(product_phone);
        Store store1 = new Store("Store1",a,100);
        Store store2 = new Store("Store2",b,100);
        Store store3 = new Store("Store3",c,100);
        System.out.println(store1.getProductList());
        alice.purchaseProduct(store1, product_laptop);
        System.out.println(alice.wallet);
        alice.rateProduct(product_laptop,4);
        alice.purchaseProduct(store1, product_table);
        alice.rateProduct(product_table,3);
        alice.purchaseProduct(store2, product_mouse);
        alice.rateProduct(product_phone,4);
        alice.purchaseProduct(store3, product_phone);
        alice.refundProduct(product_phone);
        System.out.println(store3.getProductList());
        alice.rateProduct(product_mouse,2);
        alice.viewShoppingCart(SortBy.Price);

    }
}
