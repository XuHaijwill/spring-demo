package com.xhjc.java.base.jvm;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JOLTest {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testJVM(){
        logger.info("{}", VM.current().details());
        logger.info("{}", ClassLayout.parseClass(String.class).toPrintable());
    }

}
