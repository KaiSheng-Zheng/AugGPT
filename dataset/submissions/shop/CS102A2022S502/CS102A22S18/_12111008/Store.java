import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        cnt++;
        this.name=name;
        this.income=0;
        this.id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.income=income;
        this.name=name;
        this.productList=productList;
        for (int i=0;i< productList.size();i++){
            productList.get(i).setStoreIn(this);
        }
    }
    public boolean hasProduct(Product product){
        boolean judge=this.productList.contains(product);
        return judge;
    }
    public boolean addProduct(Product product){
        boolean judge=!(productList.contains(product));
        if (judge){
            productList.add(product);
            product.setStoreIn(this);
        }
        return judge;
    }
    public boolean removeProduct(Product product){
        boolean judge=productList.contains(product);
        if (judge){
            productList.remove(product);

        }
        return judge;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }

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

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public float getIncome() {
        return this.income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);
            setIncome(product.getPrice()+getIncome());
        }else if (method==1){
            productList.add(product);
            setIncome(getIncome()- product.getPrice());
        }
    }
}
