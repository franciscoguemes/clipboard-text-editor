package com.franciscoguemes.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class MainFrame extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;

    private final JButton operateLeft;
    private final JButton operateRight;

    private JTextArea leftTextArea;
    private JTextArea rightTextArea;

    public MainFrame() {

        JPanel contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        contentPanel.setLayout(null);
        int centerWidth = getParentWidthPercentage(0.2);
        int upperGap = getParentHeightPercentage(0.05);
        int textWidth = getParentWidthPercentage(0.4);
        int textHeight = getParentHeightPercentage(0.9);
        leftTextArea = new JTextArea();
        rightTextArea = new JTextArea();
        JScrollPane leftScroll = new JScrollPane(leftTextArea);
        JScrollPane rightScroll = new JScrollPane(rightTextArea);

        leftScroll.setBounds(0, upperGap, textWidth, textHeight);
        rightScroll.setBounds(textWidth + centerWidth, upperGap, textWidth, textHeight);

        String[] operations = {"Text to column", "Column to text", "Remove empty lines"};

        JComboBox leftOperations = new JComboBox(operations);
        leftOperations.setBounds(getParentWidthPercentage(0.4),getParentHeightPercentage(0.35),getParentWidthPercentage(0.2),getParentHeightPercentage(0.05));
        operateLeft = new JButton(">>>");
        operateLeft.setBounds(getParentWidthPercentage(0.4),getParentHeightPercentage(0.4),getParentWidthPercentage(0.2),getParentHeightPercentage(0.05));
        operateLeft.addActionListener(e -> rightTextArea.setText(leftTextArea.getText()));
        JComboBox rightOperations = new JComboBox(operations);
        rightOperations.setBounds(getParentWidthPercentage(0.4),getParentHeightPercentage(0.75),getParentWidthPercentage(0.2),getParentHeightPercentage(0.05));
        operateRight = new JButton("<<<");
        operateRight.setBounds(getParentWidthPercentage(0.4),getParentHeightPercentage(0.8),getParentWidthPercentage(0.2),getParentHeightPercentage(0.05));
        operateRight.addActionListener(e -> leftTextArea.setText(rightTextArea.getText()));

        try {
            String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            leftTextArea.setText(data);
        } catch (UnsupportedFlavorException | IOException e) {
            System.err.println("It was not possible to read the contents of the clipboard");
        }


        contentPanel.add(leftScroll);
        contentPanel.add(leftOperations);
        contentPanel.add(operateLeft);
        contentPanel.add(rightOperations);
        contentPanel.add(operateRight);
        contentPanel.add(rightScroll);


        this.setTitle("CTE - Clipboard Text Editor");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setSize(WIDTH,HEIGHT);
        this.setResizable(false);
        //TODO: Set an icon for this app
        // this.setIconImage();
        this.setContentPane(contentPanel);
        this.pack();
        this.centerFrameOnScreen(0);
        this.setVisible(true);
    }

    private void centerFrameOnScreen(int screen) {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] allDevices = env.getScreenDevices();
        int topLeftX, topLeftY, screenX, screenY, windowPosX, windowPosY;

        if (screen < allDevices.length && screen > -1) {
            topLeftX = allDevices[screen].getDefaultConfiguration().getBounds().x;
            topLeftY = allDevices[screen].getDefaultConfiguration().getBounds().y;

            screenX = allDevices[screen].getDefaultConfiguration().getBounds().width;
            screenY = allDevices[screen].getDefaultConfiguration().getBounds().height;
        } else {
            topLeftX = allDevices[0].getDefaultConfiguration().getBounds().x;
            topLeftY = allDevices[0].getDefaultConfiguration().getBounds().y;

            screenX = allDevices[0].getDefaultConfiguration().getBounds().width;
            screenY = allDevices[0].getDefaultConfiguration().getBounds().height;
        }

        windowPosX = ((screenX - this.getWidth()) / 2) + topLeftX;
        windowPosY = ((screenY - this.getHeight()) / 2) + topLeftY;

        this.setLocation(windowPosX, windowPosY);
    }

    private int getParentWidthPercentage(double percentage) {
        return (int) (WIDTH * percentage);
    }

    private int getParentHeightPercentage(double percentage) {
        return (int) (HEIGHT * percentage);
    }

}
