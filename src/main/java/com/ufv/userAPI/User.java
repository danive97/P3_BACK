package com.ufv.userAPI;

import com.fasterxml.jackson.annotation.JsonProperty;
//No he puesto comentarios, porque sigue la misma dinámica que las otras dos clases (Prestamo y Equipo)
//Para ver los comentarios, revisar las otras dos clases
public class User {

    @JsonProperty("id")
    private int id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("departamento")
    private String departamento;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("email")
    private String email;
    @JsonProperty("ubicacion")
    private String ubicacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public User() {
    }


    public User(int id, String nombre, String departamento, String telefono, String email, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.telefono = telefono;
        this.email = email;
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "User{" +
                "Nombre='" + nombre + '\'' +
                ", Departamento='" + departamento + '\'' +
                ", Telefono='" + telefono + '\'' +
                ", Email='" + email + '\'' +
                ", Ubicación='" + ubicacion+
                '}';
    }

    public void editarUsuario(User userEditado){
        this.setNombre(userEditado.getNombre());
        this.setDepartamento(userEditado.getDepartamento());
        this.setTelefono(userEditado.getTelefono());
        this.setEmail(userEditado.getEmail());
        this.setUbicacion(userEditado.getUbicacion());
    }
}
