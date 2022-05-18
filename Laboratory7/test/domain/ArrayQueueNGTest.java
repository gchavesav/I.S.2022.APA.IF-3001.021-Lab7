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
public class ArrayQueueNGTest {
    
    public ArrayQueueNGTest() {
    }

    @Test
    public void test() {
        try {
            ArrayQueue queue = new ArrayQueue(7);
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
            
        } catch (QueueException ex) {
            Logger.getLogger(ArrayQueueNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}