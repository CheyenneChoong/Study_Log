package edit; /*Package containing the class.*/

/*Import API.*/
import java.io.*;

public class File_Data {
    public void Check(String file_path) {
        File path = new File(file_path);
        if (path.exists()) {
            return;
        } else {
            Create_File(path);
        }
    }

    public void Create_File(File path) {
        try {
            FileWriter file = new FileWriter(path);
            BufferedWriter buffer = new BufferedWriter(file);
            buffer.close();
        } catch (IOException e) {
            System.out.println("Error has occurred : " + e.getStackTrace());
        }
    }
}
