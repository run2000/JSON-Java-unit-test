package org.json.junit;

import java.math.BigInteger;

/**
 * Created by run2000 on 8/24/2016.
 */
public class MySubBean extends MySuperBean implements MyDefaultBean {

    @Override
    public BigInteger getNumber() {
        System.out.println("Sub called");
        return new BigInteger("10000");
    }

    public static String getStaticKey() {
        return "static value";
    }

    public MyBean get() {
        return this;
    }

    public int getX() {
        return 4;
    }

    public int getY() {
        return 3;
    }

    public boolean isXYZ() {
        return false;
    }
}
