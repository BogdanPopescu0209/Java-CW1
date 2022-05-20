package task3;

import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ApplicationRunner {

    public static void main(String[] args) {

        ApplicationRunner hillWalker = new ApplicationRunner();

        hillWalker.time();

    }

    public void time() {

        Scanner input = new Scanner(System.in);

        LocalTime time = LocalTime.now();
        
        //Time format
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String displayTime = time.format(formatTime);

        //Display time
        System.out.println(displayTime);

        System.out.print("Press set/change display to set hours or press mode/change display to altimeter (exit)> ");

        String setMode = input.next();

        //Check input and call coressponding function
        if (setMode.equals("mode")) {
            altimeter();
        }

        if (setMode.equals("set")) {
            setHours();
        }

    }

    public void altimeter() {

        //Display altimeter
        System.out.println("Altitude: 1500(meters)");

        System.out.print("Press mode/change display time or press set for altimeter (exit)> ");

        Scanner input = new Scanner(System.in);

        String setMode = input.next();
        
        //Check input and call coressponding function
        if (setMode.equals("mode")) {
            time();
        }

        if (setMode.equals("set")) {
            altimeter();
        }

        if (setMode.equals("exit")) {
            System.exit(0);
        }

    }

    public void setHours() {

        Scanner input = new Scanner(System.in);

        LocalTime time = LocalTime.now();

        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");

        String displayTime = time.format(formatTime);

        System.out.println(displayTime);

        System.out.print("Press set to add 1 hours or press mode/change display to set mins (exit)> ");

        while (true) {

            String set = input.next();

            //Check input and call coressponding function
            if (set.equals("set")) {
                
                //Add 1 to hours
                LocalTime updateTime = time.plusHours(+1);

                System.out.println(updateTime.format(formatTime) + " >");

                System.out.print("Press set to add 1 hours or press mode/change display to set mins (exit)> ");

                time = updateTime;
            }

            if (set.equals("mode")) {
                setMins();
            }

            if (set.equals("exit")) {
                System.exit(0);
            }

        }
    }

    public void setMins() {

        Scanner input = new Scanner(System.in);

        LocalTime time = LocalTime.now();

        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");

        String displayTime = time.format(formatTime);

        System.out.println(displayTime);

        System.out.print("Press set/add 1 minute or press mode/change display to time (exit)> ");

        while (true) {

            String set = input.next();
            
            //Check input and call coressponding function
            if (set.equals("set")) {
                
                //Add 1 to minutes
                LocalTime updateTime = time.plusMinutes(+1);

                System.out.println(updateTime.format(formatTime));

                System.out.print("Press set/add 1 minute or press mode/change display to time (exit)> ");

                time = updateTime;

            }

            if (set.equals("mode")) {
                time();
            }

            if (set.equals("exit")) {
                System.exit(0);
            }

        }

    }

}
