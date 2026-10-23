import java.util.Scanner;

public class youtube {
    public static void main(String[] args) {

        //obj
        fileManager file = new  fileManager();
        watchVideo watch = new watchVideo();
        viewHistory view = new viewHistory();
        removeHistory remove = new removeHistory();

        Scanner scanner = new Scanner(System.in);

        String input;
        int option;
        boolean exit = false;

        do{
            System.out.println("---------------------------------------");
            System.out.println("\tYoutube History");
            System.out.println("---------------------------------------");
            System.out.println("[1] Watch Video");
            System.out.println("[2] View History");
            System.out.println("[3] Remove History");
            System.out.println("[4] Exit");
            System.out.print("Select an option (1-4): ");
            try{
                input = scanner.next().trim();
                option = Integer.parseInt(input);
            } catch(NumberFormatException e){
                System.out.println("---------------------------------------");
                System.out.println("Please select 1-4");
                continue;
            }
            System.out.println("---------------------------------------");
            switch (option) {
                case 1:
                    watch.addVideo(scanner, file);
                    break;
                case 2:
                    view.viewVideo(scanner, file);
                    break;
                case 3:
                    remove.removeVideo(scanner, file);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;  
                default:
                    System.out.println("Invalid choice. Please select 1-5");
                    break;
            }
        }while (!exit);
        scanner.close();
    }
}
