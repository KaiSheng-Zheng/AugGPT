import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id = ++cnt;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income = 0;

    public Store(String name) {
        this.name = name;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this(name);
        this.productList.addAll(productList);
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        return productList.contains(product);
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            return false;
        }

        product.setStore(this);
        return productList.add(product);
    }

    public boolean removeProduct(Product product) {
        return productList.remove(product);
    }

    public ArrayList<Product> getProductList() {
        return new ArrayList<>(productList);
    }

    public void transact(Product product, int method) {
        switch (method) {
            case 0:
                removeProduct(product);
                income += product.getPrice();
                break;
            case 1:
                addProduct(product);
                income -= product.getPrice();
                break;
            default:
                throw new UnsupportedOperationException(String.format("Unknown method %d.", method));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Store)) {
            return false;
        }
        Store another = (Store) o;
        return id == another.id;
    }
}
