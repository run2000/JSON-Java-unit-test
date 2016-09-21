package org.json.junit;

/**
 * Created by run2000 on 8/24/2016.
 */
public interface MyDefaultBean {

    default long getLongKey() { return 12345L; }
}
