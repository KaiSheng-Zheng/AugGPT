import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }

    public boolean hasProduct(Product product){
        if (productList.contains(product)){
            return true;
        }
        else {
            return false;
        }

    }
    public boolean addProduct(Product product){
        if (!hasProduct(product)){
            productList.add(product);
            return true;
        }
        else {
            return false;
        }
    }
    public boolean removeProduct(Product product){
        if (!hasProduct(product)){
            return false;
        }else { productList.remove(product);
            return true;

        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            income+=product.getPrice();
            productList.remove(product);
        }
        if (method==1){

                addProduct(product);
                income-=product.getPrice();

        }
    }

    public float getIncome() {
        return income;
    }
    public float setIncome(float income){
        return income;
    }
}
