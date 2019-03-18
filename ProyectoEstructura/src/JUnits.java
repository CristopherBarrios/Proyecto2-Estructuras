
//parser prueba
import static org.junit.Assert.*;
import org.junit.Test;

public class ParserTest {
// prueba si lo guardado en la lista es lo esperado con assertequals
	@Test
	public void testParse() {
		Parser tester = new Parser(); 
		String operacion = ("( + 2 1)");
		assertEquals("( + 2 1 )", operacion, tester);
	}

}
