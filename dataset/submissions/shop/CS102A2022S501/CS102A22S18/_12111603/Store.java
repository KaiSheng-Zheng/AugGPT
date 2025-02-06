
import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product>productList=new ArrayList<>();
    private float income;
    public Store(String name){
        this.name = name;
        this.income = 0;
        cnt++;
        this.id = cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        this.id = cnt;
    }
    public boolean hasProduct(Product product){
        boolean flag = false;
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getID()==product.getID()){
                flag = true;
                break;
            }
        }
        return flag;
    }
    public boolean addProduct(Product product){
        boolean flag = false;
        if(!hasProduct(product)){
            productList.add(product);
            flag = true;
        }
        return flag;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public float getIncome() {
        return income;
    }

    public boolean removeProduct(Product product){
        boolean flag = false;
        if(hasProduct(product)){
            flag = true;
            productList.remove(product);
        }
        return flag;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product,int method){
        if(method == 0){
            for (int i = 0; i < productList.size(); i++) {
                if(productList.get(i).getID()==product.getID()){
                    productList.remove(i);
                    this.income += product.getPrice();
                }
            }


        }
    }


}
