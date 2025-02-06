import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;


    public Store(String name){
        this.name = name;
        income = 0;
        cnt++;
        id = cnt;
        this.productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.income = income;
        this.productList = new ArrayList<>(productList);
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product){
        return productList.contains(product);
    }

    public boolean addProduct(Product product){
        for (Product product1: productList) {
            if(product1.getId() == product.getId()) {
                return false;
            }
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product){
        for (Product product1: productList) {
            if(product.getId() == product1.getId()){
                productList.remove(product);
                return true;
            }
        } return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method == 0) {
            if(removeProduct(product)) income += product.getPrice();
        }else if(method == 1){
            if(addProduct(product)){
                income -= product.getPrice();
                if(income < 0) income = 0;
            }
        }
    }
    //maybe the customer's money will increase
}
