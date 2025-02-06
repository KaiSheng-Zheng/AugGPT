import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        this.name = name;
        Store.cnt++;
        this.id = cnt;
        this.productList = new ArrayList<Product>();
        income = 0 ;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        Store.cnt++;
        this.id = cnt;
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

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public boolean hasProduct(Product product){
        if (productList ==null || product ==null){
            return false;
        }
        for (Product product1 : productList) {
            if (product1.getId() == product.getId()){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){

        if (productList ==null || product ==null){
            return false;
        }
        for (Product product1 : productList) {
            if (product1.getId() == product.getId()){
                return false;
            }
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product){
        if (productList == null || product == null){
            return false;
        }
        for (Product product1 : productList) {
            if (product1.getId() == product.getId()){
                productList.remove(product);
                return true;
            }
        }
        return false;
    }

    public void transact(Product product, int method){
        if (method == 0){
            income += product.getPrice();
            productList.remove(product);
        }

        if (method == 1){
            income -= product.getPrice();
            productList.add(product);
        }
    }
}
