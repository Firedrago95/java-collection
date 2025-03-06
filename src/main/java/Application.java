import list.SimpleArrayList;
import list.SimpleList;

public class Application {

    public static void main(String[] args) {
        final SimpleList<Double> doubleValues = new SimpleArrayList<Double>(0.5, 0.7);
        final SimpleList<Integer> intValues = new SimpleArrayList<Integer>(1, 2);

        double sumDouble = SimpleList.sum(doubleValues);
        double sumInt = SimpleList.sum(intValues);
        System.out.println("sumDouble = " + sumDouble);
        System.out.println("sumInt = " + sumInt);
    }
}
