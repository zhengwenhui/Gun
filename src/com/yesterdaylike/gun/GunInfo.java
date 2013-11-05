package com.yesterdaylike.gun;

public class GunInfo {
	public String name;
	public int gun;
	public int bg;
	public int fire;
	public int sound;
	public int description;
	public int capacity;
	
	public static int []number = {
		R.drawable.n0,
		R.drawable.n1,
		R.drawable.n2,
		R.drawable.n3,
		R.drawable.n4,
		R.drawable.n5,
		R.drawable.n6,
		R.drawable.n7,
		R.drawable.n8,
		R.drawable.n9,
	};
	
	public GunInfo(int gun,int bg,int fire,int sound) {
		// TODO Auto-generated constructor stub
		this.gun = gun;
		this.bg = bg;
		this.fire = fire;
		this.sound = sound;
	}
	public GunInfo(String name,int gun,int bg,int fire,int sound) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.gun = gun;
		this.bg = bg;
		this.fire = fire;
		this.sound = sound;
	}
	
	public GunInfo(String name,int gun,int bg,int fire,int sound,int description,int capacity) {
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
