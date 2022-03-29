package nft.ui;

import javax.swing.*;
import java.awt.*;

public class NFTOwnersPopUp {
    private JFrame NFTOwnersFrame;


    public NFTOwnersPopUp() {
        NFTOwnersFrame = new JFrame();
        JPanel GUIPanel = new JPanel();
        GUIPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        GUIPanel.setBackground(Color.lightGray);
        GUIPanel.setLayout(new GridLayout(20,20));

        NFTOwnersFrame.setSize(500, 500);
        NFTOwnersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NFTOwnersFrame.setTitle("NFT Database");
        NFTOwnersFrame.pack();
        NFTOwnersFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        NFTOwnersFrame.setVisible(true);

    }
}
