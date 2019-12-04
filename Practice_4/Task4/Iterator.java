public class Iterator<T>{
    //позиция текущего элемента
    private int pos = -1;
    //входной массив
    private T[] tmpArr;

    //конструктор принимающий массив
    public Iterator(T[] inArr){
        tmpArr = inArr;
    }

    //проверяем есть ли следуюищй элемент
    public boolean hasNext(){
        return tmpArr.length - pos > 1;
    }

    //получаем следующий элемент
    public T next(){
        //сначала проверяем есть ли следующий элемент
        //иначе оставляем текущую позицию
        if (hasNext()){
            pos++;
        }
        return tmpArr[pos];
    }


    //получаем предыдущий элемент
    public T prev(){
        //контролируем чтобы позиция не была ниже 0
        pos--;
        if (pos < 0)
            pos = 0;
        return tmpArr[pos];
    }
}
