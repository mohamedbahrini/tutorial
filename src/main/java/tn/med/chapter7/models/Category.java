package tn.med.chapter7.models;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude="recipes")
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String categoryName;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="categories", cascade = CascadeType.ALL)
	Set<Recipe> recipes = new HashSet<>();

}
