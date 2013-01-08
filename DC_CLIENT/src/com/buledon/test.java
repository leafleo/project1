package com.buledon;

import MQAPI.AceeptOB;
import MQAPI.MQAPIOB;



public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("begin\n");
		MQAPIOB SendAPI = MQAPIOB.Create("E:/buleDonWorkSpace/DC_CLIENT");
        AceeptOB slAceept = new AceeptOB();
	String strMaxNumber=SendAPI.getMaxNumber(); 	
        slAceept.setSourceNode("ZHENGWUBAN");
        slAceept.setDestinationNode("ZHENGWUBAN");
        slAceept.setSXBM("CYXK01");// "gz0211001";
        slAceept.setSerialNO("gz0211001");  //统一查询号
        slAceept.setPassword("11") ;//= "11";//RandKey.ToString();  //查询密码
        slAceept.setSJBBH(1);// = 1;
        slAceept.setYXTYWLSH("11"); 
        slAceept.setSPSXMC("酒类批发许可证（核发）");// = "酒类批发许可证（核发）";
        slAceept.setGDBLSX(20);// = 20;
        slAceept.setGDBLSXDW("G");// = "G";
        slAceept.setGDSF("0");
        slAceept.setXMMC("广州五粮液__酒类批发许可证（核发）");
        slAceept.setFLGDGXD("440000");
        slAceept.setFSYWGXD("440000");
        slAceept.setSQDWHSQRXM("广州五粮液");
        slAceept.setSQDWJBRXM("张");
        slAceept.setSQDWLXDH("123456789");
        slAceept.setSQDWJBRSJ("");
        slAceept.setSQDWJBRYJ("");
        slAceept.setSLJGZZJGDM("007482567");
        slAceept.setSLJGMC("广州市经济贸易委员会");
        slAceept.setSLDWCBRXM("张晓");
        slAceept.setSLDWCBRGH("");
        slAceept.setSLJTDD("");
        slAceept.setHZBH("232");
        java.util.Date a=new java.util.Date();
        //date.getTime(); 
        slAceept.setSLSJ(a);
        slAceept.setHZBH("11");
        slAceept.setSLZLQD("酒类批发许可证申请表（有示范文本）1份 书面申请报告1份"
+ "营业执照(或企业名称预先核准通知书)（复印件）1份"
+ "法人代表身份证（复印件，非本地户口的，需提供暂住一年以上的居住证复印件）1份"
+ "有效期内的食品卫生许可证（复印件，经营范围需注明：批发定型包装食品）或食品流通许可证（复印件）1份"
+ "注册资金验资证明（复印件，新设立公司凭企业名称预先核准通知书申请的需提供银行进账单复印件，新设立外资企业未验资的，凭《外商企业批准证书》办理）1份"
+ "经营场所及仓储用地的已备案的租赁合同，自有房产的，提供可用于商业用途的房产证明。（复印件）1份"
+ "产销双方的协议书或授权书（原件，外文协议书或授权书需提供中文翻译件）1份"
+ "生产厂家的营业执照、卫生许可证和酒类生产许可证（复印件，加盖生产厂家或提供该材料的经销商印章，如与酒类产品的经销商签订协议的，还需提供经销商的相关证明材料，加盖经销1份"
+ "代理产品的质量标准1份"
+ "代理国产酒的，需提供具有法定资质机构出具的当年检验合格报告；（复印件）1份"
+ "代理进口酒的，需提供出入境检验检疫局出具的当年《卫生证书》（复印件）1份"
+ "承诺书（有示范文本）1份"
+ "其他必要材料1份");
        slAceept.setSLYF("0");
        slAceept.setBSLYY("");
        slAceept.setTJFS("0");

        //slAceept.setPHD("11");

        slAceept.setBZ("0");
        slAceept.setBYZDA(strMaxNumber);
        slAceept.setBYZDB("");
        slAceept.setBYZDC("");
        slAceept.setBYZDD(a);
        try
        {
            int resl = SendAPI.Accept(slAceept);
            resl=0; 
        }
        catch (Exception ex)
        {
            //ExceptionManager.Handle(new Exception("受理"));
            //ExceptionManager.Handle(ex);
            //InsertError(strSerialNO, slAceept.Password, slAceept.SJBBH, slAceept.SourceNode, slAceept.DestinationNode, slAceept.YXTYWLSH, strsss.Trim());
        }
        System.out.print("end");
        
        /*
        SupplyOB s5 = new SupplyOB();
        s5.setSourceNode("ZHENGWUBAN");
        s5.setDestinationNode("ZHENGWUBAN");
        s5.setSXBM("gz0211001");
        s5.setSerialNO("gz0211001");  //统一查询号
        s5.setPassword("11");  //查询密码
        s5.setSJBBH(1);
        s5.setYXTYWLSH("gz0211001");
        s5.setBJGZFCR("罗军");
        s5.setBJCLGZQD("酒类批发许可证申请表（有示范文本）1份 书面申请报告1份");
        s5.setBJGZYY("材料不齐全");
        
        s5.setBJGZSJ(a);
        s5.setPHD("");

        s5.setBZ("0");
        s5.setBYZDA(strMaxNumber);
        s5.setBYZDB("");
        s5.setBYZDC("");
        s5.setBYZDD(a);
        SendAPI.Supply(s5);



        SupplyAcceptOB s6 = new SupplyAcceptOB();
        s6.setSourceNode("ZHENGWUBAN");
        s6.setDestinationNode("ZHENGWUBAN");
        s6.setSXBM("gz0211001");
        s6.setSerialNO("gz0211001");  //统一查询号
        s6.setPassword("11");  //查询密码
        s6.setSJBBH(1);
        s6.setYXTYWLSH("gz0211001");
        s6.setSLDWCBRXM("罗军");
        s6.setBJCLQD("酒类批发许可证申请表（有示范文本）1份 书面申请报告1份");
        s6.setBJSLJTDD("广州大道中");
        s6.setBJSJ(a);
        s6.setPHD("");

        s6.setBZ("0");
        s6.setBYZDA(strMaxNumber);
        s6.setBYZDB("");
        s6.setBYZDC("");
        s6.setBYZDD(a);
        SendAPI.SupplyAccept(s6);
       

            SubmitOB sl = new SubmitOB();
            sl.setSourceNode("ZHENGWUBAN");
            sl.setDestinationNode("ZHENGWUBAN");
            sl.setSXBM("gz0211001");
            sl.setSerialNO("gz0211001");  //统一查询号
            sl.setPassword("11");  //查询密码
            sl.setSJBBH(1);
            sl.setYXTYWLSH("gz0211001");
            sl.setSPBZH(1);
            sl.setSPHJDM("0001");
            sl.setSPHJMC("承办");
            sl.setSPRXM("张晓霞");
            sl.setSPRZWDM("1");
            sl.setSPRZWMC("局长");
            sl.setSPYJ("符合条件，同意！");
            
            sl.setSPSJ(a);
            sl.setPHD("");

            sl.setBZ("0");
            sl.setBYZDA(strMaxNumber);
            sl.setBYZDB("");
            sl.setBYZDC("");
            sl.setBYZDD(a);
            SendAPI.Submit(sl);

            
        BlockOB s7 = new BlockOB();
        s7.setSourceNode("ZHENGWUBAN");
        s7.setDestinationNode("ZHENGWUBAN");
        s7.setSXBM("gz0211001");
        s7.setSerialNO("gz0211001");  //统一查询号
        s7.setPassword("11");  //查询密码
        s7.setSJBBH(1);
        s7.setYXTYWLSH("gz0211001");
        s7.setXH(1);
        s7.setTBCXZL("A");
        s7.setTBCXZLMC("听证");
        s7.setTBCXPZR("罗军");
        s7.setTBCXPZRSJ("1");
        s7.setTBCXPZRDH("12345678");
        s7.setTBCXQDLYHYJ("市政务令");
        s7.setSQNR("实地考察");
        s7.setTBCXSX(10);
        s7.setTBCXSXDW("G");
        s7.setTBCXKSRQ(a);
        s7.setPHD("");

        s7.setBZ("0");
        s7.setBYZDA(strMaxNumber);
        s7.setBYZDB("");
        s7.setBYZDC("");
        s7.setBYZDD(a);
        SendAPI.Block(s7);
       
        
       

        ResumeOB s8 = new ResumeOB();
        s8.setSourceNode("ZHENGWUBAN");
        s8.setDestinationNode("ZHENGWUBAN");
        s8.setSXBM("gz0211001");
        s8.setSerialNO("gz0211001");  //统一查询号
        s8.setPassword("11");  //查询密码
        s8.setSJBBH(1);
        s8.setYXTYWLSH("gz0211001");
        s8.setXH(1);
        s8.setTBCXJG("通过");
        s8.setTBCXSFJE("0");

        s8.setJGCSRQ(a);
        s8.setTBCXJSRQ(a);
        s8.setPHD("");

        s8.setBZ("0");
        s8.setBYZDA(strMaxNumber);
        s8.setBYZDB("");
        s8.setBYZDC("");
        s8.setBYZDD(a);
        SendAPI.Resume(s8);
    
        


        CompleteOB s4 = new CompleteOB();
        s4.setSourceNode("ZHENGWUBAN");
        s4.setDestinationNode("ZHENGWUBAN");
        s4.setSXBM("gz0211001");
        s4.setSerialNO("gz0211001");  //统一查询号
        s4.setPassword("11");   //查询密码
        s4.setSJBBH(1);
   
        s4.setYXTYWLSH("gz0211001");
        s4.setBJJGZZJGDM("007482567");
        s4.setBJJGMC("广州市经济贸易委员会");
        s4.setBJSJ(a);
        s4.setBJJG("6");
        s4.setBLJGMS("办结");
        s4.setZFTHYY("");
        s4.setZJMC("");
        s4.setZJBH("");
        s4.setPHD("");
        s4.setZJYXQX("");
        s4.setFZDW("");
        s4.setSFJE(0);
        s4.setJEDWDM("CNY");
        s4.setBZ("");
        s4.setBYZDA(strMaxNumber);
        s4.setBYZDB("");
        s4.setBYZDC("");
        s4.setBYZDD(a);
        SendAPI.Complete(s4);
	*/
	
	}
}
