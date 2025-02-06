import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.name=name;
        this.productList=new ArrayList<Product>();
        this.income=0;
        cnt++;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList = productList;
        this.income=income;
        cnt++;
        id=cnt;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public boolean hasProduct(Product product){
        if(productList.contains(product)){
            return true;
        }
        else
            return false;
    }

    public boolean addProduct(Product product){
        int judge=0;
        for(int i =0;i<productList.size();i++){
            if(product.getID()==productList.get(i).getID()){
                judge++;
            }
        }
        if(judge==0){
            productList.add(product);
            return true;
        }
        else
            return false;
    }

    public boolean removeProduct(Product product){
        if(productList.contains(product)){
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
        if(method==0){
            productList.remove(product);
            this.income+=product.getPrice();
        }
        if(method==1){
            productList.add(product);
            this.income-=product.getPrice();
        }
    }
}
