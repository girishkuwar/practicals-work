class Singleton
{
      private static Singleton uniqueInstance;
      Singleton()
      {
      }
      public static synchronized Singleton getInstance()
	{
		if(uniqueInstance==null)
		{
			uniqueInstance=new Singleton();
		}
		System.out.println(uniqueInstance);
		return uniqueInstance;
		
	}

      
}
public class SingletonPatter
{
	public static void main(String[] args)
	{
		Singleton s=new Singleton();
		s.getInstance();
	}
}