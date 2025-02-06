import java.util.ArrayList;

public class Customer {
    private String name;
    private static int cnt = 0;
    private int id;
    private float wallet;
    private ArrayList<Product> shoppingCart=new ArrayList<Product>();
    private ArrayList<Store> storelist=new ArrayList<Store>();
    public Customer(String name, float wallet){
        cnt++;id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        boolean x=false;boolean y=true;
        if(store.hasProduct(product)){
            if(wallet-product.getPrice()>= product.getPrice()){
                store.transact(product,0);
                shoppingCart.add(product);wallet-=product.getPrice();
                x=true;
                for(int i=0;i<storelist.size();i++){
                    if(storelist.get(i).getId()==store.getId()){
                        y=false;
                    }
                }
                if(y){
                    storelist.add(store);
                }
            }
        }
        return x;
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> shoppingCartX=new ArrayList<>(shoppingCart);
        switch (sortMethod) {
            case Price:
                for (int i = 0; i < shoppingCartX.size(); i++) {
                    for (int j = i + 1; j < shoppingCartX.size(); j++) {
                        if (shoppingCartX.get(j).getPrice() < shoppingCartX.get(i).getPrice()) {
                            Product productj = shoppingCartX.get(j);
                            Product producti = shoppingCartX.get(i);
                            shoppingCartX.set(i, productj);
                            shoppingCartX.set(j, producti);
                        }
                    }
                }
                for (int i = 0;i<shoppingCartX.size();i++){
                    System.out.println(shoppingCartX.get(i).toString());
                }
                break;
            case Rating:
                for (int i = 0; i < shoppingCartX.size(); i++) {
                    for (int j = i + 1; j < shoppingCartX.size(); j++) {
                        if (shoppingCartX.get(j).getAvgRating() < shoppingCartX.get(i).getAvgRating()) {
                            Product productj = shoppingCartX.get(j);
                            Product producti = shoppingCartX.get(i);
                            shoppingCartX.set(i, productj);
                            shoppingCartX.set(j, producti);
                        }
                    }
                }
                for (int i = 0;i<shoppingCartX.size();i++){
                    System.out.println(shoppingCartX.get(i).toString());
                }
                break;
            case PurchaseTime:
                for (int i = 0;i<shoppingCartX.size();i++){
                    System.out.println(shoppingCartX.get(i).toString());
                }
        }
    }
    public boolean refundProduct(Product product){
        boolean x=false;int y=-1;int z=-1;
        for(int i=0;i<shoppingCart.size();i++){
            if(shoppingCart.get(i).getId()==product.getId()){
                x=true;y=i;
            }
        }
        for(int i=0;i<storelist.size();i++){
            if(storelist.get(i).getId()==product.getStore()){
                z=i;
            }
        }
        if(x){
            wallet+=shoppingCart.get(y).getPrice();
            shoppingCart.remove(y);
            storelist.get(z).addProduct(product);
            storelist.get(z).setIncome(product.getPrice());
        }
        return x;
    }
}
