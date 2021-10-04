package Taski;

import java.util.HashSet;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("marty", "stepp");
//        map.put("stuart", "reges");
//        map.put("jessica", "miller");
//        map.put("amanda", "camp");
//        map.put("hal", "perkins");
        Map<String, String> map1 = Map.of(
                "marty", "stepp",
                "stuart", "reges",
                "jessica", "miller",
                "amanda", "camp",
                "hal", "perkins"
        );
        System.out.println(isUnique(map1));
    }

    public static boolean isUnique(Map<String, String> map) {
        return map.size() == new HashSet<>(map.values()).size();
    }
}
