import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getIncome() {
        return income;
    }

    public Store(String name){
        cnt++;
        this.name=name;
        this.productList=new ArrayList<>();
        this.id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.name=name;
        this.income=income;
        this.productList=new ArrayList<>();
        this.productList=productList;
        this.id=cnt;
    }

    public boolean hasProduct(Product product){
        if (productList.size()==0){
            return false;
        }
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).equals(product)) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }else{
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }

    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);
            this.income=this.income+product.getPrice();
        }
        if (method==1){
            addProduct(product);
            this.income=this.income- product.getPrice();
        }
    }
}