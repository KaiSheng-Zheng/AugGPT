import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public void setIncome(float income) {
        this.income = income;
    }

    public Store(String name) {
        this.name = name;
        this.income = 0;
        cnt++;
        id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product){
        for (int i = 0; i < productList.size(); i++){
            if (product == productList.get(i)){
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product){
        if (hasProduct(product)) return false;
        else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if (hasProduct(product)) {
            productList.remove(product);
            return true;
        }
        else return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method){
        if (method == 0){
            setIncome(income + product.getPrice());
            removeProduct(product);
        }
        else {
            setIncome(income - product.getPrice());
            addProduct(product);
        }
    }
}