import java.util.ArrayList;

public class Store {
    //Attributes
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    //Constructor
    public Store(String name){
        this.name = name;
        cnt++;
        id = cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.income = income;
        this.productList = productList;
        cnt++;
        id = cnt;
    }

    //Methods
    public boolean hasProduct(Product product){
        for (int x = 0;x< productList.size();x++){
            if (product.getId() == productList.get(x).getId()){
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product){
        if (!hasProduct(product)){
            productList.add(product);
            return true;
        }else{return false;}
    }

    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        }else{return false;}
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        switch (method){
            case 0:
                income += product.getPrice();
                removeProduct(product);
                break;
            case 1:
                productList.add(product);
                income -= product.getPrice();
        }
    }

    //Setters
    public void setId(int id) {this.id = id;}
    public void setIncome(float income) {this.income += income;}

    //Getters
    public int getId() {return id;}
}
