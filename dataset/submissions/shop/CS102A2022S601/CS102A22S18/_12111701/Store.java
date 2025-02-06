import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when theconstructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.income = 0;
        this.productList = new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.income = income;
        this.productList = productList;
    }

    public boolean hasProduct(Product product){
        boolean test = false;
        for (Product value : productList) {
            if (value.equals(product)) {
                test = true;
                break;
            }
        }
        return test;
    }

    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        } else {productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            this.productList.remove(product);
            return true;
        }else {
            return false;
        }
    }

    public void transact(Product product, int method){
        if(method == 0){
            productList.remove(product);
            this.income+=product.getPrice();
        }
        if(method == 1){
            productList.add(product);
            this.income-=product.getPrice();
        }
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
}
