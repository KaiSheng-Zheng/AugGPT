import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public static int getCnt() {
        return cnt;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Product> getProductList() {
        return productList;
    }
    public float getIncome() {
        return income;
    }
    public static void setCnt(int cnt) {
        Store.cnt = cnt;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    public void setIncome(float income) {
        this.income = income;
    }


    public Store(String name){
        this.name = name;
        cnt++;
        id = cnt;
        productList = new ArrayList<Product>();
        income = 0;

    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        cnt++;
        id = cnt;
        this.productList = new ArrayList<Product>(productList);
        this.income = income;
    }

    public boolean hasProduct(Product product){
        if (this.productList.contains(product)){
            return true;
        } else {
            return false;
        }
    }

    public boolean addProduct(Product product){
        if (productList.contains(product)){
            return false;
        } else {
            productList.add(product);
            product.setStore(this);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if (!productList.contains(product)){
            return false;
        } else {
            productList.remove(product);
            return true;
        }
    }

    public void transact(Product product, int method){
        if (method==0){
            this.removeProduct(product);
            this.income += product.getPrice();
        } else if (method==1){
            this.addProduct(product);
            this.income -= product.getPrice();
        }
    }

}
