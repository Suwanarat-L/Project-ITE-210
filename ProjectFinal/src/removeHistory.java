import java.util.Scanner;

public class removeHistory {

    public void removeVideo(Scanner scanner, fileManager file){

        file.loadFile(); //โหลดไฟล์เก็บไว้ก่อน

        //ถ้าarraylistว่าง จะเด้งแบบนี้
        if (file.Videos.isEmpty()) {
            System.out.println("History is Empty");
            return;
        }

        int option = 0;

        while (true) {
            System.out.println("Remove History");
            System.out.println("---------------------------------------");
            System.out.println("[1] Remove a specific video");
            System.out.println("[2] Remove All history");
            System.out.print("Select an option (1-2): ");

            //เช็คว่าพิมพ์เป็นตัวเลขไหม
            try{
                String input = scanner.next().trim();
                option = Integer.parseInt(input);
            } catch (NumberFormatException e){ //ถ้าพิมพ์เป็นอักษรจะเด้งแบบนี้
                System.out.println("Please enter a valid number (1-2)");
                System.out.println("---------------------------------------");
                continue;
            }

            //เช็คว่ากรอก1 หรือ2 ไหม ถ้าใช่ก็จะหยุดลูป
            if (option == 1 || option ==2) {
                break;
            } else {
                System.out.println("Please enter a valid number (1-2)"); //ไม่ได้กรอก1-2
                System.out.println("---------------------------------------");
            }
        }

        //ลบเฉพาะบางวิดีโอ
        //O(n) เพราะจะแสดงทุกตัวที่เราเก็บไว้ออกมา
        if (option == 1) {
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

                //เช็คว่ากรอกเป็นตัวเลขไหม
                try{
                    inputIndex = scanner.next().trim();
                    reomoveIndex = Integer.parseInt(inputIndex) - 1;
                } catch (NumberFormatException e){
                    System.out.println("---------------------------------------");
                    System.out.println("Please enter a number");
                    System.out.println("---------------------------------------");
                }

                //เช็คว่ากรอกเลขอยู่ในระหว่างจำนวนที่มีทั้งหมดไหม
                if (reomoveIndex <= count) {
                    break;
                } else{
                    System.out.println("---------------------------------------");
                    System.out.println("Invalid video number");
                    System.out.println("Please enter 1 - " + count);
                    System.out.println("---------------------------------------");
                }
            }
            //ทำการลบข้อมูลในArrayList แล้วทำการsaveทับใหม่
            if (reomoveIndex < file.Videos.size()) {
                video remove = file.Videos.remove(reomoveIndex); //เป็นO(N) เพราะลบแล้วต้องขยับตัวข้างหลัง
                file.save();
                System.out.println("Romove: " + remove.title);
            }

        } else if (option == 2) { //ลบประวัติทั้งหมด เป็นO(1) แค่กดclearทั้วงหมด
            String confirm;

            do{
                System.out.print("Are you sure you want to cleat All History? (Y/N): ");
                confirm = scanner.next().trim().toLowerCase();
            }while (!confirm.equals("y") && !confirm.equals("n")); //เช็คว่าตอบ y / n

            if (confirm.equals("y")) { //ตอบตกลง
                file.Videos.clear(); //ลบทั้งหมดเ แล้วsaveทับ
                file.save();
                System.out.println("All history has been cleared.");
            } else if (confirm.equals("n")) { //ตอบไม่ตกลง
                System.out.println("Clear all cancelled.");
            }

        }
    }
    
}
