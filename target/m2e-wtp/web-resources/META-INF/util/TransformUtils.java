package util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

public class TransformUtils {

	public static Timestamp stringToTimestamp(String time) {
		time=time+" 00:00:00.000000000";
//		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH：mm：ss");
		return Timestamp.valueOf(time);
	}
	public static String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	// 本方法調整fileName的長度小於或等於maxLength。
	// 如果fileName的長度小於或等於maxLength，直接傳回fileName
	// 否則保留最後一個句點與其後的附檔名，縮短主檔名使得fileName的總長度
	// 等於maxLength。
	public static String adjustFileName(String fileName, int maxLength) {
		int length = fileName.length();
		if (length <= maxLength) {
			return fileName;
		}
		int n = fileName.lastIndexOf(".");
		int sub = fileName.length() - n - 1;
		fileName = fileName.substring(0, maxLength - 1 - sub) + "." + fileName.substring(n + 1);
		return fileName;
	}

	// 檔名太長無法寫入表格，故須限制
	public static final int IMAGE_FILENAME_LENGTH = 10;

	public static Blob fileToBlob(InputStream is, long size){
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		try {
			is.read(b);
			sb = new SerialBlob(b);
		} catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return sb;
	}
	
	public static byte[] fileToBytes(InputStream is, long size){
		byte[] b = new byte[(int) size];
		try {
			is.read(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}
	

	public static byte[] blobToBytes(Blob blob) {
		BufferedInputStream is = null;
		try {
			is = new BufferedInputStream(blob.getBinaryStream());
			byte[] bytes = new byte[(int) blob.length()];
			int len = bytes.length;
			int offset = 0;
			int read = 0;
			while (offset < len && (read = is.read(bytes, offset, len - offset)) >= 0) {
				offset = read;
			}
			return bytes;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				is.close();
				is = null;
			} catch (IOException e) {
				return null;
			}
		}
	}
	

}