package com.bundle;

import java.util.ListResourceBundle;

public class Farm_de extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		String[][]twoDarray= {
				{"hello","hallo und willkommen auf unserem bauernhof"},
				{"open","Die Farm ist jetzt f�r Business ge�ffnet"}
		};
		return twoDarray;
	}

}
