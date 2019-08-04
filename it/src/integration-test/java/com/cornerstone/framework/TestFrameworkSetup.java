package com.cornerstone.framework;

import junit.extensions.TestSetup;
import junit.framework.Test;

public class TestFrameworkSetup extends TestSetup{

	public TestFrameworkSetup(Test test) {
		super(test);
		// TODO Auto-generated constructor stub
	}
	
	protected void setUp() throws Exception
    {
        Init.initialize();
    }

    protected void tearDown() throws Exception
    {
        TearDown.tear();
    }

}
