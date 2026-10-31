import java.util.Scanner;

public class searchVideo {
    public void searchTitle(Scanner scanner, fileManager file){
        file.loadFile();
        System.out.print("Enter keyword: ");
        String keyword = scanner.next();
        scanner.nextLine();
        int count = 0;
        //O(n) เพราะต้องไล่หาไปตั้งแต่แรกถึงตัวสุดท้าย
        //ใช้เcontains() แสดงว่าคือ Linear Search เพราะจะหาคำที่เหมือนกันในArrayList 
        for(video v : file.Videos){
            if ((v.title.toLowerCase().contains(keyword.toLowerCase()))) {
                count++;
                System.out.println("[" + count + "] " + v.toString());
            }
        }
        if (count < 1) {
            System.out.println("Not Found Video");
        } else{
            System.out.println("Found " + count + " videos");
        }
    }
    
}
