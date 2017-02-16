
public class Main {

	public static void main(String[] args) {
		
		Sweeper a = new Sweeper(10, 30);
		Room room = new Room(10, 30);


	}

}

class Sweeper 
{
	
	Point currentPos ;
	Point limit ;
	
	public Sweeper(int w, int l)
	{

		
	}
	
	public void move()
	{
		
		
	}
	
	public void updatePos()
	{
		
		
	}
	
	public Point getCurrent()
	{
		return this.currentPos ;
		
	}
	
	
}

class Room
{
	int width ;
	int length ;
	static int count ;
	Point[] trash ;
	
	public Room(int l, int w)
	{
		width = w ;
		length = l;
		trash= new Point[length*width];
		
	}
	
	void initTrash()
	{
		
		
	}
	
	void clearTrash()
	{
		
		
	}
	
	public void draw(Point sweeper)
	{
		for(int i = 0 ; i < length ;i++)
		{
			for(int j = 0 ; j < width ; j++)
			{
				if(sweeper.x == j && sweeper.y == i)
					System.out.print("@");
				else
					System.out.print("*");	
				
			}
			System.out.println();
			
		}
		
	}
	
	public void update()
	{
		
		
	}
	
	
	
	
}

class Point
{
//	enum clearStatus{a,c};
	public int x ;
	public int y ; 
	public char cFlag ;
		
}