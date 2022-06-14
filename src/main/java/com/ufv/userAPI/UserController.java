package com.ufv.userAPI;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;



import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;



@RestController
public class UserController {

    private final AtomicInteger counter = new AtomicInteger();

    @GetMapping("/actualizarid")
    public void IniciarContador() throws IOException{
        ArrayList<User> lista_users = GetListausers();

        if(lista_users.size()!=0){
            int max = 0;

            for (User user : lista_users){
                if(user.getId()>max){
                    max = user.getId();
                }
            }
            counter.set(max+1);
        }
        else{
            counter.set(0);
        }
    }

    @GetMapping("/Getusers")
    public ArrayList<User> Getusers() throws IOException{
        ArrayList<User> lista_users = GetListausers();
        return lista_users;
    }


    @PostMapping(path = "/NewUsers",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity nuevoUsuario (@RequestBody User newUser) throws IOException{
        ArrayList<User> lista_users = GetListausers();
        newUser.setId(counter.getAndIncrement());
        lista_users.add(newUser);
        editarJSON(lista_users);

        return new ResponseEntity(HttpStatus.CREATED);

    }



    @PutMapping(path = "/editarUser",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity editarUsuario (@RequestBody User userEditado) throws IOException{
        ArrayList<User> lista_users = GetListausers();

        int id = userEditado.getId();

        for (User user : lista_users){
            if(user.getId() == id){
                user.editarUsuario(userEditado);
            }
        }
        editarJSON(lista_users);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/borradoUser/{id}")
    public ResponseEntity borradoUser(@PathVariable int id) throws IOException{
        ArrayList<User> lista_users = GetListausers();

        lista_users.removeIf(user -> user.getId()==id);

        editarJSON(lista_users);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    private ArrayList<User> GetListausers() throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        ArrayList<User> lista_users;

        Type usersListaType = new TypeToken<ArrayList<User>>(){}.getType();

        FileReader file = null;
        try{
            file = new FileReader("Users.json");
        }catch(IOException e){
            e.printStackTrace();
        }

        lista_users = gson.fromJson(file, usersListaType);

        try{
            file.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return lista_users;
    }

    private void editarJSON(ArrayList<User> nuevosUsers){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter file = null;
        String newFile = null;
        try{
            file = new FileWriter("Users.json");
        }catch (IOException e){
            e.printStackTrace();
        }

        gson.toJson(nuevosUsers, file);

        try{
            file.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
