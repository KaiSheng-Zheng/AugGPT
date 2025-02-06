import java.util.ArrayList;

public class Customer {
	private static int cnt = 0;
	private static int[] rk = new int[500000];
	private int id;
	private String name;
	private ArrayList<Product> shoppingCart = new ArrayList<Product>();
	private ArrayList<Store> stores = new ArrayList<Store>();
	private float wallet;

	public Customer(String name, float wallet) {
		this.name = name;
		this.wallet = wallet;
		id = ++cnt;
	}

	public boolean rateProduct(Product product, int rating) {
		return product.setRating(rating);
	}

	public void updateWallet(float amount) {
		wallet += amount;
	}

	public boolean purchaseProduct(Store store, Product product) {
		if (wallet < product.getPrice() || !store.hasProduct(product))
			return false;
		store.transact(product, 0);
		wallet -= product.getPrice();
		shoppingCart.add(product);
		stores.add(store);
		return true;
	}

	private void Sort(int o, int l, int r) {
		if (l == r)
			return;
		int mid = l + r >> 1, i = l, j = mid + 1, siz = 0;
		Sort(o, l, mid);
		Sort(o, mid + 1, r);
		int[] tmp = new int[r - l + 1];
		while (i <= mid && j <= r) {
			if ((o == 1 ? shoppingCart.get(rk[i]).getPrice() <= shoppingCart.get(rk[j]).getPrice()
					: shoppingCart.get(rk[i]).getAvgRating() <= shoppingCart.get(rk[j]).getAvgRating()))
				tmp[siz++] = rk[i++];
			else
				tmp[siz++] = rk[j++];
		}
		while (i <= mid)
			tmp[siz++] = rk[i++];
		while (j <= r)
			tmp[siz++] = rk[j++];
		for (int k = 0; k < siz; k++)
			rk[l + k] = tmp[k];
	}

	public void viewShoppingCart(SortBy sortmethod) {
		switch (sortmethod) {
			case PurchaseTime:
				for (Product i : shoppingCart)
					System.out.println(i);
				break;
			case Rating:
				for (int i = 0; i < shoppingCart.size() - 1; i++)
					rk[i] = i;
				Sort(0, 0, shoppingCart.size() - 1);
				for (int i = 0; i < shoppingCart.size() - 1; i++)
					System.out.println(shoppingCart.get(rk[i]));
				break;
			case Price:
				for (int i = 0; i < shoppingCart.size() - 1; i++)
					rk[i] = i;
				Sort(1, 0, shoppingCart.size() - 1);
				for (int i = 0; i < shoppingCart.size() - 1; i++)
					System.out.println(shoppingCart.get(rk[i]));
				break;
		}
	}

	public boolean refundProduct(Product product) {
		if (!shoppingCart.contains(product))
			return false;
		for (int i = 0; i < shoppingCart.size(); i++)
			if (product.getID() == shoppingCart.get(i).getID()) {
				stores.get(i).addProduct(product);
				stores.remove(stores.get(i));
				break;
			}
		wallet += product.getPrice();
		shoppingCart.remove(product);
		return true;
	}
}
