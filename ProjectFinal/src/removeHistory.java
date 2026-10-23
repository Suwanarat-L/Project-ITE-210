import java.util.Scanner;

public class removeHistory {

    public void removeVideo(Scanner scanner, fileManager file){

        file.loadFile();

        if (file.Videos.isEmpty()) {
            System.out.println("History is Empty");
            return;
        }

        int count = 0;
        for(int i = 0; i < file.Videos.size(); i++){
            System.out.println("[" + (i+1) + "] " + file.Videos.get(i).toString());
            count++;
        }
        System.out.println("Have " + count + " video");
        System.out.println("---------------------------------------");

        String inputIndex;
        int reomoveIndex = 0;
        while(true){
            System.out.print("Enter the number of video to remove: ");
            try{
                inputIndex = scanner.next().trim();
                reomoveIndex = Integer.parseInt(inputIndex) - 1;
            } catch (NumberFormatException e){
                System.out.println("---------------------------------------");
                System.out.println("Please enter a number");
                System.out.println("---------------------------------------");
            }
            if (reomoveIndex <= count) {
                break;
            } else{
                System.out.println("---------------------------------------");
                System.out.println("Invalid video number");
                System.out.println("Please enter 1 - " + count);
                System.out.println("---------------------------------------");
            }
        }

        if (reomoveIndex < file.Videos.size()) {
            video remove = file.Videos.remove(reomoveIndex);
            file.save();
            System.out.println("Romove: " + remove.title);
        }
    }
    
}
