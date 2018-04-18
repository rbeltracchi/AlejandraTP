package proyectomundialdefutbol;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AleC
 */
public class Grupo extends EtapaMundial {

    private final int cantidadeq = 4;

    @Override
    public List<Equipo> getEquiposQueAvanzan() {

        List<Equipo> listaMejores = new ArrayList();
        List<Integer> puntajes = new ArrayList();
        //inicializar lista puntajes en cero
        puntajes.add(0,0);
        puntajes.add(1,0);
        puntajes.add(2,0);
        puntajes.add(3,0);
        List<Integer> listaIndices = new ArrayList();
        String l;
        String v;
        //suma los puntos a cada equipo del grupo
        for (Partido p : this.getPartidos()) {
            l = p.getLocal().getNombre();
            v = p.getVisitante().getNombre();
            
            if (p.getResultado().ganoLocal()) {
                puntajes = sumaPuntos(l, 3, puntajes);
                
            } else if (p.getResultado().empate()) {
                
                puntajes = sumaPuntos(l, 1, puntajes);
                puntajes = sumaPuntos(v, 1, puntajes);
                
            } else {
                puntajes = sumaPuntos(v, 3, puntajes);
                
            }
        }
        
        //obtiene los indices de los dos mejores equipos
        listaIndices = dosMaximosElementos(puntajes);
        
        //lista los nombres de los equipos del grupo
        List<String> listaEquiposG = new ArrayList();
        listaEquiposG.addAll(this.listadeEquiposporgrupo());
        //obtiene los nombres de los dos mejores equipos
        String equipo1 = listaEquiposG.get(listaIndices.get(0));
        String equipo2 = listaEquiposG.get(listaIndices.get(1));
        System.out.println("Mejores equipos "+super.getDescripcionEtapa()+" "+equipo1+" "+equipo2);
        //obtiene equipo a partir del nombre
        Equipo e1 = getEquipo(equipo1);
        Equipo e2 = getEquipo(equipo2);
        //agrega los dos equipos a la lista para retornar los dos mejores del grupo
        listaMejores.add(e1);
        listaMejores.add(e2);
        //lista los partidos jugados por los mejores equipos del grupo
        System.out.println(listaMejores);
        return listaMejores;
    }

    private List<Integer> sumaPuntos(String eq, Integer p, List<Integer> listaPuntajes) {
        //retorna una lista de puntajes actualizada, agregando el puntaje p al equipo eq
        //Primero, se obtiene la lista de equipos del grupo
        List<String> listaEquiposG = new ArrayList();
        listaEquiposG.addAll(this.listadeEquiposporgrupo());
        //asigna el puntaje p al equipo de nombre eq
        int i = listaEquiposG.indexOf(eq);
        listaPuntajes.set(i, listaPuntajes.get(i) + p);
        //retorna lista actualizada de puntajes
        return listaPuntajes;
    }

    private List<String> listadeEquiposporgrupo() {
        //genera un lista con los nombres de los equipos del grupo
        List<String> lista = new ArrayList();
        int contador = 0;
        String equipo1 = super.getPartidos().get(contador).getLocal().getNombre();
        lista.add(contador, equipo1);
        String equipo2 = super.getPartidos().get(contador).getVisitante().getNombre();
        contador++;
        lista.add(contador,equipo2);
        int i = contador;
        contador++;
        while ((i< super.getPartidos().size()) | (contador < this.cantidadeq-1)) {
            String eq = super.getPartidos().get(i).getLocal().getNombre();
            if (!lista.contains(eq)) {
                lista.add(contador, eq);
                contador++;
            }
            eq = super.getPartidos().get(i).getVisitante().getNombre();
            if ((!lista.contains(eq)) && (contador < this.cantidadeq)) {
                lista.add(contador, eq);
                contador++;
                
            }
        
        i++;
        }
        
        return lista;
    }

    private Equipo getEquipo(String nombre) {
        //dado un nombre de equipo recupera el objeto Equipo
        int i = 0;
        boolean continuar = true;
        Equipo e = new Equipo();
        while ((i < this.cantidadeq) && (continuar)) {
            if (!super.getPartidos().get(i).getLocal().getNombre().equals(nombre)) {
                if (!super.getPartidos().get(i).getVisitante().getNombre().equals(nombre)) {
                    i++;
                } else {
                    e = super.getPartidos().get(i).getVisitante();
                    continuar = false;
                }
            } else {
                e = super.getPartidos().get(i).getLocal();
                continuar = false;
            }
        }
        return e;
    }

    private int maximoElemento(List<Integer> lista) {
        //retorna el índice al mayor elemento de una lista
        int max = lista.get(0);
        int i = 0;
        for (Integer l : lista) {
            if (l > max) {
                max = l;
                i = lista.indexOf(l);
            }
        }
        return i-1;
    }

    private List<Integer> dosMaximosElementos(List<Integer> l) {
        //retorna una lista con dos índices que apuntan a los dos mayores puntajes del grupo
        List<Integer> listaMax = new ArrayList();
        int i = maximoElemento(l);
        listaMax.add(0, i);
        l.add(i, 0);
        i = maximoElemento(l);
        listaMax.add(1, i);
        return listaMax;
    }
}
