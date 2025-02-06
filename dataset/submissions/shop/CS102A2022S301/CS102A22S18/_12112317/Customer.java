import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        id = cnt;
        this.name = name;
        shoppingCart = new ArrayList<>();
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        if(rating>=1&&rating<=5){
            product.setRating(rating);
            return true;
        }else{
            return false;
        }
    }

    public void updateWallet(float amount){
        wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            store.transact(product,0);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            return true;

        }else{
            return false;
        }
    }

    public ArrayList getShoppingCart(){
        return shoppingCart;
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> copyShoppingCart = new ArrayList<>();
        for (int i = 0; i <=shoppingCart.size()-1 ; i++) {
            copyShoppingCart.add(shoppingCart.get(i));
        }
        ArrayList<Product> resultShoppingCart = new ArrayList<>();
        for (int i = 0; i <=shoppingCart.size()-1 ; i++) {
            copyShoppingCart.set(i,shoppingCart.get(i));
        }
        if(sortMethod.getShu()==1){
            resultShoppingCart = copyShoppingCart;
            for (int i = 0; i <=resultShoppingCart.size()-1 ; i++) {
                System.out.printf("%s\n",resultShoppingCart.get(i).toString());
            }
        }

        if(sortMethod.getShu()==2){
            for (int i = 0; i <copyShoppingCart.size()-1 ; i++) {
                for (int j = 0; j <copyShoppingCart.size()-1-i ; j++) {
                    if(copyShoppingCart.get(j).getAvgRating()>copyShoppingCart.get(j+1).getAvgRating()){
                        Product temp = copyShoppingCart.get(j);
                        copyShoppingCart.set(j,copyShoppingCart.get(j+1));
                        copyShoppingCart.set(j+1,temp);

                    }
                }
            }
            resultShoppingCart = copyShoppingCart;
            for (int i = 0; i <=resultShoppingCart.size()-1 ; i++) {
                System.out.printf("%s\n",resultShoppingCart.get(i).toString());
            }
        }

        if(sortMethod.getShu()==3){
            for (int i = 0; i <copyShoppingCart.size()-1 ; i++) {
                for (int j = 0; j <copyShoppingCart.size()-1-i ; j++) {
                    if(copyShoppingCart.get(j).getPrice()>copyShoppingCart.get(j+1).getPrice()){
                        Product temp = copyShoppingCart.get(j);
                        copyShoppingCart.set(j,copyShoppingCart.get(j+1));
                        copyShoppingCart.set(j+1,temp);

                    }
                }
            }
            resultShoppingCart = copyShoppingCart;
            for (int i = 0; i <=resultShoppingCart.size()-1 ; i++) {
                System.out.printf("%s\n",resultShoppingCart.get(i).toString());
            }
        }


    }




    public boolean refundProduct(Product product){
        return true;
    }


}
