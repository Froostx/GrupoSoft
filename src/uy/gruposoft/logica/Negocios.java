package uy.gruposoft.logica;

import java.util.ArrayList;

/**
 *
 * @author gdelgado
 */
public class Negocios {
    
    private ArrayList<Negocio> negocios = new ArrayList();
    
    public ArrayList<Negocio> getNegocios(){
        return negocios;
    }
    
    public void setNegocios(ArrayList<Negocio> negocios){
        this.negocios = negocios;
    }
    
    public void agregarNegocio(Negocio nuevo){
        negocios.add(nuevo);
    }
    
}
