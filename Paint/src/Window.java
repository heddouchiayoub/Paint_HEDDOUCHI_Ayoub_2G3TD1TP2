import javax.swing.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class Window extends JFrame implements ActionListener {
    Drawing Drawing = new Drawing();

    public Window(String Title, int x, int y) {
        super(Title);
        this.setSize(x, y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPanel = this.getContentPane();
        JPanel touches = new JPanel();
        touches.setLayout(new GridLayout(1, 2));

        JMenuBar m = new JMenuBar();
        JMenu menu1 = new JMenu("File");

        JMenuItem New = new JMenuItem("New");
        menu1.add(New);
        New.addActionListener(this);
        JMenuItem open = new JMenuItem("Open");
        menu1.add(open);
        open.addActionListener(this);
        JMenuItem save = new JMenuItem("Save");
        menu1.add(save);
        save.addActionListener(this);
        save.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        JMenuItem quit = new JMenuItem("Quit");
        menu1.add(quit);
        quit.addActionListener(this);
        quit.setBorder(BorderFactory.createMatteBorder(1, 0, 0,
                0, Color.decode("#6382bf")));
        m.add(menu1);

        contentPanel.add(m);

        JMenu Menu2 = new JMenu("A propos");
        JMenuItem Auteur = new JMenuItem("Author");
        Menu2.add(Auteur);
        Auteur.addActionListener(this);
        m.add(menu1);
        m.add(Menu2);
        setJMenuBar(m);

        Drawing.repaint();
        contentPanel.add(Drawing,"Center");

        JPanel couleurs = new JPanel();
        couleurs.setLayout(new GridLayout(2, 4));

        JButton noir = new JButton("Noir");
        couleurs.add(noir);
        noir.setBackground(Color.black);
        noir.setForeground(Color.white);
        noir.addActionListener(this);

        JButton rouge = new JButton("Rouge");
        couleurs.add(rouge);
        rouge.setBackground(Color.red);
        rouge.addActionListener(this);

        JButton vert = new JButton("Vert");
        couleurs.add(vert);
        vert.setBackground(Color.green);
        vert.addActionListener(this);

        JButton bleu = new JButton("Bleu");
        couleurs.add(bleu);
        bleu.setBackground(Color.blue);
        bleu.setForeground(Color.white);
        bleu.addActionListener(this);

        JButton jaune = new JButton("Jaune");
        couleurs.add(jaune);
        jaune.setBackground(Color.yellow);
        jaune.addActionListener(this);

        JButton rose = new JButton("Rose");
        couleurs.add(rose);
        rose.setBackground(Color.pink);
        rose.addActionListener(this);

        JButton magenta = new JButton("Magenta");
        couleurs.add(magenta);
        magenta.setBackground(Color.magenta);
        magenta.addActionListener(this);

        JButton orange = new JButton("Orange");
        couleurs.add(orange);
        orange.setBackground(Color.orange);
        orange.addActionListener(this);
        touches.add(couleurs);

        JPanel dessins = new JPanel();
        dessins.setLayout(new GridLayout(2, 2));

        JButton Ellipse = new JButton("paintPackage.Ellipse");
        dessins.add(Ellipse);
        Ellipse.addActionListener(this);

        JButton Cercle = new JButton("paintPackage.Cercle");
        dessins.add(Cercle);
        Cercle.addActionListener(this);

        JButton Rectangle = new JButton("paintPackage.Rectangle");
        dessins.add(Rectangle);
        Rectangle.addActionListener(this);

        JButton Square = new JButton("paintPackage.Square");
        dessins.add(Square);
        Square.addActionListener(this);

        touches.add(dessins);

        contentPanel.add(touches, "South");
        this.setVisible(true);
    }

    @Override

         public void actionPerformed(ActionEvent e){
             String cmd=e.getActionCommand();
             switch (cmd)
             {
                 case"New":
                     Drawing.getList().clear(); repaint();
                     break;
                 case"Quit":
                     System.exit(0);
                     break;
                 case"Save":
                     String Save_ad =  JOptionPane.showInputDialog(null, " Save: ");
                     Drawing.save(Save_ad);
                     break;
                 case"Open":
                     String Open_ad = JOptionPane.showInputDialog(null,"Open: ");
                     Drawing.open(Open_ad);
                     repaint();
                     break;
                 case"Noir":
                    Drawing.setColor(Color.black);
                     break;
                 case"Rouge":
                     Drawing.setColor(Color.red);
                     break;
                 case"Vert":
                     Drawing.setColor(Color.green);
                     break;
                 case"Bleu":
                     Drawing.setColor(Color.blue);
                     break;
                 case"Jaune":
                     Drawing.setColor(Color.yellow);
                     break;
                 case"Rose":
                     Drawing.setColor(Color.pink);
                     break;
                 case"Magenta":
                     Drawing.setColor(Color.magenta);
                     break;
                 case"Orange":
                     Drawing.setColor(Color.orange);
                     break;

                 case "paintPackage.Ellipse" :
                     Drawing.setFigure(new Ellipse(Drawing.getColor()));
                     Drawing.setFigureName("Ellipse");
                     break;
                 case "paintPackage.Rectangle":
                     Drawing.setFigure(new Rectangle(Drawing.getColor()));
                     Drawing.setFigureName("Rectangle");
                     break;
                 case "paintPackage.Square":
                     Drawing.setFigure(new Square(Drawing.getColor()));
                     Drawing.setFigureName("Square");
                     break;
                 case "paintPackage.Cercle":
                     Drawing.setFigure( new Cercle (Drawing.getColor()));
                     Drawing.setFigureName("Cercle");
                     break;
                 case "Author":
                     JOptionPane info = new JOptionPane();
                     info.showInternalMessageDialog( info,"Authors : Ayoub Heddouchi","information",JOptionPane.INFORMATION_MESSAGE);
                     break;

             }
        }
    }




