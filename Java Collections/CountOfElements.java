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
