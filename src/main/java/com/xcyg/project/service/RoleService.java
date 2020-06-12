package com.xcyg.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xcyg.project.entity.SysRole;

import java.util.List;

public interface RoleService {

    SysRole addRole(SysRole vo);

    void updateRole(SysRole vo);

    SysRole detailInfo(String id);

    void deletedRole(String id);

    IPage<SysRole> pageInfo(SysRole vo);

    List<SysRole> getRoleInfoByUserId(String userId);

    List<String> getRoleNames(String userId);

    List<SysRole> selectAllRoles();
}
