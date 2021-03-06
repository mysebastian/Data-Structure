
public class Array<E> {
    private E[] data;
    private int size;

    //有参构造 传入数组的容量capacity
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    //  无参构造 默认数组容量为capacity=10
    public Array() {
        this(10);
    }

    //    获取数组数组中元素的个数
    public int getSize() {
        return size;
    }

    //    获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //    判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //    在第index个位置添加元素e
    public void add(int index,E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add Failed,required index>=0 and index<=size");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i+1]=data[i];
        }
            data[index]=e;
            size++;
    }

    //    在数组末尾添加元素
    public void addLast(E e) {
        add(size, e);
    }

    //    在数组最前面添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    //打印数组
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }

        }
        res.append("]");
        return res.toString();
    }

    //    查询index处元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,Index is illegal");
        }
        return data[index];
    }

    //    修改index处的值为e
    public void set(int index,E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed,Index is illegal");
        }
        data[index]=e;
    }

    //    查找是否包含元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e) ) {
                return true;
            }
        }
        return false;
    }
    //  查找元素e 并返回其位置
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //    删除index处的元素 并返回这个删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Delete failed,index id illegal");
        }
        E ret = data[index];
        for (int i = index+1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size]=null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    //    删除第一个元素
    public E removeFirst() {
        return  remove(0);
    }

    //    删除最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    //    按值删除
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
          remove(index);
        }
    }

    //    动态改变数组容量
    private void resize(int newCapacity) {
        E[] newData= (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
