import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private ArrayList<Product> oldlist=new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;
        income=0;
        cnt++;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.income=income;
        oldlist.addAll(productList);
        this.productList=productList;
        cnt++;
        id=cnt;
    }
    public boolean hasProduct(Product product){
        if(productList.size()==0){
            return false;
        }
        for (Product value : productList) {
            if (product.getId()==value.getId()) {
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        }
        productList.add(product);
        oldlist.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            oldlist.remove(product);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            productList.remove(product);
            income+=product.getPrice();}
        if(method==1){
            productList.add(product);
            income-=product.getPrice();
        }
    }

    public static int getCnt() {
        return cnt;
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

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public void addIncome(float price) {
        this.income+=price;
    }

    public ArrayList<Product> getOldlist() {
        return oldlist;
    }
}
