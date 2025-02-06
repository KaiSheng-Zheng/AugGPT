import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        this.name = name;
        cnt++;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        this.id = cnt;
    }

    public boolean hasProduct(Product product) {
        if (productList.contains(product))
            return true;
        else return false;
    }

    public boolean addProduct(Product product) {
        int count = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId() == productList.get(i).getId())
                count++;
        }
        if (count == 0) {
            productList.add(product);
            return true;
        } else return false;
    }

    public boolean removeProduct(Product product) {
        int count = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.remove(productList.get(i));
                count++;
            }
        }
        if(count == 0) return false;
        else return true;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method == 0){
            removeProduct(product);
            income += product.getPrice();
        }
        if(method == 1){
            addProduct(product);
            income -= product.getPrice();
        }
    }


}