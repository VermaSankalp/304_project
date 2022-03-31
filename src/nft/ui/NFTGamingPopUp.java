package nft.ui;

import javax.swing.*;
import nft.database.DatabaseConnectionHandler;
import nft.model.Gaming;
import java.awt.*;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


/* NFTGaming relation GUI with insert, delete, update, projection and selection methods */
public class NFTGamingPopUp {
    private JFrame NFTBuyersFrame;
    private String table;
    private DatabaseConnectionHandler dHandler;

    public NFTGamingPopUp() {
        NFTBuyersFrame = new JFrame();
        JPanel GUIPanel = new JPanel();
        dHandler = new DatabaseConnectionHandler();
        GUIPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        GUIPanel.setBackground(Color.lightGray);
        GUIPanel.setLayout(new GridLayout(20,20));
        NFTBuyersFrame.add(GUIPanel, BorderLayout.CENTER);
        NFTBuyersFrame.setSize(500, 500);
        NFTBuyersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NFTBuyersFrame.setTitle("Gaming Table");
        NFTBuyersFrame.pack();
        NFTBuyersFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        table = "gaming";
        insertDeleteActions(GUIPanel, NFTBuyersFrame);
        projectionAction(GUIPanel,NFTBuyersFrame, table);
        selectionAction(GUIPanel, NFTBuyersFrame);
        NFTBuyersFrame.setVisible(true);
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
                /* need to add projection method here, after they finish implementing that */
            }
        });

    }


    private void insertDeleteActions(JPanel panel, JFrame frame) {
        JLabel tokenIDLabel = new JLabel("Please enter the tokenID: ");
        tokenIDLabel.setBounds(20, 90, 200, 25);
        panel.add(tokenIDLabel);

        JTextField tokenIDField = new JTextField(10);
        panel.add(tokenIDField);

        JTextField gameIDField = new JTextField(10);
        JTextField publisherField = new JTextField(10);



        tokenIDField.setBounds(110, 90, 165, 25);
        publisherField.setBounds(110, 90, 165, 25);
        
        JLabel gameIDLabel = new JLabel("Please enter the game ID: ");
        panel.add(gameIDLabel);
        panel.add(gameIDField);

        JLabel publisherLabel = new JLabel("Please enter publisher: ");
        panel.add(publisherLabel);
        panel.add(publisherField);

        String insertedTokenID = tokenIDField.getText();
        String insertedgameID = gameIDField.getText();
        String insertedPublisher = publisherField.getText();

        

        JButton insertButton = new JButton("Insert");
        JButton deleteButton = new JButton("Delete");
        JButton updateButton = new JButton("Update");

        panel.add(insertButton);
        panel.add(deleteButton);
        panel.add(updateButton);

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gaming newGaming = new Gaming(insertedTokenID, insertedgameID, insertedPublisher);
                dHandler.insertGaming(newGaming);

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dHandler.deleteGaming(insertedTokenID);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dHandler.updateGaming(insertedTokenID, insertedgameID, insertedPublisher);
            }
        });
       
    }
}


