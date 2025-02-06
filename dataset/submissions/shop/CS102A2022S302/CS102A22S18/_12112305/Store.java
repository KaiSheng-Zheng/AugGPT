

import java.util.ArrayList;


public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;


    public Store(String name) {
        cnt++;
        this.name = name;
        income = 0;
        id = cnt;

    }

    public void setIncome(float income) {
        this.income = income;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;

    }

    public String getName() {
        return name;
    }

    public float getIncome() {
        return income;
    }

    public boolean hasProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if (Equals(product,productList.get(i))){
                return true;
            }

        }
        return false;
    }

    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }
        if (!hasProduct(product)){
            productList.add(product);
            return true;
        }
        return false;
    }

    public boolean removeProduct(Product product){
        if (productList.contains(product)){
            productList.remove(product);
            return true;
        }
        else return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product,int method){
        if (method == 0){
            removeProduct(product);
            income += product.getPrice();
        }
        if (method == 1){
            addProduct(product);
            income -= product.getPrice();
        }
    }





    boolean Equals(Product j, Product k){
        return j.getName().equals(k.getName()) && j.getPrice() == k.getPrice();

    }
}
