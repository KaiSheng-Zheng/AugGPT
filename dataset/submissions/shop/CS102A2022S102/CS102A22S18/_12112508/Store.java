import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        this.name = name;
        this.income = 0;
        cnt++;
        id = cnt;
    }

    public Store(String name,ArrayList<Product> productLists,float income){
        this.name = name;
        this.income = income;
        this.productList = productLists;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product){
        for (Product value : productList) {
            if (value.getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }
        else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product,int method){
        if (method == 0){
            productList.remove(product);
            income += product.getPrice();
        }
        else if (method == 1){
            productList.add(product);
            income -= product.getPrice();
        }
    }
}
