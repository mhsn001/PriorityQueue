package com.mhsn;

import java.util.ArrayList;
import java.util.List;



/*
 * Child of parent node when indexing starts with 0
 *	left child of a parent = 2p + 1
 *	right child of a parent = 2p + 2  
 *
 *Child of parent node when indexing starts with 1
 *	left child of a parent = 2p
 *	right child of a parent = 2p + 1
 *  
 *where p = position of parent node 
 * 
 * 
 * 
 *Parent of any child node when indexing starts with 0
 *	parent node = (P - 1)/2
 * 
 *Parent of any child node when indexing starts with 1
 *	parent node = P/2
 * 
 *where P = position of any child node. 
 * 
 * 
 * */

// This is priority queue implementation using the max heap concept
public class PriorityQueue {

	private List<Task> heap;
	
	// if want to use Array in place of ArrayList then use below declarations and code will be changed in order to maintain heapSize and capacity
	//int[] heap;
	//private int heapSize;
	//private int capacity;
	
	
	//use below constructor if using capacity factor
	/*public PriorityQueue(int capacity){
		this.capacity = capacity;
		heap = new ArrayList<Task>();
	}*/
	
	public PriorityQueue(){
		heap = new ArrayList<Task>();
	}

	public void insert(String job, int priority){
		
		/*if(heapSize == capacity -1){
			System.out.println("Priority Queue is full");
		}*/
		Task newTask = new Task(job, priority);
	
		// Inserting at the end of the Array or list and then it will be heapified in the further code.
		heap.add(newTask);
		
		// Position of the newly added element 
		int position = heap.size() - 1;
		
		
		// Heapifying the Heap in order to place new element at the right place in the heap
		while(position >= 0 && 
			  heap.get(position).priority > heap.get((position-1)/2).priority // if new elements priority is greater than its parent node priority
			)
		{
			// then replace the newly added element with its parent node.
			Task item = heap.get((position-1)/2);
			heap.set((position-1)/2, heap.get(position)); // replacing
			heap.set(position, item); // replacing
			
			position = (position-1)/2; // updating the position for next iteration
			
		}
				
		printHeap();
	}
	
	// removing the top element
	public void remove(){
		
		if(heap.isEmpty()){
			System.out.println("No elements in the queue");
			return;
		}
		
		
		if(heap.size() > 1){
			
			Task item = heap.remove(heap.size()-1);// Remove the last element(say X) from the heap array
			heap.set(0, item); // replace the element X with root node of the heap
			//int itemPosition
			int position = 0;
			//Heapifying the array by comparing the priority of child nodes with element X
			while(heap.size()-1 >= 2*position +1 ){
				
				//heap.set(position, element)
				item = heap.get(position);
				
				//finding out the position of the greater child node.
				if(heap.size()-1>2*position +2){
					if(heap.get(2*position+1).priority >= heap.get(2*position+2).priority){
						position = 2*position + 1;	
					}else{
						position = 2*position + 2;	
					}
									
				}else {
					position = 2*position + 1;
				}
				
				// Replacing the nodes.
				if(item.priority < heap.get(position).priority){
					Task t = heap.get(position);
					heap.set(position, item);
					heap.set((position-1)/2, t);
				}else{
					break;
				}
			}
							
		}else{
			heap.clear();
		}
				
		printHeap();
		
		
	}
	
	
	public void printHeap(){
		System.out.println();
		for(Task t: heap){
			System.out.print(" "+t.priority);
		}
	}
	
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		System.out.print("Adding elemenats");
		pq.insert("job-50", 50);
		pq.insert("job-40", 40);
		pq.insert("job-45", 45);
		pq.insert("job-30", 30);
		pq.insert("job-35", 35);
		pq.insert("job-12", 12);
		pq.insert("job-38", 38);
		pq.insert("job-20", 20);
		pq.insert("job-25", 25);
		pq.insert("job-24", 24);

		
		System.out.print("\n Removing elemenat");
		pq.remove();
		
		
	}
	
}
