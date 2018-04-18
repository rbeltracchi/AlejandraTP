/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomundialdefutbol;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author AleC
 */
public class Equipo {
   private String nombre; 
   private List<Partido> partidosJugados;
//constructora
public Equipo (){
  this.nombre="";
  this.partidosJugados=new ArrayList<Partido>();
}   
//metodos
public String getNombre(){
    return this.nombre;
}
public void setNombre(String n){
    this.nombre=n;
}
public List<Partido> getPartidos(){
    return this.partidosJugados;
}
public void setPartido(Partido p){
    //agrega partido jugado al equipo
    this.partidosJugados.add(p);
}
public int getDiferenciaDeGoles(){
//Ejercicio 2    
//retorna la diferencia de goles entre goles a favor y goles en contra
    int gf=0;
    int gc=0;
    for (Partido p:this.partidosJugados){
        if(p.getLocal().equals(this)){
           gf=+p.getResultado().getGolesLocal();
           gc=+p.getResultado().getGolesVisitante();
        }else{
            gf=+p.getResultado().getGolesVisitante();
            gc=+p.getResultado().getGolesLocal();
       }
    }
    return gf-gc;
}
public float PorcentajePartidosGanados(){
  // Ejercicio 4 
  //devuelve el porcentaje de partidos ganados sobre el total de partidos jugados
  int partidosGanados=0;
  for (Iterator<Partido> iterator = partidosJugados.iterator(); iterator.hasNext();) { 
    //recorre la lista de partidos jugados y cuenta los partidos ganados
    Partido partido = iterator.next(); 
    if((partido.getLocal().equals(this)&&partido.getResultado().ganoLocal())||(partido.getVisitante().equals(this)&&!partido.getResultado().ganoLocal()&&!partido.getResultado().empate())) 
        partidosGanados++;
  } 
  
  return (partidosGanados/partidosJugados.size())*100; 


}
@Override
public String toString(){
    //lista partidos jugados por un equipo
    String s="Fin del listado de partidos";
    System.out.println("partidos jugados por "+this.getNombre());
    for(Partido p:this.partidosJugados){
        System.out.println("local "+p.getLocal().getNombre()+" Visitante "+p.getVisitante().getNombre()+" resultado gL "+p.getResultado().getGolesLocal()+" resultado gV "+p.getResultado().getGolesVisitante());
    }   
    return s;
}
}