public class Shadow {
    
    public int[][] pos = {{0,0},{0,0},{0,0},{0,0}, {1}};
    
    public Shadow(){
        
    }
    public void fall(){
        pos[0][1] +=1;
        pos[1][1] +=1;
        pos[2][1] +=1;
        pos[3][1] +=1;
    }
    
}
