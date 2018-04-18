/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomundialdefutbol;

import java.util.Date;

/**
 *
 * @author AleC
 */
public class Partido {
  private Date fecha;
  private Equipo local;
  private Equipo visitante;
  private Resultado resultado;
 //constructora
 public Partido (Date f1,Equipo l,Equipo v){
    this.fecha=f1;
    this.local=l;
    this.visitante=v;
    this.resultado=new Resultado();
    
 }
 //metodos
 public Resultado getResultado(){
     return this.resultado;
 }
 public void setResultado(int gl,int gv){
     this.resultado.setGolesLocal(gl);
     this.resultado.setGolesVisitante(gv);
 }
 public Equipo getLocal(){
     return this.local;
 }
 public Equipo getVisitante(){
     return this.visitante;
 }
 
}