package org.json.junit;

import org.json.stream.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
   CDLTest.class,
   CookieTest.class,
   CookieListTest.class,
   PropertyTest.class,
   XMLTest.class,
   JSONMLTest.class,
   HTTPTest.class,
   JSONStringerTest.class,
   JSONObjectTest.class,
   JSONArrayTest.class,
   EnumTest.class,
   JSONPointerTest.class,
   AppendableTest.class,
   BuilderTest.class,
   ParserTest.class
})
public class JunitTestSuite {
}
