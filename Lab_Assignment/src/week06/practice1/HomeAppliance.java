package week06.practice1;

public class HomeAppliance {

	protected String haName;  // 가전제품 이름
	protected boolean haPower = true;  // 가전제품 전원 (켜져있는 상태로 운영)
	
	public HomeAppliance(String haName) {
		super();  // 부모의 default 생성자를 호출
		this.haName = haName;
	}

	public String getHaName() {
		return haName;
	}

	public void setHaName(String haName) {
		this.haName = haName;
	}

	public boolean isHaPower() {
		return haPower;
	}

	public void setHaPower(boolean haPower) {
		this.haPower = haPower;
	}

	void showStatus() {}
	
	void menu() {}

}
