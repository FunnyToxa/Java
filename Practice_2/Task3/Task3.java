public class Task3 {
	public static void main(String[] args){
		LinkedList list = new LinkedList();
		
		System.out.println("Size = " + list.getSize());
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(1);
		list.add(8);
		System.out.println("Size after add 5 elems= " + list.getSize());
		list.remove(4);
		System.out.println("Size after remove 1 elem= " + list.getSize());
		
		System.out.println("Print all elems:");
		Integer[] arr = list.toArray();
		for(Integer o: arr)
			System.out.println(o.toString());
		
		System.out.println("4 contains? - " + list.contains(4));
		System.out.println("1 contains? - " + list.contains(1));
		
		list.clear();
		list.add(7);
		System.out.println("Size after clear and add 1 elem - " + list.getSize());
		System.out.println("8 contains? - " + list.contains(8));
	}
}