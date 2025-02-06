import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name){
        this.name=name;
        income= 0;
        cnt++;
        id=cnt;
    }

    public Store(String name,ArrayList<Product> productList,float income){
        this.name = name;
        this.income=income;
        this.productList=productList;
        cnt++;
        id=cnt;
    }
    public boolean hasProduct(Product product){
        if(getProductList().contains(product)){
            return true;
        }else{
            return false;
        }
    }

    public boolean addProduct(Product product){
        if(getProductList().contains(product)){
            return false;
        }else{
            this.productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if(getProductList().contains(product)){
            getProductList().remove(product);
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public float getIncome(){
        return income;
    }

    public void setIncome(float income){
        this.income=income+this.income;
    }

    public void transact(Product product, int method){
        if(method==0){
            removeProduct(product);
            setIncome(product.getPrice());
        }else if(method==1){
            addProduct(product);
            setIncome(-product.getPrice());
        }
    }
}

