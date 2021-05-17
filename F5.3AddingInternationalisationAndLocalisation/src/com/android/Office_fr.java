package com.android;

import java.util.ListResourceBundle;

public class Office_fr extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		return new String[][] {
			{"hello","Bonjour et bienvenue au bureau"},
			{"open","le bureau est ouvert"}
		};
	}

}
