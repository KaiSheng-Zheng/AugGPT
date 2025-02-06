import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        cnt++;
        id=cnt;
        this.name=name;
        income=0;
        productList=new ArrayList<>();
    }
    public Store(String name,ArrayList<Product> productList,float income){
        cnt++;
        id=cnt;
        this.name=name;
        this.productList=productList;
        for(int i=0;i< productList.size();i++){
            productList.get(i).setPlace(this);
        }
        this.income=income;
    }
    public boolean hasProduct(Product product){
        boolean ak=true;
        for (int i=0;i<productList.size();i++){
            if (this.productList.get(i).getId()==product.getId()){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        if (this.hasProduct(product)){
            return false;
        }
        productList.add(product);
        product.setPlace(this);
        return true;
    }
    public boolean removeProduct(Product product){
        for (int i=0;i<productList.size();i++){
            if (this.productList.get(i).getId()==product.getId()){
                productList.remove(i);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product,int method){
        if (method==0){
            removeProduct(product);
            this.income+=product.getPrice();
        }
        if (method==1){
            addProduct(product);
            this.income-=product.getPrice();
        }
    }

}
