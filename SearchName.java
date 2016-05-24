import java.text.Normalizer;
import java.util.Scanner;

public class SearchName {
	
	private static Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String[] vet = { "Abrão", "Abraão", "Aci", "Acira", "Ada", "Adail", "Adalberto", "Adália",
				"Adalgisa", "Adalton", "Adamir", "Adamo", "Adão", "Adauto", "Adelaide", "Adélia", "Adelina", "Aline",
				"Ademar", "Ademir", "Adina", "Adir", "Adira", "Ado", "Adolfo", "Adonias", "Adoniran", "Adônis", "Adriana",
				"Adriane", "Adriano", "Aécio", "Afonso", "Agar", "Ágata", "Agenor", "Agildo", "Agnaldo", "Agnelo",
				"Aguinaldo", "Aída", "Aimoré", "Airumã", "Akira", "Alan", "Alba", "Alberico", "Albertina", "Alberto",
				"Albino", "Alceu", "Alcina", "Alcione", "Alcindo", "Alcione", "Alda", "Aldir", "Aldo", "Aleixo",
				"Alejandra", "Alexandre", "Alfeu", "Alfredo", "Alice", "Alícia", "Alina", "Aline", "Alípio", "Alma",
				"Almeida", "Almir", "Almira", "Aloísio", "Altino", "Álvaro", "Alzira", "Amadeu", "Amador", "Amália",
				"Amanda", "Amândio", "Amauri", "Aarão", "Arão", "Abaçaí", "Abacílio", "Abel", "Abelardo", "Abella",
				"Abigail", "Abílio", "Abner", "Ambrósio", "Amélia", "América", "Américo", "Amílcar", "Amin", "Amir", "Ana",
				"Anacleto", "Ananias", "Anastácia", "Balduíno", "Baltazar", "Bárbara", "Barnabé", "Bartolomeu", "Baruque",
				"Basílio", "Batista", "Beatriz", "Benjamim", "Caio", "Calena", "Candido", "Carina", "Carla", "Carlos",
				"Carmen", "Carol", "Carolina", "Cassiana", "Cassiano", "Cassilda", "Cássio", "Catarina", "Cedar", "Célia",
				"Celina", "Celso", "Cátia", "Cecília", "Cesar", "Cibele", "Cícero", "Cíntia", "Cirilo", "Ciro", "Clara",
				"Clarissa", "Cláudio", "Cleber", "Clécio", "Clemente", "Cleusa", "Clodoaldo", "Clodomiro", "Clodovil",
				"Colombo", "Conceição", "Conrado", "Crispim", "Cristiano", "Cristina", "Cristóvão", "Custódio", "Dácio",
				"Dafne", "Dagoberto", "Dalila", "Dalton", "Damião", "Daniel", "Daniela", "Eduardo", "Emanuel", "Eliana",
				"Enzo", "Erick", "Emilly", "Evelyn", "Fernanda", "Filipa", "Franklin", "Fausto", "Gabrieli", "Giuliana",
				"Guilherme", "Gustavo", "Helena", "Heloísa", "Henrique", "Henry", "Ian", "Isabela", "Isadora", "Iasmin",
				"Joaquim", "Juliano", "Joice", "Júlia", "Kevin", "Kelly", "Kaique", "Laura", "Luiza", "Lauro", "Lorenzo",
				"Milena", "Melissa", "Miguel", "Matheus", "Nicolas", "Noah", "Natha", "Odete", "Ofélia", "Oliveira",
				"Otília", "Pietra", "Pérola", "Pietro", "Pierre", "Quezia", "Queiroz", "Raissa", "Rayane", "Ryan", "Rafael",
				"Renato", "Samara", "Samuel", "Sandro", "Thiago", "Téo", "Tales", "Talita", "Tainá", "Úrsula", "Úlima",
				"Uriel", "Ugo", "Vinícius", "Vitor", "Valentina", "Verônica", "William", "Wesley", "Wilma", "Walesca",
				"Ximenes", "Xande", "Yago", "Yuri", "Yara", "Yanni", "Zilda", "Zara", "Zaqueu", "Zeca", };
		
		vet = OrderVet(vet);
		
		int start = 0;
		int end = vet.length;
		System.out.print("Escreva um nome para procurar: ");
		String x = kb.next();
		
		try {
			int Answer = searchBinary(vet, start, end, x);
			
			System.out.print("Nome achado: " +  vet[Answer] + ". na Posicão " + Answer);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Nome não encontrado!");
		}
	}
	
	public static String [] OrderVet(String [] vetAUX){
		
		for(int fix = 0; fix < vetAUX.length - 1; fix++){
			int smaller = fix;
			
			for (int i = smaller + 1; i < vetAUX.length; i++) {
				if(Normalizer.normalize(vetAUX[i], Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").compareToIgnoreCase(Normalizer.normalize(vetAUX[smaller], Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")) < 0){
					smaller = i;
				}
			}
			
			if(smaller != fix){
				String aux = vetAUX[fix];
				vetAUX[fix] = vetAUX[smaller];
				vetAUX[smaller] = aux;
			}
		}
		
		return vetAUX;
	}
	
	public static int searchBinary(String vetAUX[], int startAUX, int endAUX, String x){
		
		int midAUX = (startAUX + endAUX) / 2;
		
		for(int count = 0; count < vetAUX.length + 1; count++){
			
			midAUX = (startAUX + endAUX) / 2;
			
			String str = Normalizer.normalize(vetAUX[midAUX], Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			
			int compare = str.compareToIgnoreCase(x);
			
			if(compare < 0){
				startAUX = midAUX;
				midAUX = midAUX + 1;
			}else if(compare > 0){
				endAUX = midAUX;
				endAUX = midAUX - 1;
			}
		}
		
		String str = Normalizer.normalize(vetAUX[midAUX], Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		str = str.replaceAll("[^\\p{ASCII}]", "");
		
		int compare2 = str.compareToIgnoreCase(x);
		
		if(compare2 == 0){
			return midAUX;
		}else{
			return vetAUX.length + 100;
		}
	}
}
