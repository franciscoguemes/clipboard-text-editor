package com.franciscoguemes.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(){
        this.setTitle("CTE - Clipboard Text Editor");
        this.setSize(800,600);
        this.setResizable(false);
        this.centerFrameOnScreen(0);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //TODO: Set an icon for this app
        // this.setIconImage();
        this.setVisible(true);
    }

    private void centerFrameOnScreen(int screen)
    {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] allDevices = env.getScreenDevices();
        int topLeftX, topLeftY, screenX, screenY, windowPosX, windowPosY;

        if (screen < allDevices.length && screen > -1)
        {
            topLeftX = allDevices[screen].getDefaultConfiguration().getBounds().x;
            topLeftY = allDevices[screen].getDefaultConfiguration().getBounds().y;

            screenX  = allDevices[screen].getDefaultConfiguration().getBounds().width;
            screenY  = allDevices[screen].getDefaultConfiguration().getBounds().height;
        }
        else
        {
            topLeftX = allDevices[0].getDefaultConfiguration().getBounds().x;
            topLeftY = allDevices[0].getDefaultConfiguration().getBounds().y;

            screenX  = allDevices[0].getDefaultConfiguration().getBounds().width;
            screenY  = allDevices[0].getDefaultConfiguration().getBounds().height;
        }

        windowPosX = ((screenX - this.getWidth())  / 2) + topLeftX;
        windowPosY = ((screenY - this.getHeight()) / 2) + topLeftY;

        this.setLocation(windowPosX, windowPosY);
    }

}
