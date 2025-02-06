import java.util.ArrayList;
public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;cnt++;id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;this.productList=productList;this.income=income;cnt++;id=cnt;
    }
    public boolean hasProduct(Product product){
        boolean seek=false;
        for (int i=0;i<productList.size();i++){
            if(productList.get(i).getId()== product.getId()){
                seek=true;break;
            }
        }
        return seek;
    }
    public boolean addProduct(Product product){
        boolean add=true;
        for (int i=0;i<productList.size();i++){
            if(productList.get(i).getId()== product.getId()){
                add=false;
            }
        }
        if(add==true){productList.add(product);return true;}
        else {return false;}
    }
    public boolean removeProduct(Product product){
        boolean remove=false;
        for (int i=0;i<productList.size();i++){
            if(productList.get(i).getId()== product.getId()){
                productList.remove(i);remove=true;break;
            }
        }
        return remove;
    }
    public void remove(Product product){
        for (int i=0;i<productList.size();i++){
            if(productList.get(i).getId()== product.getId()){
                productList.remove(i);
            }
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            productList.remove(product);income+=product.getPrice();
        }else if(method==1){
            productList.add(product);income-=product.getPrice();
        }
    }
    public void setIncome(float income) {
        this.income += income;
    }
}
