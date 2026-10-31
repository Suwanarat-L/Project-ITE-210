import java.util.Scanner;

public class youtube {

    //ไว้ใช้กับwatchHistory
    public static boolean incognito = false;
    public static void main(String[] args) {

        //obj
        fileManager file = new  fileManager();
        watchVideo watch = new watchVideo();
        viewHistory view = new viewHistory();
        searchVideo search = new searchVideo();
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
            System.out.println("[3] Search Video");
            System.out.println("[4] Remove History");
            System.out.println("[5] Incognito Mode");
            System.out.println("[6] Exit");
            System.out.print("Select an option (1-6): ");

            //เช็คว่าตอบเป็นตัวเลขไหม
            try{
                input = scanner.next().trim();
                scanner.nextLine();
                option = Integer.parseInt(input);
            } catch(NumberFormatException e){
                System.out.println("---------------------------------------");
                System.out.println("Please select 1-6");
                continue;
            }

            System.out.println("---------------------------------------");
            file.loadFile(); //โหลดไฟล์เข้าArrayไว้ใช้กับฟีเจอร์

            switch (option) {
                case 1:
                    watch.addVideo(scanner, file);
                    break;
                case 2:
                    view.viewVideo(scanner, file);
                    break;
                case 3:
                    search.searchTitle(scanner, file);
                    break;
                case 4:
                    remove.removeVideo(scanner, file);
                    break;
                case 5:
                    incognito = !incognito;
                    System.out.println((!incognito) ? "Incognito Mode: Off" : "Incognito Mode: On");
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting...");
                    break;  
                default:
                    System.out.println("Invalid choice. Please select 1-6");
                    break;
            }

        }while (!exit);
        scanner.close();
    }
}
