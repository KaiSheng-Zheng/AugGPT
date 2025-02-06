import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        ++cnt;
        id=cnt;
        this.name=name;
        income=0;
    }
    public Store(String name, ArrayList<Product>productList,float income){
        ++cnt;
        id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }
    public boolean hasProduct(Product product){
        int len=productList.size();
        for(int i=0;i<len;i++){
            if(productList.get(i).equal(product))return true;
        }
        return false;
    }
    public void incomeChange(float addIncome){
        income+=addIncome;
    }
    public boolean addProduct(Product product){
        int len=productList.size();
        for(int i=0;i<len;i++){
            //if(product.getName()==productList.get(i).getName())return false;
            if(productList.get(i).equal(product))return false;
        }
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        int len=productList.size();
        for(int i=0;i<len;i++){
            //if (product.getName()==productList.get(i).getName())
            if(productList.get(i).equal(product))
            {
                productList.remove(i);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            int len=productList.size();
            for(int i=0;i<len;i++) {
                //if (product.getName() == productList.get(i).getName())
                if(productList.get(i).equal(product))
                {
                    income+=product.getPrice();
                    productList.remove(i);
                    break;
                }
            }
        }
        else if(method==1){
            //bonus
        }
    }
}
