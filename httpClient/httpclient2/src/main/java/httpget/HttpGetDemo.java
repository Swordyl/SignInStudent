package httpget;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.plaf.SliderUI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public class HttpGetDemo {
	
	public static void main(String[] args){
		String url = "https://blog.csdn.net/u013425438/article/details/84664948";
		String result = "";
		
		
		Map<String, String> headers = new HashMap<>();
//		headers.put("consumerAccount", "wenxy30");
//		headers.put("startTime", "2018-12-04%2010:01:05");
//		headers.put("endTime", "2019-01-30%2010:01:05");
//		headers.put("hosts", "security.wangsu.com,www.taobao.com");
//		header.put("Content-Type", "application/json");
		try {
			for(int i = 0; i < 100; i ++){
				result = get(url,headers);
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end");
//		System.out.println(result);
	}
	
	public static String get(String url, Map<String, String> headers) throws IOException {
		HttpClient httpclient = HttpClients.createDefault();
		String result = "";
		HttpGet httpGet = new HttpGet(url);
		String user_agent = "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT)";
		httpGet.addHeader("User-Agent", user_agent);
		List<NameValuePair> formparams = setHttpParams(headers);
		String param = URLEncodedUtils.format(formparams, "UTF-8");
        httpGet.setURI(URI.create(url + "?" + param));
		Set<String> keys = headers.keySet();
        for (String key : keys) {
        	httpGet.setHeader(key, headers.get(key).toString());
        }

//		CloseableHttpClient httpclient = HttpClients.createDefault();
//		HttpGet httpGet = new HttpGet(url);
		HttpResponse response = httpclient.execute(httpGet);
//		
		HttpEntity httpEntity = response.getEntity();
		
		result = EntityUtils.toString(httpEntity, "UTF-8");	//返回数据中文乱码解决
		return result;
//		String httpEntityContent = getHttpEntityContent(response);
//        httpGet.abort();
//        return httpEntityContent;
	}
	
	private static List<NameValuePair> setHttpParams(Map<String, String> paramMap) {
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        Set<Map.Entry<String, String>> set = paramMap.entrySet();
        for (Map.Entry<String, String> entry : set) {
            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return formparams;
    }

}
