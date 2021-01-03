import java.util.Scanner;
import java.io.*;
import java.time.*;
import java.time.temporal.Temporal;
abstract class Editor
{
    abstract void adder() throws IOException;
    abstract void remover() throws IOException;
}
class Details_editor extends Editor
{
    //This array is to store attributes of a entry
    String[] details = {"Name ","Genre ","Certification ","Lead actor/actress ","Overview","Rating ","Price ","Year "};
	void adder() throws IOException
	{
	    /*This method is for adding movie details, check the .txt file to see how it is being put in*/
	    Scanner in = new Scanner(System.in);
		FileWriter fw = new FileWriter("Movie_Details.txt",true);
		int ch;
		System.out.println("Enter number of movies you would like to add");
		int t = in.nextInt();
		for(int iter = 0;iter < t;iter++)
        {
            if(iter==0)
            {
               String q = in.nextLine();
            }
            for(int ext = 0;ext < details.length;ext++)
            {
                /*This is for appending even the attribute name from the array*/
                System.out.print(details[ext]+" : ");
                for(int i = 0;i < details[ext].length();i++)
                {
                    fw.append(details[ext].charAt(i));
                }
                fw.append(':');
                String s = in.nextLine();
                /*This is for appending the detail entered by user*/
                for(int i = 0;i < s.length();i++)
                {
                    fw.append(s.charAt(i));
                }
                fw.append(' ');
            }
            fw.append('\n');
        }
        fw.close();
        System.out.println("Details added");
	}
	void remover() throws IOException
    {
        //This method is to remove a particular movie entry, it takes only movie as input
        Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader("Movie_Details.txt"));
        System.out.print("Enter movie name to remove ");
        String movie = in.nextLine();
        String use;
        int contain = 0;
        while((use = br.readLine())!=null)
        {
            if(use.toLowerCase().contains(movie.toLowerCase()))
            {
                contain = 1;
                break;
            }
        }
        br.close();
        BufferedReader br1 = new BufferedReader(new FileReader("Movie_Details.txt"));
        if(contain == 1)
        {
            File of = new File("Temp.txt");
            PrintWriter pw = new PrintWriter("Temp.txt");
            label: while((use = br1.readLine())!=null)
            {
                if(use.toLowerCase().contains(movie.toLowerCase()))
                {
                    continue label;
                }
                pw.println(use);
            }
            pw.flush();
            File nf = new File("Movie_Details.txt");
            nf.delete();
            br1.close();
            nf.createNewFile();
            //if(of.renameTo(nf))
                //System.out.println("Movie Removed");
            BufferedReader br2 = new BufferedReader(new FileReader("Temp.txt"));
            PrintWriter pw1 = new PrintWriter("Movie_Details.txt");
            while((use = br2.readLine())!=null)
            {
                pw1.println(use);
            }
            br2.close();
            pw1.flush();
            System.out.println("Movie Removed");
        }
        else
        {
            System.out.println("No such movie exists");
        }
    }
}
class Member_data_editor extends Editor
{
    //This array is to store attributes of a entry
    String[] member_details = {"Name ","Contact no. ","Age "};
	void adder() throws IOException
	{
	    /*This method is for adding member details, check the .txt file to see how it is being put in*/
	    Scanner in = new Scanner(System.in);
		FileWriter fw = new FileWriter("Members_data.txt",true);
        /*This is for appending even the attribute name from the array*/
        for(int ext = 0;ext < member_details.length;ext++)
        {
            System.out.print(member_details[ext]+" : ");
            for(int i = 0;i < member_details[ext].length();i++)
            {
                fw.append(member_details[ext].charAt(i));
            }
            fw.append(':');
            fw.append(' ');
            String s = in.nextLine();
            /*This is for appending the detail entered by user*/
            for(int i = 0;i < s.length();i++)
            {
                fw.append(s.charAt(i));
            }
            fw.append(' ');
        }
        fw.append('\n');
        fw.close();
        System.out.println("Details added");
	}
	void remover() throws IOException
    {
        //This method is to remove a particular movie entry, it takes only movie as input
        Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader("Members_data.txt"));
        System.out.print("Enter member name to remove ");
        String movie = in.nextLine();
        String use;
        int contain = 0;
        while((use = br.readLine())!=null)
        {
            if(use.toLowerCase().contains(movie.toLowerCase()))
            {
                contain = 1;
                break;
            }
        }
        br.close();
        BufferedReader br1 = new BufferedReader(new FileReader("Members_data.txt"));
        if(contain == 1)
        {
            File of = new File("Temp.txt");
            PrintWriter pw = new PrintWriter("Temp.txt");
            label: while((use = br1.readLine())!=null)
            {
                if(use.toLowerCase().contains(movie.toLowerCase()))
                {
                    continue label;
                }
                pw.println(use);
            }
            pw.flush();
            File nf = new File("Members_data.txt");
            nf.delete();
            br1.close();
            nf.createNewFile();
            //if(of.renameTo(nf))
                //System.out.println("Movie Removed");
            BufferedReader br2 = new BufferedReader(new FileReader("Temp.txt"));
            PrintWriter pw1 = new PrintWriter("Members_data.txt");
            while((use = br2.readLine())!=null)
            {
                pw1.println(use);
            }
            br2.close();
            pw1.flush();
            Issued_details_editor edit = new Issued_details_editor();
            edit.remover();
            System.out.println("Member Removed");
        }
        else
        {
            System.out.println("No such member exists");
        }
    }
}

