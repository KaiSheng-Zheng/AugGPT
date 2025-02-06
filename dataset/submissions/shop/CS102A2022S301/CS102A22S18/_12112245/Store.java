import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name) {
        income=0;
        this.name=name;
        cnt++;
        this.id=cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt++;
        this.id=cnt;

    }
    public boolean hasProduct(Product product){
        int i=0;
        if(productList.contains(product)){
            return true;
        }else{
            return false;
        }
    }
    public boolean addProduct(Product product){
        if(!hasProduct(product)){
            productList.add(product);
            return true;
        }else{
            return false;
        }
    }
    public boolean removeProduct(Product product){
        if(productList.contains(product)){
            productList.remove(product);
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<Product> getProductList() {
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            removeProduct(product);
            income+=product.getPrice();

        }else if(method==1){
            income-=product.getPrice();
            addProduct(product);
            }

        }

    public int getCnt() {
        return cnt;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public float getIncome() {
        return income;
    }
}


