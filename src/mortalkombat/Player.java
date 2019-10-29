/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortalkombat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Player {

    private int id;
    public int x= 50;
    public int y= 50;
    public int w= 90;
    public int h = 127;
    public boolean btR = false;
    public boolean btL = false;
    public boolean btU = false;
    public boolean btD = false;
    public boolean dirR = true;
    
    public PrintWriter out;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

