import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private float income;

    private ArrayList<Product> productList = new ArrayList<>();



    public Store(String name){
        this.id = ++cnt;
        this.name = name;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.id = ++cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }
    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }



    public boolean hasProduct(Product product){
        if (productList.contains(product)){
            return true;
        }else {
            return false;
        }
    }

    public boolean addProduct(Product product){
        if (productList.contains(product)){
            return false;
        }else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if (productList.contains(product)){
            productList.remove(product);
            return true;
        }else {
            return false;
        }
    }

    public void transact(Product product, int method){
        if (method == 0){
            productList.remove(product);
            income = income + product.getPrice();
        }
        if (method == 1){
            productList.add(product);
            income = income - product.getPrice();
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
}
