package nft.ui;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class NFTDigitalContentPopUp {
    private JFrame NFTBuyersFrame;


    public NFTDigitalContentPopUp() {
        NFTBuyersFrame = new JFrame();
        JPanel GUIPanel = new JPanel();
        GUIPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        GUIPanel.setBackground(Color.lightGray);
        GUIPanel.setLayout(new GridLayout(20,20));

        NFTBuyersFrame.setSize(500, 500);
        NFTBuyersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NFTBuyersFrame.setTitle("NFT Database");
        NFTBuyersFrame.pack();
        NFTBuyersFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        NFTBuyersFrame.setVisible(true);

    }
}
