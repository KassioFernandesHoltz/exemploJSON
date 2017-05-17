package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.commons.io.IOUtils;

import entidades.Atleta;
import entidades.Pessoa;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		Atleta atleta1 = new Atleta();
		Atleta atleta2 = new Atleta();
		Atleta atletas [] = new Atleta[2];
		
		atleta1.setNome("Kassio fernandes");
		atleta1.setApelido("peta");
		atleta1.setFoto("minhafoto");
		atleta1.setAtleta_id(54395);
		atleta1.setRodada_id(1);
		atleta1.setClube_id(282);
		atleta1.setPosicao_id(4);
		atleta1.setStatus_id(7);
		atleta1.setPontos_num(9.6);
		atleta1.setPreco_num(16.69);
		atleta1.setVariacao_num(2.69);
		atleta1.setMedia_num(9.6);
		atleta1.setJogos_num(1);
		
		atleta2.setNome("Lilian");
		atleta2.setApelido("lili");
		atleta2.setFoto("minhafotolilian");
		atleta2.setAtleta_id(54395);
		atleta2.setRodada_id(1);
		atleta2.setClube_id(282);
		atleta2.setPosicao_id(4);
		atleta2.setStatus_id(7);
		atleta2.setPontos_num(9.6);
		atleta2.setPreco_num(16.69);
		atleta2.setVariacao_num(2.69);
		atleta2.setMedia_num(9.6);
		atleta2.setJogos_num(1);
		
		atletas[0] = atleta1;
		atletas[1] = atleta2;
		
		try {
			
			 System.out.println(gson.toJson(atletas));
			
			/*
			BufferedReader br = new BufferedReader(new FileReader(
					"c:\\kassio\\teste.json"));
			Pessoa pessoa[] = gson.fromJson(br, Pessoa[].class);

			for (int i = 0; i < pessoa.length; i++) {
				System.out.println(pessoa[i].getNome());
			}*/

			/*
			BufferedReader br2 = new BufferedReader(new FileReader(
					"c:\\kassio\\mercado2.json"));*/
			BufferedReader br2 = new BufferedReader(new FileReader(
					"c:\\kassio\\teste.json"));
			String url = "c:\\kassio\\teste2.json";
			//String json = IOUtils.toString(new URL(url));
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(url);
			
			if (element.isJsonObject()) {
				JsonObject atletaTeste = element.getAsJsonObject();
				System.out.println(atletaTeste.get("apelido").getAsString());
				JsonArray datasets = atletaTeste.getAsJsonArray("scout");
				for (int i = 0; i < datasets.size(); i++) {
					JsonObject dataset = datasets.get(i).getAsJsonObject();
					System.out.println(dataset.get("scout").getAsString());
				}
			}else{
				System.out.println("não deu");
			}
			
			//Atleta atleta[] = gson.fromJson(br2, Atleta[].class);

			/*
			 * for (int i = 0; i < atleta.length; i++) { nome =
			 * trocaLetra(atleta[i].getNome()); alcunha =
			 * trocaLetra(atleta[i].getApelido()); System.out.println(nome +
			 * " - " + alcunha);
			 * 
			 * }
			 */
			/*
			for (int i = 0; i < atleta.length; i++) {
				if (atleta[i].getPosicao_id() != 6) {

					if (verificaJogador(atleta[i].getAtleta_id())) {
						alteraJogador(atleta[i]);
						System.out.println("alterado: "
								+ trocaLetra(atleta[i].getNome()) + " - "
								+ trocaLetra(atleta[i].getApelido()));
					} else {
						inserirJogador(atleta[i]);
						System.out.println("Inserido jogador: "
								+ trocaLetra(atleta[i].getNome()) + " - "
								+ trocaLetra(atleta[i].getApelido()));
					}
				}
			} */

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static String trocaLetra(String texto) {
		String Aux = texto;
		Aux = Aux.replaceAll("Ã©", "é");
		Aux = Aux.replaceAll("Ãº", "ú");
		Aux = Aux.replaceAll("Ã­", "í");
		Aux = Aux.replaceAll("Ã³", "ó");
		Aux = Aux.replaceAll("Ã¢", "â");
		Aux = Aux.replaceAll("Ã£", "ã");
		Aux = Aux.replaceAll("Ã´", "ô");
		Aux = Aux.replaceAll("Ã¡", "á");
		// Aux = Aux.replaceAll("Ã?","Á");
		Aux = Aux.replaceAll("Ã§", "ç");
		Aux = Aux.replaceAll("Ã‚", "Â");
		Aux = Aux.replaceAll("Ãµ", "õ");
		Aux = Aux.replaceAll("Ã‰", "É");
		Aux = Aux.replaceAll("Ãª", "ê");
		Aux = Aux.replaceAll("Ãª", "ê");
		Aux = Aux.replaceAll("Ã±", "ñ");
		Aux = Aux.replaceAll("Ándio", "Índio");
		return Aux;
	}

	public static boolean verificaJogador(int codigo) throws SQLException {

		try {
			Connection connection = new util.ConnectionFactory()
					.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT COUNT(*) total from USU_t001jog WHERE USU_CodJog=? ");
			stmt.setInt(1, codigo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int total = rs.getInt("total");
			stmt.close();
			connection.close();
			if (total == 0) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static void inserirJogador(Atleta atleta) {
		try {
			String nome = trocaLetra(atleta.getNome());
			String alcunha = trocaLetra(atleta.getApelido());
			Connection connection = new util.ConnectionFactory()
					.getConnection();
			String sql = "INSERT INTO USU_t001jog "
					+ "(USU_CodJog,USU_NomJog,USU_ApeJog,USU_CodClu,"
					+ "USU_CodPos,USU_StaJog,USU_PreJog,USU_VarJog) "
					+ "VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, atleta.getAtleta_id());
			stmt.setString(2, nome);
			stmt.setString(3, alcunha);
			stmt.setInt(4, buscarClube(atleta.getClube_id()));
			stmt.setInt(5, atleta.getPosicao_id());
			stmt.setInt(6, atleta.getStatus_id());
			stmt.setDouble(7, atleta.getPreco_num());
			stmt.setDouble(8, atleta.getVariacao_num());

			stmt.execute();
			stmt.close();
			connection.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void alteraJogador(Atleta atleta) {
		try {
			String nome = trocaLetra(atleta.getNome());
			String alcunha = trocaLetra(atleta.getApelido());
			Connection connection = new util.ConnectionFactory()
					.getConnection();
			String sql = "UPDATE"
					+ " USU_t001jog	"
					+ "SET "
					+ " USU_NomJog = ?,USU_ApeJog = ?,USU_CodClu = ?,USU_CodPos= ?,"
					+ " USU_StaJog= ?,USU_PreJog= ?,USU_VarJog= ? "
					+ " WHERE USU_CodJog = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, alcunha);
			stmt.setInt(3, buscarClube(atleta.getClube_id()));
			stmt.setInt(4, atleta.getPosicao_id());
			stmt.setInt(5, atleta.getStatus_id());
			stmt.setDouble(6, atleta.getPreco_num());
			stmt.setDouble(7, atleta.getVariacao_num());
			stmt.setInt(8, atleta.getAtleta_id());

			stmt.execute();
			stmt.close();
			connection.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static int buscarClube(int codigo) {
		try {
			Connection con = new util.ConnectionFactory().getConnection();
			String sql = "SELECT USU_CodClu FROM USU_T001clu WHERE USU_CodCar = ? ";
			PreparedStatement stmtAux = con.prepareStatement(sql);
			stmtAux.setInt(1, codigo);
			ResultSet rs = stmtAux.executeQuery();
			rs.next();
			int codAux = rs.getInt("USU_CodClu");
			stmtAux.close();
			con.close();
			return codAux; 
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
