/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npman;

/**
 *
 * @brc
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class ftpTest {

    public String server,user,pass,dirPath;
    public int port;
    
    public void ftpTest (){
        server = "www.yourserver.net";
        port = 21;
        user = "username";
        pass = "password";
        dirPath = "/";
        
    }
    
    public boolean ftpWorks(website a){
        website toTest = new website();
        toTest = a;
        
        server = toTest.Web_URL;
        user = toTest.Web_FTP_Log;
        pass = toTest.Web_FTP_Pass;
        
        boolean connected = false;
        FTPClient ftpClient = new FTPClient();
                       
        try {
            ftpClient.connect(server);
            showServerReply(ftpClient);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Operation failed. Server reply code: " + replyCode);
                connected=false;
            }
            boolean success = ftpClient.login(user, pass);
            showServerReply(ftpClient);
            if (!success) {
                System.out.println("Could not login to the server");
                connected=false;
            } else {
                System.out.println("LOGGED IN SERVER");
                connected=true;
            }
        } catch (IOException ex) {
            System.out.println("Oops! Something wrong happened");
            ex.printStackTrace();
        }
        
        return connected;
    }
    
    private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
    }
    //Build webpage object and database, use this function to upload
    //Add incoming variable webpage b to fileUpload input
    public void fileUpload(website a){
        
        website recipient = new website();
        recipient = a;
        
        server = recipient.Web_URL;
        user = recipient.Web_FTP_Log;
        pass = recipient.Web_FTP_Pass;
 
        FTPClient ftpClient = new FTPClient();
        
        try {
 
            ftpClient.connect(server);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
 
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
 
            // APPROACH #1: uploads first file using an InputStream
            File firstLocalFile = new File("D:/Test/Projects.zip");
 
            String firstRemoteFile = "Projects.zip";
            InputStream inputStream = new FileInputStream(firstLocalFile);
 
            System.out.println("Start uploading first file");
            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
            inputStream.close();
            if (done) {
                System.out.println("The first file is uploaded successfully.");
            }
 
            // APPROACH #2: uploads second file using an OutputStream
            File secondLocalFile = new File("E:/Test/Report.doc");
            String secondRemoteFile = "test/Report.doc";
            inputStream = new FileInputStream(secondLocalFile);
 
            System.out.println("Start uploading second file");
            OutputStream outputStream = ftpClient.storeFileStream(secondRemoteFile);
            byte[] bytesIn = new byte[4096];
            int read = 0;
 
            while ((read = inputStream.read(bytesIn)) != -1) {
                outputStream.write(bytesIn, 0, read);
            }
            inputStream.close();
            outputStream.close();
 
            boolean completed = ftpClient.completePendingCommand();
            if (completed) {
                System.out.println("The second file is uploaded successfully.");
            }
 
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    
    }
    
}