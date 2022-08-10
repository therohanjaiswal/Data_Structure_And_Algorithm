// https://www.geeksforgeeks.org/hashset-in-java/

import java.util.*;

class HSet {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("gfg");
        set.add("courses");
        set.add("ide");
        System.out.println(set);
        System.out.println(set.contains("ide"));
        System.out.println(set.size());

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");

        System.out.println(set.remove("ide"));

        for (String string : set)
            System.out.print(string + " ");

        if (!set.isEmpty())
            System.out.println("Set is not empty");
    }
}
