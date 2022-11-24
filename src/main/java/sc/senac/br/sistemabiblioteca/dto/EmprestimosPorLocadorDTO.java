package sc.senac.br.sistemabiblioteca.dto;

public class EmprestimosPorLocadorDTO {
	
	private String locador;
	private Long quantidadeEmprestimo;
	
	public EmprestimosPorLocadorDTO(String locador, Long quantidadeEmprestimo) {
		this.locador = locador;
		this.quantidadeEmprestimo = quantidadeEmprestimo;
	}

	public String getLocador() {
		return locador;
	}

	public void setLocador(String locador) {
		this.locador = locador;
	}

	public Long getQuantidadeEmprestimo() {
		return quantidadeEmprestimo;
	}

	public void setQuantidadeEmprestimo(Long quantidadeEmprestimo) {
		this.quantidadeEmprestimo = quantidadeEmprestimo;
	}
	
	
	
	

}
