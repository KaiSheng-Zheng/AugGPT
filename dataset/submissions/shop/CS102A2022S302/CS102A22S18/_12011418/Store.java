import java.util.ArrayList;

public class Store {
    // Attributes
    private static int cnt = 0;// initialized to 0, cnt += 1 when the constructor is called
    private int id;// unique for each store, value is set to cnt
    private String name;// the name of the product
    private ArrayList<Product> productList;// all products of the store
    private float income;// the income of the store
    private ArrayList<Product> purchased;// ADDITIONAL products which have been purchased in this store

    // Constructors
    public Store(String name){
        cnt++;
        this.setId(cnt);
        this.setName(name);
        this.productList = new ArrayList<>();
        this.purchased = new ArrayList<>();
    }// construct a new store, with income = 0 and nothing in the productList
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.setId(cnt);
        this.setName(name);
        this.setProductList(productList);
        for (Product product : productList){
            product.setStore(this);
        }// ADDITIONAL
        this.setIncome(income);
        this.purchased = new ArrayList<>();
    }// construct an existing store with given income and productList

    // Setter & Getter
    public void setId(int id) {
        this.id = id;
    }// Id
    public int getId() {
        return this.id;
    }// Id

    public void setName(String name){
        this.name = name;
    }// name
    public String getName(){
        return this.name;
    }// name

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }// productList
    public ArrayList<Product> getProductList() {
        return this.productList;
    }// productList

    public void setIncome(float income) {
        this.income = income;
    }// income
    public float getIncome() {
        return this.income;
    }// income

    public void setPurchased(ArrayList<Product> purchased) {
        this.purchased = purchased;
    }// purchased
    public ArrayList<Product> getPurchased() {
        return this.purchased;
    }// purchased

    /**
     * Determine whether this store has the given product.
     */
    public boolean hasProduct(Product product){
        return this.getProductList().contains(product);
    }

    /**
     * Add product to the productList.
     * @return whether the operation succeeds
     */
    public boolean addProduct(Product product){
        if (!this.getProductList().contains(product)){
            this.getProductList().add(product);
            product.setStore(this);// ADDITIONAL
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove product from productList.
     * @return whether the operation succeeds
     */
    public boolean removeProduct(Product product){
        return this.getProductList().remove(product);
    }

    /**
     * An interface method for stores to handle customers' purchases or refunds.
     */
    public void transact(Product product, int method){
        if (method == 0){
            if (removeProduct(product)){
                this.setIncome(this.getIncome() + product.getPrice());
            }
        } else if (method == 1){// BONUS
            if (this.addProduct(product)){
                this.setIncome(this.getIncome() - product.getPrice());
            }
        }
    }
}