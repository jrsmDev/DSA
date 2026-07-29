import java.util.LinkedList;
import java.util.Queue;

public class Queues {
    public static void main(String[] args) {

        // queue = FIFO data structure. First-In First-out (ex. a line of people)
        //         stores objects into a sort of "horizontal line"
        //         add() = enqueue, offer() =to add to the end of the line
        //         remove() = dequeue, poll() = to remove from the front of the line

        Queue<String> queue = new LinkedList<String>();

        queue.add("Minecraft");
        queue.add("Fortnite");
        queue.add("Roblox");

        //System.out.println(queue.isEmpty());
        //System.out.println(queue.size());
        System.out.println(queue.contains("Roblox"));

        //System.out.println(queue.peek());
        //queue.poll();
        
        
        //System.out.println(queue);


        /*

        System.out.println(queue.remove()); // Minecraft
        System.out.println(queue.remove()); // Fortnite
        System.out.println(queue.remove()); // Roblox

        */

    }

}