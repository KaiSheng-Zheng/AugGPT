import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt += 1;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            return product.setRating(rating);
        }else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        if (amount >= 0) {
            this.wallet += amount;
        } else {
            float amount1 = Math.abs(amount);
            this.wallet -= amount1;
        }
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet > product.getPrice()) {
            this.shoppingCart.add(product);
            this.wallet -= product.getPrice();
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortBy) {
        if (sortBy.equals(SortBy.PurchaseTime)) {
            for (Product product : shoppingCart) {
                System.out.print(product.toString());
                System.out.print("\n");
            }
        }
        if (sortBy.equals(SortBy.Rating)) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = 0; j < shoppingCart.size() - i - 1; j++) {
                    if (shoppingCart.get(j).getAvgRating() == shoppingCart.get(j + 1).getAvgRating()) {
                            if (shoppingCart.get(j).getId() < shoppingCart.get(j + 1).getId()) {
                                Product shoppingCart1 = shoppingCart.get(j);
                                Product shoopingCart2 = shoppingCart.get(j + 1);
                                shoppingCart.remove(shoppingCart.get(j));
                                shoppingCart.add(j, shoopingCart2);
                                shoppingCart.remove(shoppingCart.get(j + 1));
                                shoppingCart.add(j + 1, shoppingCart1);
                            } else {
                                Product shoppingCart1 = shoppingCart.get(j + 1);
                                Product shoopingCart2 = shoppingCart.get(j);
                                shoppingCart.remove(shoppingCart.get(j));
                                shoppingCart.add(j, shoppingCart1);
                                shoppingCart.remove(shoppingCart.get(j + 1));
                                shoppingCart.add(j + 1, shoopingCart2);
                            }
                        }
                    if (shoppingCart.get(i).getAvgRating() > shoppingCart.get(j).getAvgRating()) {
                        Product shoppingCart1 = shoppingCart.get(i);
                        Product shoopingCart2 = shoppingCart.get(j);
                        shoppingCart.remove(shoppingCart.get(i));
                        shoppingCart.add(i, shoopingCart2);
                        shoppingCart.remove(shoppingCart.get(j));
                        shoppingCart.add(j, shoppingCart1);
                    }
                }
            }
            for (int i = 0; i <= shoppingCart.size(); i++) {
                System.out.print(shoppingCart.get(i).toString());
                System.out.print("\n");
            }
        }
        if (sortBy.equals(SortBy.Price)) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = 0; j < shoppingCart.size() - i - 1; j++) {
                    if (shoppingCart.get(j).getPrice() == shoppingCart.get(j + 1).getPrice()) {
                        if (shoppingCart.get(j).getId() < shoppingCart.get(j + 1).getId()) {
                            Product shoppingCart1 = shoppingCart.get(j);
                            Product shoopingCart2 = shoppingCart.get(j + 1);
                            shoppingCart.remove(shoppingCart.get(j));
                            shoppingCart.add(j, shoopingCart2);
                            shoppingCart.remove(shoppingCart.get(j + 1));
                            shoppingCart.add(j + 1, shoppingCart1);
                        } else {
                            Product shoppingCart1 = shoppingCart.get(j + 1);
                            Product shoopingCart2 = shoppingCart.get(j);
                            shoppingCart.remove(shoppingCart.get(j));
                            shoppingCart.add(j, shoppingCart1);
                            shoppingCart.remove(shoppingCart.get(j + 1));
                            shoppingCart.add(j + 1, shoopingCart2);
                        }
                    } else if (shoppingCart.get(j).getPrice() > shoppingCart.get(j + 1).getPrice()) {
                        Product shoppingCart1 = shoppingCart.get(j);
                        Product shoopingCart2 = shoppingCart.get(j + 1);
                        shoppingCart.remove(shoppingCart.get(j));
                        shoppingCart.add(j, shoopingCart2);
                        shoppingCart.remove(shoppingCart.get(j + 1));
                        shoppingCart.add(j + 1, shoppingCart1);
                    }
                }
            }
            for (int i = 1; i <= shoppingCart.size(); i++) {
                System.out.print(shoppingCart.get(i).toString());
                System.out.print("\n");
            }
        }
    }

    public boolean refundProduct(Product product) {
        return shoppingCart.contains(product);
    }
}