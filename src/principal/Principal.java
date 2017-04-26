package principal;
import java.io.BufferedReader;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entidades.Atleta;
import entidades.Pessoa;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GsonBuilder builder = new GsonBuilder();	
		Gson gson = builder.create();
		try {
			BufferedReader br = new BufferedReader(new FileReader("c:\\kassio\\teste.json"));
			Pessoa pessoa[] = gson.fromJson(br, Pessoa[].class);
			
			for (int i = 0; i < pessoa.length; i++) {
				System.out.println(pessoa[i].getNome());
			}
			
			BufferedReader br2 = new BufferedReader(new FileReader("c:\\kassio\\mercado2.json"));
			Atleta atleta[] = gson.fromJson(br2, Atleta[].class);
			
			for (int i = 0; i < atleta.length; i++) {
				System.out.println(atleta[i].getNome() + " - " + atleta[i].getApelido());
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
