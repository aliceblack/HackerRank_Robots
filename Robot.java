import java.util.Scanner;

/*
 * Create the class Robot. Do not use the public access modifier in your class declaration.
 */
 class Robot {
    Integer currentX;
    Integer currentY;
    Integer previousX;
    Integer previousY;
    String lastMove;

    Robot(){
        this.currentX=0;
        this.currentY=5;
    }

    Robot(Integer x, Integer y){
       setCurrentCoordinates(x,y);
    }

    void setCurrentCoordinates(Integer x, Integer y){
        this.previousX=this.currentX;
        this.previousY=this.currentY;
        this.currentX=x;
        this.currentY=y;
    }

    void moveX(Integer dx){
        setLastMove("x");
        setCurrentCoordinates(currentX+dx, currentY);
    }
    
    void moveY(Integer dy){
        setLastMove("y");
        setCurrentCoordinates(currentX, this.currentY+dy);
    }

    void setLastMove(String move){
        lastMove=move;
    }

    void printCurrentCoordinates(){
        System.out.println(currentX+" "+currentY);
    }

    void printLastCoordinates(){
        System.out.println(previousX+" "+previousY);
    }

    void printLastMove(){
        if(lastMove.equals("x")){
            Integer diff=Math.subtractExact(currentX, previousX);
            System.out.println("x "+diff);
        }else{
            Integer diff=(Math.subtractExact(currentY, previousY));
            System.out.println("y "+diff);
        }
    }

}


public class RobotMoves {
	private static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		int x = scan.nextInt();
		int y = scan.nextInt();
		int dx = scan.nextInt();
		int dy = scan.nextInt();
		
		Robot firstRobot = new Robot();
	    firstRobot.printCurrentCoordinates();
	    
	    Robot secondRobot = new Robot(x, y);
	    secondRobot.printCurrentCoordinates();
	    
	    for (int i = 1; i < 3; i++) {
	        secondRobot.moveX(dx);
	        secondRobot.printLastMove();
	        secondRobot.printCurrentCoordinates();
	        secondRobot.moveY(dy);
	        secondRobot.printLastCoordinates();

	        dx += i * i;
	        dy -= i * i;
	    }		
	}
}
