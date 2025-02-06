import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.name = name;
        cnt++;
        id = cnt;
        income = 0;
        productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList=productList;
        this.income = income;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product){
        for(int i = 0;i < productList.size();i++){
            if(product.equals(productList.get(i))){
                return true;
            }
        }
        return  false;
    }

    public boolean addProduct(Product product){
        for(int i = 0;i < productList.size();i++){
            if(product.equals(productList.get(i))){
                return false;
            }
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product){
        for(int i = 0;i < productList.size();i++){
            if(product.equals(productList.get(i))){
                productList.remove(product);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method == 0){
            if(removeProduct(product)){
                income = income + product.getPrice();
            }
        }
        if(method == 1){
            if(addProduct(product)){
                income = income - product.getPrice();
            }
        }
    }
}
