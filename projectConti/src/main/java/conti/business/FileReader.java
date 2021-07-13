package conti.business;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader implements DataReader {

	@Override
	public void read() {
		// TODO Auto-generated method stub
		try
		{
			File myObj = new File("input");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine())
				{
					String data = myReader.nextLine();
					String[] splitData = data.split(": ");
					System.out.println(splitData[splitData.length - 1]);
					//Integer.parseInt();
				}
			myReader.close();
		} catch (Exception e)
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
