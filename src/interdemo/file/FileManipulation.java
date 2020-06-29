package interdemo.file;

import exceptions.pack.FileNotFoundException;
import exceptions.pack.SearchFileNotFoundException;
import interdemo.Client.MainApp;
import interdemo.Client.WelcomeScreen;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FileManipulation implements Files {
	
	public FileManipulation()
	{
		new WelcomeScreen().welcome();
	}
	
	
	String directory = "C:\\Users\\mamid\\eclipse-workspace\\SimplilearnProject\\Files";
	File file = new File(directory);
	ArrayList<String> filenames = new ArrayList<String>(Arrays.asList(file.list()));
	boolean check = false;
	Scanner sc = new Scanner(System.in);
	
	
	@Override
	public void sortfiles()
	{
		Collections.sort(filenames);
		System.out.println(filenames+"\n\n");
		MainApp.main(null);
	}
	
	
	@Override
	public void searchfile() throws SearchFileNotFoundException
	{
		System.out.println("Please enter the file name...");
		String file = sc.nextLine();
		if(filenames.contains(file))
			System.out.println("Your search file "+file +" is present in the directory"+"\n\n");
		else
			throw new SearchFileNotFoundException("Sorry, Your search file is not present in the directory"+"\n\n");
		MainApp.main(null);
	}
	
	@Override
	public void deletefile() throws FileNotFoundException
	{
		System.out.println("Please enter the file name...");
		String name = sc.nextLine();
		file = new File(directory+"\\"+name);
		if(file.delete())
			System.out.println("Successfully file "+name+" is deleted from the directory"+"\n\n");
		else
			throw new FileNotFoundException("Exception, "+name+" FileNotFound"+"\n\n");
		MainApp.main(null);
	}
	
	
	@Override
	public void addfile()
	{
		try {
			System.out.println("Please enter the file name..."+"\n\n");
			String name = sc.nextLine();
			file = new File(directory+"\\"+name);
			check = file.createNewFile();
			System.out.println("Successfully file "+name+" is added"+"\n\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MainApp.main(null);
		}
	}
}