class Issued_details_editor extends Editor
{
    //This array is to store attributes of a entry
    String[] details = {"Member name","Movie", "Date of issue","Date of return"};
	void adder() throws IOException
	{
	    /*This method is for adding movie details, check the .txt file to see how it is being put in*/
	    Scanner in = new Scanner(System.in);
		FileWriter fw = new FileWriter("Issued_books_details.txt",true);
		int ch,contains=0;
        label : for(int ext = 0;ext < details.length;ext++)
        {
            String s;
            /*This is for appending even the attribute name from the array*/
            if(ext == 0 || ext == 1)
            {
                System.out.print(details[ext]+" : ");
            }
            if(ext == 2)
            {
                LocalDate today = LocalDate.now();
                s = today.toString();
            }
            else if(ext == 3)
            {
                Period period = Period.ofDays(14);
                Temporal temp = period.addTo(LocalDate.now());
                s = temp.toString();
            }
            else
            {
            /*This is for appending the detail entered by user*/
                s = in.nextLine();
            }
            if(ext == 0)
            {
                BufferedReader br = new BufferedReader(new FileReader("Issued_books_details.txt"));
                String use;
                while((use=br.readLine())!=null)
                {
                    if(use.toLowerCase().contains(s.toLowerCase()))
                    {
                        contains = 1;
                        System.out.println(s+" has already rented a movie, please return it to rent another one");
                        break label;
                    }
                }
            }
            if(contains==0)
            {
                for(int i = 0;i < details[ext].length();i++)
                {
                    fw.append(details[ext].charAt(i));
                }
                fw.append(':');
                for(int i = 0;i < s.length();i++)
                {
                    fw.append(s.charAt(i));
                }
                fw.append(' ');
            }
        }
        if(contains==0)
        {
            fw.append('\n');
            System.out.println("Details added");
        }
        fw.close();
	}
	void remover() throws IOException
    {
        //This method is to remove a particular movie entry, it takes only member as input
        Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader("Issued_books_details.txt"));
        System.out.print("Enter member name to remove ");
        String member = in.nextLine();
        String use;
        int contain = 0;
        while((use = br.readLine())!=null)
        {
                if(use.toLowerCase().contains(member.toLowerCase()))
                {
                    contain = 1;
                    break;
                }
        }
        br.close();
        BufferedReader br1 = new BufferedReader(new FileReader("Issued_books_details.txt"));
        if(contain == 1)
        {
            File of = new File("Temp.txt");
            PrintWriter pw = new PrintWriter("Temp.txt");
            label: while((use = br1.readLine())!=null)
            {
                if(use.toLowerCase().contains(member.toLowerCase()))
                {
                    continue label;
                }
                pw.println(use);
            }
            pw.flush();
            File nf = new File("Issued_books_details.txt");
            nf.delete();
            br1.close();
            nf.createNewFile();
            BufferedReader br2 = new BufferedReader(new FileReader("Temp.txt"));
            PrintWriter pw1 = new PrintWriter("Issued_books_details.txt");
            while((use = br2.readLine())!=null)
            {
                pw1.println(use);
            }
            br2.close();
            pw1.flush();
            System.out.println("Record Removed");
        }
        else
        {
            System.out.println("No such record exists");
        }
    }
}

