import java.util.*;

class HMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("gfg", 10);
        map.put("courses", 15);
        map.put("ide", 20);
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.containsKey("gfg"));

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        Integer val = map.remove("ide");
        System.out.println(val);

        if (map.containsValue(15))
            System.out.println("Yes");
        else
            System.out.println("No");

        System.out.println(map.get("gfg"));

    }
}
