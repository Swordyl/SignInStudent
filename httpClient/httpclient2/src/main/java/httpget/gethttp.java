package httpget;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class gethttp {

	public static String get(String url) throws ClientProtocolException, IOException{
		HttpClient client = HttpClients.createDefault();
		String result = "";
		HttpPost httpPost = new HttpPost(url);
		HttpResponse response = client.execute(httpPost);
		HttpEntity httpEntity = response.getEntity();
		result = EntityUtils.toString(httpEntity, "UTF-8");	//返回数据中文乱码解决
		return result;
	}
	
	public static void main(String args[]){
		try {
			String result = get("https://www.baidu.com");
			System.out.print(result);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
