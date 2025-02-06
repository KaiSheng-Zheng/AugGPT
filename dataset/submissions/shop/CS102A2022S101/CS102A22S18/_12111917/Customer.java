import java.util.ArrayList;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products default is empty.
    private float wallet;

    class Purchase {
        Store store;
        Product product;

        public Purchase(Store store, Product product) {
            this.store = store;
            this.product = product;
        }
    }

    private ArrayList<Purchase> purchaseList = new ArrayList<>();

    public Customer(String name, float wallet) {
        id = ++cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            if (store.removeProduct(product)) {
                shoppingCart.add(product);
                if (shoppingCart.contains(product)) {
                    wallet -= product.getPrice();
                    store.transact(product, 0);
                    purchaseList.add(new Purchase(store,product));
                    return true;
                } else {
                    if (!store.hasProduct(product))
                        store.addProduct(product);
                }
            }
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                sortMethod.sortByPurchaseTime(shoppingCart);
                break;
            case Rating:
                sortMethod.sortByRating(shoppingCart);
                break;
            case Price:
                sortMethod.sortByPrice(shoppingCart);
                break;
            default:
                break;
        }

    }

    public Store getStore(Product product){
        for (int i = 0; i <purchaseList.size() ; i++) {
            if (purchaseList.get(i).product.getId() == product.getId())
                return purchaseList.get(i).store;
        }
        return null;
    }
    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            Store store = getStore(product);
            shoppingCart.remove(product);
            wallet += product.getPrice();
            store.transact(product, 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Customer alice = new Customer("Alice", 20000);
        Product product_laptop = new Product("laptop", (float) 5000);
        Product product_phone = new Product("phone", (float) 68.8);
        Product product_mouse = new Product("mouse", (float) 39.9);
        Product product_table = new Product("table", (float) 799.9);
        product_laptop.setRating(3);
        product_mouse.setRating(4);
        product_table.setRating(1);
        product_phone.setRating(2);

        Store store1 = new Store("store1");
        Store store2 = new Store("store2");
        Store store3 = new Store("store3");
        store1.addProduct(product_table);
        store1.addProduct(product_laptop);
        store2.addProduct(product_mouse);
        store3.addProduct(product_phone);

        // code for creating stores and products are ommitted
        alice.purchaseProduct(store2, product_mouse);
        alice.purchaseProduct(store1, product_laptop);
        alice.purchaseProduct(store1, product_table);
        alice.purchaseProduct(store3, product_phone);
        System.out.println("---------SortBy.Price---------");
        alice.viewShoppingCart(SortBy.Price);
        System.out.println("-------SortBy.PurchaseTime-----------");
        alice.viewShoppingCart(SortBy.PurchaseTime);
        System.out.println("-------SortBy.Rating-----------");
        alice.viewShoppingCart(SortBy.Rating);
        System.out.println("------------------");

    }

}
