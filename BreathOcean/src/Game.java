import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.lang.*;

public class Game extends JFrame{
    JFrame screen;
    int width;
    int height;

    public Game(JFrame screen, int width, int height){
        this.screen = screen;
        this.width = width;
        this.height = height;
    }

    public void createGrid(){
        Graphics g = screen.getGraphics();

        //grid widths
        int x = width/30;
        int y = height/20;

        g.setColor(Color.BLACK);
        for(int i = 0; i < x;i++ ){
                g.drawLine(x*i, 0, x*i, height); // draws lines going up and down
                g.drawLine(0, y*i, width, y*i); // draws the lines going left to right
        }

        g.setColor(Color.GREEN);
        g.fillRect(0, 0, x, y);
        g.dispose();
    }

    //creatig the map
    public void createMap(){
        Graphics g = screen.getGraphics();
        
        //grid widths
        int x = width/30;
        int y = height/20;

        for(int i = 0; i < x;i++ ){
            for(int j = 0; j<y; j++){
                if (j <= 8){
                    g.setColor(Color.GREEN);
                    g.fillRect(i*x, j*y, x, y); 
                }else{
                    g.setColor(Color.BLUE);
                    g.fillRect(i*x, j*y, x, y); 
                }
            }
        }


    }

    public void drawPhytoplankton(int x, int y, int width, int height){
        Graphics g = screen.getGraphics();


        int rectX = x/width;
        int rectY = y/height;

        if(rectY > 7){
            g.setColor(Color.BLACK);
            g.fillRect(rectX*width + 3,(rectY*height)+height+3,width-6,height-6);
        }

    }

    public void drawHouse(int houses, int width, int height){
        Graphics g = screen.getGraphics();
        int count = 0;

        //grid widths


        g.setColor(Color.WHITE);
        for(int i = 0; i < 30;i++ ){
            for(int j = 0; j<= 8; j++){
                if (j <= 8 && count < houses){
                    g.fillRect(i*width+3 , j*height+3, width-6, height-6);
                    count++;
                }
            }
        }
    }

}
