public class CifradoSustitucion {
    Configuracion config;

    public CifradoSustitucion(Configuracion config) {
        this.config = config;
    }

    public String cifrar(String texto){
        String ans = "";
        for(int i = 0; i < texto.length(); i++){
            ans += cifrarChar(texto.charAt(i));
        }
        return ans;
    }

    public String descifrar(String texto){
        String ans = "";
        for(int i = 0; i < texto.length(); i++){
            ans += descifrarChar(texto.charAt(i));
        }
        return ans;
    }

    private char cifrarChar(char a){
        String letrasMayus = config.getLetrasMayusculas();
        String letrasMinus = config.getLetrasMinusculas();
        String mapaMayus = config.getMapaMayusculas();
        String mapaMinus = config.getMapaMinusculas();

        if(Character.isUpperCase(a)){
            int ind = buscarind(letrasMayus, a);
            return ind>=0 ? mapaMayus.charAt(ind) : a;
        }
        else if(Character.isLowerCase(a)){
            int ind = buscarind(letrasMinus, a);
            return ind>=0 ? mapaMinus.charAt(ind) : a;
        }
        else return a;
    }

    private char descifrarChar(char a){
        String letrasMayus = config.getLetrasMayusculas();
        String letrasMinus = config.getLetrasMinusculas();
        String mapaMayus = config.getMapaMayusculas();
        String mapaMinus = config.getMapaMinusculas();

        if(Character.isUpperCase(a)){
            int ind = buscarind(mapaMayus, a);
            return ind>=0 ? letrasMayus.charAt(ind) : a;
        }
        else if(Character.isLowerCase(a)){
            int ind = buscarind(mapaMinus, a);
            return ind>=0 ? letrasMinus.charAt(ind) : a;
        }
        else return a;
    }

    private int buscarind(String cad, char val){
        for(int i=0; i<cad.length(); i++){
            if(cad.charAt(i) == val) return i;
        }
        return -1;
    }
}
