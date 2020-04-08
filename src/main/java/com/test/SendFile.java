package com.test;

import FMQJavaAPI.*;

public class SendFile {
    public static void main(String[] args) {
        FMQInterface m_FMQInterface = null;
        try {
            String[] szTargetID;// 目的地地址列表
            int usTargetIDCount;// 目的地地址个数
            String szDataType;// 数据类型
            String szFileDir;// 发送文件所在的目录
            String szFileName;// 发送文件的名称
            String szDestQueue;

            szTargetID= new String[1];
            szTargetID[0]="127.0.0.1";
            usTargetIDCount =1;
            szDataType= "testtest";
            szFileDir ="d:/senddir/";
            szFileName ="test.txt";

            //连接交换平台
            m_FMQInterface = FMQJavaAPI.ConnectFMQ("", 1223);
            m_FMQInterface.SendFile(szTargetID,//目的地
                    usTargetIDCount,//目的地个数
                    "",//目的地队列
                    szDataType,//数据类型
                    (byte)5,//优先级别(0~9)
                    (byte)0,(byte)0,(byte)0,(byte)0,//4个保留字段
                    0,//超时时间 0为永远不超时
                    szFileDir,//发送文件所在的目录
                    szFileName,//文件名称
                    "");//发送到默认队列中
            //提交到操作系统
            m_FMQInterface.Commit();
            //断开与交换平台的连接
            FMQJavaAPI.DisconnectFMQ(m_FMQInterface);
        }catch (FMQException e){
            System.out.print(e.FMQGetLastError());
            System.out.print(e. FMQGetErrorTypeCode());
            System.out.print(e. FMQGetErrorReasonCode ());
            return;

        }
    }
}
