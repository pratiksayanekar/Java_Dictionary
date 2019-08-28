import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

public class Dictionary {

	public LinkedHashMap<String, StringBuilder> addDictionary(String path) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
			String inputLine = null;
			LinkedHashMap<String, StringBuilder> dictionary = new LinkedHashMap<>();
			int lineNo = 0;
			while ((inputLine = reader.readLine()) != null) {
				lineNo++;
				// Ignore empty lines.
				if (inputLine.equals(""))
					continue;

				// Split the input line.
				String[] words = inputLine.split("\\s+");

				int Position = 0;
				for (String word : words) {

					Position++;
					// Remove any commas and dots.
					word = word.replace(".", "");
					word = word.replace(",", "");

					if (!dictionary.containsKey(word)) {
						dictionary.put(word, new StringBuilder("LineNo:" + lineNo + " Position:" + Position));
					} else if (dictionary.containsKey(word)) {
						dictionary.get(word).append(" ---> LineNo:" + lineNo + " Position:" + Position);
					}
				}
			}
			reader.close();
			return dictionary;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

public StringBuilder searchWord(String word, LinkedHashMap<String, StringBuilder> dictionary) {
	StringBuilder output = null;
	if(dictionary.containsKey(word))
		output = dictionary.get(word);
	if(null!=output)
		return output;
	return output;
}
	
}