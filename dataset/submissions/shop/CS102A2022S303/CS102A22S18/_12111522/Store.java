import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product>productList;
    private float income;

    public Store(String name){
        this.name=name;
        Store.cnt++;
        this.id=cnt;
        this.productList=new ArrayList<>();
    }

    public Store(String name,ArrayList<Product>productList,float income){
        this.name=name;
        cnt++;
        this.id=cnt;
        this.income=income;
        this.productList=new ArrayList<>(productList);
    }

    public boolean hasProduct(Product product){
        int index=productList.indexOf(product);
        if(index==-1) return false;
        else return true;
    }

    public boolean addProduct(Product product){

        if(!hasProduct(product)){
            productList.add(product);
            return true;
        }else return false;
    }

    public boolean removeProduct(Product product){

        if(!hasProduct(product))return false;
        else{
            productList.remove(product);
            return true;
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product,int method){
        if(method==0){
            productList.remove(product);
            income+=product.getPrice();
        }else if(method==1){
            productList.add(product);
            income-=product.getPrice();
        }
    }


}
