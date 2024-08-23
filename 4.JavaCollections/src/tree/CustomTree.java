package tree;

import javax.management.Query;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;


public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;

    public CustomTree(Entry<String> root) {
        this.root = root;
    }

    @Override
    public boolean add(String s) {
        ArrayDeque<Entry<String>> entries = new ArrayDeque<>();
        Entry<String> stringEntry;
        entries.add(root);
        while (!entries.isEmpty()){
            stringEntry = entries.poll();
            if (stringEntry.availableToAddLeftChildren){
                entries.clear();
                stringEntry.leftChild = new Entry<>(s);
                stringEntry.leftChild.parent = stringEntry;
                stringEntry.availableToAddLeftChildren = false;
                return true;
            } else if (stringEntry.availableToAddRightChildren) {
                entries.clear();
                stringEntry.rightChild = new Entry<>(s);
                stringEntry.rightChild.parent = stringEntry;
                stringEntry.availableToAddRightChildren = false;
                return true;
            } else {
                entries.add(stringEntry.leftChild);
                entries.add(stringEntry.rightChild);
            }

        }
        return false;
    }


    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        int size = 1;

        if (!root.availableToAddLeftChildren){
            size += new CustomTree(root.leftChild).size();
        }
        if (!root.availableToAddRightChildren){
            size += new CustomTree(root.rightChild).size();
        }
        return size;
    }

    public String set(int index, String element){
        throw new UnsupportedOperationException();
    }
    public void add(int index, String element){

        throw new UnsupportedOperationException();
    }
    public String remove(int index){
        throw new UnsupportedOperationException();
    }
    public List<String> subList(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }
    protected void removeRange(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }
    public boolean addAll(int index, Collection<? extends String> c){
        throw new UnsupportedOperationException();
    }

    public String getParent(String number) {
         String name = null;
        if (root.elementName.equals(number)){
            return root.parent.elementName;
        }
        if (!root.availableToAddLeftChildren){
            name = new CustomTree(root.leftChild).getParent(number);
        }
        if (!root.availableToAddRightChildren){
            name = new CustomTree(root.rightChild).getParent(number);
        }
        return name;
    }

    static class Entry<T> implements Serializable {
        public String elementName;
        public boolean availableToAddLeftChildren = true;
        public boolean availableToAddRightChildren = true;
        public Entry<T> parent;
        public Entry<T> leftChild;
        public Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
        }
        public boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
