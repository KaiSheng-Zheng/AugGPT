import java.util.ArrayList;


class Store {
    private static int cnt ;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        this.name = name;
        income = 0;
        cnt++;
        id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        id=cnt;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
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

    public boolean hasProduct(Product product) {
        boolean flag = false;
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId() == productList.get(i).getId()) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean addProduct(Product product) {
        boolean flag = false;
        if (!this.hasProduct(product)) {
            productList.add(product);
            flag = true;
        }
        return flag;
    }

    public boolean removeProduct(Product product) {
        boolean flag = false;
        if (this.hasProduct(product)) {
            this.productList.remove(product);
            flag = true;
        }
        return flag;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            productList.remove(product);
            this.setIncome(this.getIncome() + product.getPrice());
        } else if (method == 1) {
            productList.add(product);
            this.setIncome(this.getIncome() - product.getPrice());
        }
    }
}