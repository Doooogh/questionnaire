package com.xcyg.project.service.impl;

import com.xcyg.project.entity.SysDept;
import com.xcyg.project.entity.SysUser;
import com.xcyg.project.service.DeptService;
import com.xcyg.project.service.HomeService;
import com.xcyg.project.service.PermissionService;
import com.xcyg.project.service.UserService;
import com.xcyg.project.vo.resp.HomeRespVO;
import com.xcyg.project.vo.resp.PermissionRespNode;
import com.xcyg.project.vo.resp.UserInfoRespVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private UserService userService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private PermissionService permissionService;

    @Override
    public HomeRespVO getHomeInfo(String userId) {


        SysUser sysUser = userService.detailInfo(userId);
        UserInfoRespVO vo = new UserInfoRespVO();

        if (sysUser != null) {
            BeanUtils.copyProperties(sysUser, vo);
            SysDept sysDept = deptService.detailInfo(sysUser.getDeptId());
            if (sysDept != null) {
                vo.setDeptId(sysDept.getId());
                vo.setDeptName(sysDept.getName());
            }
        }

        List<PermissionRespNode> menus = permissionService.permissionTreeList(userId);

        HomeRespVO respVO = new HomeRespVO();
        respVO.setMenus(menus);
        respVO.setUserInfo(vo);

        return respVO;
    }
}
