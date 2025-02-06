import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        this.name = name;
        this.income = 0;
        cnt ++;
        int count = cnt;
        this.id = count;

    }

    public int getId() {
        return id;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt ++;
        int count = cnt;
        this.id = count;
    }

    public static int getCnt() {
        return cnt;
    }

    public String getName() {
        return name;
    }

    public float getIncome() {
        return income;
    }

    public boolean hasProduct(Product product){
        boolean hasProduct = false;
        for (int i = 0;i < productList.size();i ++){
            if (productList.get(i).getId() == product.getId()){//can it judge? or need each element equal?
                hasProduct = true;
                break;
            }
        }
        return hasProduct;
    }

    public boolean addProduct(Product product){
        boolean hasProduct = false;
        for (int i = 0;i < productList.size();i ++){
            if (productList.get(i).getId() == product.getId()){//can it judge? or need each element equal?
                hasProduct = true;
                break;
            }
        }
        if (hasProduct == false){
            productList.add(product);
        }
        return !hasProduct;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public boolean removeProduct(Product product){
        boolean hasProduct = false;
        for (int i = 0;i < productList.size();i ++){
            if (productList.get(i).getId() == product.getId()){//can it judge? or need each element equal?
                hasProduct = true;
                break;
            }
        }
        if (hasProduct == true){
            productList.remove(product);
        }
        return hasProduct;
    }

    public ArrayList<Product> getProductList(){
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
