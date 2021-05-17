package com.android;

import java.util.ListResourceBundle;

public class Zoo_de extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{"hello","Hallo mein Freund"},
			{"open","Der Zoo ist geöffnet"}
		};
	}

}
