package site.xxm.gen.utils;

import java.io.File;
import java.io.IOException;

/**
 * 文件工具类
 * @author xxm
 * @date 2018/10/30 20:47
 * @version V1.0
 */
public class FileUtil {
    public static File createNewFile(File file)throws IOException {
        if (!file.exists()) {
            mkdir(file.getParentFile());
            file.createNewFile();
        }
        return file;
    }

    private static void mkdir(File dir){
        if (!dir.getParentFile().exists()) {
            mkdir(dir.getParentFile());
        }
        dir.mkdir();
    }
    public static boolean deleteFolder(String url) {
        File file = new File( url );
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            file.delete();
            return true;
        } else {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                String root = files[i].getAbsolutePath();//得到子文件或文件夹的绝对路径
                //System.out.println(root);
                deleteFolder( root );
            }
            file.delete();
            return true;
        }
    }
}
