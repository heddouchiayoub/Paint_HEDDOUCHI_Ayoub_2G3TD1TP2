import java.awt.*;
import java.io.Serializable;


    public abstract class Figure implements Serializable {
    protected Color C;
    protected Point origin;

        public Figure(Point P, Color C) {
            this.origin = P;
            this.C = C;
        }

    @Override
    public String toString(){
        return "Rectangle :  ("+origin.getX()+","+origin.getY()+")";
    }

    public abstract double getPerimeter();
    public abstract double getSurface();
    public void setColor(Color color){this.C=color;}
    public void setorigin(Point P){this.origin=P;}
    public abstract void setBoundingBox(int heightBB, int widthBB);
    public abstract void draw(Graphics g);
        }