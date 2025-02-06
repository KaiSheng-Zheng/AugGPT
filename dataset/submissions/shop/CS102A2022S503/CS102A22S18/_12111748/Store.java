import java.util.ArrayList;
public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;
        income=0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
          this.name=name;
          this.productList=productList;
          this.income=income;
          cnt++;
          this.id=cnt;
    }
    public boolean hasProduct(Product product) {
            if (product.getId() == product.getId()) {
                return true;
            } else {
                return false;
            }
        }

    public boolean addProduct(Product product){
        if (productList.contains(product)){
            return false;
          }
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
        else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            productList.remove(product);
            income+=product.getPrice();
        }
        if(method==1){
            productList.add(product);
            income-=product.getPrice();
        }
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}