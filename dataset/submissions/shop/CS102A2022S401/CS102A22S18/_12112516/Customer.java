import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;


class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private HashMap<Integer, Store> hashMapCorrespondingStoreOfProduct = new HashMap<>();


    public Customer(String name, float wallet){
        this.wallet = wallet;
        this.name = name;
        cnt = cnt + 1;
        id = cnt;
    }


    public boolean rateProduct(Product product, int rating){
        if(rating >= 1 && rating <= 5){
            product.setRating(rating);
            return true;
        }else return false;
    }

    public void updateWallet(float amount){
       if(amount >= 0){
           wallet = wallet + amount;
       }
       else if(amount < 0 && wallet+amount >= 0){
           wallet = wallet + amount;
       }
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet >= product.getPrice()){
            store.transact(product, 0);
            shoppingCart.add(product);
            this.updateWallet(-product.getPrice());
            hashMapCorrespondingStoreOfProduct.put(product.getId(), store);
            return true;
        }
        else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod == SortBy.PurchaseTime){
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        else if(sortMethod == SortBy.Rating){
            ArrayList<Float> temp = new ArrayList<>();
            for (Product product : shoppingCart) {
                temp.add(product.getAvgRating());
            }
            HashMap<Float, ArrayList<Product>> hashMapRating = new HashMap<>();
            ArrayList<Float> differentRatings = new ArrayList<>();
            for(int i = 0; i < temp.size(); i++){
                ArrayList<Product> tempArr;
                tempArr = hashMapRating.getOrDefault(temp.get(i), new ArrayList<>());
                if(tempArr.isEmpty()){
                    differentRatings.add(temp.get(i));
                }
                tempArr.add(shoppingCart.get(i));
                hashMapRating.put(temp.get(i), tempArr);
            }
            differentRatings.sort(Comparator.naturalOrder());
            for (Float differentRating : differentRatings) {
                for (int j = 0; j < hashMapRating.get(differentRating).size(); j++) {
                    System.out.println(hashMapRating.get(differentRating).get(j).toString());
                }
            }
        }
        else if(sortMethod == SortBy.Price){
            ArrayList<Float> temp = new ArrayList<>();
            for (Product product : shoppingCart) {
                temp.add(product.getPrice());
            }

            HashMap<Float, ArrayList<Product>> hashMapPrice = new HashMap<>();
            ArrayList<Float> differentPrice = new ArrayList<>();
            for(int i = 0; i < temp.size(); i++){
                ArrayList<Product> tempArr;
                tempArr = hashMapPrice.getOrDefault(temp.get(i), new ArrayList<>());
                if(tempArr.isEmpty()){
                    differentPrice.add(temp.get(i));
                }
                tempArr.add(shoppingCart.get(i));
                hashMapPrice.put(temp.get(i), tempArr);
            }

            differentPrice.sort(Comparator.naturalOrder());
            for (Float aFloat : differentPrice) {
                for (int j = 0; j < hashMapPrice.get(aFloat).size(); j++) {
                    System.out.println(hashMapPrice.get(aFloat).get(j).toString());
                }
            }
        }
    }





    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            hashMapCorrespondingStoreOfProduct.get(product.getId()).transact(product, 1);
            this.updateWallet(product.getPrice());
            shoppingCart.remove(product);
            return true;
        }else return false;
    }
}
