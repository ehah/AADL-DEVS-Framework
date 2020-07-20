package Iso_Types;
	
import GenCol.*;
import structuredEntities.*;	
	
public class current_temperature extends entity {
	
	private DoubleRange t = new DoubleRange(68.0, 105.0);
	private String status;

	public current_temperature() {
		
	}
		
	public current_temperature(double cv) {
		t.setcVal(cv);
	}
		
	public current_temperature(double lv, double uv, double cv) {
		t.setminVal(lv);
		t.setmaxVal(uv);
		t.setcVal(cv);
	}
		
	public current_temperature(double lv, double uv, double cv, String status ) {
		t.setminVal(lv);
		t.setmaxVal(uv);
		t.setcVal(cv);
		this.status = status; 
	}
		
	public current_temperature(double cv, String status ) {
		t.setcVal(cv);
		this.status = status; 
	}
		
	public void set_t(double lv, double uv, double cv) {
		t.setminVal(lv);
		t.setmaxVal(uv);
		t.setcVal(cv);
	}
	
	public DoubleRange get_t() {
		return t;
	}
		
	public Boolean isInRange(double val) {
		return (val >= t.getminVal() && val <= t.getmaxVal());
	}
		
	public void set_status(String status) {
		this.status = status;
	}
		
	public String get_status() {
		return this.status;
	}
}
