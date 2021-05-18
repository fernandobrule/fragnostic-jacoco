package com.fragnostic.playground.service;

import com.fragnostic.playground.service.api.MrServiceApi;
import com.fragnostic.playground.service.api.MsServiceApi;
import com.fragnostic.playground.service.impl.MrServiceImpl;
import com.fragnostic.playground.service.impl.MsServiceImpl;

abstract class AbstractBase {

    MrServiceApi mrServiceApi = new MrServiceImpl();

    MsServiceApi msServiceApi = new MsServiceImpl();

}
