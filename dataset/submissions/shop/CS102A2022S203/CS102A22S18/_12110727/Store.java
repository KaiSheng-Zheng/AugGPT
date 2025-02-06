import java.util.ArrayList;
import java.util.Objects;

public class Store  {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name) {
        this.name = name;
        cnt++;
        id=cnt;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public float getIncome() {
        return income;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        id=cnt;
    }
    public boolean hasProduct(Product product) {
        int k = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (Objects.equals(product.getName(), productList.get(i).getName())) {
                k = 1;
            } else {

            }
        }
        if (k == 1) {
            return true;
        } else {
            return false;
        }
    }
    public boolean addProduct(Product product){
        int k=0;
        for (int i = 0; i < productList.size(); i++) {
            if (Objects.equals(product.getName(), productList.get(i).getName())) {
                k=1;
            }
            else {

            }
        }
        if(k==1){
            return false;
        }
        else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        int k=0;
        for (int i = 0; i <productList.size(); i++) {
            if (Objects.equals(product.getName(), productList.get(i).getName())) {
                k=1;
            } else {

            }
        }
        if(k==1){
            productList.remove(product);
            return true;
        }
        else {
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
                 if(method==0){
                     getProductList().remove(product);
                     income=income+product.getPrice();
                 }
                 if(method==1){
                     getProductList().add(product);
                     income=income-product.getPrice();
                 }
    }
}