package com.bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListResourceBundle;

import com.bundle.Animal.Type;

public class Farm_fr extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		Object[][]objArray= {
				{"hello","bienvenue dans notre ferme"},
				{"open",new Animal(12,Type.DOG)},
				{"close",new ArrayList<Integer>(Arrays.asList(23,45,67,88))}
				};
	
		return objArray;
	}

}
