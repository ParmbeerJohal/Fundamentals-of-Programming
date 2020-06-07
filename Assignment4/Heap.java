/*
 * Name: Parm Johal
 * ID: V00787710
 * Date: April 9, 2018
 * Filename: Heap.java
 * Details: \CSC 115\ Assignment 4
 */

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Heap<E extends Comparable<E>> {

	private ArrayList<E> heap;
	private int size;
	private static final int CAPACITY = 100;

	/**
	 * Creates an empty heap.
	 */
	public Heap() {
		heap = new ArrayList<E>(CAPACITY);
		for (int i=0; i<CAPACITY; i++) {
			heap.add(null);
		}
	}
