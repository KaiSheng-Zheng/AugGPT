import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private float income;
    private ArrayList<Product> productList=new ArrayList<>();

    public Store(String name){
        income=0;
        cnt++;
        id=cnt;
        this.name=name;

    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id=cnt;
        this.income=income;
        this.name=name;
        this.productList=productList;
        for (int i=0;i<productList.size();i++){
            productList.get(i).setStore(id);
        }
    }
    public boolean hasProduct(Product product){
         boolean x=false;
         for (int i=0;i<productList.size();i++){
             if (product.getId()==productList.get(i).getId()){
                 x=true;
             }
         }
         return x;

    }
    public boolean addProduct(Product product){
        boolean x=true;
        for (int i=0;i<productList.size();i++){
            if (product.getId()==productList.get(i).getId()){
                x=false;
            }
        }
        if (x){
            productList.add(product);
        }
        product.setStore(id);
        return x;

    }
    public boolean removeProduct(Product product){
        boolean x=false;
        for (int i=0;i<productList.size();i++){
            if (product.getId()==productList.get(i).getId()){
                productList.remove(i);
                x=true;
                break;
            }
        }
        return x;

    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            if (hasProduct(product)){
                productList.remove(product);
                income+= product.getPrice();
            }
        }
        if (method==1){
            if(productList.add(product))
            income=income- product.getPrice();

        }
    }
    public void setIncome(float income){
        this.income-=income;
    }
    public int getId(){
        return id;
    }
}