import java.util.ArrayList;
public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;


    public Store(String name){
        this.name = name;
        cnt++;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        this.id = cnt;
    }

    public boolean hasProduct(Product product){
        for (int i = 0; i < this.productList.size(); i++) {
            if (this.productList.get(i).getId() == product.getId()){
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product){
        if ( !this.hasProduct(product)){
            this.productList.add(product);
            return true;
        }else {
            return false;
        }
    }

    public boolean removeProduct(Product product){
        if (this.hasProduct(product)){
            this.productList.remove(product);
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<Product> getProductList(){
        return this.productList;
    }

    public void transact(Product product, int method){
        if (method == 0 && this.removeProduct(product)){
            this.income += product.getPrice();
        } else if (method == 1 && this.addProduct(product)){
            this.income -= product.getPrice();
        }
    }

    public void changeIncome(float amount){
        this.income -= amount;
    }

}
