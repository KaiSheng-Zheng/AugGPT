import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public int getId() {
        return id;
    }

    public Store(String name){
        this.name=name;
        cnt++;
        this.id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.income=income;
        this.productList=productList;
        cnt=cnt+1;
        this.id=cnt;
    }
    public boolean hasProduct(Product product){
        for (int i=0;i<this.productList.size();i++){
            if (this.productList.get(i)==product){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        if (!hasProduct(product)){
            this.productList.add(product);
            return true;
        }else {
            return false;
        }
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            this.productList.remove(product);
            return true;
        }else {
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);

            this.income=this.income+product.getPrice();
        }
        if (method==1){
            addProduct(product);

            this.income=this.income-product.getPrice();
        }
    }
}
