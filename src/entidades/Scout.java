package entidades;

import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(ScoutTypeAdapter.class)
public class Scout {
	
	private String acao;
	private int valor;
	
	Scout(){
		
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
			
	
	
}
