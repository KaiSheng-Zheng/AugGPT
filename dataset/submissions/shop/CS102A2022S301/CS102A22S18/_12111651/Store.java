import java.util.ArrayList;

public class Store {
    private static int cnt =0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    public Store(String name){
        cnt++;
        id = cnt;
        this.name = name;
    }
    public Store( String name, ArrayList<Product> productList, float income){
        cnt++;
        id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if( product.equals(productList.get(i)) ){
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if( product.getId() == productList.get(i).getId()){
                return false;
            }
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if( product.getId() == productList.get(i).getId()){
                productList.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact( Product product, int method ){
        if ( method == 0) {
            removeProduct(product);
            income = income + product.getPrice();
        }
        if( method == 1 ){
            addProduct(product);
            income = income - product.getPrice();
        }
    }
}
