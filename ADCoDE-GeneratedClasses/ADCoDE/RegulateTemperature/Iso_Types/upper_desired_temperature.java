package Iso_Types;
	
import GenCol.*;
import structuredEntities.*;	
	
public class upper_desired_temperature extends entity {
	
	private IntRange t = new IntRange(98, 100);
	private String status;

	public upper_desired_temperature() {
		
	}
		
	public upper_desired_temperature(int cv) {
		t.setcVal(cv);
	}
		
	public upper_desired_temperature(int lv, int uv, int cv) {
		t.setminVal(lv);
		t.setmaxVal(uv);
		t.setcVal(cv);
	}
		
	public upper_desired_temperature(int lv, int uv, int cv, String status ) {
		t.setminVal(lv);
		t.setmaxVal(uv);
		t.setcVal(cv);
		this.status = status; 
	}
		
	public upper_desired_temperature(int cv, String status ) {
		t.setcVal(cv);
		this.status = status; 
	}
		
	public void set_t(int lv, int uv, int cv) {
		t.setminVal(lv);
		t.setmaxVal(uv);
		t.setcVal(cv);
	}
		
	public IntRange get_t() {
		return t;
	}
		
	public Boolean isInRange(int val){
		return (val >= t.getminVal() && val <= t.getmaxVal());
	}
	
	public void set_status(String status) {
		this.status = status;
	}
		
	public String get_status() {
		return this.status;
	}
}
