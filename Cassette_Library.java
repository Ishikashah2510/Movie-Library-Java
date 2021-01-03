import java.util.Scanner;
import java.io.*;
class Cassette_Library
{
    public static void main(String args[]) throws IOException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello,Please enter your choice \n1. Admin\n2. Member");
        System.out.print("Choice ");
        int choice = in.nextInt();
        switch(choice)
        {
            case 1 : The_main_admin_login admin = new The_main_admin_login();
                    admin.The_Main();
                    break;
            case 2 : The_Main_member_login member = new The_Main_member_login();
                    member.The_Main();
                    break;
            default: System.out.println("sorry,not an option");
        }
    }
}
