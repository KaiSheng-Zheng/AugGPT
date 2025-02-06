import java.util.ArrayList;

public class Store {
    private static int cnt;//counter
    private int id;//of Store
    private String name;
    private ArrayList<Product>productList=new ArrayList<>();
    private float income;
    public Store(String name){//new store,without product or income
        cnt++;
        this.id=cnt;
        this.name=name;
    }

    public Store(String name,ArrayList<Product>productList,float income){
        cnt++;
        this.name=name;
        this.id=cnt;
        this.income=income;
        this.productList = productList;
    }

    public boolean hasProduct(Product product) {
        if (productList.contains(product)) {
            return true;
        } else return false;
    }
    public boolean addProduct(Product product){
        if (productList.contains(product)){
            return false;
        }else productList.add(product);
        return true;
        /*int n=0;
        for (int i = 0; i < productList.size(); i++) {
            if (product==productList.get(i)){
                n=1;
            }else productList.add(product);
        }
        if (n==0){
            return true;
        }else return false;*/
    }

    public boolean removeProduct(Product product){
        if (productList.contains(product)){
            productList.remove(product);
            return true;
        }else return false;
        /*int n=0;
        for (int i = 0; i < productList.size(); i++) {
            for (int j = 0; j < productList.size()&&j!=i; j++) {
                if (productList.get(j)==productList.get(i)){
                    productList.remove(j);
                    n=1;
                    j--;
                }
            }
        }
        if (n==1){
            return true;
        }else return false;*/
    }

    public ArrayList<Product>getProductList(){
        return productList;
    }

    public void transact(Product product,int method){
        if (method==0){
            productList.remove(product);
            income+= product.getPrice();
        }else if (method==1){
            productList.add(product);
            income-=product.getPrice();
        }
    }

}
