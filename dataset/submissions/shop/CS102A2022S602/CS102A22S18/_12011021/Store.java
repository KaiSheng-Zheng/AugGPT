import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name){
        cnt=cnt+1;
        id=cnt;
        this.name=name;
        this.income=0;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt=cnt+1;
        id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }

    public boolean hasProduct(Product product){
        boolean have=false;
        for(int i=0;i<productList.size();i++){
            if(product.getId()==this.productList.get(i).getId()){
                have=true;
                break;
            }
        }
        return have;
    }

    public boolean addProduct(Product product){
        if(this.hasProduct(product)){
            return false;
        }else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if(this.hasProduct(product)){
            for(int i=0;i<productList.size();i++){
                if(product.getId()==this.productList.get(i).getId()){
                    productList.remove(i);
                }
            }
            return true;
        }else {
            return false;
        }
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public float getIncome() {
        return income;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            this.removeProduct(product);
            this.setIncome(this.getIncome()+product.getPrice());
        }
        if(method==1){
            this.addProduct(product);
            this.setIncome(this.getIncome()-product.getPrice());
        }
    }
}
