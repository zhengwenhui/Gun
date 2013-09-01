package com.yesterdaylike.gun;

public class Guninfo {
	public String name;
	public int gun;
	public int bg;
	public int fire;
	public int sound;
	public int description;
	public int capacity;
	
	public Guninfo(int gun,int bg,int fire,int sound) {
		// TODO Auto-generated constructor stub
		this.gun = gun;
		this.bg = bg;
		this.fire = fire;
		this.sound = sound;
	}
	public Guninfo(String name,int gun,int bg,int fire,int sound) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.gun = gun;
		this.bg = bg;
		this.fire = fire;
		this.sound = sound;
	}
	
	public Guninfo(String name,int gun,int bg,int fire,int sound,int description,int capacity) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.gun = gun;
		this.bg = bg;
		this.fire = fire;
		this.sound = sound;
		this.description = description;
		this.capacity = capacity;
	}
}
