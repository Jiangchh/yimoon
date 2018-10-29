package com.yimoom.pplay.system.shiro;

public class MyShiroRealm  {/*

    @Resource
    private UserInfoService userInfoService;



    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal(); //获取用户名，默认和login.html中的username对应。
        SysUser userInfo = userInfoService.findByUsername(username);

        if (userInfo == null) {
            //没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常
            return null;
        }

       //验证通过返回一个封装了用户信息的AuthenticationInfo实例即可。
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户信息
                userInfo.getPassword(), //密码
                getName() //realm name
        );
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(userInfo.getCredentialsSalt())); //设置盐

        return authenticationInfo;
    }

    //当访问到页面的时候，链接配置了相应的权限或者shiro标签才会执行此方法否则不会执行
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {


        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser userInfo = (SysUser) principals.getPrimaryPrincipal();

        for (SysRole role: userInfo.getList()) {
            authorizationInfo.addRole(role.getRole_Name());
            for (SysPermission p: role.getPlist()) {
                authorizationInfo.addStringPermission(p.getName());
            }
        }

        return authorizationInfo;
    }
*/}


