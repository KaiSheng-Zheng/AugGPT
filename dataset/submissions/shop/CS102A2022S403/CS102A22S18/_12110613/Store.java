import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name){
        cnt=1;
        this.id=cnt;
        this.name=name;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }

    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }

    public boolean addProduct(Product product){
        if(!hasProduct(product)){
            productList.add(product);
            return true;
        }else
            return false;
    }

    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            this.productList.remove(product);
            return true;
        }else
            return false;
    }

    public ArrayList<Product> getProductList(){
        return this.productList;
    }

    public void  transact(Product product,int method){
        if(method==0){
            this.productList.remove(product);
            this.income+=product.getPrice();

        }
        if(method==1){
            this.productList.add(product);
            this.income-= product.getPrice();
        }
    }
}