import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public Store(String name){
        this.name=name; this.income=0;
        cnt++;
        this.id=cnt;
        this.productList=new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.income = income;
        cnt++;
        this.id=cnt;
        this.productList=productList;
    }
    public boolean hasProduct(Product product){
        int count = 0;
        for (int i=0;i<productList.size();i++){
            if (productList.get(i) == product)
                count++;
        }
        return count != 0;

    }
    public boolean addProduct(Product product) {
       if (hasProduct(product))
            return false;
        else {
            productList.add(product);
        return true;}
    }
    public boolean removeProduct(Product product){
       if (!hasProduct(product))
            return false;
        else{
            productList.remove(product);
        return true;}
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        switch (method){
            case 0: removeProduct(product);this.income += product.getPrice();
            case 1: addProduct(product);this.income -= product.getPrice();
        }
    }
}