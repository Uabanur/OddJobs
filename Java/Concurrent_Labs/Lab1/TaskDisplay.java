import java.awt.*;
import java.awt.event.*;

// Auxiliary class to buffer key events.
// You are not supposed to understand this yet!

class KeyBuffer extends KeyAdapter {

    static int K = 1000;  
    int in, out, no = 0;

    char[] buf = new char[K];

    synchronized public void keyPressed(KeyEvent e) {
      char c = e.getKeyChar();
      e.consume();
      if (c != KeyEvent.CHAR_UNDEFINED && no < K) { 
        buf[in++] = c;
        in = in % K;
        no++;
        notify();
      }
    }

    synchronized public char Get() {
      while (no==0) try{ wait();} catch (Exception e){}
      char c = buf[out++];
      out = out % K;
      no--;
      return c;
    }

}

// Class that provides a GUI for the lab

public class TaskDisplay extends Frame{

  public TextField[] tf;
  TextArea    txt;

  static final int width      =   40;
  static final int minhistory = 1000;

  private KeyBuffer kb;

  public TaskDisplay(String name, int n) {

    super(name);

    int lines = 0;

    kb = new KeyBuffer();

    addWindowListener(
        new WindowAdapter(){
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        });

    // Create 'n' TextFields

    if (n > 0) tf = new TextField[n];

    setFont(new Font("Monospaced",Font.BOLD,12));

    setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    c.gridx = 0; c.gridy = GridBagConstraints.RELATIVE;
    c.insets = new Insets(5,5,5,5);

    for (int i = 0; i < tf.length; i++) {
      c.gridx = 0; 
      Label l = new Label("Task " + i);
      add(l,c);
      c.gridx = 1;
      tf[i] = new TextField(width);
      tf[i].setEditable(false);
      tf[i].setForeground(Color.blue);
      tf[i].setBackground(Color.white);

      add(tf[i], c);
    }

    txt = new TextArea("",8,width,TextArea.SCROLLBARS_VERTICAL_ONLY);
    txt.addKeyListener(kb);
    txt.setEditable(false);
    txt.setBackground(Color.white);
    c.gridx = 0; c.gridwidth = 2;  c.fill = GridBagConstraints.HORIZONTAL;
    add(txt,c);

    pack();
    setVisible(true);
    txt.requestFocus();
  }

  public void println(String s) {
    txt.setCaretPosition(10000);       // set caret at end
    int last = txt.getCaretPosition();
    if (last > 2*minhistory) txt.replaceRange("",0,last-minhistory);
    txt.append(s+"\n");
  }

  public char getKey() {
    return kb.Get();
  }

}




