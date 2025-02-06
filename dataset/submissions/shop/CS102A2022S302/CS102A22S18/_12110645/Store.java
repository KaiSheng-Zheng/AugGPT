import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        cnt++;
        id=cnt;
        this.name=name;
        this.income=0;
        this.productList=new ArrayList<>();

    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id=cnt;
        this.name=name;
        this.income=income;
        this.productList=productList;
    }
    public boolean hasProduct(Product product){
        if (productList.size()>0) {
            for (Product value : this.productList) {
                if (value.equals(product)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }
    public boolean addProduct(Product product){
        if (productList.contains(product)){
            return false;
        } else {
            this.productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if (productList.contains(product)){
            this.productList.remove(product);
            return true;
        } else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            this.productList.remove(product);
            this.income+=product.getPrice();
        } else if (method==1){
            this.productList.add(product);
            this.income-=product.getPrice();
        }
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}
