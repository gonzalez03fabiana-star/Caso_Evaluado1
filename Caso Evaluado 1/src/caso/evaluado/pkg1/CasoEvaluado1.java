/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caso.evaluado.pkg1;

import javax.swing.JOptionPane;

/**
 *
 * @author gonza
 */
public class CasoEvaluado1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Solicitud de datos del agente 
        String nombreAgente = JOptionPane.showInputDialog("Indique el nombre del agente: ");
        int cedulaAgente = Integer.parseInt(JOptionPane.showInputDialog("Indique el numero de cedula del agente: "));
        int codigoAgente = Integer.parseInt(JOptionPane.showInputDialog("Indique el codigo del agente: "));
        String sucursal = JOptionPane.showInputDialog("Indique la sucursal para la que trabaja el agente: ");
        int vehiculo = JOptionPane.showConfirmDialog(null, "El agente cuenta con vehiculo propio? ", "vehiculo", JOptionPane.YES_NO_OPTION);
        boolean carro = (vehiculo == JOptionPane.YES_OPTION);

        Agente agente = new Agente(nombreAgente, cedulaAgente, codigoAgente, sucursal, carro);

        //Contadores 
        int cantidadFactura = 0;
        double totalComisiones = 0;
        int puntos = 0;
        int mesFactura = 0;
        double bono = 0;
        double montoFactura = 0;
        boolean bonoExtra = false;
        boolean vehiculoPropio = false;

        //Registro de facturas
        int continuar;

        do {
            JOptionPane.showMessageDialog(null, "Registro de factura # " + (cantidadFactura + 1));

            String nombreCliente = JOptionPane.showInputDialog("Indique el nombre del cliente: ");
            int cedulaCliente = Integer.parseInt(JOptionPane.showInputDialog("Indique el numero de cedula del cliente: "));
            int noFactura = Integer.parseInt(JOptionPane.showInputDialog("Indique el numero de factura: "));
            double montoCompra = Double.parseDouble(JOptionPane.showInputDialog("Indique el monto de la factura: "));

            int mes;
            do {
                mes = Integer.parseInt(JOptionPane.showInputDialog("Indique el mes de la factura (1-12): "));
                if (mes < 1 || mes > 12) {
                    JOptionPane.showMessageDialog(null, "Mes invalido");
                }

            } while (mes < 1 || mes > 12);

            int productosElectricos = Integer.parseInt(JOptionPane.showInputDialog("Indique cuantos productos electricos compro: "));
            int productosAutomotrices = Integer.parseInt(JOptionPane.showInputDialog("Indique cuantos productos automotrices compro: "));
            int productosConstruccion = Integer.parseInt(JOptionPane.showInputDialog("Indique cuantos productos de construccion compro: "));

            Factura factura = new Factura(nombreCliente, cedulaCliente, noFactura, montoFactura, mes, productosElectricos, productosAutomotrices, productosConstruccion);

            if (cantidadFactura == 0);
            {
                mesFactura = mes;
            }

            //Calculo de comisiones y puntos 
            if (productosElectricos > 0 || productosAutomotrices > 0 || productosConstruccion > 0) {
                bono += montoFactura * 0.10;
                puntos += 3;

                if (productosElectricos >= 3) {
                    bono += montoFactura * 0.04;
                    puntos += 1;
                } else if (productosElectricos < 3) {
                    bono += montoFactura * 0.02;
                    puntos += 1;
                }

                if (productosAutomotrices >= 4) {
                    bono += montoFactura * 0.04;
                    puntos += 1;
                } else if (productosAutomotrices < 4) {
                    bono += montoFactura * 0.02;
                    puntos += 1;
                }

                if (productosConstruccion > 0) {
                    bono += montoFactura * 0.08;
                    puntos += 2;
                }

                if (montoFactura > 50000) {
                    bono += montoFactura * 0.05;
                    puntos += 1;
                }

                totalComisiones += montoFactura + bono;
            }

            cantidadFactura += 1;

            continuar = JOptionPane.showConfirmDialog(null, "Desea registrar otro factura? ", "Continuar", JOptionPane.YES_NO_OPTION);

        } while (continuar == JOptionPane.YES_OPTION);

        //Calculo bono extra
        if (cantidadFactura > 3 || montoFactura > 300000) {
            totalComisiones += 2000;
            bonoExtra = true;
        }

        //Mes de la factura
        String nombreMes;
        switch (mesFactura) {
            case 1:
                nombreMes = "enero";
                break;
            case 2:
                nombreMes = "febrero";
                break;
            case 3:
                nombreMes = "marzo";
                break;
            case 4:
                nombreMes = "abril";
                break;
            case 5:
                nombreMes = "mayo";
                break;
            case 6:
                nombreMes = "junio";
                break;
            case 7:
                nombreMes = "julio";
                break;
            case 8:
                nombreMes = "agosto";
                break;
            case 9:
                nombreMes = "septiembre";
                break;
            case 10:
                nombreMes = "octubre";
                break;
            case 11:
                nombreMes = "noviembre";
                break;
            case 12:
                nombreMes = "diciembre";
                break;
            default:
                nombreMes = "desconocido";
                break;
        }
        
        //Salida de resultados
        String resultado = "El agente \"" + agente.getNombreAgente() + "\" código: " + codigoAgente
                + " en el mes de " + nombreMes + "\n"
                + "Obtuvo un total en comisiones de $" + totalComisiones + ".\n"
                + "El agente " + (bonoExtra ? "logró" : "no logró") + " el objetivo de obtener el BONO EXTRA\n"
                + "Puntos obtenidos por el agente: " + puntos + "\n"
                + "El agente " + (agente.isVehiculo() ? "cuenta" : "no cuenta") + " con vehiculo propio\n"
                + "Sucursal: " + agente.getSucursal();

        JOptionPane.showConfirmDialog(null, resultado);

    }

}
