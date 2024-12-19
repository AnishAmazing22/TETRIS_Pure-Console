/**
 * creates a shadow of the block to see where it will fall 
*/
public class Shadow {
    //the position of the shadow
    public int[][] pos = {{0,0},{0,0},{0,0},{0,0}, {1}};
    /**
     * Constructor
    */
    public Shadow(){
        
    }
    /**
     * makes the shadow fall to the bottom
    */
    public void fall(){
        pos[0][1] +=1;
        pos[1][1] +=1;
        pos[2][1] +=1;
        pos[3][1] +=1;
    }
    
}
