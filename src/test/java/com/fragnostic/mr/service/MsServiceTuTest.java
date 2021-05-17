package com.fragnostic.mr.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MsServiceTuTest extends AbstractTest {

    @Test
    void canSayTu() {
        assertEquals("tu", msServiceApi.tu());
    }
}
