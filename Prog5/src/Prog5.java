/*
 * COSC 310-001   Assignment 5

 * Prog5.java
 *
 * This class reads an html document and matches the tags
 * 
 * @author  Owen Morris

 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Prog5
{
    public static void main(String[] args) throws FileNotFoundException
    { 
    	int count = 0;
        Scanner inFile1 = new Scanner(new File("html2.txt"));
        Scanner inFile2 = new Scanner(new File("html1.txt"));
        MyStack<String> stack = new MyStack<String>();
        
        // reads the first html file
        while(inFile1.hasNextLine())
        {
            count++;
            String line = inFile1.nextLine();
            String tag = getTag( line );

            if( tag == null )
            {
            	System.out.println( "Record " + count + " is not an HTML tag: " + tag );
            }
            else if( tag.charAt(0) == '/' )
            {
            	System.out.println( "Record " + count + " is an end HTML tag: " + tag );
                tag = tag.substring(1);
                if(stack.pop().compareTo(tag) == 0)
                {
                	System.out.println("Tags are a match ");
                }
            }
            else
            {
            	System.out.println( "Record " + count + " is a start of an HTML tag: " + tag );
                stack.push(tag);
            }
        }

        if(stack.Empty())
        {
            System.out.println("The input file is a matched HTML document\n\n");
        }

        while(stack.Empty() == false)
        {
            System.out.println("Mismatched tags: ");
            System.out.println(stack.pop());
        }
        
        //reads the second html file
        while(inFile2.hasNextLine())
        {
            count++;
            String line = inFile2.nextLine();
            String tag = getTag( line );

            if( tag == null )
            {
            	System.out.println( "Record " + count + " is not an HTML tag: " + tag );
            }
            else if( tag.charAt(0) == '/' )
            {
            	System.out.println( "Record " + count + " is an end HTML tag: " + tag );
                tag = tag.substring(1);
                if(stack.pop().compareTo(tag) == 0)
                {
                	System.out.println("Tags are a match ");
                }
            }
            else
            {
            	System.out.println( "Record " + count + " is a start of an HTML tag: " + tag );
                stack.push(tag);
            }
        }

        if(stack.Empty())
        {
            System.out.println("The input file is a matched HTML document");
        }

        while(stack.Empty() == false)
        {
            System.out.println("Mismatched tags: ");
            System.out.println(stack.pop());
        }
    }
    
    
	




/*
 * Gets html tag from a string
 * 
 * @param String read from file
 * @return String html tag
 */
public static String getTag( String record )
{
    int start = record.indexOf( "<" );            // find index of < start of tag
    if( start < 0 )                               // if no < in string, return null
    {
        return null;
    }
    int end = record.indexOf( ">" );              // find index of > end of tag
    String tag = record.substring( start+1, end );
    return tag;    
}
}
