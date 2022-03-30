package nft.ui;

import javax.swing.*;

import nft.database.DatabaseConnectionHandler;
import nft.model.Buyers;

import java.awt.*;
import java.util.ArrayList;

public class divisionPopUp {
    private String returnedBuyers;
  
    public divisionPopUp() {
        JFrame projFrame = new JFrame();
        JPanel projPanel = new JPanel();

        projPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        projPanel.setBackground(Color.lightGray);
        projPanel.setLayout(new GridLayout(20,20));
        projFrame.add(projPanel, BorderLayout.CENTER);

        projFrame.setSize(500, 500);
        projFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        projFrame.setTitle("Division");
        projFrame.pack();
        projFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        projFrame.setVisible(true);
        addDivisionString(projPanel);
    }


    private void addDivisionString(JPanel panel) {
        DatabaseConnectionHandler dHandler = new DatabaseConnectionHandler();
        Buyers[] returned = dHandler.divisionAllBuyersWithCurrentBid();
        for (int i=0; i<returned.length; i++) {
            returnedBuyers = returned[i].getPersonID() + "\n";
        }
        JLabel stringLabel = new JLabel(returnedBuyers);
        panel.add(stringLabel);
    }
}


