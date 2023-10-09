import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Mouse extends MouseAdapter{
    int xPress;
    int yPress;

    boolean click = false;

    int xRel;
    int yRel;

    public void mouseClicked(MouseEvent e){
        this.click = true;
    }

    public void mousePressed(MouseEvent e){
        this.xPress= e.getX();
        this.yPress=e.getY();   
    }

    public void mouseReleased(MouseEvent e){
        this.xRel= e.getX();
        this.yRel=e.getY();
    }

    public int getXPress(){
        return this.xPress;
    }

    public int getYPress(){
        return this.yPress;
    }

    public boolean getClick(){
        return this.click;
    }

    public void setClick(){
        this.click = false;
    }

}
