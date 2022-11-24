package sc.senac.br.sistemabiblioteca.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;

import sc.senac.br.sistemabiblioteca.dao.EmprestimoDao;
import sc.senac.br.sistemabiblioteca.dto.EmprestimosPorLocadorDTO;

@ManagedBean
public class ChartEmprestimoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EmprestimoDao emprestimoDao;
	private List<EmprestimosPorLocadorDTO> emprestimosPorLocadorDTOs;
	private PieChartModel emprestimosPorLocadorModel;
	
	private List<String> cores = Arrays.asList("#FF5950", "#EBD943", "#52FF5F", "#6BEBE5", "#B16FFF", "#EB8D51",
			"#6D6EFF");
	
	public ChartEmprestimoController() {
		emprestimoDao = new EmprestimoDao();
		emprestimosPorLocadorDTOs = emprestimoDao.buscarEmprestimosPorLocador();
		iniciarGraficoEmprestimosPorLocador();
	}
	
	private void iniciarGraficoEmprestimosPorLocador() {
		emprestimosPorLocadorModel = new PieChartModel();
		
		List<Number> valores = new ArrayList<>();
		List<String> rotulos = new ArrayList<>();
		
		for (EmprestimosPorLocadorDTO dto : emprestimosPorLocadorDTOs) {
			valores.add(dto.getQuantidadeEmprestimo());
			rotulos.add(dto.getLocador());
		}
		
		PieChartDataSet dataset = new PieChartDataSet();
		dataset.setData(valores);
		dataset.setBackgroundColor(cores);
		
		ChartData dados = new ChartData();
		dados.addChartDataSet(dataset);
		dados.setLabels(rotulos);
		
		emprestimosPorLocadorModel.setData(dados);
	}

	public PieChartModel getEmprestimosPorLocadorModel() {
		return emprestimosPorLocadorModel;
	}

}
