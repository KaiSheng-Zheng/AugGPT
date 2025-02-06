import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name)  {
        cnt++;
        id=cnt;
        this.name=name;
        productList=new ArrayList<>();
        income=0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public float getIncome() {
        return income;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }
    public boolean hasProduct(Product product){
        return productList.contains(product);
    }
    public boolean addProduct(Product product){
        if(hasProduct(product))return false;
        else {productList.add(product);return true;}
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)) {productList.remove(product);return true;}
        else return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){removeProduct(product);income+=product.getPrice();}
        if(method==1){addProduct(product);income-= product.getPrice();}
    }
}
