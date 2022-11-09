package task1.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "commands")
public class Command {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String command_name;
	
	@Column(name="command_description") 
	private String command_description;
	
	@Column(name="class_name") 
	private String class_name;
	
	@Column(name="method_name") 
	private String method_name;

	public Command(String command_description, String class_name, String method_name) {
		this.command_description = command_description;
		this.class_name = class_name;
		this.method_name = method_name;
	}

	public Command() { }

	public String getCommand_name() {
		return command_name;
	}

	public void setCommand_name(String command_name) {
		this.command_name = command_name;
	}

	public String getCommand_description() {
		return command_description;
	}

	public void setCommand_description(String command_description) {
		this.command_description = command_description;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getMethod_name() {
		return method_name;
	}

	public void setMethod_name(String method_name) {
		this.method_name = method_name;
	}
	
	
	
}
