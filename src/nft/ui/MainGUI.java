package nft.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates a system console that sets up a new driver with name, ID, licensePlate, and number of packages to deliver
 */
public class MainGUI {
    private JFrame GUIFrame;

    //getters
//    public Driver getDriver() {
//        return this.driverSetUp;
//    }

    //sets up and creates a new driver
    public MainGUI() {
        GUIFrame = new JFrame();
        JPanel GUIPanel = new JPanel();
        GUIPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        GUIPanel.setBackground(Color.lightGray);
        GUIPanel.setLayout(new GridLayout(20,20));

        GUIFrame.setSize(500, 500);
        GUIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUIFrame.setTitle("NFT Database");
        GUIFrame.pack();
        GUIFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        GUIFrame.setVisible(true);
        JLabel chooseTable = new JLabel("Click on the database table you want to modify: ");
        JButton NFTBuyers = new JButton("NFT Buyers");
        JButton digitalContent = new JButton("NFT Digital Content");
        JButton NFTOwners = new JButton("NFT Owners");
        JButton collateralsTable = new JButton("NFT Collaterals");
        JButton gamingTable = new JButton("NFT Gaming");

        NFTBuyersButton(NFTBuyers);
        NFTDigitalContentButton(digitalContent);
        NFTOwnersButton(NFTOwners);
        NFTCollateralsButton(collateralsTable);
        NFTGamingButton(gamingTable);



        GUIFrame.add(GUIPanel, BorderLayout.CENTER);
        addToPanel(GUIPanel, chooseTable, NFTBuyers, digitalContent, NFTOwners, collateralsTable, gamingTable);

        GUIFrame.setLocationRelativeTo(null);

//
//        String driverName = setUpDriverName(GUIPanel);
//        String driverID = setUpDriverID(GUIPanel);
//        String driverLicensePlate = setUpLicensePlate(GUIPanel);
//        JLabel welcomeMessage = new JLabel("Tranquility Deliver");
//        welcomeMessage.setBounds(93, 30, 200, 25);
//        welcomeMessage.setFont(welcomeMessage.getFont().deriveFont(20.0f));
//        GUIPanel.add(welcomeMessage);
//
//        driverSetUp = new Driver(driverName, driverID, driverLicensePlate);
//
//        signInButton(GUIPanel);
//
//        GUIFrame.setVisible(true);
    }

    private void NFTGamingButton(JButton gamingTable) {
        gamingTable.setBounds(135, 250, 80, 25);
        gamingTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIFrame.dispose();
                new NFTDigitalContentPopUp();
            }
        });
    }

    private void NFTCollateralsButton(JButton collateralsTable) {
        collateralsTable.setBounds(135, 250, 80, 25);
//        driverPanel.add(signIn);
        collateralsTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIFrame.dispose();
                new NFTDigitalContentPopUp();
            }
        });
    }

    private void NFTOwnersButton(JButton nftOwners) {
        nftOwners.setBounds(135, 250, 80, 25);
//        driverPanel.add(signIn);
        nftOwners.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIFrame.dispose();
                new NFTDigitalContentPopUp();
            }
        });
    }

    private void NFTDigitalContentButton(JButton digitalContent) {
        digitalContent.setBounds(135, 250, 80, 25);
//        driverPanel.add(signIn);
        digitalContent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIFrame.dispose();
                new NFTDigitalContentPopUp();
            }
        });
    }

    private void NFTBuyersButton(JButton NFTBuyers) {
        NFTBuyers.setBounds(135, 250, 80, 25);
//        driverPanel.add(signIn);
        NFTBuyers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIFrame.dispose();
                new NFTCollateralsPopUp();
            }
        });

    }

    private void addToPanel(JPanel GUIPanel, JLabel chooseTable, JButton NFTBuyers, JButton digitalContent, JButton NFTOwners, JButton collateralsTable, JButton gamingTable) {
        GUIPanel.add(chooseTable);
        GUIPanel.add(NFTOwners);
        GUIPanel.add(NFTBuyers);
        GUIPanel.add(digitalContent);
        GUIPanel.add(collateralsTable);
        GUIPanel.add(gamingTable);
    }

//
//    //MODIFIES: this
//    //EFFECTS: sets up driverName field
//    private String setUpDriverName(JPanel driverPanel) {
//        JLabel nameLabel = new JLabel("Driver name: ");
//        nameLabel.setBounds(20, 90, 200, 25);
//        driverPanel.add(nameLabel);
//        JTextField nameField = new JTextField(20);
//        nameField.setBounds(110, 90, 165, 25);
//        driverPanel.add(nameField);
//        String driverName = nameField.getText();
//        return driverName;
//    }
//
//    //MODIFIES: this
//    //EFFECTS: sets up driverID field
//    private String setUpDriverID(JPanel driverPanel) {
//        JLabel idLabel = new JLabel("Driver ID: ");
//        idLabel.setBounds(20, 145, 200, 25);
//        driverPanel.add(idLabel);
//        JTextField idField = new JTextField(5);
//        idField.setBounds(110, 145, 165, 25);
//        String driverID = idField.getText();
//        driverPanel.add(idField);
//        return driverID;
//    }
//
//    //MODIFIES: this
//    //EFFECTS: sets up driverLicensePlate field
//    private String setUpLicensePlate(JPanel driverPanel) {
//        JLabel licenseLabel = new JLabel("License plate: ");
//        licenseLabel.setBounds(20, 200, 200, 25);
//        driverPanel.add(licenseLabel);
//        JTextField licenseField = new JTextField(10);
//        licenseField.setBounds(110, 200, 165, 25);
//        String driverLicensePlate = licenseField.getText();
//        driverPanel.add(licenseField);
//        return driverLicensePlate;
//    }
//
//    //EFFECTS: when signIn button clicked, starts a new TranquilityDeliveryAppGUI
//    private void signInButton(JPanel driverPanel) {
//        JButton signIn = new JButton("Sign in");
//        signIn.setBounds(135, 250, 80, 25);
//        driverPanel.add(signIn);
//        signIn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                driverFrame.dispose();
//                new NumberOfPackagesPopUp(driverSetUp);
//            }
//        });
//
//    }

    public static void main(String[] args) {
        new MainGUI();
    }
}

