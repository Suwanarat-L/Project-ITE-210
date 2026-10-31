import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class fileManager {

    //ใช้ArrayList เพราะว่าเข้าถึงข้อมูลได้ง่านและไว้กว่า
    ArrayList<video> Videos = new  ArrayList<>();

    //เก็บข้อมูลไว้ในไฟล์
    String file_path = "F:\\ITE-210\\ProjectFinal\\src\\history.txt";

    //โหลดข้อมูลในไฟล์ไว้ในArrayList
    public void loadFile(){
        Videos.clear();
        try{
            File file = new File(file_path);
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String[] parts = scanner.nextLine().split("\\|");
                    if (parts.length == 3) {
                        Videos.add(new video(parts[0], parts[1], parts[2]));
                    }
                }
                scanner.close();
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

//save ต่อของเดิม
    public void saveFile(){     
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file_path, true));
            for(video v : Videos){
                writer.println(v.title + "|" + v.channel + "|" + v.day);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }

//save ทับ
    public void save(){     
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file_path));
            for(video v : Videos){
                writer.println(v.title + "|" + v.channel + "|" + v.day);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }
}
