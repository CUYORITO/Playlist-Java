import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Clase_13_08_2023{

    public static ArrayList <ArrayList<String>> arrays = new ArrayList <>();
    String playlist = "";

    public String crear (String titulo){
        return JOptionPane.showInputDialog(titulo);
    }

    public void cventana (Object titulo){
        JOptionPane.showMessageDialog(null, titulo);
    }

    public boolean repetir (String cuerpo, String titulo){
        return (JOptionPane.showConfirmDialog(null, cuerpo, titulo, 0, JOptionPane.YES_NO_OPTION) == 0);
    }

    public int posicion (String texto){
        int indice = 0;
        for(int i = 0; i < arrays.size() ; i++){
            if(texto.equals(arrays.get(i).get(0))){
                indice = i;
                break;
            }
        }
        return indice;
    }

    public String ordenado (){
        String aux = "";
        for(int i = 0; i < arrays.size() ; i++){
            aux += ((i+1) + (arrays.get(i).get(0)) + "\n");
        }
        return aux;
    }

    public String ordenadoCanciones(){
        String aux = "";
        int numeros = 1;
        Collections.sort(arrays.get(posicion(playlist)));

        System.out.println(arrays);

        for(int i = 1; true ; i++){
            try{
                if((arrays.get(posicion(playlist)).get(i)).equals(playlist)){
                }else{
                    aux += ((numeros + ") ") + (arrays.get(posicion(playlist)).get(i)) + "\n");
                    numeros++;
                }
            }catch(Exception e){

                break;
            }
        }        
        return aux;
    }

    public boolean buscar(String valor){

        boolean esta = false;
        for(int i = 0; i < arrays.size() ; i++){
            if(valor.equals(arrays.get(i).get(0))){
                esta = true;
            }
        } 
        return esta;
    }   

    public void editarPlaylist(){
        
        if(arrays.isEmpty()){
            cventana("No tienes playlist.");
        }else{
            try{
                playlist = ") " + (crear("Elige tu playlist \n" + ordenado()));    
                if(buscar(playlist)){
                    menuCanciones(ventanaMenu());
                }else{
                    cventana("No existe la playlist");
                }
            }catch (Exception e){
                    menuPlaylist(ventanaPlaylist());    
            }
        }
    }

    public String ventanaPlaylist(){

        return (JOptionPane.showInputDialog(null, 
        "¿Que deseas hacer?" + 
        "\n 1) Crear playlist " + 
        "\n 2) Mis playlist " +
        "\n 3) Editar playlist" +
        "\n 4) Eliminar playlist" +
        "\n 5) Salir",
        "Menu",
        1)).toLowerCase();
    }

    public void crearPlaylist (){

        ArrayList <String> interno = new ArrayList<>();
        interno.add(") " + crear("Nombre de playlis:"));
        arrays.add(interno);
    }

    public void mostrarPlaylist(){

        if(arrays.isEmpty()){
            cventana("No tienes playlist creadas");
        }else{ 
            cventana(ordenado());
        }
    }

    public void eliminarPlaylist(){

        if(arrays.isEmpty()){
            cventana("No tienes playlist");
         }else{
            
            if(repetir("¿Seguro deseas eliminar una playlist?", "Advertencia")){

                String list = crear("¿Que playlist vas a eliminar? \n" + ordenado());

                if(buscar(list)){
                    
                    arrays.remove(posicion(list));
                    cventana("Se ha borrado tu playlist");
                }else{
                    cventana("La playlist no existe");
                }
            }
        }
    }

    public void menuPlaylist(String respuesta){

        if(respuesta.equals("1") || respuesta.equals("crear playlist")){
            crearPlaylist();
        }else if(respuesta.equals("2") || respuesta.equals("mis playlist")){
            mostrarPlaylist();
        }else if(respuesta.equals("3") || respuesta.equals("editar playlist")){
            editarPlaylist();
        }else if (respuesta.equals("4") || respuesta.equals("eliminar playlist")){
            eliminarPlaylist();
        }else if(respuesta.equals("5") || respuesta.equals("salir")){
            System.exit(0);
        }else{
            JOptionPane.showMessageDialog(null, "Escribe bien");
        }

    }

   public String ventanaMenu(){
        return (JOptionPane.showInputDialog(null, 
        "¿Que deseas hacer?" + 
        "\n 1) Agregar canciones " + 
        "\n 2) Modificar canciones " + 
        "\n 3) Mostrar canciones" +
        "\n 4) Eliminar cancion " +
        "\n 5) Limpiar playlis " + 
        "\n 6) Atras" + 
        "\n 7) Salir",
        "Menu de playlist",
        1)).toLowerCase();
    }

    public void agregarCancion(){
        int aumentado = 1;
        arrays.get(posicion(playlist)).add(aumentado, "nulo");
        arrays.get(posicion(playlist)).set(aumentado, crear("¿Que cancion guardaras?"));
        aumentado++;
        menuCanciones(ventanaMenu());
        
    }

    public void modificarCancion() {
        try{
            if(arrays.get(posicion(playlist)).get(1).isEmpty()){
            }else{
                int cancion = (Integer.parseInt(crear("¿Que cancion deseas modificar? \n" + ordenadoCanciones())));
                arrays.get(posicion(playlist)).set(cancion, crear("Escribe tu modificacion:"));
                menuCanciones(ventanaMenu());
            }
        }catch (Exception e){
            cventana("Playlist vacia");
            menuCanciones(ventanaMenu());
        }
    }

    public void mostrarCanciones(){
        
        try{
            if(arrays.get(posicion(playlist)).get(1).isEmpty()){
            }else{
                cventana("Las canciones de tu playlist \"" + (playlist.replace("- ", "")) + "\" son: \n" + ordenadoCanciones());
                menuCanciones(ventanaMenu());
            }
        }catch (Exception e){
            cventana("Playlist vacia");
            menuCanciones(ventanaMenu());
        }
    }

    public void eliminarCanciones(){

        try{
            if(arrays.get(posicion(playlist)).get(1).isEmpty()){
            }else{
                try{
                    int cancion = (Integer.parseInt(crear("¿Que cancion deseas eliminar? \n" + ordenadoCanciones())));
                    arrays.get(posicion(playlist)).remove(cancion);
                    cventana("Se ah eliminado tu cancion");
                }catch (Exception e){
                    cventana("No existe la cancion");
                }
                menuCanciones(ventanaMenu());
            }
        }catch (Exception e ){
            cventana("Playlist vacia");
            menuCanciones(ventanaMenu());
        }
    }

    public void limpiarCanciones(){  

        for(int i = 1; i < (arrays.get(posicion(playlist)).size()) ; i++){
            arrays.get(posicion(playlist)).remove(i);
        }
        cventana("Playlist vacia");
        menuCanciones(ventanaMenu());
    }

    public void atras(){
        menuPlaylist(ventanaPlaylist());
    }

    public void menuCanciones (String valor){
        if(valor.equals("1") || valor.equals("agregar canciones")){
            agregarCancion();
        }else if(valor.equals("2") || valor.equals("modificar canciones")){
                modificarCancion();
        }else if (valor.equals("3") || valor.equals("mostrar canciones")){
            mostrarCanciones();
        }else if(valor.equals("4") || valor.equals("eliminar cancion")){
            eliminarCanciones();
        }else if(valor.equals("5") || valor.equals("limpiar playlist")){
            limpiarCanciones();
        }else if(valor.equals("6") || valor.equals("atras")){
            atras();
        }else if(valor.equals("7") || valor.equals("salir")){
            System.exit(0);
        }else{
            JOptionPane.showMessageDialog(null, "Mamo, Escribe bien");
        }
    }
    public static void main(String[] args) {

        Clase_13_08_2023 clase = new Clase_13_08_2023();

        do{
            clase.menuPlaylist(clase.ventanaPlaylist());
        }while(true);
    }
}