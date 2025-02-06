import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>(0);
    private float income = 0;

    public Store(String name){
        this.name = name;
        cnt++;
        id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product){
        for (Product p : productList){
            if(p.getId() == product.getId()){
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        for (int i = 0;i<productList.size();i++){
            if (productList.get(i).getId() == product.getId()) {
                return false;
            }
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        ArrayList<Product> productArrayList1 = new ArrayList<>();
        for (Product a : productList){
            if(a.getId() != product.getId()){
                productArrayList1.add(a);
            }
        }
        if(productArrayList1.size() == productList.size()){
            return false;
        }else {
            productList = productArrayList1;
            return true;
        }
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if (method == 0){
            removeProduct(product);
            income += product.getPrice();
        }
        if(method == 1){
            addProduct(product);
            income -= product.getPrice();
        }
    }
}