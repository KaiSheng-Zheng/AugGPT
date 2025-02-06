import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.name=name;
        productList=new ArrayList<>();
        income=0;
        cnt++;
        id=cnt;
    }
    public Store(String name,ArrayList<Product> productList,float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt++;
        id=cnt;
    }

    public boolean hasProduct(Product product){
            for (int i=0;i<productList.size();i++) {
                if (product.getId()==productList.get(i).getId()){
                    return true;
                }
            }
            return false;
    }
    public boolean addProduct(Product product){
        if (productList.contains(product)){
            return false;
        }else {
            productList.add(product);return true;
        }
    }
    public boolean removeProduct(Product product){
        if (productList.contains(product)){
            productList.remove(product);return true;
        }else {
            return false;
        }
    }
    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product,int method){
        if (method==0){
            removeProduct(product);
            income = income+product.getPrice();
        }else if (method==1){
            addProduct(product);
            income=income-product.getPrice();
        }
    }
}