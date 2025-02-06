import java.util.ArrayList;


public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList =new ArrayList<>();;
    private float income;
    




    public Store(String name){
        this.name=name;
        cnt++;
        this.id=cnt;
    }

    public int getId() {
        return id;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }
    public boolean hasProduct(Product product){
        if (productList.contains(product)){return true;}
        else {return false;}
    }
    public boolean addProduct(Product product){
        if (productList.contains(product)){return false;}
        else {productList.add(product);
            return true;}
    }
    public boolean removeProduct(Product product){
        if (productList.contains(product)){productList.remove(product);return true;}
        else {return false;}
    }
    public ArrayList<Product> getProductList(){
        return productList;}

    public float getIncome() {
        return income;
    }

    public float setIncome(float income) {
       return this.income = income;
    }

    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);
            this.income=this.income+product.getPrice();
        }
        else {addProduct(product);
            this.income=this.income-product.getPrice();
        }
    }



}