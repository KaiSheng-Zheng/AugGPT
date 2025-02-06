import java.util.ArrayList;

public class Store {

    private static int cnt=0;
    private int id;
    public int getId(){return id;}
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.name=name;
        income=0;
        productList=new ArrayList<>();
        cnt++;
        id=cnt;
    };
    public Store(String name,ArrayList<Product> productList,float income){
        this.name=name;
        this.income=income;
        this.productList=productList;
        cnt++;
        id=cnt;
    }

    public boolean hasProduct(Product product){
        for(int i=0;i<productList.size();i++){
            if(productList.get(i).getId()==product.getId()){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        }else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product,int method){
        if(method==0){
            if(removeProduct(product)) {
                income += product.getPrice();
            }
        }else if(method==1){
            if(addProduct(product)) {
                income -= product.getPrice();
            }
        }
    }

}