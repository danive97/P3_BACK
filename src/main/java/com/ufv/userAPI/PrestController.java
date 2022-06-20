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


@RestController //En esta clase, hemos definido el controlador para nuestro Prestamos
public class PrestController {

    private final AtomicInteger counter = new AtomicInteger(); //Aquí definimos un integer, que va en autoincremento
                                //para los id de nuestros datos, aunque los pongamos a mano


    @GetMapping("/Getprestamos") //Aquí definimos el "string" que recibira mi api, para llamar a la lista de los prestamos
    public ArrayList<Prestamo> Getprestamos(){
        ArrayList<Prestamo> lista_prestamos = Getlista_prestamos();
        return lista_prestamos;
    }


    @PostMapping(path = "/NewPrestamo", //Aquí, como usamos POST, vamos a crear un dato en nuestra api, en el caso
                                        //de querer crear un nuevo prestamo
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity nuevoPrestamo (@RequestBody Prestamo NewPrestamo){
        //Aquí cuando ya tenemos el nuevo prestamo, vamos a hacer una REQUEST para agregarlo a nuestra lista de prestamos
        ArrayList<Prestamo> lista_prestamos = Getlista_prestamos();
        NewPrestamo.setId(counter.getAndIncrement());
        lista_prestamos.add(NewPrestamo);
        editarJSON(lista_prestamos); //Llamamos a editarJson(creado en nuestra clase Prestamo)

        return new ResponseEntity(HttpStatus.ACCEPTED);

    }


    //En el caso de querer EDITAR un prestamo, vamos a usar el PUT de la API, donde creamos la edición de tipo json value
    @PutMapping(path = "/editarPrestamo",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    //Una vez editado nuestro prestamos, vamos a lanzar una request para editar nuestro prestamo en nuestra lista
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


    //Aquí definimos nuestro método para obtener los prestamos, este método lo hemos llamado arriba para cuando iniciamos el grid
    private ArrayList<Prestamo> Getlista_prestamos(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        ArrayList<Prestamo> lista_prestamos;

        Type prestamos_listaType = new TypeToken<ArrayList<Prestamo>>(){}.getType();

        FileReader file = null;
        try{ //Aquí, usamos nuestro fichero Presta.json donde tenemos los prestamos, para poder leerlos y procesarlos
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
    //Por último, nuestro método para editar el JSON de los prestamos
    private void editarJSON(ArrayList<Prestamo> nuevosPrestamos){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter file = null;

        try{ //Donde volvemos a llamar a Presta.json, para hacer las modificaciones y cerrar nuestro fichero
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
