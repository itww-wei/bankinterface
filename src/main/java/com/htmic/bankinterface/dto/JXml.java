package com.htmic.bankinterface.dto;

import org.codehaus.jackson.map.ObjectMapper;


/**
 * 自定义XML格式类
 * @author wei
 *
 */
public class JXml {
	private Root root;

	public Root getRoot() {
		return root;
	}

	public void setRoot(Root root) {
		this.root = root;
	}
	
	public static void main(String[] args) throws Exception {  
  
        String content="{\"root\":{\"body\":{\"AddWord\":\"ee\",\"bank\":{\"Result\":1,\"InAcctNo\":\"341316000018170042669\",\"InName\":\"ee\",\"HstSeqNum\":\"20151019794101880002314450002518883\"}},\"head\":{\"SeqNo\":79410188000231445,\"TransCode\":3032,\"TransTime\":\"091811\",\"TransDate\":20151027}}}";
        //String content="{\"root\":{\"body\":{\"Result\":1,\"AddWord\":\"保证金入账明细查询成功!!\",\"bank\":{\"InName\":\"安徽腾飞园林建设工程有限公司\",\"PunInst\":\"\",\"InAmount\":30000,\"InTime\":145016,\"Gernal\":\"\",\"InMemo\":79410188000232928,\"InAcct\":\"34001778608053020850\",\"InDate\":20151026,\"HstSeqNum\":\"201510267941018800023292800007144355\"}},\"head\":{\"SeqNo\":201510270001,\"TransCode\":3012,\"TransTime\":\"092644\",\"TransDate\":20151027}}}";
        String str="{\"root\":{\"body\":{\"ItemNox\":2,\"AuthCode\":2,\"ItemNo\":2},\"head\":{\"SeqNo\":2,\"TransCode\":1,\"TransTime\":2,\"TransDate\":2}}}";
		// 对象就在这里读取。  
        //Person person = om.readValue(System.in, Person.class);  
        ObjectMapper om = new ObjectMapper();  
        JXml xml=om.readValue(content, JXml.class);
        // 怎么用，随便。  
//        System.out.println(person.getFullname());  
//        System.out.println(person.getEmailaddrs().get(0).getValue());  
       @SuppressWarnings("unused")
       int i=0;
       System.err.println("ok");
    }  
}
