public abstract class List implements IList {
    //быстрая сортировка
    protected void quickSort(Integer[] inArray, int begin, int end, boolean isDesc) {
        if (end <= begin)
            return;
        int pivot = partition(inArray, begin, end, isDesc);
        quickSort(inArray, begin, pivot-1, isDesc);
        quickSort(inArray, pivot+1, end, isDesc);
    }
    private int partition(Integer[] inArray, int begin, int end, boolean isDesc) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (inArray[i].intValue() < inArray[pivot].intValue() && !isDesc) {
                Integer temp = inArray[counter];
                inArray[counter] = inArray[i];
                inArray[i] = temp;
                counter++;
            }
            if (inArray[i].intValue() > inArray[pivot].intValue() && isDesc) {
                Integer temp = inArray[counter];
                inArray[counter] = inArray[i];
                inArray[i] = temp;
                counter++;
            }
        }
        Integer temp = inArray[pivot];
        inArray[pivot] = inArray[counter];
        inArray[counter] = temp;

        return counter;
    }

    protected void print(Integer[] tmpArray) {
        System.out.println("Вывод массива: ");
        for (Integer i: tmpArray)
            System.out.print(i + " ");
        System.out.println();
    }
}
