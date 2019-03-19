import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Prueba unitarias de partes fundamentales del interprete
 */
public class JUnits {
    /**
     * Prueba parser
     */
	@Test
	public void testParse() {
		Parser tester = new Parser(); 
		String operacion = "( + 2 1 )";
		String[] testlist = tester.parse(operacion);
		String[] resut = new String[]{"(", "+", "2", "1", ")",};
        assertArrayEquals(testlist, resut);
	}
    /**
     * Prueba operaciones aritemticas sencillas
     */
    @Test
    public void testAritmetica() {
        Interprete tester = new Interprete();
        String[] resut = new String[]{"(", "+", "2", "1", ")",};
        String arit = tester.interpret(resut);
        assertEquals("3.0", arit);
    }
    /**
     * Prueba operaciones aritemticas complejas
     */
    @Test
    public void testAritmetica2() {
        Interprete tester = new Interprete();
        String[] resut = new String[]{"(","*","2","(","+","1","2",")",")"};
        String arit = tester.interpret(resut);
        assertEquals("6.0", arit);
    }
    /**
     * Definicion y uso de funciones
     */
    @Test
    public void testDefun() {
        Interprete tester = new Interprete();
        String[] funcion = new String[]{"(","DEFUN","suma","(","a","b",")","(","+","a","b",")",")"};
        tester.interpret(funcion);
        String[] test = new String[]{"(","suma","(","1","2",")",")"};
        String fun = tester.interpret(test);
        assertEquals("3.0", fun);
    }
}
