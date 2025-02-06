
import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private final ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    private String from;
    HashMap<Object, Object> buyFrom = new HashMap<>();

    public Customer(String name, float wallet){
        cnt++;
        setId(cnt);
        setWallet(wallet);
        setName(name);

    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet = this.wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&this.wallet>=product.getPrice()){
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product,0);
            buyFrom.put(product.getName(),store);
            return true;
        }
        else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime -> {
                for (Product product:shoppingCart){
                    System.out.println(product);
                }
            }
            case Price -> {
                ArrayList<Product> newList = new ArrayList<>();
                int count;
                for (int i=0;i<shoppingCart.size();i++){
                    if (i==0){
                        newList.add(shoppingCart.get(0));
                    }
                    else {
                        count = 0;
                        for (int j=1;j<=newList.size();j++){
                            if (shoppingCart.get(i).getPrice()>=newList.get(newList.size()-j).getPrice()){
                                newList.add(newList.size()-j+1,shoppingCart.get(i));
                                count = 1;
                                break;
                            }
                        }
                        if (count==0){
                            newList.add(0,shoppingCart.get(i));
                        }
                    }
                }

                for (Product product:newList){
                    System.out.println(product);
                }
            }
            case Rating -> {
                shoppingCart.sort((o1, o2) -> Float.compare(o1.getAvgRating(), o2.getAvgRating()));
                for (Product product:shoppingCart){
                    System.out.println(product);
                }
            }
        }
    }
    public boolean refundProduct(Product product){
        int ifHas = 0;
        for (Product product1 : shoppingCart){
            if (product.getName().equals(product1.getName())){
                ifHas = 1;
                shoppingCart.remove(product1);
                updateWallet(product.getPrice());
                Store thisStore = (Store) buyFrom.get(product.getName());
                thisStore.transact(product,1);
                break;
            }
        }
        return ifHas==1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }


}


