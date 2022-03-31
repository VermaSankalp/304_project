package nft.ui;

import javax.swing.*;


import nft.database.DatabaseConnectionHandler;
import nft.model.Buyers;
import java.awt.*;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/* NFTBuyers relation GUI with insert, delete, update, division, projection and selection methods */
public class NFTBuyersPopUp {
    private JFrame NFTBuyersFrame;
    private String table;
    private DatabaseConnectionHandler dHandler;

    public NFTBuyersPopUp() {
        NFTBuyersFrame = new JFrame();
        JPanel GUIPanel = new JPanel();
        dHandler = new DatabaseConnectionHandler();
        GUIPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        GUIPanel.setBackground(Color.lightGray);
        GUIPanel.setLayout(new GridLayout(20,20));
        NFTBuyersFrame.add(GUIPanel, BorderLayout.CENTER);
        NFTBuyersFrame.setSize(500, 500);
        NFTBuyersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NFTBuyersFrame.setTitle("Buyers Table");
        NFTBuyersFrame.pack();
        NFTBuyersFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        table = "buyers";
        insertDeleteActions(GUIPanel, NFTBuyersFrame);
        projectionAction(GUIPanel,NFTBuyersFrame, table);
        selectionAction(GUIPanel, NFTBuyersFrame);
        divisionAction(GUIPanel, NFTBuyersFrame);
        NFTBuyersFrame.setVisible(true);
    }

    private void divisionAction(JPanel panel, JFrame frame) {
        JLabel projLabel = new JLabel("Show all buyers that own NFT's: ");
        projLabel.setBounds(20, 90, 200, 25);
        panel.add(projLabel);
        

        JButton submitDivision = new JButton("Submit");
        panel.add(submitDivision);
        submitDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new divisionPopUp();
            }
        });
    }


    private void projectionAction(JPanel panel, JFrame frame, String table) {
        JLabel projLabel = new JLabel("Please enter the column you want to project: ");
        projLabel.setBounds(20, 90, 200, 25);
        panel.add(projLabel);
        
        JTextField chooseColumn = new JTextField(10);
        panel.add(chooseColumn);

        String chosenColumn = chooseColumn.getText();
        ArrayList<String> columns = new ArrayList<String>();
        columns.add(chosenColumn);


        JButton submitProj = new JButton("Submit");
        panel.add(submitProj);
        submitProj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new projectionPopUp(columns,table);
            }
        });

    }


    private void selectionAction(JPanel panel, JFrame frame) {
        JLabel selectionLabel = new JLabel("Please enter the bid you want to view tuples with bids greater than it: ");
        selectionLabel.setBounds(20, 90, 200, 25);
        panel.add(selectionLabel);

        JTextField chooseBid = new JTextField(10);
        panel.add(chooseBid);
        String chosenBid = chooseBid.getText();

        JButton submitProj = new JButton("Submit");
        panel.add(submitProj);
        submitProj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                BigDecimal inputBigDecimal = new BigDecimal(chosenBid);
                new selectionPopUp(inputBigDecimal);
            }
        });

    }


    private void insertDeleteActions(JPanel panel, JFrame frame) {
        JLabel personIDLabel = new JLabel("Please enter the personID: ");
        personIDLabel.setBounds(20, 90, 200, 25);
        panel.add(personIDLabel);

        JTextField personIDField = new JTextField(10);
        JTextField buyerIDField = new JTextField(10);
        JTextField currentBiField = new JTextField(10);

        personIDField.setBounds(110, 90, 165, 25);
        buyerIDField.setBounds(110, 90, 165, 25);
        buyerIDField.setBounds(110, 90, 165, 25);

        panel.add(personIDField);
        
        JLabel buyerIDLabel = new JLabel("Please enter the BuyerID: ");
        panel.add(buyerIDLabel);
        panel.add(buyerIDField);

        JLabel bidLabel = new JLabel("Please enter the current bid placed: ");
        panel.add(bidLabel);
        panel.add(currentBiField);

        String insertedPersonID = personIDField.getText();
        String insertedBuyerID = buyerIDField.getText();
        String insertedBid = currentBiField.getText();

        JButton insertButton = new JButton("Insert");
        JButton deleteButton = new JButton("Delete");
        JButton updateButton = new JButton("Update");

        panel.add(insertButton);
        panel.add(deleteButton);
        panel.add(updateButton);

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Buyers newBuyer = new Buyers(insertedPersonID, insertedBuyerID, new BigDecimal(insertedBid));
                dHandler.insertBuyers(newBuyer);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dHandler.deleteBuyers(insertedPersonID);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dHandler.updateBuyers(insertedPersonID, insertedBuyerID, new BigDecimal(insertedBid));
            }
        });
    }
}
