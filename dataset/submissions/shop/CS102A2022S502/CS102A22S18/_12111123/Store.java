import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public  Store(String name){
        cnt ++;
        id = cnt;
        this.name = name;
        productList = new ArrayList<>();
        income = 0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt ++;
        id = cnt;
        this.name = name;
        this.productList = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++){
            this.productList.add(productList.get(i));
        }
        this.income = income;
        for (int i = 0; i < productList.size(); i++){
            productList.get(i).setStore(this);
        }
    }
    public boolean hasProduct(Product product){
        for (int i = 0; i < productList.size(); i++){
            if (productList.contains(product)){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        if (hasProduct(product))
            return false;
        product.setStore(this);
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        if (!hasProduct(product))
            return false;
        productList.remove(product);
        return true;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
    public void transact(Product product, int method) {
        if (method == 0) {
            removeProduct(product);
            income += product.getPrice();
        }
        if (method == 1) {
            addProduct(product);
            income -= product.getPrice();
        }
    }

    public void setIncome(float income) {
        this.income = income;
    }

}