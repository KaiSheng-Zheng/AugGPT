import java.util.*;

public class Customer {
    private static int cnt = 0; 
    private int id; 
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); 
    private float wallet;
    private ArrayList<Store> stores = new ArrayList<>();




    public Customer(String name, float wallet) {
        ++cnt;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public float getWallet() {
        return wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        if(amount > 0){
            this.wallet +=amount;
        }else{
            this.wallet -=Math.abs(amount);
        }
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.getProductList().contains(product) && product.getPrice() <= this.wallet){
            updateWallet(-product.getPrice());
            store.transact(product,0);
            this.shoppingCart.add(product);
            this.stores.add(store);
            return true;
        }else {
            return false;
        }

    }
    public void viewShoppingCart(SortBy sortMethod){
        if (this.shoppingCart.size()>0){
            if(sortMethod.equals(SortBy.PurchaseTime)){
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println( shoppingCart.get(i).toString());

                }
            }else{
                compar1(sortMethod);
            }
        }

    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)&&null !=this.stores.get(shoppingCart.indexOf(product))){
            Store store = this.stores.get(shoppingCart.indexOf(product));
            this.shoppingCart.remove(product);
            this.wallet += product.getPrice();
            store.transact(product,1);
            store.removeProduct(product);
            
            return true;
        }else{
            return false;
        }
    }

    public void compar(SortBy sortMethod){
        Map<Float,Product> map = new TreeMap<Float,Product>(
                new Comparator<Float>() {
                    @Override
                    public int compare(Float o1, Float o2) {
                        return o1.compareTo(o2);
                    }
                }

        );
        if(sortMethod.equals(SortBy.Price)){
            for (int i = 0; i < shoppingCart.size(); i++) {
                map.put(shoppingCart.get(i).getPrice(),shoppingCart.get(i));
            }
        }else{
            for (int i = 0; i < shoppingCart.size(); i++) {
                map.put(shoppingCart.get(i).getAvgRating(),shoppingCart.get(i));
            }
        }

        Set<Float> keySet = map.keySet();
        Iterator<Float> iter = keySet.iterator();

        while(iter.hasNext()){
            float key = iter.next();
            System.out.println(map.get(key).toString());

        }

    }

    public void compar1(SortBy sortMethod){
        if(sortMethod.equals(SortBy.Rating)){
            Map<Product,Float> map = new TreeMap<Product,Float>(
                    new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            if (o1.getAvgRating() - o2.getAvgRating()>=0){
                                return 1;
                            }else {
                                return -1;
                            }

                        }
                    }

            );

            for (int i = 0; i < shoppingCart.size(); i++) {
                map.put(shoppingCart.get(i),shoppingCart.get(i).getAvgRating());
            }
            Set<Product> keySet = map.keySet();
            Iterator<Product> iter = keySet.iterator();

            while(iter.hasNext()){
                System.out.println(iter.next().toString());

            }

        }else {
        Map<Product,Float> map = new TreeMap<Product,Float>(
                new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getPrice() - o2.getPrice()>=0){
                            return 1;
                        }else {
                            return -1;
                        }

                    }
                }

        );

        for (int i = 0; i < shoppingCart.size(); i++) {
            map.put(shoppingCart.get(i),shoppingCart.get(i).getAvgRating());
        }
        Set<Product> keySet = map.keySet();
        Iterator<Product> iter = keySet.iterator();

        while(iter.hasNext()){
            System.out.println(iter.next().toString());

        }

    }
        }




}
