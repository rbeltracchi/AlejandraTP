/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomundialdefutbol;

/**
 *
 * @author AleC
 */
public class Resultado {
  private int golesLocal;
  private int golesVisitante;
//constructor
public void Resultado(){
    golesLocal=0;
    golesVisitante=0;
}
//metodos
public int getGolesLocal(){
    return this.golesLocal;
}  
public void setGolesLocal(int gl){
    this.golesLocal=gl;
}
public int getGolesVisitante(){
    return this.golesVisitante;
}
public void setGolesVisitante(int gv){
    this.golesVisitante=gv;
}
public boolean ganoLocal(){
    return (this.golesLocal>this.golesVisitante);
}
public boolean empate(){
    return(this.golesLocal==this.golesVisitante);
}
}
