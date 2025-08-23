package edit; /*Package containing the class.*/

/*Import API.*/
import java.io.*;
import java.util.ArrayList;

public class Read { /*Class for reading files.*/
    private File_Data check = new File_Data();

    /*Method for reading all the data.*/
    public String[][] all(String file_path) {
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

    /*Method for reading multiple data with the same foreign key.*/
    public String[][] multiple(String id, int key, String file_path) {
        check.Check(file_path);
        ArrayList<String> temp_all = new ArrayList<String>();
        String line;

        try {
            FileReader read_file = new FileReader(file_path);
            BufferedReader read_buffer = new BufferedReader(read_file);
            while ((line = read_buffer.readLine()) != null) {
                temp_all.add(line);
            }
            read_buffer.close();
        } catch (Exception e) {
            System.out.println("Error has occured : " + e.getStackTrace());
        }

        String[] temp_all_array = temp_all.toArray(new String[0]);
        if (temp_all_array.length == 0) {
            return null;
        }
        ArrayList<String> temp_filter = new ArrayList<String>();
        for (int index = 0; index < temp_all_array.length; index++) {
            String[] data = temp_all_array[index].split(";");
            if (data[key].equals(id)) {
                temp_filter.add(temp_all_array[index]);
            }
        }
        String[] temp_filter_array = temp_filter.toArray(new String[0]);
        int element_count = temp_filter_array[0].split(";").length;
        String[][] filtered_data = new String[temp_filter_array.length][element_count];
        for (int row = 0; row < temp_filter_array.length; row++) {
            String[] data = temp_filter_array[row].split(";");
            for (int column = 0; column < element_count; column++) {
                filtered_data[row][column] = data[column];
            }
        }
        return filtered_data;
    }
}
