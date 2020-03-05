import java.util.Scanner;
/**
 * holds all the pointer and 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Machine
{
    private States current; 
    private States lam;
    private States a;
    private States b;
    private States aa;
    private States ab;
    private States bc;
    private States aac;
    private States abc;
    private States abcc;
    private States bcb;
    private boolean crabcakes;
    /**
     * Constructor for objects of class Machine
     */
    public Machine()
    {
        lam = new States(a, b, lam, true, 1, 3, false);
        a = new States(aa, ab, lam, false, 2, 3, false);
        b = new States(a, b, bc, false, 3, 3, false);
        aa= new States(aa, ab, aac, false, 4, 3, false);
        ab= new States(a, b, abc, false, 5, 3, false);
        bc = new States(a, bcb, lam, false, 6, 3, false);
        aac = new States(aac, aac, aac, false, 7, 3, true);
        abc = new States(a, bcb, abcc, false, 8, 3, false);
        abcc = new States(abcc, abcc, abcc, false, 9, 3, true);
        bcb = new States(bcb, bcb, bcb, false, 10, 3, true);
        current = lam;
       crabcakes = false;
    }
    public void change(char a)
    {
        if(a == 'a')
        {
            current = current.getA();
        }
        else if(a == 'b')
        {
            current = current.getB();
        }
        else if(a == 'c')
        {
            current = current.getC();
        }
        else
        {
            crabcakes = true; 
        }
    }
    public boolean getCarbCakes()
    {
        return crabcakes;
    }
    public boolean finCurrent()
    {
        return current.getAcceptedPlace();
    }
    
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        Machine mac = new Machine();
        while(true)
        {
            System.out.print("You String>");
            String travel = kb.next();
            travel.toLowerCase();
            for(int i = 0; i < travel.length(); i++)
            {
                mac.change(travel.charAt(i));
                if(mac.getCarbCakes() == true)
            {
                System.out.println("Reject");
                break;
            }
             if(mac.finCurrent())
                {
                    System.out.println("Accepted");   
                }
                else
                {
                    System.out.println("Reject");
                }
            }
            // closes the input
            kb.close();

        }
        
    }

}
