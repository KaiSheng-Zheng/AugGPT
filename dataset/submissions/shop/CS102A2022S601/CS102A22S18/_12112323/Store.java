import java.util.ArrayList;
public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
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
    this.name=name;
    setIncome(0);
    this.productList =new ArrayList<>();
        setCnt(getCnt()+1);
        setId(getCnt());
        this.income=0;
    }


    public Store(String name, ArrayList<Product> productList, float income){
     this.name=name;
     this.productList=productList;
     this.income=income;
        setCnt(getCnt()+1);
        setId(getCnt());
    }
    public boolean hasProduct(Product product){
        boolean a = true;
 for (int p = 0;p<productList.size();p++){
     if (product.getId()==productList.get(p).getId()){
         return a;
     }
 }
 return false;
    }
    public boolean addProduct(Product product) {
        boolean a = false;
        for (int p = 0; p < productList.size(); p++) {
            if (product.getId() == productList.get(p).getId()) {
                return a;
            }
        }
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        boolean a = true;
        for (int p = 0; p < productList.size(); p++) {
            if (product.getId() == productList.get(p).getId()) {
                productList.remove(product);
                return a;
            }
        }
        return false;
    }
    public void transact(Product product, int method){
        if (method==0){
           income+=Math.round(product.getPrice() * 100) / 100f;
            productList.remove(product);
        }
        if (method==1){
            income-=Math.round(product.getPrice() * 100) / 100f;
            productList.add(product);

        }
    }

}
