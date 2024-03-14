package com.matheus.apispring.domain.titular;

import com.matheus.apispring.dtos.TitularDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.annotation.Nullable;
import java.math.BigInteger;
import java.time.Instant;

@Entity(name = "Titular")
@Table(name = "titular")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Titular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	private String nome;

	@Column(name = "cpf_cnpj")
	private String cpfcnpj;
	private String pseudonimo;

	@Column(name = "codigo_ecad")
	private BigInteger codigoecad;

	@Column(name = "codigo_socinpro")
	private BigInteger codigosocinpro;

	@Nullable
	private Double saldo;
	@Nullable
	private String foto_perfil;

	@PrePersist
	protected void onPrePersist() {
		// Geração de códigos baseada no timestamp. Isso é apenas um exemplo e pode
		// não ser ideal para todos os casos, especialmente se houver muitas inserções
		// em um curto período de tempo.
		long timestamp = Instant.now().toEpochMilli();
		this.codigoecad = BigInteger.valueOf(timestamp);

		// Para garantir que o código Socinpro seja diferente, podemos adicionar um valor,
		// como 1, ao timestamp. Ajuste conforme necessário.
		this.codigosocinpro = BigInteger.valueOf(timestamp + 1);
	}

	public Titular(TitularDTO titularDTO){
		this.cpfcnpj = titularDTO.cpfcnpj();
		this.foto_perfil = titularDTO.foto_perfil();
		this.id = titularDTO.id();
		this.nome = titularDTO.nome();
		this.saldo = titularDTO.saldo();
		this.pseudonimo = titularDTO.pseudonimo();
	}
}
