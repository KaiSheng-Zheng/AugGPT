import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart =new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.name = name;
        this.wallet = wallet;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if (rating >= 1 && rating <= 5){
            product.setRating(rating);
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount){
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case Price:
                ArrayList<Product> newList1 = (ArrayList<Product>) this.shoppingCart.clone();
                ArrayList<Product> sorted1 = new ArrayList<>();
                if (newList1.size() == 0){} else {
                    while (newList1.size() > 0){
                        sorted1.add(highestPrice(newList1));
                        newList1.remove(highestPrice(newList1));
                    }
                    print(sorted1);
                }
                break;
            case Rating:
                ArrayList<Product> newList2 = (ArrayList<Product>) this.shoppingCart.clone();
                ArrayList<Product> sorted2 = new ArrayList<>();
                if (newList2.size() == 0){} else {
                    while (newList2.size() > 0){
                        sorted2.add(highestRate(newList2));
                        newList2.remove(highestRate(newList2));
                    }
                    print(sorted2);
                }
                break;
            case PurchaseTime:
                print(shoppingCart);
                break;
            default:break;
        }
    }

    public static Product highestPrice(ArrayList<Product> array){
        Product theProduct = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (theProduct.getPrice() > array.get(i).getPrice()){
                theProduct = array.get(i);
            } else if (theProduct.getPrice() == array.get(i).getPrice()){
                if (array.indexOf(theProduct) > i){
                    theProduct = array.get(i);
                }
            }
        }
        return theProduct;
    }

    public static Product highestRate(ArrayList<Product> array){
        Product theProduct = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (theProduct.getAvgRating() > array.get(i).getAvgRating()){
                theProduct = array.get(i);
            } else if (theProduct.getAvgRating() == array.get(i).getAvgRating()){
                if (array.indexOf(theProduct) > i){
                    theProduct = array.get(i);
                }
            }
        }
        return theProduct;
    }

    public static void print(ArrayList<Product> array){
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i).toString());
        }
    }

    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            this.updateWallet(product.getPrice());
                product.getFrom().transact(product,1);
            return true;
        } else {
            return false;
        }
    }
}
