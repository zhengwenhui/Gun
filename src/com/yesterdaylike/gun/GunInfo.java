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
		//R.drawable.n0,
		R.drawable.n1,
		R.drawable.n2,
		R.drawable.n3,
		R.drawable.n4,
		R.drawable.n5,
		R.drawable.n6,
		R.drawable.n7,
		R.drawable.n8,
		R.drawable.n9,
		R.drawable.n10,
		/*R.drawable.n11,*/
	};
	
	public static int []gunsThumbnails = {
		//0
		R.drawable.handgun0_small,
		R.drawable.handgun1_small, 
		R.drawable.handgun2_small, 
		R.drawable.handgun3_small, 
		R.drawable.handgun4_small, 
		R.drawable.handgun5_small,
		//1
		R.drawable.handgun6_small,
		R.drawable.rifles0_small, 
		R.drawable.rifles1_small, 
		R.drawable.rifles2_small, 
		R.drawable.rifles3_small, 
		R.drawable.rifles4_small, 
		//2
		R.drawable.rifles5_small, 
		R.drawable.rifles6_small, 
		R.drawable.rifles7_small, 
		R.drawable.rifles8_small, 
		R.drawable.rifles9_small, 
		R.drawable.rifles10_small, 
		//3
		R.drawable.tactical_rifle_0_small, 
		R.drawable.tactical_rifle_1_small, 
		R.drawable.tactical_rifle_2_small, 
		R.drawable.tactical_rifle_3_small, 
		R.drawable.tactical_rifle_4_small, 
		R.drawable.tactical_rifle_5_small, 
		//4
		R.drawable.tactical_rifle_6_small, 
		R.drawable.tactical_rifle_7_small, 
		R.drawable.tactical_rifle_8_small, 
		R.drawable.tactical_rifle_9_small, 
		R.drawable.tactical_rifle_10_small, 
		R.drawable.shotgun_0_small, 
		//5
		R.drawable.shotgun_1_small,
		R.drawable.shotgun_2_small,
		R.drawable.shotgun_3_small,
		R.drawable.shotgun_4_small,
		R.drawable.shotgun_5_small,
		R.drawable.shotgun_6_small,
		//5
		R.drawable.shotgun_7_small,
		R.drawable.tactical_shotgun_0_small,
		R.drawable.tactical_shotgun_1_small,
		R.drawable.tactical_shotgun_2_small,
		R.drawable.tactical_shotgun_3_small,
		R.drawable.tactical_shotgun_4_small,
		//6
		R.drawable.tactical_shotgun_5_small,
		R.drawable.tactical_shotgun_6_small,
		R.drawable.tactical_shotgun_7_small, 
		R.drawable.tactical_shotgun_8_small,
		R.drawable.combo_gun_0_small,
		R.drawable.combo_gun_1_small,
		//7
		R.drawable.combo_gun_2_small,
		R.drawable.combo_gun_3_small,
		R.drawable.combo_gun_4_small,
		R.drawable.combo_gun_5_small,
		R.drawable.combo_gun_6_small,
		R.drawable.black_powder_rifle_0_small,
		//8
		R.drawable.black_powder_rifle_1_small,
		R.drawable.black_powder_rifle_2_small,
		R.drawable.black_powder_rifle_3_small,
		R.drawable.black_powder_rifle_4_small,
		R.drawable.black_powder_rifle_5_small,
		R.drawable.revolver_0_small, 
		//9
		R.drawable.revolver_1_small,
		R.drawable.revolver_2_small, 
		R.drawable.revolver_3_small, 
		R.drawable.revolver_4_small, 
		R.drawable.revolver_5_small, 
		R.drawable.revolver_6_small, 
		//11
		R.drawable.revolver_7_small, 
		R.drawable.revolver_8_small, 
		R.drawable.specialty_0_small, 
		R.drawable.specialty_1_small, 
		R.drawable.specialty_2_small, 
		R.drawable.specialty_3_small, 
		//12
		R.drawable.specialty_4_small, 
		R.drawable.specialty_5_small, 
		R.drawable.specialty_6_small, 
		R.drawable.specialty_7_small,
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
