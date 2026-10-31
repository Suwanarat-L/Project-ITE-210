import java.time.LocalDate;
import java.util.Scanner;

public class watchVideo {

    public void addVideo(Scanner scanner, fileManager file){
        System.out.print("Enter Video Title: ");
        String title = scanner.nextLine();
        //เคลียร์บัฟเฟอร์
        if (title.trim().isEmpty()) {
        title = scanner.nextLine();
        }   

        System.out.print("Enter Video Channel: ");
        String channel = scanner.nextLine();

        if (!title.trim().isEmpty() && !channel.trim().isEmpty()) {
            String currentDate = LocalDate.now().toString();
            if (youtube.incognito) { //เปิดโหมดไม่ระบุตัวตน
                System.out.println("Watch " + title + " on " + currentDate + " (Incognito Mode)");
            } else{ //ปิดโหมดไม่ระบุตัวตน
                file.Videos.add(new video(title, channel, currentDate)); //O(1) แค่เอาที่เราเพิ่มมาแอดลงArray
                file.save(); //O(n) เพราะต้องไล่save แต่เริ่มแรก
                System.out.println("Watch " + title + " on " + currentDate);
            }
        } else {
            System.out.println("Title and Channel cannot be empty");
        }
    }
    
}
