import java.util.ArrayList;
public class Customer {
    private static int cnt = 0 ; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products default is empty.
    private float wallet;
    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt += 1;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if( product.setRating(rating)){
            return true;
        }else{
            return false;
        }
    }

    public void updateWallet(float amount){
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)){
            if(product.getPrice()<=wallet){
                shoppingCart.add(product);
                product.setStore(store);
                wallet = wallet - product.getPrice();
                store.getProductList().remove(product);
                store.changeIncome(product.getPrice());
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> shoppingCart1 = new ArrayList<>();
        for(int i = 0 ; i < shoppingCart.size() ; i++){
            shoppingCart1.add( shoppingCart.get(i));
        }
        switch(sortMethod){
            case PurchaseTime:
                for(int i = 0 ; i < shoppingCart1.size() ; i++ ){
                    System.out.println(shoppingCart1.get(i).toString());
                }
                break;
            case Rating:
                for(int i = 0 ; i < shoppingCart1.size() - 1 ; i++ ){
                    for(int j = 0 ; j < shoppingCart1.size() - 1 - i ; j++ ){
                        if(shoppingCart1.get(j).getAvgRating() > shoppingCart1.get( j + 1 ).getAvgRating()) {
                            Product temp1 = shoppingCart1.get(j);
                            shoppingCart1.set(j, shoppingCart1.get(j + 1));
                            shoppingCart1.set(j + 1, temp1);
                        }
                    }
                }
                for(int i = 0 ; i < shoppingCart1.size() ; i++ ){
                    System.out.println(shoppingCart1.get(i).toString());
                }
                break;
            case Price:
                for (int i = 0; i < shoppingCart1.size() - 1; i++) {
                    for (int j = 0; j < shoppingCart1.size() - 1 - i; j++) {
                        if (shoppingCart1.get(j).getPrice() > shoppingCart1.get(j + 1).getPrice()) {
                            Product temp2 = shoppingCart1.get(j);
                            shoppingCart1.set(j, shoppingCart1.get(j + 1));
                            shoppingCart1.set(j + 1, temp2);
                        }
                    }
                }
                for(int i = 0 ; i< shoppingCart1.size() ; i++ ){
                    System.out.println(shoppingCart1.get(i).toString());
                }
                break;
        }
        }


    public boolean refundProduct(Product product){
        boolean flag = false;
        for(int i = 0 ; i < shoppingCart.size(); i++ ){
            if(shoppingCart.get(i).equals(product)){
                flag = true; // Actually buy it.
            }
        }
        if ( flag ){
            //return to store's productList
            product.getLocation().addProduct(product);
            //change store's income
            product.getLocation().changeIncome(-product.getPrice()) ;
            //return to customer's wallet
            wallet = wallet + product.getPrice();
            //change shoppingCart
            shoppingCart.remove(product);
            return true;
        }else{
            return false;
        }
    }
}