package mon.sof.common.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author wanghaibin
 * @created 2016年11月30日 上午11:17:20
 * @since v1.0
 */
public class HttpClientUtil {
	private static Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

	/**
	 * 发送带参post请求，表单格式参数
	 * @param url
	 * @param params
	 * @return
	 * @author wanghaibin
	 * @created 2016年11月30日 上午11:17:20
	 */
	public static String sendPostRequest(String url, Map<String, String> params) {
		String result = "";
        HttpPost httpPost = new HttpPost(url);//创建HttpPost对象
        // 请求参数begin
        log.info("请求参数begin");
        log.info("URL:"+url);
        List <NameValuePair> NameValuePairParams = new ArrayList<NameValuePair>();
        for(Map.Entry<String, String> entry : params.entrySet()){
        	NameValuePairParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        	log.info(entry.getKey()+":"+entry.getValue());
        }
        log.info("请求参数end");
        // 请求参数end
        try {  
        	httpPost.setEntity(new UrlEncodedFormEntity(NameValuePairParams,HTTP.UTF_8));  
            HttpResponse httpResponse = new DefaultHttpClient().execute(httpPost);
            log.info("响应码："+httpResponse.getStatusLine().getStatusCode());
            if(httpResponse.getStatusLine().getStatusCode() == 200) {  
                HttpEntity httpEntity = httpResponse.getEntity();  
                result = EntityUtils.toString(httpEntity);//取出应答字符串  
            }  
            log.info("响应内容："+result);
        } catch (Exception e) {  
            e.printStackTrace();
            result = e.getMessage().toString();  
        } finally{
        	httpPost.abort();
        }
		return result;
	}
	
	/**
	 * 发送带参post请求，JSON格式参数
	 * @param url
	 * @return
	 * @author wanghaibin
	 * @created 2016年11月30日 上午11:17:20
	 */
	public static String sendPostRequestWithJSON(String url, String json) {
		String result = "";  
        // 将JSON进行UTF-8编码,以便传输中文
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-type","application/json; charset=utf-8");  
        httpPost.setHeader("Accept", "application/json");  
        httpPost.setEntity(new StringEntity(json, Charset.forName("UTF-8")));
        
        log.info("请求参数begin");
        log.info("URL:"+url);
        log.info("json:"+json);
        log.info("请求参数end");
        
        // 请求参数end
        try {  
            HttpResponse httpResponse = new DefaultHttpClient().execute(httpPost);
            log.info("响应码："+httpResponse.getStatusLine().getStatusCode());
            if(httpResponse.getStatusLine().getStatusCode() == 200) {  
                HttpEntity httpEntity = httpResponse.getEntity();  
                result = EntityUtils.toString(httpEntity);//取出应答字符串  
            }  
            log.info("响应内容："+result);
        } catch (Exception e) {  
            e.printStackTrace();
            result = e.getMessage().toString();  
        } finally{
        	httpPost.abort();
        }
		return result;
    }
	
	/**
	 * 发送Http get请求
	 * @param url
	 * @return
	 * @author wanghaibin
	 * @created 2016年11月30日 上午11:17:20
	 */
	@SuppressWarnings({ "resource", "deprecation" })
	public static String sendGetRequest(String url) {
		
		log.info("请求参数begin");
        log.info("URL:"+url);
        log.info("请求参数end");
		
		HttpClient httpClient = null;
		String result = null;
		try {
			httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			HttpResponse response = httpClient.execute(httpGet);
			log.info("响应码："+response.getStatusLine().getStatusCode());
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity, Charset.forName("utf-8"));
				 log.info("响应内容："+result);
			}
			httpGet.abort();
		} catch (IOException e) {
			throw new RuntimeException("远程请求服务器异常,URL:" + url, e);
		} finally {
			if (httpClient != null) {
				httpClient.getConnectionManager().shutdown();
			}
		}
		return result;
	}


	/**
	 * 发送带参post请求，文件类型
	 * @param url
	 * @return
	 * @author zhangxiaomei
	 * @created 2019年7月25日12:32:08
	 */
	public static String sendPostFile(String url, File file, Map<String,String> params )  {
		String result = "";
		// 将JSON进行UTF-8编码,以便传输中文
		HttpPost httpPost = new HttpPost(url);
		String BOUNDARY = java.util.UUID.randomUUID().toString();
		MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE, "--------------------"+BOUNDARY, Charset.defaultCharset());
		multipartEntity.addPart("Filedata",new FileBody(file));
		try {
			for (Map.Entry<String, String> map : params.entrySet()) {
				multipartEntity.addPart(map.getKey(),new StringBody(map.getValue()));
				log.info("请求参数："+map.getKey()+":"+map.getValue());
			}
			//multipartEntity.addPart("type",new StringBody("face"));
			httpPost.setEntity(multipartEntity);
			log.info("请求参数begin");
			log.info("URL:"+url);
			log.info("fileName:"+file.getName());
			log.info("请求参数end");
			// 请求参数end
			HttpResponse httpResponse = new DefaultHttpClient().execute(httpPost);
			log.info("响应码："+httpResponse.getStatusLine().getStatusCode());
			if(httpResponse.getStatusLine().getStatusCode() == 200) {
				HttpEntity httpEntity = httpResponse.getEntity();
				result = EntityUtils.toString(httpEntity);//取出应答字符串
			}
			log.info("响应内容："+result);
		} catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage().toString();
		} finally{
			httpPost.abort();
		}
		return result;
	}

}
