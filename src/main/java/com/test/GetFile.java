package com.test;

import FMQJavaAPI.*;
public class GetFile  {
    public static void main(String[] args) {
        FMQInterface m_FMQInterface = null;
        try {
            String szDataType;//接收数据类型
            String szRcvFileDir; //接收文件存放目录
            StringBuffer szFileName=new StringBuffer("test.txt");

            szDataType=new String("testtest");
            szRcvFileDir=new String("d:/rcvdir");
            //连接交换平台
            m_FMQInterface = FMQJavaAPI.ConnectFMQ("", 1223);
            m_FMQInterface.GetFile(szDataType, //! 数据类型
                    szRcvFileDir,  //! 文件所在的目录
                    szFileName,  //! 输出文件名 最长75字节
                    "",    //! 数据队列名称 (如果填写，数据将从本地数据队列中取出)
                    null,    //! 输出数据的网关头(输入NULL的时候，就不输出网关头)
                    true);   //! 重名是否覆盖
            //提交到操作系统
            m_FMQInterface.Commit();
            //断开与交换平台的连接
            FMQJavaAPI.DisconnectFMQ(m_FMQInterface);
        }
        catch (FMQException e) {
            System.out.print(e.FMQGetLastError());
            System.out.print(e. FMQGetErrorTypeCode());
            System.out.print(e. FMQGetErrorReasonCode ());
            return;
        }
    }
}
