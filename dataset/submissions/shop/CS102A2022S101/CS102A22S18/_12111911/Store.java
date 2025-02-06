
import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.income = 0;
    }

    public boolean hasProduct(Product product){
        int count = 0;
        if (productList.size() == 0){return false;}
        else {
        for (int i=0;i<productList.size();i++){
            if (productList.get(i) == product)
                count++;
        }
        return count != 0;}
    }

    public boolean addProduct(Product product){
        if (hasProduct(product))
            return false;
        else {
            productList.add(product);
        return true;}
    }

    public float getIncome() {
        return income;
    }

    public boolean removeProduct(Product product){
        if (!hasProduct(product))
            return false;
        else{
            productList.remove(product);
        return true;}
    }

    public ArrayList<Product> getProductList(){
        return this.productList;
    }

    public void transact(Product product, int method){
        switch (method){
            case 0: removeProduct(product);this.income += product.getPrice();
            case 1: addProduct(product);this.income -= product.getPrice();
        }
    }

    public void setIncome(float income) {
        this.income = income;
    }


}
