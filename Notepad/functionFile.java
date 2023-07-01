import java.awt.FileDialog;
import java.io.*;

public class functionFile {
    GUI gui;
    String fileName;
    String fileAddress;
    public functionFile(GUI gui) {
        this.gui = gui;
    }

    public void newFile() {
        gui.textArea.setText("");
        gui.window.setTitle("New");

    }

    public void open() {
        FileDialog fileDialog = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fileDialog.setVisible(true);

        if(fileDialog.getFile()!=null){
            fileName = fileDialog.getFile();
            fileAddress = fileDialog.getDirectory();
            gui.window.setTitle(fileName);
        }

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.textArea.setText("");
            String line = null;

            while((line = br.readLine())!=null){
                gui.textArea.append(line + "\n");
            }
            br.close();
        }
        catch(Exception e){
            System.out.println("File not opened!");
        }
    }

    public void saveAs() {
        FileDialog fileDialog = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fileDialog.setVisible(true);

        if(fileDialog.getFile()!=null){
            fileName = fileDialog.getFile();
            fileAddress = fileDialog.getDirectory();
            gui.window.setTitle(fileName);
        }
        
        try{
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void save() {

        if(fileName==null){
            saveAs();
        }
        else{
            try{
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
