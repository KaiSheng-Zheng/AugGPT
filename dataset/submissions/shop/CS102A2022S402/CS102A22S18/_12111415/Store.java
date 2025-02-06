
import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        this.name = name;
        this.income = 0;
        this.id = 1 + cnt;
        cnt = cnt + 1;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        this.id = 1 + cnt;
        cnt = cnt + 1;
    }

    public boolean hasProduct(Product product) {
        int judge=0;
        if (productList.size()==0){
            return false;
        }
        for (int i=0;i<productList.size();i++){
            if (product==productList.get(i)){
                judge=1; break;   }
        }
        if (judge==1){
            return true;
        }
        else return false;}

    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }
        else{ productList.add(product);
            return true;}
    }

    public float getIncome() {
        return income;
    }

    public boolean removeProduct(Product product){
        if (!hasProduct(product))
            return false;
        else {productList.remove(product);
            return true;
        }

    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product,int method){
        if (method==0){
            removeProduct(product);
            income=income+product.getPrice();
        }
        else if (method==1){
            addProduct(product);
            income=income-product.getPrice();
        }
    }
    public void addIncome(float income){
        this.income+=income;
    }}