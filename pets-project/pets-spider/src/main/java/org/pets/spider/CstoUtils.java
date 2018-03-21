package org.pets.spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSONObject;
import com.guo.pets.entity.PrjInfo;

/**
 * 
 * @author dzfking007@163.com
 * CSTO 网站抓取类 
 */
public class CstoUtils {
	private static Logger logger = Logger.getLogger(CstoUtils.class);
	
	public static List<PrjInfo> crawPrjinfo() throws IOException{
		List<PrjInfo> list = null;
		Document doc = Jsoup.connect("http://www.csto.com/project/list").get();
		logger.info(doc.title());
		Element prjLines = doc.selectFirst("#list_shwores");
		if(prjLines!=null) {
			list = new ArrayList<PrjInfo>();
			Elements dls = prjLines.select("dl");
			for(Element dl : dls) {
				PrjInfo prjInfo = new PrjInfo();
				Element moneyElement = dl.selectFirst(".head .price");
				if(moneyElement!=null) {
					prjInfo.setMoney(moneyElement.attr("title"));
				}
				Element titleElement = dl.selectFirst(".intro .title a");
				if(titleElement!=null) {
					prjInfo.setTitle(titleElement.text());
					prjInfo.setUrl(titleElement.absUrl("href"));
				}
				Element fabutimeElement = dl.selectFirst(".intro ol li");
				if(fabutimeElement!=null) {
					prjInfo.setFabutime(fabutimeElement.text());
				}
				Element contentElement = dl.selectFirst(".intro .introduce p");
				if(contentElement!=null) {
					prjInfo.setContent(contentElement.text());
				}
				list.add(prjInfo);
				logger.info(JSONObject.toJSONString(prjInfo));
			}
		}
		return list;
	}
	
	
	public static void main(String args[]) throws IOException {
		crawPrjinfo();
		
	}

}
