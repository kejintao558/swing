package Util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FileLineNumber {
	//获取文件行数
	public  long getLineNumber(File file) {
	    if (file.exists()) {
	        try {
	            FileReader fileReader = new FileReader(file);
	            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
	            lineNumberReader.skip(Long.MAX_VALUE);
	            long lines = lineNumberReader.getLineNumber() + 1;
	            fileReader.close();
	            lineNumberReader.close();
	            return lines;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return 0;
	}
}
