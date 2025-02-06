import java.util.ArrayList;
public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income=0;
    public Store(String name){
        Store.cnt++;
        this.id = Store.cnt;
        this.name=name; }
    public Store(String name, ArrayList<Product> productList, float income){
        Store.cnt++;
        this.id = Store.cnt;
        this.name=name;
        this.productList = productList;
        this.income=income;
    }
    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    public ArrayList<Product> getProductList() {
        return productList;}
    public static void setCnt(int cnt) {
        Store.cnt = cnt;
    }
    public static int getCnt() {
        return cnt;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setIncome(float income) {
        this.income = income;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getIncome() {
        return income;
    }
    public boolean addProduct(Product product){
        if (productList.contains(product)) {
            return false;}
        else {
            productList.add(product);
            return true;}}

    public boolean hasProduct(Product product){
        return productList.contains(product);}
    public boolean removeProduct(Product product){
        if (productList.contains(product)) {
            productList.remove(product);//remove product from array list
            return true;
        }
        else {
            return false;
        }
    }
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);//remove product from array list
            income+= product.getPrice();
        }
        if (method==1){
            productList.add(product);
            income-= product.getPrice();
        }
    }
}
