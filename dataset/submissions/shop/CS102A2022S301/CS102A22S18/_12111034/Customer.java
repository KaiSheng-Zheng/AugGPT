import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart =new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if (rating==1||rating==2||rating==3||rating==4||rating==5){
            product.setRating(rating);
            return true;
        }
        else return false;
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet>=product.getPrice()){
            wallet=wallet- product.getPrice();
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (int i=0;i<shoppingCart.toArray().length;i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod==SortBy.Rating){
            Product temp;
            Product [] arr =new  Product[shoppingCart.size()];
            for (int i=0;i<arr.length-1;i++){
                for (int j=0;j<arr.length-i-1;j++){
                    if (arr[j].getAvgRating()>arr[j+1].getAvgRating()){
                        temp=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                    }
                }
            }
            for (int i=0;i<arr.length;i++){
                System.out.println(arr[i].toString());
            }

        }
        if (sortMethod==SortBy.Price){
            Product temp;
            Product [] arr =new  Product[shoppingCart.size()];
            for (int i=0;i<arr.length-1;i++){
                for (int j=0;j<arr.length-i-1;j++){
                    if (arr[j].getPrice()>arr[j+1].getPrice()){
                        temp=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                    }
                }
            }
            for (int i=0;i<arr.length;i++){
                System.out.println(arr[i].toString());
            }
        }
    }

}