public class Configuracion{
    private static final String letrasMayusculas = "ABCDEFGHIJKLMÑNOPQRSTUVWXYZ";
    private static final String letrasMinusculas = "abcdefghijklmñnopqrstuvwxyz";
    private static final String mapaMinusculas = "efghijklmñnopqrstuvwxyzabcd";
    private static final String mapaMayusculas = "EFGHIJKLMÑNOPQRSTUVWXYZABCD";
    private String claveVigenere;

    public void setClaveVigenere(String clave){
        for(var it : clave.toCharArray()){
            char a = it;
            if((a>='A' && a<='Z') || a=='Ñ') continue;
            else{
                System.out.println("ERROR. Clave invalida.");
                return;
            }
        }

        System.out.println("Clave establecida: " + clave);
    }

    //getters
    public String getLetrasMayusculas(){ return letrasMayusculas; }
    public String getLetrasMinusculas(){ return letrasMinusculas; }
    public String getMapaMayusculas(){ return mapaMayusculas; }
    public String getMapaMinusculas(){ return mapaMinusculas; }
    public String getClave(){ return claveVigenere; }

}
