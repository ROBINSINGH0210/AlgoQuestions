package algoQuestions;

public class SearchWordsInDict {

	public static void main(String[] args) {

//		["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
//				[[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]

		// TODO Auto-generated method stub
		Trie trie = new Trie();
		trie.insert("robin");
		trie.insert("robinsingh");
		trie.insert("singh");

		System.out.println(trie.search("a*"));

	}

}

class Trie {
	TrieNode root = new TrieNode();

	void insert(String str) {
		TrieNode node = root;
		for (int i = 0; i < str.length(); i++) {
			if (node.child[str.charAt(i) - 'a'] == null) {
				node.child[str.charAt(i) - 'a'] = new TrieNode();
			}
			node = node.child[str.charAt(i) - 'a'];
		}
		node.isWord = true;
	}

	boolean search(String str) {
		return recSearch(str, root, 0);
	}

	boolean recSearch(String str, TrieNode node, int i) {
		if (node == null) {
			return false;
		}
		if (i == str.length()) {
			return node.isWord;
		}
		char c = str.charAt(i);
		if (c == '.') {
			for (TrieNode nodes : node.child) {
				if (recSearch(str, nodes, i + 1))
					return true;
			}
			return false;
		} else if (c == '*') {
			for (TrieNode nodes : node.child) {
				if(recSearch(str, nodes, i + 1) || recSearch(str, nodes, i))
					return true;

			}
			return false;
		} else {
			TrieNode child = node.child[c - 'a'];
			return recSearch(str, child, i + 1);
		}

	}

}

class TrieNode {
	TrieNode[] child = new TrieNode[26];
	boolean isWord;
}
