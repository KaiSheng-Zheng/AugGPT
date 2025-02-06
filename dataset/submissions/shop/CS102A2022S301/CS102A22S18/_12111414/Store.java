import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = new ArrayList<>();
        this.income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public void updateIncome(float amount){
        this.income += amount;
    }

    public boolean hasProduct(Product product){
        boolean exist = false;
        for (int i = 0; i < this.productList.size(); i++) {
            if (this.productList.get(i).getId() == product.getId()){
                exist = true;
                break;
            }
        }
        return exist;
    }

    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }else {
            this.productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            this.productList.remove(product);
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<Product> getProductList(){
        return this.productList;
    }

    public void transact(Product product, int method){
        if (method == 0){
            this.productList.remove(product);
            updateIncome(product.getPrice());
        }else if (method == 1){
            this.productList.add(product);
            updateIncome(product.getPrice() * -1f);
        }
    }

    public int getId() {
        return id;
    }
}