import java.sql.Driver;
import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private final int id;
    private final String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        cnt++;
        id = cnt;
        this.name = name;
        income = 0;
        productList = new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }
    public boolean hasProduct(Product product){
        boolean s = false;
        for(int i = 0;i<productList.size();i++){
            if(productList.get(i).getId()==product.getId()){
                s = true;
                break;
            }
        }
        return s;
    }
    public boolean addProduct(Product product){
        boolean s = true;
        if(productList.size()>0){for (Product value : productList) {
            if (value.getId() == product.getId()) {
                s = false;
                break;
            }
        }
        }
        if(s){
            productList.add(product);
        }
        return s;

    }
    public boolean removeProduct(Product product){
        boolean s = false;
        int i = 0;
        for(i = 0;i<productList.size();i++){
            if(productList.get(i).getId()==product.getId()){
                s = true;
                break;
            }
        }
        if(s){
            productList.remove(i);
        }
        return s;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method == 0){
            removeProduct(product);
            income += product.getPrice();
        }else if(method == 1){
            addProduct(product);
            income -= product.getPrice();
        }

    }
}
