package com.buledon;
import gov.datacenter.util.PropertyFileUtil;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.Timer;

import MQAPI.MQAPIOB;

public class InspurMqapiService {
	/**
	 * @param args
	 */
	private static String m_strpath;
	private static Timer m_timerHB;
	private static Timer m_timerMN;
	private static String m_strFilePath;
	private static String m_strMaxNumber;
	private static MQAPIOB m_SendAPI;
	private static long m_heartBeatTimes;
	private static long m_MaxNuberTimes;
	private static String m_sysName;
	private static String getFileLastLine(String strFilePath) {
		String strRes = "";
		RandomAccessFile rf = null;
		try {
			rf = new RandomAccessFile(strFilePath, "r");
			long len = rf.length();
			long start = rf.getFilePointer();
			long nextend = start + len - 3;
			String line;
			rf.seek(nextend);
			int c = -1;
			while (nextend > start) {
				c = rf.read();
				if (c == '\n' || c == '\r') {
					line = rf.readLine();
					strRes = line;
					nextend--;
					break;
				}
				nextend--;
				rf.seek(nextend);
				if (nextend == 0) {
					strRes = rf.readLine();
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		return strRes;
	}

	private static String fillZero(String str, int len) {
		int tmp = str.length();
		int t;
		String str1 = str;
		if (tmp >= len)
			return str1;
		t = len - tmp;
		for (int i = 0; i < t; i++)

			str1 = "0" + str1;
		return str1;

	}

	private static String getCurrentDateString() {
		Calendar c = GregorianCalendar.getInstance();
		String datetime = "" + c.get(c.YEAR) + "-"
				+ fillZero(1 + c.get(c.MONTH) + "", 2) + "-"
				+ fillZero("" + c.get(c.DAY_OF_MONTH), 2);
		return datetime;
	}

	private static void init() {
		MyPath mypaht = new MyPath();
		//m_strpath=this.getClass()
		m_strpath = mypaht.getProjectPath();
		if (m_strpath.contains("/")) {
			int icval = m_strpath.lastIndexOf("/");
			m_strpath = m_strpath.substring(0, icval);
			icval = m_strpath.lastIndexOf("/");
			m_strpath = m_strpath.substring(0, icval);
		} else if (m_strpath.contains("\\")) {
			int icval = m_strpath.lastIndexOf("\\");
			m_strpath = m_strpath.substring(0, icval);
			icval = m_strpath.lastIndexOf("\\");
			m_strpath = m_strpath.substring(0, icval);
		}

		if (m_strpath.contains("/")) {
			m_strFilePath = m_strpath + "/" + "MQAPILog/" + "VOA/"
					+ getCurrentDateString() + ".txt";
		} else if (m_strpath.contains("\\")) {
			m_strFilePath = m_strpath + "\\" + "MQAPILog\\" + "VOA\\"
					+ getCurrentDateString() + ".txt";
		}
		m_strMaxNumber = getFileLastLine(m_strFilePath);
		if(m_strMaxNumber.equals(""))
			m_strMaxNumber="0|"+getCurrentDateString();
		try {
			String strConFilePath = "";
			if (m_strpath.contains("\\"))
				strConFilePath = m_strpath + "\\conf\\"
						+ "dc-client.properties";
			else if (m_strpath.contains("/")) {
				strConFilePath = m_strpath + "/conf/" + "dc-client.properties";
			}
			PropertyFileUtil fileUtil = new PropertyFileUtil(strConFilePath);
			Properties fileProperties = fileUtil.getProperties();
			if (fileProperties.containsKey("Service.HeartBeat")) {
				m_heartBeatTimes = Long.valueOf(String.valueOf(fileProperties
						.getProperty("Service.HeartBeat")));
			}
			if (fileProperties.containsKey("Service.MaxNumberTime")) {
				m_MaxNuberTimes = Long.valueOf(String.valueOf(fileProperties
						.getProperty("Service.MaxNumberTime")));
			}
			if (fileProperties.containsKey("Service.NodeName")) {
				m_sysName = String.valueOf(fileProperties
						.getProperty("Service.NodeName"));
			}
		} catch (Exception ex) {
			 System.out.println(ex.toString());
		}
		System.out.println("Path:"+m_strpath+" m_strMaxNumber:"+m_strMaxNumber+" Service.NodeName"+m_sysName);	
		m_SendAPI = MQAPIOB.Create(m_strpath);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		init();
		System.out.println("m_heartBeatTimes:"+m_heartBeatTimes+"   m_MaxNuberTimes:"+m_MaxNuberTimes);	
		// heartBeat
		m_timerHB = new Timer();
		m_timerHB.schedule(new HBTask(),m_heartBeatTimes,m_heartBeatTimes);

		// MaxNumber
		m_timerMN = new Timer();
		m_timerMN.schedule(new MNTask(),m_MaxNuberTimes,m_MaxNuberTimes);
		
		
		
	}

	// MaxNumber Thread
	static class MNTask extends java.util.TimerTask {
		public void run() {
			m_strMaxNumber = getFileLastLine(m_strFilePath);
			if(m_strMaxNumber.equals(""))
				m_strMaxNumber="0|"+getCurrentDateString();
			m_SendAPI.MQAPIDateNumber(m_strMaxNumber);
		}
	}

	// HeartBeat Thread
	static class HBTask extends java.util.TimerTask {
		public void run() {
			String strVersion=m_SendAPI.version+"|"+m_sysName;
			m_SendAPI.sendVersion("ZHENGWUBAN",strVersion);
		}
	}

}
