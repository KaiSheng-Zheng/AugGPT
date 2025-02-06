import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        id=cnt;
        this.name=name;
        income=0;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id=cnt;
        this.income=income;
        this.productList= (ArrayList<Product>) productList.clone();
        this.name=name;
    }

    public boolean hasProduct(Product product){
        return productList.contains(product);
    }

    public boolean addProduct(Product product){
        if (hasProduct(product))
            return false;
        else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        } else
            return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            income+=product.getPrice();
        }
        if (method==1){
            productList.add(product);
            income+=product.getPrice();
        }
    }
}