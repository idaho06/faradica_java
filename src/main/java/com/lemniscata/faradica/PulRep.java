package com.lemniscata.faradica;

import javax.swing.*;
import java.awt.*;

public class PulRep extends JPanel {

    private Generador generador = null;
    //private JLabel titulo;
    private JPanel confWest;
    private JPanel formaConf;

    public PulRep(Generador g) {
        super(new BorderLayout());
        generador = g;
        //titulo = new JLabel("Pulso - Reposo: " + generador.getFrecuencia(), JLabel.LEFT);
        //this.add(titulo, BorderLayout.WEST);
        // Panel para elejir la forma de onda
        formaConf = new JPanel(new GridLayout(0, 1));
        formaConf.setBorder(BorderFactory.createTitledBorder("Forma"));
        JRadioButton Cuadrada = new JRadioButton("Cuadrada");
        JRadioButton Triangular = new JRadioButton("Triangular");
        formaConf.add(Cuadrada);
        formaConf.add(Triangular);


        // Panel de la izquierda con configuraciones
        confWest = new JPanel(new GridLayout(0, 1, 4, 4)); // Vertical grid of panes
        confWest.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        confWest.add(formaConf); // Panel con configuracion de Forma
        confWest.add(new JLabel("T Pulso")); // Panel con configuracin de Tiempo de Pulso
        confWest.add(new JLabel("T Reposo")); // Panel con configuración de Tiempo de Reposo
        confWest.add(new JLabel("Polaridad")); // Panel con configuracion de polaridad
        //confWest.setPreferredSize(new Dimension(100,50));
        this.add(confWest, BorderLayout.WEST);
        this.add(new JScrollPane(), BorderLayout.CENTER);

    }
}
