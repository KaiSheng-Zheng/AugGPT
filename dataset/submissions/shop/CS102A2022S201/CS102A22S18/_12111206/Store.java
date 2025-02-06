

import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    public Store(String name){
        this.name = name;
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
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i) == product){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        if(!hasProduct(product)){
            productList.add(product);
            return true;
        }else {
            return false;
        }
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }else {
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method == 0){
            productList.remove(product);
            income += product.getPrice();
        }else if(method == 1){
            productList.add(product);
            income -= product.getPrice();
        }
    }
}
