package com.fragnostic.mr.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MsServiceTest extends AbstractBase {

    @Test
    void canSayYo() {
        assertEquals("yo", msServiceApi.yo());
    }

    @Test
    void canSayTu() {
        assertEquals("tu", msServiceApi.tu());
    }

    @Test
    void canSayEl() {
        assertEquals("el", msServiceApi.el());
    }

    @Test
    void canSayNosotros() {
        assertEquals("nosotros", msServiceApi.nosotros());
    }

    @Test
    void canSayVosotros() {
        assertEquals("vosotros", msServiceApi.vosotros());
    }

    @Test
    void canSayEllos() {
        assertEquals("ellos", msServiceApi.ellos());
    }

}
