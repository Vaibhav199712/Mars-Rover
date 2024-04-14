import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the width of matrix ");
        int width = inp.nextInt();
        System.out.println("Enter the height of matrix ");
        int height = inp.nextInt();

        Grid grid = new Grid(width, height);

        Boolean enterObstacle = true ;

        while(enterObstacle) {

            System.out.println("Do you want to enter obstacle? Press 1 if Yes or 2 if No");
            int num = inp.nextInt();
            enterObstacle = num==1?true:false;

             if(enterObstacle){
                 System.out.println("Enter x-coordinate");
                int x = inp.nextInt();
                 System.out.println("Enter y-coordinate");
                int y = inp.nextInt();
                grid.addObstacle(x,y);
             }
            inp.nextLine();
        }

        System.out.println("Enter the starting x-coordinate");
        int x = inp.nextInt();
        System.out.println("Enter the starting y-coordinate");
        int y =inp.nextInt();

        Rover rover = new Rover(x, y, Direction.NORTH, grid);

        CommandInvoker invoker = new CommandInvoker();
        Boolean stillPlaying = true;

        while(stillPlaying) {

            System.out.println("Do you want to enter commands? Press 1 if Yes and 2 if No");
             int num = inp.nextInt() ;
            stillPlaying = num==1?true:false ;

            //inp.nextLine();

            if(stillPlaying) {
                System.out.println("Enter the command");
                char move = inp.next().charAt(0);
                switch(Character.toLowerCase(move)){

                    case 'm' :
                        System.out.println("moving ahead");
                        invoker.addCommand(new MoveCommand());
                        invoker.executeCommands(rover);
                        break;

                    case 'r' :
                        System.out.println("moving right");
                        invoker.addCommand(new TurnRightCommand());
                        invoker.executeCommands(rover);
                        break;

                    case 'l' :
                        System.out.println("moving left");
                        invoker.addCommand(new TurnLeftCommand());
                        invoker.executeCommands(rover);
                        break;
                }
            }
        }

        System.out.println("Game Ended!");
        rover.reportStatus();
    }
}
