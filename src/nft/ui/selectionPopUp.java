package nft.ui;

import javax.swing.*;

import nft.database.DatabaseConnectionHandler;
import nft.model.Buyers;

import java.awt.*;
import java.math.BigDecimal;

/* This class is responsible for handling relation Selection */
public class selectionPopUp {
    private String returnedString;
  
    public selectionPopUp(BigDecimal bid) {
        JFrame projFrame = new JFrame();
        JPanel projPanel = new JPanel();

        projPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        projPanel.setBackground(Color.lightGray);
        projPanel.setLayout(new GridLayout(20,20));
        projFrame.add(projPanel, BorderLayout.CENTER);

        projFrame.setSize(500, 500);
        projFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        projFrame.setTitle("Selection");
        projFrame.pack();
        projFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        projFrame.setVisible(true);
        addSelectionString(bid, projPanel);
    }


    private void addSelectionString(BigDecimal bid, JPanel panel) {
        DatabaseConnectionHandler dHandler = new DatabaseConnectionHandler();
        Buyers[] returned = dHandler.selectionBuyersWithBidsGreaterThan(bid);
        for (int i = 0; i < returned.length; i++) {
            returnedString = returned[i].getPersonID() + ", " + returned[i].getBuyerID() + ", " + returned[i].getCurrentBid() + "\n";
        }
        JLabel stringLabel = new JLabel(returnedString);
        panel.add(stringLabel);
    }

}




