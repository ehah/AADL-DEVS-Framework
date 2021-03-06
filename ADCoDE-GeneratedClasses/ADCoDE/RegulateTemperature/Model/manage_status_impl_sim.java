/**
* generated by ADCoDE @ 2019-12-04 16:13:59
* This class represents DEVS atomic model for thread manage_status with manage_status.impl
**/
package RegulateTemperature;

import java.lang.*;
import GenCol.*;
import model.modeling.*;
import model.simulation.*;
import view.modeling.ViewableAtomic;
import view.simView.*;
import component.structuredEntities.*;
import component.Iso_Types.*;
	
public class manage_status_impl_sim extends ViewableAtomic {
			
	// entities
	protected stringEnt rm;
	protected stringEnt rs;
	
	// variables
	private stringEnt rgm =  new stringEnt("INIT");
		private doubleEnt pd = new doubleEnt(100.0);
	private stringEnt rgs =  new stringEnt("Init");
	
	//for port datatypes
	
	public manage_status_impl_sim() {
		this("manage_status.impl");
	}
			
	public manage_status_impl_sim(String name) {
		super(name);
			 
		//input and output ports from and for other atomic/coupled models
		// it is recommended to use short names
				
		addInport("regulator_mode"); 
		addOutport("regulator_status"); 

		//test input for standalone testing
		addTestInput("regulator_mode", new stringEnt("NORMAL"));
		addTestInput("regulator_mode", new stringEnt("INIT"));
		addTestInput("regulator_mode", new stringEnt("FAILED"));
	}	
			
	public void initialize() {
		//Can be updated by the modeler 
		phase = "Start";
		sigma = 0.0;

	  	super.initialize();
	}
			
	public void deltint() {
		if (phaseIs("Start")) {
		  holdIn("Chk_Mode", pd.getv());
		}
		if (phaseIs("Chk_Mode")) {
		  holdIn("Set_Vars", 0.0);
		}
		if (phaseIs("Set_Vars")) {
		  holdIn("Chk_Mode", pd.getv());
		}
	}
			
	public void deltext(double e, message x) {
		Continue(e);
		
		if (phaseIs("Chk_Mode")) {
		 	for(int i=0; i<x.getLength(); i++) {
				if(messageOnPort(x, "regulator_mode", i)) {
			 	rgm = (stringEnt) x.getValOnPort("regulator_mode", i);
			 	if(rgm.getv() == "INIT") {rgs.setv(Init);}
			 				  else if(rgm.getv() == "NORMAL" )   
			 				  {rgs.setv(On);}
			 				  else if(rgm.getv() == "FAILED") 
			 				  {rgs.setv(Failed);} 
			 	holdIn("Set_Vars", 0.0);
				}
			}
		}
	}
			
	public message out() {
		message m = new message();
		
		if (phaseIs("Set_Vars"))
		m.add(makeContent("regulator_status", rgs));
		
		return m;
	}
}
