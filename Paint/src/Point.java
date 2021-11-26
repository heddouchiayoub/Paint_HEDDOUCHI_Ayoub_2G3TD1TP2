import java.io.Serializable;

public class Point implements Serializable {
    protected int X, Y;
    public Point (){
        X=0;
        Y=0;
    }
    public Point(int X,int Y){
        this.X=X;
        this.Y=Y;
    }
    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
    @Override
    public String toString(){
        return "("+X+","+Y+")";
    }
}
