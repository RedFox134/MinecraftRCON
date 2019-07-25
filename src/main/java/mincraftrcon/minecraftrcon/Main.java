import java.util.Scanner;
import java.io.IOException;

public class Main
{
    public static void main(String args[])
    {
        NetRcon NR;
        String ip;
        int port;
        String password;
        boolean returnsData = true;
        int receiveTimeout = 1000;
        int sleepTimer = 500;
        Scanner sc = new Scanner(System.in);
        Boolean stop  = false;
        String command = "";
        
        System.out.print("Enter in the IP Address or URL: ");
        ip = sc.next();
        System.out.print("\nEnter in the port number: ");
        port = sc.nextInt();
        System.out.print("\nEnter in the password (Leave blank if none): ");
        password = sc.next();

        //Intitialize session/login/connection
        try
        {
            NR = new NetRcon( ip, port, password, returnsData, receiveTimeout, sleepTimer );
        } catch ( IOException ioe )
        {
            System.out.println("ERROR: " + ioe.getMessage());
        }
        
        //maintain session and continue to ask for commands until exit flag met.
        while ( stop != true )
        {
            try
            {
                NR.sendCommand( command );
            } catch ( InterruptedException ie)
            {
                System.out.println("Command failed to send!  ERROR: " 
                        + ie.getMessage());
            }
        }
        
    }
}