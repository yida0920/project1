package org.apache.commons.text;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

    public static Test suite() {
        TestSuite suite = new TestSuite();

        suite.addTestSuite(AlphabetConverterTest.class);

        return suite;
    }
}