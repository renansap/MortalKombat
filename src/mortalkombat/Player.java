/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortalkombat;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Ksa
 */
public class Player extends JLabel {

    public int x = 0, y = 0;
    ImageIcon walkL;
    ImageIcon walkR;
    ImageIcon walkU;
    ImageIcon walkD;
    ImageIcon stoppedD; //Parada Direita
    ImageIcon stoppedE;//Parada Esquerda

    public void setup() {
        setText("12");

        stoppedD = new ImageIcon(new ImageIcon(getClass().getResource("p_d.gif")).getImage().getScaledInstance(88, 127, Image.SCALE_DEFAULT));
        stoppedE = new ImageIcon(new ImageIcon(getClass().getResource("p_e.gif")).getImage().getScaledInstance(88, 127, Image.SCALE_DEFAULT));

        walkR = new ImageIcon(new ImageIcon(getClass().getResource("c_d.gif")).getImage().getScaledInstance(88, 127, Image.SCALE_DEFAULT));
        walkL = new ImageIcon(new ImageIcon(getClass().getResource("c_e.gif")).getImage().getScaledInstance(88, 127, Image.SCALE_DEFAULT));

        setBounds(x, y, 90, 127);
        setIcon(walkR);
    }

//    private boolean excedeuAreaDaTela(int posX, int posY) {
//        return posX < 0 || posX + 180 > 750 || posY < 0 || posY + 90 > 700;
//    }
    public void move() {

        if (x > 0) { //####renan#### implementado limite de largura da esquerda
            setBounds(x, y, 90, 127);
            System.out.println("X" + x);
            System.out.println("Y" + y);

        } else {
            x = 0;
            setBounds(x, y, 90, 127);

        }
        if (x < 696) { //####renan#### implementado limite de largura da direita
            setBounds(x, y, 90, 127);
            System.out.println("X" + x);
            System.out.println("Y" + y);

        } else {
            x = 696;
            setBounds(x, y, 90, 127);

        }

        if (y > 0) { //####renan#### implementado limite de altura pra cima
            setBounds(x, y, 90, 127);
            System.out.println("X" + x);
            System.out.println("Y" + y);

        } else {
            y = 0;
            setBounds(x, y, 90, 127);

        }
        if (y < 432) { //####renan#### implementado limite de largura pra baixo
            setBounds(x, y, 90, 127);
            System.out.println("X" + x);
            System.out.println("Y" + y);

        } else {
            y = 432;
            setBounds(x, y, 90, 127);

        }

//        setBounds(x, y, 90, 127);
//        System.out.println("X"+x);
//        System.out.println("Y"+y);
    }

    public void setIconRight() {
        setIcon(walkR);
    }

    public void setIconLeft() {
        setIcon(walkL);
    }

    public void setIconStoppedD() {
        setIcon(stoppedD);
    }

    public void setIconStoppedE() {
        setIcon(stoppedE);
    }

}
