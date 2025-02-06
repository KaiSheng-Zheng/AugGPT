import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        this.name = name;
        cnt++;
        id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        id = cnt;
    }

    public float getIncome() {
        return income;
    }

    public boolean hasProduct(Product product){
        int flag = 0;
        for(int i=0;i<productList.size();i++){
            if(productList.get(i).getId()==product.getId())
                flag++;
        }
        if(flag>0)
            return true;
        else
            return false;
    }

    public boolean addProduct(Product product){
        int flag = 0;
        for(int i=0;i<productList.size();i++){
            if(productList.get(i).getId()==product.getId())
                flag++;
        }
        if(flag>0) {
            return false;
        }
        else{
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        int flag = 0;
        for(int i=0;i<productList.size();i++) {
            if (productList.get(i).getId() == product.getId()){
                productList.remove(i);
                flag++;
            }
        }
        if(flag>0)
            return true;
        else
            return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            productList.remove(product);
            income+=product.getPrice();
        }
        else if(method==1){
            productList.add(product);
            income-=product.getPrice();
        }
    }
}
