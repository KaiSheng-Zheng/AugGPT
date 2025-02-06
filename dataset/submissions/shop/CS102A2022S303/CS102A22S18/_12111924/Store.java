import java.util.ArrayList;
import java.util.Comparator;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.income=0;
        this.productList=new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
       cnt++;
        this.id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Store.cnt = cnt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public boolean hasProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if (this.productList.get(i).getId()==product.getId()){return true;}
        }return false;
    }
    public boolean addProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if (this.productList.get(i).getId()==product.getId()){return false;}
        }
        this.productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if (this.productList.get(i).getId()==product.getId()){this.productList.remove(product);return true;}
        }return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){removeProduct(product);this.income+=product.getPrice();}
        else if (method==1){addProduct(product);this.income-=product.getPrice();}
    }
}

