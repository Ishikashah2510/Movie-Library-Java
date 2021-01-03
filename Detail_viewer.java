import java.util.*;
import java.io.*;
/*Here, we are viewing the details at a whole, we could have done it in the editor class, but i thought
if we have to view a single detail, then it would be better in a seperate class*/
class Detail_viewer
{
    //for movie details
    void movie_detail() throws IOException
    {
        FileReader fr = new FileReader("Movie_Details.txt");
        int ch;
        while((ch=fr.read())!=-1)
        {
            System.out.print((char) ch);
        }
        fr.close();
    }
    //for member details
    void member_detail() throws IOException
    {
        FileReader fr = new FileReader("Members_data.txt");
        int ch;
        while((ch=fr.read())!=-1)
        {
            System.out.print((char) ch);
        }
        fr.close();
    }
    //for issued movie details
    void Issued_detail() throws IOException
    {
        FileReader fr = new FileReader("Issued_books_details.txt");
        int ch;
        while((ch=fr.read())!=-1)
        {
            System.out.print((char) ch);
        }
        fr.close();
    }
}
