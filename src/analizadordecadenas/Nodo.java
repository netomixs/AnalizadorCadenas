/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadordecadenas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author netom
 */
public class Nodo extends JPanel {

    private Set<Trancicion> apunta;
    int estado;
    public boolean estadoFinal;
    public boolean estadoInicial;
    
    public static int radio = 50;
    public boolean ismoved = false;
    int x, y;


    public Nodo(int x, int y, int estado ) {
    
        this.apunta = new HashSet<>();
        this.x = x;
        this.y = y;
        this.estado = estado;
        estadoFinal = false;
        estadoInicial = false;
    }
public Nodo(int estado) {
        this.apunta = new HashSet<>();
        this.x = 0;
        this.y = 0;
        this.estado = estado;
        estadoFinal = false;
        estadoInicial = false;
      
    }
   

    public void addTrancicion(Trancicion a) {
        apunta.add(a);
    }

    public void removerTrancicion(int nodo) {
        for (Trancicion trancicion : apunta) {
            if (trancicion.getNodo() == nodo) {
                apunta.remove(trancicion);
            }
        }
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public Set<Trancicion> getApunta() {
       
        return apunta;
    }

    public void setApunta(Set<Trancicion> apunta) {
        this.apunta = apunta;
    }


    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
