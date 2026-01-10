import java.util.Scanner;

public class Controlador {
    Scanner in = new Scanner(System.in);
    Configuracion config = new Configuracion();
    CifradoSustitucion sust = new CifradoSustitucion(config);
    CifradoVigenere vig = new CifradoVigenere(config);

    public void iniciar(){
        String opcion = "";

        do{
            mostrarMenu();
            opcion = in.nextLine();
            elegirOpcion(enteroValido(opcion));
        }while(!opcion.equals("8"));
    }

    private void mostrarMenu(){
        System.out.println("1. Configurar clave Vigenere.");
        System.out.println("2. Cifrar texto (Sustitucion).");
        System.out.println("3. Descifrar texto (Sustitucion).");
        System.out.println("4. Cifrar texto (Vigenere).");
        System.out.println("5. Descifrar texto (Vigenere).");
        System.out.println("6. Mostrar mapa actual.");
        System.out.println("7. Mostrar clave actual.");
        System.out.println("8. Salir.");
    }

    private int enteroValido(String opcion){
        //validar el entero

        return Integer.parseInt(opcion);
    }

    private void elegirOpcion(int opcion){
        switch(opcion){
            case 1 -> configClave();
            case 2 -> cifrarSust();
            case 3 -> descifrarSust();
            //case 4 -> cifrarVig();
            //case 5 -> descifrarVig();
            case 6 -> mostrarMapa();
            case 7 -> mostrarClave();
            case 8 -> System.out.println("saliendo...");
            default -> System.out.println("opcion invalida");
        }
    }

    private void configClave(){
        System.out.print("Ingrese la clave Vigenere: ");
        String clave = in.nextLine().trim().toUpperCase();
        config.setClaveVigenere(clave);
    }

    private void cifrarSust(){
        System.out.print("Texto a cifrar: ");
        String texto = in.nextLine();
        System.out.println("Texto cifrado: " + sust.cifrar(texto));
    }

    private void descifrarSust(){
        System.out.print("Texto a descifrar: ");
        String texto = in.nextLine();
        System.out.println("Texto descifrado: " + sust.descifrar(texto));
    }

    private void mostrarMapa(){
        System.out.println("Mapa de letras mayusculas: " + config.getMapaMayusculas());
        System.out.println("Mapa de letras minusculas " + config.getMapaMinusculas());
    }

    private void mostrarClave(){
        System.out.println("Clave Vigenere: " + config.getClave());
    }
}
