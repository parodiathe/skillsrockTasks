import java.lang.reflect.Array;

class FilterMethod {

    public static <T> T[] filter(T[] array, Filter<T> filter) {

        T[] result = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);

        for (int i = 0; i < array.length; i++) {
            result[i] = filter.apply(array[i]);
        }

        return result;
    }

    public interface Filter<T> {
        T apply(T o);
    }
}

public class Main {
    public static void main(String[] args) {
        String[] input = {"fdsfdsf", "fdsfsdfsdf", "dsdsadsad, dsadsad, dsadasda","dsdasdad"};

        String[] output = FilterMethod.filter(input, s -> s.toUpperCase());

        for (String s : output) {
            System.out.println(s);
        }
    }
}
