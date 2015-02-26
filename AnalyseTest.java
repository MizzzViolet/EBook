

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class AnalyseTest {

	@Test
	public void testSort(){
		/**Test if sorted correctly**/
		List<String> list = Arrays.asList("I","am","silver","and", "exact");
		List<String> expected = Arrays.asList("I","am","and", "exact","silver");	
		
		List<String> list2 = Arrays.asList(" ");
		List<String> expected2 = Arrays.asList(" ");
		
		/**Test different length but starts with the same letter**/
		List<String> list3 = Arrays.asList("a","aa","aa","aaaba", "a", "a");
		List<String> expecte3 = Arrays.asList("a","a","a", "aa","aa", "aaaba");	
		
		/**Test same length**/
		List<String> list4 = Arrays.asList("zo","wo","yo","to", "di", "de");
		List<String> expected4 = Arrays.asList("de","di","to", "wo","yo", "zo");	
		
		assertEquals(Analyse.sort((list)),expected);
		assertEquals(Analyse.sort(list2),expected2);
		assertEquals(Analyse.sort((list3)),expecte3);
		assertEquals(Analyse.sort(list4),expected4);
		
	}
}
