package com.pratik.mqttapp.mqttapp.model;

public class VehicleData {
	
		private int milesDriven;
	    private String engineStatus;
	    private String acState;
	    private String doorStatus;
	    private String warningStatus;
	    private String securityAlarm;
	    
	    public VehicleData() {
	    	
	    }

		public VehicleData(int milesDriven, String engineStatus, String acState, String doorStatus,
				String warningStatus, String securityAlarm) {
			this.milesDriven = milesDriven;
			this.engineStatus = engineStatus;
			this.acState = acState;
			this.doorStatus = doorStatus;
			this.warningStatus = warningStatus;
			this.securityAlarm = securityAlarm;
		}

		public String getAcState() {
			return acState;
		}

		public void setAcState(String acState) {
			this.acState = acState;
		}

		public int getMilesDriven() {
			return milesDriven;
		}

		public void setMilesDriven(int milesDriven) {
			this.milesDriven = milesDriven;
		}

		public String getEngineStatus() {
			return engineStatus;
		}

		public void setEngineStatus(String engineStatus) {
			this.engineStatus = engineStatus;
		}

		public String getDoorStatus() {
			return doorStatus;
		}

		public void setDoorStatus(String doorStatus) {
			this.doorStatus = doorStatus;
		}

		public String getWarningStatus() {
			return warningStatus;
		}

		public void setWarningStatus(String warningStatus) {
			this.warningStatus = warningStatus;
		}

		public String getSecurityAlarm() {
			return securityAlarm;
		}

		public void setSecurityAlarm(String securityAlarm) {
			this.securityAlarm = securityAlarm;
		}

		@Override
		public String toString() {
			return "VehicleData [milesDriven=" + milesDriven + ", engineStatus=" + engineStatus + ", acState=" + acState
					+ ", doorStatus=" + doorStatus + ", warningStatus=" + warningStatus + ", securityAlarm="
					+ securityAlarm + "]";
		}
		
		
	    

}
