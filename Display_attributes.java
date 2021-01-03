import java.io.*;
import java.util.*;
/* This class is to display overview, and we can similarly work on others maybe, there must be a better way obviously */
class Display_attributes
{
    int count = 0;
    void movie_finder() throws IOException
    {
        /*This method is to find details of a particular movie*/
        Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader("Movie_Details.txt"));
        String use;
        System.out.println("Please enter movie to search : ");
        String movie = in.nextLine();
        while((use = br.readLine())!=null)
        {
            if(use.toLowerCase().contains(movie.toLowerCase()))//since case sensitive
            {
                break;
            }
        }
        if(use!=null)
        {
            System.out.println("The details of required movie is ");
            System.out.println(use);
        }
        else
        {
            System.out.println("Such a movie doesn't exist");
        }
    }
    void member_finder() throws IOException
    {
        /*This method is to find details of a particular member*/
        Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader("Members_data.txt"));
        String use;
        System.out.println("Please enter member name to search : ");
        String mem_name = in.nextLine();
        while((use = br.readLine())!=null)
        {
            if(use.toLowerCase().contains(mem_name.toLowerCase()))//since case sensitive
            {
                break;
            }
        }
        if(use!=null)
        {
            System.out.println("The details of required member is ");
            System.out.println(use);
        }
        else
        {
            System.out.println("Such a member doesn't exist");
        }
    }
    void issued_finder(String mem_name) throws IOException
    {
        /*This method is to find details of a particular member*/
        BufferedReader br = new BufferedReader(new FileReader("Issued_books_details.txt"));
        String use;
        while((use = br.readLine())!=null)
        {
            if(use.toLowerCase().contains(mem_name.toLowerCase()))//since case sensitive
            {
                break;
            }
        }
        if(use!=null)
        {
            System.out.println("The details of required member is ");
            System.out.println(use);
        }
        else
        {
            System.out.println("Member hasn't issued any movie");
        }
    }
    void member_finder(String mem_name) throws IOException
    {
        /*This method is to find details of a particular member*/
        BufferedReader br = new BufferedReader(new FileReader("Members_data.txt"));
        String use;
        while((use = br.readLine())!=null)
        {
            if(use.toLowerCase().contains(mem_name.toLowerCase()))//since case sensitive
            {
                break;
            }
        }
        if(use!=null)
        {
            System.out.println("The details of required member is ");
            System.out.println(use);
        }
        else
        {
            System.out.println("Member doesn't exist");
        }
    }
    void availibility() throws IOException
    {
        Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader("Issued_books_details.txt"));
        String use;
        System.out.println("Which movie would you like to check availibility for?");
        String movie = in.nextLine();
        System.out.println(movie);
        BufferedReader br1 = new BufferedReader(new FileReader("Movie_Details.txt"));
        String extra;
        int available=0;
        while((extra = br1.readLine())!=null)
        {
            if(extra.toLowerCase().contains(movie.toLowerCase()))
            {
                available=1;
                break;
            }
        }
        if(available==1)
        {
            while((use = br.readLine())!=null)
            {
                if(use.toLowerCase().contains(movie.toLowerCase()))
                {
                    count++;
                }
            }
            if(count==9)
            {
                System.out.println("Sorry, this movie cannot be rented");
            }
            else
            {
                System.out.println("This movie is available for rent");
            }
        }
        else
        {
            System.out.println("Required mvoie is not available");
        }
    }
}
