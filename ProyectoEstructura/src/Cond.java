import java.util.HashMap;
public class Cond {
    private boolean verifica= false;
    private boolean error = false;

    HashMap Variables = new HashMap();

    String PrimCond= "", SegCond="", Compa= "";

    private boolean Buscar(String enc) {
        char[] sentencia = enc.toCharArray();
        String condicion = "";
        int pa = 0, pc = 0;
        boolean b = false;
        for (int x = 0; x < sentencia.length; x++) {
            String aux = Character.toString(sentencia[x]);
            if ((aux.equals("(")) || (aux.equals(")"))) {
                if (aux.equals("("))
                    pa++;
                if (aux.equals(")"))
                    pc++;
            } else
                condicion = condicion + aux;
        }
        if (pa == pc)
            verifica = this.Check(condicion);
        else
            this.verifica = false;
        b = this.verifica;
        return b;
    }


    private boolean Check(String condicion){
        boolean verifica= true;
        SegCond=this.segundaCondicion(condicion, true);
        if(PrimCond.equals("") && SegCond.equals("")  && (Compa.equals("")))
            verifica=false;
        return verifica;
    }

    public void tablavalores(HashMap mapa){
        Variables = mapa;
        if(this.Variables.containsKey(this.PrimCond))
            this.PrimCond = (String)this.Variables.get(this.PrimCond);
        if(this.Variables.containsKey(this.SegCond))
            this.SegCond = (String) this.Variables.get(this.SegCond);

        this.analiza();
    }
    private void analiza(){
        try{
            int num=Integer.parseInt(this.PrimCond);
            int d = Integer.parseInt(this.SegCond);
            if(this.Compa.equals(">")){
                if(num>d)
                    verifica= true;
                else
                    verifica= false;
            }if(this.Compa.equals("<")){
                if(num<d)
                    verifica= true;
                else
                    verifica= false;
            }if(this.Compa.equals("=")){
                if(num==d)
                    verifica= true;
                else
                    verifica= false;
            }
        }catch(NumberFormatException ex){
            error= true;
        }
    }
    private String segundaCondicion(String condicional, boolean numero){
        char [] sentencia = condicional.toCharArray();
        String condicionS = "";
        String primeracondicion = "";
        boolean bandera= false;
        for(int x=0; x<sentencia.length;x++){
            String aux =Character.toString(sentencia[x]);
            if((aux.equals(">")) || (aux.equals("<")) || (aux.equals("="))){
                bandera=true;
                this.Compa = aux;
            } else{
                if(bandera)
                    condicionS = condicionS+ aux;
                else
                    primeracondicion= primeracondicion + aux;
            }

        }
        if(numero)
            this.PrimCond= primeracondicion;
        return condicionS;
    }

    private int Buscar(String Pal ,String Parrafo){
        if (!(Parrafo.compareTo("")==0) && (!(Pal.compareTo("")==0))){
            int Ocurrencias=0;
            for(int i=0;i<(Parrafo.length()-Pal.length());i++){
                if(Parrafo.substring(i,(i+Pal.length())).compareTo(Pal)==0){
                    Ocurrencias++;
                }
            }
            return Ocurrencias;
        }
        return 0;
    }
}
