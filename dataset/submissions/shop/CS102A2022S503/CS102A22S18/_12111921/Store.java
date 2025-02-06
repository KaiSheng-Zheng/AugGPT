import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public Store(String name){
        this.name = name;
        income = 0;
        cnt++;
        id = cnt;
        productList = new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.income = income;
        this.productList = productList;
        this.name = name;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if (product.equals(productList.get(i))){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).equals(product)){
                return false;
            }
        }
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if (product.equals(productList.get(i))){
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
        if (method == 0){
            for (int i = 0; i < productList.size(); i++) {
                if (product.getId() == productList.get(i).getId()){
                    productList.remove(i);
                }
            }
            income += product.getPrice();
        }
        else if (method == 1){
            productList.add(product);
            income -= product.getPrice();
        }
    }


}
