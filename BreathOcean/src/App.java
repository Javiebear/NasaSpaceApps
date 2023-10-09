import javax.swing.JFrame;
import java.lang.*;

public class App {
    public static void main(String[] args) throws Exception {

        //creating display

        JFrame screen = new JFrame();
        screen.setUndecorated(false);
        screen.setTitle("BreathingOcean");
        screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        screen.setResizable(false);

        screen.setSize(1290,700);
        screen.setFocusable(false);

        Mouse mouse = new Mouse();
        screen.getContentPane().addMouseListener(mouse);

        screen.setLocationRelativeTo(null); //where the window will pop up
        screen.setVisible(true);


        //game variables
        int boundX = 1290/30;
        int boundY = 700/20;
        int carbonFootPrint = 1;
        int population = 1;
        int range = 10;
        int plankton =0;
        int totalPlankton = 0;
        long time = System.currentTimeMillis();

        Game game = new Game(screen, 1290, 700);

        game.createMap();

        while(carbonFootPrint < 100){

        game.createGrid();

            game.drawHouse(population, boundX, boundY);


            if (mouse.getClick() && plankton < 7){
                mouse.click = false;
                game.drawPhytoplankton(mouse.getXPress(), mouse.getYPress(), boundX, boundY);
                plankton++;
                totalPlankton++;

            }

            if((System.currentTimeMillis() - time) > 5000){
                population = population + (int)(Math.random() * range) + 5;
                carbonFootPrint = population*3 - totalPlankton/2;
                time = System.currentTimeMillis();
                plankton = 0;                
            }

            System.out.println("the total carbon footprint: " + carbonFootPrint);
        }
        screen.dispose();

        System.out.println("The Global temperatures have risen and resulted in climate change");

    }
}
