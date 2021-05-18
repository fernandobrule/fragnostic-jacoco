package com.fragnostic.playground.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MrServiceTest extends AbstractBase {

    @Test
    void canSayEu() {
        assertEquals("eu", mrServiceApi.eu());
    }

    @Test
    void canSayTu() {
        assertEquals("tu", mrServiceApi.tu());
    }

    @Test
    void canSayEle() {
        assertEquals("ele", mrServiceApi.ele());
    }

    @Test
    void canSayNos() {
        assertEquals("nos", mrServiceApi.nos());
    }

    @Test
    void canSayVos() {
        assertEquals("vos", mrServiceApi.vos());
    }

    @Test
    void canSayEles() {
        assertEquals("eles", mrServiceApi.eles());
    }

}
