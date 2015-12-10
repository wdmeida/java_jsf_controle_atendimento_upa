package br.com.wagner.upa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Medico {
	@Id
	@SequenceGenerator(name = "medico_id", sequenceName = "medico_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medico_id")
	private Long id;
	@NotEmpty(message = "CRM deve ser cadastrado")
	private String crm;
	@NotEmpty(message = "Nome deve ser cadastrado")
	private String nome;
	@NotEmpty(message = "O telefone deve ser cadastrado")
	private String telefone;
	@NotEmpty(message = "A área de especialização deve ser cadastrada")
	private String area;
	@NotNull(message = "O salário deve ser cadastrado")
	private Double salario;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCrm() {
		return crm;
	}
	
	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
}
