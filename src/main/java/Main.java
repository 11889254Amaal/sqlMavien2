import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class Main {
	static void choicesFunction1() {

		System.out.println("***************************");
		System.out.println("Welcome...Please Select one of the following options:");
		System.out.println("1. connect to database");
		System.out.println("2. Read from API");
		System.out.println("3. Get Api ");
		System.out.println("4. Create Table");
		System.out.println("5. Insert to Table");
		System.out.println("6. Read from Table");
		System.out.println("7. update from Table (domains based in id)");
		System.out.println("8. delete from Table web based in id");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		choicesFunction1();

		do {
			/// hibkjbjkjguj
			int userInput = sc.nextInt();
			switch (userInput) {
			case 1:
				// this class to connect eclipes with my database
				System.out.println("==========Connect to database===================");
				ConnectToDatabase connectToDatabse1 = new ConnectToDatabase();
				connectToDatabse1.conToDataBase();
				System.out.println("================================================");
				choicesFunction1();
				//
				break;

			case 2:
				System.out.println("==========Read From APi===================");

				URL url = new URL(" https://restcountries.com/v3.1/all");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.connect();
				StringBuilder informationString = new StringBuilder();
				int responseCode = conn.getResponseCode();
				if (responseCode != 200) {
					throw new RuntimeException("HttpresponseCode");

				}

				else {
					Scanner scanner = new Scanner(url.openStream());
					while (scanner.hasNext()) {
						informationString.append(scanner.nextLine());
					}
					scanner.close();

					System.out.println(informationString.toString());

				}
				System.out.println("===========================================");
				choicesFunction1();

				break;

			case 3:
				System.out.println("==========Get api from URL===================");
				URL url1 = new URL("https://restcountries.com/v3.1/all");
				HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
				conn1.setRequestMethod("GET");
				conn1.connect();
				StringBuilder informationString1 = new StringBuilder();
				int responseCode1 = conn1.getResponseCode();
				if (responseCode1 != 200) {
					throw new RuntimeException("HttpresponseCode");

				}

				else {
					Scanner scanner = new Scanner(url1.openStream());
					while (scanner.hasNext()) {
						informationString1.append(scanner.nextLine());
					}
					scanner.close();
					Gson gson = new Gson();
					// System.out.println(informationString1.toString());
					Root[] apiResult = gson.fromJson(informationString1.toString(), Root[].class);
					for (Root r : apiResult) {
					
						System.out.println("Commen : " + r.name.getcommon());
						System.out.println("official : " + r.name.getofficial());
						
						if(r.name.nativeName.eng != null) {
						System.out.println("Commen : " + r.name.nativeName.eng.getcommon());
						System.out.println("official : " + r.name.nativeName.eng.getofficial());
						}
						else if(r.name.nativeName.fra !=null) {
							System.out.println("Commen : " + r.name.nativeName.fra.getcommon());
						System.out.println("official : " + r.name.nativeName.fra.getofficial());
						}
						System.out.println("Tld : " + r.getTld());
					}
				}
			

			System.out.println("===========================================");
			choicesFunction1();
			break;
			
			case 4:
				System.out.println("==========CRATE TABLE WEB===================");
				CreateTable CrateTableWeb = new CreateTable();
				CreateTable.CreateTableToDB();

				System.out.println("===========================================");
				choicesFunction1();
				break;
				
			case 5:	
				System.out.println("==========Insert to Table===================");
				URL url11 = new URL("https://restcountries.com/v3.1/all");
				HttpURLConnection conn11 = (HttpURLConnection) url11.openConnection();
				conn11.setRequestMethod("GET");
				conn11.connect();
				StringBuilder informationString11 = new StringBuilder();
				int responseCode11 = conn11.getResponseCode();
				if (responseCode11 != 200) {
					throw new RuntimeException("HttpresponseCode");

				}

				else {
					Scanner scanner = new Scanner(url11.openStream());
					while (scanner.hasNext()) {
						informationString11.append(scanner.nextLine());
					}
					scanner.close();
					Gson gson = new Gson();
					
					// System.out.println(informationString1.toString());
					Root[] apiResult = gson.fromJson(informationString11.toString(), Root[].class);
					
					for (Root x : apiResult) {
									
					String name_comman = x.name.getcommon();
						String name_official = x.name.getofficial();
						List<String> tld = x.getTld();
						String Cca2 = x.getCca2();
						String Ccn3 = x.getCcn3();
						String Cca3 = x.getCca3();

						Class.forName("com.mysql.cj.jdbc.Driver");
						String url111 = "jdbc:mysql://localhost:3306/MaveinDBMS2";
						String username = "root";
						String password = "root";

						Connection con1 = DriverManager.getConnection(url111, username, password);
						int id = 1;

						if (con1 != null) {
							String SQLqueryForInserting = "insert into Root(name_common,name_official, tld,cca2, ccn3,cca3)"
									+ " values('" + name_comman + "' ,'" + name_official + "', '" + tld
									+ "','" + Cca2 + "' ,' " + Ccn3 + "','" + Cca3 + "')";
							Statement st = con1.createStatement();
							//
							// Executing query
							int m = st.executeUpdate(SQLqueryForInserting);
							if (m >= 1) {
								System.out.println("inserted successfully : " + SQLqueryForInserting);

							} else {
								System.out.println("insertion failed");

								// Closing the connections
							}

						}
						}
					
				}

				choicesFunction1();
				
				
				break;
			case 6:
				System.out.println("==========Read From Table===================");
				String sqlDB = " SELECT * FROM Root ";

				Class.forName("com.mysql.jdbc.Driver");
				String url111 = "jdbc:mysql://localhost:3306/maveindbms2";
				String username = "root";
				String password = "root";
				try {

					Connection conn111 = DriverManager.getConnection(url111, username, password);
					Statement st = conn111.createStatement();
					ResultSet m = st.executeQuery(sqlDB);
					if (m.next()) {
						do {
							System.out.println("id : " + m.getInt(1));
							System.out.println("name_common :" + m.getString(2));
							System.out.println("name_official :" + m.getString(3));
							System.out.println("tld :" + m.getString(4));
							System.out.println("cca2 :" + m.getString(5));

							System.out.println("ccn3 :" + m.getString(6));

							System.out.println("cca3 :" + m.getString(7));

							System.out.println("*********************************");
						} while (m.next());
					} else {
						System.out.println("No such user id is already registered");
					}
					conn111.close();
				} catch (Exception ex) {
					System.err.println(ex);
				}
				choicesFunction1();
				break;
				
			case 7:
				System.out.println("==========Update From Table Web===================");
				System.out.println("plz enter id that want to update");
				Scanner sc1 = new Scanner(System.in); // System.in is a standard input stream
				int id = sc1.nextInt();
				System.out.println("plz enter new  name");
				String name_common = sc1.next();
				String sqlDB1 = " update Root set name_common = ? where id =  " + id;

				Class.forName("com.mysql.jdbc.Driver");
				String url1111 = "jdbc:mysql://localhost:3306/maveindbms2";
				String username1 = "root";
				String password1 = "root";
				try (
						// gets connection with database
						Connection connection = DriverManager.getConnection(url1111, username1, password1);

						// sends queries and receives results
						PreparedStatement statement = connection.prepareStatement(sqlDB1);) {
					// this way to prevent sql injection
					statement.setString(id, name_common);

					int count = statement.executeUpdate();

					System.out.print(" updated rows is " + id + ".");
				} catch (SQLException e) {
					// some logic depending on scenario
					// maybe LOGGER.log(e.getMessage()) and "result false"
					e.printStackTrace();
				}
				choicesFunction1();
				break;
			}
		} while (true);
	}
}
