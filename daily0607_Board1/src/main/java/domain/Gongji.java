package domain;

public class Gongji {
	private int id;// 공지 아이디
	private String title;// 공지 제목
	private String date;// 공지 작성날자
	private String content;// 공지 내용
	private int rootid;//원글번호
	private int relevel;//댓글레벨
	private int recnt;//댓글내 글 표시 순서
	private int viewcnt;//조회수

	public int getId() {// 아이디 가져오기
		return id;
	}

	public int getRootid() {
		return rootid;
	}

	public void setRootid(int rootid) {
		this.rootid = rootid;
	}

	public int getRelevel() {
		return relevel;
	}

	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}

	public int getRecnt() {
		return recnt;
	}

	public void setRecnt(int recnt) {
		this.recnt = recnt;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public void setId(int id) {// 아이디 설정하기
		this.id = id;
	}

	public String getTitle() {// 제목 가져오기
		return title;
	}

	public void setTitle(String title) {// 제목 설정하기
		this.title = title;
	}

	public String getDate() {// 작성날자 가져오기
		return date;
	}

	public void setDate(String date) {// 작성날자 설정하기
		this.date = date;
	}

	public String getContent() {// 내용 가져오기
		return content;
	}

	public void setContent(String content) {// 내용 설정하기
		this.content = content;
	}

	@Override
	public String toString() {
		return "Gongji [id=" + id + ", title=" + title + ", date=" + date + ", content=" + content + "]";
	}
}
