package com.zhiyou.Game.CarRental.CarRentalPlus;

import java.util.List;

public class CarRentalApp {
    public static void main(String[] args) throws Exception{
        //===============初始化
        CarUtil cu = new CarUtil();
        UserUtil uu = new UserUtil();
        cu.init();
        uu.init();
        //================测试
//        List<Car> cuList = cu.getCarList();
//        System.out.println(cuList.size());
//        List<User> uuList = uu.getUserList();
//        System.out.println(uuList.size());

        //===============获取登录对象
        User user = uu.login();
        if (user == null){
            System.out.println("账号或密码错误");
        }else if ("Admin".equals(user.getRole().getRole())){
            System.out.println("==================管理员功能");
            uu.adminOperation();
        }else if ("User".equals(user.getRole().getRole())){
            System.out.println("==================用户功能");
            uu.userOperation();
        }
    }
}
