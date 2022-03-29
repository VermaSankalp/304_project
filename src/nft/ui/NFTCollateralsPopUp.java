package nft.ui;

import javax.swing.*;
import java.awt.*;

public class NFTCollateralsPopUp {
    private JFrame NFTCollateralsFrame;


    public NFTCollateralsPopUp() {
        NFTCollateralsFrame = new JFrame();
        JPanel GUIPanel = new JPanel();
        GUIPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        GUIPanel.setBackground(Color.lightGray);
        GUIPanel.setLayout(new GridLayout(20,20));

        NFTCollateralsFrame.setSize(500, 500);
        NFTCollateralsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NFTCollateralsFrame.setTitle("NFT Database");
        NFTCollateralsFrame.pack();
        NFTCollateralsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        NFTBuyersFrame.setUndecorated(true);
        NFTCollateralsFrame.setVisible(true);

    }
}
