/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public class PriorityLinkedQueueNGTest {
    
    public PriorityLinkedQueueNGTest() {
    }

    @Test
    public void test() {
        try {
            PriorityLinkedQueue queue = new PriorityLinkedQueue();
            queue.enQueue(10, 1);
            queue.enQueue(20, 2);
            queue.enQueue(30, 2);
            queue.enQueue(50, 3);
            queue.enQueue(80, 1);
            queue.enQueue(70, 3);
            queue.enQueue(90, 2);
            //queue.enQueue(2);
//            System.out.println("Priority Linked queue front element: "
//                    +queue.front());
            //System.out.println("Priority Linked queue size: "+queue.size());
            System.out.println(queue.toString());
//            System.out.println("DEQUEUE? "+queue.deQueue());
//            System.out.println("DEQUEUE? "+queue.deQueue());
//            System.out.println("Contains 50? " +queue.contains(50)+", indexOf: "+queue.indexOf(50));
//            System.out.println("Contains 17? " +queue.contains(17)+", indexOf: "+queue.indexOf(17));
//            System.out.println("Linked queue size: "+queue.size());            
//            System.out.println(queue.toString());

            
        } catch (QueueException ex) {
            Logger.getLogger(ArrayQueueNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
