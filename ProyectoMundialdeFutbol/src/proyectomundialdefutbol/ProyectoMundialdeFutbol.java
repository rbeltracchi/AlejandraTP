/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomundialdefutbol;

import java.util.Date;
import java.util.List;

/**
 *
 * @author AleC
 */
public class ProyectoMundialdeFutbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    //configuracion fechas
    Date fecha1=new Date (2018,6,15,12,3,4);
    Date fecha2=new Date(2018,6,17,12,3,4);
    Date fecha3=new Date(2018,6,19,12,3,4);
    Date fecha4=new Date(2018,6,20,12,3,4);
    Date fecha5=new Date(2018,6,23,12,3,4);
    Date fecha6=new Date(2018,6,28,12,3,4);
    //Etapa grupo1
    EtapaMundial grupo1=new Grupo(); 
    grupo1.setDescripcionEtapa("Grupo1");
    //creación equipos grupo 1
    Equipo e1=new Equipo(); e1.setNombre("Arabia Saudita"); 
    Equipo e2=new Equipo(); e2.setNombre("Egipto"); 
    Equipo e3=new Equipo(); e3.setNombre("Uruguay"); 
    Equipo e4=new Equipo(); e4.setNombre("Rusia"); 
    Partido p1=new Partido(fecha1,e1,e2); grupo1.addPartido(p1);
    p1.setResultado(0, 1);
    e1.setPartido(p1);
    e2.setPartido(p1);
    Partido p2=new Partido(fecha2,e1,e3);grupo1.addPartido(p2);
    p2.setResultado(1, 1);
    e1.setPartido(p2);
    e3.setPartido(p2);
    Partido p3=new Partido(fecha3,e1,e4); grupo1.addPartido(p3);
    p3.setResultado(0, 3);
    e1.setPartido(p3);
    e4.setPartido(p3);
    Partido p4=new Partido(fecha2,e2,e3);grupo1.addPartido(p4);
    p4.setResultado(0, 1);
    e2.setPartido(p4);
    e3.setPartido(p4);
    Partido p5=new Partido(fecha3,e2,e4);grupo1.addPartido(p5);
    p5.setResultado(0, 1);
    e2.setPartido(p5);
    e4.setPartido(p5);
    Partido p6=new Partido(fecha1,e3,e4);grupo1.addPartido(p6);
    p6.setResultado(0, 1);
    e3.setPartido(p6);
    e4.setPartido(p6);
    //seleccion de equipos que avanzan del grupo 1
    List<Equipo> le1=grupo1.getEquiposQueAvanzan();
    
    //Etapa grupo2
    EtapaMundial grupo2=new Grupo(); 
    grupo2.setDescripcionEtapa("Grupo2");
    //creación equipos grupo 2
    Equipo e5=new Equipo(); e5.setNombre("Portugal"); 
    Equipo e6=new Equipo(); e6.setNombre("España"); 
    Equipo e7=new Equipo(); e7.setNombre("Argentina"); 
    Equipo e8=new Equipo(); e8.setNombre("Iran"); 
    Partido p7=new Partido(fecha1,e5,e6); grupo2.addPartido(p7);
    p7.setResultado(1, 1);
    e5.setPartido(p7);
    e6.setPartido(p7);
    Partido p8=new Partido(fecha2,e5,e7);grupo2.addPartido(p8);
    p8.setResultado(0, 1);
    e7.setPartido(p8);
    e8.setPartido(p8);
    Partido p9=new Partido(fecha3,e5,e8); grupo2.addPartido(p9);
    p9.setResultado(1, 0);
    e5.setPartido(p9);
    e8.setPartido(p9);
    Partido p10=new Partido(fecha2,e6,e7);grupo2.addPartido(p10);
    p10.setResultado(0, 1);
    e6.setPartido(p10);
    e7.setPartido(p10);
    Partido p11=new Partido(fecha3,e6,e8);grupo2.addPartido(p11);
    p11.setResultado(0, 1);
    e6.setPartido(p11);
    e8.setPartido(p11);
    Partido p12=new Partido(fecha1,e7,e8);grupo2.addPartido(p12);
    p12.setResultado(0, 1);
    e7.setPartido(p12);
    e8.setPartido(p12);
    //Seleccion de equipos que avanzan del grupo 2
    List<Equipo> le2=grupo2.getEquiposQueAvanzan();
    
    //etapa LLave (semifinal)
    EtapaMundial semifinal1=new Llave();
    semifinal1.setDescripcionEtapa("Semifinal1");
    Partido p13=new Partido(fecha4,le1.get(0),le2.get(1));semifinal1.addPartido(p13);
    p13.setResultado(0,1);
    le1.get(0).setPartido(p13);
    le2.get(1).setPartido(p13);
    
    EtapaMundial semifinal2=new Llave();
    semifinal2.setDescripcionEtapa("Semifinal2");
    Partido p14=new Partido(fecha5,le1.get(1),le2.get(0));semifinal2.addPartido(p14);
    p14.setResultado(3,0);
    le1.get(1).setPartido(p14);
    le2.get(0).setPartido(p14);
    List<Equipo> lle1=semifinal1.getEquiposQueAvanzan();
    List<Equipo> lle2=semifinal2.getEquiposQueAvanzan();
       
    //Etapa Final
    EtapaMundial finale=new Llave();
    finale.setDescripcionEtapa("Final");
    Partido p15=new Partido(fecha6,lle1.get(0),lle2.get(0));finale.addPartido(p15);
    p15.setResultado(2,0);
    lle1.get(0).setPartido(p15);
    lle2.get(0).setPartido(p15);
    List<Equipo> lle3=finale.getEquiposQueAvanzan();
    System.out.println(lle3.get(0).getNombre()+" es el ganador!!!!!");
    //Ejercicio 2
    int goles=lle3.get(0).getDiferenciaDeGoles();
    System.out.println("Diferencia de goles ganador "+goles);
    //Ejercicio 4
    float ppg=lle3.get(0).PorcentajePartidosGanados();
    System.out.println("Porcentaje partidos ganados del ganador "+ppg);
    }
    
}
