/*This class is created specifically for us to login, it is just cause it looks fancy, no other reason to have this*/
//import java.util.Scanner;
class Login
{
    //Scanner in = new Scanner(System.in);
    private String passwords[] = {"Password","password"};
    int allowed_name = 0,allowed_pass = 0;
    private String usernames[] = {"Ishika","Greeva"};
    void Check(String username,String password)
    {
        int i = 0;
        for(String user_name : usernames)
        {
            //System.out.println(user_name);
            if(username.equals(user_name))
            {
                allowed_name =1;
                if(password.equals(passwords[i]))
                {
                    allowed_pass = 1;
                    break;
                }
            }
            i++;
        }
        if(allowed_name == 0 || allowed_pass == 0)
        {
            System.out.println("Sorry wrong username or password");
        }
        else
        {
            System.out.println("You are logged in");
        }
    }
}
