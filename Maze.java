import java.util.Scanner;
import java.io.*;

public class Maze{

	static int[][] maze;
	static int locX = 0, locY = 0, startX = 0, startY = 0, endX, endY;
	static char undone = 'N';
	static Stack<Character> movements = new Stack<Character>();
	static final int LIMIT = 500;
	
	public static void main(String arg[]) throws IOException{
		
		boolean won = false;
		char move;
		reader();
		System.out.println("The maze: ");
		for (int i = 0; i < maze.length; i++){
			for(int j = 0; j < maze[0].length; j++){
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
		movements.push('S');
		int i = 0;
		while (!(won)){
			//System.out.println("X: " + locX + " Y: " + locY);
			i++;
			if (i == LIMIT) break;
			maze[locY][locX] = 2;
			if (locX == endX && locY == endY){
				System.out.println("Maze complete");
				break;
			}
			if (locX == 0){			
				if(maze[locY][locX + 1] == 0){
					movements.push('R');
					locX++;
					continue;
				}
			}
			
			if (locY == 0){
				if(maze[locY+1][locX] == 0){
					movements.push('D');
					locY++;
					continue;
				}			
			}
			
			if (locX == maze[0].length - 1){
				if(maze[locY][locX - 1] == 0){
					movements.push('L');
					locX--;
					continue;
				}
			}
			
			if (locY == maze.length - 1){
				if(maze[locY - 1][locX] == 0){
					movements.push('U');
					locY--;
					continue;
				}
			}
			
			if (locX > 0 && locX < maze[0].length - 1){
				if(maze[locY][locX + 1] == 0){
					movements.push('R');
					locX++;
					continue;
				}
				if(maze[locY][locX - 1] == 0){
					movements.push('L');
					locX--;
					continue;
				}
			}
			
			if (locY > 0 && locY < maze.length - 1){
			if(maze[locY + 1][locX] == 0){
					movements.push('D');
					locY++;
					continue;
				}
				if(maze[locY - 1][locX] == 0){
					movements.push('U');
					locY--;
					continue;
				}			
			}
			
			undone = movements.pop();
			if (undone == 'S') {
				System.out.println("Unsolvable");
				break;
			}
			else {
			
				if(undone == 'D'){
					locY--;
					continue;
				}
				if(undone == 'U'){
					locY++;
					continue;
				}
				if(undone == 'R'){
					locX--;
					continue;
				}
				if(undone == 'L'){
					locX++;
					continue;
				}
			
			}
			
			
		}
		
		PrintRoute();
		
		 
	}
	
	public static void reader() throws IOException{
		
		System.out.println("Please enter a file name: ");
		Scanner key = new Scanner(System.in);
		String name = key.nextLine();
		File readIn = new File(name);
		//File readIn = new File("maze3.txt");
		Scanner scan = new Scanner(readIn);
		Scanner lineParse;
		String line;
		int x = 0, y = 0;
		while (scan.hasNext()){
			scan.nextLine();
			y++;
		}
		scan.close();
		scan = new Scanner(readIn);
		line = scan.nextLine();
		lineParse = new Scanner(line);
		while(lineParse.hasNext()){
			lineParse.next();
			x++;	
		}
		maze = new int[y][x];
		scan.close();
		lineParse.close();
		scan = new Scanner(readIn);
		String temp;
		for (int i = 0; i < y; i++){
			line = scan.nextLine();
			lineParse = new Scanner(line);
			for (int j = 0; j < x; j++){
				temp = lineParse.next();
				if(temp.equals("0")){
					maze[i][j] = 0;
				}
				else if(temp.equals("1")){
					maze[i][j] = 1;
				}
				else if(temp.equals("S")){
					maze[i][j] = 0;
					startX = j;
					startY = i;
				}
				else if(temp.equals("E")){
					maze[i][j] = 0;
					endX = j;
					endY = i;
				}
			}
			lineParse.close();
		
		}
		locX = startX;
		locY = startY;
	}
	
	public static void PrintRoute(){
		
		Stack<Character> reverse = new Stack<Character>();
		int n = movements.length();
		for (int i = 0; i < n; i++){
			reverse.push(movements.pop());
		}
		for (int i = 0; i < n; i++){
			System.out.println(i + ": " + reverse.pop());
		}
	}

}
