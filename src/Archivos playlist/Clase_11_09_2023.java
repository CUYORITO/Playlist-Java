import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Clase_11_09_2023{

    ArrayList <String> playlist = new ArrayList<String>();

    public String crear (String titulo){
        return JOptionPane.showInputDialog(titulo);
    }
    
    public void cventana (String titulo){
        JOptionPane.showMessageDialog(null, titulo);
    }

    public boolean repetir (String cuerpo, String titulo){
        return (JOptionPane.showConfirmDialog(null, cuerpo, titulo, 0, JOptionPane.YES_NO_OPTION) == 0);
    }
    
    public String ordenado (){
        String aux = "";
        Collections.sort(playlist);
            for(int i = 0; i < playlist.size(); i++){
                aux += playlist.get(i) + "\n";
            }
            return aux;
    }
    
    public String ventana(){
        return (JOptionPane.showInputDialog(null, 
        "¿Que deseas hacer?" + 
        "\n 1) Agregar canciones " + 
        "\n 2) Modificar canciones " + 
        "\n 3) Mostrar canciones" +
        "\n 4) Eliminar cancion " +
        "\n 5) Limpiar playlis " + 
        "\n 6) Salir",
         "Menu",
         1)).toLowerCase();
    }

    public void agregar (){
        playlist.add(crear("¿Que cancion deseas agregar?"));
        cventana("Se ah guardado tu cancion");
    }

    public void modificar (){
        
        if(playlist.isEmpty()){
                cventana("No hay canciones disponibles");
            }else{

            String cancion = crear("¿Que cancion vas a modificar? \n" + ordenado());
        
            if(playlist.contains(cancion)){
                int indice = 0;
                for(int i = 0; i < playlist.size() ; i++){
                    if(cancion == playlist.get(i)){
                        indice = i;
                        break;
                    }
                }
                playlist.set(indice,crear("¿Por cual la modificaras?"));
                cventana("Se ah modificado tu cancion: " + cancion + " \n por la cancion: " + playlist.get(indice));
            }else{
                cventana("La cancion no existe en la playlist");
            }
        }
    }

    public void mostrar (){
        
        if(playlist.isEmpty()){
            cventana(" No tienes canciones");
        }else{
            
            cventana(ordenado());
        }
    }

    public void limpiar (){
        
        if(playlist.isEmpty()){
            cventana("La playlist esta limpia");
        }else{
            playlist.clear();
            cventana("Se limpio tu playlist");
        }
    }

    public void eliminar (){
        
        if(playlist.isEmpty()){
            cventana("La playlist esta vacia");
         }else{
            
            if(repetir("¿Seguro que quieres eliminar?", "Advertencia")){

                String cancion = crear("¿Que cancion vas a eliminar? \n" + ordenado());
                if(playlist.contains(cancion)){
                int indice = 0;
                for(int i = 0; i < playlist.size() ; i++){
                    if(cancion == playlist.get(i)){
                        indice = i;
                        break;
                    }
                }
                playlist.remove(indice);
                cventana("Se ha borrado tu cancion");
                }else{
                    cventana("La cancion no existe");
                }
            }
        }
    }

    public void menu (String valor ){

        if(valor.equals("1") || valor.equals("agregar canciones")){
            agregar();
        }else if(valor.equals("2") || valor.equals("modificar canciones")){
            modificar();
        }else if (valor.equals("3") || valor.equals("mostrar canciones")){
            mostrar();
        }else if(valor.equals("4") || valor.equals("eliminar cancion")){
            eliminar();
        }else if(valor.equals("5") || valor.equals("limpiar playlist")){
            limpiar();
        }else if(valor.equals("6") || valor.equals("salir")){
            System.exit(0);
        }else{
            JOptionPane.showMessageDialog(null, "Mamo, Escribe bien");
        }

    }

    public static void main(String[] args) {
        
        Clase_11_09_2023 clase = new Clase_11_09_2023();
        
        do{
            clase.menu(clase.ventana());
        }while(true);
        
    }
}