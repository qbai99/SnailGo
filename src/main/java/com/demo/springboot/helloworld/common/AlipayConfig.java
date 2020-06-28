package com.demo.springboot.helloworld.common;

import com.demo.springboot.helloworld.common.domain.LogerUtil;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static final String app_id="2016102700770232";//例：2016082600317257
    // 商户私钥，您的PKCS8格式RSA2私钥
    public static final String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCXZA0MFlXRQDe7vzeZijraEiEsN01EeBdNiGrmIn57Ql1il+5pFHhxNU6VL7HBF5TtaIk+Q0zMVnvecrUTunQlcoiaps3Ua/0fNC3Py8f3Zsy43hzGZqCKD2dERVo1H+buBrYwUmG3RccbpFe5fyi2XrQrbO+LE/rhuiJESFkJZxnMXAHFQn9Lgid7IqrTQJKq8ku+42DMV21T3Jm/OUVWtPR00DJmeoZWoCozus65b6OFkvWLCA6cVhlxA3+17uWuSVBeDrMFZhZ+h199qv6TGbbgnyBEH/ur1D0j9MFf3CNgcQtLIkLf9khxNrtHFPdSXMTMnePeCwHvPzqKFTP9AgMBAAECggEATuhQQJ+XpVRyeEJHiZjZ6fYPIkvE005A3yGejksmX7qMkCoektifmmothmbwoHNZJZEaD8DmU480SxLAvQKvLSGQgAM3P2P18ACzbB6MILCNPkJO/z5YqP00VwpK5Wu2YxROe8tEsVEGYar8KmxT3RJpmETUakpEtsjcuXh4KAStlvVPJYV+2y7Tl64gQZt4hyN3mA06NyJljqiU/epNMZ343ADiKk0OgA+29O41+dxZ4WWJPgVqZnCtKzt6Nprd3cqN4JiJwqMnZz0x/PjNc8ksdawVgcVVNrJLrzTHcB3MI9dE4oWpG7p/skkGm7Lm5u54q9sqKis5GUOPZ478YQKBgQDcFLEDtfbhtCeb6sCXHYGS9CSE3B4FudIoyqu2X4W3d/JENH1HSEPHBxC2IXw19noYuvfO2NRbjPiQaimMSa+IC8so15DSpa3LFHBBJPapCjeO3k/GJneiW8o41ydq750QXr5CMW2dP1Z+PX8R0cDDEUwCDkHNcu/WtCNMZQD7SQKBgQCwGWNBbYg9/tpuQdoOBCd4JNnh3oAe7Wdlwgy3KxijKYm8OE6OMarlfmIv8z00FtdTqi6sRX+ugSjDS89Gis8W0rNtRExhibgN8VRBgFYRG1N79kjxZ9pftm5J3c6dRqahI9UHg9oL8AW9cNQcgaF/GgRcSw16oWo1vekqeTzfFQKBgQCIh+mc5LkJImtkJcletjZZRU6Wgbu6T6IaHklSdYYN4MKSH4IMw78QbMioRLO7AnKSfwMW9psfRKA7bzDhUCEuJCrf5oN4usHLd52APH8tNSJsZmxVAC49sfYNNyTECWyF6FDd3a4j3FQ7Mslu85JDMarWp6OY4hH6P3yaexqVyQKBgQCqrJB0c1Jes8jEn/JVL1WJrj22Gk4Wq4VRLJfiV1STnsitse0BB8ZYkvta+ebRu2mK3yBJOzqayPfXAHyuJA6+Ugww1Mcqqa3HZaSBr367Kb7qIDNmNX+C0G9oDCAacsVA3Fe15ubINyN5DgemcUUyyOZ9BQjVV+h2mc+IqOSEWQKBgCzXxDvclOiXXjrGA60G1+hJEK7xZHRUJnYH8kG8kVcY4ZDt1QPAr/NJBA6ivMzKMJ2nCeftk3AXcM+0hnVx/NPGOO3lBV9TaEXEsl9OgZXqq/o5Tj4ZTT/3eSgMQAIq1Jag622eJczukMpBC2+hZzsh/JUGVIGP2rMTUsHgqENu";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm
    // 对应APPID下的支付宝公钥。
    public static final String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw1aqbmNpKtJ0E5jxcwlvCdOYgExrmv6ZR5SkKW0GMWsDjIiOs8ESvR/HOXC5ftRhPOn+Z5A4j7i+25YAlsezuCqOMHgM46dXGunq741thBgzMN50H/0k9vPmXAtn9UVRkUvfNt37TdkwKJhjaVVuEkCHdPqsON1NRd78hH+qOp6W5hH78LFPLGgbnNrYfnA+8xJpi+fB35o1k9SdrORa1mJl588lIjCfdn32YwFMQrhZktkBQr+3rYuKBpUv3nWNmLGjXCUupdwwb+yJQt1/Hu9Dzalo16aKv4ncn9L0e0XhvzF6gsdtqmcFiMj4HXL7B+fCLZC9GsPg46msqdqndQIDAQAB";
    // 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    /**
     * 返回的时候此页面不会返回到用户页面，只会执行你写到控制器里的地址
     */
    public static final String notify_url="http://localhost:8585/paynotice";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    /**
     * 此页面是同步返回用户页面，也就是用户支付后看到的页面，上面的notify_url是异步返回商家操作，谢谢
     * 要是看不懂就找度娘，或者多读几遍，或者去看支付宝第三方接口API，不看API直接拿去就用，遇坑不怪别人,要使用外网能访问的ip,建议使用花生壳,内网穿透
     */
    public static final String return_url = "http://localhost:8585/user/OrderHistory";
    // 签名方式
    public static final String sign_type = "RSA2";
    // 字符编码格式
    public static final String charset = "utf-8";
    // 支付宝网关
    public static final String gatewayUrl="https://openapi.alipaydev.com/gateway.do";
    // 日志地址,这里在d盘下要创建这个文件,不然会报错
    public static final String log_path = "D:/logs/";
    // ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord
     *            要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_"
                    + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            LogerUtil.log(e.getClass(),"",e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    LogerUtil.log(e.getClass(),"",e);

                }
            }
        }
    }
}