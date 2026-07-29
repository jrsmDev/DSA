import java.util.Stack;

// stack = LIFO data structure. Last-In First-out
        //         stores objects into a sort of "vertical tower"
        //         push() = to add to the top
        //         pop() = to remove from the top

public class StackDemo {
    public static void main(String[] args) {
    
        Stack<String> stack = new Stack<String>();

        stack.push("Minecraft");
        stack.push("Fortnite");
        stack.push("Roblox");
        stack.push("CSGO");
        stack.push("Valorant");

        //stack.pop();

        //String myFavGame = stack.pop();
        //System.out.println(stack.peek());
        //System.out.println(stack.search("GTA V"));
        //System.out.println(stack);

        /* 
        System.out.println(stack.pop()); // Roblox
        System.out.println(stack.pop()); // Fortnite
        System.out.println(stack.pop()); // Minecraft
        */

        /* 
        for(int i = 0; i < 1000; i++) {
            stack.push("GTA V");
        }
        */

        /*
         uses of stacks: 
         1. undo.redo features in the text editors 
         2. moving back and forward through browser history
         3. backtracking algorithms (maze, file directories)
         4. calling functions (call stack)
        */

    }
}