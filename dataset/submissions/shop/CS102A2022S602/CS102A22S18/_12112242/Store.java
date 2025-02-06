import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product>productList=new ArrayList<>();
    private float income;

    public Store(String name){
        this.name=name;
        income=0;
        cnt++;
        id=cnt;
    }
    public Store(String name,ArrayList<Product>productList,float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        id=1;
        cnt++;
        id=cnt;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public float getIncome() {
        return income;
    }

    public boolean hasProduct(Product product){
        if(productList.contains(product)){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean addProduct(Product product) {
        if (productList.contains(product))
            return false;
        else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(productList.contains(product)){
            productList.remove(product);
            return true;
        }
        else {
            return false;
        }
    }
    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product,int method){
        if(method==0){
            removeProduct(product);
            income+=product.getPrice();
        }
        if(method==1){
            addProduct(product);
            income-= product.getPrice();
        }
    }
    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
}
