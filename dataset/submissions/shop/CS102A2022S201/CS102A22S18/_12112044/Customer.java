import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Store> storesList = new ArrayList<>();
    private ArrayList<Product> Car = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id=cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if(!product.setRating(rating)){
            return false;
        }
        else {
            return true;
        }
    }

    public void updateWallet(float amount){
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store,Product product){
        float income;
        float pay;

        if(store.hasProduct(product) && wallet>=product.getPrice()){
            pay = - product.getPrice();
            updateWallet(pay);
            shoppingCart.add(product);
            storesList.add(store);
            Car.add(product);
            income = store.getIncome() + product.getPrice();
            store.setIncome(income);
            store.removeProduct(product);
            return true;
        }
        else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> change = new ArrayList<>(shoppingCart);
        switch (sortMethod){
            case PurchaseTime:
                for(int i = 0;i<change.size(); i++){
                    System.out.println(change.get(i).toString());
                }
                break;

            case Rating:
                for(int i = 0; i<change.size()-1;i++){
                    for(int j = 0; j < change.size()-1-i; j++){
                        if( change.get(j).getAvgRating() > change.get(j+1).getAvgRating() ){
                            Product original = change.get(j);
                            change.set(j,change.get(j+1));
                            change.set(j+1,original);
                        }
                    }
                }

                for(int i = 0; i< change.size(); i++) {
                    System.out.println(change.get(i).toString());
                }
                break;

            case Price:
                for(int i = 0; i<change.size()-1;i++){
                    for(int j = 0; j < change.size()-1-i; j++){
                        if( change.get(j).getPrice() > change.get(j+1).getPrice() ){
                            Product original = change.get(j);
                            change.set(j,change.get(j+1));
                            change.set(j+1,original);
                        }

                    }
                }

                for(int i = 0; i< change.size(); i++) {
                    System.out.println(change.get(i).toString());
                }
                break;


        }
    }

    public boolean refundProduct(Product product){
        for (int i = 0; i < storesList.size(); i++) {
            for (int j = 0; j < storesList.get(i).getProductList().size(); j++) {
                if( storesList.get(i).getProductList().contains(product)  ){
                    return false;
                }
            }
        }

        if(!Car.contains(product)){
            return false;
        }

        for( int i = 0;i < Car.size(); i++){
            if (product.equals(Car.get(i))){
                shoppingCart.remove(product);
                updateWallet(product.getPrice());
                storesList.get(i).transact(product,1);
            }
        }
        return true;
    }
}
