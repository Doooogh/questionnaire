package com.xcyg.project.service;

import com.xcyg.project.entity.SysDept;
import com.xcyg.project.vo.resp.DeptRespNodeVO;

import java.util.List;

public interface DeptService {

    SysDept addDept(SysDept vo);

    void updateDept(SysDept vo);

    SysDept detailInfo(String id);

    void deleted(String id);

    List<DeptRespNodeVO> deptTreeList(String deptId);

    List<SysDept> selectAll();
}
