/*
 * Gerardo Hernandez
 * HW2-2
 * Due Date 02/19/2017
 */

import java.util.Scanner ;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		int rows = 15, cols = 30 ;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the columns: ");
		cols = input.nextInt();
		
		System.out.print("Enter the rows: ");
		rows = input.nextInt();
		
		Room room = new Room(rows, cols);
		Sweeper a = new Sweeper((int)rows/2, (int)cols/2);
		
		room.initTrash();
		a.setLimit(room.dimension());
		
		while(room.getCount() > 0 )
		{
			room.draw(a.getCurrent());
			a.move();
			//Thread.sleep(10);

		}
		
		input.close();

	}

}

class Sweeper 
{
	
	Point currentPos ;
	Point limit ;
	
	public Sweeper(int x, int y)
	{
		currentPos = new Point();
		this.currentPos.x = x ;
		this.currentPos.y = y ;
		
	}
	
	public void move()
	{
		switch(randMove())
		{
		case 'w' :
		case 'W' :
			if(currentPos.x-1 > 0)
			 currentPos.x -= 1 ;
			break ;
		case 's':
		case 'S':
			if(currentPos.x+1 <= limit.x)
			currentPos.x += 1 ;
			break ;
		case 'a':
		case 'A':
			if(currentPos.y-1 > 0)
			currentPos.y -= 1 ;
			break ;
		case 'd':
		case 'D':
			if(currentPos.y+1 <= limit.y)
			currentPos.y += 1 ;
			break ;
		
		}
		
	}
		
	public Point getCurrent()
	{
		return this.currentPos ;
		
	}
	
	public void setLimit(Point l)
	{
		limit = new Point();
		limit.x = l.x ;
		limit.y = l.y ;
		
	}
	
	char randMove()
	{
		char dir = 'w';
		
		switch((int)(Math.random()*100) % 4)
		{
		case 0 :
			dir = 'w' ;
			break ;
		case 1 :
			dir = 'a';
			break ;
		case 2 :
			dir = 's';
			break ;
		case 3 :
			dir = 'd';
			break ;
		}
					
		return dir ;
	}
	
	
}

class Room
{
	int cols ;
	int rows ;
	static int count ;
	char[][] trash ;

	
	public Room(int r, int c)
	{
		cols = c ;
		rows = r;
		count = cols * rows ;
		trash = new char[rows][cols];

		
	}
	
	void initTrash()
	{
		for(int i = 0 ; i < rows ; i++)
		{
			for(int j = 0 ; j < cols ; j++)
			{
				trash[i][j] = '*';
			}
			
		}
	}
	
	void clearTrash(Point sweeper)
	{

		if(trash[sweeper.x-1][sweeper.y-1] == '*' )
		{
			trash[sweeper.x-1][sweeper.y-1] =' ' ;
			count-- ;
		}
			
		
	}
	
	public void draw(Point sweeper)
	{
		clearTrash(sweeper);
		
		for(int i = 0 ; i < rows ; i++)
		{
			for(int j = 0 ; j < cols ; j++)
			{
				if(i == sweeper.x-1 && j == sweeper.y-1)
				{
					System.out.print("@");
				}
				else
				{
					System.out.print(trash[i][j]);
				}
			}
			System.out.println();
			
		}
		
	}
	
	public Point dimension()
	{
		Point d = new Point();
		d.x = rows ;
		d.y = cols ;
		return d ;
	}
	
	public int getCount()
	{
		return count ;
		
	}
	
	
	
}

class Point {

	public int x ;
	public int y ; 
		
}

