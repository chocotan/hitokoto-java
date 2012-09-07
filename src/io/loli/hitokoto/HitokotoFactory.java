package io.loli.hitokoto;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HitokotoFactory {
	private static String url="http://api.hitokoto.us/rand";
	public static Hitokoto getHitokoto() throws JAXBException, MalformedURLException{
		//声明JAXBContext上下文对象
		JAXBContext context=JAXBContext.newInstance(Hitokoto.class);
		//创建XML转化java的对象Unmarshaller
		Unmarshaller u=context.createUnmarshaller();
		//一个URL实例
		URL nurl=new URL(url+"?encode=xml");
		return (Hitokoto)u.unmarshal(nurl);
	}
	public static Hitokoto getHitokotoByJson() throws IOException, MalformedURLException{
		//将这个URL打开后的内容保存到一个StringBuilder对象中
		URL nurl=new URL(url);
		//创建一个gson对象，这里使用setDateFormat指定日期格式，否则会抛出异常
		Gson gson=new GsonBuilder().setDateFormat("yyyy.MM.dd HH:mm:ss").create();
		//将Reader转换成POJO对象
		return (Hitokoto)gson.fromJson(new InputStreamReader(nurl.openStream(),"UTF8"),Hitokoto.class);
	}
	public static void main(String[] args) throws JAXBException, IOException{
		Hitokoto h=HitokotoFactory.getHitokoto();
		System.out.println(h.getAuthor());
		System.out.println(h.getHitokoto());
		System.out.println(h.getSource());
		System.out.println(h.getDate());
		System.out.println();
		h=HitokotoFactory.getHitokotoByJson();
		System.out.println(h.getAuthor());
		System.out.println(h.getHitokoto());
		System.out.println(h.getSource());
		System.out.println(h.getDate());
		System.out.println();
	}
}
