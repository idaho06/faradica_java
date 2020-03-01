package com.lemniscata.faradica;


import javax.swing.*;
import java.awt.*;

public class FaradicaApp implements Runnable {

    private Generador generador;

    public FaradicaApp() {
        this.generador = new Generador();
        //System.out.println(generador.getFrecuencia());
    }

    public void run() {

        //JPanel mainPanel = new JPanel(new BorderLayout(20,20));
        JPanel mainPanel = new JPanel(new GridLayout(0, 1, 8, 8));
        //
        mainPanel.add(new PulRep(generador)); // Pul-Rep
        mainPanel.add(new JScrollPane()); // Trenes
        mainPanel.add(new JScrollPane()); // Modo

        mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JFrame frame = new JFrame("Farádicas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(mainPanel);

        frame.setLocationByPlatform(true);
        frame.pack();
        //frame.setSize(320,240);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new FaradicaApp());
    }

}
