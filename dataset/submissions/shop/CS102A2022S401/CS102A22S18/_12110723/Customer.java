import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private ArrayList<Product> List = new ArrayList<>();
    private ArrayList<Store> List2 = new ArrayList<>();

    public Customer(String name, float wallet){
        cnt = cnt+1;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)){
            return true;
        }else {return false;}
    }

    public void updateWallet(float amount){
        this.wallet = this.wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&product.getPrice()<=this.wallet){
            this.wallet=this.wallet-product.getPrice();
            store.transact(product,0);
            shoppingCart.add(product);
            List.add(product);
            List2.add(store);
            return true;
        }else {return false;}
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod.equals(SortBy.Price)){
                ArrayList<Product> ANS = comparePrice(this.shoppingCart);
                for(int i = 0;i<ANS.size();i++){
                    String a = ANS.get(i).toString();
                    System.out.print(a+"\n");
                }
        }
        if(sortMethod.equals(SortBy.Rating)) {
            ArrayList<Product> ans = compareRating(this.shoppingCart);
            for (int i = 0; i < ans.size(); i++) {
                String a = ans.get(i).toString();
                System.out.print(a+"\n");
            }
        }
        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                String a = shoppingCart.get(i).toString();
                System.out.print(a+"\n");
            }
        }
    }

    public ArrayList<Product> comparePrice(ArrayList<Product> shoppingCart){
        for(int i= 0; i < shoppingCart.size(); i++) {
            for(int j = 0; j < shoppingCart.size(); j++) {
                Product chuandi;
                if(j+1<shoppingCart.size()){
                if (shoppingCart.get(j).getPrice() > shoppingCart.get(j+1).getPrice()) {
                    chuandi = shoppingCart.get(j);
                    shoppingCart.set(j,shoppingCart.get(j+1));
                    shoppingCart.set(j+1,chuandi);
                }
                }
            }
        }
        return shoppingCart;
    }

    public ArrayList<Product> compareRating(ArrayList<Product> shoppingCart){
        for(int i= 0; i < shoppingCart.size(); i++) {
            for(int j = 0; j < shoppingCart.size(); j++) {
                Product chuandi;
                if(j+1<shoppingCart.size()){
                    if (shoppingCart.get(j).getAvgRating() > shoppingCart.get(j+1).getAvgRating()) {
                        chuandi = shoppingCart.get(j);
                        shoppingCart.set(j,shoppingCart.get(j+1));
                        shoppingCart.set(j+1,chuandi);
                    }
                }
            }
        }
        return shoppingCart;
    }

    public boolean haveProduct(Product product) {
        int test = 0;
        for(int i=0;i<shoppingCart.size();i++){
            if(product.equals(shoppingCart.get(i))){
                test = 1;
                break;
            }
        }
        if(test == 1){return true;}else {return false;}
    }

    public boolean refundProduct(Product product){
        if(haveProduct(product)){
            shoppingCart.remove(product);
            Store shop = List2.get(getnumber(product));
            shop.transact(product,1);
            this.wallet = this.wallet + product.getPrice();
            return true;
        }else {return false;}
    }

    public int getnumber(Product product){
        int number = 0;
        for(int i =0;i<List.size();i++){
            if(product.equals(List.get(i))){
                number = i;
            }
        }
        return number;
    }
}
