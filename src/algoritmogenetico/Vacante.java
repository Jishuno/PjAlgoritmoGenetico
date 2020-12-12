/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico;

/**
 *
 * @author Jonat
 */
public class Vacante {
    private int Presupuesto;
    private Contratista[] Contratistas;
 
    private int ValorPagar;
    private int Capacidades;
 
    public Vacante(int Presupuesto, int numContratistas) {
        this.Presupuesto = Presupuesto;
        this.Contratistas = new Contratista[numContratistas];
        this.Capacidades = 0;
        this.ValorPagar = 0;
    }
 
    public Contratista[] getContratistas() {
        return Contratistas;
    }
 
     public int getValorPagar() {
       return ValorPagar;
    }
     
    public void setValorPagar(int ValorPagar) {
        this.ValorPagar = ValorPagar;
    }
 
    public int getCapacidades() {
        return Capacidades;
    }
 
    public void setCapacidades(int Capacidades) {
        this.Capacidades = Capacidades;
    }
 
    public int getPresupuesto() {
        return Presupuesto;
    }
 
    public void setPresupuesto(int Presupuesto) {
        this.Presupuesto = Presupuesto;
    }
 
    /**
     * Añade un Maestro a la mochila
     * @param e 
     */
    public void addContratista(Contratista e) {
 
        for (int i = 0; i < this.Contratistas.length; i++) {
            if (this.Contratistas[i] == null) {
                this.Contratistas[i] = e; //lo añade
                this.Capacidades+=e.getCapacidades(); // aumenta el Capacidades
                this.ValorPagar+=e.getValorPagar(); // Aumenta el piso
                break;
            }
        }
 
    }
 
    /**
     * Vaciamos la mochila
     */
    public void clear() {
        this.ValorPagar=0;
        this.Capacidades=0;
        for (int i = 0; i < this.Contratistas.length; i++) {
            this.Contratistas[i] = null;
        }
    }
 
    /**
     * Elimina Maestro dado
     * @param e 
     */
    public void eliminarContratista(Contratista e) {
        for (int i = 0; i < this.Contratistas.length; i++) {
            if (this.Contratistas[i].equals(e)) {
                this.Contratistas[i] = null; //el Maestro fuera
                this.ValorPagar-=e.getValorPagar(); //Reduce el ValorPagar
                this.Capacidades-=e.getCapacidades(); // reduce el Capacidades
                break;
            }
        }
    }
     
    /**
     * Indica si existe un Maestro
     * @param e
     * @return 
     */
    public boolean existeContratista(Contratista e) {
        for (int i = 0; i < this.Contratistas.length; i++) {
            if (this.Contratistas[i] != null && this.Contratistas[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
 
    /**
     * Muestra la mochila
     * @return 
     */
    public String toString() {
        String cadena="";
        for (int i = 0; i < this.Contratistas.length; i++) {
            if (this.Contratistas[i] != null) {
                cadena+=Contratistas[i]+"\n";
            }
        }
        cadena+="Valor a pagar: " + getValorPagar()+"\n";
        cadena+="Capacidades: " + getCapacidades()+"\n";
        return cadena;
    }
    
}
