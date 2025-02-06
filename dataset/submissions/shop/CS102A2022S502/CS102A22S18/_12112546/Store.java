import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;// unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income = 0;

    public Store(String name){
        this.income = 0 ;
        this.name = name;
        cnt++;
        id = cnt;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public float getIncome() {
        return income;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.income = income;
        this.productList = productList;
        this.name = name;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product){
        int have = 0;
        for (int i = 0; i < this.productList.size(); i++) {
            if (this.productList.get(i).equals(product)){
                have = 1;
            }
        }
        return have != 0;
    }

    public boolean addProduct(Product product){
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

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if (method == 0){
            this.income = income + product.getPrice();
            this.removeProduct(product);
        }else if (method == 1){
            productList.add(product);
            this.income = income - product.getPrice();
        }
    }
}
