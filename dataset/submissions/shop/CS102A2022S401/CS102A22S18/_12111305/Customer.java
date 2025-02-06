import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private static int tnt=1;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private ArrayList<Store> storeList=new ArrayList<>();
    private ArrayList<Product> shoppingList=new ArrayList<>();


    public Customer(String name,float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product,int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store,Product product){
        if(store.hasProduct(product)){
            if(wallet>=product.getPrice()){
                float cost=(-1)*product.getPrice();
                updateWallet(cost);
                shoppingCart.add(product);
                storeList.add(store);
                shoppingList.add(product);
                product.setTime(tnt);
                tnt++;
                store.removeProduct(product);
                store.transact(product,0);
                return true;
            }
            else return false;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod.equals(SortBy.PurchaseTime)){
            Comparator<Product> comparator = new Comparator<>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o1.getTime() - o2.getTime();
                }
            };

            shoppingCart.sort(comparator);
            for(Product product:shoppingCart){
                System.out.println(product.toString());
            }
        }
        else if(sortMethod.equals(SortBy.Rating)){
            Comparator<Product> comparator = (o1, o2) -> {
                if (o1.getAvgRating() != o2.getAvgRating()) {
                    if (o2.getAvgRating() > o1.getAvgRating()) {
                        return -1;
                    } else return 1;
                } else{
                    return o1.getTime()- o2.getTime();
                }
            };

            shoppingCart.sort(comparator);
            for(Product product:shoppingCart){
                System.out.println(product.toString());
            }
        }
        else if (sortMethod.equals(SortBy.Price)){
            Comparator<Product> comparator = (o1, o2) -> {
                if (o1.getPrice() != o2.getPrice()) {
                    if (o2.getPrice() > o1.getPrice()) {
                        return -1;
                    } else return 1;
                } else{
                    return o1.getTime()- o2.getTime();
                }
            };

            shoppingCart.sort(comparator);
            for(Product product:shoppingCart){
                System.out.println(product.toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        if (shoppingList.size() != 0) {
            for (int i = 0; i < shoppingList.size(); i++) {
                if (shoppingList.get(i).getId() == product.getId()) {
                    shoppingList.remove(i);
                    shoppingCart.remove(product);
                    storeList.get(i).transact(product, 1);
                    storeList.remove(i);
                    updateWallet(product.getPrice());
                    return true;
                }
            }
        }
        return false;
    }
}
