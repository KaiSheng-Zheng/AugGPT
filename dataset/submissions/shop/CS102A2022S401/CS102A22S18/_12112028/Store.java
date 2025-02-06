import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;id = cnt;
        this.name =name;
        this.productList =productList;
        this.income =income;

    }
    public boolean hasProduct(Product product){
        if (productList.contains(product)){
            boolean hasProduct = true;
            return hasProduct;
        }else {
            boolean hasProduct = false;
            return hasProduct;
        }
    }
    public boolean addProduct(Product product){
        if (productList.contains(product)){
            boolean addProduct = false;
            return addProduct;
        }else{
            boolean addProduct = true;
            productList.add(product);
            return addProduct;
        }
    }
    public boolean removeProduct(Product product){
        if (productList.contains(product)){
            boolean removeProduct = true;
            productList.indexOf(product);

            return removeProduct;
        }else{
            boolean removeProduct = false;
            return removeProduct;
        }
    }
    public ArrayList<Product> getProductList(){
        return getProductList();
    }
    public void transact(Product product, int method){
        if (method == 1){
            productList.add(product);

            income = income - product.getPrice();
        }
        if (method == 0){
            productList.remove(product);
           income =income + product.getPrice();
        }
    }
}
