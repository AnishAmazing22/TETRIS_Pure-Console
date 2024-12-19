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
        System.out.println("Welcome to Tetris!\n\nControls:\n1. ENTER: progress a tick\n2. A: move left\n3. D: move right\n4. S or hold ENTER: move down\n5. SPACE: drop block\n");
        System.out.println("Spam ENTER at a consistent, high speed to play properly\n");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play Tetris in hard or easy");
        if(!(scanner.nextLine()).equals("hard")){
            easy=true;
        }
        //runs the tetris game
        Tetris.run();
        
        
    }
}
