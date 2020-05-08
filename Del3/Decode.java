import java.io.*;
import java.util.Arrays;

public class Decode {
    public static final int n = 256;

    public Decode(String inputFileName, String outputFileName){
        try(BitInputStream in = new BitInputStream(new FileInputStream(inputFileName)); OutputStream out = new FileOutputStream(outputFileName)){
            int[] characterFrequency = readCharacterFrequency(in);
            int frequencySum = Arrays.stream(characterFrequency).sum();
            BinNode root = HoffmanTree.HoffmanTreeFactory(characterFrequency).rootNode;

            int bit;
            BinNode currentNode = root;
            while ((bit = in.readBit()) != -1){
                if (bit == 0){
                    currentNode = currentNode.leftLeg;
                } else {
                    currentNode = currentNode.rightLeg;
                }

                if (currentNode.leftLeg == null){
                    out.write(currentNode.k); //TODO Possibly writes 32-bit
                    currentNode = root;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int[] readCharacterFrequency(BitInputStream in) throws IOException {
        int[] freq = new int[n];
        for(int i = 0; i < n; i++){
            freq[i] = in.readInt();
        }
        return freq;
    }

    public static void main(String[] args){
        new Decode(args[0], args[1]);
    }
}
