import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        cnt++;
        this.name=name;
        id=cnt;
        income=0;
        productList=new ArrayList<Product>();
    }

    public Store(String name,ArrayList<Product> productList,float income){
        cnt++;
        this.name=name;
        id=cnt;
        this.productList=productList;
        this.income=income;
    }

    public boolean hasProduct(Product product){
        for(Product value:this.productList){
            if(value.equals(product)){
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product){
        if(!hasProduct(product)){
            productList.add(product);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product,int method){
        if(method==0){
            this.removeProduct(product);
            income=income+product.getPrice();
        }
        else{
            ;
        }
    }


}