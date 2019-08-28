import java.util.LinkedHashMap;
import java.util.Scanner;

public class Input {

	public static void main(String[] args) {
		Dictionary d = new Dictionary();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Path along with file name and extension: ");
		String path = in.nextLine();
		System.out. println("Entered Path is : "+ path);
		
		LinkedHashMap<String, StringBuilder> dictionary = d.addDictionary(path);
		System.out.println("Enter word to be search: ");
		String word = in.nextLine();
		StringBuilder output = d.searchWord(word, dictionary);
		if(null!= output)
			System.out.println(output);

	}

}
