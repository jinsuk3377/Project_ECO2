package com.dankook.bsi.model;

public class Info {
	
	private String gbxmlFilePath = "";
	private String HVACFilePath = "";
	
	private double area; //GFA, USER
	private int floor; //USER
	
	private double roof_area;
	private double floor_area;
	private double shell_area;
	private double wall_area;
	private double window_area;
	
	private double U_wall; //열관류율 USER
	private double U_window; //USER
	private double U_roof; //USER
	private double U_floor; //USER
	private double SHGC; //USER
	
	private double H_T_wall; 
	private double H_T_window; 
	private double H_T_roof; 
	private double H_T_floor; 
	
	private double [] each_shell_area;	//외피면적, USER
	private double [] each_wall_area;	//벽체면적, USER
	private double [] each_window_area;	//창면적, USER
	
	private HeatingSystemType HeatingSystemType;
	private HeatingPumpSystemType HeatingPumpSystemType;
	private CoolingSystemType CoolingSystemType;
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
	private final int lighting_hours = 9;
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
	private final double [] I_s_w = {682, 54, 97.6, 63.7, 115, 98.7, 98.2, 72.5, 81.6, 99.6, 76.7, 54.3, 45.2};
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
	private double light_density;
	
	private double Q_h_b[]; //난방에너지요구량
	private double Q_c_b[]; //냉방에너지요구량
	private double Q_w_b[]; //급탕에너지요구량
	private double Q_l_b[]; //조명에너지요구량, 조명에너지 소요량
	private double Q_v_b[]; //환기에너지소요량
	
	private double Q_h_f[]; //난방기기 에너지요구량 계산 사용변수
	private double Q_c_f[]; //냉방기기 에너지요구량 계산 사용변수
	private double Q_w_f[]; //급탕기기 에너지요구량 계산 사용변수
	private double Q_h_f_elec[];	//난방에너지소요량-전기
	private double Q_h_f_gas[];		//난방에너지소요량-가스
	private double Q_h_f_local[];	//난방에너지소요량-지역난방
	private double Q_c_f_elec[];	//냉방에너지소요량-전기
	private double Q_c_f_gas[];		//냉방에너지소요량-가스
	private double Q_c_f_local[];	//냉방에너지소요량-지역난방
	private double Q_w_f_elec[];	//급탕에너지소요량-전기
	private double Q_w_f_gas[];		//급탕에너지소요량-가스
	private double Q_w_f_local[];	//급탕에너지소요량-지역난방
	
	private double Q_h_1[]; //난방1차에너지소요량
	private double Q_c_1[]; //냉방1차에너지소요량
	private double Q_w_1[]; //급탕1차에너지소요량
	private double Q_l_1[]; //조명1차에너지소요량
	private double Q_v_1[]; //환기1차에너지소요량
	

	public Info() {
		each_shell_area = new double[4];
		each_wall_area = new double[4];
		each_window_area = new double[4];
		
		 Q_h_b = new double[13]; //난방에너지요구량
		 Q_c_b = new double[13]; //냉방에너지요구량
		 Q_w_b = new double[13]; //급탕에너지요구량
		 Q_l_b = new double[13]; //조명에너지요구량, 조명에너지 소요량
		 Q_v_b = new double[13]; //환기에너지소요량
		
		 Q_h_1 = new double[13]; //난방1차에너지소요량
		 Q_c_1 = new double[13]; //냉방1차에너지소요량
		 Q_w_1 = new double[13]; //급탕1차에너지소요량
		 Q_l_1 = new double[13]; //조명1차에너지소요량
		 Q_v_1 = new double[13]; //환기1차에너지소요량
		
		 Q_h_f = new double[13]; 	//난방기기 에너지요구량 계산 사용변수
		 Q_c_f = new double[13]; 	//냉방기기 에너지요구량 계산 사용변수
		 Q_w_f = new double[13]; 	//급탕기기 에너지요구량 계산 사용변수
		 Q_h_f_elec = new double[13];	//난방에너지소요량-전기
		 Q_h_f_gas = new double[13];	//난방에너지소요량-가스
		 Q_h_f_local = new double[13];	//난방에너지소요량-지역난방
		 Q_c_f_elec = new double[13];	//냉방에너지소요량-전기
		 Q_c_f_gas = new double[13];	//냉방에너지소요량-가스
		 Q_c_f_local = new double[13];	//냉방에너지소요량-지역난방
		 Q_w_f_elec = new double[13];	//급탕에너지소요량-전기
		 Q_w_f_gas = new double[13];	//급탕에너지소요량-가스
		 Q_w_f_local = new double[13];	//급탕에너지소요량-지역난방
	}
	
