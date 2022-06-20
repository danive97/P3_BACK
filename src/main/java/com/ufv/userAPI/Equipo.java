package com.ufv.userAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Equipo { //Creamos el objeto Equipo, con los distintos elementos que lo forman y con su tipo

    @JsonProperty("id_equipo")
    private int id_equipo;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("marca")
    private String marca;
    @JsonProperty("uso")
    private String uso;
    @JsonProperty("so_Nombre")
    private String so_nombre;
    @JsonProperty("so_Version")
    private String so_version;
    @JsonProperty("procesador")
    private String procesador;
    @JsonProperty("ram")
    private int ram;
    @JsonProperty("ram_speed")
    private int ram_speed;
    @JsonProperty("tipo_disco")
    private String tipo_disco;
    @JsonProperty("capacidad")
    private int capacidad;
    @JsonProperty("diagonal")
    private int diagonal;
    @JsonProperty("resolucion")
    private String resolucion;
    @JsonProperty("software_pago")
    private String software_pago;
    @JsonProperty("software_pago_v")
    private String software_pago_v;
    @JsonProperty("software_pago_t")
    private String software_pago_t;
    @JsonProperty("software_libre")
    private String software_libre;
    @JsonProperty("software_libre_v")
    private String software_libre_v;

    //Definimos todos los Get and Set de cada elemento de nuestro objeto
    public int getid_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getSo_nombre() {
        return so_nombre;
    }

    public void setSo_nombre(String so_nombre) {
        this.so_nombre = so_nombre;
    }

    public String getSo_version() {
        return so_version;
    }

    public void setSo_version(String so_version) {
        this.so_version = so_version;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getRam_speed() {
        return ram_speed;
    }

    public void setRam_speed(int ram_speed) {
        this.ram_speed = ram_speed;
    }

    public String getTipo_disco() {
        return tipo_disco;
    }

    public void setTipo_disco(String tipo_disco) {
        this.tipo_disco = tipo_disco;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getSoftware_pago() {
        return software_pago;
    }

    public void setSoftware_pago(String software_pago) {
        this.software_pago = software_pago;
    }

    public String getSoftware_pago_v() {
        return software_pago_v;
    }

    public void setSoftware_pago_v(String software_pago_v) {
        this.software_pago_v = software_pago_v;
    }

    public String getSoftware_pago_t() {
        return software_pago_t;
    }

    public void setSoftware_pago_t(String software_pago_t) {
        this.software_pago_t = software_pago_t;
    }

    public String getSoftware_libre() {
        return software_libre;
    }

    public void setSoftware_libre(String software_libre) {
        this.software_libre = software_libre;
    }

    public String getSoftware_libre_v() {
        return software_libre_v;
    }

    public void setSoftware_libre_v(String software_libre_v) {
        this.software_libre_v = software_libre_v;
    }
    //Definimos un constructor vacio
    public Equipo(){

    }
    //Definimos otro constructor, con los elementos de mi objeto
    public Equipo(int id_equipo, String tipo, String marca, String uso, String so_nombre, String so_version, String procesador, int ram, int ram_speed, String tipo_disco, int capacidad, int diagonal, String resolucion, String software_pago, String software_pago_v, String software_pago_t, String software_libre, String software_libre_v) {
        this.id_equipo = id_equipo;
        this.tipo = tipo;
        this.marca = marca;
        this.uso = uso;
        this.so_nombre = so_nombre;
        this.so_version = so_version;
        this.procesador = procesador;
        this.ram = ram;
        this.ram_speed = ram_speed;
        this.tipo_disco = tipo_disco;
        this.capacidad = capacidad;
        this.diagonal = diagonal;
        this.resolucion = resolucion;
        this.software_pago = software_pago;
        this.software_pago_v = software_pago_v;
        this.software_pago_t = software_pago_t;
        this.software_libre = software_libre;
        this.software_libre_v = software_libre_v;
    }
    //Definimos este método, para poner cómo queremos que nos saque los datos por pantalla, en formato String
    @Override
    public String toString() {
        return "Equipo{"+
                "id_equipo=" + id_equipo +
                ", tipo='" + tipo + '\'' +
                ", marca='" + marca + '\'' +
                ", uso='" + uso + '\'' +
                ", so_nombre='" + so_nombre + '\'' +
                ", so_version=" + so_version +
                ", procesador='" + procesador + '\'' +
                ", ram='" + ram + '\'' +
                ", ram_speed='" + ram_speed + '\'' +
                ", tipo_disco='" + tipo_disco + '\'' +
                ", capacidad='" + capacidad + '\'' +
                ", diagonal=" + diagonal +
                ", resolucion='" + resolucion + '\'' +
                ", software_pago='" + software_pago + '\'' +
                ", software_pago_v=" + software_pago_v +
                ", software_pago_t='" + software_pago_t + '\'' +
                ", software_libre=" + software_libre + '\'' +
                ", software_libre_v=" + software_libre_v +
                "}";
    }
}
