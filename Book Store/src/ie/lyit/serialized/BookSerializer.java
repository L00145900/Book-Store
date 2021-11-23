package ie.lyit.serialized;

import java.util.ArrayList;
import java.util.Scanner;

import ie.lyit.book.Book;
import java.io.*;


public class BookSerializer 
{
	private ArrayList<Book> books;
	private final String FILENAME = "books.ser";
	
	public BookSerializer()
	{
		books = new ArrayList<Book>();
	}
	
	public void add()
	{
		//• Create a Book object
		Book book = new Book();
		//• Call it’s read() method, to read the Book details from the user,
		book.read();
		//• Add that Book object to the ArrayList instance variable using the ArrayList add() method.
		books.add(book);
	}
	
	public void list()
	{
		for(Book tmpBook:books)
		{
			System.out.println(tmpBook);
		}
	}
	
	public void serializeBooks()
	{
		try 
		{
			//• Create a FileOutputStream object, passing the name of the binary File to be created
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
			//• Connect it to an ObjectOutputStream object
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			//• Call its writeObject() method to write the entire ArrayList instance variable to the file
			os.writeObject(books);
			//• Call its close() method to close the file.
			os.close();
		}
		catch(FileNotFoundException fNFE)
		{
			System.out.println("Cannot create file " + FILENAME + ".");
		}
		catch(IOException ioE)
		{
			System.out.println(ioE.getMessage());
		}
	}
	
	public void deserializeBooks()
	{
		try 
		{
			//• Create a FileInputStream object, passing the name of the binary File that was created in B.
			FileInputStream fileStream = new FileInputStream(FILENAME);
			//• Connect it to an ObjectInputStream object.
			ObjectInputStream is = new ObjectInputStream(fileStream);
			//• Call its readObject() method to read the entire ArrayList from the file into the ArrayList instance variable.
			books=(ArrayList<Book>)is.readObject();
			//• Call its close() method to close the file.
			is.close();
		}
		catch(FileNotFoundException fNFE)
		{
			System.out.println("Cannot create file " + FILENAME + ".");
		}
		catch(IOException ioE)
		{
			System.out.println(ioE.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public Book view()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("ENTER LIBRARY NUMBER OF BOOK");
		int bookToView=keyboard.nextInt();//Read the key field
		
		for(Book tmpBooks:books)//Loop every book in the array
		{
			if(tmpBooks.getLibraryNumber() == bookToView)//If key equals find book
			{
				System.out.println(tmpBooks);//Display the object
				return tmpBooks;//Return the book
			}
		}	
		System.out.println("Book not found");
		return null;
	}
	
	public void delete()
	{
		Book bookToDelete = view();
		
		if(bookToDelete != null)
		{
			books.remove(bookToDelete);
		}
		else
		{
			System.out.println("Book not found");
		}
	}
	
	public void edit() 
	{
		Book bookToEdit = view();
				
		if(bookToEdit != null)
		{
			int index = books.indexOf(bookToEdit);
			
			bookToEdit.read();
			
			books.set(index, bookToEdit);
		}
		else
		{
			System.out.println("Book not found");
		}
	}
}
