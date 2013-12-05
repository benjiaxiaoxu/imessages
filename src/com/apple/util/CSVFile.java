package com.apple.util;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
public class CSVFile {
	private static final String STR_FORMAT = "0000";

	public static File createCSVFile(List<String> cityNum, String outPutPath,
			String filename) {
		File csvFile = null;
		BufferedWriter csvFileOutputStream = null;
		try {
			csvFile = new File(outPutPath + filename + ".csv");
			File parent = csvFile.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			if (!csvFile.exists()) {
				csvFile.createNewFile();
			}

			// GB2312使正确读取分隔符","
			csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(csvFile), "GBK"), 1024);
			DecimalFormat df = new DecimalFormat(STR_FORMAT);
			for (String cnum : cityNum) {

				for (int i = 0; i < 1001; i++) {

					csvFileOutputStream
							.write("\"" + cnum + df.format(i) + "\"");
					csvFileOutputStream.newLine();

				}

			}

			csvFileOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				csvFileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return csvFile;
	}

	public static void main(String[] args) {
		String[] city = { };

		List<String> list = new ArrayList<String>();
		System.out.println(city.length);
		for (int i = 0; i < city.length; i++) {
			list.add(city[i]);
			if ((i + 1) % 6 == 0) {
				CSVFile.createCSVFile(list, "d:/aaaaaa/mmm/",city[i].substring(0, 6));
				list.clear();
				System.out.println("------" + list.size());
			}

		}

	}
}
