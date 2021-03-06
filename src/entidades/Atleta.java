package entidades;


import com.google.gson.annotations.SerializedName;

public class Atleta {
	
	@SerializedName("nome")
	private String nome;
	
	@SerializedName("apelido")
	private String apelido;
	
	@SerializedName("foto")
	private String foto;
	
	@SerializedName("atleta_id")
	private int atleta_id;
	
	@SerializedName("rodada_id")
	private int rodada_id;
	
	@SerializedName("clube_id")
	private int clube_id;
	
	@SerializedName("posicao_id")
	private int posicao_id;
	
	@SerializedName("status_id")
	private int status_id;
	
	@SerializedName("pontos_num")
	private double pontos_num;
	
	@SerializedName("preco_num")
	private double preco_num;
	
	@SerializedName("variacao_num")
	private double variacao_num;
	
	@SerializedName("media_num")
	private double media_num;
	
	@SerializedName("jogos_num")
	private int jogos_num;
	
	
	@SerializedName("scout")
	private Scout scout[];
	
	public Atleta(){
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public int getAtleta_id() {
		return atleta_id;
	}
	public void setAtleta_id(int atleta_id) {
		this.atleta_id = atleta_id;
	}
	public int getRodada_id() {
		return rodada_id;
	}
	public void setRodada_id(int rodada_id) {
		this.rodada_id = rodada_id;
	}
	public int getClube_id() {
		return clube_id;
	}
	public void setClube_id(int clube_id) {
		this.clube_id = clube_id;
	}
	public int getPosicao_id() {
		return posicao_id;
	}
	public void setPosicao_id(int posicao_id) {
		this.posicao_id = posicao_id;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public double getPontos_num() {
		return pontos_num;
	}
	public void setPontos_num(double pontos_num) {
		this.pontos_num = pontos_num;
	}
	public double getPreco_num() {
		return preco_num;
	}
	public void setPreco_num(double preco_num) {
		this.preco_num = preco_num;
	}
	public double getVariacao_num() {
		return variacao_num;
	}
	public void setVariacao_num(double variacao_num) {
		this.variacao_num = variacao_num;
	}
	public double getMedia_num() {
		return media_num;
	}
	public void setMedia_num(double media_num) {
		this.media_num = media_num;
	}
	public int getJogos_num() {
		return jogos_num;
	}
	public void setJogos_num(int jogos_num) {
		this.jogos_num = jogos_num;
	}

	/*
	public Scout[] getScout() {
		return scout;
	}

	public void setScout(Scout[] scout) {
		this.scout = scout;
	}*/

	

	
	
	
}
