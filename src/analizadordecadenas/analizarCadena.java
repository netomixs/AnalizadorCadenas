/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadordecadenas;

import java.util.ArrayList;

/**
 *
 * @author netom
 */
public class analizarCadena {

    ArrayList<Nodo> nodos;
    char[] arr;

    public analizarCadena(ArrayList<Nodo> nodos, char[] arr) {
        this.nodos = nodos;

        this.arr = arr;
    }
    boolean aceptada = false;
    boolean noAceptada = true;
    String estado = "";

    void analizar(int indexActual, int indexNodo) {
        // System.out.println("Analizando cadena "+arr[indexActual]);
        if (aceptada == false) {
            if (indexActual == arr.length - 1) {
                for (Trancicion t : nodos.get(buscar(indexNodo)).getApunta()) {
                    if (t.getValor().equals("" + arr[indexActual])) {
                        if (nodos.get(buscar(t.getNodo())).estadoFinal) {
                            System.out.println("Ultima trancicion");
                            System.out.print("q" + nodos.get(buscar(indexNodo)).getEstado());
                            System.out.println(" Aceptada");
                            aceptada = true;
                            return;
                        }
                    }
                System.out.print("q" + nodos.get(buscar(indexNodo)).getEstado());
                System.out.println(" No Aceptada");;
                }
            } else {
                for (Trancicion t : nodos.get(buscar(indexNodo)).getApunta()) {
                    if (t.getValor().equals("" + arr[indexActual])) {
                        analizar(indexActual + 1, t.getNodo());
                    }
                }
            }
        }
    }

    int buscar(int buscar) {
        for (int i = 0; i < nodos.size(); i++) {
            if (nodos.get(i).getEstado() == buscar) {
                return i;
            }
        }
        return -1;
    }
}
