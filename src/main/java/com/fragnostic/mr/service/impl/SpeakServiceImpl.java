package com.fragnostic.mr.service.impl;

import com.fragnostic.mr.service.api.SpeakApi;
import com.fragnostic.mr.service.api.SpeakServiceApi;

public class SpeakServiceImpl implements SpeakServiceApi {

    @Override
    public String sayTwoWords(final SpeakApi mrSpeakApi, final SpeakApi msSpeakApi) {
        return String.format("%s %s", mrSpeakApi.speak(), msSpeakApi.speak());
    }

}
