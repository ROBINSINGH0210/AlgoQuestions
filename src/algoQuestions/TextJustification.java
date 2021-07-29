package algoQuestions;

import java.util.*;

public class TextJustification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		int maxWidth = 16;
		System.out.println(new TextJustification().fullJustify(words, maxWidth));
	}

	/*
	 * General Approach: 1.Calculate the maximum number of word each line could pack
	 * -> count 2.Calculate the length of the space of each line = maxWidth - count
	 * 3.Distribute the space as evenly as possible, if we could not distribute
	 * evenly, we add the reminder space from left to right i.At the last line - we
	 * should deal as special case ii.Not at the last line - be careful of the case
	 * when number of the space is not even Specific process: 1. How do we know what
	 * is the maximum number of word we could pack each line? We compare maxWidth
	 * with total of( n-words length + (n-1)Space) e.x ["This", "is", "an",
	 * "example", "of", "text", "justification."] maxWidth = 16 The maximum words we
	 * could insert are "-->This is an" 4+1+2+1+2=10,could we add one more word
	 * "example", obviously impossible
	 * 
	 * 2.To find the number of space in each line, we could just have maxWidth minus
	 * the length of all words in this line In the above example would be 16-10 = 6
	 * --> we will have 6 space at this line
	 * 
	 * 3. When we have the numbers of space, we need to insert the space b.w the
	 * word. How to do so? a. If this line is the last line, it should be left
	 * justified and no extra space is inserted between words. b. If this line is
	 * not the last line, we have another two cases to consider: i.space could be
	 * evenly contributed ii. space could not be evenly contrinuted -> we insert the
	 * remain space from left to right For example ["to","a"] maxWidth = 6 If this
	 * is the last line, we should have "to a  ";Otherwise, we have "to   a"
	 * 
	 * It would be very easy to understand if we just run an simple following
	 * example with the code. ["This", "is", "an", "example", "of", "text",
	 * "justification."] maxWidth = 16
	 */
	public List<String> fullJustify(String[] words, int L) {
		List<String> lines = new ArrayList<String>();
		int index = 0;
		while (index < words.length) {
			int count = words[index].length();
			int last = index + 1;
			while (last < words.length) {
				if (words[last].length() + count + 1 > L)
					break;
				// plus one for the space, if its a perfect fit it will fit
				count += 1 + words[last].length();
				last++;
			}
			StringBuilder builder = new StringBuilder();
			builder.append(words[index]);
			int diff = last - index - 1;
			// if last line or number of words in the line is 1, left-justified
			if (last == words.length || diff == 0) {
				for (int i = index + 1; i < last; i++) {
					builder.append(" ");
					builder.append(words[i]);
				}
				for (int i = builder.length(); i < L; i++) {
					builder.append(" ");
				}
			} else {

				/*
				 * Not the last line case: Total space = maxWidth - the length of total words at
				 * this line The number of space after each word = (maxWidth - count) / gap =
				 * (maxWidth - count) / diff e.x ["This", "is", "an", "example", "of", "text",
				 * "justification."] maxWidth = 16 The number of space after each word = 3 r ->
				 * remaining number of space if the spaces are not divided evenly
				 */
				// middle justified
				int spaces = (L - count) / diff;// The number of space after each word
				int r = (L - count) % diff;// remaining number of space which we should insert from left to right
				for (int i = index + 1; i < last; i++) {
					for (int k = spaces; k > 0; k--) {
						builder.append(" ");
					}
					if (r > 0) {
						builder.append(" ");
						r--;
					}
					builder.append(" ");
					builder.append(words[i]);
				}
			}
			lines.add(builder.toString());
			index = last;
		}
		return lines;
	}
}
