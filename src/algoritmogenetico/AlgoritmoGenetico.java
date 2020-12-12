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
public class AlgoritmoGenetico {
    
    
    public static void llenarVacante(Vacante m_base, Contratista[] Contratistas, boolean llena, Vacante m_opt) {
 
      //si esta llena
      if (llena) {
          //compruebo si tiene mas Capacidades que otra
          if (m_base.getCapacidades() > m_opt.getCapacidades()) {
 
              Contratista[] ContraMochBase = m_base.getContratistas();
              m_opt.clear();
 
              //metemos los maestros
              for (Contratista e : ContraMochBase) {
                  if (e != null) {
                      m_opt.addContratista(e);
                  }
 
              }
 
          }
 
      } else {
          //Recorre los maestros
          for (int i = 0; i < Contratistas.length; i++) {
              //si existe el Maestro
              if (!m_base.existeContratista(Contratistas[i])) {
                  //Si el ValorPagar de la Vacante se supera, indicamos que esta llena
                  if (m_base.getPresupuesto()> m_base.getValorPagar()+ Contratistas[i].getValorPagar()) {
                      m_base.addContratista(Contratistas[i]); //añadimos
                      llenarVacante(m_base, Contratistas, false, m_opt);
                      m_base.eliminarContratista(Contratistas[i]); // lo eliminamos
                  } else {
                      llenarVacante(m_base, Contratistas, true, m_opt);
                  }
 
              }
 
          }
 
      }
 
  }
    
    public static void main(String[] args) {
        Contratista[] Contratistas = {
            new Contratista(120200000, 9),
            new Contratista(56000000, 4),
            new Contratista(89000000, 6),
            new Contratista(95000000, 7),
            new Contratista(77000000, 5)
        };
 
        Vacante m_base = new Vacante(400500000, Contratistas.length);
        Vacante m_opt = new Vacante(400500000, Contratistas.length);
 
        llenarVacante(m_base, Contratistas, false, m_opt);
 
        System.out.println(m_opt);
    }
    
}
