import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private HashMap<Integer,Store>trace;

    public Customer(String name, float wallet){
        cnt++;
        this.id=this.cnt;
        this.name=name;
        this.wallet=wallet;
        this.trace=new HashMap<>();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if ((store.hasProduct(product)) && (this.wallet >= product.getPrice())) {
            this.updateWallet(-product.getPrice());
            this.shoppingCart.add(product);
            store.transact(product, 0);
            trace.put(product.getId(), store);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (Product buytime:shoppingCart) {
                    System.out.println(buytime.toString());
                }
                break;
            case Rating:
                Product []aftersorting=new Product[(shoppingCart.size())];
                for (Product me:shoppingCart) {
                    int index=0;
                    for (Product toFindWhereAmI:shoppingCart) {
                        if (shoppingCart.indexOf(toFindWhereAmI)!=shoppingCart.indexOf(me)){
                            if (toFindWhereAmI.getAvgRating()< me.getAvgRating()){
                                index++;
                            }
                            if ((toFindWhereAmI.getAvgRating()== me.getAvgRating())&&(shoppingCart.indexOf(toFindWhereAmI)<shoppingCart.indexOf(me))){
                                index++;
                            }
                        }
                    }
                    aftersorting[index]=me;

                }
                for (Product toPrint:aftersorting) {
                    System.out.println(toPrint.toString());
                }
                break;
            case Price:
                Product[]aftersortyou=new Product[shoppingCart.size()];
                for (Product you:shoppingCart){
                    int yourIndex=0;
                    for (Product toFindWhereYouAre:shoppingCart) {
                        if (shoppingCart.indexOf(toFindWhereYouAre)!=shoppingCart.indexOf(you)){
                            if (toFindWhereYouAre.getPrice()<you.getPrice()){
                                yourIndex++;
                            }
                            if ((toFindWhereYouAre.getPrice()==you.getPrice())&&(shoppingCart.indexOf(toFindWhereYouAre)<shoppingCart.indexOf(you))){
                                yourIndex++;
                            }
                        }
                    }
                    aftersortyou[yourIndex]=you;
                }
                for (Product printYou:aftersortyou) {
                    System.out.println(printYou.toString());
                }
                break;
        }


    }
    public boolean refundProduct(Product product) {
        if (trace.containsKey(product.getId())) {
            Store store = trace.get(product.getId());
            store.transact(product, 1);
            this.updateWallet(product.getPrice());
            this.shoppingCart.remove(product);
            trace.remove(product.getId());

            return true;
        } else {
            return false;
        }
    }




}
