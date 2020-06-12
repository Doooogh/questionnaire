package com.xcyg.project.service;

import com.xcyg.project.vo.resp.HomeRespVO;

public interface HomeService {

    HomeRespVO getHomeInfo(String userId);
}
