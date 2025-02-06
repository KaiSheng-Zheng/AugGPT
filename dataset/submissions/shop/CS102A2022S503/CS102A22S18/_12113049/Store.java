import java.util.ArrayList;
public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        cnt ++;
        this.id = cnt;
        this.name=name;
        this.income =0;
    }

    public String getName  (){return name;}
    public int getId (){
        return id;
    }
    public ArrayList<Product> getProductList(){return productList;}
    public ArrayList<Product> setProductList( ArrayList<Product> productList){return this.productList = productList ;}
    public float getIncome (){return income;}
    public void setIncome(float income){this.income = income;}

    public Store(String name, ArrayList<Product> productList, float income){
        cnt ++;
        this.id = cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;}


    public boolean hasProduct(Product product){
        int a=-1;
        a=productList.indexOf(product);
        if(a>=0){
            product.setStore(this);
            return true;
        }
        else{
            return false;}}


    public boolean addProduct(Product product){
        if(!hasProduct(product)){
            productList.add(product);
            return true;}
        else{
            return false;}}


    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;}
        else{
            return false;}}


    public void transact(Product product, int method){
        float income = getIncome();
        if(method==0){
            removeProduct(product);
            this.income=income+product.getPrice();}

        if(method==1){
            addProduct(product);
            this.income=income-product.getPrice();}}


}