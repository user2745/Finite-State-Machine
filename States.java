
/**
 * This is a general class the for a finite state in transition or start 
 * 
 * @author (Alcinder Lewis) 
 * @version (0.1)
 */
public class States
{
    // instance variables - replace the example below with your own
    private States a; //Pointer to a
    private States b; //Pointer to b
    private States c; //Pointer to a
    private boolean acceptedPlace; //Determines if accept state
    private boolean loop; //Poionter to this state
    private boolean trap; //Trap state 
    private boolean starter; //Tell if starter
    private int placement; // loaction in state in the machine
    private int alphaMax; //How many letter are in Sigma.
    private String looper; //This is a string that holds all the states that point back to this class
    private String id; //This is a id for the state (i.e. b1a2 if you have seen one b and two A's). futher descrpiton for data types hold in system.txt 
    
    /**
     * Constructor for objects of class States
     */
    public States(States a, States b, States c, boolean starter, int placement,int alphaMax, boolean acceptedPlace)
    {
      this.a = a;
      this.b = b;
      this.c = c; 
      this.starter = starter;
      this.placement = placement; 
      this.acceptedPlace = acceptedPlace;
    }

    /**
     * Constructor for objects of class States
     */
    public States(States a, States b, boolean starter, int placement,int alphaMax, boolean acceptedPlace)
    {
      this.a = a;
      this.b = b;
      this.starter = starter;
      this.placement = placement; 
      this.acceptedPlace = acceptedPlace;
    }
    
    /**
     * This allow you to switch a pointer to somewhere else if you have the correct character.
     * @param a The new state that will be transition by having a A.
     */
    public void setA(States a)
    {
        this.a = a;    
    }
     /**
     * This allow you to switch a pointer to somewhere else if you have the correct character.
     * @param a The new state that will be transition by having a B.
     */
    public void setB(States b)
    {
        this.b = b;    
    }
     /**
     * This allow you to switch a pointer to somewhere else if you have the correct character.
     * @param a The new state that will be transition by having a B.
     */
    public void setC(States c)
    {
        this.c = c;
    }
    /**
     * This allows you to change the starter value of the machine. 
     * @param starter is the value that starts the machine.
     */
    public void setStarter(boolean starter)
    {
        this.starter = starter;
    } 
    /**
     *  This allow you to tell others that there is a loop or statement pointing to its self.
     *  @param loop boolean for the loop. (Find out how it looks for this)
     */
    public void setLoop(boolean loop)
    {
        this.loop = loop; 
    }
    /**
     * This allows you to change the descrption of the state.
     * @param id for description.
     * 
     */
    public void setId(String id)
    {
        this.id = id; 
    }
    /**
     * The is determine if the state is an accepted one or not.
     * @param acceptedPlace is the boolean determiner for this.
     */
    public void setAcceptedState(boolean acceptedPlace)
    {
        this.acceptedPlace = acceptedPlace;
    }
    
    
    public boolean getAcceptedPlace()
    {
        return acceptedPlace;
    }
    public boolean getLoops()
    {
        return loop;
    }
    public boolean isStart()
    {
        return starter;
    }
    public String getId()
    {
        return id;
    }
    public String getLoopers()
    {
       return looper;
    }
    public States getA()
    {
     return a;   
    }
    public States getB()
    {
        return b;
    }
    public States getC()
    {
        return c;
    }
    public int getPlacement()
    {
        return placement;
    }
    
    
    public void LoopFinder()
    {
        looper = "";
        if (a == this)
        {
           loop = true;
           looper += "a "; 
        }
        if(b == this)
        {
           loop = true;
           looper += "b ";
        }
        if(c == this)
        {
            loop = true;
            looper += "c";
        }
    }
    
    public void trapFinder()
    {
        if(alphaMax == 3)
        {
            if(looper == "a b c")
            {
                trap = true;
            }
        }
        else if(alphaMax == 2)
        {
            if(looper == "a b ")
            {
                trap = true;
            }
        }
        else
        {
            System.out.println("There has not be updates to account for the Alphabet you have entered");
        }
    }
}
