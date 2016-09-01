package com.dankook.bsi.model;

enum HeatingSystemType {지역난방, 보일러, EHP};
enum HeatingPumpSystemType {지역난방, 보일러, EHP};
enum CoolingSystemType {압축식, 흡수식, EHP};

public class Info {
	
	private String gbxmlFilePath = "";
	
	private String buildingName; //USER
	private double area; //GFA, USER
	private int floor; //USER
	
	private double roof_area;
	private double floor_area;
	private double shell_area;
	private double wall_area;
	private double window_area;
	
	private double H_T_wall; //열관류율 USER
	private double H_T_window; //USER
	private double H_T_roof; //USER
	private double H_T_floor; //USER
	private double SHGC; //USER
	
	private double [] each_shell_area;	//외피면적, USER
	private double [] each_wall_area;	//벽체면적, USER
	private double [] each_window_area;	//창면적, USER
	
	private HeatingSystemType HeatingSystem;
	private HeatingPumpSystemType HeatingPumpSystemType;
	private CoolingSystemType CoolingSystem;
	private double HeatingVolumn;
	private double HeatingPumpVolumn;
	private double CoolingVolumn;
	private double LightingDensity;
	private double HeatingEfficiency;
	private double HeatingPumpEfficiency;
	private double CoolingEfficiency;
	
	private final double Q_I_p = 55.8;
	private final double Q_I_fac = 126;
	private double Q_I_L;
	private double H_T;
	private final double H_V = 2.2;
	private final double H_inf = 0.5;
	
	private final int office_hours = 8;
	private final int lighting_hours = 8;
	private final double hotwater_need = 30;
	private final double boiler_aux = 1.3;
	private final double elec_aux = 1.3;
	
	private final double outside_building = 0.9;
	private final double incident_angle = 0.9;
	private final double frame = 0.7;
	
	private final double [] d_full = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private final double [] d_op = {0, 22, 20, 23, 22, 22, 22, 23, 22, 22, 22, 22, 23};
	private final double [] temp = {0, -2.1, 0.2, 6.3, 13, 17.6, 21.8, 25.2, 26.4, 21.1, 4.7, 6.9, 0.8};
	private final double [] I_s_h = {898, 83, 117.5, 141.3, 180.4, 189.4, 183.1, 145.9, 147.5, 157.8, 129.2, 82.4, 72.1};
	private final double [] I_s_s = {442, 111.6, 132.2, 116.9, 110.5, 87.1, 87.3, 76.5, 87.4, 116.2, 134.9, 99.3, 97.9};
	private final double [] I_s_se = {535, 81.8, 92.4, 135.2, 102.1, 95.6, 103.3, 92.8, 97.3, 111.6, 120.8, 78.9, 78.3};
	private final double [] I_s_sw = {569, 94.8, 132.8, 83.3, 122.2, 99.2, 95.4, 74, 85, 113.2, 109, 83.9, 78.2};
	private final double [] I_s_e = {580, 44.2, 62.5, 115, 91.2, 93.9, 110.3, 98.8, 97.1, 96.2, 86, 50.6, 45.5};
	private final double [] I_s_ne = {419, 30.2, 44.5, 72.7, 75.1, 75.5, 97.8, 86.9, 83.9, 72.9, 49.3, 34.4, 29.7};
	private final double [] I_s_nw = {496, 31.1, 53.9, 52.1, 88.6, 78.6, 88.6, 68.5, 74.2, 76.4, 47.9, 34.6, 29.3};
	private final double [] I_s_n = {263, 28.3, 41, 48.4, 66.5, 56.3, 77.3, 67, 68.1, 60.2, 38.3, 31.3, 26.9};
	
	private double Q_solar;
	private double Q_T;
	private double Q_V;
	private double Q_source;
	private double Q_sink;
	private double gamma;
	private double tau;
	private double a;
	private double eta;
	private double Q_h_b;
	private double Q_c_b;
	private double Q_w_b;
	private double Q_l_b;
	private double Q_h_f;
	private double Q_c_f;
	private double Q_w_f;

	public Info() {
		each_shell_area = new double[4];
		each_wall_area = new double[4];
		each_window_area = new double[4];
	}
	
