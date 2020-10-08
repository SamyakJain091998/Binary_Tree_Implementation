package com.binary_tree.practice;

public class MyBinaryTree<K extends Comparable<K>> {
	private MyBinaryNode<K> root;
	private boolean resultToBeReturned = false;

	public void add(K key) {
		this.root = this.addRecursively(root, key);
	}

	private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key) {
		// TODO Auto-generated method stub
		if (current == null) {
			return new MyBinaryNode<>(key);
		}
		int compareResult = key.compareTo(current.key);
		if (compareResult == 0)
			return current;
		if (compareResult < 0) {
			current.left = addRecursively(current.left, key);
		} else {
			current.right = addRecursively(current.right, key);
		}
		return current;
	}

	public int getSize() {
		return this.getSizeRecursive(root);
	}

	private int getSizeRecursive(MyBinaryNode<K> current) {
		// TODO Auto-generated method stub
		return current == null ? 0 : 1 + this.getSizeRecursive(current.left) + this.getSizeRecursive(current.right);
	}

	public boolean search(K key) {
		// TODO Auto-generated method stub
		boolean result = this.searchRecursively(this.root, key);
		if (resultToBeReturned == true) {
			return true;
		}
		return false;
	}

	public boolean searchRecursively(MyBinaryNode<K> current, K key) {
		// TODO Auto-generated method stub
		if (current == null) {
			return false;
		}

		int compareResult = key.compareTo(current.key);
		if (compareResult == 0) {
			this.resultToBeReturned = true;
			return true;
		}
		if (compareResult < 0) {
			searchRecursively(current.left, key);
		} else {
			searchRecursively(current.right, key);
		}
		return false;
	}

}
