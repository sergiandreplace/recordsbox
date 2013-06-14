package com.sergiandreplace.recordsbox.util;

/**
 * Created with IntelliJ IDEA.
 * User: Sergi
 * Date: 14/06/13
 * Time: 12:46
 * To change this template use File | Settings | File Templates.
 */

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 * User: Sergi
 * Date: 25/05/13
 * Time: 19:33
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseUtil {

    public static void backupDatabase(Context context, String databaseName) {
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String currentDBPath = "//data//" + context.getApplicationInfo().packageName +"//databases//" + databaseName;
                String backupDBPath = databaseName;
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                }
            }
        } catch (Exception e) {
        }
    }
}

