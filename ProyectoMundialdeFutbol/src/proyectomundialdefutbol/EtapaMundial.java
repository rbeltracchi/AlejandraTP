/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomundialdefutbol;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AleC
 */
public abstract class EtapaMundial {
 private String descripcion;
 private List<Partido> partidos;
 //constructora
public EtapaMundial(){
  this.descripcion="";   
  this.partidos=new ArrayList<Partido>();
 }
 //metodos
public String getDescripcionEtapa(){
     return this.descripcion;
 }
public String setDescripcionEtapa(String d){
    return this.descripcion=d;
}
public void addPartido(Partido p){
     this.partidos.add(p);
     }
protected List<Partido> getPartidos(){  
  return this.partidos;
}
public abstract List<Equipo> getEquiposQueAvanzan();


}