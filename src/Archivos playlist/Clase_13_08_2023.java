import java.util.ArrayList;

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
            aux += (((i+1) + ")") + (arrays.get(i).get(0)) + "\n");
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
            playlist = crear("Elige tu playlist \n" + ordenado());    
            if(buscar(playlist)){
                ventanaMenu();
            }else{
                cventana("No existe la playlist");
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
        interno.add(crear("Nombre de playlis:"));
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
                    cventana("Se ha borrado tu cancion");
                }else{
                    cventana("La cancion no existe");
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
        "\n 6) Atras",
        "Menu de playlist",
        1)).toLowerCase();
    }

    public void agregar(){
        int aumentado = 1;
        arrays.get(posicion(playlist)).add(aumentado, "nulo");
        arrays.get(posicion(playlist)).set(aumentado, crear("¿Que cancion guardaras?"));
        aumentado++;
    }

    public static void main(String[] args) {

        Clase_13_08_2023 clase = new Clase_13_08_2023();
        
        
        
    }

}