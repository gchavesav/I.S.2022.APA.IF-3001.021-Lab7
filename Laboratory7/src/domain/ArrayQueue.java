/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public class ArrayQueue implements Queue {
    private int n; //total de elementos
    private int front, rear; //anterior y posterior
    private Object queue[];

    //Constructor
    public ArrayQueue(int n){
        if(n<=0) System.exit(-1); //error
        this.n = n;
        this.queue = new Object[n];
        this.rear = n-1;
        this.front = rear;
    }
    
    @Override
    public int size() {
        return rear-front;
    }

    @Override
    public void clear() {
        this.queue = new Object[n];
        this.rear = n-1;
        this.front = rear;
    }

    @Override
    public boolean isEmpty() {
        return front==rear;
    }

    @Override
    public int indexOf(Object element) throws QueueException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void enQueue(Object element) throws QueueException {
        if(size()==this.queue.length){
            throw new QueueException("Array Queue is full");
        }
        //la primera, cuando la cola esta vacia, no entra al for
        for (int i = front; i < rear; i++) {
            this.queue[i] = this.queue[i+1];
            
        }
        this.queue[rear] = element;
        front--; //siempre queda en una casilla vacia
    }

    @Override
    public Object deQueue() throws QueueException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean contains(Object element) throws QueueException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object peek() throws QueueException {
        return this.queue[front+1];
    }

    @Override
    public Object front() throws QueueException {
        return this.queue[front+1];
    }
    
}
