import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name) {
        this.name=name;
        cnt++;id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        this.name=name;this.productList=productList;this.income=income;
        cnt++;id=cnt;
    }

    public boolean hasProduct(Product product){
        return productList.contains(product);
    }

    public boolean addProduct(Product product){
        if (hasProduct(product)){return false;}
        else {productList.add(product);return true;}
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)){productList.remove(product); return true;}
        else {return false;}
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            income+=product.getPrice();
            productList.remove(product);
        }
        else {
            income-=product.getPrice();
            productList.add(product);
        }
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}
