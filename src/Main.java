
import java.awt.event.*;
import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class Main {

    private JFrame mainFrame;

    public Main(){
        prepareGUI();
    }

    public static void main(String[] args){
       Main main = new Main();main.showColorChooserDemo();
    }

    private void prepareGUI(){
        mainFrame = new JFrame("Java Swing Examples");
        mainFrame.setSize(600,400);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        mainFrame.setVisible(true);
    }

    private void showColorChooserDemo(){
        JColorChooser colorChooser = new JColorChooser();

        AbstractColorChooserPanel[] panels = colorChooser.getChooserPanels();
        for(AbstractColorChooserPanel p:panels) {
            String displayName = p.getDisplayName();
            System.out.println(displayName);
            switch (displayName) {
                case "サンプル(S)":
                    colorChooser.removeChooserPanel(p);
                    break;
                case "HSV(H)":
                    colorChooser.removeChooserPanel(p);
                    break;
                case "HSL(L)":
                    colorChooser.removeChooserPanel(p);
                    break;
                case "CMYK":
                    colorChooser.removeChooserPanel(p);
                    break;
            }
        }

        mainFrame.getContentPane().add(colorChooser);
        mainFrame.setVisible(true);
    }
}
