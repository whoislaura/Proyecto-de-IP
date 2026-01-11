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
            System.out.print("Elige una opción(1-8): ");
            opcion = in.nextLine();
            System.out.println("---------------------------------");
            elegirOpcion(enteroValido(opcion));
        }while(!opcion.equals("8"));
    }

    private void mostrarMenu(){
        System.out.println("---------------------------------");
        System.out.println("1. Configurar clave Vigenère.");
        System.out.println("2. Cifrar texto (Sustitucion).");
        System.out.println("3. Descifrar texto (Sustitucion).");
        System.out.println("4. Cifrar texto (Vigenère).");
        System.out.println("5. Descifrar texto (Vigenère).");
        System.out.println("6. Mostrar mapa actual.");
        System.out.println("7. Mostrar clave actual.");
        System.out.println("8. Salir.");
    }

    private int enteroValido(String opcion){
        if(opcion == null || opcion.isEmpty()) return -1;
        for(char i = '1'; i<='8'; i++){
            if(opcion.charAt(0) == i) return Integer.parseInt(opcion);
        }

        return -1;
    }

    private void elegirOpcion(int opcion){
        switch(opcion){
            case 1 -> configClave();
            case 2 -> cifrarSust();
            case 3 -> descifrarSust();
            case 4 -> cifrarVig();
            case 5 -> descifrarVig();
            case 6 -> mostrarMapa();
            case 7 -> mostrarClave();
            case 8 -> System.out.println(">Saliendo...");
            default -> System.out.println(">Opción no válida. Intente de nuevo.");
        }
    }

    //metodos del menu
    private void configClave(){
        System.out.print(">Ingrese la clave Vigenère: ");
        String clave = in.nextLine().toUpperCase();
        config.setClaveVigenere(clave);
    }

    private void cifrarSust(){
        System.out.print(">Texto a cifrar: ");
        String texto = in.nextLine();
        System.out.println(">Texto cifrado: " + sust.cifrar(texto));
    }

    private void descifrarSust(){
        System.out.print(">Texto a descifrar: ");
        String texto = in.nextLine();
        System.out.println(">Texto descifrado: " + sust.descifrar(texto));
    }

    private void cifrarVig(){
        if(config.getClave() == null) {
            System.out.println(">ERROR. No se ha establecido una clave.");
            return;
        }
        System.out.print(">Texto a cifrar: ");
        String texto = in.nextLine();
        System.out.println(">Texto cifrado: " + vig.cifrar(texto));
    }

    private void descifrarVig(){
        if(config.getClave() == null) {
            System.out.println(">ERROR. No se ha establecido una clave.");
            return;
        }
        System.out.print(">Texto a descifrar: ");
        String texto = in.nextLine();
        System.out.println(">Texto descifrado: " + vig.descifrar(texto));
    }

    private void mostrarMapa(){
        System.out.println(">Mapa de letras mayusculas: " + config.getMapaMayusculas());
        System.out.println(">Mapa de letras minusculas " + config.getMapaMinusculas());
    }

    private void mostrarClave(){
        String clave = config.getClave();
        System.out.println(clave == null ? ">No se ha establecido una clave." : ">Clave Vigenère: " + clave);
    }
}
