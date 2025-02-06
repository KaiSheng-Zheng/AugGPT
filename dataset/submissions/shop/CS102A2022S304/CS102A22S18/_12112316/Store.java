import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<Product>();
    private float income;
    public Store(String name){
        cnt++; id = cnt;
        this.name = name;
        income = 0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++; id = cnt;
        this.name = name;
        this.income = income;
        for(int i = 0; i < productList.size(); i++){
            this.productList.add(productList.get(i));
            this.productList.get(i).setStore(this);
        }
    }
    public Store(){
        income = 1000;
    }
    public boolean hasProduct(Product product){
        for(int i = 0; i < productList.size(); i++){
            if(productList.get(i).getId() == product.getId())
                return true;
        }
        return false;
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        } else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)){
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
        if(method == 0){
            removeProduct(product);
            income = income + product.getPrice();
        }
        if(method == 1){
            addProduct(product);
            income = income - product.getPrice();
        }
    }
}
