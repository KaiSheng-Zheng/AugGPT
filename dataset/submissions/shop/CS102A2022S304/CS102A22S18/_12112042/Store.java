import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public  Store(String name){
        cnt++;
        this.name = name;
        this.income = 0;
        this.productList = new ArrayList<>();
        this.id = cnt;
    }
    public Store(String name,ArrayList<Product>productList,float income){
        cnt++;
        this.name = name;
        this.income = income;
        this.productList = productList;
        this.id = cnt;
    }
    public boolean hasProduct(Product product){
        int count = 0;
        for (int i = 0; i < this.productList.size(); i++) {
            if(this.productList.get(i) == product){
                count++;
            }
        }if(count != 0){
            return true;
        }else {
            return false;
        }
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        }else {
            this.productList.add(product);
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
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        if(method == 0){
            removeProduct(product);
            this.income = this.income + product.getPrice();
        }else if(method == 1){
            this.productList.add(product);
            this.income = this.income - product.getPrice();
        }
    }
}
