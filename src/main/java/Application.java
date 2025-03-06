import list.SimpleArrayList;
import list.SimpleList;

public class Application {

    public static void main(String[] args) {
        final SimpleList<Double> doubleValues = new SimpleArrayList<Double>(-0.1, 0.5, 0.7);
        final SimpleList<Integer> intValues = new SimpleArrayList<Integer>(-10, 1, 2);

        final SimpleList<Double> filteredDoubleValues = SimpleList.filterNegative(doubleValues);
        final SimpleList<Integer> filteredIntValues = SimpleList.filterNegative(intValues);
        System.out.println("filteredDoubleValues = " + filteredDoubleValues);
        System.out.println("filteredIntValues = " + filteredIntValues);
    }
}
