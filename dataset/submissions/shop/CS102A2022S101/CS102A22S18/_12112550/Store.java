import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        this.name = name;
        cnt++;
        setId(cnt);
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        setId(cnt);
    }

    public boolean hasProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId() == product.getId()){
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        } else {
            this.productList.add(product);
        }
        return true;
    }

    public boolean removeProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if(product.getId() == productList.get(i).getId()){
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
        if(method == 0){
            removeProduct(product);
            income = income + product.getPrice();
        }

        if(method == 1){
            addProduct(product);
            income = income - product.getPrice();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int cnt) {
        this.id = Store.cnt;
    }

}
