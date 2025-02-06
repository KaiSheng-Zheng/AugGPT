import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList =new ArrayList<>();
    private float income;

    public Store(String name){
        this.name=name;
        income=0;
        cnt+=1;
        id=cnt;
    }

    public Store(String name,ArrayList<Product> productList,float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt+=1;
        id=cnt;
    }

    public boolean hasProduct(Product product){
        for (int i=0;i<productList.size();i++) {
            if (product == productList.get(i)) {
                return true;
            }
        }   return false;
    }

    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product){
        for (int i=0;i<productList.size();i++){
            if (productList.get(i)==product){
                productList.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);
            income+=product.getPrice();
        }
        if (method==1){
            addProduct(product);
            income-=product.getPrice();
        }

    }
}
