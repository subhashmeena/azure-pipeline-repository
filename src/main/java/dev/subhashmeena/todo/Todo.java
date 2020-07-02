package dev.subhashmeena.todo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	public long id;
	
	@NonNull
	@NotNull(message="Please provide the task details")
	public String task;
	
}
