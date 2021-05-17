package net.huayiyun.manbing.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Project : boot2emo
 * @Package Name : com.example.demo.util
 * @Description : TODO 文件utils
 * @Author : zlj
 * @Creation Date : 2020年03月06日 12:00
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@Slf4j(topic = "FileUtils")
public class FileUtils {

    /**
     * 得到图片字节流 数组大小
     */
    public static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }

    /**
     * 将文件转换成Byte数组
     *
     * @param file
     * @return
     */
    public static byte[] getBytesByFile(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            byte[] data = bos.toByteArray();
            bos.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * MultipartFile转File
     *
     * @param param
     * @return
     */
    public static File transfer(MultipartFile param) {
        if (!param.isEmpty()) {
            File file = null;
            try {
                InputStream in = param.getInputStream();
                file = new File(param.getOriginalFilename());
                OutputStream out = new FileOutputStream(file);
                int bytesRead = 0;
                byte[] buffer = new byte[8192];
                while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                in.close();
                out.close();
                return file;
            } catch (Exception e) {
                e.printStackTrace();
                return file;
            }
        }
        return null;
    }

    /**
     * 获取指定文件的输入流
     *
     * @param logoPath 文件的路径
     * @return
     */
    public static InputStream getResourceAsStream(String logoPath) {
        return FileUtils.class.getResourceAsStream(logoPath);
    }

    /**
     * 将InputStream写入到File中
     *
     * @param ins
     * @param file
     * @throws IOException
     */
    public void inputstreamtofile(InputStream ins, File file) throws IOException {
        OutputStream os = new FileOutputStream(file);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        ins.close();
    }

    /**
     * 获取指定文件的输入流
     *
     * @param logoPath 文件的路径
     * @return
     */
    public static InputStream getStream(String logoPath) {
        //判断是路径还是url
        boolean isUrl = isURL(logoPath);
        if (isUrl){
            return getUrlAsStream(logoPath);
        }
        return FileUtils.class.getResourceAsStream(logoPath);
    }

    /**
     * 根据URL网址获取输入流
     *
     * @param urlStr 文件的路径
     * @return
     */
    public static InputStream getUrlAsStream(String urlStr) {

        HttpURLConnection conn = null;
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(20 * 1000);
            final ByteArrayOutputStream output = new ByteArrayOutputStream();
            IOUtils.copy(conn.getInputStream(), output);
            return new ByteArrayInputStream(output.toByteArray());
        } catch (Exception e) {
            log.error("getInputStreamByUrl 异常,exception is {}", e);
        } finally {
            try {
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    /**
     * @Author zlj
     * @param url
     * @return
     * @Description TODO 根据url获取文件名称
     * @creat_date 2020年03月11日
     * @creat_time 10:22:13
     */
    public static String getFileNameByUrl(String url) {
        String filename = "";
        boolean isok = false;
        // 从UrlConnection中获取文件名称
        try {
            URL myURL = new URL(url);

            URLConnection conn = myURL.openConnection();
            if (conn == null) {
                return null;
            }
            Map<String, List<String>> hf = conn.getHeaderFields();
            if (hf == null) {
                return null;
            }
            Set<String> key = hf.keySet();
            if (key == null) {
                return null;
            }
            // Log.i("test", "getContentType:" + conn.getContentType() + ",Url:"
            // + conn.getURL().toString());
            for (String skey : key) {
                List<String> values = hf.get(skey);
                for (String value : values) {
                    String result;
                    try {
                        result = new String(value.getBytes("ISO-8859-1"), "GBK");
                        int location = result.indexOf("filename");
                        if (location >= 0) {
                            result = result.substring(location
                                    + "filename".length());
                            filename = result
                                    .substring(result.indexOf("=") + 1);
                            isok = true;
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }// ISO-8859-1 UTF-8 gb2312
                }
                if (isok) {
                    break;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            log.error("getFileNameByUrl 异常,exception is {}", e);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("getFileNameByUrl 异常,exception is {}", e);
        }
        // 从路径中获取
        if (filename == null || "".equals(filename)) {
            filename = url.substring(url.lastIndexOf("/") + 1);
        }
        return filename;

    }

    /**
     * @Author zlj
     * @param strUrl
     * @return
     * @Description TODO 根据url获取文件类型
     * @creat_date 2020年03月11日
     * @creat_time 10:25:43
     */
    public static String getContentTypeByUrl(String strUrl){

        BufferedInputStream bis = null;
        HttpURLConnection urlConnection = null;
        String contentTypeFromStream = null;
        try{
            URL url = null;
            url = new URL(strUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            bis = new BufferedInputStream(urlConnection.getInputStream());
            contentTypeFromStream = HttpURLConnection.guessContentTypeFromStream(bis);
            System.out.println("file type:"+contentTypeFromStream);
        }catch (MalformedURLException e) {
            e.printStackTrace();
            log.error("getContentTypeByUrl 异常,exception is {}", e);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("getContentTypeByUrl 异常,exception is {}", e);
        }finally {

            try {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
            }
            return contentTypeFromStream;
        }
    }

    public static UrlBean getFileByUrl(String strUrl){

        String filename = "";
        String contentTypeFromStream = null;
        InputStream inputStream = null;

        boolean isok = false;
        HttpURLConnection conn = null;

        try {

            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if (conn == null) {
                return null;
            }
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(20 * 1000);
            final ByteArrayOutputStream output = new ByteArrayOutputStream();
            IOUtils.copy(conn.getInputStream(), output);
            //获取流
            inputStream = new ByteArrayInputStream(output.toByteArray());
            //获取文件类型
            contentTypeFromStream = HttpURLConnection.guessContentTypeFromStream(inputStream);
            System.out.println("file type:"+contentTypeFromStream);
            //获取文件名
            Map<String, List<String>> hf = conn.getHeaderFields();
            if (hf == null) {
                return null;
            }
            Set<String> key = hf.keySet();
            if (key == null) {
                return null;
            }
            for (String skey : key) {
                List<String> values = hf.get(skey);
                for (String value : values) {
                    String result;
                    try {
                        result = new String(value.getBytes("ISO-8859-1"), "GBK");
                        int location = result.indexOf("filename");
                        if (location >= 0) {
                            result = result.substring(location
                                    + "filename".length());
                            filename = result
                                    .substring(result.indexOf("=") + 1);
                            isok = true;
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }// ISO-8859-1 UTF-8 gb2312
                }
                if (isok) {
                    break;
                }
            }
            // 从路径中获取
            if (filename == null || "".equals(filename)) {
                filename = strUrl.substring(strUrl.lastIndexOf("/") + 1);
            }

        } catch (Exception e) {
            log.error("getFileByUrl 异常,exception is {}", e);
        } finally {
            try {
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (Exception e) {
            }
            return new UrlBean(inputStream,filename,contentTypeFromStream);
        }
    }

    /**适用正式环境域名情况下使用
     * 判断字符串是否为URL
     * @param urls 用户头像key
     * @return true:是URL、false:不是URL
     */
    public static boolean isHttpUrl(String urls) {
        boolean isurl = false;
        String regex = "(((https|http)?://)?([a-z0-9]+[.])|(www.))"
                + "\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)";//设置正则表达式

        Pattern pat = Pattern.compile(regex.trim());//比对
        Matcher mat = pat.matcher(urls.trim());
        isurl = mat.matches();//判断是否匹配
        return isurl;
    }

    /**适用于有ip或者域名的情况下使用     localhost：8080不适用  127.0.0.1：8080 可以
     * 判断字符串是否为URL
     * @param str 用户头像key
     * @return true:是URL、false:不是URL
     */
    public static boolean isURL(String str){
        boolean isurl = false;
        //转换为小写
        str = str.toLowerCase();
        String regex = "^((https|http|ftp|rtsp|mms)?://)"
                + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@
                + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
                + "|" // 允许IP和DOMAIN（域名）
                + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.
                + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名
                + "[a-z]{2,6})" // first level domain- .com or .museum
                + "(:[0-9]{1,4})?" // 端口- :80
                + "((/?)|" // a slash isn't required if there is no file name
                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
        Pattern pat = Pattern.compile(regex.trim());//比对
        Matcher mat = pat.matcher(str.trim());
        isurl = mat.matches();//判断是否匹配
        return isurl;


    }


    public static void main(String[] args) {
        String url = "http://127.0.0.1:8000/file/qrcode2";
        String url2 = "https://manbing.huayiyun.net/login?id=12434446464&name=263433";
        System.out.println(isHttpUrl(url2));
        System.out.println(isURL(url2));
    }
}
