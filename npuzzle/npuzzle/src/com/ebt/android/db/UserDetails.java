package com.ebt.android.db;

public class UserDetails {
	private int id;
	private String userName;
	private int moves;
	public UserDetails(){
		
	}
	public UserDetails(String userName, int moves){
		this.userName = userName;
		this.moves = moves;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getMoves() {
		return moves;
	}
	public void setMoves(int moves) {
		this.moves = moves;
	}
	
	
}
