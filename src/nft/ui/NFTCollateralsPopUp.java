//package nft.ui;
//
//import javax.swing.*;
//
//import nft.database.DatabaseConnectionHandler;
//import nft.model.Collaterals;
//import java.awt.*;
//import java.awt.event.ActionListener;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.awt.event.ActionEvent;
//
//
///* NFTCollaterals relation GUI with insert, delete, update, projection and selection methods */
//public class NFTCollateralsPopUp {
//    private JFrame NFTBuyersFrame;
//    private String table;
//    private DatabaseConnectionHandler dHandler;
//
//    public NFTCollateralsPopUp() {
//        NFTBuyersFrame = new JFrame();
//        JPanel GUIPanel = new JPanel();
//        dHandler = new DatabaseConnectionHandler();
//        GUIPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
//        GUIPanel.setBackground(Color.lightGray);
//        GUIPanel.setLayout(new GridLayout(20,20));
//        NFTBuyersFrame.add(GUIPanel, BorderLayout.CENTER);
//        NFTBuyersFrame.setSize(500, 500);
//        NFTBuyersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        NFTBuyersFrame.setTitle("Collaterals Table");
//        NFTBuyersFrame.pack();
//        NFTBuyersFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        table = "collaterals";
//        insertDeleteActions(GUIPanel, NFTBuyersFrame);
//        projectionAction(GUIPanel,NFTBuyersFrame, table);
//        selectionAction(GUIPanel, NFTBuyersFrame);
//        NFTBuyersFrame.setVisible(true);
//    }
//
//
//    private void projectionAction(JPanel panel, JFrame frame, String table) {
//        JLabel projLabel = new JLabel("Please enter the column you want to project: ");
//        projLabel.setBounds(20, 90, 200, 25);
//        panel.add(projLabel);
//
//        JTextField chooseColumn = new JTextField(10);
//        panel.add(chooseColumn);
//
//        String chosenColumn = chooseColumn.getText();
//        ArrayList<String> columns = new ArrayList<String>();
//        columns.add(chosenColumn);
//
//
//        JButton submitProj = new JButton("Submit");
//        panel.add(submitProj);
//        submitProj.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.dispose();
//                new projectionPopUp(columns,table);
//            }
//        });
//
//    }
//
//
//    private void selectionAction(JPanel panel, JFrame frame) {
//        JLabel selectionLabel = new JLabel("Please enter the bid you want to view tuples with bids greater than it: ");
//        selectionLabel.setBounds(20, 90, 200, 25);
//        panel.add(selectionLabel);
//
//        JTextField chooseBid = new JTextField(10);
//        panel.add(chooseBid);
//        String chosenBid = chooseBid.getText();
//
//        JButton submitProj = new JButton("Submit");
//        panel.add(submitProj);
//        submitProj.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.dispose();
//                BigDecimal inputBigDecimal = new BigDecimal(chosenBid);
//                new selectionPopUp(inputBigDecimal);
//                /* need to add projection method here, after they finish implementing that */
//            }
//        });
//
//    }
//
//
//    private void insertDeleteActions(JPanel panel, JFrame frame) {
//        JLabel tokenIDLabel = new JLabel("Please enter the tokenID: ");
//        tokenIDLabel.setBounds(20, 90, 200, 25);
//        panel.add(tokenIDLabel);
//
//        JTextField tokenIDField = new JTextField(10);
//        panel.add(tokenIDField);
//
//        JTextField tokenTypeField = new JTextField(10);
//        JTextField loaneeField = new JTextField(10);
//        JTextField loanerField = new JTextField(10);
//        JTextField tokenRateField = new JTextField(10);
//
//
//        tokenIDField.setBounds(110, 90, 165, 25);
//        tokenTypeField.setBounds(110, 90, 165, 25);
//        tokenTypeField.setBounds(110, 90, 165, 25);
//        loanerField.setBounds(110, 90, 165, 25);
//        tokenRateField.setBounds(110, 90, 165, 25);
//
//
//
//        JLabel tokenTypeLabel = new JLabel("Please enter the tokenType: ");
//        panel.add(tokenTypeLabel);
//        panel.add(tokenTypeField);
//
//        JLabel loaneeLabel = new JLabel("Please enter loanee: ");
//        panel.add(loaneeLabel);
//        panel.add(loaneeField);
//
//        JLabel loanerLabel = new JLabel("Please enter loaner: ");
//        panel.add(loanerLabel);
//        panel.add(loanerField);
//
//        JLabel tokenRateLabel = new JLabel("Please enter token rate: ");
//        panel.add(tokenRateLabel);
//        panel.add(tokenRateField);
//
//
//        String insertedTokenID = tokenIDField.getText();
//        String insertedTokenType = tokenTypeField.getText();
//        String insertedLoanee = loaneeField.getText();
//        String insertedLoanerString = loanerField.getText();
//        String insertedTokenRate = tokenRateField.getText();
//
//
//        JButton insertButton = new JButton("Insert");
//        JButton deleteButton = new JButton("Delete");
//        JButton updateButton = new JButton("Update");
//
//        panel.add(insertButton);
//        panel.add(deleteButton);
//        panel.add(updateButton);
//
//        insertButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Collaterals newCollaterals = new Collaterals(insertedTokenID, insertedTokenType, insertedLoanee,insertedLoanerString,new BigDecimal(insertedTokenRate));
//                dHandler.insertCollaterals(newCollaterals);
//            }
//        });
//        deleteButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dHandler.deleteCollaterals(insertedTokenID);
//            }
//        });
//        updateButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dHandler.updateCollaterals(insertedTokenID, insertedTokenType, insertedLoanee, insertedLoanerString,new BigDecimal(insertedTokenRate));
//            }
//        });
//    }
//}
//
