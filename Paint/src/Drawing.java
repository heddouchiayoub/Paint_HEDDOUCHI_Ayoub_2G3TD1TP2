import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;


public class Drawing extends JPanel implements MouseMotionListener,MouseListener{
    Color color;
    Figure figure;
    String figureName;
    ArrayList<Figure> liste;
    int X;
    int Y;


    public Drawing() {

        super();
        color=Color.black;
        figureName="Rectangle";
        figure =new Rectangle(0,0);
        liste = new ArrayList<Figure>();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.white);
        for (Figure f: liste){f.draw(g);}
    }

    public void setColor(Color color){this.color=color;}

    public void setFigure(Figure figure){this.figure=figure;}
    public void setFigureName(String figureName){this.figureName=figureName;}
    public Figure getFigure(){return this.figure;}
    public Color getColor(){return this.color;}
    public String getFigureName(){return this.figureName;}
    public ArrayList<Figure> getList(){return liste;}


    public void mouseDragged(MouseEvent e){
        int dX=Math.abs(e.getX()-X);
        int dY=Math.abs(e.getY()-Y);
        figure.setBoundingBox(dX, dY);
        repaint();
        if(figureName=="Cercle" | figureName=="Square"){
            if (e.getX() < X){
                figure.setorigin(new Point(Math.max(X-dY,e.getX()),Y));
            }
            if (e.getY() < Y){
                figure.setorigin(new Point(X,Math.max(Y-dX,e.getY())));
            }
            if (e.getX() < X && e.getY() < Y){
                figure.setorigin(new Point(Math.max(X-dY,e.getX()),Math.max(Y-dX,e.getY())));
            }
        }
        else{
            if (e.getX() < X){
                figure.setorigin(new Point(e.getX(),Y));
            }
            if (e.getY() < Y){
                figure.setorigin(new Point(X,e.getY()));
            }
            if (e.getX() < X && e.getY() < Y){
                figure.setorigin(new Point(e.getX(),e.getY()));
            }
        }
    }

    public void mousePressed(MouseEvent e){
        X=e.getX();
        Y=e.getY();
        figure.setColor(color);
        figure.setorigin(new Point(X,Y));
        liste.add(getFigure());
    }

    public void save(String fileName){
        try{
            FileOutputStream fos = new FileOutputStream(FileSystemView.getFileSystemView().getHomeDirectory()+"\\"+fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(liste);

            oos.close();
        }
        catch (Exception e){
            System.out.println("Problemos !");
        }
    }

    public void open(String fileName){
        try{
            FileInputStream fis = new FileInputStream(FileSystemView.getFileSystemView().getHomeDirectory()+"\\"+fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            liste = (ArrayList<Figure>) ois.readObject();

            ois.close();
        }
        catch (Exception e){
            System.out.println("Problemos !");
        }
    }

    public void mouseReleased(MouseEvent e){
    }
    public void mouseMoved(MouseEvent e){
    }

    public void mouseClicked(MouseEvent e){
    }

    public void mouseEntered(MouseEvent e){
    }

    public void mouseExited(MouseEvent e){
    }


}



