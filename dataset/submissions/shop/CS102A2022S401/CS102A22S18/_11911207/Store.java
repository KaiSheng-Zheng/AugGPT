
import java.util.ArrayList;
import java.util.Objects;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        setId(cnt);
        setName(name);
        setIncome(0);
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        setId(cnt);
        setName(name);
        setIncome(income);
        setProductList(productList);
    }

    public boolean hasProduct(Product product){
        int judge = 0;
        for (Product inProduct: productList){
            if (Objects.equals(product.getName(), inProduct.getName())){
                judge = 1;
                break;
            }
        }
        return judge == 1;
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }
        else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)){
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
        if (method==0){
            if (removeProduct(product)){
                this.income = this.income + product.getPrice();
            }
        }
        else if (method==1){
            addProduct(product);
            this.income = this.income - product.getPrice();
        }
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public float getIncome() {
        return income;
    }

    public int getId() {
        return id;
    }

}