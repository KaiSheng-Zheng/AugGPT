import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        income = 0.0f;
        id = cnt;
        this.name=name;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id=cnt;
        this.income = income;
        this.productList = productList;
        this.name=name;
    }

    public boolean hasProduct(Product product){
        if (productList.contains(product)){
            return true;
        }else {
            return false;
        }
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            for (int i = 0; i < productList.size(); i++) {
                if (product.equals(productList.get(i))){
                    productList.remove(productList.get(i));
                }
            }
            return true;
        }else {
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method == 0){
            removeProduct(product);
            income = income + product.getPrice();
        }else if (method == 1){
            addProduct(product);
            income = income - product.getPrice();
        }
    }

}
