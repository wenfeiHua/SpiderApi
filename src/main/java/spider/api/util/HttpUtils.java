package spider.api.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

/**
 * 封装HttpClient工具类
 * 
 * @author lixuef
 *
 */
@Component
public class HttpUtils {
	// 声明HttpClient连接池,创建连接池管理器
	private PoolingHttpClientConnectionManager cm;

	// 创建构造方法
	public HttpUtils() {
		this.cm = new PoolingHttpClientConnectionManager();
		// 设置最大连接数
		cm.setMaxTotal(100);
		// 设置每个主机的最大连接数
		cm.setDefaultMaxPerRoute(10);
	}

	/**
	 * 根据请求地址下载页面
	 * 
	 * @param url
	 * @return 页面名称
	 */
	public String doGetHtml(String url) {
		// 获取httpClient对象
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();
		// 创建httpGet请求对象，设置url
		HttpGet httpGet = new HttpGet(url);
		// 设置请求信息
		httpGet.setConfig(this.getConfig());
		//设置请求头  模拟浏览器请求
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36"); 
		System.out.println(httpGet);
		// 使用HttpClient发起请求，获取响应
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpGet);
			// 解析响应，返回结果
			if (response.getStatusLine().getStatusCode() == 200) {
				// 判断响应体Entity是否不为空，不为空就可以使用EntityUtils
				if (response.getEntity() != null) {
					String connent = EntityUtils.toString(response.getEntity(), "utf8");
					return connent;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// 没有数据返回空值
		return "";
	}

	// 配置请求信息
	private RequestConfig getConfig() {
		RequestConfig config = RequestConfig.custom().setConnectTimeout(1000)// 创建连接的最长时间
				.setConnectionRequestTimeout(500)// 获取连接的最长时间
				.setSocketTimeout(10 * 1000)// 数据传输的最长时间
				.build();
		return config;
	}

	/**
	 * 根据请求下载图片
	 * 
	 * @param url
	 * @return 图片名称
	 */
	public String doGetImage(String url) {
		// 获取httpClient对象
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();
		// 创建httpGet请求对象，设置url
		HttpGet httpGet = new HttpGet(url);
		// 设置请求信息
		httpGet.setConfig(this.getConfig());
		// 使用HttpClient发起请求，获取响应
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpGet);
			// 解析响应，返回结果
			if (response.getStatusLine().getStatusCode() == 200) {
				// 判断响应体Entity是否不为空，不为空就可以使用EntityUtils
				if (response.getEntity() != null) {
					// 下载图片
					// 获取图片后缀
					String extName = url.substring(url.lastIndexOf("."));
					// 重命名图片
					String picName = UUID.randomUUID().toString() + extName;
					// 下载图片
					// 声明outputStream、
					OutputStream outputStream = new FileOutputStream(new File("") + picName);
					response.getEntity().writeTo(outputStream);
					// 返回图片名称
					return picName;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// 下载失败返回空值
		return "";
	}

	/**
	 * 处理带参数的httpGet请求
	 * 
	 */
	public String doGetHtmlWithParam(String url,String paramName,String paramValue) {
		        // 获取httpClient对象
				CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();
				//创建URIBuilder
				URIBuilder uriBuilder=null;
				HttpGet httpGet = null;
				CloseableHttpResponse response = null;
				try {
					uriBuilder=new URIBuilder(url);
					//设置参数
					uriBuilder.setParameter(paramName, paramValue);
					System.out.println(uriBuilder.build());
					httpGet=new HttpGet(uriBuilder.build());
					httpGet.setConfig(this.getConfig());
					//设置httpGet的头部参数信息     
		/*			httpGet.setHeader("Accept", "Accept text/html,application/xhtml+xml,application/xml;q=0.9,*;q=0.8");    
					httpGet.setHeader("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");    
					httpGet.setHeader("Accept-Encoding", "gzip, deflate");    
					httpGet.setHeader("Accept-Language", "zh-cn,zh;q=0.5");    
					httpGet.setHeader("Connection", "keep-alive");    
					httpGet.setHeader("Cookie", "");     
					httpGet.setHeader("Host", "");      
					httpGet.setHeader("refer", "");     */ 
					httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");   
					response = httpClient.execute(httpGet);
					// 解析响应，返回结果
					if (response.getStatusLine().getStatusCode() == 200) {
						// 判断响应体Entity是否不为空，不为空就可以使用EntityUtils
						if (response.getEntity() != null) {
							String connent = EntityUtils.toString(response.getEntity(), "utf8");
							return connent;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (response != null) {
						try {
							response.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				// 没有数据返回空值
				return "false";
	}
    
	/**
	 * 处理带参数的HttpPost请求
	 * @return
	 */
	public String  doPostHtmlWithParm(String url,String paramName,String paramValue) {
		// 获取httpClient对象
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();
        //创建HttpPost对象，设置url访问地址
		HttpPost httpPost = new HttpPost(url);
		//声明list集合，封装表单参数
		List<NameValuePair> paramsList=new ArrayList<NameValuePair>();
		paramsList.add(new BasicNameValuePair(paramName, paramValue));
		//创建表单的Entity对象
		UrlEncodedFormEntity formEntity=null;
		CloseableHttpResponse response = null;
		try {
			formEntity=new UrlEncodedFormEntity(paramsList,"utf8");
			formEntity.setContentType("application/json");
			for (NameValuePair nameValuePair : paramsList) {
				System.out.println(nameValuePair);
			}
			//设置表单的Entity对象到post请求中
			httpPost.setEntity(formEntity);
			System.out.println(httpPost);
			response = httpClient.execute(httpPost);
			System.out.println((response.getStatusLine().getStatusCode()));
			// 解析响应，返回结果
			if (response.getStatusLine().getStatusCode() == 200) {
				// 判断响应体Entity是否不为空，不为空就可以使用EntityUtils
				System.out.println(1234);
				if (response.getEntity() != null) {
					String connent = EntityUtils.toString(response.getEntity(), "utf8");
					return connent;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// 没有数据返回空值
		return "false";
	}
}

