package DSA2.Stacks;

public class UseQueue {
    public static void main(String[] args) throws QueueIsFullException, QueueIsEmptyException {
        QueueInLL qa=new QueueInLL();
        qa.enqueue(1);
        qa.enqueue(2);
        qa.enqueue(3);
        qa.dequeue();
        qa.enqueue(4);
        qa.enqueue(5);
        while (!qa.isempty())
        {
            System.out.println(qa.dequeue());
        }
        qa.dequeue();;
    }
}
