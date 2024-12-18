/**
 * Block object class to create the block object
*/
public class Block {
    //position array for the position of block
    public int[][] pos = {{0,0},{0,0},{0,0},{0,0}, {1}};
    
    /**
     * Constructor
     * creates the block
    */
    public Block(){
        this.create();
    }
    /**
     * rotates the block as whole around the 2nd square
    */
    public void rotate(){
        int xValue;
        int yValue;
        for(int i = 0;i<4;i++){
            xValue = (pos[1][1]-pos[i][1])+pos[1][0];
            yValue = (pos[i][0]-pos[1][0])+pos[1][1];
            pos[i][0]=xValue;
            pos[i][1]=yValue;
        }
    }
    /**
     * moves the block one unit down
    */
    public void update(){
        pos[0][1] +=1;
        pos[1][1] +=1;
        pos[2][1] +=1;
        pos[3][1] +=1;
    }
    /**
     * moves the block to either side by an amount
     * @param move the amount to move
    */
    public void move(int move){
        pos[0][0] +=move;
        pos[1][0] +=move;
        pos[2][0] +=move;
        pos[3][0] +=move;
    }
    /**
     * creates the a random block from the possible combinations of the squares
    */
    public void create(){
        int rand = (int)(Math.random()*7);
        switch(rand){
            case 0:
                pos[0][0] = 5;
                pos[0][1]=0;
                pos[1][0] = 5;
                pos[1][1]=1;
                pos[2][0] = 6;
                pos[2][1]=1;
                pos[3][0] = 7;
                pos[3][1]=1;
                pos[4][0] = 0;
                break;
            case 1:
                pos[0][0] = 7;
                pos[0][1]=0;
                pos[1][0] = 7;
                pos[1][1]=1;
                pos[2][0] = 6;
                pos[2][1]=1;
                pos[3][0] = 5;
                pos[3][1]=1;
                pos[4][0] = 0;
                break;
            case 2:
                pos[0][0] = 6;
                pos[0][1]=0;
                pos[1][0] = 6;
                pos[1][1]=1;
                pos[2][0] = 5;
                pos[2][1]=1;
                pos[3][0] = 7;
                pos[3][1]=1;
                pos[4][0] = 0;
                break;
            case 3:
                pos[0][0] = 5;
                pos[0][1]=0;
                pos[1][0] = 6;
                pos[1][1]=1;
                pos[2][0] = 6;
                pos[2][1]=0;
                pos[3][0] = 7;
                pos[3][1]=1;
                pos[4][0] = 0;
                break;
            case 4:
                pos[0][0] = 7;
                pos[0][1]=0;
                pos[1][0] = 6;
                pos[1][1]=1;
                pos[2][0] = 6;
                pos[2][1]=0;
                pos[3][0] = 5;
                pos[3][1]=1;
                pos[4][0] = 0;
                break;
            case 5:
                pos[0][0] = 4;
                pos[0][1]=0;
                pos[1][0] = 5;
                pos[1][1]=0;
                pos[2][0] = 6;
                pos[2][1]=0;
                pos[3][0] = 7;
                pos[3][1]=0;
                pos[4][0] = 0;
                break;
            case 6:
                pos[0][0] = 6;
                pos[0][1]=0;
                pos[1][0] = 6;
                pos[1][1]=1;
                pos[2][0] = 7;
                pos[2][1]=0;
                pos[3][0] = 7;
                pos[3][1]=1;
                pos[4][0] = 0;
                break;
        }
    }
    
}
