import java.util.ArrayList;
public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;


    public Store(String name){
        cnt++;
        income=0;
        this.name=name;
        productList=new ArrayList<>();
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.name=name;
        this.income=income;
        this.productList=new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            this.productList.add(productList.get(i));
        id=cnt;
        }

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getIncome() {
        return income;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public boolean hasProduct(Product product){
        boolean a=false;
        for (int i = 0; i <productList.size() ; i++) {
            if(product.getName().equals(productList.get(i).getName())){
             a=true;
            }
        }
        return a;
    }

    public boolean addProduct(Product product){
     if(!hasProduct(product)){
         productList.add(product);
         return true;
     }else {
         return false;
     }

    }


    public boolean removeProduct(Product product){
     if(hasProduct(product)){
         productList.remove(product);
         return true;
     }else {
         return false;
     }

    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            income+=product.getPrice();
        }
        if(method==1){
            productList.add(product);
            income-=product.getPrice();
        }
    }



}
