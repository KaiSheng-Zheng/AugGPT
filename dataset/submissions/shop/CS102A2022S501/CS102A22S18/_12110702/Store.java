import java.util.ArrayList;
public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    private ArrayList<Product> dan=new ArrayList<>();
    public Store(String name){
        this.name=name;
        income=0;
        cnt++;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt++;
        id=cnt;
    }
    public boolean hasProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId()==productList.get(i).getId()){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)){return false;}
        else {
            productList.add(product);dan.add(product);return true;}
    }
    public boolean removeProduct(Product product) {
        if (hasProduct(product)){productList.remove(product);return true;}
        else return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);
            income+=product.getPrice();
        }
        else{
            if (!hasProduct(product)){
                productList.add(product);
                income-=product.getPrice();
            }
        }

    }
}
