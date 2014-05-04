package com.practice.trees;

public class btreenode
{
	int data;
	btreenode left;
	btreenode right;
	public btreenode(int data)
	{
		this.data = data;
	   left = right = null;
	}
	public btreenode(int data , btreenode left,btreenode right)
	{
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
