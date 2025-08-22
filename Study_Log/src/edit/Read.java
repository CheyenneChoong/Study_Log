package edit; /*Package containing the class.*/

/*Import API.*/
import java.io.*;
import java.util.ArrayList;

public class Read { /*Class for reading files.*/
    /*Method for reading all the data.*/
    public String[][] all(String file_path) {
        File_Data check = new File_Data();
        check.Check(file_path);
        ArrayList<String> temp = new ArrayList<String>();
        String line;

        try {
            FileReader read_file = new FileReader(file_path);
            BufferedReader read_buffer = new BufferedReader(read_file);
            while ((line = read_buffer.readLine()) != null) {
                temp.add(line);
            }
            read_buffer.close();
        } catch (IOException e) {
            System.out.println("Error has occurred : " + e.getStackTrace());
        }
        
        String[] temp_array = temp.toArray(new String[0]);
        if (temp_array.length == 0) {
            return null;
        }
        int element_count = temp_array[0].split(";").length;
        String[][] data = new String[temp_array.length][element_count];
        for (int row = 0; row < temp_array.length; row++) {
            String[] elements = temp_array[row].split(";");
            for (int column = 0; column < element_count; column++) {
                data[row][column] = elements[column];
            }
        }
        return data;
    }

    /*Method for reading one line of data.*/
    public String[] one(String id, String file_path) {
        String[][] all_data = all(file_path);
        
        for (String[] data : all_data) {
            if (data[0].equals(id)) {
                return data;
            }
        }

        return null;
    }
}
