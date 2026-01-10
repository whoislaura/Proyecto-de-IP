public class CifradoVigenere {
    Configuracion config;

    public CifradoVigenere(Configuracion config) {
        this.config = config;
    }

    public String cifrar(String texto){
        String ans = "";
        for(int i = 0; i < texto.length(); i++){
            ans += cifrarChar(texto.charAt(i), i);
        }
        return ans;
    }

    public String descifrar(String texto){
        String ans = "";
        for(int i = 0; i < texto.length(); i++){
            ans += descifrarChar(texto.charAt(i), i);
        }
        return ans;
    }

    private char cifrarChar(char a, int it){
        String letrasMayus = config.getLetrasMayusculas();
        String letrasMinus = config.getLetrasMinusculas();
        String clave = config.getClave();
        int len = it%clave.length();

        if(Character.isUpperCase(a)){
            int ind = buscarind(letrasMayus, a);
            int ind2 = buscarind(letrasMayus, clave.charAt(len));
            return ind>=0 &&ind2>=0 ? letrasMayus.charAt((ind+ind2)%letrasMayus.length()) : a;
        }
        else if(Character.isLowerCase(a)){
            int ind = buscarind(letrasMinus, a);
            int ind2 = buscarind(letrasMayus, clave.charAt(len));
            return ind>=0 && ind2>=0 ? letrasMinus.charAt((ind+ind2)%letrasMinus.length()) : a;
        }
        else return a;
    }

    private char descifrarChar(char a, int it){
        String letrasMayus = config.getLetrasMayusculas();
        String letrasMinus = config.getLetrasMinusculas();
        String clave = config.getClave();
        int len = it%clave.length();

        if(Character.isUpperCase(a)){
            int ind = buscarind(letrasMayus, a);
            int ind2 = buscarind(letrasMayus, clave.charAt(len));
            return ind>=0 && ind2>=0 ? (ind>ind2 ? letrasMayus.charAt((ind-ind2)%letrasMayus.length()) : letrasMayus.charAt(((ind+27)-ind2)%letrasMayus.length())) : a;
        }
        else if(Character.isLowerCase(a)){
            int ind = buscarind(letrasMinus, a);
            int ind2 = buscarind(letrasMayus, clave.charAt(len));
            return ind>=0 && ind2>=0 ? (ind>ind2 ? letrasMinus.charAt((ind-ind2)%letrasMinus.length()) : letrasMinus.charAt(((ind+27)-ind2)%letrasMinus.length())) : a;
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

