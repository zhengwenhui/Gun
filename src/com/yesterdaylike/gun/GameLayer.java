package com.yesterdaylike.gun;

import org.cocos2d.actions.base.CCRepeatForever;
import org.cocos2d.actions.interval.CCRotateBy;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

import android.content.Context;

public class GameLayer extends CCLayer{
	CCSprite aPlayer;

	public GameLayer(Context context){
		aPlayer = CCSprite.sprite("player.png");
		CGPoint initPoint = CGPoint.ccp(450, 480);
		aPlayer.setPosition(initPoint);
		this.addChild(aPlayer);

		CCRotateBy rotateBy = CCRotateBy.action(2, -60);
		CCRotateBy rotateBy2 = CCRotateBy.action(4, 120);

		CCSequence sequence = CCSequence.actions(rotateBy, rotateBy2, rotateBy);
		CCRepeatForever repeatForever = CCRepeatForever.action(sequence);
		aPlayer.runAction(repeatForever);
	}
}
