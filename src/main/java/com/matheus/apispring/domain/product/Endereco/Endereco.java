package com.matheus.apispring.domain.product.Endereco;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "endereco")
@Entity(name = "endereco")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Endereco {
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private String id ;
	private  String rua ;
	private String numero;
	private  String Bairro;
	private String Cidade;
	private String Estado;
	private String cep;



}
