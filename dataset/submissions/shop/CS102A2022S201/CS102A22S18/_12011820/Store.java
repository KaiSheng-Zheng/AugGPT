import java.util.ArrayList;
class Store{
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.name = name;
        income = 0;
        productList = new ArrayList<Product>();
        id=++cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        for(int i = 0;i<productList.size();i++){
            productList.get(i).store = this;
        }
    }

    public boolean hasProduct(Product product){
        int size = productList.size();
        for(int i = 0;i<size;i++){
            if(product.equals(productList.get(i))){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        int size = productList.size();
        for(int i = 0;i<size;i++){
            if(productList.get(i).equals(product)) return false;
        }
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){

        for(int i = 0;i < productList.size();i++){
            if(productList.get(i).equals(product)){
                productList.remove(i);
                return true;
            }
        }
        return  false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            if(removeProduct(product))  income+= product.getPrice();
        }
        if(method==1){
            if(addProduct(product)) income-= product.getPrice();
        }
    }
}