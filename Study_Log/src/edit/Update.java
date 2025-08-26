package edit; /*Package containing the class.*/

/*Import API.*/
import java.io.*;

public class Update { /*Class for updating the file.*/
    private File_Data check = new File_Data();
    private Read read = new Read();

    public void add(String path, String data) {
        check.Check(path);
        try {
            FileWriter file = new FileWriter(path, true);
            BufferedWriter buffer = new BufferedWriter(file);
            buffer.write(data);
            buffer.newLine();
            buffer.close();
        } catch (IOException e) {
            System.out.println("Error has occurred : " + e.getStackTrace());
        }
    }

    public void update(String path, String id, int index, String updated_data) {
        check.Check(path);
        String[][] current_data = read.all(path);
        try {
            FileWriter file = new FileWriter(path);
            BufferedWriter buffer = new BufferedWriter(file);
            for (String[] data : current_data) {
                if (data[0].equals(id)) {
                    data[index] = updated_data;
                }
                buffer.write(String.join(";", data));
                buffer.newLine();
            }
            buffer.close();
        } catch (IOException e) {
            System.out.println("Error has occurred : " + e.getStackTrace());
        }
    }

    public void note(String path, String text) {
        check.Check(path);
        try {
            FileWriter file = new FileWriter(path);
            BufferedWriter buffer = new BufferedWriter(file);
            buffer.write(text);
            buffer.close();
        } catch (IOException e) {
            System.out.println("Error has occurred : " + e.getStackTrace());
        }
    }

    public void delete(String path, String id) {
        check.Check(path);
        String[][] current_data = read.all(path);
        try {
            FileWriter file = new FileWriter(path);
            BufferedWriter buffer = new BufferedWriter(file);
            for (String[] row : current_data) {
                if (!row[0].equals(id)) {
                    buffer.write(String.join(";", row));
                    buffer.newLine();
                }
            }
            buffer.close();
        } catch (IOException e) {
            System.out.println("Error has occurred : " + e.getStackTrace());
        }
    }
}
