import java.util.ArrayList;
import java.util.HashMap;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    private float income;

    public Store (String name){
        this.name = name;
        this.income = 0;
        cnt++;
        this.id = cnt;
    }
    public Store (String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        this.id = cnt;
    }

    public boolean hasProduct(Product product){
        for(Product product1 : productList){
            if (product1.getId() == product.getId())
                return true;
        }
                return false;
    }

    public boolean addProduct(Product product){
        if (!this.hasProduct(product)) {
            this.productList.add(product);
            return true;
        }
        return false;
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            this.productList.remove(product);
            return true;
        } else {
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        switch(method){
            case 0:
                this.productList.remove(product);
                this.income += product.getPrice();
                break;
            case 1:
                this.productList.add(product);
                this.income -= product.getPrice();
                break;
        }
    }
}
