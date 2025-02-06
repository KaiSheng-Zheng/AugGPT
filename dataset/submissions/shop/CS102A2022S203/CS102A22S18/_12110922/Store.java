import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        cnt++;
        id = cnt;
        this.name = name;
        productList = new ArrayList<>();
        income = 0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }
    public boolean hasProduct(Product product){
        int i = 0;
        for(i = 0; i < productList.size(); i++){
            if(productList.get(i).getId() == product.getId()){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        int i = 0;
        for(i = 0; i < productList.size(); i++){
            if(productList.get(i).getId() == product.getId()){
                return false;
            }
        }
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        int i = 0;
        for(i = 0; i < productList.size(); i++){
            if(productList.get(i).getId() == product.getId()){
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
        int i = 0;
        if(method == 0){
            for(i = 0; i < productList.size(); i++){
                if(productList.get(i).getId() == product.getId()){
                    income += productList.get(i).getPrice();
                    productList.remove(i);
                    return;
                }
            }
        }
        else {
            income -= product.getPrice();
            productList.add(product);
        }
    }
}
