import java.util.Scanner;

public class viewHistory {

    public void viewVideo(Scanner scanner, fileManager file){

        file.loadFile();

        String input;
        int option = 0;
        boolean cheek = false;
        
        do{
            System.out.println("[1] View All History");
            System.out.println("[2] View History by Date");
            System.out.print("Selcet an option (1-2): ");

            try{
                input = scanner.next().trim();
                option = Integer.parseInt(input);
            } catch(NumberFormatException e){
                System.out.println("---------------------------------------");
                System.out.println("Please select 1-2");
                System.out.println("---------------------------------------");
                continue;
            }

            if (option == 1 || option == 2) {
                cheek = true;
                System.out.println("---------------------------------------");
            } else{
                System.out.println("---------------------------------------");
                System.out.println("Please select 1-2");
                System.out.println("---------------------------------------");
            }

        } while(!cheek);

        switch (option) {
            case 1:
                System.out.println("View All History");
                viewAll(file);
                break;
        
            case 2:
                String targetDate;
                System.out.println("View History by Date");
                while (true) {
                    System.out.print("Enter date to view (e.g. 2026-11-21): ");
                    targetDate = scanner.next().trim();
                    try{
                        java.time.LocalDate.parse(targetDate);
                        break;
                    }catch(java.time.format.DateTimeParseException e){
                        System.out.println("Invalid date format! Please use YYYY-MM-DD (e.g. 2026-11-21)");
                        System.out.println("---------------------------------------");
                    }
                }
                viewByDate(file, targetDate);
                break;
        }
        
    }

    public void viewAll(fileManager file){
        if (file.Videos.isEmpty()) {
            System.out.println("History is Empty");
        }
        for(int i = 0; i < file.Videos.size(); i++){
            System.out.println("[" + (i+1) + "] " + file.Videos.get(i).toString());
        }
    }

    public void viewByDate(fileManager file, String targetDate){
        int count = 0;
        System.out.println("---------------------------------------");
        System.out.println("History on " + targetDate);
        for(int i = 0; i < file.Videos.size(); i++){
            video v = file.Videos.get(i);
            if (v.getDay().equals(targetDate)) {
                count++;
                System.out.println("[" + (count) + "] " + v.toString());
            }
        }
        if (count < 1) {
            System.out.println("No history found on this date");
        } else{
            System.out.println("Found " + count + " video");
        }
    }
    
}
