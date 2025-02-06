import java.util.ArrayList;


public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
private ArrayList<String> recoredsintime=new ArrayList<>();
private ArrayList<String> recoredsinRating=new ArrayList<>();
private ArrayList<String> recoredsinPrice=new ArrayList<>();
    public Customer(String name, float wallet) {
        cnt++;
        this.name = name;
        this.wallet = wallet;
  id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }


    public void updateWallet(float amount){
        wallet=wallet+amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>=product.getPrice()){int count1 = 0;int count2=0;
            store.transact(product,0);
            shoppingCart.add(product);
            updateWallet((-1)*product.getPrice());
            recoredsintime.add(product.toString());
            for (Product value : shoppingCart) {
                if (product.getAvgRating()>value.getAvgRating()) {
                    count1++;
                }
                if(product.getPrice()==value.getPrice()){count2=shoppingCart.indexOf(value);break;}
                if(product.getPrice()>value.getPrice()){count2++;}
            }
            recoredsinRating.add(count1,product.toString());
            recoredsinPrice.add(count2,product.toString());
        return true;
        }
else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){switch (sortMethod){
        case PurchaseTime:for(String sb:recoredsintime){System.out.println(sb);}break;
        case Rating:for(String sb:recoredsinRating){System.out.println(sb);}break;
        case Price:for(String sb:recoredsinPrice){System.out.println(sb);}break;
        default:break;
    }
    }

    public boolean refundProduct(Product product){return true;}
}
