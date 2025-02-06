import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private  float income;

    public Store(String name){
        this.name=name;
        income=0;
        id=++cnt;
    }

    public Store(String name,ArrayList<Product> productList,float income){
        this.name=name;
        this.income=income;
        for(Product product : productList) {
            product.setBelongStore(this);
        }
        this.productList=productList;
        id=++cnt;
    }

    public boolean hasProduct(Product product){
        boolean flag=false;
        for(int i=0;i<productList.size();i++){
            if(product.equals(productList.get(i))){
                flag=true; break;
            }

        }
        return flag;
    }

    public boolean addProduct(Product product){
        boolean flag=hasProduct(product);
        if(!flag){
            product.setBelongStore(this);
            productList.add(product);
            return true;
        }
        else{
            return false;
        }
    }

    public  boolean removeProduct(Product product){
        boolean flag=hasProduct(product);
        if(flag){
            productList.remove(product);
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product,int method){
        if(method==0){
            income+=product.getPrice();
            removeProduct(product);
        }
        if(method==1){
            income-= product.getPrice();
            addProduct(product);
        }
    }
}