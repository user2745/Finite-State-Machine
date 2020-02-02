import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FiniteStateMachine {
    private final static int[][] STATE_TABLE = {
        {  1,  2, 0, 5 },
        {  3,  5, 0, 5 },
        {  1,  2, 6, 5 },
        {  3,  5, 4, 5 },
        {  4,  4, 4, 5 },
        {  1,  2, 7, 5 },
        {  1,  8, 0, 5 },
        {  1,  8, 9, 5 },
        {  8,  8, 8, 5 },
        {  9,  9, 9, 5 },
    };

    private BufferedReader in;

    public FiniteStateMachine() 
    {
        in = new BufferedReader(
                 new InputStreamReader(System.in));
    }

    public void run() throws IOException 
    {
        char ch;
        int  state;
        for (;;) 
        {
            System.out.print("Enter your string: ");
            ch    = (char) in.read();

            // set state to start state
            state = 0;   
                   
            while (ch != '\n') {
               state = STATE_TABLE[state][charToColumn(ch)];
               ch    = (char) in.read();
            }

            // determine whether to accept or reject
            if (state == 8 || state == 4 || state == 9) { 
                System.out.println("Accept\n");
            } else {
                System.out.println("Reject\n");
            }
        }
    }
    public int charToColumn(char ch) {
        // column 2 is for some unexpected character
        int column = 3;

        switch( ch ) 
        {
        case 'a':
            column = 0;
            break;

        case 'b':
            column = 1;
            break;
        case 'c':
            column = 2;
            break;
        }

        return column;
    }

    public static void main(String[] args) {
        try {
            FiniteStateMachine fsm = new FiniteStateMachine();
            fsm.run();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