	@SuppressWarnings("static-access")
	public void setValues() {

		testSetValues();
		
		floor_area = roof_area;
		shell_area = each_shell_area[0]+each_shell_area[1]+each_shell_area[2]+each_shell_area[3];	//외피면적, USER
		wall_area = each_wall_area[0]+each_wall_area[1]+each_wall_area[2]+each_wall_area[3];	//벽체면적, USER
		window_area = each_window_area[0]+each_window_area[1]+each_window_area[2]+each_window_area[3];
		
		H_T_wall = wall_area * U_wall;
		H_T_window = window_area * U_window;
		H_T_roof = roof_area * U_roof;
		H_T_floor = floor_area * U_floor;
		
		//조명밀도 = 15W/m2 default value
		light_density = 15; 
		Q_I_L = area * light_density * lighting_hours; 
		H_T = H_T_roof + H_T_wall + H_T_window + H_T_floor;
		
		//설비 정보입력까지 default value
		HeatingSystemType = HeatingSystemType.지역난방;
		HeatingPumpSystemType = HeatingPumpSystemType.보일러;
		CoolingSystemType = CoolingSystemType.EHP;
		
		for(int i=1; i<=12; i++) {
			// 난방, 급탕, 조명 계산에 필요한 변수 초기화
			Q_solar = (I_s_s[i] * each_window_area[0] + I_s_w[i] * each_window_area[1]
					+ I_s_n[i] * each_window_area[2] + I_s_e[i] * each_window_area[3])
					* SHGC * 0.9 * 0.9 * 0.7 * 24; //외부건물(0.9) * 태양입사각(0.9) * 프레임(0.7) * 24시간
			Q_T = H_T * (20 - temp[i]) * 24;
			Q_V = H_inf * (20 - temp[i]) * 24 + H_V * (20 - temp[i]) * office_hours;

			if(20 - temp[i] < 0) {
				Q_sink = 0;
				Q_source = Q_solar + Q_I_p + Q_I_fac + Q_I_L - Q_T - Q_V;
				gamma = 1;
			} else {
				Q_sink = Q_T + Q_V;
				Q_source = Q_solar + Q_I_p + Q_I_fac + Q_I_L;
				gamma = Q_source / Q_sink;
			}
			
			tau = 90 / (H_T + H_V + H_inf);
			a = 1 + tau / 16;
			
			if(gamma == 1) {
				eta = a / (a + 1);
			} else {
				eta = (1 - Math.pow(gamma, a)) / (1 - Math.pow(gamma, a + 1));
			}
			
			//요구량 계산
			Q_h_b[i] = (Q_sink - eta * Q_source) * d_op[i] / (area * 0.7) / 1000;
			if(Q_h_b[i] < 0) Q_h_b[i] = 0;
			
			Q_w_b[i] = hotwater_need * d_op[i] / (1000 * 0.5);
			
			Q_l_b[i] = light_density * lighting_hours * d_op[i] / (1000 * 0.7);
			
			Q_l_1[i] = Q_l_b[i] * 2.75;
			
			switch(HeatingSystemType) {
			case 보일러:
				Q_h_f[i] = (Q_h_b[i] * boiler_aux) / (0.87 * 0.9 / 100); //보일러 난방효율 0.87
				Q_h_f_elec[i] = Q_h_f[i];
				Q_h_f_gas[i] = Q_h_f[i] * 0.1;
				Q_h_f_local[i] = 0;
				break;
			case 지역난방:
				Q_h_f[i] = (Q_h_b[i] * boiler_aux);
				Q_h_f_elec[i] = 0;
				Q_h_f_gas[i] = Q_h_f[i] * 0.1;
				Q_h_f_local[i] = Q_h_f[i];
			case EHP:
				Q_h_f[i] = (Q_h_b[i] * elec_aux) / (0.0411 * 0.9); //EHP 난방효율 0.0411 
				Q_h_f_elec[i] = 0;
				Q_h_f_gas[i] = Q_h_f[i];
				Q_h_f_local[i] = 0;
			}
			
			Q_h_1[i] = Q_h_f_elec[i] * 2.75 + Q_h_f_gas[i] * 1.1 + Q_h_f_local[i] * 0.728; 
			
			switch(HeatingPumpSystemType) {
			case 보일러:
				Q_w_f[i] = (Q_w_b[i] * boiler_aux) / (0.88 * 0.9 / 100); //보일러 급탕효율 0.88
				Q_w_f_elec[i] = Q_w_f[i];
				Q_w_f_gas[i] = Q_w_f[i] * 0.1;
				Q_w_f_local[i] = 0;
				break;
			case 지역난방:
				Q_w_f[i] = (Q_w_b[i] * boiler_aux);
				Q_w_f_elec[i] = 0;
				Q_w_f_gas[i] = Q_w_f[i] * 0.1;
				Q_w_f_local[i] = Q_w_f[i];
			case EHP:
				Q_w_f[i] = (Q_w_b[i] * elec_aux) / (0.0411 * 0.9); //EHP 급탕효율 0.0411 
				Q_w_f_elec[i] = 0;
				Q_w_f_gas[i] = Q_w_f[i];
				Q_w_f_local[i] = 0;
			}
			
			Q_w_1[i] = Q_w_f_elec[i] * 2.75 + Q_w_f_gas[i] * 1.1 + Q_w_f_local[i] * 0.728;
			
			
			
			// 냉방, 환기 계산에 필요한 변수 초기화
			Q_T = H_T * (26 - temp[i]) * 24;
			Q_V = H_inf * (26 - temp[i]) * 24 + H_V * (26 - temp[i]) * office_hours;
			
			if(26 - temp[i] < 0) {
				Q_sink = 0;
				Q_source = Q_solar + Q_I_p + Q_I_fac + Q_I_L - Q_T - Q_V;
				eta = 0;
			} else {
				Q_sink = Q_T + Q_V;
				Q_source = Q_solar + Q_I_p + Q_I_fac + Q_I_L;
				gamma = Q_source / Q_sink;
				tau = 90 / (H_T + H_V + H_inf);
				a = 1 + tau / 16;
				if(gamma == 1) {
					eta = a / (a + 1);
				} else {
					eta = (1 - Math.pow(gamma, -a)) / (1 - Math.pow(gamma, -a - 1));
				}
			}
			
			//요구량 계산
			Q_c_b[i] = (Q_source - eta * Q_sink) * d_op[i] / (area * 0.7) / 1000;
			if(Q_c_b[i] < 0) Q_c_b[i] = 0;
			
			Q_v_b[i] = Q_c_b[i] / 0.34 / 10;
			
			Q_v_1[i] = Q_c_b[i] / 0.34 / 10 * 2.75;
			
			switch(CoolingSystemType) {
			case 압축식:
				Q_c_f[i] = (Q_c_b[i] * elec_aux) / (0.0456 * 0.7); //보일러 난방효율 0.0456
				Q_c_f_elec[i] = 0;
				Q_c_f_gas[i] = Q_c_f[i];
				Q_c_f_local[i] = 0;
				break;
			case 흡수식:
				Q_c_f[i] = (Q_h_b[i] * boiler_aux);
				Q_c_f_elec[i] = Q_c_f[i];
				Q_c_f_gas[i] = Q_c_f[i] * 0.1;
				Q_c_f_local[i] = 0;
			case EHP:
				Q_c_f[i] = (Q_c_b[i] * elec_aux) / (0.0378 * 0.9); //EHP 난방효율 0.0378 
				Q_c_f_elec[i] = 0;
				Q_c_f_gas[i] = Q_c_f[i];
				Q_c_f_local[i] = 0;
			}
			
			Q_c_1[i] = Q_c_f_elec[i] * 2.75 + Q_c_f_gas[i] * 1.1 + Q_c_f_local[i] * 0.728;
		}
		
		this.printBIX();
	}
	
