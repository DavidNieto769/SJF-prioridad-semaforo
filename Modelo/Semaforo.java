/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author
 */
public class Semaforo {
   private boolean estado;

   public Semaforo() {
      estado=true;
   }

   public void waitSemaforo(){
         estado=false;
   }
   public void signalSemaforo(){
         estado=true;
   }

   public boolean getEstado() {
      return this.estado;
   }
}
