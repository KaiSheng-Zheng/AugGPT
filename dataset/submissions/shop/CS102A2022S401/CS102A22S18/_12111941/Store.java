import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private final int id; // unique for each store and the value is set to cnt.
    private final String name;
    private ArrayList<Product> productList;
    private float income;


    public Store(String name){
        cnt++;
        this.name=name;
        this.id=cnt;
        this.productList=new ArrayList<>();
        this.income=0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.name=name;
        this.income=income;
        this.productList=productList;
        this.id=cnt;
        for (int i=0;i< productList.size();i++){
            productList.get(i).setstore(this);
        }
    }

    public boolean hasProduct(Product product){
        boolean ans=false;
        for (int i=0;i<productList.size();i++){
            if (productList.get(i).getId()==product.getId())
                ans=true;
        }
        return ans;
    }


    public void addIncome(float income){
        this.income=this.income+income;
    }
    public boolean addProduct(Product product){
        boolean ans=true;
            for (int m=0;m<productList.size();m++){
                if (productList.get(m).getId()==product.getId())
                    ans=false;
            }
        if (ans) {
            this.productList.add(product);
            product.setstore(this);
        }
        return ans;
    }
    public boolean removeProduct(Product product){
        if (productList.contains(product)){
            productList.remove(product);
            return true;
        }
        else
            return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            income=income+product.getPrice();
        }
        else if (method==1){
            productList.add(product);
            income=income-product.getPrice();
        }
    }

}