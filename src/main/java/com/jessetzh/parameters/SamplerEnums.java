package com.jessetzh.parameters;

public enum SamplerEnums {

	Euler_a(1, "Euler_a"),
	Euler(2, "Euler"),
	LMS(3, "LMS"),
	Heun(4, "Heun"),
	DPM2(5, "DPM2"),
	DPM2_a(6, "DPM2 a"),
	DPM_2S_a(7, "DPM++ 2S a"),
	DPM_2M(8, "DPM++ 2M"),
	DPM_SDE(9, "DPM++ SDE"),
	DPM_fast(10, "DPM fast"),
	DPM_adaptive(11, "DPM adaptive"),
	LMS_Karras(12, "LMS Karras"),
	DPM2_Karras(13, "DPM2 Karras"),
	DPM2_a_Karras(14, "DPM2 a Karras"),
	DPM_2S_a_Karras(15, "DPM++ 2S a Karras"),
	DPM_2M_Karras(16, "DPM++ 2M Karras"),
	DPM_SDE_Karras(17, "DPM++ SDE Karras"),
	DDIM(18, "DDIM"),
	PLMS(19, "PLMS"),
	UniPC(20, "UniPC");

	private final Integer code;

	private final String info;

	public Integer getCode() {
		return code;
	}

	public String getInfo() {
		return info;
	}

	SamplerEnums(int i, String samplerName) {
		this.code = i;
		this.info = samplerName;
	}
}
