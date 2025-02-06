import java.util.ArrayList;

public class Customer {
    //Attributes
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private ArrayList<Store> beenTo = new ArrayList<>();

    //Constructor
    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWallet(float wallet) {
        this.wallet = wallet;
    }
    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getWallet() {
        return wallet;
    }
    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    //Methods
    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        float newWallet = getWallet();
        newWallet += amount;
        setWallet(newWallet);
    }

    public boolean hasProduct(Product product) {
        int productNum = shoppingCart.size();
        boolean has = false;
        for (int i = 0; i < productNum; i++) {
            if (product == shoppingCart.get(i)) {
                has = true;
                break;
            }
        }
        return has;
    }

    public boolean purchaseProduct(Store store, Product product) {
        float price = product.getPrice();
        float nowWallet = getWallet();
        if (store.hasProduct(product) && nowWallet >= price) {
            store.transact(product, 0);
            shoppingCart.add(product);
            beenTo.add(store);
            updateWallet(- price);
            return true;
        }
        else
            return false;
    }

    public boolean refundProduct(Product product) {
        int storeID = product.getBelongToStore();
        int beenToStoreNum = beenTo.size();
        int beenToIndex;
        for (beenToIndex = 0; beenToIndex < beenToStoreNum; beenToIndex++) {
            if (storeID == beenTo.get(beenToIndex).getId()) {
                break;
            }
        }
        float price = product.getPrice();
        if (hasProduct(product)) {
            beenTo.get(beenToIndex).transact(product, 1);
            shoppingCart.remove(product);
            updateWallet(price);
            return true;
        }
        else
            return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> inputCart = getShoppingCart();
        int productNum = inputCart.size();
        if (productNum != 0) {
            ArrayList<Product> outputCart = new ArrayList<>(productNum);
            if (sortMethod == SortBy.PurchaseTime) {
                outputCart = inputCart;
            }
            else if (sortMethod == SortBy.Price) {
                outputCart.add(inputCart.get(0));
                for (int i = 1; i < productNum; i++) {
                    if (inputCart.get(i).getPrice() >= outputCart.get(outputCart.size() - 1).getPrice())
                        outputCart.add(inputCart.get(i));
                    else {
                        for (int k = 0; k < i; k++) {
                            if (inputCart.get(i).getPrice() < outputCart.get(k).getPrice()) {
                                outputCart.add(k, inputCart.get(i));
                                break;
                            }
                        }
                    }
                }
            }
            else {
                outputCart.add(inputCart.get(0));
                for (int i = 1; i < productNum; i++) {
                    if (inputCart.get(i).getAvgRating() >= outputCart.get(outputCart.size() - 1).getAvgRating())
                        outputCart.add(inputCart.get(i));
                    else {
                        for (int k = 0; k < i; k++) {
                            if (inputCart.get(i).getAvgRating() < outputCart.get(k).getAvgRating()) {
                                outputCart.add(k, inputCart.get(i));
                                break;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < productNum; i++) {
                System.out.println(outputCart.get(i).toString());
            }
        }
        else {
            System.out.print("");
        }
    }
}
