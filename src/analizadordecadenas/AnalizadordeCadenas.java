/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package analizadordecadenas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author netom
 */
public class AnalizadordeCadenas {

    static Set<String> alfabeto;
    static int numEstados;
    static ArrayList<Nodo> lista;

    public static void main(String[] args) {
        JLabel esatoLabe = new JLabel("Estado");
        JLabel nameLabel = new JLabel("Valor:");
        JTextField nameField = new JTextField(3);

        JLabel ageLabel = new JLabel("Nodo destino:");
        JTextField ageField = new PositiveIntegerField(2);

        // Crear el panel personalizado
        JPanel panel = new JPanel();
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);

        String input = "";
        boolean cancel = false;
        alfabeto = new HashSet<>();
        lista = new ArrayList<>();
        //crearNodo();

        // Bucle que pide datos hasta que el usuario cancele la entrada
        while (!cancel) {
            input = JOptionPane.showInputDialog("Ingrese alafabeto");
            if (input == null) {
                cancel = true;
            } else {
                alfabeto.add(input);
            }
        }

        JOptionPane.showMessageDialog(null, "Entrada cancelada.");
        boolean done = false;

        while (!done) {
            input = JOptionPane.showInputDialog(null, "Ingrese el numeros de estado:");
            if (input != null && !input.isEmpty()) {
                done = true;
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar un valor.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        numEstados = Integer.parseInt(input);

        while (numEstados != lista.size()) {
            done = false;
            while (!done) {
                input = JOptionPane.showInputDialog(null, "Ingrese numero de estado Q:");
                if (input != null && !input.isEmpty()) {
                    done = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un valor.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            Nodo nodo = new Nodo(Integer.parseInt(input));
            done = false;
            while (!done) {
                Trancicion t = new Trancicion();
                int result = JOptionPane.showConfirmDialog(null, panel, "Ingrese transicion para el nodo ", JOptionPane.OK_CANCEL_OPTION);

                // Si se presionó el botón "OK", mostrar los datos ingresados
                if (result == JOptionPane.OK_OPTION) {

                    t.setValor(nameField.getText());
                    t.setNodo(Integer.parseInt(ageField.getText()));
                    if (alfabeto.contains(t.getValor())) {
                        nodo.addTrancicion(t);
                    } else {
                        JOptionPane.showMessageDialog(null, "El valor debe de pertenencer al alfabeto", "Transicion novalida", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    done = true;
                }
            }
            int result = JOptionPane.showConfirmDialog(null, "¿Marcar nodo como final?", "Nodo " + nodo.getEstado(), JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                nodo.estadoFinal = true;
            } else if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
                System.out.println(" ");
            }
            lista.add(nodo);
            System.out.println(lista.size());
        }
        calcular();
    }

    static void crearNodo() {
        Nodo n0 = new Nodo(10, 10, 0);
        n0.estadoInicial = true;
        n0.addTrancicion(new Trancicion("a", 1));
        n0.addTrancicion(new Trancicion("a", 2));
        n0.addTrancicion(new Trancicion("b", 0));
        n0.addTrancicion(new Trancicion("b", 2));
        n0.addTrancicion(new Trancicion("c", 0));

        Nodo n1 = new Nodo(10, 10, 1);

        n1.addTrancicion(new Trancicion("b", 0));
        n1.addTrancicion(new Trancicion("b", 5));
        n1.addTrancicion(new Trancicion("c", 1));
        n1.addTrancicion(new Trancicion("c", 5));

        Nodo n2 = new Nodo(10, 10, 2);

        n2.addTrancicion(new Trancicion("a", 4));
        n2.addTrancicion(new Trancicion("a", 1));
        n2.addTrancicion(new Trancicion("b", 2));
        n2.addTrancicion(new Trancicion("c", 4));
        n2.addTrancicion(new Trancicion("c", 1));

        Nodo n3 = new Nodo(10, 10, 3);
        n3.estadoFinal = true;
        n3.addTrancicion(new Trancicion("a", 3));
        n3.addTrancicion(new Trancicion("a", 1));
        n3.addTrancicion(new Trancicion("b", 5));
        n3.addTrancicion(new Trancicion("c", 2));
        n3.addTrancicion(new Trancicion("c", 0));

        Nodo n4 = new Nodo(10, 10, 4);

        n4.addTrancicion(new Trancicion("a", 3));
        n4.addTrancicion(new Trancicion("a", 6));
        n4.addTrancicion(new Trancicion("b", 6));
        n4.addTrancicion(new Trancicion("c", 3));

        Nodo n5 = new Nodo(10, 10, 5);
        n5.estadoFinal = true;
        n5.addTrancicion(new Trancicion("a", 5));
        n5.addTrancicion(new Trancicion("b", 5));
        n5.addTrancicion(new Trancicion("b", 1));
        n5.addTrancicion(new Trancicion("c", 4));
        n5.addTrancicion(new Trancicion("c", 1));

        Nodo n6 = new Nodo(10, 10, 6);

        n6.addTrancicion(new Trancicion("a", 5));
        n6.addTrancicion(new Trancicion("b", 5));
        n6.addTrancicion(new Trancicion("b", 2));
        n6.addTrancicion(new Trancicion("c", 2));
        lista.add(n6);
        lista.add(n5);
        lista.add(n1);
        lista.add(n2);
        lista.add(n3);
        lista.add(n4);
        lista.add(n0);

        String joined = "cababbaba";

        char[] result = new char[joined.length()];
        joined.getChars(0, joined.length(), result, 0);
        analizarCadena analizar = new analizarCadena(lista, result);
        analizar.analizar(0, 0);
    }

    static void calcular() {
        boolean fin = false;
        while (fin != true) {
            String a = JOptionPane.showInputDialog("ingresa cadena");
            if (a != null) {
                char[] result = new char[a.length()];
                a.getChars(0, a.length(), result, 0);
                analizarCadena analizar = new analizarCadena(lista, result);
                analizar.analizar(0, 0);
                System.out.println("Resultados");
            }
            if (a == null) {
                fin = true;
            }
        }

    }
}
