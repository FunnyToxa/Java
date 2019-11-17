public class LinkedList {
	private class LLNode{
		public Object obj;
		public LLNode next;
		
		public LLNode(Object inObj){
			obj = inObj;
		}
	}
		
	private int size = 0;
	
	private LLNode first, last;
	
	public void add(Object o){
		if (first == null){
			first = new LLNode(o);
			last =  first;
		} else {
			last.next = new LLNode(o);
			last = last.next;
		}
		size += 1;
	}
	
	public void remove(Object o){
		if (first == null)
			return;
		LLNode beforeNode = null;
		LLNode node = first;
		while (node != null) {
			if (o.equals(node.obj)){
				if (beforeNode == null){
					first = first.next;
				} else if (node.next == null) {
					beforeNode.next = null;
				} else {
					beforeNode.next = node.next;
				}
				size -= 1;
				return;
			}
			beforeNode = node;
			node = node.next;
		}
	}
	
	public boolean contains(Object o){
		if (first == null)
			return false;
		LLNode node = first;
		while (node != null){
			if  (o.equals(node.obj))
				return true;
			node = node.next;
		}
		return false;
	}
	
	public void clear(){
		first = last = null;
		size = 0;
	}
	
	public int getSize(){
		return size;
	}
	
	public Object[] toArray(){
		Object[] retObj = new Object[size];
		LLNode node = first;
		int pos = 0;
		while (node != null) {
			retObj[pos] = node.obj;
			node = node.next;
			pos += 1;
		}
		return retObj;
	}
}