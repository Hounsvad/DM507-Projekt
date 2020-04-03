import java.util.ArrayList;
import java.util.List;

public class DictBinTree implements Dict {

    public BinNode rootNode = null;

    DictBinTree() {

    }

    // Skal bruge binært søgetræ
    public void insert(int k) {
        // indsætter nøglen k i træet
        BinNode z = new BinNode(k, null, null);
        BinNode y = null;
        BinNode x = rootNode;
        while (x != null) {
            y = x;
            x = z.k < x.k ? x.leftLeg : x.rightLeg;
        }
        if (y == null) {
            rootNode = z;
        } else if (z.k < y.k) {
            y.leftLeg = z;
        } else {
            y.rightLeg = z;
        }

    }

    public ArrayList<Integer> orderedTraversal() {
        ArrayList<Integer> returnList = new ArrayList<>();
        orderedTraversalRecursive(returnList, rootNode);
        return returnList;
    }
    private void orderedTraversalRecursive(List<Integer> returnList, BinNode x) {
        if(x != null){
            orderedTraversalRecursive(returnList, x.leftLeg);
            returnList.add(x.k);
            orderedTraversalRecursive(returnList, x.rightLeg);
        }
    }

    public boolean search(int k) {
        return searchRecursive(k, rootNode);
    }

    private boolean searchRecursive(int k, BinNode x) {
        if (x == null)
            return false;
        if (x.k == k)
            return true;
        if (k < x.k)
            return searchRecursive(k, x.leftLeg);
        else
            return searchRecursive(k, x.rightLeg);
    }

}
