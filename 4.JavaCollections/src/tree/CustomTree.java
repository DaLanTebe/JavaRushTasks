package tree;

import java.io.Serializable;
import java.util.*;


public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    private Entry<String> root;
    private int size = 0;

    public CustomTree() {
        root = new Entry<>("1");
        size();
    }
    public CustomTree(Entry<String> root) {
            this.root = root;
            size();
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
                size();
                return true;
            } else if (stringEntry.availableToAddRightChildren) {
                entries.clear();
                stringEntry.rightChild = new Entry<>(s);
                stringEntry.rightChild.parent = stringEntry;
                stringEntry.availableToAddRightChildren = false;
                size();
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
        size = 0;
        ArrayDeque<Entry<String>> entries = new ArrayDeque<>();
        Entry<String> stringEntry;
        entries.add(root);

        while (!entries.isEmpty()){
            stringEntry = entries.poll();
            if (!stringEntry.availableToAddLeftChildren){
                size++;
                entries.add(stringEntry.leftChild);
            }
            if (!stringEntry.availableToAddRightChildren){
                size++;
                entries.add(stringEntry.rightChild);
            }
        }
        return size;
    }

    @Override
    public boolean remove(Object o){
        String str;
        try {
            str = (String) o;
        }catch (ClassCastException e){
            throw new UnsupportedOperationException();
        }
        
    }

    public String set(int index, String element){
        throw new UnsupportedOperationException();
    }

    public void add(int index, String element){

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
        LinkedList<Entry<String>> strings = new LinkedList<>();

        strings.add(root);
        Entry<String> entry;
        while (!strings.isEmpty()){
            entry = strings.poll();
            if (entry.elementName.equals(number) && entry.parent != null){
                return entry.parent.elementName;
            }
            if (!entry.availableToAddLeftChildren){
                strings.add(entry.leftChild);
            }
            if (!entry.availableToAddRightChildren){
                strings.add(entry.rightChild);
            }
         }
        return null;
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
