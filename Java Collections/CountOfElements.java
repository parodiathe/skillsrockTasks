import java.util.HashMap;
import java.util.Map;

public class CountOfElements {

    public static Map<Object, Integer> countOfElements(Object[] array)throws Exception {
        if (array == null)
            throw new Exception("array is null");

        Map<Object, Integer> map = new HashMap<>();
        for (Object element : array) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }
        }
        return map;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Object[] elements = {2,4,6,8,2,4};

            Map<Object, Integer> result = CountOfElements.countOfElements(elements);

            for (Map.Entry<Object, Integer> entry : result.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
