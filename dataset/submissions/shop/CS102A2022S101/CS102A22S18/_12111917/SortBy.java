import java.util.ArrayList;

public enum SortBy {
    PurchaseTime,
    Rating,
    Price;


    public void sortByPurchaseTime(ArrayList<Product> shoppingCart ) {
        for (Product product : shoppingCart ) {
            System.out.println(product.toString());
        }
    }

    public void sortByPrice(ArrayList<Product> shoppingCart) {
        BST<Float,Integer,Integer> bst = new BST<>();
        for (int i = 0; i < shoppingCart.size(); i++) {
            bst.root = bst.insert(bst.root, shoppingCart.get(i).getPrice(), i, i);
        }
        bst.inOrderRecur(bst.root);
        ArrayList<Integer> res = bst.getRetval();
        for (Integer re : res) {
            System.out.println(shoppingCart.get(re).toString());
        }
    }

    public void sortByRating(ArrayList<Product> shoppingCart) {
        BST<Float,Integer,Integer> bst = new BST<>();
        for (int i = 0; i < shoppingCart.size(); i++) {
            bst.root = bst.insert(bst.root, shoppingCart.get(i).getAvgRating(), i, i);
        }
        bst.inOrderRecur(bst.root);
        ArrayList<Integer> res = bst.getRetval();
        for (Integer re : res) {
            System.out.println(shoppingCart.get(re).toString());
        }
    }

}

class BST<Key1 extends Comparable<Key1> ,Key2 extends Comparable<Key2> , Value> {
    public class Node {
        private Key1 key1;
        private Key2 key2;
        private Value value;

        private Node left, right;

        private Node(Key1 key1, Key2 key2, Value value) {
            this.key1 = key1;
            this.key2 = key2;
            this.value = value;
            left = right = null;
        }
    }

    public Node root;
    private int count;

    private ArrayList<Value> retval = new ArrayList<>();

    public BST() {
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void inOrderRecur(Node root) {
        if (root == null) {
            return;
        }
        inOrderRecur(root.left);
        retval.add(root.value);
        inOrderRecur(root.right);
    }

    public ArrayList<Value> getRetval() {
        return retval;
    }

    public Node insert(Node node, Key1 key1, Key2 key2, Value value) {
        if (node == null) {
            count++;
            return new Node(key1, key2, value);
        }

        if (key1.compareTo(node.key1) == 0 && key2.compareTo(node.key2) == 0){
            node.value = value;
            return node;
        }

        if ((key1.compareTo(node.key1) < 0) || (key1.compareTo(node.key1) == 0 && key2.compareTo(node.key2) < 0)) {
            if (null == node.left) {
                node.left = new Node(key1, key2, value);
                count++;
                return node;
            }
            node.left = insert(node.left, key1, key2, value);
        }

        if ((key1.compareTo(node.key1) > 0) || (key1.compareTo(node.key1) == 0 && key2.compareTo(node.key2) > 0)) {
            if (null == node.right) {
                node.right = new Node(key1, key2, value);
                count++;
                return node;
            }
            node.right = insert(node.right, key1, key2, value);
        }

        return node;
    }
}
