
import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;
        income=0;
        cnt++;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        for(Product i:productList){
            i.setStore(this);
        }
        cnt++;
        id=cnt;
    }
    public void setName(String name){this.name=name;}
    public String getName(){return name;}
    public void setIncome(float income){this.income=income;}
    public float getIncome(){return  income;}
    public boolean hasProduct(Product product){
        return (productList.contains(product));
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return  false;
        }else {
            productList.add(product);
            product.setStore(this);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
            return  true;
        }else {
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            if (removeProduct( product))income=income+ product.getPrice();

        }
        if (method==1){
            if (addProduct(product))income=income- product.getPrice();

        }
    }
}
