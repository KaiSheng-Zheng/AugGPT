import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.name = name;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product){
        boolean has = false;
        for (int i = 0;i < productList.size();i++){
            if (productList.get(i) == product){
                has = true;
            }
        }
        return has;
    }
    public boolean addProduct(Product product){
        boolean addSuccess = true;
        for (int i = 0;i< productList.size();i++){
            if (product == productList.get(i)){
                addSuccess = false;
            }
            if (i == productList.size()-1 & product!=productList.get(i)){
                productList.add(product);
            }
        }
        return addSuccess;
    }
    public boolean removeProduct(Product product){
        boolean removeSuccess = true;
        for (int i = 0;i< productList.size();i++){
            if (product == productList.get(i)){
                removeSuccess = true;
                productList.remove(product);
            }
        }
        return removeSuccess;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
    public void transact(Product product, int method){
        if (method == 0){
            removeProduct(product);
            income += product.getPrice();
        }
        if (method == 1){
            addProduct(product);
            income -= product.getPrice();
        }
    }

}