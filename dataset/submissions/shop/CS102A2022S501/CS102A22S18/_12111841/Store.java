import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private float income;
    private ArrayList<Product> productList = new ArrayList<>(0);

    public Store(String name) {
        this.name = name;
        this.income = 0;
        ++cnt;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.income = income;
        this.productList = productList;
        ++cnt;
        this.id = cnt;
    }

    public boolean hasProduct(Product product){
        if (productList.size() == 0){
            return false;
        }
        return productList.contains(product);
    }

    public boolean addProduct(Product product){
        if (productList.size() == 0){
            productList.add(product);
            return true;
        }
        if (productList.contains(product)){
            return false;
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product){
        if (productList.size() == 0){
            return false;
        }
        for (int i = productList.size() - 1; i >= 0; i --){
            if (productList.get(i).equals(product)){
                productList.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method){
        if (method == 0) {
            if (productList.size() == 0){
                return;
            }
            for (int i = productList.size() - 1; i >= 0; i --){
                if (productList.get(i).equals(product)){
                    productList.remove(i);
                    this.income += product.getPrice();
                    return;
                }
            }
        }
        else if (method == 1){
            productList.add(product);
            this.income -= product.getPrice();
        }
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public float getIncome() {
        return income;
    }
}