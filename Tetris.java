import java.util.Scanner;

/**
 * class that creates the Tetris game
*/
public class Tetris {
    private static int[][] screen = {{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,1,1,1,1,1,1,1,1}};
    
    private static String input = "";
    private static int speed = 4;
    private static int time = 0;
    private static Block block;
    private static int[] finished = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int score;
    private static Shadow shadow;
    /**
     * runs the game
    */
    public static void run(){
        if(!(Runner.easy)){
            speed=2;
        }
        
        //creates the block object
        block = new Block();
        shadow = new Shadow();
        
        shadow.pos = deepCopy2DArray(block.pos);
        
        System.out.println("start");
        
        //creates Scanner object
        Scanner in = new Scanner(System.in);
        
        System.out.println("working");
        
        //prints the first screen
        screen();
        
        //sets speed value to reference spearate from speed
        int sped = speed;
        
        while(!(input.equals("m"))){
           
            
            
            //starts setting speed
            speed = sped;
            //takes the input
            input = in.nextLine();
            //takes key pressed and executes a movement
            if(input.equals("a")||input.equals("aa")){
                block.move(-1);
            }else if(input.equals("d")||input.equals("dd")){
                block.move(1);
            }else if(input.equals("w")||input.equals("ww")){
                block.rotate();
            }else if(input.equals("s")||input.equals("ss")){
                speed = 1;
            }else if(input.equals(" ")){
                while(!(touching())){
                    block.update();
                }
            }
            //moves the block back in screen if it went over
            edge();
            edge();
            edge();
            
            shadow.pos = deepCopy2DArray(block.pos);
            while(!(touch())){
                shadow.fall();
            }
            //checks if block is touching other blocks and creates a new block if so
            if(touching()){
                for(int i=0;i<4;i++){
                    screen[(block.pos[i][1])][(block.pos[i][0])] = 1;
                    if(block.pos[i][1]==0){
                        input="m";
                    }
                }
                block.create();
            }
            //speeds up the game when the score is a multiple of 10
            if((time%500) == 0&&sped!=1&&time!=0){
                sped--;
                System.out.println("Speed up");
            }
            //prints the screen
            screen();
            //progresses one timestep forward
            step();
        }
    }
    /**
     * prints the screen
    */
    public static void screen(){
        //prints the score and top of the screen
        System.out.println("TIME: "+time);
        System.out.println("SCORE: "+score);
        System.out.println("__________________________");
        
        //counts to check if their is a full row
        int counter = 0;
        
        //goes through the loops to print the screen
        for(int i = 0;i<20;i++){
            counter = 0;
            System.out.print("|");
            if(finished[i]==0){
                for(int j = 0;j<12;j++){
                    //checks if there is a block in the location and prints it
                    if(check(j, i)){
                        System.out.print("⊦⫞");
                        if(screen[i][j]==1){
                            counter++;
                        }
                    }else if(check2(j, i)&&Runner.easy){
                        System.out.print("--");
                    }else{
                        System.out.print("  ");
                    }
                }
                if(counter==12){
                    //declares a full row of blocks
                    finished[i]=1;
                }
            }else{
                //moves the rows down after not printing the row
                finished[i]=0;
                score++;
                for(int h = i; h>0;h--){
                    screen[h] = screen[h-1];
                }
                System.out.print("                        ");
            }
            System.out.println("|");
            
        }
        //prints the bottom
        System.out.println("__________________________");
    }
    /**
     * progresses a timestep and moves the block down if the time is a multiple of the speed
    */
    public static void step(){
        //increases the time
        time+=1;
        
        //checks if the time is a multiple of the speed
        if((time%speed) == 0){
            block.update();
        }
    }
    /**
     * checks if the current position is a block position
     * @param x x-coord of the block
     * @ param y y-coord of the block
     * @return returns if there is a block in that location
    */
    public static boolean check(int x, int y){
        return (((block.pos[0][0]==x&&block.pos[0][1]==y)||(block.pos[1][0]==x&&block.pos[1][1]==y)||(block.pos[2][0]==x&&block.pos[2][1]==y)||(block.pos[3][0]==x&&block.pos[3][1]==y))||(screen[y][x]==1));
    }
    /**
     * checks if the current position is a shadow position
     * @param x x-coord of the shadow block
     * @ param y y-coord of the shadow block
     * @return returns if there is a shadow block in that location
    */
    public static boolean check2(int x, int y){
        return (((shadow.pos[0][0]==x&&shadow.pos[0][1]==y)||(shadow.pos[1][0]==x&&shadow.pos[1][1]==y)||(shadow.pos[2][0]==x&&shadow.pos[2][1]==y)||(shadow.pos[3][0]==x&&shadow.pos[3][1]==y)));
    }
    /**
     * checks if the block is touching other blocks on the bottom
     * @return returns if it is touching a block underneath
    */
    public static boolean touching(){
        for(int i=0;i<4;i++){
            if((screen[block.pos[i][1]+1][(block.pos[i][0])])==1){
                return true;
            }
        }
        return false;
    }
    /**
     * the touching method but for the shadow
     * @return whether it is touching or not
    */
    public static boolean touch(){
        for(int i=0;i<4;i++){
            if((screen[shadow.pos[i][1]+1][(shadow.pos[i][0])])==1){
                return true;
            }
        }
        return false;
    }
    /**
     * moves the block back in screen if it is moved off by player
    */
    public static void edge(){
        for(int i=0;i<4;i++){
            if(block.pos[i][0]<0){
                block.move(1);
            }
            if(block.pos[i][0]>11){
                block.move(-1);
                System.out.println("stop");
            }
        }
    }
    /**
     * creates a copy of the block to assign to the shadow
     * I did this because it was creating a reference when I was trying to assign it
     * @param original the array to copy
     * @return returns the copy of the array
    */
    public static int[][] deepCopy2DArray(int[][] original) {
        if (original == null) {
            return null; // Handle null case
        }
    
        int[][] copy = new int[original.length][]; // Create a new 2D array
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone(); // Clone each row
        }
        return copy;
    }
}
