package microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelePhoneDir {

	public static void main(String[] args) {
		Trie t = new Trie();
		String s[] = { "rob", "robs" };
		t.insertContactsArray(s);
		t.getContactList("rob");
	}

}

class TrieNode {
	Map<Character, TrieNode> child;
	boolean isLast;

	public TrieNode() {
		child = new HashMap<>();
		isLast = false;
	}
}

class Trie {
	TrieNode root;

	public void insertContactsArray(String contacts[]) {
		if (root == null)
			root = new TrieNode();
		for (String con : contacts) {
			insert(con.toLowerCase());
		}
	}

	public void insert(String contact) {
		int len = contact.length();
		TrieNode node = root;
		for (int i = 0; i < len; i++) {
			char c = contact.charAt(i);
			TrieNode nextNode = node.child.get(c);
			if (nextNode == null) {
				nextNode = new TrieNode();
				node.child.put(c, nextNode);
			}
			node = nextNode;
			nextNode.isLast = false;
			if (i == len - 1)
				nextNode.isLast = true;
		}
	}

	public List<String> getContactList(String s) {
		int len = s.length();
		String ss = "";
		List<String> list = new ArrayList<String>();
		TrieNode next = root;
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			next = next.child.get(c);
			if ((i == 0 || i < len - 1) && next == null) {
				return list;
			} else if (next != null)
				ss += s.charAt(i);
		}
		getContactUtil(next);
		return list;
	}

	public String getContactUtil(TrieNode next) {
		String s="";
		for (Map.Entry<Character, TrieNode> map : next.child.entrySet()) {
			if(!map.getValue().isLast) {
				s += map.getKey();
				if(map.getValue().child != null)
					getContactUtil(map.getValue());
			}else {
				s += map.getKey();
			}
		}
		return s;
	}

}