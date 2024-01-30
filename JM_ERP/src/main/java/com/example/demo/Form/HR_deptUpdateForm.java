package com.example.demo.Form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HR_deptUpdateForm {
	@NotEmpty(message = "부서의 새로운 이름을 입력해주세요.")
	private String deptName;
	
	private String deptCode;
}
