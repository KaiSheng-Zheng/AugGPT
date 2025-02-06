import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart;// The list of purchased products; default is empty.
    private float wallet;
    private ArrayList<Store> fromStore;
    private int countPurchase=0;

    public Customer(String name, float wallet){
        cnt++;
        this.wallet=wallet;
        this.name=name;
        this.shoppingCart=new ArrayList<>();
        this.fromStore=new ArrayList<>();
        this.id=cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet>= product.getPrice()){
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            fromStore.add(store);
            store.transact(product,0);
            countPurchase++;
            product.setPurchaseTime(countPurchase);

            return true;
        }else{
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod.equals(SortBy.PurchaseTime)){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.printf(shoppingCart.get(i).toString()+"\n");
            }
        }else if (sortMethod==SortBy.Price){
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getPrice()-o2.getPrice()>0){
                        return 1;
                    }else {
                        return -1;
                    }
                }
            });
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.printf(shoppingCart.get(i).toString()+"\n");
            }
        }else if(sortMethod==SortBy.Rating){
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getAvgRating()-o2.getAvgRating()>0){
                        return 1;
                    }else {
                        return -1;
                    }
                }
            });
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.printf(shoppingCart.get(i).toString()+"\n");
            }
        }
    }

    public boolean refundProduct(Product product){
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).equals(product)){
                shoppingCart.remove(product);
                fromStore.get(i).transact(product,1);
                fromStore.remove(i);
                updateWallet(product.getPrice());
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Store store1=new Store("store1",new ArrayList<Product>(), 0);
        Store store2=new Store("store2",new ArrayList<Product>(), 0);
        Store store3=new Store("store3",new ArrayList<Product>(),0);

        Product product_phone=new Product("Phone",7000);
        Product product_laptop=new Product("Laptop",10000);
        Product product_mouse=new Product("Mouse",100);
        Product product_table=new Product("Table",300);
        store1.addProduct(product_laptop);
        store1.addProduct(product_table);
        store2.addProduct(product_mouse);
        store3.addProduct(product_phone);

        Customer alice = new Customer("Alice", 20000);
        alice.rateProduct(product_phone,4);
        alice.rateProduct(product_laptop,4);
        alice.rateProduct(product_mouse,3);
        alice.rateProduct(product_table,2);
// code for creating stores and products are ommitted
        alice.purchaseProduct(store1, product_laptop);
        alice.purchaseProduct(store1, product_table);
        alice.purchaseProduct(store2, product_mouse);
        alice.purchaseProduct(store3, product_phone);

        alice.viewShoppingCart(SortBy.Rating);
    }
}
