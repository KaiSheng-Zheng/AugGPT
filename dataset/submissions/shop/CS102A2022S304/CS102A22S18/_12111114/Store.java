import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when theconstructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        cnt++;
        this.name=name;
        id = cnt;
        income = 0;
        productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        id = cnt;
        this.name=name;
        this.income = income;
        this.productList = productList;

    }

    public boolean hasProduct(Product product) {
        int b = productList.size();
        for (int i = 0; i < b; i++) {
            if (product.equals(productList.get(i)))
                return true;
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product))
            return false;
        else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        if (hasProduct(product)) {
            productList.remove(product);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            removeProduct(product);
            incomeAdd(product.getPrice());
        }
        if (method==1){
            addProduct(product);
            incomeAdd(-product.getPrice());
        }
    }
    public void incomeAdd(float income ){
        this.income=this.income+income;
    }
}
