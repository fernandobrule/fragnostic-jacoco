package com.fragnostic.mr.service;

import com.fragnostic.mr.service.api.MrServiceApi;
import com.fragnostic.mr.service.api.MsServiceApi;
import com.fragnostic.mr.service.api.SpeakServiceApi;
import com.fragnostic.mr.service.impl.MrServiceImpl;
import com.fragnostic.mr.service.impl.MsServiceImpl;
import com.fragnostic.mr.service.impl.SpeakServiceImpl;

abstract class AbstractTest {

    String mr = "Mr";
    String ms = "Ms";

    MrServiceApi mrServiceApi = new MrServiceImpl();

    MsServiceApi msServiceApi = new MsServiceImpl();

    SpeakServiceApi speakServiceApi = new SpeakServiceImpl();

}
