package com.ufv.userAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

@RestController //Definimos esta clase como controlador de los Equipos
public class EquiController {

    @GetMapping("/Getequipos") //Este método, lo usamos para obtener los equipos
    public ArrayList<Equipo> Getequipos(){// Definimos un arraylist para los equipos
        Gson gson = new GsonBuilder().setPrettyPrinting().create();//Usamos la libreria Gson para la interfaz

        ArrayList<Equipo> lista_equipos;

        Type equipos_listaType = new TypeToken<ArrayList<Equipo>>(){}.getType();

        FileReader file = null;
        try{
            file = new FileReader("Equipo.json"); //Le pasamos el fichero json que debe leer
        }catch(IOException e){
            e.printStackTrace();
        }

        lista_equipos = gson.fromJson(file, equipos_listaType); //Usamos nuestro objeto Gson, para pasarle el jSON

        try{
            file.close();//Cerramos el fichero
        }catch(IOException e){
            e.printStackTrace();
        }

        return lista_equipos;//Devuelvo la lista de equipos
    }
}
