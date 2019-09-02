package practice;

import java.util.*;

public class LRUCache {
	Queue<Page> pageQueue;
	Map<Integer, Page> pageMap;
	int capicity = 20;

	public LRUCache(int capicity) {
		this.pageMap = new HashMap<Integer, Page>(capicity);
		this.pageQueue = new LinkedList<Page>();
		this.capicity = capicity;
	}

	public void accessPage(int pageNum) {
		Page page = this.pageMap.get(pageNum);
		if (page != null) {
			System.out.println(page.getPageNo());
			if(pageQueue.remove(page))
				pageQueue.add(page);
		} else {
			page = new Page(pageNum);
			if (this.pageMap.size() == this.capicity) {
				Page removedPage = this.pageQueue.poll();
				pageMap.remove(removedPage.getPageNo());
				System.out.println("Removed page " + removedPage.getPageNo());
			}
			this.pageMap.put(pageNum, page);
			this.pageQueue.add(page);
		}
	}

	public static void main(String[] args) {
    LRUCache cache = new LRUCache(6);
    cache.accessPage(2);
    cache.accessPage(3);
    cache.accessPage(4);
    cache.accessPage(2);
    cache.accessPage(4);
	}

}

class Page {
	private int pageNo;

	public Page(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageNo() {
		return this.pageNo;
	}
}