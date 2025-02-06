import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;
    // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart;
    // The list of purchased products default is empty.
    private float wallet;
    private ArrayList<Store> storeArrayList;
    private ArrayList<Integer> idOrder;




    /**
     * constructor
     * @param name
     * @param wallet
     */
    public Customer(String name, float wallet){
        cnt++;
        id = cnt;
        this.name = name;
        shoppingCart = new ArrayList<>();
        this.wallet = wallet;
        storeArrayList = new ArrayList<>();
        idOrder = new ArrayList<>();
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Customer.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public ArrayList<Store> getStoreArrayList() {
        return storeArrayList;
    }

    public void setStoreArrayList(ArrayList<Store> storeArrayList) {
        this.storeArrayList = storeArrayList;
    }

    public ArrayList<Integer> getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(ArrayList<Integer> idOrder) {
        this.idOrder = idOrder;
    }
    /**
     * customer can rate a product using this method
     * @param product
     * @param rating
     * @return For invalid rating, return false; otherwise return true.
     */
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    /**
     * Update the wallet of this customer.
     * @param amount The amount could be positive (gaining money) or
     *               negative (consuming money).
     */
    public void updateWallet(float amount){
        setWallet(getWallet()+amount);
    }

    /**
     * Purchase product from store.
     * @param store
     * @param product
     * @return Return true if the store has this product and the customer has enough money in the wallet to purchase this product;
     *         return false otherwise
     *         Note that the shoppingCart of this customer as well as his/her wallet should be updated accordingly.
     */
    public boolean purchaseProduct(Store store, Product product){
        boolean haveProduct = store.hasProduct(product);
        boolean haveMoney = getWallet()-product.getPrice()>=0;
        if (haveProduct && haveMoney){
            getShoppingCart().add(product);
            updateWallet(-product.getPrice());
            getStoreArrayList().add(store);
            getIdOrder().add(product.getId());
            store.removeProduct(product);
            store.setIncome(store.getIncome()+product.getPrice());
            return true;
        }
        else
            return false;
    }

    /**
     * Display the purchased products in the shoppingCart of this customer. The order of displaying is specified by sortMethod.
     * @param sortMethod
     * If products have exactly the same average rating, they should be sorted by the purchase time.
     *
     */
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (int i = 0; i < getShoppingCart().size(); i++) {
                    System.out.println(getShoppingCart().get(i).toString());
                }
                break;
            case Rating: {
                ArrayList<Product> a = new ArrayList<>();
                int length = getShoppingCart().size();
                a.addAll(getShoppingCart());
                Product b;
                Product c;
                for (int i = 0; i < length; i++) {
                    b = a.get(0);
                    int d = 0;
                    for (int j = 1; j < a.size(); j++) {
                        c = a.get(j);
                        if (c.getAvgRating() < b.getAvgRating()) {
                            b = c;
                            d = j;
                        }
                    }
                    a.remove(d);
                    System.out.println(b.toString());
                }
            }
                break;
            case Price: {
                ArrayList<Product> a = new ArrayList<>();
                int length = getShoppingCart().size();
                a.addAll(getShoppingCart());
                Product b;
                Product c;
                for (int i = 0; i < length; i++) {
                    b = a.get(0);
                    int d = 0;
                    for (int j = 1; j < a.size(); j++) {
                        c = a.get(j);
                        if (c.getPrice() < b.getPrice()) {
                            b = c;
                            d = j;
                        }
                    }
                    a.remove(d);
                    System.out.println(b.toString());
                }
            }
                break;
        }
    }

    /**
     *
     * @param product
     * @return
     */
    public boolean refundProduct(Product product){
        boolean haveBought = haveBought(product);
        if (haveBought){
            getShoppingCart().remove(product);
            setWallet(getWallet()+product.getPrice());
            whichStore(product).addProduct(product);
            whichStore(product).setIncome(whichStore(product).getIncome()-product.getPrice());
        }return haveBought;
    }

    public boolean haveBought(Product product){
        return getShoppingCart().contains(product);
    }

    public Store whichStore(Product product){
        int a = product.getId();
        for (int i = 0; i < getIdOrder().size(); i++) {
            if (a == getIdOrder().get(i)){
                return storeArrayList.get(i);
            }
        }
        return storeArrayList.get(0);
    }

}
