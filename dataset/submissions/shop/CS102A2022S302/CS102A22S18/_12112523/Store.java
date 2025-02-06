import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;


    public Store(String name){
        this.name=name;
        this.id=cnt+1;
        cnt++;
        this.income=0;
        productList=new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        this.name=name;
        this.id=cnt+1;
        cnt++;
        this.income=income;
        this.productList=productList;
    }

    public boolean hasProduct(Product product){
        for (int i = 0; i < this.productList.size(); i++) {
            if(this.productList.get(i).getId()==product.getId()){
                return true;
            }
        }
        return false;
    }


    public boolean addProduct(Product product){
        for (int i = 0; i < this.productList.size(); i++) {
            if(hasProduct(product)){
                return false;
            }
        }
        productList.add(product);
        return false;
    }

    public boolean removeProduct(Product product){
        for (int i = 0; i < this.productList.size(); i++) {
            if(hasProduct(product)){
                productList.remove(product);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        switch (method){
            case 0:
                removeProduct(product);
                this.income+=product.getPrice();
                break;
            case 1:
                addProduct(product);
                this.income-=product.getPrice();
                break;
        }
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}
