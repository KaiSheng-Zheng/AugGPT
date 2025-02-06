import java.util.ArrayList;

public class Store {

    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        this.name = name;
        this.income = 0;
        this.id = cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.name = name;
        this.productList = productList;
        this.income = income;
        this.id = cnt;
    }
    public boolean hasProduct(Product product) {
        return productList.contains(product);
    }

    public boolean addProduct(Product product){
        if(!productList.contains(product)){
            productList.add(product);
            return true;
        }else{
            return false;
        }
    }
    public boolean removeProduct(Product product){
        if(!productList.contains(product)){
            return false;
        }else{
            productList.remove(product);
            return true;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method == 0){
            productList.remove(product);
            income += product.getPrice();
        }
        if(method == 1){
           productList.add(product);
           income -= product.getPrice();
        }



    }


    public boolean removeProduct2(Product product) {
        if(hasProduct(product)) {
            productList.remove(product);
            return true;
        }
        return false;
    }


    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}
