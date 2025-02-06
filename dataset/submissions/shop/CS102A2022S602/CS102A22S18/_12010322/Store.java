import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income=0;



    public Store(String name){
        this.name=name;
        cnt++;
        this.id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        cnt++;
        this.id=cnt;
        this.income=income;
        this.productList=productList;
    }
    public boolean hasProduct(Product product){
        int l=this.productList.size();
        boolean hasProduct=false;
        if(l!=0){
        for(int i=0;i<l;i++){
            if(product.getId()==(this.productList.get(i).getId())){
                hasProduct=true;
                break;
            }
        }}
        return hasProduct;
    }
    public boolean addProduct(Product product){
        boolean addProduct;
        if(this.hasProduct(product)==true){
            addProduct=false;
        }else {
            addProduct=true;
            this.productList.add(product);
        }
        return addProduct;
    }
    public boolean removeProduct(Product product){
    boolean removeProduct;
        if(this.hasProduct(product)==true){
            int n=0;
        removeProduct=true;
        int l=this.productList.size();
        for(int i=0;i<l;i++){
            if(product.getId()==(this.productList.get(i).getId())){
                n=i;
                break;
            }
            }
        this.productList.remove(n);
    }else {
            removeProduct=false;
        }
        return removeProduct;
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    };
    public void transact(Product product, int method) {
        if (method == 0) {
            this.removeProduct(product);
            this.income += product.getPrice();
        }else if(method==1){
            this.productList.add(product);
            this.income-= product.getPrice();
        }
    }



}
