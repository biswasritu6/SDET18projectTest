package com.rmgyantra.GenericUtils;

import java.util.Random;

public class JavaUtility {

	public int randomNumber() {
		Random random = new Random();
		int randomData=random.nextInt(5000);
		return randomData;
	}
}
