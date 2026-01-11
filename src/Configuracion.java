public class Configuracion{
    private static final String letrasMayusculas = "AÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚÜVWXYZ";
    private static final String letrasMinusculas = "aábcdeéfghiíjklmnñoópqrstuúüvwxyz";
    private static final String mapaMinusculas = "eéfghiíjklmnñoópqrstuúüvwxyzaábcd";
    private static final String mapaMayusculas = "EÉFGHIÍJKLMNÑOÓPQRSTUÚÜVWXYZAÁBCD";
    private String claveVigenere;

    public void setClaveVigenere(String clave){
        if(clave.isEmpty()){
            System.out.println(">ERROR. Clave no válida. Intente de nuevo.");
            return;
        }
        for(var it : clave.toCharArray()){
            char a = it;
            if((a>='A' && a<='Z') || a=='Ñ' || a=='Á' || a=='É' || a=='Í' || a=='Ó' || a=='Ú' || a=='Ü') continue;
            else{
                System.out.println(">ERROR. Clave no válida. Intente de nuevo.");
                return;
            }
        }
        claveVigenere = clave;
        System.out.println(">Clave establecida: " + claveVigenere);
    }

    //getters
    public String getLetrasMayusculas(){ return letrasMayusculas; }
    public String getLetrasMinusculas(){ return letrasMinusculas; }
    public String getMapaMayusculas(){ return mapaMayusculas; }
    public String getMapaMinusculas(){ return mapaMinusculas; }
    public String getClave(){ return claveVigenere; }

}
