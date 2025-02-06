import java.util.ArrayList;
class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        this.id = ++cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)) {
            shoppingCart.add(product);
            wallet-=product.getPrice();
            return true;
        }
        else return false;
    }
    public void updateWallet(float amount){
        this.wallet = this.wallet + amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>= product.getPrice()) return true;
        else return false;
    }
    private ArrayList<Product> copy(){

        ArrayList<Product> result = new ArrayList<Product>();

        for(int i = 0;i<shoppingCart.size();i++){
            result.add(shoppingCart.get(i));
        }
        return result;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod == SortBy.PurchaseTime) {
            ArrayList<Product> com = copy();
            for(int i =0;i<com.size();i++){
                System.out.println(com.get(i));
            }
        }
        else if(sortMethod == SortBy.Rating) {
            ArrayList<Product> com = copy();
            ArrayList<Product> result = new ArrayList<>();
            while(true) {
                if(com.size()== 0){
                    break;
                }
                if(com.size()== 1){
                    result.add(com.get(0));
                    break;
                }
                int index =0;
                float rating = com.get(0).getAvgRating();
                for(int i=0;i< com.size();i++){
                    if(rating<com.get(i).getAvgRating()) {
                        index = i;
                        rating = com.get(i).getPrice();
                    }
                }
                result.add(com.get(index));
                com.remove(index);
            }
            if(com.size()!= 0){
                for(int i = 0;i<result.size();i++){
                    System.out.println(result.get(i));
                }
            }
        }
        else if(sortMethod == SortBy.Price) {
            ArrayList<Product> com = copy();
            ArrayList<Product> result = new ArrayList<>();
            while(true) {
                if(com.size()== 0){
                    break;
                }
                if(com.size()== 1){
                    result.add(com.get(0));
                    break;
                }
                int index =0;
                float price = com.get(0).getPrice();
                for(int i=0;i< com.size();i++){
                    if(price<com.get(i).getPrice()) {
                        index = i;
                        price = com.get(i).getPrice();
                    }
                }
                result.add(com.get(index));
                com.remove(index);
            }
            if(com.size()!= 0){
                for(int i = 0;i<result.size();i++){
                    System.out.println(result.get(i));
                }
            }
        }
    }
    public static enum SortBy {
        PurchaseTime, Rating, Price
    }

    private boolean hasProductInShoppingCart(Product product){
        for(int i = 0;i<shoppingCart.size();i++){
            if(shoppingCart.get(i).equals(product)) return true;
        }
        return false;
    }
    public void removeFromShoppingCart(Product product){
        int index=-1;
        for(int i = 0;i<shoppingCart.size();i++){
            if(shoppingCart.get(i).equals(product)) {
                index = i;
                break;
            }
        }
        shoppingCart.remove(index);
    }
    public boolean refundProduct(Product product){
        if(hasProductInShoppingCart(product)) {

            removeFromShoppingCart(product);
            this.wallet+=product.getPrice();

            product.store.transact(product,1);

            return true;
        }
        else return false;
    }
}