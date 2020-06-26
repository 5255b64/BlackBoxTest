package edu.ecnu.sqslab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbeInfoTest {

    @Test
    public void probeInfoTest(){
        String input = "ACCURATE_PROBE cn.com.cfets.data.coretransaction.fx.DealLog <init> DealLog.java 116 1 ()V";
        ProbeInfo pi = new ProbeInfo(input);
        assertEquals("cn.com.cfets.data.coretransaction.fx.DealLog", pi.getClassName());
        assertEquals("<init>", pi.getFuncName());
        assertEquals("DealLog.java", pi.getFileName());
        assertEquals(116, pi.getLineNum());
        assertEquals("1", pi.getThreadNum());
        assertEquals("()V", pi.getFuncSignature());
    }
}