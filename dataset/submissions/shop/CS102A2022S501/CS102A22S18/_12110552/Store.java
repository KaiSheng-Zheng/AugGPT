import java.util.ArrayList;
public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income ;

    public Store(String name){
        this.cnt ++;
        this.name = name;
        this.id = cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.cnt ++;
        this.name = name;
        this.id = cnt;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }
    public boolean addProduct(Product product){
        if (this.productList.contains(product))
            return false;
        else{
            this.productList.add(product);
            return true;
        }

    }
    public boolean removeProduct(Product product){
        if(this.productList.contains(product)){
            this.productList.remove(product);
            return true;
        }
        else
            return false;
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        if(method == 0){
            this.productList.remove(product);
            this.income += product.getPrice();
        }
        if(method == 1){
           this.productList.add(product);
           this.income -= product.getPrice();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}
