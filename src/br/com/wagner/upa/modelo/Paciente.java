package br.com.wagner.upa.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Paciente {
	@Id
	@SequenceGenerator(name = "paciente_id", sequenceName = "paciente_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_id")
	private Long id;
	@NotEmpty(message = "O CPF deve ser informado")
	@CPF(message = "CPF inválido")
	private String cpf;
	@NotEmpty(message = "O nome deve ser informado")
	private String nome;
	@NotEmpty(message = "O telefone deve ser informado")
	private String telefone;
	@NotEmpty(message = "O sexo deve ser informado")
	private String sexo;
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	@NotEmpty(message = "O endereço deve ser informado")
	private String endereco;
	
	public Paciente() {
		dataNascimento = Calendar.getInstance();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
