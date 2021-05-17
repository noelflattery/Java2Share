package com.money;

import java.util.ListResourceBundle;

public class Tax_en_IE extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{"tax",new IrishTaxCode()}
		};
	}

}
