package com.yelsyn.backendcotizador.Entities;

public class Cliente {
    private String PaisOrigen;
    private String nombre;
    private double valorDescuento;

    public String getPaisOrigen() {
        return PaisOrigen;
    }
    public void setPaisOrigen(String paisOrigen) {
        PaisOrigen = paisOrigen;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValorDescuento() {
        return valorDescuento;
    }
    public void setValorDescuento(double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }
}
