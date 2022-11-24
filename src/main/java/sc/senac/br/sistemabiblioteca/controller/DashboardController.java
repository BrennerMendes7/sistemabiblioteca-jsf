package sc.senac.br.sistemabiblioteca.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;


import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;

import sc.senac.br.sistemabiblioteca.dao.LivroDao;
import sc.senac.br.sistemabiblioteca.dto.LivrosPorCategoriaDTO;

@ManagedBean
public class DashboardController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private LivroDao livroDao;
	private List<LivrosPorCategoriaDTO> livrosPorCategoriaDTOs;
	private PieChartModel livrosPorCategoriaModel;
	
	private List<String> cores = Arrays.asList("#FF5950", "#EBD943", "#52FF5F", "#6BEBE5", "#B16FFF", "#EB8D51",
			"#6D6EFF");
	
	public DashboardController() {
		livroDao = new LivroDao();
		livrosPorCategoriaDTOs = livroDao.buscarLivrosPorCategoria();
		iniciarGraficoLivrosPorCategoria();
	}
	
	private void iniciarGraficoLivrosPorCategoria() {
		livrosPorCategoriaModel = new PieChartModel();
		
		List<Number> valores = new ArrayList<>();
		List<String> rotulos = new ArrayList<>();
		
		for(LivrosPorCategoriaDTO dto : livrosPorCategoriaDTOs) {
			rotulos.add(dto.getCategoria());
			valores.add(dto.getQuantidadeLivros());
		}
		
		PieChartDataSet dataset = new PieChartDataSet();
		dataset.setData(valores);
		dataset.setBackgroundColor(cores);
		
		ChartData dados = new ChartData();
		dados.addChartDataSet(dataset);
		dados.setLabels(rotulos);
		
		livrosPorCategoriaModel.setData(dados);
		
	}

	public PieChartModel getLivrosPorCategoriaModel() {
		return livrosPorCategoriaModel;
	}
	

}
