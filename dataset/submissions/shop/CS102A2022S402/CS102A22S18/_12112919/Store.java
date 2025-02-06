import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private ArrayList<Product> allProduct;
    private ArrayList<Integer> stores;
    private float income;

    public Store(String name) {
        productList = new ArrayList<>();
        this.name = name;
        this.income = 0;
        this.cnt++;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        this.cnt++;
        this.id = cnt;
    }

    public boolean hasProduct(Product product){
        for (int i = 0; i < this.productList.size(); i++) {
            if (product.getId()==productList.get(i).getId()) return true;
        }
        return false;
    }

    public boolean addProduct(Product product){
        if (!hasProduct(product)){
            productList.add(product);
            return true;
            
        }
        return false;
    }

    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(productList.indexOf(product));
            return true;
        }return false;
    }



    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method){
        if (method == 0) {
            this.removeProduct(product);
            this.income += product.getPrice();
        }
        if (method == 1) {
            this.addProduct(product);
            this.income -= product.getPrice();
        }
    }
}
