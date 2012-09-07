package io.loli.hitokoto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

//标注XML的根元素
@XmlRootElement(name="result")
public class Hitokoto {
	private int id;
	private String hitokoto;
	private String cat;
	private String catname;
	private String author;
	private String source;
	private int like;
	private java.util.Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHitokoto() {
		return hitokoto;
	}
	public void setHitokoto(String hitokoto) {
		this.hitokoto = hitokoto;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	//让日期正确格式化
	@XmlJavaTypeAdapter(DateFormat.class) 
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
}
