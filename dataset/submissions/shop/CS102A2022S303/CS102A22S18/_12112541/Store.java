import java.util.ArrayList;

public class Store {
    private static  int cnt = 0;
    private  int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private  float income;

    public Store(String name) {
        this.name = name;
        this.income=0;
        cnt++;
        this.id= cnt;
    }
    public Store(String name,ArrayList<Product> productList,float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt++;
        this.id=cnt;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public  boolean hasProduct(Product product) {
        if (productList.contains(product))
            return true;
        else
            return  false;
    }
    public  boolean addProduct(Product product) {
        boolean test = true;
        if (productList.contains(product)) {
            test = false;
        } else
            productList.add(product);
        return test;
    }


    public  boolean removeProduct (Product product){
        if (productList.contains(product)){
            productList.remove(product);
            return true;
        }else
            return  false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public  void  transact(Product product,int method){
        if (method==0){
            productList.remove(product);
            income += product.getPrice();
        }
        if (method==1){
            productList.add(product);
            income -= product.getPrice();
        }
    }

}
