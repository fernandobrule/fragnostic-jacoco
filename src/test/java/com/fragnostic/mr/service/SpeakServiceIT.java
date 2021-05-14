package com.fragnostic.mr.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpeakServiceIT extends AbstractTest {

    @Test
    void canSpeak() {
        assertEquals(String.format("%s %s", mr, ms), speakServiceApi.sayTwoWords(mrServiceApi, msServiceApi));
    }

}
