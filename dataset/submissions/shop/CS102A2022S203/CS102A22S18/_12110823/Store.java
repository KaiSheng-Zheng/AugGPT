import java.util.ArrayList;




public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.income=0;
        this.productList=new ArrayList<Product>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.income=income;
        this.productList=productList;
    }

    public String getName() {
        return name;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getId() {
        return id;
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

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public boolean hasProduct(Product product){
        /*for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==product.getId()){
                return true;
            }
        }*/if (productList.contains(product)){
            return true;
        }else {
        return false;}
    }

    public boolean addProduct(Product product){
        boolean has=false;
        if(productList.contains(product)){
            return false;
        }
        else {productList.add(product);
        return true;}
    };
    public boolean removeProduct(Product product){
        if(!productList.contains(product)){
            return false;
        }
        else {productList.remove(product);
            return true;}
    }
    public ArrayList<Product> getProductList(){return productList;};
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            this.income+=product.getPrice();
        }
        if (method==1){
            productList.add(product);
            this.income-=product.getPrice();
        }
    }
}
