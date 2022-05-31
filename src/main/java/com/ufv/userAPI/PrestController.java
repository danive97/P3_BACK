package com.ufv.userAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PrestController {

    private final AtomicInteger counter = new AtomicInteger();


    @GetMapping("/Getprestamos")
    public ArrayList<Prestamo> Getprestamos(){
        ArrayList<Prestamo> lista_prestamos = Getlista_prestamos();
        return lista_prestamos;
    }


    @PostMapping(path = "/NewPrestamo",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity nuevoPrestamo (@RequestBody Prestamo NewPrestamo){
        ArrayList<Prestamo> lista_prestamos = Getlista_prestamos();
        NewPrestamo.setId((int) counter.getAndIncrement());
        lista_prestamos.add(NewPrestamo);
        editarJSON(lista_prestamos);

        return new ResponseEntity(HttpStatus.ACCEPTED);

    }



    @PutMapping(path = "/editarPrestamo",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity editarPrestamo (@RequestBody Prestamo prestamoEditado){
        ArrayList<Prestamo> lista_prestamos = Getlista_prestamos();

        int id = (int) prestamoEditado.getId();

        for (Prestamo prestamo : lista_prestamos){
            if(prestamo.getId() == id){
                prestamo.editarPrestamo(prestamoEditado);
            }
        }
        editarJSON(lista_prestamos);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }



    private ArrayList<Prestamo> Getlista_prestamos(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        ArrayList<Prestamo> lista_prestamos;

        Type prestamos_listaType = new TypeToken<ArrayList<Prestamo>>(){}.getType();

        FileReader file = null;
        try{
            file = new FileReader("Presta.json");
        }catch(IOException e){
            e.printStackTrace();
        }

        lista_prestamos = gson.fromJson(file, prestamos_listaType);

        try{
            file.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return lista_prestamos;
    }

    private void editarJSON(ArrayList<Prestamo> nuevosPrestamos){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter file = null;

        try{
            file = new FileWriter("Presta.json");
        }catch (IOException e){
            e.printStackTrace();
        }

        gson.toJson(nuevosPrestamos, file);

        try{
            file.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
