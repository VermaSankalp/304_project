//package nft.ui;
//
//import javax.swing.*;
//import nft.database.DatabaseConnectionHandler;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//
///* Creates a the main page GUI. Here you get to choose which relation you want to modify */
//public class MainGUI {
//    private JFrame GUIFrame;
//    private  DatabaseConnectionHandler dHandler;
//
//
//    public MainGUI() {
//        dHandler = new DatabaseConnectionHandler();
//        GUIFrame = new JFrame();
//        JPanel GUIPanel = new JPanel();
//        GUIPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
//        GUIPanel.setBackground(Color.lightGray);
//        GUIPanel.setLayout(new GridLayout(20,20));
//
//        GUIFrame.setSize(500, 500);
//        GUIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        GUIFrame.setTitle("NFT Database");
//        GUIFrame.pack();
//        GUIFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        GUIFrame.setVisible(true);
//        JLabel chooseTable = new JLabel("Click on the database table you want to modify: ");
//        JButton NFTBuyers = new JButton("NFT Buyers");
//        JButton digitalContent = new JButton("NFT Digital Content");
//        JButton NFTOwners = new JButton("NFT Owners");
//        JButton collateralsTable = new JButton("NFT Collaterals");
//        JButton gamingTable = new JButton("NFT Gaming");
//
//        NFTBuyersButton(NFTBuyers);
//        NFTDigitalContentButton(digitalContent);
//        NFTOwnersButton(NFTOwners);
//        NFTCollateralsButton(collateralsTable);
//        NFTGamingButton(gamingTable);
//
//
//
//        GUIFrame.add(GUIPanel, BorderLayout.CENTER);
//        addToPanel(GUIPanel, chooseTable, NFTBuyers, digitalContent, NFTOwners, collateralsTable, gamingTable);
//
//        GUIFrame.setLocationRelativeTo(null);
//    }
//
//    private void NFTGamingButton(JButton gamingTable) {
//        gamingTable.setBounds(135, 250, 80, 25);
//        gamingTable.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                GUIFrame.dispose();
//                new NFTGamingPopUp();
//            }
//        });
//    }
//
//    private void NFTCollateralsButton(JButton collateralsTable) {
//        collateralsTable.setBounds(135, 250, 80, 25);
//        collateralsTable.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                GUIFrame.dispose();
//                new NFTCollateralsPopUp();
//            }
//        });
//    }
//
//    private void NFTOwnersButton(JButton nftOwners) {
//        nftOwners.setBounds(135, 250, 80, 25);
//        nftOwners.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                GUIFrame.dispose();
//                new NFTOwnersPopUp();
//            }
//        });
//    }
//
//    private void NFTDigitalContentButton(JButton digitalContent) {
//        digitalContent.setBounds(135, 250, 80, 25);
//        digitalContent.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                GUIFrame.dispose();
//                new NFTDigitalContentPopUp();
//            }
//        });
//    }
//
//    private void NFTBuyersButton(JButton NFTBuyers) {
//        NFTBuyers.setBounds(135, 250, 80, 25);
//        NFTBuyers.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                GUIFrame.dispose();
//                new NFTBuyersPopUp();
//            }
//        });
//
//    }
//
//    private void addToPanel(JPanel GUIPanel, JLabel chooseTable, JButton NFTBuyers, JButton digitalContent, JButton NFTOwners, JButton collateralsTable, JButton gamingTable) {
//        GUIPanel.add(chooseTable);
//        GUIPanel.add(NFTOwners);
//        GUIPanel.add(NFTBuyers);
//        GUIPanel.add(digitalContent);
//        GUIPanel.add(collateralsTable);
//        GUIPanel.add(gamingTable);
//    }
//
//
//    public static void main(String[] args) {
//        new MainGUI();
//    }
//}
//
