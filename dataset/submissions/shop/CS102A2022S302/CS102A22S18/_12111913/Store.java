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

    public ArrayList<Product> getProductList() {
        return productList;
    }


    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.income=0;
        this.productList=new ArrayList<>();
    }


    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }


    public boolean hasProduct(Product product){
        boolean is=false;
        for (Product a:productList){if (a.getId()==product.getId())
        {is=true;}}
        return  is;
    }


    public boolean addProduct(Product product){
        boolean is=true;
        for (Product a:productList){if (a.getId()==product.getId())
        {return false;}}
        this.productList.add(product);
        return  is;
    }


    public boolean removeProduct(Product product){
        boolean is=false;
        for (Product a:productList){if (a.getId()==product.getId())
        is=true;}
        if (is){productList.remove(product);return true;}
        else {return false;}
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
