import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Store.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public Store(String name){
        this.name = name;
        cnt++;
        id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product){
        boolean test = false;
        for (int i=0;i<this.productList.size();i++){
            if (this.productList.get(i)==product){
                test = true;
                break;
            }
        }
        if (test==true){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean addProduct(Product product){
        boolean test = true;
        for (int i=0;i<this.productList.size();i++){
            if (product==this.productList.get(i)){
                test = false;
                break;
            }
            else {
                test = true;
            }
        }
        if (test==false){
            return false;
        }
        else {
            this.productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        boolean test = false;
        for (int i=0;i<this.productList.size();i++){
            if (product==this.productList.get(i)){
                this.productList.remove(product);
                test = true;
                break;
            }
            else {
                test = false;
            }
        }
        if (test == true){
            return true;
        }
        else {
            return false;
        }
    }

    public void transact(Product product,int method){
        if (method==0){
            this.productList.remove(product);
            this.income += product.getPrice();
        }
        else if (method==1){
            this.productList.add(product);
            this.income -= product.getPrice();
        }
    }
}