	public void testSetValues() {
		area = 13117.3;
		floor = 6;
		roof_area = 2186;
		
		U_wall = 0.47; //열관류율 USER
		U_window = 3.4; //USER
		U_roof = 0.29; //USER
		U_floor = 0.41; //USER
		SHGC = 0.56; //USER
		
		each_shell_area = new double[]{1772.133, 886.0667, 1772.133, 886.0667};
		each_wall_area = new double[]{886.0667, 354.4267, 708.8533, 354.4267};
		each_window_area = new double[]{886.0667, 531.6400, 1063.2800, 531.6400};
	}
	
	
	public void printBIX() {
		
		System.out.printf("Area : %-15f\n", getArea());
		System.out.printf("Roof_Area : %-15f\n", getRoof_area());
		System.out.printf("Floor : %-15d\n", getFloor());
		System.out.printf("외벽열관류율 : %-15f\n", getU_wall());
		System.out.printf("창호열관류율 : %-15f\n", getU_window());
		System.out.printf("지붕열관류율 : %-15f\n", getU_roof());
		System.out.printf("바닥열관류율 : %-15f\n", getU_floor());
		System.out.printf("SHGC : %-15f\n", getSHGC());
		System.out.printf("외피면적(N) : %-12f", getEach_shell_area()[0]);
		System.out.printf("외피면적(E) : %-12f", getEach_shell_area()[1]);
		System.out.printf("외피면적(S) : %-12f", getEach_shell_area()[2]);
		System.out.printf("외피면적(W) : %-12f\n", getEach_shell_area()[3]);
		System.out.printf("창면적(N) : %-13f", getEach_window_area()[0]);
		System.out.printf("창면적(E) : %-13f", getEach_window_area()[1]);
		System.out.printf("창면적(S) : %-13f", getEach_window_area()[2]);
		System.out.printf("창면적(W) : %-13f\n", getEach_window_area()[3]);
		System.out.printf("벽체면적(N) : %-12f", getEach_wall_area()[0]);
		System.out.printf("벽체면적(E) : %-12f", getEach_wall_area()[1]);
		System.out.printf("벽체면적(S) : %-12f", getEach_wall_area()[2]);
		System.out.printf("벽체면적(W) : %-12f\n", getEach_wall_area()[3]);
		
		System.out.printf("난방에너지요구량 :     ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_h_b[i]);
		System.out.printf("\n냉방에너지요구량 :     ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_c_b[i]);
		System.out.printf("\n급탕에너지요구량 :     ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_w_b[i]);
		System.out.printf("\n조명에너지요구량 :     ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_l_b[i]);
		System.out.printf("\n난방에너지소요량 전기 :  ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_h_f_elec[i]);
		System.out.printf("\n난방에너지소요량 가스 :  ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_h_f_gas[i]);
		System.out.printf("\n난방에너지소요량 지역 :  ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_h_f_local[i]);
		System.out.printf("\n냉방에너지소요량 전기 :  ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_c_f_elec[i]);
		System.out.printf("\n냉방에너지소요량 가스 :  ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_c_f_gas[i]);
		System.out.printf("\n냉방에너지소요량 지역 :  ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_c_f_local[i]);
		System.out.printf("\n급탕에너지소요량 전기 :  ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_w_f_elec[i]);
		System.out.printf("\n급탕에너지소요량 가스 :  ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_w_f_gas[i]);
		System.out.printf("\n급탕에너지소요량 지역 :  ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_w_f_local[i]);
		System.out.printf("\n조명에너지소요량 :     ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_l_b[i]);
		System.out.printf("\n환기에너지소요량 :     ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_v_b[i]);
		System.out.printf("\n난방1차에너지소요량 :   ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_h_1[i]);
		System.out.printf("\n냉방1차에너지소요량 :   ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_c_1[i]);
		System.out.printf("\n급탕1차에너지소요량 :   ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_w_1[i]);
		System.out.printf("\n조명1차에너지소요량 :   ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_l_1[i]);
		System.out.printf("\n환기1차에너지소요량 :   ");
		for(int i=1; i<=12; i++) 
			System.out.printf("%f  ", Q_v_1[i]);
	}
	
	public void printHVAC() {
		
		System.out.println("난방기기");
		System.out.println("\t기기방식 : " + HeatingSystemType.name());
		System.out.println("\t용량 : " + HeatingVolumn);
		System.out.println("\t효율 : " + HeatingEfficiency);
		System.out.println("급탕기기");
		System.out.println("\t기기방식 : " + HeatingPumpSystemType.name());
		System.out.println("\t용량 : " + HeatingPumpVolumn);
		System.out.println("\t효율 : " + HeatingPumpEfficiency);
		System.out.println("냉방기기");
		System.out.println("\t기기방식 : " + CoolingSystemType.name());
		System.out.println("\t용량 : " + CoolingVolumn);
		System.out.println("\t효율 : " + CoolingEfficiency);
		System.out.println("조명기기");
		System.out.println("\t조명밀도 : " + LightingDensity);
	}
	
	
public void printHVACTest() {
		
		System.out.println("난방기기");
		System.out.println("\t기기방식 : " + HeatingSystemType.name());
		System.out.println("\t용량 : " + getHeatingVolumn());
		System.out.println("\t효율 : " + getHeatingEfficiency());
		System.out.println("급탕기기");
		System.out.println("\t기기방식 : " + HeatingPumpSystemType.name());
		System.out.println("\t용량 : " + HeatingPumpVolumn);
		System.out.println("\t효율 : " + HeatingPumpEfficiency);
		System.out.println("냉방기기");
		System.out.println("\t기기방식 : " + CoolingSystemType.name());
		System.out.println("\t용량 : " + getCoolingVolumn());
		System.out.println("\t효율 : " + getCoolingEfficiency());
	}
	
	public static String[] parseString(String[] str, double[] array) {
		
		String[] strArray = new String[str.length+array.length-1];
		for(int i=0; i<str.length; i++) {
			strArray[i] = str[i];
		}
		for(int i=0; i<array.length-1; i++) {
			strArray[i+str.length] = String.valueOf(array[i+1]);
		}
		
		return strArray;
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
	public double getU_wall() {
		return U_wall;
	}
	public void setU_wall(double u_wall) {
		U_wall = u_wall;
	}
	public double getU_window() {
		return U_window;
	}
	public void setU_window(double u_window) {
		U_window = u_window;
	}
	public double getU_roof() {
		return U_roof;
	}
	public void setU_roof(double u_roof) {
		U_roof = u_roof;
	}
	public double getU_floor() {
		return U_floor;
	}
	public void setU_floor(double u_floor) {
		U_floor = u_floor;
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
	public HeatingSystemType getHeatingSystemType() {
		return HeatingSystemType;
	}
	public void setHeatingSystemType(HeatingSystemType heatingSystemType) {
		HeatingSystemType = heatingSystemType;
	}
	public HeatingPumpSystemType getHeatingPumpSystemType() {
		return HeatingPumpSystemType;
	}
	public void setHeatingPumpSystemType(HeatingPumpSystemType heatingPumpSystemType) {
		HeatingPumpSystemType = heatingPumpSystemType;
	}
	public CoolingSystemType getCoolingSystemType() {
		return CoolingSystemType;
	}
	public void setCoolingSystemType(CoolingSystemType coolingSystemType) {
		CoolingSystemType = coolingSystemType;
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

	public String getGbxmlFilePath() {
		return gbxmlFilePath;
	}

	public void setGbxmlFilePath(String gbxmlFilePath) {
		this.gbxmlFilePath = gbxmlFilePath;
	}
	
	public String getHVACFilePath() {
		return HVACFilePath;
	}
	
	public void setHVACFilePath(String HVACFilePath) {
		this.HVACFilePath = HVACFilePath;
	}

	public double getLight_density() {
		return light_density;
	}

	public void setLight_density(double light_density) {
		this.light_density = light_density;
	}
	
	public double getQ_I_L() {
		return Q_I_L;
	}

	public void setQ_I_L(double q_I_L) {
		Q_I_L = q_I_L;
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

	public double[] getQ_h_b() {
		return Q_h_b;
	}

	public void setQ_h_b(double[] q_h_b) {
		Q_h_b = q_h_b;
	}

	public double[] getQ_c_b() {
		return Q_c_b;
	}

	public void setQ_c_b(double[] q_c_b) {
		Q_c_b = q_c_b;
	}

	public double[] getQ_w_b() {
		return Q_w_b;
	}

	public void setQ_w_b(double[] q_w_b) {
		Q_w_b = q_w_b;
	}

	public double[] getQ_l_b() {
		return Q_l_b;
	}

	public void setQ_l_b(double[] q_l_b) {
		Q_l_b = q_l_b;
	}

	public double[] getQ_v_b() {
		return Q_v_b;
	}

	public void setQ_v_b(double[] q_v_b) {
		Q_v_b = q_v_b;
	}

	public double[] getQ_h_f_elec() {
		return Q_h_f_elec;
	}

	public void setQ_h_f_elec(double[] q_h_f_elec) {
		Q_h_f_elec = q_h_f_elec;
	}

	public double[] getQ_h_f_gas() {
		return Q_h_f_gas;
	}

	public void setQ_h_f_gas(double[] q_h_f_gas) {
		Q_h_f_gas = q_h_f_gas;
	}

	public double[] getQ_h_f_local() {
		return Q_h_f_local;
	}

	public void setQ_h_f_local(double[] q_h_f_local) {
		Q_h_f_local = q_h_f_local;
	}

	public double[] getQ_c_f_elec() {
		return Q_c_f_elec;
	}

	public void setQ_c_f_elec(double[] q_c_f_elec) {
		Q_c_f_elec = q_c_f_elec;
	}

	public double[] getQ_c_f_gas() {
		return Q_c_f_gas;
	}

	public void setQ_c_f_gas(double[] q_c_f_gas) {
		Q_c_f_gas = q_c_f_gas;
	}

	public double[] getQ_c_f_local() {
		return Q_c_f_local;
	}

	public void setQ_c_f_local(double[] q_c_f_local) {
		Q_c_f_local = q_c_f_local;
	}

	public double[] getQ_w_f_elec() {
		return Q_w_f_elec;
	}

	public void setQ_w_f_elec(double[] q_w_f_elec) {
		Q_w_f_elec = q_w_f_elec;
	}

	public double[] getQ_w_f_gas() {
		return Q_w_f_gas;
	}

	public void setQ_w_f_gas(double[] q_w_f_gas) {
		Q_w_f_gas = q_w_f_gas;
	}

	public double[] getQ_w_f_local() {
		return Q_w_f_local;
	}

	public void setQ_w_f_local(double[] q_w_f_local) {
		Q_w_f_local = q_w_f_local;
	}

	public double[] getQ_h_1() {
		return Q_h_1;
	}

	public void setQ_h_1(double[] q_h_1) {
		Q_h_1 = q_h_1;
	}

	public double[] getQ_c_1() {
		return Q_c_1;
	}

	public void setQ_c_1(double[] q_c_1) {
		Q_c_1 = q_c_1;
	}

	public double[] getQ_w_1() {
		return Q_w_1;
	}

	public void setQ_w_1(double[] q_w_1) {
		Q_w_1 = q_w_1;
	}

	public double[] getQ_l_1() {
		return Q_l_1;
	}

	public void setQ_l_1(double[] q_l_1) {
		Q_l_1 = q_l_1;
	}

	public double[] getQ_v_1() {
		return Q_v_1;
	}

	public void setQ_v_1(double[] q_v_1) {
		Q_v_1 = q_v_1;
	}

	public double getQ_I_p() {
		return Q_I_p;
	}

	public double getQ_I_fac() {
		return Q_I_fac;
	}
	
}
