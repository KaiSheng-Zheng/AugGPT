import java.util.ArrayList;

public class Store {
    private static int cnt=0;
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
    public Store(String name,ArrayList<Product> productList,float income){
        this.name=name;
        this.productList=productList;
        this.income=income;

        cnt++;
        id=cnt;

    }public boolean hasProduct(Product product){
        if (productList.contains(product)){
            return true;
        }else {
            return false;
        }
    }
    public boolean addProduct(Product product){
        if (productList.contains(product)){
//            product.sd=this;
            return false;
        }else {
            productList.add(product);
            return true;
        }
    }public boolean removeProduct(Product product){
        if (productList.contains(product)){
            productList.remove(product);
            return true;
        }else {
            return false;
        }

    }public void transact(Product product,int method){
        if (method==0){
                productList.remove(product);
                income+=product.getPrice();
            product.sd=this;

        }if (method==1){
            productList.add(product);
            income-=product.getPrice();

        }
    }public ArrayList<Product> getProductList(){
        return productList;
    }

}
