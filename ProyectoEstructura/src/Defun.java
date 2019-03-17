
import java.io.*;
import java.util.*;

class Defun {

    protected String nombre;
    protected Vector <String> formales;
    protected TreeNode cuerpo;

    /**
     * función: Defun: usuario defina funciones
     *
     * Constructor: Defun(String n, TreeNode f, TreeNode b)
     *
     * esta funcion crea una función creada por el usuario con nombre, lista de paramtros formales y cuerpo
     *
     * @todo: deja que cuerpo no sea lista
     *
     * @param n el nombre de la  funcion
     * @param f la list de formales - puede ser()
     * @param b el cuerpo de la funcion
     *
     * @throws Excepcion si parametros no estan correctos
     *
     */
    public Defun(String n, TreeNode f, TreeNode b) throws excepcion{
        nombre = n;
        if ( (!f.isList() && !f.toString().matches("NIL") ) || ( !b.isList() && !b.toString().matches("NIL") ) ){
            throw new excepcion("funcion de parametros invalidos o cuerpo.\n" + f.toString() + "\n" + b.toString());
        }

        String formalesstring = f.toString();
        formales = splitParamList(formalesstring);
        cuerpo = b;
    }

