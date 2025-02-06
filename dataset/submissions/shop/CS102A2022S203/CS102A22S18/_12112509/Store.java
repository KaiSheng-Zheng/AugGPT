import java.util.ArrayList;
public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;
        cnt++;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        cnt++;
        id=cnt;
        this.income=income;
        this.productList=productList;
    }
    public boolean hasProduct(Product product){
        if (productList.contains(product)) {
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
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method,Product price){
        switch (method){
    case '0': productList.remove(product);
              income+= price.getPrice();
    break;
    case '1':productList.add(product);
             income-=price.getPrice();
    break;
}
    }
}
