import java.util.ArrayList;


public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name=name;
        this.id = getId();
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        boolean toReturn = product.setRating(rating);
        return toReturn;
    }


    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.getProductList().contains(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            this.shoppingCart.add(product);
            this.updateWallet(-product.getPrice());
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod==SortBy.PurchaseTime) {
            ArrayList<Product> ByTime=new ArrayList<>();
            ByTime.addAll(this.shoppingCart);
            for (int i = 0; i < ByTime.size(); i++) {
                Product pro = ByTime.get(i);
                System.out.println(pro.toString());
            }
        }
        if (sortMethod==SortBy.Rating) {
            ArrayList<Product> ByRating= new ArrayList<>();
            ByRating=sortByRating(this.shoppingCart);
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                Product pro=ByRating.get(i);
                System.out.println(pro.toString());
            }
        }
        if(sortMethod==SortBy.Price){
            ArrayList<Product> ByPrice=sortByPrice(this.shoppingCart);
            for (int i = 0; i < ByPrice.size(); i++) {
                Product pro =ByPrice.get(i);
                System.out.println(pro.toString());
            }
        }
    }

    public ArrayList<Product> sortByRating(ArrayList<Product> toCorrect) {
        ArrayList<Product> toRating = new ArrayList<>();
        for (int i = 0; i < toCorrect.size(); i++) {
            toRating.add(toCorrect.get(i));
        }
        for (int i = 0; i < toRating.size()-1; i++) {
            for (int j = 0; j < toCorrect.size()-1; j++) {
                if(toRating.get(j).getAvgRating() > toRating.get(j+1).getAvgRating()){
                    Product a = toRating.get(j);
                    toRating.remove(j);
                    toRating.add(j + 1, a);
                }
            }
        }
        return toRating;
    }

    public ArrayList<Product> sortByPrice(ArrayList<Product> toCorrect) {
        ArrayList<Product> toPrice = new ArrayList<>();
        for (int i = 0; i < toCorrect.size(); i++) {
            toPrice.add(toCorrect.get(i));
        }
        for (int i = 0; i < toPrice.size()-1; i++) {
            for (int j = 0; j < toPrice.size()-1 ; j++) {
                if (toPrice.get(j).getPrice() > toPrice.get(j+1).getPrice()) {
                    Product a = toPrice.get(j);
                    toPrice.remove(j);
                    toPrice.add(j + 1, a);
                }
            }
        }
        return toPrice;
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            wallet = wallet + product.getPrice();
            shoppingCart.remove(product);
        }
        return false;
    }


}
