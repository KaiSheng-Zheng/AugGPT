import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id ;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        this.name = name;
        income = 0;
        cnt = cnt +1;
        id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt = cnt +1;
        id =cnt;
    }

    public boolean hasProduct(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) == product) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i) == product){
                return false;
            }
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i) == product){
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
        if(method==0){
            productList.remove(product);
            income = income + product.getPrice();
        }else if(method==1){
            productList.add(product);
            income = income - product.getPrice();
        }
    }
}