package com.example.demo;

import java.io.Serializable;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConstantesController implements Serializable {

	private static final long serialVersionUID = -4748753749748021840L;

	@GetMapping(path = "fijas")
	public Map<String, String> getConstantes() {
		return null;
	}

	@GetMapping(path = "generados")
	public Map<String, String> getDiasAniosConstantes() {
		return null;
	}

}
