package beans;

import java.util.Date;

public class BoardVO {
	private int qna_num;
	private String qna_title;
	private String qna_content;
	private int qna_re_ref;
	private int qna_re_lev;
	private int qna_re_seq;
	private int qna_writer_num;
	private int qna_readcount;
	private char qna_delete;
	private Date qna_date;
	private String qna_name;	// 작성자 이름 추가
	
	public BoardVO() {}
	
	// 원본글 작성 시 
	public BoardVO(String qna_title, String qna_content, int qna_writer_num) {
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.qna_writer_num = qna_writer_num;
	}

	public BoardVO(String qna_title, String qna_content, int qna_re_ref, int qna_re_lev, int qna_re_seq,
			int qna_writer_num) {
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.qna_re_ref = qna_re_ref;
		this.qna_re_lev = qna_re_lev;
		this.qna_re_seq = qna_re_seq;
		this.qna_writer_num = qna_writer_num;
	}

	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public int getQna_re_ref() {
		return qna_re_ref;
	}
	public void setQna_re_ref(int qna_re_ref) {
		this.qna_re_ref = qna_re_ref;
	}
	public int getQna_re_lev() {
		return qna_re_lev;
	}
	public void setQna_re_lev(int qna_re_lev) {
		this.qna_re_lev = qna_re_lev;
	}
	public int getQna_re_seq() {
		return qna_re_seq;
	}
	public void setQna_re_seq(int qna_re_seq) {
		this.qna_re_seq = qna_re_seq;
	}
	public int getQna_writer_num() {
		return qna_writer_num;
	}
	public void setQna_writer_num(int qna_writer_num) {
		this.qna_writer_num = qna_writer_num;
	}
	public int getQna_readcount() {
		return qna_readcount;
	}
	public void setQna_readcount(int qna_readcount) {
		this.qna_readcount = qna_readcount;
	}
	public char getQna_delete() {
		return qna_delete;
	}
	public void setQna_delete(char qna_delete) {
		this.qna_delete = qna_delete;
	}
	public Date getQna_date() {
		return qna_date;
	}
	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
	}
	
	public String getQna_name() {
		return qna_name;
	}

	public void setQna_name(String qna_name) {
		this.qna_name = qna_name;
	}

	@Override
	public String toString() {
		return "BoardVO [qna_num=" + qna_num + ", qna_title=" + qna_title + ", qna_content=" + qna_content
				+ ", qna_re_ref=" + qna_re_ref + ", qna_re_lev=" + qna_re_lev + ", qna_re_seq=" + qna_re_seq
				+ ", qna_writer_num=" + qna_writer_num + ", qna_readcount=" + qna_readcount + ", qna_delete="
				+ qna_delete + ", qna_date=" + qna_date + "]";
	}
	
}
