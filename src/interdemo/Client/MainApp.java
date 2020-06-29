package interdemo.Client;

import java.util.*;
import interdemo.file.FileManipulation;


public class MainApp {
	
	static FileManipulation fm = new FileManipulation();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Select 1 to sort files in current directory");
		System.out.println("Select 2 for more options to manipulate files in the curent directory");
		System.out.println("Select 3 to stop the Application.");
		int s= sc.nextInt();
		switch(s)
		{
			case 1:
				fm.sortfiles();
				break;
			case 2:
				System.out.println("Select 1 to add a file in current directory");
				System.out.println("Select 2 to delete a file in current directory");
				System.out.println("Select 3 to search a file in current directory");
				System.out.println("Select 4 to navigate the main context");
				int option = sc.nextInt();
				switch(option)
				{
					case 1:
						fm.addfile();
						break;
					case 2:
						try {
							fm.deletefile();
						} catch (Exception e) {
							System.out.println("Exception occured: "+e);
						}
						finally {
							MainApp.main(null);
						}
						break;
					case 3:
						try {
							fm.searchfile();
						} catch (Exception e) {
							System.out.println("Exception occured: "+e);
						}finally {
							MainApp.main(null);
						}
						break;
					case 4:
						MainApp.main(null);
						break;
					default:
						System.out.println("Your choosen option is not valid...!!!");
						break;
				}
				break;
			case 3:
				System.out.println("Thank you, for visiting");
				System.exit(0);
				break;
			default:
				System.out.println("Your choosen option is not valid...!!!");
				break;
				
		}
		sc.close();
	}

}
