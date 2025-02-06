import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<Product>();
    private float income;
    public Store(String name){
        cnt++;
        id=cnt;
        this.name=name;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id=cnt;
        this.name=name;this.productList=productList;this.income=income;
        for (int i = 0;i<productList.size();i++){
            productList.get(i).setStore(id);
        }
    }
    public boolean hasProduct(Product product){
        boolean x=false;
        for(int i=0;i<productList.size();i++){
            if(productList.get(i).getId()==product.getId()){
                x=true;
            }
        }
        return x;
    }
    public boolean addProduct(Product product){
        boolean x=true;
        for(int i=0;i<productList.size();i++){
            if(productList.get(i).getId()==product.getId()){
                x=false;
            }
        }
        if(x){
            productList.add(product);
        }
        product.setStore(id);
        return x;
    }
    public boolean removeProduct(Product product){
        boolean x=false;
        for(int i=0;i<productList.size();i++){
            if(productList.get(i).getId()==product.getId()){
                productList.remove(i);x=true;break;
            }
        }
        return x;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            if(hasProduct(product)){
                productList.remove(product);
                income+=product.getPrice();
            }
        }
        if(method==1){
            productList.add(product);
            income-=product.getPrice();
        }
    }

    public int getId() {
        return id;
    }

    public void setIncome(float income) {
        this.income -= income;
    }
}