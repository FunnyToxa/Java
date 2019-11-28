public class LinkedList extends List {
	
	//класс узлов
	private class LLNode{
		public Integer obj;
		public LLNode next;
		public LLNode prev;

		public  LLNode(Integer inObj){ obj = inObj.intValue();}

		public LLNode(Integer inObj, LLNode prev){
			obj = inObj.intValue();
			this.prev = prev;
		}

		public void setObj(Integer obj) {
			this.obj = obj.intValue();
		}
	}

	//размер листа
	private int size = 0;

	//ссылка на последний элемент
	private LLNode last;

	public LinkedList(Integer[] inArr){
		for(Integer i: inArr){
			this.add(i);
		}
	}

	public LinkedList(){}

	//добавление элемента в конец
	@Override
	public void add(Integer o){
		if (last == null){
			last = new LLNode(o);
		} else {
			last.next = new LLNode(o, last);
			last = last.next;
		}
		size ++;
	}

	//добавление элемента в указанную позицию
	@Override
	public boolean add(int pos, Integer val) {
		if (pos >= size)
			return false;
		LLNode node = getNode(pos);
		LLNode newNode = new LLNode(val, node.prev);
		newNode.next = node;
		//меняем ссылки у предыдущего и следующего элементов
		node.prev.next = newNode;
		node.prev = newNode;
		size++;
		return true;
	}

	@Override
	public int getMin() {
		LLNode node = last;
		int min = node.obj;
		while (node !=null) {
			if (node.obj < min)
				min = node.obj;
			node = node.prev;
		}
		return  min;
	}

	@Override
	public int getMax() {
		LLNode node = last;
		int max = node.obj;
		while (node !=null) {
			if (node.obj > max)
				max = node.obj;
			node = node.prev;
		}
		return  max;
	}

	//получение значения по позиции
	@Override
	public Integer get(int pos) {
		LLNode node = getNode(pos);
		if (node == null)
			return null;
		else
			return node.obj;
	}

	//получение узла по номеру позиции
	private LLNode getNode(int pos) {
		LLNode node = last;
		int curPos = size -1;
		while (pos != curPos && node != null){
			node = node.prev;
			curPos--;
		}
		return node;
	}

	//изменение значения по позиции
	@Override
	public void modify(int pos, Integer newVal) {
		LLNode node = getNode(pos);
		if (node != null)
			node.obj = newVal;
	}

	//удаление элемента по позиции
	@Override
	public boolean remove(int pos){
		if (last == null)
			return false;
		LLNode node = getNode(pos);

		if (node != null){
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
			return true;

		}
		return false;
	}

	//проверка на вхождение
	@Override
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
	@Override
	public int getSize(){
		return size;
	}

	//преобразование в массив
	@Override
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

	@Override
	public void printSorted(boolean isDesc) {
		System.out.println("Вывод отсортированного листа, сортировка по " + (isDesc ? "убыванию" : "возростанию"));
		Integer[] tmpArr = this.toArray();
		quickSort(tmpArr, 0, tmpArr.length-1, isDesc);
		print(tmpArr);
	}

	@Override
	public void print() {
		Integer[] tmpArr = this.toArray();
		print(tmpArr);
	}
}