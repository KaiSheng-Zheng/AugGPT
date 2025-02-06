import java.util.ArrayList;
public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<Product>();
    private float income;
    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.income=0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.income=income;
        if (productList.size()>=1){
            this.productList=productList;
        }
    }
    public boolean hasProduct(Product product){
        int r=0;
        try {
            for (Product product1 : productList) {
                    if (product1.getId()==product.getId()){
                        r++;
                    }
                }
            if (r==0){
                return false;
            }else return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean addProduct(Product product){
        if (!hasProduct(product)){
            this.productList.add(product);
            return true;
        }else return false;
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            this.productList.remove(product);
            return true;
        }else return false;
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product,int method){
        if (method==0){
            if (removeProduct(product)){
                this.income+=product.getPrice();
            }
        }else {
            if (addProduct(product)){
                this.income-=product.getPrice();
            }
        }
    }
}
