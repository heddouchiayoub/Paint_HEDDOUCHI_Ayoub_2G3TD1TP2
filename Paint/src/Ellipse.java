import java.awt.*;
import java.lang.Math;


public class Ellipse extends Figure {
    int SemiAxysX;
    int SemiAxysY;

    public Ellipse (Color C){super(new Point(0,0),C);}

    public Ellipse (int a, int b) {super(new Point(a,b),Color.black);}

    public Ellipse (int px, int py, Color c) {
        super(new Point(px,py), c);
    }

    public void setBoundingBox(int heightBB, int widthBB) {
        SemiAxysX = heightBB;
        SemiAxysY = widthBB;
    }

    public void draw(Graphics g){
        g.setColor(this.C);
        g.fillOval(origin.getX(),origin.getY(),SemiAxysX,SemiAxysY);
    }
    public double getPerimeter(){return 2*Math.PI*Math.sqrt((SemiAxysX*SemiAxysX + SemiAxysY*SemiAxysY)/2);}
    public double getSurface(){return Math.PI*SemiAxysY*SemiAxysX/4;}
    public int getSemiAxysX(){return this.SemiAxysX;}
    public int getSemiAxysY(){return this.SemiAxysY;}

    @Override
    public String toString(){
        return "l'ellipse d'origine :"+origin + "de rayon d'abscisses :"+SemiAxysX+ "et de rayon d'ordonnées  "+SemiAxysY;
    }


}
