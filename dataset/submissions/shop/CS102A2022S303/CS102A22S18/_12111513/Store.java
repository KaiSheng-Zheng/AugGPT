import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;


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

    public ArrayList<Product> getProductList() {
        return productList;
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

    public Store(String name){
         cnt++;
        this.income = 0;
        ArrayList<Product> productList = new ArrayList<>();
        this.productList=productList;
        this.name = name;
        this.id=cnt;

    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.name = name;
        this.productList=productList;
        this.income=income;
        this.id=cnt;
    }
    public boolean hasProduct(Product product){
       if (getProductList().contains(product)){
           return true;
       }else {
           return false;
       }
    }
    public boolean addProduct(Product product){
        if (getProductList().contains(product)){
            return false;
        } else {
            getProductList().add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if (getProductList().contains(product)){
            getProductList().remove(product);
            return true;
        }else {
            return false;
        }

    }
    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);
            setIncome(getIncome() + product.getPrice());
        }
        if (method==1){
            addProduct(product);
            setIncome(getIncome()- product.getPrice());
        }
    }


}
