package org.example.mongo.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="comments")
public class Comment {
	
	private String author;
	
	private String content;
	
	private Date commentTime;
	
	

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Comment [author=" + author + ", commentTime=" + commentTime
				+ ", content=" + content + "]";
	}
	
	
	
}
