//imports
import javax.swing.*;
import java.awt.event.*;
//main body
public class GUI extends JFrame implements ActionListener{
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit; 
    functionFile file = new functionFile(this);
    // JMenuItem ;

    public static void main(String args[]){
        new GUI();
    }
    public GUI(){
        createWindow();
        createTextArea();
        Menubar();
        createFileMenu();
        window.setVisible(true);
    }

    public void createWindow(){

        window = new JFrame("Notepad");
        window.setSize(800,1000);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    } 

    public void createTextArea() {
        textArea = new JTextArea();
        scrollPane = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    public void Menubar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);

    }

    public void createFileMenu() {
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save", ABORT);
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As", ABORT);
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save As");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit", ABORT);
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch(command){
            case "New" : file.newFile();break;
            case "Open" : file.open();break;
            case "Save" : file.save(); break;
            case "Save As" : file.saveAs();break;
            // case "Exit" : file.open();
        }
    }


}
