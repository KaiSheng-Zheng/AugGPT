import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;
    // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    /**
     * constructors
     * @param name
     */
    public Store(String name){
        cnt++;
        id = cnt;
        this.name = name;
        productList = new ArrayList<>();
        income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Store.cnt = cnt;
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

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    /**
     * determine whether this store has the given product
     * @param product
     * @return Return true if the product is in the productList of the store;
     *         otherwise, return false.
     */
    public boolean hasProduct(Product product){
        return getProductList().contains(product);
    }

    /**
     * Add product to the productList
     * @param product is uniquely identified by its id
     * @return a boolean indicating whether the operation succeeds.
     *         If a product already exists in productList, return false and productList remains the same;
     *         otherwise, add product to productList and return true.
     */
    public boolean addProduct(Product product){
        if (getProductList().size() == 0){
            getProductList().add(product);
            return true;
        }
        for (int i = 0; i < getProductList().size(); i++) {
            if (getProductList().get(i).getId()==product.getId()){
                return false;
            }
        }
        getProductList().add(product);
        return true;
    }

    /**
     * Remove product from productList
     * @param product is uniquely identified by its id
     * @return a boolean indicating whether the operation succeeds.
     *         If product exists in productList, remove it from productList and return true
     *         otherwise, return false and productList remains the same.
     */
    public boolean removeProduct(Product product){
        for (int i = 0; i < getProductList().size(); i++) {
            if (getProductList().get(i).getId()==product.getId()){
                getProductList().remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Return productList
     * @return
     */
    public ArrayList<Product> getProductList(){
        return productList;
    }

    /**
     * This is an interface method for stores to handle customers' purchases or refunds.
     * Suppose that all the arguments are valid here.
     * @param product
     * @param method
     */
    public void transact(Product product, int method){
        switch (method){
            case 0:
                removeProduct(product);
                setIncome(getIncome()+product.getPrice());
                break;
            case 1:
                addProduct(product);
                setIncome(getIncome()-product.getPrice());
                break;
        }
    }
}
