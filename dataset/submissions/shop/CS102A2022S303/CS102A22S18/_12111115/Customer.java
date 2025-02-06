import java.util.ArrayList;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        this.id=cnt;
    }

    public boolean rateProduct(Product product, int rating){
       return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (!store.hasProduct(product) || this.wallet < product.getPrice()) {
            return false;
        } else {
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product, 0);
            return true;
        }
    }


    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }

        if (sortMethod==SortBy.Rating){
            ArrayList<Product> A = new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++) {
                A.add(shoppingCart.get(i));
            }
            for (int i = 0; i < A.size()-1; i++) {
                for (int j = i+1; j < A.size(); j++) {
                    if (A.get(i).getAvgRating()>A.get(j).getAvgRating()){
                        Product L = A.get(j);
                        A.set(j,A.get(i));
                        A.set(i,L);
                    }
                }
            }
            for (int i = 0; i < A.size(); i++) {
                System.out.println(A.get(i));
            }
        }

        if (sortMethod==SortBy.Price){
            ArrayList<Product> A = new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++) {
                A.add(shoppingCart.get(i));
            }
            for (int i = 0; i < A.size()-1; i++) {
                for (int j = i+1; j < A.size(); j++) {
                    if (A.get(i).getPrice()>A.get(j).getPrice()){
                        Product L = A.get(j);
                        A.set(j,A.get(i));
                        A.set(i,L);
                    }
                }
            }
            for (int i = 0; i < A.size(); i++) {
                System.out.println(A.get(i));
            }
        }
    }

    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            updateWallet(-product.getPrice());
            product.getStore().removeProduct(product);
            product.getStore().setIncome(+product.getPrice());
            return true;
        }else {
            return false;
        }
    }

}
