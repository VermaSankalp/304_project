package nft.ui;

import javax.swing.*;
import java.awt.*;

public class NFTGamingPopUp {
    private JFrame NFTGamingFrame;


    public NFTGamingPopUp() {
        NFTGamingFrame = new JFrame();
        JPanel GUIPanel = new JPanel();
        GUIPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        GUIPanel.setBackground(Color.lightGray);
        GUIPanel.setLayout(new GridLayout(20,20));

        NFTGamingFrame.setSize(500, 500);
        NFTGamingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NFTGamingFrame.setTitle("NFT Database");
        NFTGamingFrame.pack();
        NFTGamingFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        NFTBuyersFrame.setUndecorated(true);
        NFTGamingFrame.setVisible(true);

    }
}
