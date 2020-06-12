package com.xcyg.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xcyg.project.entity.SysUser;
import com.xcyg.project.vo.req.*;
import com.xcyg.project.vo.resp.LoginRespVO;
import com.xcyg.project.vo.resp.UserOwnRoleRespVO;
import com.xcyg.project.vo.req.LoginReqVO;
import com.xcyg.project.vo.req.RegisterReqVO;
import com.xcyg.project.vo.req.UpdatePasswordReqVO;

import java.util.List;

public interface UserService extends IService<SysUser> {

    String register(RegisterReqVO vo);

    LoginRespVO login(LoginReqVO vo);

    void updateUserInfo(SysUser vo, String operationId);


    IPage<SysUser> pageInfo(SysUser vo);

    SysUser detailInfo(String userId);

    void addUser(SysUser vo);

    void logout();

    void updatePwd(UpdatePasswordReqVO vo, String userId);

    List<SysUser> getUserListByDeptIds(List<String> deptIds);

    void deletedUsers(List<String> userIds,String operationId);

    UserOwnRoleRespVO getUserOwnRole(String userId);

    void setUserOwnRole(String userId,List<String> roleIds);

    void updateUserInfoMy(SysUser vo, String userId);
}
