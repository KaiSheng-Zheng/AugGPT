import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.name = name;
        this.income = 0;
//        this.productList = null;
        this.id = cnt + 1;
        cnt++;
        productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        this.id = cnt + 1;
        cnt++;
    }

    public int getId() {
        return id;
    }

    public void updIncome(float val){
        this.income += val;
    }

    public boolean hasProduct(Product product){
        boolean ok = false;
        for (Product value : productList) {
            if (value == product) {
                ok = true;
                break;
            }
        }
        return ok;
    }

    public boolean addProduct(Product product){
        boolean ok = true;
        for (Product value : productList) {
            if (value == product) {
                ok = false;
                break;
            }
        }
        if (!ok){
            return false;
        }
        else{
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        boolean ok = false;
        for (Product value : productList) {
            if (value == product) {
                ok = true;
                break;
            }
        }
        if (!ok){
            return false;
        }
        else{
            productList.remove(product);
            return true;
        }
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if (method == 0){
            if (removeProduct(product)){
                this.income = this.income + product.getPrice();
            }
        }
        if (method == 1){
            addProduct(product);
            this.income = this.income - product.getPrice();
        }
    }
}
