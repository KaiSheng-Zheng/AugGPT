import java.util.ArrayList;

public class Store {
    // Attributes
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;
    // Constructors
    public Store(String name){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = new ArrayList<>(){};;
        this.income = 0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id = cnt;
        this.name = name;
        if (!productList.isEmpty()) this.productList = productList;
        if (income > 0) this.income = income;
    }
    public int getId() {return id;}
    // Methods
    public boolean hasProduct(Product product){
        for (Product value : productList) {
            if (value.equals(product)) return true;
        }
        return false;
    }
    public boolean addProduct(Product product){
        for (Product value : this.productList) {
            if (value.equals(product)) return false;
        }
        this.productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        for (int i = 0; i < this.productList.size(); i++){
            if (this.productList.get(i).equals(product)){
                this.productList.remove(i);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Product> getProductList(){return this.productList;}
    public void transact(Product product, int method){
        if (method == 0){
            removeProduct(product);
            this.income += product.getPrice();
        }
        else if (method == 1){
            addProduct(product);
            income -= product.getPrice();
        }
    }
}
