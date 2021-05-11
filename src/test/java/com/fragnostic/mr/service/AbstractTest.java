package com.fragnostic.mr.service;

import com.fragnostic.mr.service.api.MrServiceApi;
import com.fragnostic.mr.service.impl.MrServiceImpl;

abstract class AbstractTest {

    MrServiceApi mrServiceApi = new MrServiceImpl();

}
