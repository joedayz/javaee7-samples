package pe.joedayz.javaee7.cdi.ejemplo16;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class GeneradorNumero16Test {

    // ======================================
    // =             Attributes             =
    // ======================================

    protected static Weld weld;
    protected static WeldContainer container;

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @BeforeClass
    public static void init() {
        weld = new Weld();
        container = weld.initialize();
    }

    @AfterClass
    public static void close() {
        weld.shutdown();
    }

    // ======================================
    // =              Methods               =
    // ======================================

    @Test
    public void shouldCheckNumberIsThirteenDigits() {
        LibroService16 bookService = container.instance().select(LibroService16.class).get();
        Libro16 book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
        System.out.println("########### " + book.getIsbn());
        assertTrue(book.getIsbn().startsWith("13"));
    }
}