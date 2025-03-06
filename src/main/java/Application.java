import list.SimpleArrayList;
import list.SimpleList;

public class Application {

    public static void main(String[] args) {
        final String[] arrays = {"first", "second"};

        SimpleList<String> values = SimpleArrayList.fromArrayToList(arrays);
    }
}
