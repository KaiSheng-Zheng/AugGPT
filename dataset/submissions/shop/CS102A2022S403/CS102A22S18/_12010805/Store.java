import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id = 0;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private static ArrayList<Store> storeList = new ArrayList<>();
    private float income;
    public int[] address = new int[1000001];
    public int[] loc = new int[1000001];

    public float getIncome() {
        return income;
    }

    public static ArrayList<Store> getStoreList() {
        return storeList;
    }

    public int getId() {
        return id;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public Store(String name){
        this.name = name;
        income = 0;
        cnt++;
        id = cnt;
        loc[id] = 1;
        storeList.add(this);
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id = cnt;
        this.name = name;
        this.productList = productList;
        for (int i = 0; i < productList.size(); i++)
        {
            address[productList.get(i).getId()] = 1;
            productList.get(i).setStoreId(id);
        }
        this.income = income;

        loc[id] = 1;
        storeList.add(this);
    }
    public boolean hasProduct(Product product){
        if (address[product.getId()] == 1)
            return true;
        else return false;
    }
    public boolean addProduct(Product product){
        if (!hasProduct(product))
        {
            productList.add(product);
            address[product.getId()] = 1;
            product.setStoreId(id);
            return true;
        }
        else return false;
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product))
        {
            productList.remove(product);
            address[product.getId()] = 0;
            return true;
        }
        else return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method == 0)
        {
            income += product.getPrice();
            removeProduct(product);
            address[product.getId()] = 0;
        }
        if (method == 1)
        {
            income -= product.getPrice();
            addProduct(product);
            address[product.getId()] = 1;
        }
    }
}
