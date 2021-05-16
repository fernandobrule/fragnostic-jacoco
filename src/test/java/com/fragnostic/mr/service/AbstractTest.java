package com.fragnostic.mr.service;

import com.fragnostic.mr.service.api.MrServiceApi;
import com.fragnostic.mr.service.api.MsServiceApi;
import com.fragnostic.mr.service.impl.MrServiceImpl;
import com.fragnostic.mr.service.impl.MsServiceImpl;

abstract class AbstractTest {

    MrServiceApi mrServiceApi = new MrServiceImpl();

    MsServiceApi msServiceApi = new MsServiceImpl();

}
