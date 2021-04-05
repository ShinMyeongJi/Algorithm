public interface QueueIF {
    boolean isEmpty();
    void enqueue(Object data);
    void dequeue();
    Object peek();
    void clear();
}
