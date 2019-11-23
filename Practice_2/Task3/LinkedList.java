public class LinkedList {
	
	//класс узлов
	private class LLNode{
		public Integer obj;
		public LLNode next;
		public LLNode prev;

		public  LLNode(Integer inObj){ obj = inObj;}

		public LLNode(Integer inObj, LLNode prev){
			obj = inObj;
			this.prev = prev;
		}
	}

	//размер листа
	private int size = 0;

	//ссылка на последний элемент
	private LLNode last;

	//добавление элемента
	public void add(Integer o){
		if (last == null){
			last = new LLNode(o);
		} else {
			last.next = new LLNode(o, last);
			last = last.next;
		}
		size += 1;
	}

	//удаление элемента
	public void remove(Integer o){
		if (last == null)
			return;
		LLNode node = last;
		while (node != null) {
			if (o.equals(node.obj)){
				if (node.next == null){
					node.prev.next = null;
				} else if (node.prev == null) {
					node.next.prev = null;
				} else {
					node.next.prev = node.prev;
					node.prev.next = node.next;
				}
				//Очищаем ссылки у текущего узла
				node.prev = node.next = null;
				node.obj = null;
				size -= 1;
				return;
			}
			node = node.prev;
		}
	}
	
	public boolean contains(Integer o){
		if (last == null)
			return false;
		LLNode node = last;
		while (node != null){
			if  (o.equals(node.obj))
				return true;
			node = node.prev;
		}
		return false;
	}

	//очистка листа
	public void clear(){
		clearNode(last);
		last = null;
		size = 0;
	}

	//рекурсивный метод очистки всех елементов листа
	//очищает ссылки на объект узла, а так же на следующий и предыдущий узлы
	private void clearNode(LLNode node){
		if (node.prev != null)
			clearNode(node.prev);
		node.prev = null;
		node.next = null;
		node.obj = null;
	}

	//возвращает размер листа
	public int getSize(){
		return size;
	}

	//преобразование в массив
	public Integer[] toArray(){
		Integer[] retObj = new Integer[size];
		LLNode node = last;
		int pos = size-1;
		while (node != null) {
			retObj[pos] = node.obj;
			node = node.prev;
			pos--;
		}
		return retObj;
	}
}