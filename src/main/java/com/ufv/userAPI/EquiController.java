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

@RestController
public class EquiController {

    @GetMapping("/Getequipos")
    public ArrayList<Equipo> Getequipos(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        ArrayList<Equipo> lista_equipos;

        Type equipos_listaType = new TypeToken<ArrayList<Equipo>>(){}.getType();

        FileReader file = null;
        try{
            file = new FileReader("Equipo.json");
        }catch(IOException e){
            e.printStackTrace();
        }

        lista_equipos = gson.fromJson(file, equipos_listaType);

        try{
            file.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return lista_equipos;
    }
}
