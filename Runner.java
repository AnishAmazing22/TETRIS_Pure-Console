import java.util.Scanner;
/**
 * the tester program to run the code
*/
public class Runner
{
    public static boolean easy = false;
    /**
     * runs the code and runs the tetris game inside of it
    */
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play Tetris in hard or easy");
        if(!(scanner.nextLine()).equals("hard")){
            easy=true;
        }
        //runs the tetris game
        Tetris.run();
        
        
    }
}
