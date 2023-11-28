public class Log  
{
    public static boolean value = true;
    
    public static void info(String input)
    {
        if(value)
        {
            System.out.println(input);
        }
    }
    
    public static void info(int input)
    {
        if(value)
        {
            System.out.println(input);
        }
    }
    
    public static void info(double input)
    {
        if(value)
        {
            System.out.println(input);
        }
    }
}
