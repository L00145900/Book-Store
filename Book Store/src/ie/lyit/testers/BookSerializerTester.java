package ie.lyit.testers;

import ie.lyit.serialized.BookSerializer;
import ie.lyit.book.Menu;

public class BookSerializerTester 
{
	public static void main(String[] args) 
	{
		//• Create an object of the BookSerializer class
		/*BookSerializer bookSerializer = new BookSerializer();
		//• Call it’s add() method twice, to add two records to the ArrayList
		bookSerializer.add();
		bookSerializer.add();
		//• Call it’s serializeBooks() method to write the entire ArrayList to the File.
		bookSerializer.serializeBooks();*/
		
		
		//• Create an object of the BookSerializer class
		//BookSerializer bookDeserializer = new BookSerializer();
		//• Call it’s deserializeBooks() method to read the entire ArrayList from the File into the ArrayList instance variable
		//bookDeserializer.deserializeBooks();
		//• Call it’s list() method, to list all of the records in the ArrayList.
		//bookDeserializer.list();
		
		
		BookSerializer bookSerializer = new BookSerializer();
		bookSerializer.deserializeBooks();
		
		Menu menuObj = new Menu();
		do
		{
			menuObj.display();
			menuObj.readOption();
			
			switch(menuObj.getOption())
			{
			case 1:bookSerializer.add();break;
			case 2:bookSerializer.list();break;
			case 3:bookSerializer.view();break;
			case 4:bookSerializer.edit();break;  
			case 5:bookSerializer.delete();break;
			case 6:break;
			default:System.out.println("Invailid Option");
			}
		}
		while(menuObj.getOption() != 6);
		
		bookSerializer.serializeBooks();
		
	}
}
