/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caso.evaluado.pkg1;

/**
 *
 * @author gonza
 */
public class Agente {
    private String nombreAgente;
    private int cedulaAgente;
    private int codigoAgente;
    private String sucursal;
    private boolean vehiculo;

    public Agente(String nombreAgente, int cedulaAgente, int codigoAgente, String sucursal, boolean vehiculo) {
        this.nombreAgente = nombreAgente;
        this.cedulaAgente = cedulaAgente;
        this.codigoAgente = codigoAgente;
        this.sucursal = sucursal;
        this.vehiculo = vehiculo;
    }
    

    public String getNombreAgente() {
        return nombreAgente;
    }

    public void setNombreAgente(String nombreAgente) {
        this.nombreAgente = nombreAgente;
    }

    public int getCedulaAgente() {
        return cedulaAgente;
    }

    public void setCedulaAgente(int cedulaAgente) {
        this.cedulaAgente = cedulaAgente;
    }

    public int getCodigoAgente() {
        return codigoAgente;
    }

    public void setCodigoAgente(int codigoAgente) {
        this.codigoAgente = codigoAgente;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public boolean isVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(boolean vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    
           
    
}
