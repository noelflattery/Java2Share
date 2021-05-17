package com.bundle;

import java.util.ListResourceBundle;

public class Farm_de extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		String[][]twoDarray= {
				{"hello","hallo und willkommen auf unserem bauernhof"},
				{"open","Die Farm ist jetzt für Business geöffnet"}
		};
		return twoDarray;
	}

}
