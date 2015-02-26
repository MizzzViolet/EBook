/**
 * Authour: Jasmine Talukder
 * Date: 06 December 2014
 */

//import java.util.regex.Pattern;
//import java.util.regex;
import java.lang.Character;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Analyse {
	static String arr[];		/** Store unsorted words in array**/
	public static int count = 0;
	static char a, s;
	static String word = "";

	public static void main(String[] args) throws EOFException {

		SimpleCharacterReader stream = new SimpleCharacterReader();
		List<String> list = new ArrayList<>();
		String str = "";
		/** Need to know how may words we have**/
		count(stream);
		SimpleCharacterReader st = new SimpleCharacterReader();
		store(st);	
		/**Store valid words in list to sort later**/
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != " " && arr[i] != null) {
				str = arr[i];
			}
			list.add(str);
		}
		sort(list); /**Sort list**/
		print(list);/**Print list**/
	}
	public static List<String> sort(List<String> list){
		/** We use string compare to sort the list by length first then Collections.sort will sort it alphabetically  **/
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length()) { /**Second string length is greater than first string length**/
					return -1;
				} else if (o1.length() > o2.length()) {/**Second string length is less than first string length**/
					return 1;
				} else {		/** Equal **/
					return o1.compareTo(o2);
				}
			}
		});
		return list;
	}
	/** Simply prints the length and sorted words. Sorted by their length first then alphapetically. **/
	public static void print(List<String> list) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(list.get(i).length() + " - " + list.get(i));
		}
	}
	/** Counts how many words **/
	public static void count(SimpleCharacterReader stream) {
		try {
			while (true) {
				a = getReader(stream);
				/** When a space, next line or tab is met, we assume a word was met. **/
				if ((a == ' ') || (a == '\n') || (a == '\t')) {
					count++;
				}
			}
		} catch (EOFException eof) {
			stream.Dispose();
		}
		arr = new String[count];
	}
	/** Gets the characters **/
	public static char getReader(ICharacterReader reader) throws EOFException {
		return reader.GetNextChar();		
	}
	/** Store unsorted words in array **/
	public static void store(ICharacterReader info) throws EOFException {
		int i = 0;
		while (i < count) {
			s = info.GetNextChar();
			if (Character.isLetterOrDigit(s)) {
				word += Character.toString(s);
			} else if (s == ' ' || s == '\n' || s == '\t') {
				arr[i++] = word;
				word = "";
			}
		}
	}
}
