import java.time.LocalDate;
import java.util.Scanner;

public class watchVideo {

    public void addVideo(Scanner scanner, fileManager file){
        System.out.print("Enter Video Title: ");
        String title = scanner.nextLine();
        if (title.trim().isEmpty()) {
        title = scanner.nextLine();
        }   
        System.out.print("Enter Video Channel: ");
        String channel = scanner.nextLine();

        if (!title.trim().isEmpty() && !channel.trim().isEmpty()) {
            String currentDate = LocalDate.now().toString();
            file.Videos.add(new video(title, channel, currentDate));
            file.saveFile();
            System.out.println("Watch " + title + " on " + currentDate);
        } else {
            System.out.println("Title and Channel cannot be empty");
        }
    }
    
}
