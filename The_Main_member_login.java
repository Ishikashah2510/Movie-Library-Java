import java.util.*;
import java.io.*;
class The_Main_member_login
{
    void The_Main() throws IOException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("1.Login\n2.Signup");
        System.out.print("Enter your choice ");
        int choice = 0;
        try{choice = in.nextInt();}
        catch(InputMismatchException e)
        {
            System.out.println("Please enter valid choice");
        }
        int attempts2=0,attempts=0;
        String username=null,password=null;
        Login_user user = new Login_user();
        switch(choice)
        {
            case 1 :
                    do{
                        System.out.print("Username: ");
                        username = in.next();
                        System.out.print("Password: ");
                        password = in.next();
                        user.Check(username,password);
                        attempts++;
                    }while((user.allowed_pass!=1 || user.allowed_name!=1) && attempts!=3);
                    break;
            case 2 :
                    do{
                        System.out.println("Username must be same as member name");
                        System.out.print("Username : ");
                        if(attempts2==0)
                            username = in.nextLine();
                        username = in.nextLine();
                        System.out.print("Password : ");
                        password = in.nextLine();
                        user.signup(username,password);
                        attempts2++;
                    }while(attempts2!=3 && user.existing!=0);
                    break;
            default : System.out.println("Please enter correct choice");
                    break;
        }
        if((attempts2==3&&(user.existing==1))||(attempts==3&&(user.allowed_pass==0||user.allowed_name==0)))
            System.out.println("You crossed the limit of 3 tries");
        else{
        System.out.println("Welcome member,what would you like to do today?");
        System.out.println("1. View movies\n2. View your data of issued books\n3. View your data");
        System.out.println("4. Search for a movie\n5. check availibility of a movie\n6. Logout");
        Detail_viewer view = new Detail_viewer();
        Display_attributes da = new Display_attributes();
        while(choice!=0)
        {
            System.out.println("Enter your choice");
            choice = in.nextInt();
            switch(choice)
            {
                case 1 : view.movie_detail();
                        break;
                case 2 : da.issued_finder(username);
                        break;
                case 3 : da.member_finder(username);
                        break;
                case 4 : da.movie_finder();
                        break;
                case 5 : da.availibility();
                        break;
                case 6 : choice=0;
                        break;
                default : System.out.println("Please enter correct choice");
                        break;
            }
        }
        }
    }
}
