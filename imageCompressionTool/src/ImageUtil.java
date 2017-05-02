import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by xy on 2017/5/2/002.
 */
public  class ImageUtil {

    public static boolean comparess(String dir,JProgressBar progressBar){
        boolean result=false;
        File dirFile=new File(dir);
        if(dirFile.isDirectory()){
                String [] fileNames=dirFile.list(); //获取文件夹下所有文件名
            for(int i=0;i<fileNames.length;i++){
                if(!fileNames[i].substring(fileNames[i].lastIndexOf(".")+1).toLowerCase().equals("gif")){
                    File file=new File(dir+"\\"+fileNames[i]);

                    try {
                        Thumbnails.of(file).scale(1f).outputQuality(0.25f).toFile(dir+"\\"+fileNames[i]);
                    } catch (IOException e) {
                        System.out.println("压缩出错，文件名："+fileNames[i]);
                        continue;
                    }
                }
                double a=(i+1)*1.0;
                double b=(fileNames.length)*1.0;
                int percent= (int) (a/b*100);

                progressBar.setValue(percent);
                progressBar.setString("已压缩"+(i+1)+"个图片，共有"+fileNames.length+"个图片");

            }
           result=true;
        }else{
            return false;
        }
        return result;
    }
}
