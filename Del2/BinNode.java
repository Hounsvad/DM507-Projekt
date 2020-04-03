public class BinNode{
    public BinNode leftLeg = null;
    public BinNode rightLeg = null;
    public int k;

    BinNode(int k, BinNode leftLeg, BinNode rightLeg){
        this.k = k;
        this.leftLeg = leftLeg;
        this.rightLeg = rightLeg;
    }
}