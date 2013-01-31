package org.hitplay.audio.dto;

public class SimpleTagDTO {

	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	private Long value;
	private String  label;
}
