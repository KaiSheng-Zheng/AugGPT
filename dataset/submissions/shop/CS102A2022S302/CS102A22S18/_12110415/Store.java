import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<Product>();
    private float income;

    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.income=0f;
        this.productList=new ArrayList<Product>();
    }
    public Store(String name,ArrayList<Product> productList,float income){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }

    public boolean hasProduct(Product product){
        boolean test =false;
        if (productList.size()==0){
            return false;
        }
        for (int i = 0; i <productList.size() ; i++) {
            if (productList.get(i).toString().equals(product.toString()))
                test=true;
        }
        return test;
    }

    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            int n=0;
            for (int i = 0; i < productList.size();i++){
                if (productList.get(i).toString().equals(product.toString()))
                    n=i;
            }
            productList.remove(n);
            return true;
        }
        return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            int n=-1;
            for (int i = 0; i < productList.size();i++){
                if (productList.get(i).toString().equals(product.toString()))
                    n=i;
            }
            productList.remove(n);
            income+=product.getPrice();
        }
        else {
            productList.add(product);
            income-=product.getPrice();
        }
    }
}
