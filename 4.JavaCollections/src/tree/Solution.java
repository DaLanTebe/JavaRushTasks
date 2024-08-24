package tree;

import java.util.List;
import java.util.TreeMap;

public class Solution {

        public static void main(String[] args) {
            List<String> list = new CustomTree();

            for (int i = 1; i < 16; i++) {
                list.add(String.valueOf(i));
            }

            System.out.println("The list size is " + list.size());
            System.out.println("The expected parent is 3. The actual parent is " + ((CustomTree) list).getParent("8"));
            System.out.println("The expected parent is null. The actual parent is " + ((CustomTree) list).getParent("20"));
        }
}
