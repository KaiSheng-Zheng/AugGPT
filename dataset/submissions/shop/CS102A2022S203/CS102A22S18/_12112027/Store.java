import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        this.id =cnt;
        this.name = name;
        this.income = 0;

    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }



    public boolean hasProduct(Product product){
        boolean flag = false;
        for (int i = 0; i<this.productList.size() ; i++){
            if (productList.contains(product)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }else {
            this.productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            this.productList.remove(product);
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if (method == 0){
            removeProduct(product);
            this.income += product.getPrice();
        }else if (method == 1){
            addProduct(product);
            this.income -= product.getPrice();
        }
    }

//    public boolean equals(Product product1, Product product2){
//        String name1 = product1.getName();
//        String name2 = product2.getName();
//        if (name1.equals(name2)){
//            return true;
//        }else return false;
//    }

    public String getName() {
        return name;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}
