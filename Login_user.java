import java.util.*;
import java.io.*;
class Login_user
{
    //Scanner in = new Scanner(System.in);
    String passwords[] = new String[50];
    int allowed_name = 0,allowed_pass = 0,existing = 0;
    String usernames[] = new String[50];
    void Check(String username,String password) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("Signin_usernames.txt"));
        String use;
        int j = 0;
        while((use=br.readLine())!=null)
        {
            usernames[j]=use;
            j++;
        }
        int k = 0;
        BufferedReader br1 = new BufferedReader(new FileReader("Signin_passwords.txt"));
        while((use=br1.readLine())!=null)
        {
            passwords[k]=use;
            k++;
        }
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
    void signup(String username,String password) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("Signin_usernames.txt"));
        String use;
        int j = 0;
        while((use=br.readLine())!=null)
        {
            usernames[j]=use;
            j++;
        }
        int k = 0;
        BufferedReader br1 = new BufferedReader(new FileReader("Signin_passwords.txt"));
        while((use=br1.readLine())!=null)
        {
            passwords[k]=use;
            k++;
        }
        int i = 0;
        for(String user_name : usernames)
        {
            if(username.equals(user_name))
            {
                existing =1;
                break;
            }
            i++;
        }
        if(existing == 1)
        {
            System.out.println("This username is already taken");
        }
        else
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Signin_usernames.txt",true));
            writer.write(username);
            writer.write("\n");
            writer.close();
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("Signin_passwords.txt",true));
            writer1.write(password);
            writer1.write("\n");
            writer1.close();
            System.out.println("You are now registered as a member,please complete further formalities");
            Member_data_editor mde = new Member_data_editor();
            mde.adder();
        }
    }
}

