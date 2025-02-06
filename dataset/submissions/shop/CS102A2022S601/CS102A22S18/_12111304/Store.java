import java.util.*;

public class Store {

    private static int cnt =0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        cnt+=1;
        id = cnt;
        this.name = name;
        income = 0;
        productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt +=1;
        id = cnt;
        this.name = name;
        this.productList = productList;
        for(int i=0;i<this.productList.size();i++){
            this.productList.get(i).setStore(this);
            this.productList.get(i).setInStore(true);
        }
        this.income = income;
    }

    public boolean hasProduct(Product product){
        for (int i=0;i<productList.size();i++){
            if (productList.get(i).getId()==product.getId()){
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }
        productList.add(product);
        product.setStore(this);
        product.setInStore(true);
        return true;
    }

    public boolean removeProduct(Product product){
        for (int i=0;i<productList.size();i++){
            if (productList.get(i).getId()==product.getId()){
                productList.remove(i);
                product.setInStore(false);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if (method == 0){
            removeProduct(product);
            income+=product.getPrice();
        }
        if (method == 1){
            addProduct(product);
            income-=product.getPrice();
        }
    }
}
