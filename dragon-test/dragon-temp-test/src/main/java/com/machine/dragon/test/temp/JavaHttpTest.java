package com.machine.dragon.test.temp;

import org.springframework.util.DigestUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class JavaHttpTest {
    /**
     * http get请求
     *
     * @param httpUrl 链接
     * @return 响应数据
     */
    public static String doGet(String httpUrl) {
        //链接
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        StringBuffer result = new StringBuffer();
        try {
            //创建连接
            URL url = new URL(httpUrl);
            connection = (HttpURLConnection) url.openConnection();
            //设置请求方式
            connection.setRequestMethod("GET");
            //设置连接超时时间
            connection.setConnectTimeout(15000);
            //设置读取超时时间
            connection.setReadTimeout(15000);
            //开始连接
            connection.connect();
            //获取响应数据
            if (connection.getResponseCode() == 200) {
                //获取返回的数据
                is = connection.getInputStream();
                if (is != null) {
                    br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String temp = null;
                    while ((temp = br.readLine()) != null) {
                        result.append(temp);
                    }
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            connection.disconnect();// 关闭远程连接
        }
        return result.toString();
    }

    /**
     * post请求
     *
     * @param httpUrl 链接
     * @param param   参数
     * @return
     */
    public static String doPost(String httpUrl, String param) {
        StringBuffer result = new StringBuffer();
        //连接
        HttpURLConnection connection = null;
        OutputStream os = null;
        InputStream is = null;
        BufferedReader br = null;
        try {
            //创建连接对象
            URL url = new URL(httpUrl);
            //创建连接
            connection = (HttpURLConnection) url.openConnection();
            //设置请求方法
            connection.setRequestMethod("POST");
            //设置连接超时时间
            connection.setConnectTimeout(15000);
            //设置读取超时时间
            connection.setReadTimeout(15000);

            //设置head
            connection.addRequestProperty("X-App-Version", "1");
            connection.addRequestProperty("X-TenantId", "2000010002");

            //设置是否可读取
            connection.setDoOutput(true);
            //设置响应是否可读取
            connection.setDoInput(true);

            //设置参数类型
            connection.setRequestProperty("Content-Type", "application/json");
            //拼装参数
            if (param != null && !param.equals("")) {
                //设置参数
                os = connection.getOutputStream();
                //拼装参数
                os.write(param.getBytes("UTF-8"));
            }
            //设置权限
            //设置请求头等
            //开启连接
            //connection.connect();
            //读取响应
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                if (is != null) {
                    br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String temp = null;
                    if ((temp = br.readLine()) != null) {
                        result.append(temp);
                    }
                }
            }
            //关闭连接
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭连接
            connection.disconnect();
        }
        return result.toString();
    }

    public static void main(String[] str) {
        StringBuilder url = new StringBuilder("https://open-dev-commerce.sanlian-group.cn/open/cdp/birthdaycare?");
        String paramBody = "{\n" +
                "  \"groupid\": \"10000\",\n" +
                "  \"groupname\": \"n222\",\n" +
                "  \"unionids\": [\n" +
                "    \"101\",\n" +
                "    \"002\"\n" +
                "  ]\n" +
                "}";

        Map<String, String> treeParamMap = new TreeMap<>();
        treeParamMap.put("signtype", "md5");
        treeParamMap.put("timestamp", System.currentTimeMillis() + "");

        StringBuilder signParam = new StringBuilder();
        for (Map.Entry entry : treeParamMap.entrySet()) {
            signParam = signParam.append(entry.getKey()).append(entry.getValue());
            url.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }

        signParam = signParam.append(paramBody);
        String sign = DigestUtils.md5DigestAsHex(signParam.toString().getBytes());
        url.append("&sign=").append(sign);

        System.out.println(signParam);
        System.out.println(sign);
        System.out.println(url);
        String result = JavaHttpTest.doPost(url.toString(), paramBody);
        System.out.println(result);
    }
}