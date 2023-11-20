package com.matheus.apispring.domain.product.Endereco;

import jakarta.persistence.*;
import lombok.*;

@Table
@Entity(name = "endereco")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Endereco {
	@Id
@ManyToOne
	private String id ;
	private  String rua ;
	private String numero;
	private  String Bairro;
	private String cidade;
	private String estado;
	private String cep;



}
