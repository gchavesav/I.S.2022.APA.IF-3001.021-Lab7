/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.annotations.Test;

/**
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public class LinkedQueueNGTest {
    
    public LinkedQueueNGTest() {
    }

    @Test
    public void test() {
        try {
            LinkedQueue queue = new LinkedQueue();
            queue.enQueue(10);
            queue.enQueue(20);
            queue.enQueue(30);
            queue.enQueue(50);
            queue.enQueue(80);
            queue.enQueue(70);
            queue.enQueue(90);
            //queue.enQueue(2);
            System.out.println("Array queue front element: "
                    +queue.front());
            System.out.println("Array queue size: "+queue.size());
            System.out.println(queue.toString());
            System.out.println("DEQUEUE? "+queue.deQueue());
            System.out.println("DEQUEUE? "+queue.deQueue());
//            System.out.println("Contains 50? " +queue.contains(50)+", indexOf: "+queue.indexOf(50));
//            System.out.println("Contains 17? " +queue.contains(17)+", indexOf: "+queue.indexOf(17));
            System.out.println("Array queue size: "+queue.size());            
            System.out.println(queue.toString());

            
        } catch (QueueException ex) {
            Logger.getLogger(ArrayQueueNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
