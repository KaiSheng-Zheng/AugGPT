import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        this.name = name;
        income = 0;
        cnt++;
        id = cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        for(int i = 0;i < this.productList.size();i++){
            this.productList.get(i).setStore(this);
        }
        this.income = income;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product){
        int counter = 0;
        for (Product value : productList) {
            if (value.getName().equals(product.getName())) {
                counter++;
                break;
            }
        }
        return counter != 0;
    }
    public boolean addProduct(Product product){
        if(!hasProduct(product)){
            product.setStore(this);
            productList.add(product);
            return true;
        }
        else{
            return false;
        }
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }
        else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method == 0){
            if(removeProduct(product)) {
                income += product.getPrice();
            }
        }
        else if(method == 1){
            if(addProduct(product)) {
                income -= product.getPrice();
            }
        }
    }
}