	public void setValues() {
		/*
		roof_area = area / floor;
		floor_area = area / floor;
		for (int i = 0; i < 4; i++) {
			shell_area += each_shell_area[i];
			window_area += each_window_area[i];
			wall_area += each_wall_area[i];
		}
		*/
	}
	
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public double getRoof_area() {
		return roof_area;
	}
	public void setRoof_area(double roof_area) {
		this.roof_area = roof_area;
	}
	public double getFloor_area() {
		return floor_area;
	}
	public void setFloor_area(double floor_area) {
		this.floor_area = floor_area;
	}
	public double getShell_area() {
		return shell_area;
	}
	public void setShell_area(double shell_area) {
		this.shell_area = shell_area;
	}
	public double getWall_area() {
		return wall_area;
	}
	public void setWall_area(double wall_area) {
		this.wall_area = wall_area;
	}
	public double getWindow_area() {
		return window_area;
	}
	public void setWindow_area(double window_area) {
		this.window_area = window_area;
	}
	public double getH_T_wall() {
		return H_T_wall;
	}
	public void setH_T_wall(double h_T_wall) {
		H_T_wall = h_T_wall;
	}
	public double getH_T_window() {
		return H_T_window;
	}
	public void setH_T_window(double h_T_window) {
		H_T_window = h_T_window;
	}
	public double getH_T_roof() {
		return H_T_roof;
	}
	public void setH_T_roof(double h_T_roof) {
		H_T_roof = h_T_roof;
	}
	public double getH_T_floor() {
		return H_T_floor;
	}
	public void setH_T_floor(double h_T_floor) {
		H_T_floor = h_T_floor;
	}
	public double getSHGC() {
		return SHGC;
	}
	public void setSHGC(double sHGC) {
		SHGC = sHGC;
	}
	public double[] getEach_shell_area() {
		return each_shell_area;
	}
	public void setEach_shell_area(double[] each_shell_area) {
		this.each_shell_area = each_shell_area;
	}
	public double[] getEach_wall_area() {
		return each_wall_area;
	}
	public void setEach_wall_area(double[] each_wall_area) {
		this.each_wall_area = each_wall_area;
	}
	public double[] getEach_window_area() {
		return each_window_area;
	}
	public void setEach_window_area(double[] each_window_area) {
		this.each_window_area = each_window_area;
	}
	public HeatingSystemType getHeatingSystem() {
		return HeatingSystem;
	}
	public void setHeatingSystem(HeatingSystemType heatingSystem) {
		HeatingSystem = heatingSystem;
	}
	public HeatingPumpSystemType getHeatingPumpSystemType() {
		return HeatingPumpSystemType;
	}
	public void setHeatingPumpSystemType(HeatingPumpSystemType heatingPumpSystemType) {
		HeatingPumpSystemType = heatingPumpSystemType;
	}
	public CoolingSystemType getCoolingSystem() {
		return CoolingSystem;
	}
	public void setCoolingSystem(CoolingSystemType coolingSystem) {
		CoolingSystem = coolingSystem;
	}
	public double getHeatingVolumn() {
		return HeatingVolumn;
	}
	public void setHeatingVolumn(double heatingVolumn) {
		HeatingVolumn = heatingVolumn;
	}
	public double getHeatingPumpVolumn() {
		return HeatingPumpVolumn;
	}
	public void setHeatingPumpVolumn(double heatingPumpVolumn) {
		HeatingPumpVolumn = heatingPumpVolumn;
	}
	public double getCoolingVolumn() {
		return CoolingVolumn;
	}
	public void setCoolingVolumn(double coolingVolumn) {
		CoolingVolumn = coolingVolumn;
	}
	public double getLightingDensity() {
		return LightingDensity;
	}
	public void setLightingDensity(double lightingDensity) {
		LightingDensity = lightingDensity;
	}
	public double getHeatingEfficiency() {
		return HeatingEfficiency;
	}
	public void setHeatingEfficiency(double heatingEfficiency) {
		HeatingEfficiency = heatingEfficiency;
	}
	public double getHeatingPumpEfficiency() {
		return HeatingPumpEfficiency;
	}
	public void setHeatingPumpEfficiency(double heatingPumpEfficiency) {
		HeatingPumpEfficiency = heatingPumpEfficiency;
	}
	public double getCoolingEfficiency() {
		return CoolingEfficiency;
	}
	public void setCoolingEfficiency(double coolingEfficiency) {
		CoolingEfficiency = coolingEfficiency;
	}
	public double getQ_I_L() {
		return Q_I_L;
	}
	public void setQ_I_L(double q_I_L) {
		Q_I_L = q_I_L;
	}
	public double getH_T() {
		return H_T;
	}
	public void setH_T(double h_T) {
		H_T = h_T;
	}
	public double getQ_solar() {
		return Q_solar;
	}
	public void setQ_solar(double q_solar) {
		Q_solar = q_solar;
	}
	public double getQ_T() {
		return Q_T;
	}
	public void setQ_T(double q_T) {
		Q_T = q_T;
	}
	public double getQ_V() {
		return Q_V;
	}
	public void setQ_V(double q_V) {
		Q_V = q_V;
	}
	public double getQ_source() {
		return Q_source;
	}
	public void setQ_source(double q_source) {
		Q_source = q_source;
	}
	public double getQ_sink() {
		return Q_sink;
	}
	public void setQ_sink(double q_sink) {
		Q_sink = q_sink;
	}
	public double getGamma() {
		return gamma;
	}
	public void setGamma(double gamma) {
		this.gamma = gamma;
	}
	public double getTau() {
		return tau;
	}
	public void setTau(double tau) {
		this.tau = tau;
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getEta() {
		return eta;
	}
	public void setEta(double eta) {
		this.eta = eta;
	}
	public double getQ_h_b() {
		return Q_h_b;
	}
	public void setQ_h_b(double q_h_b) {
		Q_h_b = q_h_b;
	}
	public double getQ_c_b() {
		return Q_c_b;
	}
	public void setQ_c_b(double q_c_b) {
		Q_c_b = q_c_b;
	}
	public double getQ_w_b() {
		return Q_w_b;
	}
	public void setQ_w_b(double q_w_b) {
		Q_w_b = q_w_b;
	}
	public double getQ_l_b() {
		return Q_l_b;
	}
	public void setQ_l_b(double q_l_b) {
		Q_l_b = q_l_b;
	}
	public double getQ_h_f() {
		return Q_h_f;
	}
	public void setQ_h_f(double q_h_f) {
		Q_h_f = q_h_f;
	}
	public double getQ_c_f() {
		return Q_c_f;
	}
	public void setQ_c_f(double q_c_f) {
		Q_c_f = q_c_f;
	}
	public double getQ_w_f() {
		return Q_w_f;
	}
	public void setQ_w_f(double q_w_f) {
		Q_w_f = q_w_f;
	}
	public double getQ_I_p() {
		return Q_I_p;
	}
	public double getQ_I_fac() {
		return Q_I_fac;
	}
	public double getH_V() {
		return H_V;
	}
	public double getH_inf() {
		return H_inf;
	}
	public int getOffice_hours() {
		return office_hours;
	}
	public int getLighting_hours() {
		return lighting_hours;
	}
	public double getHotwater_need() {
		return hotwater_need;
	}
	public double getBoiler_aux() {
		return boiler_aux;
	}
	public double getElec_aux() {
		return elec_aux;
	}
	public double getOutside_building() {
		return outside_building;
	}
	public double getIncident_angle() {
		return incident_angle;
	}
	public double getFrame() {
		return frame;
	}
	public double[] getD_full() {
		return d_full;
	}
	public double[] getD_op() {
		return d_op;
	}
	public double[] getTemp() {
		return temp;
	}
	public double[] getI_s_h() {
		return I_s_h;
	}
	public double[] getI_s_s() {
		return I_s_s;
	}
	public double[] getI_s_se() {
		return I_s_se;
	}
	public double[] getI_s_sw() {
		return I_s_sw;
	}
	public double[] getI_s_e() {
		return I_s_e;
	}
	public double[] getI_s_ne() {
		return I_s_ne;
	}
	public double[] getI_s_nw() {
		return I_s_nw;
	}
	public double[] getI_s_n() {
		return I_s_n;
	}

	public String getGbxmlFilePath() {
		return gbxmlFilePath;
	}

	public void setGbxmlFilePath(String gbxmlFilePath) {
		this.gbxmlFilePath = gbxmlFilePath;
	}
	
}
