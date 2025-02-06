import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private final int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    public Store(String name){
        id = ++cnt;
        this.name = name;
        this.income = 0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        id = ++cnt;
        this.name = name;
        this.productList = (ArrayList<Product>) productList.clone();
        this.income = income;
    }
    public int getId() {
        return id;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)) return false;
        else{
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(!hasProduct(product)) return false;
        else{
            productList.remove(product);
            return true;
        }
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        switch (method){
            case 0:
                this.income += product.getPrice();
                removeProduct(product);
                break;
            //Bonus
            case 1:
                addProduct(product);
                this.income -= product.getPrice();
                break;
        }
    }
}
