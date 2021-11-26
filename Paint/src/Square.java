import java.awt.*;


public class Square extends Rectangle {

    public Square(Color C){super(C);}

    public Square(int px, int py, Color C) {
        super(px, py, C);
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setBoundingBox(int heightBB, int widthBB) {

        this.length = Math.min(heightBB, widthBB);
        this.width = Math.min(heightBB, widthBB);
    }
}
