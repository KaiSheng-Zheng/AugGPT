import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        this.id=cnt;
    }

    public boolean rateProduct(Product product, int rating){
        boolean result = product.setRating(rating);
        return result;
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (this.wallet>=product.getPrice()){
            if (store.hasProduct(product)){
                store.transact(product,0);
                this.shoppingCart.add(product);
                this.wallet-=product.getPrice();
                return true;
            }
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (int i = 0; i < this.shoppingCart.size(); i++) {
                    System.out.println(this.shoppingCart.get(i).toString());

                }
                break;
            case Price:
                ArrayList<Product> temp = new ArrayList<>();
                for (int i = 0; i < this.shoppingCart.size(); i++) {
                    temp.add(this.shoppingCart.get(i));
                }
                Product lowestPrice;
                int index;
                while (temp.size()!=0){
                    lowestPrice=temp.get(0);
                    index=0;
                    for (int i = 0; i < temp.size(); i++) {
                        if (temp.get(i).getPrice()<lowestPrice.getPrice()){
                            lowestPrice=temp.get(i);
                            index=i;
                        }
                    }
                    System.out.println(temp.get(index).toString());
                    temp.remove(index);
                }
                break;
            case Rating:
                ArrayList<Product> temp2 = new ArrayList<>();
                for (int i = 0; i < this.shoppingCart.size(); i++) {
                    temp2.add(this.shoppingCart.get(i));
                }
                Product lowestrate;
                int index2;
                while (temp2.size()!=0){
                    lowestrate=temp2.get(0);
                    index2=0;
                    for (int i = 0; i < temp2.size(); i++) {
                        if (temp2.get(i).getAvgRating()<lowestrate.getAvgRating()){
                            lowestrate=temp2.get(i);
                            index2=i;
                        }
                    }
                    System.out.println(temp2.get(index2).toString());
                    temp2.remove(index2);
                }
                break;
        }
    }
    public boolean refundProduct(Product product){
        for (int i = 0; i < this.shoppingCart.size(); i++) {
            if (this.shoppingCart.get(i).getId()==product.getId()){
                this.shoppingCart.remove(i);
                product.getSource().transact(product,1);
                this.wallet+=product.getPrice();
                return true;
            }
        }
        return false;
    }
}

