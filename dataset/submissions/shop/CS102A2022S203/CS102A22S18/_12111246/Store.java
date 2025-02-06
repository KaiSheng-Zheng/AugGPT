import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }


    private Product product;
    public Store(String name, ArrayList<Product> productList, float income)
    {this.id=1;
        this.income=income;
        this.productList=productList;}
    public Store(String name)
    {
        this.id+=1;this.cnt+=1; this.name=name;
        this.income=0f;}

    public boolean hasProduct(Product product){

        if (this.getProductList().contains(product)){return true;}
        else {return false;}
    }
    public boolean addProduct(Product product)
    {if (productList.contains(product)){return false;}
     else {productList.add(product);return true;}
    }
    public boolean removeProduct(Product product)
    {
        if (productList.contains(product)){productList.remove(product);return true;}
        else {return false;}
    }
    public ArrayList<Product>getProductList(){return productList;}
    public void transact(Product product,int method){

        if (method==0){productList.remove(product);income=income+ product.getPrice();}
        if (method==1){productList.add(product);income=income- product.getPrice();}
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
