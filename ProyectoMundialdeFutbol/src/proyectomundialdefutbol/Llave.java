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
public class Llave extends EtapaMundial {

    @Override
    public List<Equipo> getEquiposQueAvanzan() {
    //devuelve lista de equipos que avanzan en estea etapa
    List<Equipo> le=new ArrayList();
    
    for(Partido p:this.getPartidos()){    
    if(p.getResultado().ganoLocal()){
        le.add(p.getLocal());
        System.out.println(p.getLocal().getNombre()+" pasa a la siguiente etapa ");
    }else{
        le.add(p.getVisitante());
        System.out.println(p.getVisitante().getNombre()+" pasa a la siguiente etapa ");
    }
    }
    return le;
    }
    
}
