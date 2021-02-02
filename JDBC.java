import java.sql.*;
import java.util.Scanner;

public class JDBC {

   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost/CPSC_408?serverTimezone=UTC";

   //  Database credentials
   static final String USER = "jdbcuser";
   static final String PASS = "jdbc";

   // begining of main

   public static void main(String[] args) {
   Connection conn1 = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn1 = DriverManager.getConnection(DB_URL,USER,PASS);




      System.out.println("Creating statement...");
      stmt = conn1.createStatement();

      Scanner myObj = new Scanner(System.in);
      String choice = "0";

      System.out.println("\nPlease press ENTER to start the program\n ");

      // begining of the while loop, entire program

      while (myObj.hasNextLine()){
        System.out.println("Please select from the following list");
        System.out.println("1) Insert record into a table");
        System.out.println("2) Delete record from a table");
        System.out.println("3) Update row in the Event table");
        System.out.println("4) Execute one of the predefined queries");
        System.out.println("5) Exit");

        choice = myObj.nextLine();

        // first option, insert

        if (choice.equals("1")){

          System.out.println("\nYou have chosen to insert a record into any table\n");

          // deciding what table to insert into
          Scanner myObj1 = new Scanner(System.in);
          System.out.println("Please select the table you would like to insert into");
          System.out.println("1) Fighter");
          System.out.println("2) Stadium");
          System.out.println("3) Event");
          System.out.println("4) Sales");
          System.out.println("5) StartTime");
          System.out.println("6) Commercial");
          System.out.println("7) Station");

          String table = myObj1.nextLine();

          // Figther table

          if (table.equals("1")){
            // Getting the inputs
            System.out.println("Please answer the following questions");

            System.out.println("Please enter a first name");
            String FirstName = myObj1.nextLine();
            System.out.println("Please enter a last name");
            String LastName = myObj1.nextLine();
            System.out.println("Please enter opponent name");
            String Opponent = myObj1.nextLine();
            System.out.println("Please enter their stance");
            String Stance = myObj1.nextLine();
            System.out.println("Please enter their id (above 20,000)");
            String id = myObj1.nextLine();

            int id_int = 0;
            // parsing the string to an int
            try{
              id_int = Integer.parseInt(id);
            }catch(NumberFormatException ex){
               System.out.println("That number is not valid, cant convert to int");
               System.out.println("Try Again");
               continue;
            }
            if (id_int < 20000){
              System.out.println("Please enter a number that is above 20,000");
              System.out.println("Please enter their id (above 20,000)");
              id = myObj1.nextLine();
            }
            System.out.println("Please enter their salary");
            String Salary = myObj1.nextLine();
            System.out.println("Please enter their location");
            String Location = myObj1.nextLine();

            String sqlFighter;
            sqlFighter = "insert into Fighter values('"+FirstName+"','"+LastName+"','"+Opponent+"','"+Stance+"',"+id+","+Salary+",'"+Location+"')";

            System.out.println(sqlFighter);

            // getting it to execute the query
            int i = stmt.executeUpdate(sqlFighter);
            System.out.println("Rows inserted: "+i);

            System.out.println("Sucessfully added " + FirstName + " " + LastName + " into the Fighter table\n");

            System.out.println("\nPlease press ENTER to continue\n");
            continue;

          }

          // option two, the Stadium table
          if (table.equals("2")){

            System.out.println("Please answer the following questions");
            System.out.println("Please enter the stadium capacity (int)");
            String Capacity = myObj1.nextLine();
            System.out.println("Please enter the city");
            String City = myObj1.nextLine();
            System.out.println("Please enter the state");
            String State = myObj1.nextLine();
            System.out.println("Please enter the stadium name");
            String StadiumName = myObj1.nextLine();

            String sqlStadium;
            sqlStadium = "insert into Stadium values("+Capacity+",'"+City+"','"+State+"','"+StadiumName+"')";

            System.out.println(sqlStadium);

            // exceting the query

            int i = stmt.executeUpdate(sqlStadium);
            System.out.println("Rows inserted: "+i);

            System.out.println("Sucessfully added " + StadiumName + " into the Stadium table\n");

            System.out.println("\nPlease press ENTER to continue\n");
            continue;

          }

          // option three, the Event table
          if (table.equals("3")){

            System.out.println("Please answer the following questions");
            System.out.println("Please enter the event id (int) > 1,000,000");
            String EventID = myObj1.nextLine();

            int id_int = 0;
            try{
              id_int = Integer.parseInt(EventID);
            }catch(NumberFormatException ex){
               System.out.println("That number is not valid, cant convert to int");
               System.out.println("Try Again");
               continue;
            }

            // checking to make sure it can be added
            if (id_int < 1000000){
              System.out.println("Please enter a number that is above 1,000,000");
              System.out.println("Please enter their id (above 1,000,000)");
              EventID = myObj1.nextLine();
            }

            System.out.println("Please enter the event name");
            String EventName = myObj1.nextLine();
            System.out.println("Please enter the number of fights");
            String NumEvent = myObj1.nextLine();

            String sqlEvent;
            sqlEvent = "insert into Event values("+EventID+",'"+EventName+"',"+NumEvent+")";

            System.out.println(sqlEvent);

            int i = stmt.executeUpdate(sqlEvent);
            System.out.println("Rows inserted: "+i);

            System.out.println("Sucessfully added " + EventName + " into the Event table\n");


            System.out.println("\nPlease press ENTER to continue\n");
            continue;
          }

          // // option four, the Sales table
          if (table.equals("4")){

            System.out.println("Please answer the following questions");

            System.out.println("Please enter the sale ID > 50,000");
            String SaleID = myObj1.nextLine();

            int id_int = 0;

            try{
              id_int = Integer.parseInt(SaleID);
            }catch(NumberFormatException ex){
               System.out.println("That number is not valid, cant convert to int");
               System.out.println("Try Again");
               continue;
            }

            if (id_int < 50000){
              System.out.println("Please enter a number that is above 50,000");
              System.out.println("Please enter their id (above 50,000)");
              SaleID = myObj1.nextLine();
            }

            // getting the inputs

            System.out.println("Please enter the quantity of tickets sold (int)");
            String QuantSold = myObj1.nextLine();
            System.out.println("Please enter the average ticket price");
            String AvgTicketPrice = myObj1.nextLine();
            System.out.println("Please enter the total expenses");
            String TotalCost = myObj1.nextLine();
            System.out.println("Please enter the revenue");
            String Revenue = myObj1.nextLine();
            System.out.println("Please enter the EventID below 50,000");
            String EventID = myObj1.nextLine();

            int id_int2 =0;

            try{
              id_int2 = Integer.parseInt(EventID);
            }catch(NumberFormatException ex){
               System.out.println("That number is not valid, cant convert to int");
               System.out.println("Try Again");
               continue;
            }
            if (id_int2 > 50000){
              System.out.println("\nPlease enter a number that is below 50,000");
              System.out.println("Please enter their id (below 50,000)\n");
              EventID = myObj1.nextLine();
            }

            String sqlSales;
            sqlSales ="insert into Sales values("+SaleID+","+QuantSold+","+AvgTicketPrice+","+TotalCost+","+Revenue+","+EventID+")";


            System.out.println(sqlSales);

            int i = stmt.executeUpdate(sqlSales);
            System.out.println("Rows inserted: "+i);

            System.out.println("Sucessfully added into the Sales table\n");


            System.out.println("\nPlease press ENTER to continue\n");
            continue;
          }
          // // option five, the StartTime table
          if (table.equals("5")){

            System.out.println("Please answer the following questions");

            System.out.println("Please enter the start time id > 110,000");
            String start_time_id = myObj1.nextLine();

            int id_int = 0;

            try{
              id_int = Integer.parseInt(start_time_id);
            }catch(NumberFormatException ex){
               System.out.println("That number is not valid, cant convert to int");
               System.out.println("Try Again");
               continue;
            }
            if (id_int < 110000){
              System.out.println("Please enter a number that is above 110,000");
              System.out.println("Please enter their id (above 110,000)");
              start_time_id = myObj1.nextLine();
            }

            System.out.println("Please enter the start time (int)");
            String start_time = myObj1.nextLine();
            System.out.println("Please enter the time per match (int)");
            String time_per_match = myObj1.nextLine();
            System.out.println("Please enter the end time (int)");
            String end_time = myObj1.nextLine();

            String sqlStartTime;
            sqlStartTime = "insert into StartTime values("+start_time_id+","+start_time+","+time_per_match+","+end_time+")";

            System.out.println(sqlStartTime);

            int i = stmt.executeUpdate(sqlStartTime);
            System.out.println("Rows inserted: "+i);

            System.out.println("Sucessfully added into the StartTime table\n");

            System.out.println("\nPlease press ENTER to continue\n");
            continue;
          }

          // option six, the Commerical table
          if (table.equals("6")){

            System.out.println("Please answer the following questions");

            System.out.println("Please enter the ad company name");
            String AdComp = myObj1.nextLine();
            System.out.println("How many ads will they run");
            String NumAds = myObj1.nextLine();
            System.out.println("How much did they pay");
            String AmtPaid = myObj1.nextLine();
            System.out.println("What is their air time (int)");
            String AirTime = myObj1.nextLine();
            System.out.println("What is their Transaction ID > 90000");
            String TransactionID = myObj1.nextLine();

            int id_int = 0;

            try{
              id_int = Integer.parseInt(TransactionID);
            }catch(NumberFormatException ex){
               System.out.println("That number is not valid, cant convert to int");
               System.out.println("Try Again");
               continue;
            }
            if (id_int < 90000){
              System.out.println("Please enter a number that is above 90,000");
              System.out.println("Please enter their id (above 90,000)");
              TransactionID = myObj1.nextLine();
            }

            System.out.println("What is their Event ID below 90000 because this is a foreign key");
            String EventID = myObj1.nextLine();
            int id_int1 = 0;

            try{
              id_int1 = Integer.parseInt(EventID);
            }catch(NumberFormatException ex){
               System.out.println("That number is not valid, cant convert to int");
               System.out.println("Try Again");
               continue;
            }
            if (id_int1 > 90000){
              System.out.println("Please enter a number that is below 90,000");
              System.out.println("Please enter their id (below 90,000)");
              EventID = myObj1.nextLine();
            }

            System.out.println("Who did they pay (string)");
            String PaidTo = myObj1.nextLine();

            String sqlCommercial;
            sqlCommercial = "insert into Commercial values('"+AdComp+"',"+NumAds+","+AmtPaid+","+AirTime+","+TransactionID+","+EventID+",'"+PaidTo+"')";
            // PreparedStatement preparedStatement = conn1.prepareStatement(sql);
            // int executeThat = preparedStatement.executeUpdate();

            System.out.println(sqlCommercial);

            int i = stmt.executeUpdate(sqlCommercial);
            System.out.println("Rows inserted: "+i);
            System.out.println("Sucessfully added " + AdComp + " into the Commercial table\n");

            System.out.println("\nPlease press ENTER to continue\n");
            continue;
          }

          // option seven, the Station table
          if (table.equals("7")){

            System.out.println("Please answer the following questions");
            System.out.println("Please enter the station name");
            String StationName = myObj1.nextLine();
            System.out.println("Please Station ID > 10,000");
            String StationID = myObj1.nextLine();
            int id_int = 0;
            try{
              id_int = Integer.parseInt(StationID);
            }catch(NumberFormatException ex){
               System.out.println("That number is not valid, cant convert to int");
               System.out.println("Try Again");
               continue;
            }
            if (id_int < 10000){
              System.out.println("Please enter a number that is above 10,000");
              System.out.println("Please enter their id (above 10,000)");
              StationID = myObj1.nextLine();
            }

            String sqlStation;
            sqlStation = "insert into Station values('"+StationName+"',"+StationID+")";

            System.out.println(sqlStation);

            int i = stmt.executeUpdate(sqlStation);
            System.out.println("Rows inserted: "+i);

            System.out.println("Sucessfully added " + StationName + " into the Station table\n");


            System.out.println("\nPlease press ENTER to continue\n");
            continue;
          }
          myObj1.close();
        }

        // the second option, deleting the recods
        if (choice.equals("2")){
          System.out.println("\nYou have chosen a delete a record from any table\n");

          // deciding what table to delete out of
          Scanner myObj2 = new Scanner(System.in);
          System.out.println("Please select the table you would like to delete from");
          System.out.println("1) Fighter");
          System.out.println("2) Stadium");
          System.out.println("3) Event");
          System.out.println("4) Sales");
          System.out.println("5) StartTime");
          System.out.println("6) Commercial");
          System.out.println("7) Station");

          String deleteTable = myObj2.nextLine();

          // The Fighter table

          if (deleteTable.equals("1")){
            System.out.println("You are deleting out of the Fighter Table \n");

            System.out.println("The primary key is Fighter ID");

            System.out.println("Please enter the Fighter ID you would like to delete");
            String FightDelete5 = myObj2.nextLine();
            String sql3 = "delete from Fighter where FighterID = "+FightDelete5+"";

            PreparedStatement preparedStatement = conn1.prepareStatement(sql3);
            System.out.println("Executing Delete Update");
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows Deleted: " + rowsAffected);

            System.out.println("\nPlease press ENTER to continue\n");
            continue;

          // // The Stadium table

          }if (deleteTable.equals("2")){
            System.out.println("You are deleting out of the Stadium Table \n");
            System.out.println("The primary key is Stadium Name");


            System.out.println("Please enter the stadium name you would like to delete");
            String StadiumDelete4 = myObj2.nextLine();
            String sql3 = "delete from Stadium where StadiumName like '"+StadiumDelete4+"'";

            PreparedStatement preparedStatement = conn1.prepareStatement(sql3);
            System.out.println("Executing Delete Update");
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows Deleted: " + rowsAffected);

            System.out.println("\nPlease press ENTER to continue\n");
            continue;
          }

          // The Event table
          if (deleteTable.equals("3")){
            System.out.println("You are deleting out of the Event Table \n");
            System.out.println("The primary key is Event ID");

            System.out.println("Please enter the event id you would like to delete");
            String EventDelete1 = myObj2.nextLine();
            String sql3 = "delete from Event where EventID = "+EventDelete1+"";

            PreparedStatement preparedStatement = conn1.prepareStatement(sql3);
            System.out.println("Executing Delete Update");
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows Deleted: " + rowsAffected);

            System.out.println("\nPlease press ENTER to continue\n");
            continue;

          }

          // The Sales table
          if (deleteTable.equals("4")){

            System.out.println("You are deleting out of the Sales Table \n");
            System.out.println("The primary key is SaleID");

            System.out.println("Please enter the Sale ID you would like to delete");
            String SalesDelete1 = myObj2.nextLine();
            String sql3 = "delete from Sales where QuantSold = "+SalesDelete1+"";

            PreparedStatement preparedStatement = conn1.prepareStatement(sql3);
            System.out.println("Executing Delete Update");
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows Deleted: " + rowsAffected);


            System.out.println("\nPlease press ENTER to continue\n");
            continue;

          }
          // The StartTime table
          if (deleteTable.equals("5")){

            System.out.println("You are deleting out of the StartTime Table \n");
            System.out.println("The primary key is StartTimeId");

            System.out.println("Please enter the start time id you would like to delete");
            String StartTimeDelete1 = myObj2.nextLine();
            String sql3 = "delete from StartTime where StartTimeId = "+StartTimeDelete1+"";

            PreparedStatement preparedStatement = conn1.prepareStatement(sql3);
            System.out.println("Executing Delete Update");
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows Deleted: " + rowsAffected);


            System.out.println("\nPlease press ENTER to continue\n");
            continue;

          }
          // The Commercial table
          if (deleteTable.equals("6")){

            System.out.println("You are deleting out of the Commercial Table \n");
            System.out.println("The primary key is TransactionID");

            System.out.println("Please enter the Transaction ID you would like to delete");
            String CommercialDelete1 = myObj2.nextLine();
            String sql3 = "delete from Commercial where TransactionID = "+CommercialDelete1+"";

            PreparedStatement preparedStatement = conn1.prepareStatement(sql3);
            System.out.println("Executing Delete Update");
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows Deleted: " + rowsAffected);


            System.out.println("\nPlease press ENTER to continue\n");
            continue;

          }

          // The Stadium table
          if (deleteTable.equals("7")){
            System.out.println("You are deleting out of the Station Table \n");

            System.out.println("The primary key is Station ID");

            System.out.println("Please enter the Station ID you would like to delete");
            String StationDelete1 = myObj2.nextLine();
            String sql3 = "delete from Station where StationID = "+StationDelete1+"";
            PreparedStatement preparedStatement = conn1.prepareStatement(sql3);
            System.out.println("Executing Delete Update");
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows Deleted: " + rowsAffected);


            System.out.println("\nPlease press ENTER to continue\n");
            continue;

          }
          myObj2.close();
        }

        // Updating tables

        if (choice.equals("3")){
          System.out.println("\nYou have chosen to update a row in the Event Table\n");

          Scanner myObj3 = new Scanner(System.in);

          System.out.println("Which variable would you like to update?");
          System.out.println("1) EventName");
          System.out.println("2) NumEvent");

          String updateChoice = myObj3.nextLine();

          // Updating the Event table, cant update the primary key
          // Updating Event Name

          if (updateChoice.equals("1")){
            System.out.println("We will be updating EventName where number of events = 9");
            System.out.println("What would you like to set the event name to?");
            String newEventName = myObj3.nextLine();

            String sqlUpdate = "update Event set EventName = '"+newEventName+"' where NumEvent = 9";
            PreparedStatement preparedStatement = conn1.prepareStatement(sqlUpdate);
            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("Executing update");

            System.out.println("Rows Updated: " + rowsAffected);


            System.out.println("\nPlease press ENTER to continue\n");
            continue;

          }

          // Updating Number of Event
          if (updateChoice.equals("2")){
            System.out.println("We will be updating Number of Events where number of events = 9");
            System.out.println("What would you like to set the event ID to?");
            String newNumEvent = myObj3.nextLine();

            String sqlUpdate = "update Event set NumEvent = "+newNumEvent+" where NumEvent = 9";
            PreparedStatement preparedStatement = conn1.prepareStatement(sqlUpdate);
            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("Executing update");

            System.out.println("Rows Updated: " + rowsAffected);


            System.out.println("\nPlease press ENTER to continue\n");
            continue;
          }
          myObj3.close();
        }

        // Querying

        if (choice.equals("4")){

          Scanner myObj4 = new Scanner(System.in);

          System.out.println("\nYou have chosen to run a query\n");
          System.out.println("Please choose one of the queries from the list");
          System.out.println("1) get revenue given the event id (join)");
          System.out.println("2) get the event names given the quantity of tickets sold (join)");
          System.out.println("3) get the total cost given the event id (join)");
          System.out.println("4) get the list of Event Names where an a certain HBO is the host (join)");
          System.out.println("5) get the average amount paid when the event id < x (join, aggregate)");
          System.out.println("6) get the average capacity in the stadium table (aggregate)");
          System.out.println("7) get the minimum salary of a fighter (aggregate)");

          String queryChoice = myObj4.nextLine();

          System.out.println("Here is the query for option: " + queryChoice);

          // get revenue given the event id (join)
          if (queryChoice.equals("1")){
            String sql2 = "select Revenue from Sales natural join Event where EventID = 2";
            PreparedStatement preparedStatement = conn1.prepareStatement(sql2);
            System.out.println("Executing query");
            ResultSet result = preparedStatement.executeQuery();

            System.out.print("\nselect Revenue from Sales natural join Event where EventID = 2\n");


            while(result.next()) {
               System.out.print("Revenue: "+result.getString("Revenue")+" ");
               System.out.println();
            }


            System.out.println("\nPlease press ENTER to continue\n");
            continue;


          }

          // get the event names given the quantity of tickets sold (join)

          if (queryChoice.equals("2")){
            String sql2 = "select EventName from Event natural join Sales where QuantSold > 30000";
            PreparedStatement preparedStatement = conn1.prepareStatement(sql2);
            System.out.println("Executing query");
            ResultSet result = preparedStatement.executeQuery();

            System.out.print("\nselect EventName from Event natural join Sales where QuantSold > 30000\n");


            while(result.next()) {
               System.out.print("EventName: "+result.getString("EventName")+" ");
               System.out.println();
            }

            System.out.println("\nPlease press ENTER to continue\n");
            continue;


          }

          // get the total cost given the event id (join)

          if (queryChoice.equals("3")){
            String sql2 = "select TotalCost from Sales natural join Event where EventID > 5";
            PreparedStatement preparedStatement = conn1.prepareStatement(sql2);
            System.out.println("Executing query");
            ResultSet result = preparedStatement.executeQuery();

            System.out.print("\nselect TotalCost from Sales natural join Event where EventID > 5\n");


            while(result.next()) {
               System.out.print("TotalCost: "+result.getString("TotalCost")+" ");
               System.out.println();
            }

            System.out.println("\nPlease press ENTER to continue\n");
            continue;

          }

          // get the list of Event Names where an a certain HBO is the host (join)

          if (queryChoice.equals("4")){
            String sql2 = "select EventName from Event natural join Commercial where PaidTo like 'HBO'";
            PreparedStatement preparedStatement = conn1.prepareStatement(sql2);
            System.out.println("Executing query");
            ResultSet result = preparedStatement.executeQuery();

            System.out.print("\nselect EventName from Event natural join Commercial where PaidTo like 'HBO'\n");


            while(result.next()) {
               System.out.print("EventName: "+result.getString("EventName")+" ");
               System.out.println();
            }

            System.out.println("\nPlease press ENTER to continue\n");
            continue;

          }

          // get the average amount paid when the event id < x (join, aggregate)");


          if (queryChoice.equals("5")){
            String sql2 = "select AVG(AmtPaid) from Commercial natural join Event where EventID < 5";
            PreparedStatement preparedStatement = conn1.prepareStatement(sql2);
            System.out.println("Executing query");
            ResultSet result = preparedStatement.executeQuery();

            System.out.print("\nselect AVG(AmtPaid) from Commercial natural join Event where EventID < 5\n");


            while(result.next()) {
               System.out.print("AVG(AmtPaid): "+result.getString("AVG(AmtPaid)")+" ");
               System.out.println();
            }

            System.out.println("\nPlease press ENTER to continue\n");
            continue;

          }

          // get the average capacity in the stadium table (aggregate)

          if (queryChoice.equals("6")){
            String sql2 = "select avg(Capacity) from Stadium";
            PreparedStatement preparedStatement = conn1.prepareStatement(sql2);
            System.out.println("Executing query");
            ResultSet result = preparedStatement.executeQuery();

            System.out.print("\nselect AVG(Capacity) from Stadium\n");

            while(result.next()) {
               System.out.print("AVG(Capacity): "+result.getString("AVG(Capacity)")+" ");
               System.out.println();
            }
            System.out.println("\nPlease press ENTER to continue\n");
            continue;
          }

          // get the minimum salary of a fighter (aggregate)

          if (queryChoice.equals("7")){
            String sql2 = "select MIN(Salary) from Fighter";
            PreparedStatement preparedStatement = conn1.prepareStatement(sql2);
            System.out.println("Executing query");
            ResultSet result = preparedStatement.executeQuery();

            System.out.print("\nselect MIN(Salary) from Fighter\n");

            while(result.next()) {
               System.out.print("MIN(Salary): "+result.getString("MIN(Salary)")+" ");
               System.out.println();
            }
            System.out.println("\nPlease press ENTER to continue\n");
            continue;
          }
          myObj4.close();
        }

        // Exiting the Program
        if (choice.equals("5")){
          System.out.println("\nThank you!!");
          break;
        }
      }

      // rs.close();
      stmt.close();
      conn1.close();
   }catch(SQLException se){
     System.out.println("error 1");
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
     System.out.println("error 2");

      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
        System.out.println("error 3");

      }// nothing we can do
      try{
         if(conn1!=null)
            conn1.close();
      }catch(SQLException se){
        System.out.println("error 4");

         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("\nGoodbye!");

}
//end main
}
