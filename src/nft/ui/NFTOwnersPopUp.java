package nft.ui;

import nft.database.DatabaseConnectionHandler;
import nft.model.NFTOwns;
import java.awt.*;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



import java.awt.event.ActionEvent;


/* NFTOwners relation GUI with insert, delete, update, projection and selection methods */
public class NFTOwnersPopUp {
    private JFrame NFTOwnersFrame;
    private String table;
    private DatabaseConnectionHandler dHandler;


    public NFTOwnersPopUp() {
        NFTOwnersFrame = new JFrame();
        JPanel GUIPanel = new JPanel();
        dHandler = new DatabaseConnectionHandler();
        GUIPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        GUIPanel.setBackground(Color.lightGray);
        GUIPanel.setLayout(new GridLayout(20,20));
        NFTOwnersFrame.add(GUIPanel, BorderLayout.CENTER);
        NFTOwnersFrame.setSize(500, 500);
        NFTOwnersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NFTOwnersFrame.setTitle("Owners Table");
        NFTOwnersFrame.pack();
        NFTOwnersFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        insertDeleteActions(GUIPanel, NFTOwnersFrame);
        table = "nft_owns";
        projectionAction(GUIPanel,NFTOwnersFrame,table);
        selectionAction(GUIPanel, NFTOwnersFrame);
        NFTOwnersFrame.setVisible(true);
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
        JLabel tokenIDLabel = new JLabel("Please enter the tokenID: ");
        tokenIDLabel.setBounds(20, 90, 200, 25);
        panel.add(tokenIDLabel);

        JTextField tokenIDField = new JTextField(10);
        JTextField personIDField = new JTextField(10);
        JTextField tokenTypeField = new JTextField(10);


        tokenIDField.setBounds(110, 90, 165, 25);
        personIDField.setBounds(110, 90, 165, 25);
        personIDField.setBounds(110, 90, 165, 25);

        panel.add(tokenIDField);
        
        JLabel personIDLabel = new JLabel("Please enter the personID: ");
        panel.add(personIDLabel);
        panel.add(personIDField);

        JLabel tokenTypeLabel = new JLabel("Please enter the token type: ");
        panel.add(tokenTypeLabel);
        panel.add(tokenTypeField);

        String insertedTokenID = tokenIDField.getText();
        String insertedPersonID = personIDField.getText();
        String insertedTokenType = tokenTypeField.getText();

        JButton insertButton = new JButton("Insert");
        JButton deleteButton = new JButton("Delete");
        JButton updateButton = new JButton("Update");

        panel.add(insertButton);
        panel.add(deleteButton);
        panel.add(updateButton);
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NFTOwns newOwner = new NFTOwns(insertedTokenID, insertedPersonID, insertedTokenType);
                dHandler.insertNftOwns(newOwner);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dHandler.deleteNFTOwns(insertedTokenID);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dHandler.updateNFTOwns(insertedTokenID, insertedPersonID, insertedTokenType);
            }
        });
       
    }

}
