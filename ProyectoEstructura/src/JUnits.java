
//parser prueba
import static org.junit.Assert.*;
import org.junit.Test;

public class ParserTest {

	@Test
	public void testParse() {
		Parser tester = new Parser(); 
		String operacion = ("( + 2 1)");
		assertEquals("( + 2 1 )", operacion, tester);
	}

}

// prueba interprete

class InterpreteTest {

	@Test
	void testInterpret() {
		 Interprete InterPrueba = new Interprete();
		 String instruccion = "( + 2 1 )";
		 Parser myParser = new Parser();
	     InterPrueba.interpret(myParser.parse(instruccion));
	     assertEquals("",instruccion, 3);
	        }
		
	

	}
