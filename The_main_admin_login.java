import java.util.*;
import java.io.*;
class The_main_admin_login
{
    void The_Main() throws IOException
    {
        Scanner in = new Scanner(System.in);
        Login user = new Login();
        int attempts = 0;
        do{
            System.out.print("Username: ");
            String username = in.next();
            System.out.print("Password: ");
            String password = in.next();
            user.Check(username,password);
            attempts++;
        }while((user.allowed_pass!=1 || user.allowed_name!=1) && attempts!=3);
        if(attempts==3&&(user.allowed_pass==0||user.allowed_name==0))
        {
            /*If 3 tries are exceeded  we terminate the whole program*/
            System.out.println("You crossed the limit of 3 tries");
        }
        else
        {
            /*All the choices i could think of are here*/
            System.out.println("Hello admin, What would you like to do today?");
            System.out.println("1. View movies\n2. Add movie\n3. Remove movie");
            System.out.println("4. View member data\n5. Add Members\n6. Remove Members");
            System.out.println("7. View data of issued books\n8. Add data of issued books\n9. Remove data of issued books");
            System.out.println("10. View data of particular movie\n11. View data of particular member\n12. Check Availibility of a movie");
            System.out.println("13.Logout");
            Detail_viewer view = new Detail_viewer();
            Display_attributes da = new Display_attributes();
            Editor edit[] = new Editor[3];
            System.out.print("Please enter your choice : ");
            int choice = 0;
            try{
            choice = in.nextInt();}
            catch(InputMismatchException e)
            {
                System.out.println("Please enter valid choice");
            }
            while(choice!=0)
            {
                switch(choice)
                {
                    case 1 : view.movie_detail();
                        break;
                    case 2 : edit[0]  =  new Details_editor();
                             edit[0].adder();
                        break;
                    case 3 : edit[0]  =  new Details_editor();
                             edit[0].remover();
                        break;
                    case 4 : view.member_detail();
                        break;
                    case 5 : edit[1]  =  new Member_data_editor();
                             edit[1].adder();
                        break;
                    case 6 : edit[1]  =  new Member_data_editor();
                             edit[1].remover();
                        break;
                    case 7 : view.Issued_detail();
                        break;
                    case 8 : edit[2]  =  new Issued_details_editor();
                             edit[2].adder();
                        break;
                    case 9 : edit[2]  =  new Issued_details_editor();
                             edit[2].remover();
                        break;
                    case 10 : da.movie_finder();
                        break;
                    case 11 : da.member_finder();
                        break;
                    case 12 : da.availibility();
                              if(da.count!=9 && da.count!=0)
                              {
                                  System.out.println("Would you like to rent this movie?");
                                  String answer = in.nextLine();
                                  answer = in.nextLine();
                                  if(answer.toLowerCase().equals("yes"))
                                  {
                                        Issued_details_editor obj = new Issued_details_editor();
                                        obj.adder();
                                  }
                              }
                        break;
                    case 13 : choice = 0;
                        break;
                    default : System.out.println("Enter correct choice");
                        break;
                }
                System.out.println();
                if(choice!=0)
                {
                    System.out.print("Please enter your choice : ");
                    try{choice = in.nextInt();}
                    catch(InputMismatchException e)
                    {
                        System.out.println("Please enter valid choice");
                    }
                }
            }
            System.out.println("You have been logged out");
        }
    }
}
