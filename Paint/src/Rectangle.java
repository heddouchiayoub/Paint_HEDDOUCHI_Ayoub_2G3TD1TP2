import java.awt.*;

public class Rectangle extends Figure {
    int px;
    int py;
    protected int length;
    protected int width;

    public Rectangle (Color C){super(new Point(0,0),C);}

    public Rectangle (int a, int b){
        super(new Point(0,0),Color.black);
        this.length=a;
        this.width=b;
    }

    public Rectangle(int px, int py, Color C){
        super(new Point(px,py),C);
        this.length=0;
        this.width=0;
    }
    @Override
    public String toString(){
       return "Rectangle d'origine :"+origin + "de longueur :"+length+ "et de largeur "+width;
    }
    public void setBoundingBox(int heightBB, int widthBB) {
        this.length = heightBB;
        this.width = widthBB;
    }

    public void draw(Graphics g){
        g.setColor(C);
        g.fillRect(origin.getX(),origin.getY(),length,width);
    }
    public double getPerimeter(){return 2*length+2*width;}
    public double getSurface(){return length*width;}
    public int getLength(){return length;}
    public int getWidth(){return width;}

    public void setLength(int length){
        length=length;
    }
    public void setWidth(int width){width=width;}
}





