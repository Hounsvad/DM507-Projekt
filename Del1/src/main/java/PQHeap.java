import java.util.ArrayList;
import java.util.List;

public class PQHeap implements PQ{
    private List<Element> elements = new ArrayList<>();
    public PQHeap() {
    }

    @Override
    public Element extractMin() {
        Element root = elements.get(0);
        if(elements.size()>1){
            Element left = elements.get(1);
            if(elements.size()>2){
                Element right = elements.get(2);
                if(left.getKey() < root.getKey() || right.getKey() < root.getKey() ){
                    if(left.getKey()<right.getKey()){
                        elements.set(0, left);
                    }else{
                        elements.set(0, right);
                    }
                }
            }else{
                if(left.getKey()<root.getKey()){
                    elements.set(0, left);
                }
            }
        }




        Element smallestElement = elements.get(0);
        elements.remove(0);
        return smallestElement;
    }

    @Override
    public void insert(Element e) {
        elements.add(e);
        int i = elements.size()-1;
        while (i > 0 && elements.get(parent(i)).getKey() > e.getKey()){
            Element parent = elements.get(parent(i));
            Element child = elements.get(i);
            elements.set(parent(i), child);
            elements.set(i, parent);
            i = parent(i);
        }
    }

    private int leftChild(int i){
        return 2*i+1;
    }

    private int rightChild(int i){
        return 2*i+2;
    }

    private int parent(int i){
        return (i - 1) / 2;
    }
}
