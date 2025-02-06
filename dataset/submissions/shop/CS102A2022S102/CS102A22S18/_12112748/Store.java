import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.name=name;
        cnt++;
        this.id=cnt;
        productList=new ArrayList<>();
        income=0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        cnt ++;
        this.id = cnt;
        this.productList = productList;
        this.income = income;
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
        }else {
            return false;
        }
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        }else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }else {
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            if(hasProduct(product)){
                productList.remove(product);
                this.income += product.getPrice();
            }
        }else{
            if (!hasProduct(product)) {
                productList.add(product);
                this.income -= product.getPrice();
            }
        }
    }

    public boolean equals(Store a){
        if(this.id == a.id && this.name.equals(a.name) && this.income == a.getIncome()){
            return true;
        }else {
            return false;
        }
    }
}
