import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private ArrayList<Integer> productId=new ArrayList<>();
    private float income;

    public Store(String name){
        this.name=name;
        income=0;
        cnt++;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        for(int i=0;i<productList.size();i++){
            productId.add(productList.get(i).getId());
        }
        this.income=income;
        cnt++;
        id=cnt;
    }

    public boolean hasproductss(Product product){
        for(int i=0;i<productId.size();i++){
            if(productId.get(i).equals(product.getId())){
                return true;
            }
        }
        return false;
    }

    public boolean hasProduct(Product product){
        for(int i=0;i<productList.size();i++){
            if(productList.get(i).equals(product)){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        boolean add=true;
        for(int i=0;i<productList.size();i++){
            if(productList.get(i).equals(product)){
                add=false;
                break;
            }
        }
        if(add){
            productList.add(product);
            productId.add(product.getId());
        }
        return add;
    }
    public boolean removeProduct(Product product){
        boolean remove=false;
        for(int i=0;i<productList.size();i++){
            if(productList.get(i).equals(product)){
                remove=true;
                productList.remove(product);
                break;
            }
        }
        return remove;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            removeProduct(product);
            income+=product.getPrice();
        }
        if(method==1){
            addProduct(product);
            income-=product.getPrice();
        }
    }
}