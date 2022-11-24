package sc.senac.br.sistemabiblioteca.dto;

public class LivrosPorCategoriaDTO {

	private String categoria;
	private Long quantidadeLivros;
	
	public LivrosPorCategoriaDTO(String categoria, Long quantidadeLivros) {
		this.categoria = categoria;
		this.quantidadeLivros = quantidadeLivros;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Long getQuantidadeLivros() {
		return quantidadeLivros;
	}
	public void setQuantidadeLivros(Long quantidadeLivros) {
		this.quantidadeLivros = quantidadeLivros;
	}
	
	
}
