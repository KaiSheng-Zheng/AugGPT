import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        cnt++;
        this.name=name;
        this.income=0;
        this.id=cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.name=name;
        this.productList=productList;
        this.income=income;
        this.id=cnt;
    }

    public boolean hasProduct(Product product){
        if (productList.contains(product))return true;
        else return false;
    }

    public boolean addProduct(Product product){
        if (productList.contains(product))return false;
        else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if (productList.contains(product)) {
            for (int i=0;i<productList.size();i++){
                if (productList.get(i)==product)productList.remove(i);
            }
            return true;
        }
        else return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);
            income+=product.getPrice();
        }
        else {
            productList.add(product);
            income-=product.getPrice();
        }
    }

}