package com.zhiyou.Game.CarRental.CarRental;

public class test {

    /**
     *      练习汽车租赁
     *     1查看所有租赁汽车信息
     *     2按照车牌号 查询汽车信息
     *     3租赁汽车
     *     4归还汽车
     *     5新增租赁汽车
     *     6删除租赁汽车
     *     7.退出e
     *     把汽车信息保存在 文本
     */

    public static void main(String[] args)  throws Exception{

        Menu menu = new Menu();
        //Info info = new Info();
        //info.Init();//初始化
        menu.OperationMenu();
    }
}
