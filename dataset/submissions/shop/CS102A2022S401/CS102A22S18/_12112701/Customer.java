import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(){cnt++;}

    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product, int rating){

        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&this.wallet>=product.getPrice()){
            this.shoppingCart.add(product);
            this.wallet-= product.getPrice();
            store.transact(product,0);
            return true;
        }
        else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod.equals(SortBy.Price)) {
            ArrayList<Float> priceList = new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++) {
                if (!priceList.contains(shoppingCart.get(i).getPrice())) {
                    priceList.add(shoppingCart.get(i).getPrice());
                }
            }
            ArrayList<Float> PriceList = rank(priceList);
            for (int i = 0; i < PriceList.size(); i++) {
                for (int j = 0; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(j).getPrice() == PriceList.get(i)) {
                        System.out.println(shoppingCart.get(j).toString());
                    }
                }
            }
        }
        if (sortMethod.equals(SortBy.Rating)) {
            ArrayList<Float> ratingList = new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++) {
                if (!ratingList.contains(shoppingCart.get(i).getAvgRating())) {
                    ratingList.add(shoppingCart.get(i).getAvgRating());
                }
            }
            ArrayList<Float> RatingList = rank(ratingList);
            for (int i=0;i<RatingList.size();i++){
                for (int j=0;j<shoppingCart.size();j++){
                    if(shoppingCart.get(j).getAvgRating()==RatingList.get(i)){
                        System.out.println(shoppingCart.get(j).toString());
                    }
                }
            }


        }
    }

    public boolean refundProduct(Product product){
        if(this.shoppingCart.contains(product)){
            this.shoppingCart.remove(product);
            this.wallet+=product.getPrice();
            product.getStore().get(0).transact(product,1);
            product.getStore().clear();
            return true;
        }
        else return false;
    }

    public static ArrayList<Float> rank(ArrayList<Float> list){
        for (int i=0;i<list.size()-1;i++){
            for (int j=0;j<list.size()-1-i;j++){
                if(list.get(j)>list.get(j+1)){
                    float temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }
        return list;
    }
}
