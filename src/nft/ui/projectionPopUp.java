package nft.ui;

import javax.swing.*;

import nft.database.DatabaseConnectionHandler;

import java.awt.*;
import java.util.ArrayList;

/* This class is responsible for handling relation Projection */
public class projectionPopUp {
  
    public projectionPopUp(ArrayList<String> columns, String table) {
        JFrame projFrame = new JFrame();
        JPanel projPanel = new JPanel();

        projPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        projPanel.setBackground(Color.lightGray);
        projPanel.setLayout(new GridLayout(20,20));
        projFrame.add(projPanel, BorderLayout.CENTER);

        projFrame.setSize(500, 500);
        projFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        projFrame.setTitle("Projection");
        projFrame.pack();
        projFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        projFrame.setVisible(true);
        addProjectionString(columns, projPanel, table);
    }


    private void addProjectionString(ArrayList<String> columns, JPanel panel, String table) {
        DatabaseConnectionHandler dHandler = new DatabaseConnectionHandler();
        String returned = dHandler.projection(table, columns);
        System.out.println(returned);
        JLabel stringLabel = new JLabel(returned);
        panel.add(stringLabel);
    }

    
}

