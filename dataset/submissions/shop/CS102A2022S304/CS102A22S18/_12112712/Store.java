import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.name = name;
        income = 0;
        productList = new ArrayList<>();
        cnt++;
        id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product){
        return productList.contains(product);
    }

    public boolean addProduct(Product product){//attention,maybe there exist some problems
        if (hasProduct(product)){
            return false;
        }else {
            productList.add(product);
            return true;
        }
    }
     public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        }else {
            return false;
        }
     }

     public void transact(Product product, int method){
        if(method==0) {
            removeProduct(product);
            income = income + product.getPrice();
        }else if (method==1){
            addProduct(product);
            income = income - product.getPrice();
        }
     }

    public ArrayList<Product> getProductList() {
        return productList;
    }

}
