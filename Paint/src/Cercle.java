import java.awt.*;

import static java.lang.Math.PI;


public class Cercle extends Ellipse {

    public Cercle(Color C){super(C);}

    public Cercle(int SemiAxysX) {
        super(SemiAxysX, SemiAxysX);
    }

    public Cercle(int px, int py, Color C) {
        super(px, py, C);
    }

    public void setBoundingBox(int heightBB, int widthBB) {
        this.SemiAxysX = Math.min(heightBB, widthBB);
        this.SemiAxysY = Math.min(heightBB, widthBB);
    }

    public int getDiametre() {
        return SemiAxysX;
    }

    public double getPerimeter() {
        return SemiAxysX * PI;
    }

    public double getSurface() {
        return Math.pow(PI * (SemiAxysX / 2), 2);
    }
}


