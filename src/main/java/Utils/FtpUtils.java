package main.java.Utils;

import main.java.config.FtpConfig;
import com.changhong.web.service.knowledge.KnowLedgeService;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * 文件传输.
 * @author hwl
 */
@Component
public class FtpUtils {

    private static Logger logger = LogManager.getLogger(KnowLedgeService.class);


    private static FtpConfig ftpConfig;

    @Autowired
    public  void setFtpConfig(FtpConfig ftpConfig) {
        FtpUtils.ftpConfig = ftpConfig;
    }

    /**
     * 连接ftp服务器.
     * @return ftp
     */
    public static FTPClient connectFtp() {
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(ftpConfig.getHost(), ftpConfig.getPort());// 连接FTP服务器
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(ftpConfig.getUsername(), ftpConfig.getPassword());// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
            }
        } catch (IOException e) {
            logger.error("", e);
            logger.info("ftp服务器连接失败！");
        }
        return ftp;
    }

    /**
     * 连接ftp服务器.
     * @return ftp
     */
    public static void disConnectFtp(FTPClient ftp) {
        try {
            ftp.logout();
            ftp.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Description: 向FTP服务器上传文件
     * @param ftp ftp连接
     * @param filePath FTP服务器文件存放路径。例如分日期存放：/2018/05/28。文件的路径为basePath+filePath
     * @param filename 上传到FTP服务器上的文件名
     * @param input 输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(FTPClient ftp, String filePath, String filename, InputStream input) {
        boolean result = false;
        try {
            //切换到上传目录
            if (!ftp.changeWorkingDirectory(ftpConfig.getPath() + filePath)) {
                //如果目录不存在创建目录
                String[] dirs = filePath.split("/");
                String tempPath = ftpConfig.getPath();
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) {
                        continue;
                    }
                    tempPath += "/" + dir;
                    if (!ftp.changeWorkingDirectory(tempPath)) {
                        if (!ftp.makeDirectory(tempPath)) {
                            logger.error("目录" + tempPath + "创建失败") ;
                        } else {
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            //设置为被动模式
            ftp.enterLocalPassiveMode();
            //设置上传文件的类型为二进制类型
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            //上传文件
            if (!ftp.storeFile(filename, input)) {
                logger.error("文件" + filename + "存储失败!");
            }
            input.close();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
