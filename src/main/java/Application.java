import list.SimpleArrayList;
import list.SimpleList;

public class Application {

    public static void main(String[] args) {
        class Printer { }
        class LaserPrinter extends Printer { }

        final var laserPrinter = new LaserPrinter();

        final SimpleList<Printer> printers = new SimpleArrayList<Printer>();
        final SimpleList<LaserPrinter> laserPrinters = new SimpleArrayList<LaserPrinter>(laserPrinter);

        SimpleList.copy(laserPrinters, printers);

        System.out.println(printers.get(0) == laserPrinter);
    }
}
